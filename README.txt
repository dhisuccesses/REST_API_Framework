README file for API Framework:
------------------------------

Pre-requisite steps:     
--------------------

1. Install Eclipse IDE (Preferably MARS 4.5, since all the other jars/libraries supported to setup this framework).
2. Import the project folder 'APIFramework' present inside the folder 'REST_API_Framework' into Eclipse.
3. Kindly wait for some time to load all libraries into the project.(See the download completion status in the right bottom corner of the Eclipse IDE).
4. Change the project file path with respect to the location in your machine where you placed this project folder which is present as navigated below.
         'resources' package --> 'Utils.java' file --> 'getGlobalValue' method.

Execution Steps:
----------------

1.  Modify the value of the variable 'features' of '@CucumberOptions' which can be navigated as below.
        'cucumber.Options' package -->'TestRunner.java' class --> '@CucumberOptions'
Eg., If want to execute a feature file named 'login.feature' then the value of the feature should be as below.
	features="src/test/java/features/login.feature".
2. Finally to run a feature file using Eclipse, can be done by navigating as below.
        'APIFramework' folder --> 'src/test/java' folder --> 'cucumber.Options' package --> 'TestRunner.java' class --> Right click --> Run As -->JUnit Test.



  
