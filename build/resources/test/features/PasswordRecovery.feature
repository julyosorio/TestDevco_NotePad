@password_recovery
Feature: Password recovery
  I as an automator
  Requires to realizate the automation of the forgot password route
  To diminish the test execution time and detect early errors that may occur for the app deployment

  @password_recovery1
  Scenario Outline: As "iris-user" requires to recovery password succesfully
    Given "iris-user" goes to the login page
    When "iris-user" performs successful password change
      | nit   | documentUser   | username   | email   | password   |
      | <nit> | <documentUser> | <username> | <email> | <password> |
    Then "iris-user" verifies the successfull password change message
    When "iris-user" complete the login with the new credentials
      | nit   | username   | password   | email   |
      | <nit> | <username> | <password> | <email> |
    Then "iris-user" verifies a successful login with the new password
    Examples:
      | nit       | documentUser | username | email                            | password            |
      | 111111103 | 12345678     | irisUser | iris.auto.test.oc.01@yopmail.com | UserTestAutomation* |

  @password_recovery2
  Scenario Outline: As "iris-user" requires to verify the password recovery failed in user data form
    Given "iris-user" goes to the login page
    When "iris-user" tries to recover password with fail data
      | scenario   | nit   | documentUser   | username   | email   |
      | <scenario> | <nit> | <documentUser> | <username> | <email> |
    Then "iris-user" verifies the error message showed "<scenario>"
    Examples:
      | scenario                      | nit        | documentUser | username      | email                             |
      | non-existant user             | 111111103  | 12345678     | userIrisAut07 | iris.auto.test.oc.01@yopmail.com  |
      | email without @               | 111111103  | 12345678     | irisUser      | iris.auto.test.oc.01              |
      | email without domain          | 111111103  | 12345678     | irisUser      | iris.auto.test.oc.01@             |
      | email with incomplete domain  | 111111103  | 12345678     | irisUser      | iris.auto.test.oc.01@.com         |
      | non-existant nit              | 0123456701 | 12345678     | irisUser      | iris.auto.test.oc.01@yopmail.com  |
      | empty fields                  |            |              |               |                                   |
      | email and user don't match    | 111111103  | 12345678     | irisUser      | iris.auto.test.sr.01@yopmail.com  |
      | user and nit don't match      | 111111105  | 12345678     | irisUser      | iris.auto.test.oc.01@yopmail.com  |
      | document and user don't match | 111111103  | 12345669     | irisUser      | iris.auto.test.oc.01@yopmail.com  |
      | without nit                   |            | 12345678     | irisUser      | iris.auto.test.oc.01@yopmail.com  |
      | without document              | 111111103  |              | irisUser      | iris.auto.test.oc.01@yopmail.com  |
      | without user                  | 111111103  | 12345678     |               | iris.auto.test.oc.01@yopmail.com  |
      | without email                 | 111111103  | 12345678     | irisUser      |                                   |
