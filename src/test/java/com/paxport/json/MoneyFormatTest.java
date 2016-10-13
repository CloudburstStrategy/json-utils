package com.paxport.json;

import com.paxport.json.examples.ExampleItem;
import com.paxport.json.examples.ImmutableExampleItem;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyFormatTest {


    @Test
    public void formatTest() {
        ExampleItem item = ImmutableExampleItem.builder()
                .amount(new BigDecimal(123.456))
                .build();

        String json = JsonUtils.toJson(item);
        Assert.assertTrue(json.contains("123.46"));
    }

}
