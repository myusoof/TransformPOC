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
