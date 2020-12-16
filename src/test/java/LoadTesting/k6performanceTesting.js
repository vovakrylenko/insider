// $ k6 --help
// $ k6 run -d 30s -u 30 src/test/java/LoadTesting/k6performanceTesting.js
// $ k6 run -u 0 -s 10s:200 -s 60s -s 10s:0 /k6performanceTesting.js
// $ k6 run -u 0 -s 10s:1000 -s 60s -s 10s:0 /k6performanceTesting.js

import http from 'k6/http';
import { check, group} from 'k6';
import { Rate } from 'k6/metrics';
const urlMaxItems = "https://www.wildberries.ru/catalog/0/search.aspx?search=%D1%85%D1%83%D0%B4%D0%B8&xParams=preset%3D1075&xShard=presets%2Ftop100_10&xFilters=dlvr%3Bbrand%3Bprice%3Bkind%3Bcolor%3Bwbsize%3Bseason%3Bconsists%3Bf10%3Bf1010&xsearch=true";
const urlMixItems = "https://www.wildberries.ru/catalog/0/search.aspx?search=%D1%85%D1%83%D0%B4%D0%B8&xparams=preset%253D1075&xshard=presets/top100_10&xfilters=dlvr;brand;price;kind;color;wbsize;season;consists;f10;f1010&xsearch=true&fbrand=86470";
export const errorRate = new Rate('errors');
export const options = {
  stages: [
    // Ramp from 1 to 5 users in 10s
    { duration: "10s", target: 5 },

    // Stay at rest on 5 users for 5s
    { duration: "5s", target: 5 },

    // Ramp-down from 5 to 0 users for 5s
    { duration: "5s", target: 0 }
  ],
  thresholds: {
    error_rate: ["rate<0.1"]
  }
};
export default function () {

    //case1: check search result with max available items on page
    group('searchMaxItems', function openMaxUrlItems() {
      const res = http.get(urlMaxItems);
      check(res, { "status is 200": (r) => r.status === 200 }) || errorRate.add(1);
    });

    //case2: check search result with min available items on page
    group('searchMinItems', function openMinUrlItems() {
      const res = http.get(urlMixItems);
      check.duration(res, { "status is 200": (r) => r.status === 200 }) || errorRate.add(1);
    });
}