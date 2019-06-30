package com.philip.studymock.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by philipl on 2019/6/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @Test
    public void getOrderSource() throws Exception {
//        Mockito.when(orderService.getOrderSource()).thenReturn("Julia");
        Mockito.when(customerService.getCustomerByNo(Mockito.anyInt())).thenReturn("Julia");
        String source = orderService.getOrderSource();
        Mockito.verify(customerService, Mockito.times(1)).getCustomerByNo(110486);
        log.info(source);
        Assert.assertTrue("Julia".equals(source));

    }

}