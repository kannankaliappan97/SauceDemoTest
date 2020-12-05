# SauceDemoTest
# How to run
* Go to the folder path where your project POM.xml resides and type
* mvn clean test -Dcucumber.options=”—tags @smoke” – This will run the scenarios which has smoke tag in the feature file
* In case of running all the scenarios from all feature files, use “mvn clean test serenity:aggregate” which will run all scenarios and produce the aggregated results.
* serenity.properties file contain the configuration for different browsers.
