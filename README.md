I/ Set up environment

1/ Eclipse

- Download and install Eclipse: https://www.eclipse.org/downloads/packages/

2/ JAVA

- Download and install Java JDK: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

- Set java home: https://javatutorial.net/set-java-home-windows-10
- Project need to config is run with JRE 1.7

3/ Maven

- Download Maven: https://maven.apache.org/download.cgi

- Set Maven Home, Path: https://www.tutorialspoint.com/maven/maven_environment_setup

4/ TestNG

- Download and install testNG: https://www.toolsqa.com/selenium-webdriver/install-testng/

5/ Git

- Download and install Git: https://git-scm.com/downloads

6/ GitHub

- Register GitHub account.

- Link to clone code: https://github.com/stevenNguyen9211/shopeeTestQC.git

II/ How to run

1/ Clone the repository

● Create your workspace directory: example E:/HomeTest/workspace

● On command prompt, type the following command: cd E:/HomeTest/workspace

● For cloning, type Git clone command: git clone https://github.com/stevenNguyen9211/homeTest.git Or download zip from the same above address

2/ Import in Eclipse workspace

● In the Eclipse menu, choose File => Import

● In Maven section select Existing Maven Projects

● Click on Next > button. The next screen Import projects appears

● Click Browse... button to locate gobear_automation_test project

● Click on Finish button to import

3/ Execution

● Open the folder execution and run the xml file. You can both run test with parallel or single mode with correspondingly suite: runSingleTest.xml and runParallelTest.xml
● Make sure you download the newest Chrome browser to fit the chromedriver which we are using at this time we create the project.
