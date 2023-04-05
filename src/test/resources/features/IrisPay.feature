@irispay
Feature: Manage billing, with irisPay
  I as an iris web user with access to irispay
  I want to create a new charge from irispay
  to manage the billing of an account associated to irispay.

  @irispay1
  Scenario Outline: Successfully create new billing link
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | emailUser   |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" creates a new billing link in the irispay module
      | customerName   | documentType   | documentNumber   | customerEmail   | billingConcept   | reference1   | withOrWithoutReference1   | referenceNumber1   | addReference   | reference2   | withOrWithoutReference2   | referenceNumber2   | tag   | billingDetail   | totalValue   | withOrWithoutIVA   | expirationDate   |
      | <customerName> | <documentType> | <documentNumber> | <customerEmail> | <billingConcept> | <reference1> | <withOrWithoutReference1> | <referenceNumber1> | <addReference> | <reference2> | <withOrWithoutReference2> | <referenceNumber2> | <tag> | <billingDetail> | <totalValue> | <withOrWithoutIVA> | <expirationDate> |
    Then "Iris-User" validates the final message of the link creation, successful
    Examples:
      | nit       | username    | password             | emailUser                          | customerName  | documentType         | documentNumber | customerEmail              | billingConcept       | reference1      | withOrWithoutReference1 | referenceNumber1 | addReference | reference2      | withOrWithoutReference2 | referenceNumber2 | tag          | billingDetail       | totalValue | withOrWithoutIVA | expirationDate |
      | 900800005 | adminrobot2 | *2023Automatizacion* | usuarioautomatizacion2@yopmail.com | Juanita Perez | Cédula de ciudadanía | 1098766780     | clienteiris@yopmail.com.co | concepto del cobro 1 | Factura         | NO                      | c0001            | no           |                 |                         |                  | Otros4       | Detalle del cobro 1 | 3000       | Si               | 25/02/2023     |
      | 900800005 | adminrobot1 | *2023Automatizacion* | usuarioautomatizacion1@yopmail.com | Lina Perez    | NIT                  | 123456789      | clienteiris@yopmail.com.co | concepto del cobro 2 | Sin referencia  |                         |                  |              |                 |                         |                  | Consultoría2 | Detalle del cobro 2 | 2000       | no               |                |
      | 900800005 | adminrobot2 | *2023Automatizacion* | usuarioautomatizacion2@yopmail.com | Maria Perez   | Pasaporte            | 1098766780     |                            | concepto del cobro 3 | autoreferencia1 | SI                      |                  | Si           | autoreferencia2 | SI                      |                  | Consultoría2 | Detalle del cobro 3 | 2500       | Si               | 25/02/2023     |
      | 900800005 | adminrobot1 | *2023Automatizacion* | usuarioautomatizacion1@yopmail.com | Carlos Perez  | Cédula de ciudadanía | 1098766780     | clienteiris@yopmail.com.co | concepto del cobro 4 | Factura         | NO                      | Cobro002         | Si           | autoreferencia1 | No                      | cobro1           | Otros4       | Detalle del cobro 4 | 4000       | NO               |                |

  @irispay2
  Scenario Outline: Successfully create new billing link from an invoice
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | emailUser   |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" creates a new billing link from an invoice in the irispay module
      | billingConcept   | addReference   | reference2   | withOrWithoutReference2   | referenceNumber2   | tag   | billingDetail   | expirationDate   | fileName   |
      | <billingConcept> | <addReference> | <reference2> | <withOrWithoutReference2> | <referenceNumber2> | <tag> | <billingDetail> | <expirationDate> | <fileName> |
    Then "Iris-User" validates the final message of the link creation, successful
    Examples:
      | nit       | username    | password             | emailUser                          | billingConcept | addReference | reference2      | withOrWithoutReference2 | referenceNumber2 | tag          | billingDetail | expirationDate | fileName |
      | 900800005 | adminrobot2 | *2023Automatizacion* | usuarioautomatizacion2@yopmail.com | concepto 1     | no           |                 |                         |                  | Otros4       | Detalle 1     | 01/03/2023     | factura  |
      | 900800005 | adminrobot1 | *2023Automatizacion* | usuarioautomatizacion1@yopmail.com | concepto 2     | No           |                 |                         |                  | Consultoría2 | Detalle 2     |                | factura2 |
      | 900800005 | adminrobot2 | *2023Automatizacion* | usuarioautomatizacion2@yopmail.com | concepto 3     | Si           | autoreferencia2 | SI                      |                  | Consultoría2 | Detalle 3     | 01/03/2023     | factura3 |
      | 900800005 | adminrobot1 | *2023Automatizacion* | usuarioautomatizacion1@yopmail.com | concepto 4     | Si           | autoreferencia1 | No                      | cobro1           | Otros4       | Detalle 4     |                | factura  |

