@otia
Feature: Online Transaction between iris accounts
  I as an Iris User
  Want to do an online transaction between iris accounts
  To verify the transaction status

  @otia1
  Scenario Outline: Transaction between iris accounts, verifying if the transfer value entered was valid
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" enters the transfer value for transaction between iris accounts
      | originAccountNumber   | destinationAccountNumber   | transferValue   |
      | <originAccountNumber> | <destinationAccountNumber> | <transferValue> |
    Then "Iris-User" verifies if the value of the transfer between iris accounts is correct
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | 0.99          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | 1.99          |

  @otia2
  Scenario Outline: Verify the information present in summary page of the transaction
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" verifies the information on the summary page of the transaction made between iris accounts
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-user" verifies the online transaction information between iris accounts on the summary page matches the information entered
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag     | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4462                     |             | Nomina  | 1.23          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4462                     | Prueba      | Nomina2 | 1.87          |

  @otia3
  Scenario Outline: Successful online transaction between iris accounts, verifying transaction successful message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" makes an online transaction between iris accounts
      | emailUser   | originAccountNumber   | destinationAccountNumber   | transferValue   | tag   | description   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <transferValue> | <tag> | <description> |
    Then "Iris-User" verify transaction successful message between iris accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | transferValue | tag     | description |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | 1.00          | Nomina  | prueba      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | 1.00          | Nomina2 |             |

  @otia4
  Scenario Outline: Successful online transaction between iris accounts, checking data of voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    And "Iris-User" makes a transaction online between iris accounts using the following credentials:
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    When The "Iris-User" see the initial voucher of transaction between iris accounts
    Then "Iris-User" validate that the information on the transaction voucher between iris accounts is correct.
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | transferValue | tag     | description |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | 1.00          | Nomina3 | prueba      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | 1.00          | Nomina4 | prueba 2    |

  @otia5
  Scenario Outline: Successful online transaction between iris accounts, checking data in the transaction detail register
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction between iris accounts in the transaction detail table
      | emailUser   | originAccountNumber   | destinationAccountNumber   | transferValue   | tag   | description   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <transferValue> | <tag> | <description> |
    Then "Iris-User" validate that the information of the transaction detail table register is correct for trx between iris accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | transferValue | tag     | description |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | 1.00          | Nomina  | prueba      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | 1.00          | Nomina2 |             |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | 1.00          | Nomina3 | prueba      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | 1.00          | Nomina4 | prueba 2    |

  @otia6
  Scenario Outline: Successful online transaction between iris accounts, checking data in the transaction detail voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction done between iris accounts in the transaction detail voucher
      | emailUser   | originAccountNumber   | destinationAccountNumber   | transferValue   | tag   | description   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <transferValue> | <tag> | <description> |
    Then "Iris-User" validate that the information of the transaction detail table voucher is correct for trx between iris accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | transferValue | tag     | description |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | 1.00          | Nomina  | prueba      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | 1.00          | Nomina2 |             |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | 1.00          | Nomina3 | prueba      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | 1.00          | Nomina4 | prueba 2    |

  @otia7
  Scenario Outline: Successful online transaction between iris accounts, checking data in the transaction history register
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction between iris accounts in the transaction historic table
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the historic transaction table register is correct for trx between iris accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag     | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | prueba      | Nomina  | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     |             | Nomina2 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | prueba      | Nomina3 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | prueba 2    | Nomina4 | 1.00          |

  @otia8
  Scenario Outline: Successful online transaction between iris accounts, checking data in the transaction history voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction between iris accounts in the transaction history table register
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the transaction historic table voucher is correct for trx between iris accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag     | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | prueba      | Nomina  | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     |             | Nomina2 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | prueba      | Nomina3 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | prueba 2    | Nomina4 | 1.00          |

  @otia9
  Scenario Outline: Successful online transaction between iris accounts, checking the voucher send by email
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    And "Iris-User" makes a transaction online between iris accounts using the following credentials:
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    When "Iris-User" sends the transaction voucher between iris accounts by email
    Then "Iris-User" validate that the voucher was received in destination email
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag     | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     | prueba      | Nomina  | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 4824                     |             | Nomina2 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | prueba      | Nomina3 | 1.00          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7983                     | prueba 2    | Nomina4 | 1.00          |