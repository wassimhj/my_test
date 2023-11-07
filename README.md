# PS_testware
This repository is for the test pressented by PS Testware

To run all tests on this project please execute the following command mvn clean test
To run only the stable test use the following command 	
mvn test -Dcucumber.filter.tags="@Stable"
otherwise you can launch the tests using the TestRunner class and specify which feature file to use, the stepdefinition package, the tests with specific tags to run
