Feature: Apply Loan

	@Sanity
  Scenario Outline: User applies for a loan with valid details
    Given baseurl
    When User vist apply loan page
    When User enters email "<email>"
    And User enters loan amount "<amount>"
    And User selects loan term "<term>"
    And User enters yearly income "<income>"
    And User enters age "<age>"
    And User submits the loan application
    Then User should see approval message if eligible

    Examples:
      | email          | amount | term | income | age |
      | sai@gmail.com  | 90000  | 3    | 30000  | 18  |

	@Sanity
  Scenario Outline: User applies for a loan with invalid details
    Given baseurl
     When User vist apply loan page
    When User enters email "<email>"
    And User enters loan amount "<amount>"
    And User selects loan term "<term>"
    And User enters yearly income "<income>"
    And User enters age "<age>"
    And User submits the loan application
    Then User should see rejection message if ineligible

    Examples:
      | email          | amount | term | income | age |
      | sai@gmail.com  | 200000 | 3    | 3990   | 17  |