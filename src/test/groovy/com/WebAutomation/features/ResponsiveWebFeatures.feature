Feature: I have to launch the application for responsive web


  Scenario Outline: I have the launch using different browser size
    Given I have to launch test application with <browser> size
    Then I click on "Redirect Link" link with responsive
    Examples:
      | browser |
      |Desktop |
      |Tablet|
      |Mobile|
