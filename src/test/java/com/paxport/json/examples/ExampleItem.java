package com.paxport.json.examples;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paxport.json.ser.MoneySerializer;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.math.BigDecimal;

@Value.Immutable
@Serial.Structural
@JsonSerialize(as = ImmutableExampleItem.class)
@JsonDeserialize(as = ImmutableExampleItem.class)
public abstract class ExampleItem {

    @Value.Parameter
    @JsonSerialize(using = MoneySerializer.class)
    public abstract BigDecimal getAmount();

}
