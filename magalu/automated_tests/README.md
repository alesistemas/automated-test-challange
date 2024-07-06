# magazine luiza automated tests

Magazine Luiza web automation environment in java

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

What things you need to run the project:

* Gradle
* Java 1.8
* Cucumber plugin
* Gherkin plugin

#### Install Gradle

* Get gradle zip with gradle binary :
 * wget https://services.gradle.org/distributions/gradle-6.4.1-bin.zip -P /tmp
* Unzip :
 * sudo unzip -d /opt/gradle /tmp/gradle-*.zip
* Make sure folders where successfully created
 * ls /opt/gradle/gradle-6.4.1
 * Should see : bin getting-started.html init.d lib LICENSE media NOTICE
* Add env variables gradle in the bashrc file :
 * sudo nano ~/.bashrc (usually located in /home/username/.bashrc)
 * paste:
 - export GRADLE_HOME=/opt/gradle/gradle-6.4.1
 - export PATH=${GRADLE_HOME}/bin:${PATH}
* Reload env variables so will be available right away :
 * source ~/.bashrc
* Check that gradle 6.4.1 is installed :
 * gradle -v

#### Install java jdk + jre

sudo apt-get install default-jdk

#### install sdk packages

###Linux environment

Install and configure chromedriver on env.json file on assets folder.
* P.S.: Make sure that version of chromedriver is the same as chrome on your computer.

### Running the tests

Run the tests with minimum parameters:

#### To run a specific cucumber tag
```
gradle test -Dcucumber.options="--tags @e2e-test"
```
For each test it's generated a report in html format in the **target** folder, the file reportJava.html .

#### To run without a browser
```
xvfb-run -a gradle test -Dcucumber.options="--tags @e2e-test"
```
#### Report html on target/report path
```
google-chrome-stable reportJava.html (Linux)
start reportJava.html (Windows)
```