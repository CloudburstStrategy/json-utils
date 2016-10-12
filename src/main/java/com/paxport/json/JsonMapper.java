package com.paxport.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class JsonMapper {

    public static ObjectMapper prettyPrintMapper() {
        ObjectMapper mapper = defaultObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }

    /**
     * Default Mapper will ignore unknown properties and not include null things
     * and will write out dates/times as human readable
     * @return
     */
    public static ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // don't break if our version of model has new things in
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // don't bother sending nulls
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        registerModules(mapper);

        // write date/times as readable strings
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper;
    }

    public static void registerModules(ObjectMapper objectMapper) {
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.registerModule(new JavaTimeModule());
    }
}
