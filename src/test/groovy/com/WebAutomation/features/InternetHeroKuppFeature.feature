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

  Scenario: I have to drag and drop the element
    Given I navigate to the test application
    Then I click on "Drag and Drop" link
    And I validate the page Url "drag_and_drop"
    Then I perform drag and drop operation

  Scenario: I have to play with select option
    Given I navigate to the test application
    Then I click on "Dropdown" link
    And I validate the page Url "dropdown"
    Then I have to select the option

  Scenario: I have to play with dynamic control
    Given I navigate to the test application
    Then I click on "Dynamic Controls" link
    And I validate the page Url "dynamic_controls"
    Then I have to play with dynamic controls
    Then I have to play with wait for element


  Scenario: I have to play with dynamic loading
    Given I navigate to the test application
    Then I click on "Dynamic Loading" link
    And I validate the page Url "dynamic_loading"
    Then I click on first link
    Then Click on start button in the first page
    Then I click on second link
    Then Click on start button in the second page

  Scenario: I have to play with exit intent
    Given I navigate to the test application
    Then I click on "Exit Intent" link
    And I validate the page Url "exit_intent"
    Then I get the position of exit intent element

  Scenario: I have to download the file for firefox
    Given I navigate to the test application
    Then I click on "File Download" link
    And I validate the page Url "download"
    Then I download the file


  Scenario: I have to upload the file for firefox
    Given I navigate to the test application
    Then I click on "File Upload" link
    And I validate the page Url "upload"
    Then I upload the file via text

  Scenario: I have to test the floating menu
    Given I navigate to the test application
    Then I click on "Floating Menu" link
    And I validate the page Url "floating_menu"
    Then I would test the floating menu

  Scenario: I have to test forgot password
    Given I navigate to the test application
    Then I click on "Forgot Password" link
    And I validate the page Url "forgot_password"
    Then I woud like to retrieve forgot password