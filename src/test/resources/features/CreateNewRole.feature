@cnr
Feature: Create new role in banking
  I as an admin user
  Want to register a new role
  To assign permits and restrictions to the users

  @cnr1
  Scenario Outline: Create a new role successful, verifying the message and confirming that appears the role record in the list roles
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-user" registers an new user role in banking
      | roleName   | roleDescription   | productsList   | complementsList   | permitsGroupsList   | emailUser   |
      | <roleName> | <roleDescription> | <productsList> | <complementsList> | <permitsGroupsList> | <emailUser> |
    Then "Iris-user" verifies that in the list roles appears the new role created
      | roleName   | roleDescription   | productsList   | complementsList   |
      | <roleName> | <roleDescription> | <productsList> | <complementsList> |
    Examples:
      | nit       | username  | password              | emailUser                 | roleName  | roleDescription | productsList     | complementsList | permitsGroupsList                                 |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | testAuto1 | testAuto1       | 7007,0433 , 9523 | irisPay         | resumen, Transferencias, Pagos ,PSE,configuracion |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | testAuto2 | testAuto2       | 7007             | irispay         | Transferencias,Pagos, resumen                     |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | testAuto3 | testAuto3       | 0433             | IRISPAY         | Transferencias,Pagos,Pse                          |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | testAuto4 | testAuto4       | 0433,9523        |                 | Transferencias, Pagos,Configuracion               |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | testAuto5 | testAuto5       | 7007,0433        | irispaY         | pse,transferencias,pagos                          |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | testAuto6 | testAuto6       | 7007             | irisPAY         | Transferencias,ConfiguracioN, resumen             |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | testAuto7 | testAuto7       | 0433,9523,7007   | IRISPAY         | Banca general                                     |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | testAuto8 | testAuto8       | 9523             |                 | banca general                                     |
