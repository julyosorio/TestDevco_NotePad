@stob
Feature: Scheduled Transaction from a iris account to other bank
  I as an Iris User
  Want to do a transaction between an iris account and account other bank
  To verify the transaction status

  @stob1
  Scenario Outline: Verify the information present in summary page of the transaction
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to summary page of current transaction to other bank
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   | periodicity   | startTransactionDate   | finalTransactionDate   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> | <periodicity> | <startTransactionDate> | <finalTransactionDate> |
    Then "Iris-user" verifies for scheduled transaction to other bank that information of summary page be equal to the entered information
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description | tag    | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba      | Otros  | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     |             | Otros2 | 10000.01      | Semanal     | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     |             | Otros3 | 10.03         | Quincenal   | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     | Prueba      | Otros4 | 1000.04       | Mensual     | 01/02/2023           | 20/06/2023           |

  @stob2
  Scenario Outline: Successful scheduled transaction to other banks, verifying transaction successful message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" makes a scheduled transaction to other bank
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   | periodicity   | startTransactionDate   | finalTransactionDate   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> | <periodicity> | <startTransactionDate> | <finalTransactionDate> |
    Then "Iris-User" verifies that show successful transaction message to other bank
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description | tag    | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba      | Otros  | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     |             | Otros2 | 10000.01      | Semanal     | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     |             | Otros3 | 10.03         | Quincenal   | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     | Prueba      | Otros4 | 1000.04       | Mensual     | 01/02/2023           | 20/06/2023           |

  @stob3
  Scenario Outline: Successful scheduled transaction to other banks, checking the scheduled transaction register
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches the scheduled transactions table for the transaction with the data
      | originAccountNumber   | destinationBank   | destinationAccountNumber   | periodicity   | startTransactionDate   | finalTransactionDate   | tag   | transferValue   |
      | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <periodicity> | <startTransactionDate> | <finalTransactionDate> | <tag> | <transferValue> |
    Then "Iris-User" validate that the information of the scheduled transaction table register was correct
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | tag    | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     | Otros  | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     | Otros2 | 10000.01      | Semanal     | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     | Otros3 | 10.03         | Quincenal   | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     | Otros4 | 1000.04       | Mensual     | 01/02/2023           | 20/06/2023           |


  @stob4
  Scenario Outline: Successful scheduled transaction to other banks, checking the scheduled transaction voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches the scheduled transactions table for the voucher with the data
      | originAccountNumber   | destinationBank   | destinationAccountNumber   | periodicity   | startTransactionDate   | finalTransactionDate   | tag   | transferValue   | description   |
      | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <periodicity> | <startTransactionDate> | <finalTransactionDate> | <tag> | <transferValue> | <description> |
    Then "Iris-User" validate that the information of the voucher was correct
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description | tag    | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba      | Otros  | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     |             | Otros2 | 10000.01      | Semanal     | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     |             | Otros3 | 10.03         | Quincenal   | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     | Prueba      | Otros4 | 1000.04       | Mensual     | 01/02/2023           | 20/06/2023           |


  @stob5
  Scenario Outline: Delete scheduled transaction to other banks, from the scheduled transaction table record details
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" deletes a scheduled transaction to other banks from the detail of a selected record in the scheduled transactions table
      | originAccountNumber   | destinationBank   | destinationAccountNumber   | periodicity   | startTransactionDate   | finalTransactionDate   | tag   | transferValue   | description   |
      | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <periodicity> | <startTransactionDate> | <finalTransactionDate> | <tag> | <transferValue> | <description> |
    Then "Iris-User" verifies the successful deletion message of a scheduled transaction to other banks
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationBank  | destinationAccountNumber | description | tag    | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     | Prueba      | Otros  | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     |             | Otros2 | 10000.01      | Semanal     | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | Banco Davivienda | 6678                     |             | Otros3 | 10.03         | Quincenal   | 01/02/2023           | 20/06/2023           |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | Banco Davivienda | 6678                     | Prueba      | Otros4 | 1000.04       | Mensual     | 01/02/2023           | 20/06/2023           |
