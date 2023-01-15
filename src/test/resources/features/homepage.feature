Feature: HomePage - Test

  Scenario: Verify home page title
    Given application launched
    When page loaded
    Then verify title as "ToolsQA"

  Scenario: Navigate to elements page
    Given application launched
    When "Elements" card clicked
    Then verify header as "Elements"