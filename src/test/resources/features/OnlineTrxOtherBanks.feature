@otob
Feature: Online Transaction from an iris account to other bank
  I as an Iris User
  Want to do a transaction between an iris account and another bank account
  To verify the transaction status

  @otob1
  Scenario Outline: Transaction to other banks, verifyng if the transfer value entered was valid
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" enters the transfer value for transaction to other banks
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <transferValue> |
    Then "Iris-User" verifies if the value of the transfer to other banks is correct
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank | destinationAccountNumber | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Bancamia S.A.   | 1536                     | 0.99          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Bancamia S.A.   | 1536                     | 1.99          |

  @otob2
  Scenario Outline: Verify the information present in summary page of the transaction
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to summary page of current transaction to other banks
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-user" verifies the online transaction information to other banks on the summary page matches the information entered

    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description      | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx banks | Otros2 | 1.87          |

  @otob3
  Scenario Outline: Successful online transaction to other banks, verifying transaction successful message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" makes a transaction online to other banks
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" verify transaction successful message to other banks
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description      | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx banks | Otros2 | 1.87          |

  @otob4
  Scenario Outline: Successful online transaction to other banks, checking data of voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    And "Iris-User" makes a transaction online to other banks using the following credentials:
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    When The "Iris-User" see the initial voucher of transaction to other banks
    Then "Iris-User" validate that the information on the transaction voucher to other banks is correct.
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |             | Otros3 | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx  | Otros4 | 1.00          |

  @otob5
  Scenario Outline: Successful online transaction to other banks, checking data in the transaction detail register
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction to other banks in the transaction detail table
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the transaction detail table register is correct for trx to other banks
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description      | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx banks | Otros2 | 1.87          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros3 | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx       | Otros4 | 1.00          |

  @otob6
  Scenario Outline: Successful online transaction to other banks, checking data in the transaction detail voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction to other banks in the transaction detail table register
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the transaction detail table voucher is correct for trx to other banks
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description      | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx banks | Otros2 | 1.87          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros3 | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx       | Otros4 | 1.00          |

  @otob7
  Scenario Outline: Successful online transaction to other banks, checking data in the transaction history register
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction to other banks in the transaction historic table
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the historic transaction table register is correct for trx to other banks
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description      | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx banks | Otros2 | 1.87          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros3 | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx       | Otros4 | 1.00          |

  @otob8
  Scenario Outline: Successful online transaction to other banks, checking data in the transaction history voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" look for the transaction to other banks in the transaction history table register
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the transaction historic table voucher is correct for trx to other banks
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description      | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx banks | Otros2 | 1.87          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros3 | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx       | Otros4 | 1.00          |

  @otob9
  Scenario Outline: Successful online transaction to other banks, checking the voucher send by email
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    And "Iris-User" makes a transaction online to other banks using the following credentials:
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    When "Iris-User" sends the transaction voucher to other banks by email
    Then "Iris-User" validate that the voucher was received in email
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description      | tag    | transferValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros  | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx banks | Otros2 | 1.87          |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Bancamia S.A.    | 1536                     |                  | Otros3 | 1000.00       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba trx       | Otros4 | 1.00          |
