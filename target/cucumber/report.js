$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("mobileAppium.feature");
formatter.feature({
  "id": "i-have-to-test-and-launch-appium-mobile-automation",
  "description": "",
  "name": "I have to test and launch appium mobile automation",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "i-have-to-test-and-launch-appium-mobile-automation;i-have-to-appium-server",
  "description": "",
  "name": "I have to appium server",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "I would like to start the appium server",
  "keyword": "Given ",
  "line": 4
});
formatter.match({
  "location": "MobileAutomationOne.groovy:33"
});
formatter.result({
  "duration": 222325476,
  "status": "passed"
});
});