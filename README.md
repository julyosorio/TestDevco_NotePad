#IRIS SERVICES

##The following automation tools are used in this project:

- Java SDK version 11.0.15
- Gradle wrapper vesion 7.4.1
- Serenity BDD version 3.2.5
- Rest Assured version 3.2.5
- Cucumber version 3.2.5
- Log4j version 2.17.2


##Description of packages used in the project, for this project the Screenplay desing pattern was used 

- **Tasks:** Interaction groups to complete an objective implemented by an actor.
- **Interactions:** Single action implemented by an actor to achieve a task.
- **Models:** Base classes to map and transfer information according to the requirements.
- **Questions:** specific interactions to ensure that the test results are correct.
- **Utils:** Methods and classes that are not provided by Serenity  to operate test data.
- **Integrations:** Implemented connections with third party systems like external databases.
- **Exceptions:** Exceptions according to specific rules not included with Serenity.
- **Runners:** Communication classes between Cucumber features and step definition where the
communication rules are defined
- **Step Definitions:** Where the tasks, questions and others are integrated to programatically execute  a given feature.
- **Features:** Functional descriptions in Gherkin language (Behaviour Driven Development)
- **Files:** Automation specifically required files.
- **Log:** Program execution information files.