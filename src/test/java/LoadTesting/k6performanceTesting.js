// $ brew install k6
// $ k6 --help
// $ k6 run -d 30s -u 30 src/test/java/LoadTesting/k6performanceTesting.js
// $ k6 run -u 0 -s 10s:200 -s 60s -s 10s:0 test/k6performanceTesting.js
// $ k6 run -u 0 -s 10s:1000 -s 60s -s 10s:0 test/k6performanceTesting.js

import http from 'k6/http';
import { check } from 'k6';
import { Rate } from 'k6/metrics';
export let errorRate = new Rate('errors');
export default function () {
  var url = 'https://www.wildberries.ru/catalog/0/search.aspx?search=%D1%85%D1%83%D0%B4%D0%B8&xParams=preset%3D1075&xShard=presets%2Ftop100_10&xFilters=dlvr%3Bbrand%3Bprice%3Bkind%3Bcolor%3Bwbsize%3Bseason%3Bconsists%3Bf10%3Bf1010&xsearch=true';
  var params = {
    headers: {
      Authorization: 'Token ffc62b27db68502eebc6e90b7c1476d29c581f4d',
      'Content-Type': 'application/json',
    },
  };
  check(http.get(url, params), {
    'status is 200': (r) => r.status == 200,
  }) || errorRate.add(1);
}