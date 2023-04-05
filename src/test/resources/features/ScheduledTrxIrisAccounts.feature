@stia
Feature: Scheduled transaction between iris accounts
  I as an Iris User
  Want to do a scheduled transaction between iris accounts
  To verify the transaction status

  @stia1
  Scenario Outline: Verify the information present in summary page of the transaction
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to summary page of current transaction between iris accounts
      | emailUser   | originAccountNumber   | destinationAccountNumber   | transferValue   | tag   | description   | periodicity   | startTransactionDate   | finalTransactionDate   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <transferValue> | <tag> | <description> | <periodicity> | <startTransactionDate> | <finalTransactionDate> |
    Then "Iris-user" verifies for scheduled transaction between iris accounts that information of summary page be equal to the entered information
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag     | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 4462                     | Prueba Auto | Nomina | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0870                     |             | Nomina2 | 1.02          | Semanal     | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 7983                     |             | Nomina3 | 1.03          | Quincenal   | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 4462                     | Prueba Auto | Nomina4 | 1000.04       | Mensual     | 01/02/2023           | 25/06/2023           |

  @stia2
  Scenario Outline: Successful scheduled transaction between iris accounts, verifying transaction successful message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" makes a scheduled transaction between iris accounts
      | emailUser   | originAccountNumber   | destinationAccountNumber   | transferValue   | tag   | description   | periodicity   | startTransactionDate   | finalTransactionDate   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <transferValue> | <tag> | <description> | <periodicity> | <startTransactionDate> | <finalTransactionDate> |
    Then "Iris-User" verifies successful scheduled transaction message between iris accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag     | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 4462                     | Prueba Auto | Nomina | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0870                     |             | Nomina2| 1.02          | Semanal     | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 7983                     |             | Nomina3| 1.03          | Quincenal   | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 4462                     | Prueba Auto | Nomina4| 1000.04       | Mensual     | 01/02/2023           | 25/06/2023           |

  @stia3
  Scenario Outline: Successful scheduled transaction between iris accounts, checking the scheduled transaction register
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" search in the table of scheduled transactions for the transaction between iris accounts
      | originAccountNumber   | destinationAccountNumber   | periodicity   | startTransactionDate   | finalTransactionDate   | tag   | transferValue   |
      | <originAccountNumber> | <destinationAccountNumber> | <periodicity> | <startTransactionDate> | <finalTransactionDate> | <tag> | <transferValue> |
    Then "Iris-User" verifies that the information of the scheduled transaction register between iris accounts is correct
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber| tag     | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 4462                    | Nomina  | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0870                    | Nomina2 | 1.02          | Semanal     | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 7983                    | Nomina3 | 1.03          | Quincenal   | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 4462                    | Nomina4 | 1000.04       | Mensual     | 01/02/2023           | 25/06/2023           |


  @stia4
  Scenario Outline: Successful scheduled transaction between iris accounts, checking the scheduled transaction voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches the table of scheduled transactions to view the transaction voucher between iris accounts
      | originAccountNumber   | destinationAccountNumber   | periodicity   | startTransactionDate   | finalTransactionDate   | tag   | transferValue   | description   |
      | <originAccountNumber> | <destinationAccountNumber> | <periodicity> | <startTransactionDate> | <finalTransactionDate> | <tag> | <transferValue> | <description> |
    Then "Iris-User" verifies that the scheduled transaction voucher information is correct between iris accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag     | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 4462                     | Prueba Auto | Nomina  | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0870                     |             | Nomina2 | 1.02          | Semanal     | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 7983                     |             | Nomina3 | 1.03          | Quincenal   | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 4462                     | Prueba Auto | Nomina4 | 1000.04       | Mensual     | 01/02/2023           | 25/06/2023           |


  @stia5
  Scenario Outline: Delete scheduled transaction between iris accounts, from the scheduled transaction table record details
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" deletes a scheduled transaction between iris accounts from the detail of a selected record in the scheduled transactions table
      | originAccountNumber   | destinationBank   | destinationAccountNumber   | periodicity   | startTransactionDate   | finalTransactionDate   | tag   | transferValue   | description   |
      | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <periodicity> | <startTransactionDate> | <finalTransactionDate> | <tag> | <transferValue> | <description> |
    Then "Iris-User" verifies the successful deletion message of a scheduled transaction between iris accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag     | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 4462                     | Prueba Auto | Nomina  | 1000.01       | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 0870                     |             | Nomina2 | 1.02          | Semanal     | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0433                | 7983                     |             | Nomina3 | 1.03          | Quincenal   | 01/02/2023           | 25/06/2023           |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 7007                | 4462                     | Prueba Auto | Nomina4 | 1000.04       | Mensual     | 01/02/2023           | 25/06/2023           |