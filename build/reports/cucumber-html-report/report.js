$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("TransformPoC.feature");
formatter.feature({
  "line": 1,
  "name": "I have to test the service call",
  "description": "I have to get the service call using cucumber",
  "id": "i-have-to-test-the-service-call",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Perform a get call",
  "description": "",
  "id": "i-have-to-test-the-service-call;perform-a-get-call",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I hit the get country service",
  "keyword": "Given "
});
formatter.match({
  "location": "RestClientSteps.groovy:21"
});
formatter.result({
  "duration": 5651440267,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Perform a get call with query paramater",
  "description": "",
  "id": "i-have-to-test-the-service-call;perform-a-get-call-with-query-paramater",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I git the get call with query param",
  "keyword": "Given "
});
formatter.match({
  "location": "RestClientSteps.groovy:28"
});
formatter.result({
  "duration": 8377111267,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Perform a post call",
  "description": "",
  "id": "i-have-to-test-the-service-call;perform-a-post-call",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "I perform the post call",
  "keyword": "Given "
});
formatter.match({
  "location": "RestClientSteps.groovy:33"
});
formatter.result({
  "duration": 3423236194,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Perform scenario with parameter",
  "description": "",
  "id": "i-have-to-test-the-service-call;perform-scenario-with-parameter",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I perform simple call with paramater",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "paramater",
      "offset": 27
    }
  ],
  "location": "RestClientSteps.groovy:43"
});
formatter.result({
  "duration": 2782477,
  "status": "passed"
});
formatter.uri("TransformPoC_1.feature");
formatter.feature({
  "line": 1,
  "name": "I have to test the service call",
  "description": "I have to get the service call using cucumber",
  "id": "i-have-to-test-the-service-call",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Perform a get call",
  "description": "",
  "id": "i-have-to-test-the-service-call;perform-a-get-call",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I hit the get country service",
  "keyword": "Given "
});
formatter.match({
  "location": "RestClientSteps.groovy:21"
});
formatter.result({
  "duration": 2555729289,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Perform a get call with query paramater",
  "description": "",
  "id": "i-have-to-test-the-service-call;perform-a-get-call-with-query-paramater",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I git the get call with query param",
  "keyword": "Given "
});
formatter.match({
  "location": "RestClientSteps.groovy:28"
});
formatter.result({
  "duration": 404446654,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Perform a post call",
  "description": "",
  "id": "i-have-to-test-the-service-call;perform-a-post-call",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "I perform the post call",
  "keyword": "Given "
});
formatter.match({
  "location": "RestClientSteps.groovy:33"
});
formatter.result({
  "duration": 415080967,
  "status": "passed"
});
});