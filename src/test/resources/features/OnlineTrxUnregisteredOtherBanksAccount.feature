@otuoba
Feature: Online transaction to other bank with unregistered destination account
  I as an Iris User
  Want to do a transaction to other bank including the subscription of a new destination account
  To verify the transaction status

  @otuoba1
  Scenario Outline: Verify the information present in summary page of the transaction
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to summary page of current transaction to other banks with destination unregistered account
      | emailUser   | originAccountNumber   | destinationBank   | ownerDestinationAccount   | emailSubsAccount   | docTypeDestinationAccount   | docNumDestinationAccount   | destinationAccountType   | destinationAccountNumber   | requiresSaveSubscription   | descriptionSubsAccount   | transferValue   | tag   | description   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <ownerDestinationAccount> | <emailSubsAccount> | <docTypeDestinationAccount> | <docNumDestinationAccount> | <destinationAccountType> | <destinationAccountNumber> | <requiresSaveSubscription> | <descriptionSubsAccount> | <transferValue> | <tag> | <description> |
    Then "Iris-user" verify that the data on the summary page is correct for transaction to other banks with unregistered destination account
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank | ownerDestinationAccount | emailSubsAccount    | docTypeDestinationAccount | docNumDestinationAccount | destinationAccountType | destinationAccountNumber | requiresSaveSubscription | descriptionSubsAccount | description | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Bancoldex       | Ramon Gomez             | ramongo@yopmail.com | ciudadanía                | 1023436987               | ahorros                | 7893211056               | Si                       | Cuenta1                | test        | Otros  | 1000.01       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Bancamia S.A    | Maria Pulgarin          | mariapu@yopmail.com | Pasaporte                 | 9632387410               | corriente              | 789007723                | Si                       |                        | test1       | Otros2 | 1.04          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Bancoomeva      | Juan Castro             | juanca@yopmail.com  | extranjería               | 733951                   | corriente              | 14796000258              | No                       | Cuenta3                |             | Otros3 | 1.00          |

  @otuoba2
  Scenario Outline: Successful online transaction to other banks with unregistered other bank account, verifying transaction successful message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" subscribes an account and makes a transaction to other banks
      | emailUser   | originAccountNumber   | destinationBank   | ownerDestinationAccount   | emailSubsAccount   | docTypeDestinationAccount   | docNumDestinationAccount   | destinationAccountType   | destinationAccountNumber   | requiresSaveSubscription   | descriptionSubsAccount   | transferValue   | tag   | description   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <ownerDestinationAccount> | <emailSubsAccount> | <docTypeDestinationAccount> | <docNumDestinationAccount> | <destinationAccountType> | <destinationAccountNumber> | <requiresSaveSubscription> | <descriptionSubsAccount> | <transferValue> | <tag> | <description> |
    Then "Iris-user" verifies the message of successful transaction to other banks with the unregistered destination account
      | transferValue   |
      | <transferValue> |
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank | ownerDestinationAccount | emailSubsAccount    | docTypeDestinationAccount | docNumDestinationAccount | destinationAccountType | destinationAccountNumber | requiresSaveSubscription | descriptionSubsAccount | description | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Bancoldex       | Ramon Gomez             | ramongo@yopmail.com | ciudadanía                | 1023436987               | ahorros                | 7893211056               | Si                       | Cuenta1                | test        | Otros  | 1000.01       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Bancamia S.A    | Maria Pulgarin          | mariapu@yopmail.com | Pasaporte                 | 9632387410               | corriente              | 789007723                | Si                       |                        | test2       | Otros2 | 1.04          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Bancoomeva      | Juan Castro             | juanca@yopmail.com  | extranjería               | 733951                   | corriente              | 14796000258              | No                       | Cuenta3                |             | Otros3 | 1.00          |

  @otuoba3
  Scenario Outline: Successful online transaction to other banks with unregistered account, checking in the table of registered accounts
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches the registered account record of other banks in the table registered accounts
      | ownerDestinationAccount   | destinationBank   | emailSubsAccount   | docTypeDestinationAccount   | docNumDestinationAccount   | destinationAccountNumber   | descriptionSubsAccount   | destinationAccountType   |
      | <ownerDestinationAccount> | <destinationBank> | <emailSubsAccount> | <docTypeDestinationAccount> | <docNumDestinationAccount> | <destinationAccountNumber> | <descriptionSubsAccount> | <destinationAccountType> |
    Then "Iris-User" validate that the information of the registered account other banks, of the table accounts registered is correct
    Examples:
      | nit       | username    | password             | emailUser                          |  destinationBank | ownerDestinationAccount | emailSubsAccount    | docTypeDestinationAccount | docNumDestinationAccount | destinationAccountType | destinationAccountNumber | descriptionSubsAccount |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com |  Bancoldex       | Ramon Gomez             | ramongo@yopmail.com | ciudadanía                | 1023436987               | ahorros                | 7893211056               | Cuenta1                |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com |  Bancamia S.A    | Maria Pulgarin          | mariapu@yopmail.com | Pasaporte                 | 9632387410               | corriente              | 789007723                |                        |

  @otuoba4
  Scenario Outline: Successful online transaction to other banks with unregistered account, verification of registered account details
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches for the registered account of other banks in the table registered accounts, to see the account detail
      | ownerDestinationAccount   | destinationBank   | docTypeDestinationAccount   | docNumDestinationAccount   | destinationAccountType   | destinationAccountNumber   | emailSubsAccount   | descriptionSubsAccount   |
      | <ownerDestinationAccount> | <destinationBank> | <docTypeDestinationAccount> | <docNumDestinationAccount> | <destinationAccountType> | <destinationAccountNumber> | <emailSubsAccount> | <descriptionSubsAccount> |
    Then "Iris-User" validate that the detailed information of the registered account of other banks is correct
    Examples:
      | nit       | username    | password             | emailUser                          |  destinationBank | ownerDestinationAccount | emailSubsAccount    | docTypeDestinationAccount | docNumDestinationAccount | destinationAccountType | destinationAccountNumber | descriptionSubsAccount |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com |  Bancoldex       | Ramon Gomez             | ramongo@yopmail.com | ciudadanía                | 1023436987               | ahorros                | 7893211056               | Cuenta1                |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com |  Bancamia S.A    | Maria Pulgarin          | mariapu@yopmail.com | Pasaporte                 | 9632387410               | corriente              | 789007723                |                        |

