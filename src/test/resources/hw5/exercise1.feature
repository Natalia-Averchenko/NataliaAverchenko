Feature: I want to log in, open Different Elements Page
  I want to check logBox after selecting checkboxes, radio and color

  Background: I open site and log in with relevant data
    Given I Open test site by URL 'https://jdi-testing.github.io/jdi-light/index.html'
    When I perform login with username 'Roman' and password 'Jdi1234'
    Then User is logged. Name is displayed and equals to expected result 'ROMAN IOVLEV'

  Scenario: I open Different Element Page
    When I click on 'SERVICE' in the header menu on main page
    And I click on 'DIFFERENT ELEMENTS' in drop-down list
    Then Page with url 'https://jdi-testing.github.io/jdi-light/different-elements.html' is opened

  Scenario: I check logBox on Different Element Page
    When I click on 'SERVICE' in the header menu on main page
    And I click on 'DIFFERENT ELEMENTS' in drop-down list
    And I click on 'Water','Wind' checkboxes
    And I click on 'Selen' radio
    And I select 'Yellow' from drop-down list
    Then Change log contains strings 'Colors: value changed to Yellow','metal: value changed to Selen', 'Wind: condition changed to true', 'Water: condition changed to true'
