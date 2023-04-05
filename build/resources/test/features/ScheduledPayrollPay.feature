@spp
Feature: Scheduled payroll pay
  I as Iris User
  Want to do a scheduled payroll pay in banking
  To verify its status

  @spp1
  Scenario Outline: Complete successfully a scheduled payroll pay, verifying the pay in process message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "payroll" menu and completes the payroll pay transaction with scheduled date
      | emailUser   | originAccountNumber   | payId   | executeDate   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <executeDate> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies the message that indicates the scheduled payroll pay is in process is showed
      | quantity   | payValue   |
      | <quantity> | <payValue> |
    Examples:
      | nit       | username    | password             | emailUser                          | originAccountNumber | payId       | executeDate | tag    | quantity | destinationBank  | destinationAccountNumber | payValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | PagoN190101 | 20/01/2023  | Nomina | 3        | Banco Davivienda | 6678                     | 400.02   |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | PagoN190102 | 21/01/2023  | Nomina | 2        | Bancamia S.A     | 1536                     | 10.55    |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 7007                | PagoN190103 | 22/01/2023  | Nomina | 1        | Iris             | 7983                     | 2.99     |

  @spp2
  Scenario Outline: Scheduled payroll payment successful, verifying the record in the scheduled table for payments.
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" searches in the programmed table for the payroll payment with the following data
      | payId   | payType   | tag   | quantity   | executeDate   | payValue   |
      | <payId> | <payType> | <tag> | <quantity> | <executeDate> | <payValue> |
    Then "Iris-User" verifies that the payroll record information in the programmed table is correct.
    Examples:
      | nit       | username    | password             | emailUser                          | payId       | payType         | tag    | quantity | executeDate | payValue |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | PagoN190101 | Manuales:Nomina | Nomina | 3        | 20/01/2023  | 400.0    |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | PagoN190102 | Manuales:Nomina | Nomina | 2        | 21/01/2023  | 10.55    |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | PagoN190103 | Manuales:Nomina | Nomina | 1        | 22/01/2023  | 2.99     |