package com.paxport.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class JsonUtils {

    private final static ObjectMapper prettyMapper = JsonMapper.prettyPrintMapper();
    private final static ObjectMapper mapper = JsonMapper.defaultObjectMapper();

    /**
     * Convert Object to compact Json
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert Object to pretty Json
     * @param obj
     * @return
     */
    public static String toPrettyJson(Object obj) {
        try {
            return prettyMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert String Json into Object of the given type
     * @param json
     * @param targetType
     * @param <E>
     * @return
     */
    public static <E> E fromJson (String json, Class<E> targetType) {
        try {
            return mapper.readValue(json,targetType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert to Json and encode the resulting UTF-8 bytes as a Base64 string
     * @param obj
     * @return
     */
    public static String encode(Object obj) {
        try {
            String json = mapper.writeValueAsString(obj);
            byte[] bytes = json.getBytes("UTF-8");
            return Base64.getEncoder().encodeToString(bytes);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Decode from Base64 json string into required type
     * @param base64encoded
     * @param target
     * @param <E>
     * @return
     */
    public static <E> E decode(String base64encoded, Class<E> target) {
        try {
            byte[] bytes = Base64.getDecoder().decode(base64encoded);
            String json = new String(bytes, "UTF-8");
            return mapper.readValue(json,target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
