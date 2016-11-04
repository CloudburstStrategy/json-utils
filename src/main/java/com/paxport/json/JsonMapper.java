package com.paxport.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Default Jackson Mappers which handle Java 8 stuff nicely
 *
 *
 */
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
        objectMapper.registerModule(javaTimeModule());
        objectMapper.registerModule(new GuavaModule());
    }

    private static JavaTimeModule javaTimeModule(){
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
        return module;
    }
}
