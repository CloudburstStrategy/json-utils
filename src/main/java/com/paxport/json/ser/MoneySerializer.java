package com.paxport.json.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Serialize Money correctly
 */
public class MoneySerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(format(value));
    }

    private static BigDecimal round(BigDecimal amount){
        return amount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private static String format(BigDecimal amount){
        return round(amount).toPlainString();
    }
}