Feature: Loan Status

@Sanity
  Scenario Outline: User checks loan status with valid ID
    Given baseurl
    When User vist  loan status page
    When User enters Loan ID "<loanID>"
    And User submits the loan status request
    Then User should see loan details if Loan ID is valid

    Examples:
      | loanID                          |
      | 67b058449aee7f0045a05a54 |

@Sanity
  Scenario Outline: User checks loan status with invalid ID
    Given baseurl
    When User vist  loan status page
    When User enters Loan ID "<loanID>"
    And User submits the loan status request
    Then User should see error message for invalid Loan ID

    Examples:
      | loanID                          |
      | 67b021bd9aee7f0045a05a4 |