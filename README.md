# QAAutomationTechChallenge

## Prerequisites
* \>=JDK8 installed

## Build and Run 
- Download the source code from git. 

- Build with maven.

- Right click on testng.xml and hit run. 

 ![Screenshot (1)](https://user-images.githubusercontent.com/75461516/152078926-176eba04-cbb3-4e49-ad1b-bcd5299f980d.png)
- Test cases will pick up variables from resources -> data.properties and run tests for firefox , chrome and safari. 

- Test reports are stored in reports -> ExtentReport.html. 

![Screenshot (2)](https://user-images.githubusercontent.com/75461516/152079185-25986816-bee5-489f-8da5-f07095b6faa7.png)

## About Framework 
- Framework uses page object model (POM) design pattern with class file for each web page.
- Create account test scripts for each browser ( chrome, firefox & safari) is under src -> test folder.
- TestNG annotations to control the flow of execution of test methods.
- Reporting is implemented using ExtentReports.
- Login page is created for testing only (instead of creating multiple accounts during create account testing) - ignore this file. 
