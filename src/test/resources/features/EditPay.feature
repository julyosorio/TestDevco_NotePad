@editpay
Feature: Edit payment from saved payments table
  I as user iris
  Want edit the payment information
  To save the pay updated and use it after

  @editpay1
  Scenario Outline: Edit payment successfully, deleting payments from the payments list
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" deletes the payments quantity requested from payments list
      | payId   | paymentQuantityDelete   |
      | <payId> | <paymentQuantityDelete> |
    Then "Iris-User" verifies that message pay record updated was showed

    Examples:
      | nit       | username  | password              | emailUser                 | payId             | paymentQuantityDelete |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoSupplierP10   | 7                     |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoProveedorD10  | 8                     |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | paySavedSupplier3 | 4                     |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoProveedorD11  | 10                    |

  @editpay2
  Scenario Outline: Edit payment successfully, modifying the origin product selected for the pay
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" modifies the origin account selected and saves changes
      | payId   | originAccountNumber   |
      | <payId> | <originAccountNumber> |
    Then "Iris-User" verifies that message pay record updated was showed
    Examples:
      | nit       | username    | password              | emailUser                 | payId          | originAccountNumber |
      | 900800005 | userautho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoNominaS2   | 9523                |
      | 900800005 | userautho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoSupplierP1 | 7007                |

  @editpay3
  Scenario Outline: Edit payment successfully, modifying the execute date selected for the pay
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" modifies the execute date selected and saves changes
      | payId   | executeDate   |
      | <payId> | <executeDate> |
    Then "Iris-User" verifies that message pay record updated was showed
    Examples:
      | nit       | username  | password              | emailUser                 | payId           | executeDate |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoProveedorS1 | 30/01/2023  |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoProveedorD2 | 25/02/2023  |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoNominahS2   | 30/01/2024  |


  @editpay4
  Scenario Outline: Edit payment successfully, adding new payments to the payments list
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" addes payments to the pay list and saves changes
      | payId   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <payId> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies that message pay record updated was showed
    Examples:
      | nit       | username  | password              | emailUser                 | payId             | quantity | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoNominahS1     | 46       | AV Villas       | 9182                     | 23.56    |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | paySavedSupplier2 | 5        | AV Villas       | 9182                     | 23.56    |