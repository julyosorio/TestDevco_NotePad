@oppia
Feature: Online payroll pay between iris accounts
  I as an Iris User
  Want to do an online payroll pay transaction
  To verify status of payments done

  @oppia1
  Scenario Outline: Online payroll pay, verifying if the value pay entered was valid
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" enters the pay value for manual current payroll pay
      | emailUser   | originAccountNumber   | payId   | tag   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <tag> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies if the value entered for manual payroll pay is correct
      | payValue   |
      | <payValue> |

    Examples:
      | nit       | username  | password              | emailUser                 | originAccountNumber | payId    | tag        | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 0433                | testPP01 | PagoNomina | Iris            | 0870                     | 0.99     |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | testPP03 | PagoNomina | Iris            | 0870                     | 0.01     |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 0433                | testPP03 | PagoNomina | Iris            | 0870                     | 1.00     |

  @oppia2
  Scenario Outline: Online payroll pay between iris accounts, verifying the pay in process message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "payroll" menu and completes the payroll pay transaction with current date
      | emailUser   | originAccountNumber   | payId   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies the message that indicates the payroll manual pay is in process is showed
      | quantity   | payValue   |
      | <quantity> | <payValue> |

    Examples:
      | nit       | username  | password              | emailUser                 | originAccountNumber | payId     | tag         | quantity | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | irisCF01  | PagoNomina  | 2        | Iris            | 4824                     | 5000.00  |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 0433                | payNomin6 | Nomina      | 2        | Iris            | 4824                     | 1000.33  |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | payNomin7 | PagoNomIris | 3        | Iris            | 4824                     | 1.59     |

  @oppia3
  Scenario Outline: Online payroll pay between iris accounts, verifying the pay register in payments and batches historic table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" looks for the recent payroll manual pay record in the payments and batches historic table
      | tag   |
      | <tag> |
    Then "Iris-User" verifies that the data of payroll payment  manual record found in historic table is correct
      | payId   | quantity   | tag   | payValue   |
      | <payId> | <quantity> | <tag> | <payValue> |
    Examples:
      | nit       | username  | password              | emailUser                 | payId            | quantity | tag         | payValue |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | sofkaPayrollPay5 | 2        | Nomina      | 1000.33  |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | sofkaPayrollPay6 | 3        | PagoNomIris | 1.59     |

  @oppia4
  Scenario Outline: Save successfully an online payroll payment to use this pay in the future
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "payroll" menu and save the payroll pay transaction with current date
      | emailUser   | originAccountNumber   | payId   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-user" verifies the payroll pay saved successfull message

    Examples:
      | nit       | username    | password              | emailUser                 | originAccountNumber | payId          | tag        | quantity | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | userAutho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | pagoNominahS10 | PagoNomina | 50       | Bogotá          | 9411                     | 269.63   |
      | 900800005 | userAutho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | pagoNominaS2   | Nomina     | 8        | Iris            | 7983                     | 35.96    |
      | 900800005 | userAutho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | pagoNominaS3   | PagoNomina | 3        | BBVA            | 5987                     | 269.63   |
      | 900800005 | userAutho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | pagoNominaS4   | Nomina     | 2        | Iris            | 7983                     | 35.96    |

  @oppia5
  Scenario Outline: Validate payroll pay record in payments saved table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" looks for the record correct of payroll pay in saved payments table
      | payId   |
      | <payId> |
    Then "Iris-User" verifies the information present in the record payroll pay found
      | payId   | createDate   | quantity   | payValue   | tag   |
      | <payId> | <createDate> | <quantity> | <payValue> | <tag> |

    Examples:
      | nit       | username  | password              | emailUser                 | payId           | createDate | quantity | payValue | tag        |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | edjkgitpwlx1021 | 07/12/2022 | 50       | 35.96    | Nomina     |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | paySaved9       | 07/12/2022 | 50       | 35.96    | Nomina     |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | r45             | 14/09/2022 | 1        | 34.34    | Otros      |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoNominaS1    | 14/12/2022 | 3        | 269.63   | PagoNomina |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoNominaS2    | 14/12/2022 | 2        | 35.96    | Nomina     |

  @oppia6
  Scenario Outline: Delete payroll pay from payments saved table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" looks for the payroll pay in the saved payments table and delete it
      | payId   |
      | <payId> |
    Then "Iris-User" verifies that payroll payment was deleted successfull

    Examples:
      | nit       | username  | password              | emailUser                   | payId        |
      | 900800005 | usertrx01 | UserTestAutomation01* | iris.auto.au.01@yopmail.com | pagoNominaS6 |
      | 900800005 | usertrx01 | UserTestAutomation01* | iris.auto.au.01@yopmail.com | pagoNominaS1 |


