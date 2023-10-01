Feature: Saucedemo Test



#  @smoke
  Scenario: Login should be Not Success
    And User Enter Wrong_USerName as "zEEQ1"
    And User Enter Wrong_Password as "Pass123"
    When User Click on login button
    Then Login Should be not Success
    But Login Should fail
# @smoke
  Scenario: Login should be Success
    And User Enter USerName as "standard_user"
    And User Enter Password as "secret_sauce"
    And User Click on login button
    And Login Should be Success
