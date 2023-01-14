Feature: HomePage - Test

  Scenario: Verify home page title
    Given application url
    When application launched
    Then verify title as "ToolsQA1"