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


  Scenario: I have to have form authenication
    Given I navigate to the test application
    Then I click on "Form Authentication" link
    And I validate the page Url "login"
    Then I enter the username and password

  Scenario: I have to play with frames
    Given I navigate to the test application
    Then I click on "Frames" link
    And I validate the page Url "frames"
    Then I click on "Nested Frames" link
    Then I switch to the frame "frame-top"
    Then I switch to the frame "frame-left"
    Then I assert the text is "LEFT"
    Then back to default frame
    Then I switch to the frame "frame-top"
    Then I switch to the frame "frame-middle"
    Then I assert the text is "MIDDLE"
    Then back to default frame
    Then I switch to the frame "frame-bottom"
    Then I assert the text is "BOTTOM"

  Scenario: I have to play with iframe
    Given I navigate to the test application
    Then I click on "Frames" link
    And I validate the page Url "frames"
    Then I click on "iFrame" link
    Then I switch to the frame "mce_0_ifr"
    Then get the content in the frame
    Then back to default frame
    Then set the content "<B> Following is the new content </B>" in the frameid "mce_0_ifr"

  Scenario: I have to play with slider
    Given I navigate to the test application
    Then I click on "Horizontal Slider" link
    And I validate the page Url "horizontal_slider"
    Then I perform the slider action

  Scenario: I have to play with hover
    Given I navigate to the test application
    Then I click on "Hovers" link
    And I validate the page Url "hovers"
    Then I hover over the pic
    And I validate the page Url "users/1"

  Scenario: I have to play with scroll infinite
    Given I navigate to the test application
    Then I click on "Infinite Scroll" link
    And I validate the page Url "infinite_scroll"
    Then I press the space to scroll down

  Scenario: I have to play with jquery menu
    Given I navigate to the test application
    Then I click on "JQuery UI Menus" link
    And I validate the page Url "jqueryui/menu"
    Then I work with jquery menu

  Scenario: I have to play with js alerts
    Given I navigate to the test application
    Then I click on "JavaScript Alerts" link
    And I validate the page Url "javascript_alerts"
    Then I click on button with text "Click for JS Alert"
    Then I would like to play with js alerts
    Then I verify the text in the page "You successfuly clicked an alert"
    Then I click on button with text "Click for JS Confirm"
    Then I would like to play with js confirmation accept
    Then I verify the text in the page "You clicked: Ok"
    Then I click on button with text "Click for JS Confirm"
    Then I would like to play with js confirmation dismiss
    Then I verify the text in the page "You clicked: Cancel"
    Then I click on button with text "Click for JS Prompt"
    Then I would like to play with js prompt accept
    Then I verify the text in the page "You entered: yusoof"

  Scenario: I have to play with key press
    Given I navigate to the test application
    Then I click on "Key Presses" link
    And I validate the page Url "key_presses"
    Then I work with key press

  Scenario: I have to play with multiple window
    Given I navigate to the test application
    Then I click on "Multiple Windows" link
    And I validate the page Url "windows"
    Then I work with multiple window

  Scenario: I have to play with Notification Messages
    Given I navigate to the test application
    Then I click on "Notification Messages" link
    And I validate the page Url "notification_message_rendered"
    Then I click on the link until succesful

  Scenario: I have to play with redirect link
    Given I navigate to the test application
    Then I click on "Redirect Link" link
    And I validate the page Url "redirector"
    Then I click on button with text "here"
    And I validate the page Url "status_codes"

  Scenario: I have to play with Shifting Content
    Given I navigate to the test application
    Then I click on "Shifting Content" link
    And I validate the page Url "shifting_content"
    Then I click on button with text "Example 1: Menu Element"
    And I play with shifting content

  Scenario: I have to play with Shifting Content1
    Given I navigate to the test application
    Then I click on "Shifting Content" link
    And I validate the page Url "shifting_content"
    Then I click on button with text "Example 2: An image"
    And I play with shifting for content