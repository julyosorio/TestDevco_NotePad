@tagmanager
Feature: Manage the tags in the digital bank
  I as user iris
  Want to manage the tags
  To can create, edit, list, delete it

  @tagmanager1
  Scenario Outline: Create a new tag successfully
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" completes the tag creation form
      | tagName   | usersList   | typeOperationList   | category   |
      | <tagName> | <usersList> | <typeOperationList> | <category> |
    Then "Iris-User" verifies that message the tag created successful was showed

    Examples:
      | nit       | username    | password              | emailUser                         | tagName     | usersList                                                                  | typeOperationList                                                                                                              | category   |
      | 900800005 | userautho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com         | pruebaIris3 |                                                                            |                                                                                                                                | pruebaSof  |
      | 900800005 | userautho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com         | prueba46    | operador iris, Sharon Rojas, LEIDY DIAZ, admin autorizador, Robot Operador | Transf. cuentas iris, Transf. en lote, Pagos manuales: Nóminas, Link de Cobro, Pagos en lote: Nóminas, Transf. cuentas propias | RecaudoMod |
      | 900800005 | usertrx01   | UserTestAutomation01* | usuariotrx.01@yopmail.com         | prueb20     | operador iris, Sharon Rojas, LEIDY DIAZ, admin autorizador, Robot Operador | Transf. cuentas iris, Transf. en lote, Pagos manuales: Nóminas, Link de Cobro, Pagos en lote: Nóminas, Transf. cuentas propias | RecaudoMod |
      | 900800005 | sharonrojas | UserTestAutomation01* | usuariotrx.02@yopmail.com         | tagPrueba10 | operador iris, Sharon Rojas, LEIDY DIAZ, admin autorizador, Robot Sofka    | Transf. cuentas iris, Transf. en lote, Pagos manuales: Nóminas, Link de Cobro, Pagos en lote: Nóminas, Transf. cuentas propias | RecaudoMod |
      | 900800005 | operador01  | UserTestAutomation01* | iris.auto.operador.01@yopmail.com | tagPrueba20 | operador iris, Sharon Rojas,admin autorizador                              | Transf. cuentas iris, Transf. en lote, Pagos : Nóminas                                                                         | RecaudoMod |