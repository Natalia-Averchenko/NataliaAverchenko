Feature: I want to check correct selection of checkbox

  Scenario: I check log row on User Table page
    Given I open JDI GitHub site
    And I login as user 'ROMAN IOVLEV'
    And I click on 'SERVICE' button in Header
    And I click on 'USER TABLE' button in Service dropdown
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section