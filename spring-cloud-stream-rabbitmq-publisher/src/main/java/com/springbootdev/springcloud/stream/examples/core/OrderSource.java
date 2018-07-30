package com.springbootdev.springcloud.stream.examples.core;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderSource
{
    String OUTPUT = "orderPublishChannel";

    @Output(OUTPUT)
    MessageChannel create();
}
