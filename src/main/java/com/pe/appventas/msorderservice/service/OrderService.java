package com.pe.appventas.msorderservice.service;

import com.pe.appventas.msorderservice.client.CustomerServiceClient;
import com.pe.appventas.msorderservice.dto.AccountDto;
import com.pe.appventas.msorderservice.dto.OrderRequest;
import com.pe.appventas.msorderservice.entities.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private CustomerServiceClient customerClient;

    public Order createOrder(OrderRequest orderRequest){

        AccountDto account = customerClient.findAccountById(orderRequest.getAccountId());

        AccountDto dummyAccount = customerClient.createDummyAccount();
        //dummyAccount = customerClient.createAccount(dummyAccount);

        dummyAccount = customerClient.createAccountBody(dummyAccount);
        dummyAccount.getAddress().setZipCode("987987");

        customerClient.updateAccount(dummyAccount);

        AccountDto updatedAccount = customerClient.findAccountById(orderRequest.getAccountId());
        log.info(updatedAccount.toString());


        customerClient.deleteAccount(dummyAccount);

        Order order = new Order();
        order.setAccountId(orderRequest.getAccountId());
        order.setOrderId("100");
        order.setStatus("PENDING");
        order.setTotalAmount(1000.00);
        order.setTotalIgv(10.00);
        order.setTransactionDate(new Date());
        return order;
    }

    public List<Order> findAllOrder(){
        List<Order> orderList = new ArrayList();
        Order order = new Order();
        order.setAccountId("00001");
        order.setOrderId("100");
        order.setStatus("PENDING");
        order.setTotalAmount(1000.00);
        order.setTotalIgv(10.00);
        order.setTransactionDate(new Date());

        Order order2 = new Order();
        order2.setAccountId("00001");
        order2.setOrderId("100");
        order2.setStatus("PENDING");
        order2.setTotalAmount(1000.00);
        order2.setTotalIgv(10.00);
        order2.setTransactionDate(new Date());


        orderList.add(order);
        orderList.add(order2);

        return orderList;
    }

    public Order findOrderById(String orderId){
        Order order3 = new Order();
        order3.setAccountId("00001");
        order3.setOrderId("100");
        order3.setStatus("PENDING");
        order3.setTotalAmount(1000.00);
        order3.setTotalIgv(10.00);
        order3.setTransactionDate(new Date());

        return order3;
    }
}
