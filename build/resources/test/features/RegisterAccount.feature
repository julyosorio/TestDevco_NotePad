@regAccount
Feature: Register an account with the bank iris
  I as an Iris User
  Want to register an account in the "Registered accounts" option in the banking system
  To then be able to make transactions to that registered account

  @regAccount1
  Scenario Outline: Register account of other banks
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" registers an account of other banks in the menu registered accounts
      | ownerDestinationAccount   | destinationBank   | docTypeDestinationAccount   | docNumDestinationAccount   | destinationAccountType   | destinationAccountNumber   | emailSubsAccount   | descriptionSubsAccount   | requiresSaveSubscription   |
      | <ownerDestinationAccount> | <destinationBank> | <docTypeDestinationAccount> | <docNumDestinationAccount> | <destinationAccountType> | <destinationAccountNumber> | <emailSubsAccount> | <descriptionSubsAccount> | <requiresSaveSubscription> |
    Then "Iris-User" verifies the new account registration pop-up message for other banks
    Examples:
      | nit       | username    | password             | emailUser                          | destinationBank   | ownerDestinationAccount | emailSubsAccount   | docTypeDestinationAccount | docNumDestinationAccount | destinationAccountType | destinationAccountNumber | descriptionSubsAccount | requiresSaveSubscription |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Banco Caja Social | salome rojas            | salome@yopmail.com | Cédula de extranjería     | 1104780                  | Cuenta de ahorros      | 30016809182              | cuenta 3               | NO                       |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | Banco AV Villas   | salome rojas            | salome@yopmail.com | Cédula de ciudadanía      | 1104789650               | Cuenta de ahorros      | 30016809182              | cuenta 4               | SI                       |


  @regAccount2
  Scenario Outline: Register of iris account
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" registers an iris account in the menu registered accounts
      | destinationAccountNumber   | requiresSaveSubscription   | descriptionSubsAccount   | emailSubsAccount   |
      | <destinationAccountNumber> | <requiresSaveSubscription> | <descriptionSubsAccount> | <emailSubsAccount> |
    Then "Iris-User" verifies the new account registration pop-up message for iris accounts
    Examples:
      | nit       | username    | password             | emailUser                          | destinationAccountNumber | requiresSaveSubscription | descriptionSubsAccount     | emailSubsAccount         |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 100282154462             | Si                       | LA SUPER ELECTRODOMÉSTICOS | laSuper@electrohogar.com |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 100488918858             | NO                       | TIENDA MASKOTIKS           | maskotik4s@gmail.com     |


  @regAccount3
  Scenario Outline: Delete registered account
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" deletes an registered account from the table of registered accounts
      | destinationAccountNumber   |
      | <destinationAccountNumber> |
    Then "Iris-User" verifies the pop-up message to delete the registered account
    Examples:
      | nit       | username    | password             | emailUser                          | destinationAccountNumber |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 123456987                |


  @regAccount4
  Scenario Outline: Update registered account
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" updates the data of a registered account from the table of registered accounts
      | destinationAccountNumber   | requiresSaveSubscription   | descriptionSubsAccount   | emailSubsAccount   |
      | <destinationAccountNumber> | <requiresSaveSubscription> | <descriptionSubsAccount> | <emailSubsAccount> |
    Then "Iris-User" verifies the pop-up message for successful update of  registered account
    Examples:
      | nit       | username    | password             | emailUser                          | destinationAccountNumber | requiresSaveSubscription | descriptionSubsAccount | emailSubsAccount   |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 100282154462             | NO                       | update ctaIris 2       | testaa@yopmail.com |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion2@yopmail.com | 0018876678               | SI                       | update ctaOtros        | testb@yopmail.com  |

