# Gender Detection

Gender Detection in an application for detect gender by providing list of names.


##Instalation

To create Jar file please use below commends:
```bash
mvn clean package
```

To run Jar file please use command below:

```bash
java -jar “<path>\gender_detection-0.0.1-SNAPSHOT.jar”
```

## Description

Application is written in Java and using Spring Boot. You can detect list of names in two ways: first one will return "Male" or "Female" based on just first of the names that you provided. Endpoint to first method is shown below:




```bash
http://localhost:8080/detect/byone
```
When you want to check all of the names and find out if more of them are male or female use second endpoint:

```bash
http://localhost:8080/detect/byall
```
Method will check all of provided names and return "Male" if number of male names is greater then female. It will return "Female otherwise. If occurence of both male and female names is the same method will return "INCONCLUSIVE".

**Please be informed that both endpoints accept only strings. Please divide names with comma.**

All of the names can be seen using below endpoints:

```bash
http://localhost:8080/tokens/male
http://localhost:8080/tokens/female
```

Files with tokens are stored in "resources".

##Usage
```bash
{"Leo, Ava, Aria"} 
Post method to http://localhost:8080/detect/byone # wil return "Male"

{"Leo, Ava, Aria"} 
Post method to http://localhost:8080/detect/byall # wil return "Female"
```

##Author

Piotr Boczar
