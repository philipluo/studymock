package com.philip.studymock.singles;

import com.philip.studymock.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by philipl on 2019/6/30.
 */
@RunWith(SpringRunner.class)
public class StudyRunWithSpringRunnerTest {

    @MockBean
    CustomerService customerService;

    @Test
    public void testMockBeamInSpring(){
        Mockito.when(customerService.getCustomerByNo(Mockito.anyInt())).thenReturn("Customer name");
        String name = customerService.getCustomerByNo(110486);
        Assert.assertTrue("Customer name".equals(name));

        Mockito.doReturn("Another Name").when(customerService).getCustomerByNo(Mockito.anyInt());
        String anotherName = customerService.getCustomerByNo(220486);
        assertEquals("Another Name", anotherName);
    }
}
