package com.springbootdev.springcloud.stream.examples.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class Order implements Serializable
{
    @JsonProperty("order_name")
    private String orderName;
    private Float amount;
    private String status;
}
