@ota
Feature: Online Transaction Authorization
  I as an iris user with administrator role
  I Want to approve a transaction that requires approval
  To for the transaction to be executes successfully

  @ota1
  Scenario Outline: Successful online transaction to other banks with unauthorized user, verifying pending authorization message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" is an unauthorized user and performs an online transaction to other banks using the following credentials:
      | emailUser   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" verify that transaction message with authorization pending was showed
    Examples:
      | nit       | username       | password             | emailUser                          | originAccountNumber | destinationBank   | destinationAccountNumber | description | tag    | transferValue |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 7007                | Banco Davivienda  | 6678                     | otherBank   | Otros  | 1000.01       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | Banco Caja Social | 5182                     |             | Otros2 | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | Banco Caja Social | 5182                     |             | Otros3 | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | Banco Caja Social | 5182                     |             | Otros4 | 1.00          |


  @ota2
  Scenario Outline: Successful online transaction between iris accounts with unauthorized user, verifying pending authorization message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" is an unauthorized user and performs an online transaction between iris accounts using the following credentials:
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" verify that transaction message with authorization pending was showed
    Examples:
      | nit       | username       | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description      | tag     | transferValue |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 7007                | 0870                     |                  | Nomina  | 1000.00       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | 4462                     | test cuenta iris | Nomina2 | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | 7983                     | test cuenta iris | Nomina3 | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | 4824                     |                  | Nomina4 | 10.00         |


  @ota3
  Scenario Outline: Successful online transaction between own accounts with unauthorized user, verifying pending authorization message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" is an unauthorized user and performs an online transaction between own accounts using the following credentials:
      | emailUser   | originAccountNumber   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <emailUser> | <originAccountNumber> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" verify that transaction message with authorization pending was showed
    Examples:
      | nit       | username       | password             | emailUser                          | originAccountNumber | destinationAccountNumber | description      | tag          | transferValue |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 7007                | 0433                     |                  | Consultoría  | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | 7007                     | test own account | Consultoría2 | 1000.00       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | 7007                     |                  | Consultoría3 | 1000.00       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | 7007                     |                  | Consultoria4 | 1000.00       |


  @ota4
  Scenario Outline: Successful online transaction with unauthorized user, verifying that the transaction is in the pending bank authorization table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to pending authorizations table and filters by type transaction
      | typeTransaction   | tag   | transferValue   |
      | <typeTransaction> | <tag> | <transferValue> |
    Then "Iris-User" verifies that the transaction record exists in the pending bank authorizations table
    Examples:
      | nit       | username       | password             | emailUser                          | typeTransaction | tag          | transferValue |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Otros bancos    | Otros        | 1000.01       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Otros bancos    | Otros2       | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas iris    | Nomina       | 1000.00       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas iris    | Nomina2      | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas propias | Consultoría  | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas propias | Consultoría2 | 1000.00       |


  @ota5
  Scenario Outline: Successful online transaction with unauthorized user, verifying that the voucher information of transaction pending for authorization is correct
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" opens the voucher of transaction pending for authorization
      | typeTransaction   | originAccountNumber   | destinationBank   | destinationAccountNumber   | description   | tag   | transferValue   |
      | <typeTransaction> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <description> | <tag> | <transferValue> |
    Then "Iris-User" verifies that voucher information for the transaction pending authorization is correct
    Examples:
      | nit       | username       | password             | emailUser                          | typeTransaction | originAccountNumber | destinationBank   | destinationAccountNumber | description      | tag          | transferValue |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Otros bancos    | 7007                | Banco Davivienda  | 6678                     | otherBank        | Otros        | 1000.01       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Otros bancos    | 0433                | Banco Caja Social | 5182                     |                  | Otros2       | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Otros bancos    | 0433                | Banco Caja Social | 5182                     |                  | Otros3       | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Otros bancos    | 0433                | Banco Caja Social | 5182                     |                  | Otros4       | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas iris    | 7007                |                   | 0870                     |                  | Nomina       | 1000.00       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas iris    | 0433                |                   | 4462                     | test cuenta iris | Nomina2      | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas iris    | 0433                |                   | 7983                     | test cuenta iris | Nomina3      | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas iris    | 0433                |                   | 4824                     |                  | Nomina4      | 10.00         |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas propias | 7007                |                   | 0433                     |                  | Consultoría  | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas propias | 0433                |                   | 7007                     | test own account | Consultoría2 | 1000.00       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas propias | 0433                |                   | 7007                     |                  | Consultoría3 | 1000.00       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas propias | 0433                |                   | 7007                     |                  | Consultoria4 | 1000.00       |


  @ota6
  Scenario Outline: Authorize transaction online, from the detail of the record in the table my authorizations
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches and approves the transaction pending approval in the my approvals table
      | emailUser   | typeTransaction   | tag   | transferValue   |
      | <emailUser> | <typeTransaction> | <tag> | <transferValue> |
    Then "Iris-User" verifies successful approval messages
    Examples:
      | nit       | username    | password             | emailUser                          | typeTransaction | tag         | transferValue |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Otros bancos    | Otros       | 1000.01       |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas iris    | Nomina      | 1000.00       |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas propias | Consultoría | 1.00          |


  @ota7
  Scenario Outline: Authorize transaction from the main button of the my authorizations table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches and approves for the transaction pending approval in the table my authorizations
      | emailUser   | typeTransaction   | tag   | transferValue   |
      | <emailUser> | <typeTransaction> | <tag> | <transferValue> |
    Then "Iris-User" verifies successful approval messages
    Examples:
      | nit       | username    | password             | emailUser                          | typeTransaction | tag          | transferValue |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Otros bancos    | Otros2       | 1.00          |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas iris    | Nomina2      | 1.00          |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas propias | Consultoría2 | 1000.00       |


  @ota8
  Scenario Outline: Verify the pending authorization transaction record present in historic table
    Given  The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to transactions historic table and looks for the last transaction with pending authorization
      | typeTransaction   | originAccountNumber   | destinationBank   | destinationAccountNumber   | tag   | transferValue   |
      | <typeTransaction> | <originAccountNumber> | <destinationBank> | <destinationAccountNumber> | <tag> | <transferValue> |
    Then "iris-User" verifies that found historic record for the transaction pending authorization is correct
    Examples:
      | nit       | username       | password             | emailUser                          | typeTransaction | originAccountNumber | destinationBank   | destinationAccountNumber | tag          | transferValue |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Otros bancos    | 7007                | Banco Davivienda  | 6678                     | Otros        | 1000.01       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Otros bancos    | 0433                | Banco Caja Social | 5182                     | Otros2       | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas iris    | 7007                |                   | 0870                     | Nomina       | 1000.00       |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas iris    | 0433                |                   | 4462                     | Nomina2      | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas propias | 7007                |                   | 0433                     | Consultoría  | 1.00          |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | Cuentas propias | 0433                |                   | 7007                     | Consultoría2 | 1000.00       |
      | 900800005 | adminrobot1    | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Otros bancos    | 7007                | Banco Davivienda  | 6678                     | Otros        | 1000.01       |
      | 900800005 | adminrobot1    | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Otros bancos    | 0433                | Banco Caja Social | 5182                     | Otros2       | 1.00          |
      | 900800005 | adminrobot1    | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas iris    | 7007                |                   | 0870                     | Nomina       | 1000.00       |
      | 900800005 | adminrobot1    | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas iris    | 0433                |                   | 4462                     | Nomina2      | 1.00          |
      | 900800005 | adminrobot1    | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas propias | 7007                |                   | 0433                     | Consultoría  | 1.00          |
      | 900800005 | adminrobot1    | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas propias | 0433                |                   | 7007                     | Consultoría2 | 1000.00       |


  @ota9
  Scenario Outline: No Authorize transaction online, from the detail of the record in the table my authorizations
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" looks for and does not authorize the transaction pending authorization from the details of the table my authorizations
      | emailUser   | tag   | transferValue   | typeTransaction   |
      | <emailUser> | <tag> | <transferValue> | <typeTransaction> |
    Then "Iris-User" verify that NO authorization messages are successful
    Examples:
      | nit       | username    | password             | emailUser                          | typeTransaction | tag          | transferValue |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Otros bancos    | Otros3       | 1.00          |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas iris    | Nomina3      | 1.00          |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas propias | Consultoría3 | 1000.00       |


  @ota10
  Scenario Outline: No Authorize transaction from the main button of the my authorizations table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches for and does not authorize the transaction pending authorization in the table my authorizations
      | emailUser   | tag   | transferValue   | typeTransaction   |
      | <emailUser> | <tag> | <transferValue> | <typeTransaction> |
    Then "Iris-User" verify that NO authorization messages are successful
    Examples:
      | nit       | username    | password             | emailUser                          | typeTransaction | tag          | transferValue |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Otros bancos    | Otros4       | 1.00          |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas iris    | Nomina4      | 10.00         |
      | 900800005 | adminrobot1 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | Cuentas propias | Consultoria4 | 1000.00       |
