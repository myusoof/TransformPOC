Feature: I have to launch the application for responsive web

  @webapplication
  Scenario Outline: I have the launch using different browser size
    Given I have to launch test application with <browser> size
    Then I click on "Redirect Link" link with responsive
    Then I click on here link with responsive
    Examples:
      | browser |
      | Desktop |
      | Tablet  |
      | Mobile  |