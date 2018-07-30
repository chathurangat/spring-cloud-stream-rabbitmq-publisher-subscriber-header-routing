package com.springbootdev.springcloud.stream.examples.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@EnableBinding(OrderSource.class)
@RestController
public class OrderController
{
    @Autowired
    private OrderSource source;

    @PostMapping("/orders/publish")
    public String publishOrder(@RequestBody Order order, @RequestParam("payment_mode") String paymentMode)
    {
        source.create().send(MessageBuilder.withPayload(order).setHeader("payment_mode",paymentMode).build());
        log.info(order.toString());
        return "order_published";
    }
}