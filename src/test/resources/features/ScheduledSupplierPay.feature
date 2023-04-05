@ssp
Feature: Scheduled supplier pay
  I as Iris User
  Want to do a scheduled supplier pay in banking
  To verify its status

  @ssp1
  Scenario Outline: Complete successfully a scheduled supplier pay, verifying the pay in process message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "supplier" menu and completes the supplier pay transaction with scheduled date
      | emailUser   | originAccountNumber   | payId   | executeDate   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <executeDate> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies the message that indicates the scheduled supplier pay is in process is showed
      | quantity   | payValue   |
      | <quantity> | <payValue> |
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | payId      | executeDate | tag         | quantity | destinationBank  | destinationAccountNumber | payValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | PagoP190101 | 20/01/2023  | Consultoría | 1        | Banco Davivienda | 6678                     | 1.02     |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | PagoP190102 | 21/01/2023  | Consultoría | 2        | Bancamia S.A     | 1536                     | 2.31     |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | PagoP190103 | 22/01/2023  | Consultoría | 4        | Iris             | 7983                     | 1000.02  |


  @ssp2
  Scenario Outline: Successful scheduled supplier payment, verifying the record in the scheduled payment table.
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches in the scheduled table for the payment to suppliers with the following data
      | payId   | payType   | tag   | quantity   | executeDate   | payValue   |
      | <payId> | <payType> | <tag> | <quantity> | <executeDate> | <payValue> |
    Then "Iris-User" verifies that the supplier payment record information in the programmed table is correct.
    Examples:
      | nit       | username    | password             | emailUser                          | payId      | payType              | tag         | quantity | executeDate | payValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | PagoP190101 | Manuales:Proveedores | Consultoría | 1        | 20/01/2023  | 1.02     |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | PagoP190102 | Manuales:Proveedores | Consultoría | 2        | 21/01/2023  | 2.31     |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | PagoP190103 | Manuales:Proveedores | Consultoría | 4        | 22/01/2023  | 1000.02  |