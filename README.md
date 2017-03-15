Json Utils
==========
<a href="https://travis-ci.org/CloudburstStrategy/json-utils" target="_blank"><img src="https://api.travis-ci.org/CloudburstStrategy/json-utils.svg?branch=master"/></a>

Standard Jackson Mapper that supports Java 8 and Dates/Times properly and some utilities


## Usage

    String json = JsonUtils.toJson(obj);
    
    MyType thing = JsonUtils.fromJson(json, MyType.class);
    
    String base64encodedString = JsonUtils.encode(json);
    
    MyType thing2 = JsonUtils.decode(base64encodedString, MyType.class);


## To Release new version to Bintray

    mvn clean release:prepare -Darguments="-Dmaven.javadoc.skip=true"
    mvn release:perform -Darguments="-Dmaven.javadoc.skip=true"