@otoa
Feature: Online Transaction between own accounts iris
  I as an Iris User
  Want to do an transaction between own accounts iris
  To verify the transaction status

  @otoa1
  Scenario Outline: Transaction between own accounts, verifying if the transfer value entered was valid
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" enters the transfer value for transaction with own accounts
      | originAccountNumber   | destinationAccountNumber   | transferValue   |
      | <originAccountNumber> | <destinationAccountNumber> | <transferValue> |
    Then "Iris-User" verifies if the value of the transfer with own accounts is correct
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     | 0.99          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     | 1.00          |

  @otoa2
  Scenario Outline: Verify the information present in summary page of the transaction
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" verifies the information on the summary page of the transaction made with own accounts
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-user" verifies the online transaction information between own accounts on the summary page matches the information entered
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag          | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría2 | 1000.00       |


  @otoa3
  Scenario Outline: Successful online transaction between own accounts, verifying transaction successful message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" makes a transaction online with own accounts
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" verify transaction successful message to own accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag          | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría2 | 1.00          |

  @otoa4
  Scenario Outline: Successful online transaction between own accounts, checking data of voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    And "Iris-User" makes a transaction online between own accounts using the following credentials:
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    When The "Iris-User" see the initial voucher of transaction between own accounts
    Then "Iris-User" validate that the information on the transaction voucher between own accounts is correct.
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag          | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría3 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoria4 | 1000.00       |

  @otoa5
  Scenario Outline: Successful online transaction between own accounts, checking data in the transaction detail register
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction between own accounts in the transaction detail table
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the transaction detail table register is correct for trx between own accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag          | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría2 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría3 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoria4 | 1000.00       |

  @otoa6
  Scenario Outline: Successful online transaction between own accounts, checking data in the transaction detail voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction between own accounts in the transaction detail table register
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the transaction detail table voucher is correct for trx between own accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag          | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría2 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría3 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoria4 | 1000.00       |

  @otoa7
  Scenario Outline: Successful online transaction between own accounts, checking data in the transaction history register
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction between own accounts in the transaction historic table
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the historic transaction table register is correct for trx between own accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag          | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría2 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría3 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoria4 | 1000.00       |

  @otoa8
  Scenario Outline: Successful online transaction between own accounts, checking data in the transaction history voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction between own accounts in the transaction history table register
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the transaction historic table voucher is correct for trx between own accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag          | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría2 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría3 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoria4 | 1000.00       |

  @otoa9
  Scenario Outline: Successful online transaction between own accounts, checking the voucher send by email
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    And "Iris-User" makes a transaction online between own accounts using the following credentials:
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    When "Iris-User" sends online voucher of the transaction between own accounts by email
    Then "Iris-User" validates the receipt of the online transaction voucher between own accounts by e-mail
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag          | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría2 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoría3 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0433                     |             | Consultoria4 | 1000.00       |

