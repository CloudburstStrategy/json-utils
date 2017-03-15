package com.cloudburst.json.examples;

import com.cloudburst.json.ser.MoneySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.math.BigDecimal;

@Value.Immutable
@Serial.Structural
public abstract class ExampleItem {

    @Value.Parameter
    @JsonSerialize(using = MoneySerializer.class)
    public abstract BigDecimal getAmount();

}
