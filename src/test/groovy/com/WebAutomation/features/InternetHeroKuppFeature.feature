Feature: I have to automate the complete internetherokupp application

  Scenario: I have to test the A/B testing
    Given I navigate to the test application
    Then I click on "A/B Testing" link
      And I validate the page Url "abtest"
      And I validate the content in the page
        |A/B Test Variation 1|

  Scenario: I have to test the basic auth
    Given I navigate to the test application
    Then I click on Basic Auth link
      And I validate the page Url "basic_auth"
      And I validate the content in the page
        |Basic Auth|

  Scenario: I have to validate the broken image
    Given I navigate to the test application
    Then I click on "Broken Images" link
      And I validate the page Url "broken_images"
      And I validate the images are loaded correctly
      And I validate the content in the page
        |Broken Images|

  Scenario: I have to test the checkbox feature
    Given I navigate to the test application
    Then I click on "Checkboxes" link
      And I validate the page Url "checkboxes"
    Then I get validate the status of the checkbox

  Scenario: I have to context menu
    Given I navigate to the test application
    Then I click on "Context Menu" link
    And I validate the page Url "context_menu"
    Then I validate the context menu

  Scenario: I have to play with disappearing element
    Given I navigate to the test application
    Then I click on "Disappearing Elements" link
    And I validate the page Url "disappearing_elements"
    Then I get all the menus which appears