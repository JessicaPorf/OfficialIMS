# ProjectIMS

This is a project on Inventory Management Systems. It is a software system for tracking inventory items, orders and customers. I have included a Risk Assesment, pom.xml file and this README for the project.

## Getting Started

The live database I have used is Google Cloud Platform (GCP) with a MySQL server. You are able to run it via anyones machine.

## How to conduct software build 

* Planned project on Kanban board (Trello)
* Created database and tables on MySql
* Fetched sample code from external repository 
* Compiled the code and checked for dependencies 
* Implemented my written code
* Linked the code files accordingly
* Ran the automated unit tests
* Created UML diagram
* Risk Assesment compleated
* Uploaded it to GitHub


-- I used an incremental build approach

## Prerequisites

I needed to install Java, Maven and MySql. I had these on my localinstall however they are avaliable to download via the internet.

Java is a set of computer software and specifications; that provides a system for developing application software and deploying it in a cross-platform computing environment.

Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM). Maven can manage a project's build,reporting and documentation from a central piece of information. 

MySql is an open-source relational database management system (RDBMS). It is based on the structure query language (SQL), which is used for adding, removing and modifying information in the database.

## Running the tests

I had to push it to sonarqube to access the coverage results of a single test.
There are Maven integration tests.
Semantic Testing belongs among validation tests, with which the validity of the data input is tested. 

I used Mockito to help run my tests, it is a mocking framework. A Java based library that is used for effective unit testing of Java applications. Mockito is used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing. 

## Test analyse

I analysed my code with SonarQube. 
Initially I found 0 bugs, 66 code smells, 29.1% test coverage...
I then added tests for my services functions in my project which would have raised the test coverage somewhat significantly by around 10%; however I encountered issues when updating my project as SonarQube would not read the new tests I had made for it, so it did not carry out the function where it improved my test coverage as well as identifying some code smells in which I had corrected.

## Deployment

I have one major release, however I have pushed multiple versions of my IMS each one slightly more improved than the previous. This was me working in an Agile way. Having a quick release framework allows me to push the MVP out to customers as soon as possible. Which allows time for feedback and further improvemnt in upcoming releases. 

## Built with 
[Maven] (https://maven.apache.org)


## Other building tools I used in my project
[Violet] (http://alexdp.free.fr/violetumleditor/page.php?id=en:download)
[MySql] (https://www.mysql.com/downloads/)
[Jenkins] (https://jenkins.io)
[GitHub] (https://github.com)

## Author 
Jessica Levett 

## License
This project is licensed under the MIT License 

## Working Awknowledgements 
Hassan,
Sam, 
Ash & 
Laurence 



