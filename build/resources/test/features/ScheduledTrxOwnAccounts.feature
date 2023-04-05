@stboa
Feature: Scheduled Transaction between own accounts iris
  I as an Iris User
  Want to do a scheduled transaction between own accounts iris
  To verify that transfer was successful

  @stboa1
  Scenario Outline: Verify the information present in summary page of the transaction
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to summary page of current transaction between own accounts
      | emailUser   | originAccountNumber   | destinationAccountNumber   | transferValue   | tag   | description   | periodicity   | startTransactionDate   | finalTransactionDate   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <transferValue> | <tag> | <description> | <periodicity> | <startTransactionDate> | <finalTransactionDate> |
    Then "Iris-user" verifies for scheduled transaction between own accounts that information of summary page be equal to the entered information
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag         | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     | Prueba Auto | Consultoría | 1.00          | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | 0433                     |             | Consultoría2 | 1.00          | Semanal     | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     |             | Consultoría3 | 1000.00       | Quincenal   | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | 0433                     | Prueba Auto | Consultoria4 | 1.00          | Mensual     | 01/02/2023           | 25/11/2023           |

  @stboa2
  Scenario Outline: Successful scheduled transaction between own accounts, verifying transaction successful message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" makes a scheduled transaction with own accounts
      | emailUser   | originAccountNumber   | destinationAccountNumber   | transferValue   | tag   | description   | periodicity   | startTransactionDate   | finalTransactionDate   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <transferValue> | <tag> | <description> | <periodicity> | <startTransactionDate> | <finalTransactionDate> |
    Then "Iris-User" verifies that it displays the transaction successful message for proprietary accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag         | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     | Prueba Auto | Consultoría  | 1.00          | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     |             | Consultoría2 | 1.00          | Semanal     | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     |             | Consultoría3 | 1000.00       | Quincenal   | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     | Prueba Auto | Consultoria4 | 1.00          | Mensual     | 01/02/2023           | 25/11/2023           |

  @stboa3
  Scenario Outline: Successful scheduled transaction between own accounts, checking the scheduled transaction register
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches the scheduled transactions table for the transaction between own accounts with the data
      | originAccountNumber   | destinationAccountNumber   | periodicity   | startTransactionDate   | finalTransactionDate   | tag   | transferValue   |description|
      | <originAccountNumber> | <destinationAccountNumber> | <periodicity> | <startTransactionDate> | <finalTransactionDate> | <tag> | <transferValue> |<description>|
    Then "Iris-User" validate that the information of the scheduled transaction with own accounts table register was correct
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description |tag         | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     | Prueba Auto |Consultoría  | 1.00          | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     |             |Consultoría2 | 1.00          | Semanal     | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     |             |Consultoría3 | 1000.00       | Quincenal   | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     | Prueba Auto |Consultoria4 | 1.00          | Mensual     | 01/02/2023           | 25/11/2023           |

  @stboa4
  Scenario Outline: Successful scheduled transaction between own accounts, checking the scheduled transaction voucher
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches the table of scheduled transactions to view the transaction voucher between own accounts
      | originAccountNumber   | destinationAccountNumber   | periodicity   | startTransactionDate   | finalTransactionDate   | tag   | transferValue   | description   |
      | <originAccountNumber> | <destinationAccountNumber> | <periodicity> | <startTransactionDate> | <finalTransactionDate> | <tag> | <transferValue> | <description> |
    Then "Iris-User" verifies that the scheduled transaction voucher information is correct between own accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag         | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     | Prueba Auto | Consultoría  | 1.00          | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     |             | Consultoría2 | 1.00          | Semanal     | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     |             | Consultoría3 | 1000.00       | Quincenal   | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     | Prueba Auto | Consultoria4 | 1.00          | Mensual     | 01/02/2023           | 25/11/2023           |

  @stboa5
  Scenario Outline: Delete scheduled transaction between own accounts, from the scheduled transaction table record details
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" deletes a scheduled transaction between own accounts from the detail of a selected record in the scheduled transactions table
      | originAccountNumber   | destinationAccountNumber   | periodicity   | startTransactionDate   | finalTransactionDate   | tag   | transferValue   | description   |
      | <originAccountNumber> | <destinationAccountNumber> | <periodicity> | <startTransactionDate> | <finalTransactionDate> | <tag> | <transferValue> | <description> |
    Then "Iris-User" verifies the successful deletion message of a scheduled transaction between own accounts
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description | tag         | transferValue | periodicity | startTransactionDate | finalTransactionDate |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     | Prueba Auto | Consultoría  | 1.00          | Única vez   | 01/02/2023           |                      |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     |             | Consultoría2 | 1.00          | Semanal     | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     |             | Consultoría3 | 1000.00       | Quincenal   | 01/02/2023           | 25/11/2023           |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 0433                | 7007                     | Prueba Auto | Consultoria4 | 1.00          | Mensual     | 01/02/2023           | 25/11/2023           |

