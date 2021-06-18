# JSON Parser Utility

Project Description :

This Project is create the different utilities for data Parsing from API's using Java Gson library in Maven Project

## Maven
Maven is a software project management and build management tool for Java Framework.

## JUnit
Junit is a unit testing framework used to write and run repeatable automated tests. 

## Java Gson library
Gson is a Java serialization/deserialization library to convert Java Objects into JSON and back. Gson was created by Google for internal use and later open sourced.



*********************************************************************************************************************************

## Instructions

API used in Framework : 
- https://cdn-api.co-vin.in/api/v2/admin/location/districts/16
- http://time.jsontest.co
- https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding
- https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing


To Run the Tests in either of below ways :
- mvn test 
- junit Tests
- Run App.java


*********************************************************************************************************************************

## Java Gson library Methods

- The toJson() method serializes the specified object into its equivalent JSON representation.
- The fromJson() method deserializes the specified JSON into an object of the specified class.
- GsonBuilder builds Gson with various configuration settings. GsonBuilder follows the builder pattern, and it is typically used by first invoking various configuration methods to set desired options, and finally calling create().
- Gson has two output modes: compact and pretty. 
  // Gson gson = new GsonBuilder().setPrettyPrinting().create()
- Gson by default does not serialize fields with null values to JSON. If a field in a Java object is null, Gson excludes it. We can force Gson to serialize null values via the GsonBuilder by using serializeNulls() method.
- @Expose annotation indicates that a member should be exposed for JSON serialization or deserialization. 
The @Expose annotation can take two boolean parameters: serialize and deserialize. The @Expose annotation must be explicitly enabled with excludeFieldsWithoutExposeAnnotation() method.

Reference NOTE : https://zetcode.com/java/gson/