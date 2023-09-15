Account-Service Backend
--
A Spring boot microservice project which takes the account details and save in mysql database.

Prerequisites
--
## Install Java on Ubuntu 22.04
### Update & Upgrade pkgs
``` sudo apt update && apt upgrade ```
### Install java
``` sudo apt install openjdk-17-jdk ```
### Check java version 
``` java --version ```

## Install Maven
### Download maven 
``` wget https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz ```
### Exract the file 
``` tar -xvf apache-maven-*-bin.tar.gz ```
### Move it to /usr/share/
``` sudo mv apache-maven-3.8.5 /usr/share/maven ```
###  Add the Maven folder to the System path
``` echo 'export PATH="$PATH:/usr/share/maven"' >> ~/.bashrc
    echo 'export PATH="$PATH:/usr/share/maven/bin"' >> ~/.bashrc
```
### Reload Bash profile
``` source ~/.bashrc ``` 

### Check the MVN version
``` mvn -v ```

How to Download and use the application
--
### Git clone the project using 
``` https://github.com/pavankumar0077/Client-Server-Vnc-Project.git ```
### Use any IDE like STS or Eclipse download link is here
``` https://download.springsource.com/release/STS4/4.19.1.RELEASE/dist/e4.28/spring-tool-suite-4-4.19.1.RELEASE-e4.28.0-linux.gtk.x86_64.tar.gz ```
### Import and Run the application (GUI)
1) Select File (Top-left corner) --> Select Open Projects from file system --> Select file path using Directory option --> and Click on Finish
2) Right click on the project --> Run as -->  Spring boot application

### Run the application using CLI
```
1) Go the path where application is clone and cd to Account-Service/
2) To build the package(jar file) use this command ``` mvn package ``` or ``` mvn clean install ```
3) Go to target folder in which is available at the root folder ``` cd target ```
4) 1st way : To Run the application If maven is installed then use ``` mvn spring-boot:run``` in the root folder
5) 2nd way : Use ``` ./mvnw spring-boot:run ``` if maven is not installed in the root folder
6) 3rd way : cd to target folder and run ```java -jar Account-Service-0.0.1-SNAPSHOT.jar ```
```
### How to test the application

**Post Request to create account**

_Endpoint_ : ``` http://192.168.138.156:9901/api/accounts/createAccount ```

_curl --location 'http://192.168.138.156:9901/api/accounts/createAccount' \
--header 'Content-Type: application/json' \
--data '{
 "accountNum":101010,
 "accountType":"Savings",
 "accountOpeningDate":"1995-02-24",
 "balance":9563.2
}'_

**Output**
```
{
    "accountNum": 101011,
    "accountType": "Savings",
    "accountOpeningDate": "2019-08-25",
    "balance":"98562"
}
```


**Get Request to get all accounts**

_Endpoint_ : http://192.168.138.156:9901/api/accounts/accounts

_curl --location 'http://192.168.138.156:9901/api/accounts/accounts'_

**Output**
```
[
    {
        "accountNum": 101010,
        "accountType": "Savings",
        "accountOpeningDate": "2019-02-12",
        "balance": 10000.0
    }
]
```

**Get Request to get specific account**

_Endpoint_ : http://192.168.138.156:9901/api/accounts/101010

_curl --location 'http://192.168.138.156:9901/api/accounts/101010'_

**Output**

```
{
    "accountNum": 101010,
    "accountType": "Savings",
    "accountOpeningDate": "2019-02-12",
    "balance": 10000.0
}
```






