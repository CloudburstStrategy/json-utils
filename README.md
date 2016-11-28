Json Utils
===================
![Travis Status](https://api.travis-ci.org/paxport/json-utils.svg?branch=master)

Standard Jackson Mapper that supports Java 8 and Dates/Times properly and some utilities

## Usage

    String json = JsonUtils.toJson(obj);
    
    MyType thing = JsonUtils.fromJson(json, MyType.class);
    
    String base64encodedString = JsonUtils.encode(json);
    
    MyType thing2 = JsonUtils.decode(base64encodedString, MyType.class);


## To Release new version to Bintray

    mvn clean release:prepare -Darguments="-Dmaven.javadoc.skip=true"
    mvn release:perform -Darguments="-Dmaven.javadoc.skip=true"