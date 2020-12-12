// $ brew install k6
// $ k6 --help
// $ cd ./election-reporting-admin-import-services
// $ k6 run -d 30s -u 30 src/test/java/LoadTesting/k6performanceTesting.js
// $ k6 run -u 0 -s 10s:200 -s 60s -s 10s:0 test/k6performanceTesting.js
// $ k6 run -u 0 -s 10s:1000 -s 60s -s 10s:0 test/k6performanceTesting.js

import http from 'k6/http';
import { check } from 'k6';
import { Rate } from 'k6/metrics';
export let errorRate = new Rate('errors');
export default function () {
  var url = 'https://httpbin.org/';
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