Feature: I have to test the service call
  I have to get the service call using cucumber

  @restService
  Scenario: Perform a get call
    Given I hit the get country service

  @restService
  Scenario: Perform a get call with query paramater
    Given I git the get call with query param

  @restService
  Scenario: Perform a post call
    Given I perform the post call

  @restService
  Scenario: Perform scenario with parameter
    Given I perform simple call with paramater

  @nottoinclude
  Scenario: non tag
    Given I perform simple call with paramater