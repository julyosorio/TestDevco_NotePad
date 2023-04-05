@login
Feature: Login to the IRIS website
  I as a user of IRIS website
  Want to connect to the IRIS website
  To manage my accounts

  @login1
  Scenario Outline: Iris user successfully login to Iris website
    When The "Iris user" authenticates to the Iris website using the following credentials:
      | nit   | username   | password   | email   |
      | <nit> | <username> | <password> | <email> |
    Then "Iris user" verifies successful authenticate to the Iris website
    Examples:
      | nit       | username    | password             | email                              |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com |

  @login2
  Scenario Outline: Iris user login failed due to error in OTP code
    When The "Iris user" authenticates with wrong OTP to the Iris website with credentials:
      | nit   | username   | password   | email   | otp   |
      | <nit> | <username> | <password> | <email> | <otp> |
    Then "Iris user" shouldn't access Iris web site
    Examples:
      | nit       | username    | password             | email                              | otp    |
      | 900800005 | adminrobot2 | *2022Automatizacion* | usuarioautomatizacion1@yopmail.com | 123456 |

  @login3
  Scenario Outline: Iris user login failed due to error in credentials
    When The "Iris user" authenticates with wrong credentials to the Iris website as follows:
      | nit   | username   | password   |
      | <nit> | <username> | <password> |
    Then "Iris user" shouldn't access Iris web site, due to credential error
    Examples:
      | nit       | username    | password             |
      | 900800005 | adminrobot  | *2022Automatizacion* |
      | 900800005 | adminrobot2 |  *2022Automatizacion*  |
      | 900800006 | adminrobot2 | *2022Automatizacion* |
      | 900800006 | adminrobot2 |  *2022Automatizacion*  |

  @login4
  Scenario Outline: Iris user login succesfull by password expirated
    When "Iris user" enter expirated credentials in login page
      | nit   | username   | expiratedPass   | newPass   | email   |
      | <nit> | <username> | <expiratedPass> | <newPass> | <email> |
    Then "Iris user" verifies that system allows to change password
    When "Iris user" complete the login with the renewed password
      | nit   | username   | expiratedPass   | newPass   | email   |
      | <nit> | <username> | <expiratedPass> | <newPass> | <email> |
    Then "Iris user" verifies a successful login with the new password
    Examples:
      | nit       | username    | expiratedPass        | newPass              | email                              |
      | 900800005 | adminrobot2 | *2022Automatizacion* |  *2022Automatizacion*  | usuarioautomatizacion1@yopmail.com |

  @login5
  Scenario Outline: Iris user login failed by password expirated
    When "Iris user" tries to login with expirated password
      | nit   | username   | expiratedPass   |
      | <nit> | <username> | <expiratedPass> |
    Then "Iris user" verifies that systems requires to renew password
    Examples:
      | nit       | username   | expiratedPass         |
      | 900800005 | adminrobot  | *2022Automatizacion* |







