@userprofiles
Feature: User profile management
  I as an admin user
  Want to manage user profiles
  To enable its access to iris web

  @userprofiles1
  Scenario Outline: create a new user and verify that user record has pending status
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" completes the form for send request access to the user
      | nameUser   | lastnameUser   | documentType   | documentNumber   | cellphone   | emailNewUser   | role   |
      | <nameUser> | <lastnameUser> | <documentType> | <documentNumber> | <cellphone> | <emailNewUser> | <role> |
    Then "Iris-User" verifies the user record in users table
      | nameUser   | lastnameUser   | role   |
      | <nameUser> | <lastnameUser> | <role> |
    Examples:
      | nit       | username  | password              | emailUser                 | nameUser          | lastnameUser     | documentType | documentNumber | cellphone  | emailNewUser                | role          |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | prueba            | sofka cinco      | Pasaporte    | 1133448        | 3124456767 | usuariosofka.05@yopmail.com | Administrador |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | prueba auto       | sofka uno        | ciudadanía   | 17788991       | 3145578909 | usuariosofka.08@yopmail.com | Administrador |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | prueba auto       | iris dos         | extranjería  | 77668899       | 3155446666 | usuariosofka.09@yopmail.com | Administrador |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | prueba automation | iris veintisiete | Pasaporte    | 11557739       | 3133334444 | usuariosofka.50@yopmail.com | Operador      |


  @userprofiles2
  Scenario Outline: Update or modify the data of an existing user
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" Update or modify the data of an user
      | nameUser   | lastnameUser   | cellphone   | emailNewUser   | role   | updateRole   |
      | <nameUser> | <lastnameUser> | <cellphone> | <emailNewUser> | <role> | <updateRole> |
    Then "Iris-User" verifies the final message of the saved data
    Examples:
      | nit       | username    | password             | emailUser                          | nameUser | lastnameUser   | cellphone  | emailNewUser         | role          | updateRole |
     # | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Robot    | Automatizacion | 3012456789 | prueba99@yopmail.com | Administrador | Operador   |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Robot    | Automatizacion | 3217873812 | usuarioautomatizacion2@yopmail.com | Operador | Administrador |