Json Utils
===================

Standard Jackson Mapper that supports Java 8 and Dates/Times properly and some utilities

Current Build status: ![Travis Status](https://api.travis-ci.org/paxport/json-utils.svg?branch=master)


## Usage

    String json = JsonUtils.toJson(obj);
    
    MyType thing = JsonUtils.fromJson(json, MyType.class);
    
    String base64encodedString = JsonUtils.encode(json);
    
    MyType thing2 = JsonUtils.decode(base64encodedString, MyType.class);


## To Release new version to Bintray

    mvn clean release:prepare -Darguments="-Dmaven.javadoc.skip=true"
    mvn release:perform -Darguments="-Dmaven.javadoc.skip=true"