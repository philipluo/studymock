package com.philip.studymock.jUnit.service;

import com.philip.studymock.service.OrderService;
import com.philip.studymock.util.StaticHelper;
import lombok.extern.slf4j.Slf4j;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by philipl on 2019/6/30.
 * Study how to mock a static method by jmockit
 * from:
 * https://www.baeldung.com/jmockit-static-method
 * https://www.jianshu.com/p/c76b8cdba30d
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTestbyBddMockito {

    @Autowired
    OrderService orderService;

    @Test
    public void testGetOrderSource(){
        //mock static method in StaticHelper.getRandomInteger, which is called by CustomerService
        new MockUp<StaticHelper>() {
            @Mock
            public Integer getRandomInteger(){
                return 12345;
            }
        };

        Integer custNo = 110486;
        String source = orderService.getOrderSourceByCustNo(custNo);
        log.info("---->{}", source);
        assertEquals(source,"12345-SYNNEX DEMO");
    }
}
