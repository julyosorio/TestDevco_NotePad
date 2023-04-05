@opa
Feature: Online Payment Authorization
  I as an iris user with operator role
  Want to complete an online payroll pay with user unauthorized
  To verifies the payment status

  @opa1
  Scenario Outline: Successful online payroll payment with unauthorized user, verifying pending authorization message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "payroll" menu and completes a payroll pay online without authorization
      | emailUser   | originAccountNumber   | payId   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies that message about pay with authorization pending was showed
      | quantity   | payValue   |
      | <quantity> | <payValue> |
    Examples:
      | nit       | username       | password             | emailUser                          | originAccountNumber | payId       | tag     | quantity | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | Nomina00004 | Empresa | 1        | Iris            | 4824                     | 10.00    |


  @opa2
  Scenario Outline: Successful online supplier payment with unauthorized user, verifying pending authorization message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "supplier" menu and completes a supplier pay online without authorization
      | emailUser   | originAccountNumber   | payId   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies that message about pay with authorization pending was showed
      | quantity   | payValue   |
      | <quantity> | <payValue> |
    Examples:
      | nit       | username       | password             | emailUser                          | originAccountNumber | payId          | tag         | quantity | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | operadorrobot1 | 2023Automatizacion** | usuarioautomatizacion3@yopmail.com | 0433                | Proveedor00004 | Consultoría | 2        | Iris            | 4824                     | 10.00    |


  @opa3
  Scenario Outline: Successful scheduled payroll payment with unauthorized user, verifying pending authorization message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "payroll" menu and completes a scheduled payroll pay without authorization
      | emailUser   | originAccountNumber   | payId   | executeDate   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <executeDate> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies that message about scheduled pay with authorization pending was showed
      | quantity   | payValue   |
      | <quantity> | <payValue> |
    Examples:
      | nit       | username   | password              | emailUser                         | originAccountNumber | payId          | executeDate | tag         | quantity | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | operador01 | UserTestAutomation01* | iris.auto.operador.01@yopmail.com | 0433                | sofkaNominaa1  | 15/01/2023  | PagoNomIris | 2        | Iris            | 4824                     | 1000.33  |
      | 900800005 | operador01 | UserTestAutomation01* | iris.auto.operador.01@yopmail.com | 0433                | sofkaNominaa20 | 19/01/2023  | PagoNomIris | 2        | Iris            | 4824                     | 1000.33  |
      | 900800005 | operador01 | UserTestAutomation01* | iris.auto.operador.01@yopmail.com | 7007                | sofkaNominaa21 | 31/07/2023  | PagoNomina  | 4        | Bancamia        | 3456                     | 456.81   |

  @opa4
  Scenario Outline: Successful scheduled supplier payment with unauthorized user, verifying pending authorization message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "supplier" menu and completes a scheduled supplier pay without authorization
      | emailUser   | originAccountNumber   | payId   | executeDate   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <executeDate> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies that message about scheduled pay with authorization pending was showed
      | quantity   | payValue   |
      | <quantity> | <payValue> |
    Examples:
      | nit       | username   | password              | emailUser                         | originAccountNumber | payId            | executeDate | tag         | quantity | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | operador01 | UserTestAutomation01* | iris.auto.operador.01@yopmail.com | 0433                | sofkaProveedor1  | 20/01/2023  | PagoProv    | 2        | Iris            | 4824                     | 1000.33  |
      | 900800005 | operador01 | UserTestAutomation01* | iris.auto.operador.01@yopmail.com | 0433                | sofkaProveedor10 | 31/01/2023  | Proveedores | 2        | Iris            | 4824                     | 1000.33  |
      | 900800005 | operador01 | UserTestAutomation01* | iris.auto.operador.01@yopmail.com | 7007                | sofkaProveedor11 | 03/07/2023  | PagoProv    | 4        | Bancamia        | 3456                     | 456.81   |

  @opa5
  Scenario Outline: Authorize payment from the main button of the my authorizations table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" looks up and approves the payment pending approval in the table my authorizations
      | emailUser   | payType   | tag   | payValue   | quantity   |
      | <emailUser> | <payType> | <tag> | <payValue> | <quantity> |
    Then "Iris-User" verifies the success of payment approval messages
    Examples:
      | nit       | username    | password             | emailUser                          | payType              | tag         | payValue | quantity |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Manuales:Nominas     | Empresa     | 10.00    | 1        |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Manuales:Proveedores | Consultoría | 20.00    | 2        |

  @opa6
  Scenario Outline: Authorize payment online, from the detail of the record in the table my authorizations
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches and approves the payment pending approval in the my approvals table
      | emailUser   | payType   | tag   | payValue   | quantity   |
      | <emailUser> | <payType> | <tag> | <payValue> | <quantity> |
    Then "Iris-User" verifies the success of payment approval messages
    Examples:
      | nit       | username    | password             | emailUser                          | payType              | tag         | payValue | quantity |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Manuales:Nominas     | Empresa     | 10.00    | 1        |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Manuales:Proveedores | Consultoría | 10.00    | 2        |

  @opa7
  Scenario Outline: No Authorize payment from the main button of the my authorizations table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches for and does not authorize the payment pending authorization in the table my authorizations
      | emailUser   | payType   | tag   | payValue   | quantity   |
      | <emailUser> | <payType> | <tag> | <payValue> | <quantity> |
    Then "Iris-User" checks the NO payment authorization message
    Examples:
      | nit       | username    | password             | emailUser                          | payType              | tag         | payValue | quantity |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Manuales:Nominas     | Empresa     | 10.00    | 1        |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Manuales:Proveedores | Consultoría | 10.00    | 2        |

    @opa8
    Scenario Outline: No Authorize payment, from the detail of the record in the table my authorizations
      Given The "Iris-User" authenticates to the Iris website using the following credentials:
        | nit   | username   | password   | email       |
        | <nit> | <username> | <password> | <emailUser> |
      When "Iris-User" looks for and does not authorize the payment pending authorization from the details of the table my authorizations
        | emailUser   | payType   | tag   | payValue   | quantity   |
        | <emailUser> | <payType> | <tag> | <payValue> | <quantity> |
      Then "Iris-User" checks the NO payment authorization message
      Examples:
        | nit       | username    | password             | emailUser                          | payType              | tag         | payValue | quantity |
        | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Manuales:Nominas     | Empresa     | 10.00    | 1        |
        | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Manuales:Proveedores | Consultoría | 10.00    | 2        |