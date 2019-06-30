package com.philip.studymock.testNg.service;

import com.philip.studymock.testNg.BaseTestByTestNG;
import com.philip.studymock.service.OrderService;
import com.philip.studymock.util.StaticHelper;
import lombok.extern.slf4j.Slf4j;
import mockit.Mock;
import mockit.MockUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by philipl on 2019/6/30.
 * Study how to mock a static method by jmockit
 * from:
 * https://www.baeldung.com/jmockit-static-method
 * https://www.jianshu.com/p/c76b8cdba30d
 */
@Slf4j
public class OrderServiceTestByTestNG extends BaseTestByTestNG{

    @Autowired
    OrderService orderService;

    @Test
    public void testGetOrderSource(){
        //mock static method in StaticHelper.getRandomInteger, which is called by CustomerService
        new MockUp<StaticHelper>() {
            @Mock
            public Integer getRandomInteger(){
                return 23456;
            }
        };
        Integer custNo = 110486;
        String source = orderService.getOrderSourceByCustNo(custNo);
        log.info("---->{}", source);
        assertEquals(source,"23456-SYNNEX DEMO");
    }
}
