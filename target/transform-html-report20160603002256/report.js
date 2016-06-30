$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("TransformPoC.feature");
formatter.feature({
  "id": "i-have-to-test-the-service-call",
  "description": "I have to get the service call using cucumber",
  "name": "I have to test the service call",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "i-have-to-test-the-service-call;perform-a-get-call",
  "tags": [
    {
      "name": "@restService",
      "line": 4
    }
  ],
  "description": "",
  "name": "Perform a get call",
  "keyword": "Scenario",
  "line": 5,
  "type": "scenario"
});
formatter.step({
  "name": "I hit the get country service",
  "keyword": "Given ",
  "line": 6
});
formatter.match({
  "location": "RestClientSteps.groovy:21"
});
formatter.result({
  "duration": 7138775534,
  "status": "failed",
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[su]nt aut facere repell...\u003e but was:\u003c[]nt aut facere repell...\u003e\n\tat org.junit.Assert.assertEquals(Assert.java:115)\n\tat org.junit.Assert.assertEquals(Assert.java:144)\n\tat org.junit.Assert$assertEquals.call(Unknown Source)\n\tat RestClientSteps$_run_closure1.doCall(RestClientSteps.groovy:23)\n\tat ✽.Given I hit the get country service(TransformPoC.feature:6)\n"
});
formatter.scenario({
  "id": "i-have-to-test-the-service-call;perform-a-get-call-with-query-paramater",
  "tags": [
    {
      "name": "@restService",
      "line": 8
    }
  ],
  "description": "",
  "name": "Perform a get call with query paramater",
  "keyword": "Scenario",
  "line": 9,
  "type": "scenario"
});
formatter.step({
  "name": "I git the get call with query param",
  "keyword": "Given ",
  "line": 10
});
formatter.match({
  "location": "RestClientSteps.groovy:27"
});
formatter.result({
  "duration": 796374462,
  "status": "passed"
});
formatter.scenario({
  "id": "i-have-to-test-the-service-call;perform-a-post-call",
  "tags": [
    {
      "name": "@restService",
      "line": 12
    }
  ],
  "description": "",
  "name": "Perform a post call",
  "keyword": "Scenario",
  "line": 13,
  "type": "scenario"
});
formatter.step({
  "name": "I perform the post call",
  "keyword": "Given ",
  "line": 14
});
formatter.match({
  "location": "RestClientSteps.groovy:33"
});
formatter.result({
  "duration": 817684637,
  "status": "passed"
});
formatter.scenario({
  "id": "i-have-to-test-the-service-call;perform-scenario-with-parameter",
  "tags": [
    {
      "name": "@restService",
      "line": 16
    }
  ],
  "description": "",
  "name": "Perform scenario with parameter",
  "keyword": "Scenario",
  "line": 17,
  "type": "scenario"
});
formatter.step({
  "name": "I perform simple call with paramater",
  "keyword": "Given ",
  "line": 18
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
  "duration": 1761768,
  "status": "passed"
});
formatter.uri("TransformPoC_1.feature");
formatter.feature({
  "id": "second-feature-file",
  "description": "I have to get the service call using cucumber",
  "name": "Second Feature file",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "second-feature-file;perform-a-get-call",
  "tags": [
    {
      "name": "@restService",
      "line": 4
    }
  ],
  "description": "",
  "name": "Perform a get call",
  "keyword": "Scenario",
  "line": 5,
  "type": "scenario"
});
formatter.step({
  "name": "I hit the get country service",
  "keyword": "Given ",
  "line": 6
});
formatter.match({
  "location": "RestClientSteps.groovy:21"
});
formatter.result({
  "duration": 1726206878,
  "status": "failed",
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[su]nt aut facere repell...\u003e but was:\u003c[]nt aut facere repell...\u003e\n\tat org.junit.Assert.assertEquals(Assert.java:115)\n\tat org.junit.Assert.assertEquals(Assert.java:144)\n\tat org.junit.Assert$assertEquals.call(Unknown Source)\n\tat RestClientSteps$_run_closure1.doCall(RestClientSteps.groovy:23)\n\tat ✽.Given I hit the get country service(TransformPoC_1.feature:6)\n"
});
formatter.scenario({
  "id": "second-feature-file;perform-a-get-call-with-query-paramater",
  "tags": [
    {
      "name": "@restService",
      "line": 8
    }
  ],
  "description": "",
  "name": "Perform a get call with query paramater",
  "keyword": "Scenario",
  "line": 9,
  "type": "scenario"
});
formatter.step({
  "name": "I git the get call with query param",
  "keyword": "Given ",
  "line": 10
});
formatter.match({
  "location": "RestClientSteps.groovy:27"
});
formatter.result({
  "duration": 814790459,
  "status": "passed"
});
formatter.scenario({
  "id": "second-feature-file;perform-a-post-call",
  "tags": [
    {
      "name": "@restService",
      "line": 12
    }
  ],
  "description": "",
  "name": "Perform a post call",
  "keyword": "Scenario",
  "line": 13,
  "type": "scenario"
});
formatter.step({
  "name": "I perform the post call",
  "keyword": "Given ",
  "line": 14
});
formatter.match({
  "location": "RestClientSteps.groovy:33"
});
formatter.result({
  "duration": 582839086,
  "status": "passed"
});
});