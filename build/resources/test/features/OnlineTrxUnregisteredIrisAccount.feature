@otuia
Feature: Online transaction between iris accounts with unregistered destination account
  I as an Iris User
  Want to do a transaction between iris accounts including the subscription of a new account
  To verify the transaction status

  @otuia1
  Scenario Outline: Verify the information present in summary page of the transaction
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to summary page of current transaction between iris accounts with destination unregistered account
      | emailUser   | originAccountNumber   | destinationAccountNumber   | requiresSaveSubscription   | descriptionSubsAccount   | emailSubsAccount   | transferValue   | tag   | description   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <requiresSaveSubscription> | <descriptionSubsAccount> | <emailSubsAccount> | <transferValue> | <tag> | <description> |
    Then "Iris-user" verify that the data on the summary page is correct for transaction between iris accounts with unregistered destination account
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | requiresSaveSubscription | descriptionSubsAccount | emailSubsAccount           | description | tag     | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 100282154462             | Si                       | Cuenta Iris1           | cuentaIris1@yopmail.com.co |             | Nomina  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 100111407983             | Si                       | Cuenta Iris2           | cuentaIris2@yopmail.com.co |             | Nomina2 | 1000.00       |


  @otuia2
  Scenario Outline: Successful online transaction between iris accounts to an iris destination account unregistered, verifying transaction successful message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" subscribes an account and makes a transaction between iris accounts
      | emailUser   | originAccountNumber   | destinationAccountNumber   | requiresSaveSubscription   | descriptionSubsAccount   | emailSubsAccount   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <requiresSaveSubscription> | <descriptionSubsAccount> | <emailSubsAccount> | <description> | <tag> | <transferValue> |
    Then "Iris-user" verifies the message of successful transaction between the iris account with the unregistered destination account
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | requiresSaveSubscription | descriptionSubsAccount | emailSubsAccount           | description | tag     | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 100282154462             | Si                       | Cuenta Iris1           | cuentaIris1@yopmail.com.co |             | Nomina3  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 100111407983             | Si                       | Cuenta Iris2           | cuentaIris2@yopmail.com.co |             | Nomina4 | 1000.00       |

  @otuia3
  Scenario Outline: Successful online transaction between iris accounts with unregistered account, checking in the table of registered accounts
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches the registered account record between iris accounts in the table registered accounts
    Then "Iris-User" validate that the information of the registered iris account, of the table accounts registered is correct
      | emailSubsAccount   | destinationAccountNumber   | descriptionSubsAccount   |
      | <emailSubsAccount> | <destinationAccountNumber> | <descriptionSubsAccount> |
    Examples:
      | nit       | username    | password             | emailUser                          | emailSubsAccount           | destinationAccountNumber | descriptionSubsAccount |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | cuentaIris1@yopmail.com.co | 100282154462             | Cuenta Iris1           |


  @otuia4
  Scenario Outline: Successful online transaction to other banks with unregistered account, verification of registered account details
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches for the registered iris account in the table registered accounts, to see the account detail
      | destinationAccountNumber   | emailSubsAccount   |
      | <destinationAccountNumber> | <emailSubsAccount> |
    Then "Iris-User" validate that the detailed information of the registered iris account is correct
      | destinationAccountNumber   | emailSubsAccount   | descriptionSubsAccount   |
      | <destinationAccountNumber> | <emailSubsAccount> | <descriptionSubsAccount> |
    Examples:
      | nit       | username    | password             | emailUser                          | emailSubsAccount         | destinationAccountNumber | descriptionSubsAccount |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | cuentaIris1@yopmail.com.co | 100282154462             | Cuenta Iris1           |
