Feature: adding new address to user account

  Scenario Outline: user can add new address to their account

    Given user opens https://prod-kurs.coderslab.pl/index.php

    And user signs in

    When user opens addresses page

    And user fills in alias <Alias>

    And user fills in address <Address>

    And user fills in zip/postal code <ZipPostalCode>

    And user fills in city <City>

    And user fills in country <Country>

    And user fills in phone <Phone>

    And user saves new address

    Then user has added new address

    And user quits browsing

    Examples:

      | Alias | Company       | VAT number | Address                 | Address Complement | ZipPostalCode | City   | Country        | Phone   |
      | qwer  | Askawa sp. pl | 1234566    | Wwalekaowea Street 2/21 |                    | 11-233        | Oksaal | United Kingdom | 1234566 |

