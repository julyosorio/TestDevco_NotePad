@ospia
Feature: Online supplier pay between iris accounts
  I as an Iris User
  Want to do an online supplier pay transaction
  To verify status of payments done

  @ospia1
  Scenario Outline: Online supplier pay, verifyng if the value pay entered was valid
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" enters the pay value for manual current supplier pay
      | emailUser   | originAccountNumber   | payId   | tag   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <tag> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies if the value entered for manual supplier pay is correct
      | payValue   |
      | <payValue> |

    Examples:
      | nit       | username  | password              | emailUser                 | originAccountNumber | payId    | tag      | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 0433                | testPS01 | PagoProv | Iris            | 0870                     | 0.99     |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | testPS03 | PagoProv | Iris            | 0870                     | 0.01     |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 0433                | testPS03 | PagoProv | Iris            | 0870                     | 1.00     |


  @ospia2
  Scenario Outline: Online supplier pay between iris accounts, verifying the pay in process message
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "supplier" menu and completes the supplier pay transaction with current date
      | emailUser   | originAccountNumber   | payId   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-User" verifies the message that indicates the supplier manual pay is in process is showed
      | quantity   | payValue   |
      | <quantity> | <payValue> |

    Examples:
      | nit       | username  | password              | emailUser                 | originAccountNumber | payId             | tag         | quantity | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 0433                | testProv01        | PagoProv    | 2        | Iris            | 7983                     | 5000.00  |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | sofkaProveed1     | PagoProv    | 4        | Iris            | 7983                     | 1000.74  |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 0433                | sofkaSupplierPay2 | Proveedores | 3        | Iris            | 0870                     | 30.58    |


  @ospia3
  Scenario Outline: Online supplier pay between iris accounts, verifying the pay register in payments and batches historic table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" looks for the recent supplier manual pay record in the payments and batches historic table
      | tag   |
      | <tag> |
    Then "Iris-User" verifies that the data of supplier payment manual record found in historic table is correct
      | payId   | quantity   | tag   | payValue   |
      | <payId> | <quantity> | <tag> | <payValue> |

    Examples:
      | nit       | username  | password              | emailUser                 | payId             | quantity | tag         | payValue |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | sofkaSupplierPay1 | 4        | PagoProv    | 1000.74  |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | sofkaSupplierPay2 | 3        | Proveedores | 30.58    |


  @ospia4
  Scenario Outline: Save successfully an online supplier payment to use this pay in the future
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" goes to "supplier" menu and save the supplier pay transaction with current date
      | emailUser   | originAccountNumber   | payId   | tag   | quantity   | destinationBank   | destinationAccountNumber   | payValue   |
      | <emailUser> | <originAccountNumber> | <payId> | <tag> | <quantity> | <destinationBank> | <destinationAccountNumber> | <payValue> |
    Then "Iris-user" verifies the supplier pay saved successfull message

    Examples:
      | nit       | username  | password              | emailUser                 | originAccountNumber | payId            | tag         | quantity | destinationBank | destinationAccountNumber | payValue |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 9523                | pagoSupplierP10  | PagoProv    | 8        | Bogotá          | 9411                     | 839.43   |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | pagoProveedorD10 | Proveedores | 9        | Iris            | 7983                     | 44.67    |
      | 900800005 | userTrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | 7007                | pagoProveedorD11 | PagoProv    | 10       | AV Villas       | 9182                     | 839.43   |

  @ospia5
  Scenario Outline: Validate supplier pay record in payments saved table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" looks for the record correct of supplier pay in saved payments table
      | payId   |
      | <payId> |
    Then "Iris-User" verifies the information present in the record supplier pay found
      | payId   | createDate   | quantity   | payValue   | tag   |
      | <payId> | <createDate> | <quantity> | <payValue> | <tag> |

    Examples:
      | nit       | username  | password              | emailUser                 | payId              | createDate | quantity | payValue | tag         |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | sfffasjaskak223248 | 12/12/2022 | 50       | 44.67    | Proveedores |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | paySavedSupplier4  | 12/12/2022 | 50       | 44.67    | Proveedores |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | paySavedSupplier1  | 09/12/2022 | 3        | 839.43   | PagoProv    |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoProveedorS1    | 15/12/2022 | 3        | 839.43   | PagoProv    |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoProveedorS2    | 15/12/2022 | 2        | 44.67    | Proveedores |
      | 900800005 | usertrx01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagoProveedorD3    | 12/01/2023 | 3        | 839.43   | PagoProv    |


  @ospia6
  Scenario Outline: Delete supplier pay from payments saved table
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" looks for the supplier pay in the saved payments table and delete it
      | payId   |
      | <payId> |
    Then "Iris-User" verifies that supplier payment was deleted successfull

    Examples:
      | nit       | username  | password              | emailUser                   | payId             |
      | 900800005 | usertrx01 | UserTestAutomation01* | iris.auto.au.01@yopmail.com | paySavedSupplier1 |
      | 900800005 | usertrx01 | UserTestAutomation01* | iris.auto.au.01@yopmail.com | pagoProveedorD3   |



