# The Java framework

Java framework is a front-end framework. All components are
all hosted in GitHub repo.**

## Technologies
Project is created with:
* Java: 1.8
* Maven: 3.6.3
* Docker: 3.0.0
* K6 v0.29.0
* Selenium for Java
* IntelliJ IDEA 
* GIT

## Installation

You need to install Java, Selenium and Maven for test execution by webDriver.
For load testing you should download and install k6 and Docker.

## Documentation
How to configure installed apps:
- [Maven](https://maven.apache.org/) 
- [K6](https://k6.io/docs/getting-started/running-k6)
- [Docker](https://docs.docker.com/get-docker/)

## Project structure

Main strucure

```
.
├── driver                  # Drivers for Selenium
├── reports                 # Reports from Load testing (k6)
├── screenshots             # screenshots from schreenshotListener
├── src                     # Source files
├── test                    # Automated tests
├── testng.xml              # File for tests execution
├── pom.xml					        # Dependency and plugins
└── README.md

```

Java files location

```
/src/
├── ...
├── main                    
│   ├── core          		  # Configurations, utilities, etc.
│   ├── requests_API        # Code for API tests
│   └── ui_Layer            # Code for IU tests
│                   
└── ...
```

Test files location

```
/src/
├── ...
├── test                    
│   ├── DataDriven          # Data-Driven providers
│   ├── LoadTesting         # Load and stress tests
│   └── Tests            	  # Test files (IU and API)
│       ├── UI_Tests        # UI tests for Selenium
│       └── API             # API tests
└── ...
```

## Usage Java framework
After all apps was succesfully configured. We can start working with framework.
#### Executing tests from IDEA 
   1. Open any test in folder Test" and try to run
#### Executing tests from CMD / terminal
   1. Open CMD from testng.xml file location
   2. Execute:
   ```
   mvn test
   ```
## Usage K6 for load testing
Before working with k6 we need to start Docker.
#### Executing load testing from PowerShell
   1. Execute from script location:
```
PowerShell
cat yourScript.js | docker run -i loadimpact/k6 run -
Termianl
$ k6 run yourScript.js
or with parameters and reports
k6 run -d 30s -u 30 ./yourScript > reports log.txt
```
