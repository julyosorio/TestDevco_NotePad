@categorymanager
Feature: Manage the categories in the digital bank
  I as iris user
  Want to manage the categories
  To create,edit, list, delete it

  @categorymanager1
  Scenario Outline: Create a new category successfully
    Given The "Iris-User" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email       |
      | <nit> | <username> | <password> | <emailUser> |
    When "Iris-User" completes the category creation form
      | categoryName   | tagsList   | numberCategoryColor   |
      | <categoryName> | <tagsList> | <numberCategoryColor> |
    Then "Iris-User" verifies that message the category  created successful was showed

    Examples:
      | nit       | username    | password              | emailUser                 | categoryName     | tagsList                                                               | numberCategoryColor |
      | 900800005 | userautho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | consultoriaTrx   | Consultoría2,cuentasIris,ctasPropias                                   | 11                  |
      | 900800005 | userautho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | pagosCuentasIris | PagoNomIris,PagoProv,PagoProvIris,PaySupplier,ProveedorPag,otrosBancos | 10                  |
      | 900800005 | userautho01 | UserTestAutomation01* | usuariotrx.01@yopmail.com | otrosTrxIris     | PRUEBA NOMIN,Otros2,Otros3, Empresa Iris, Consultoría3                 | 5                   |
      | 900800005 | usertrx01   | UserTestAutomation01* | usuariotrx.01@yopmail.com | consultaSaldos   |                                                                        | 7                   |