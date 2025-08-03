Feature: Create an Account

  Scenario: Successful Account Created with Valid Credentials
    Given User launches Chrome browser
    When User opens URL "https://magento.softwaretestingboard.com/"
    And User clicks on Create an Account link
    And User enters FirstName as "Test" and LastName as "Admin" and Email as "admin09@yourstore.com" and Password as "Admin@12344" and ConfirmPassword as "Admin@12344"
    And User clicks on Create an Account button
    Then Page Title should be "My Account"
    And User waits for 2 seconds
    Then User clicks on Sign out link
    Then User should see logout confirmation message
    And Close the browser
