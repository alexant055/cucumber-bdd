Feature: ElementsPage - Test

  Scenario: Verify text box header
    Given application launched
    When "Elements" card clicked
    And "Text Box" menu clicked on Elements list
    Then verify header as "Text Box"