@checkout
Feature: Checkout scenarios
  As a user, I want to make a checkout for various login credentials
  and for all filter options

  @smoke @regression
  Scenario Outline: Checkout journey
    Given User logged into the application using "<Username>" and "<Password>"
    When User selects the "<Filter>"
    * User adds the item to cart
    * User fills address to finish the checkout
      | FirstName | <FirstName> |
      | LastName  | <LastName>  |
      | Zipcode   | <Zipcode>   |
    Then User should see the success message confirming order is placed

    Examples: 
      | Username                | Password     | Filter              | FirstName | LastName | Zipcode |
      | standard_user           | secret_sauce | Name (A to Z)       | Satheesh  | kannan   |  626189 |
      | locked_out_user         | secret_sauce | Name (Z to A)       | kannan    | satheesh |  626130 |
      | problem_user            | secret_sauce | Price (low to high) | mukil     | thiru    |  626124 |
      | performance_glitch_user | secret_sauce | Price (high to low) | seetha    | lakshmi  |  626123 |

      
  @smoke @regression
  Scenario: Remove link in item page
    Given User logged into the application using "standard_user" and "secret_sauce"
    When User clicks an item from cart
    Then User should see the remove button at the item page