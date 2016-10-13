package com.paxport.json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeFormatTest {

    private ObjectMapper mapper = JsonMapper.defaultObjectMapper();

    @Test
    public void testLocalDateTimeSerialisation(){
        assertQuoted("2016-11-09T10:35", LocalDateTime.of(2016,11,9,10,35));
    }

    @Test
    public void testLocalDateSerialisation(){
        assertQuoted("2016-11-09", LocalDate.of(2016,11,9));
    }

    private void assertQuoted(String expected, Object obj){
        try{
            Assert.assertEquals("\"" + expected + "\"",mapper.writeValueAsString(obj));
        }
        catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

}
