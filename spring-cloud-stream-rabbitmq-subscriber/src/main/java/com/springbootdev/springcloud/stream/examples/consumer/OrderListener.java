package com.springbootdev.springcloud.stream.examples.consumer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(OrderSink.class)
public class OrderListener
{
    @StreamListener(target = OrderSink.INPUT,condition = "headers['payment_mode']=='cash'")
    public void listenForCashOrder(Order order)
    {
      log.info(" received new CASH order {} ",order.toString());
    }

    @StreamListener(target = OrderSink.INPUT,condition = "headers['payment_mode']=='credit'")
    public void listenForCreditOrder(Order order)
    {
        log.info(" received new CREDIT order {} ",order.toString());
    }

    @StreamListener(target = OrderSink.INPUT,condition = "headers['payment_mode']=='cheque'")
    public void listenForChequeOrder(Order order)
    {
        log.info(" received new CHEQUE order {} ",order.toString());
    }
}
