package com.philip.studymock;

import com.philip.studymock.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudymockApplicationTests {

	@Autowired
	OrderService orderService;

	@Test
	public void contextLoads() {
		orderService.getOrderSource();
	}

	@Test
	public void whenNotUseMockAnnotation_thenCorrect() {
		List mockList = Mockito.mock(ArrayList.class);

		mockList.add("one");
		Mockito.verify(mockList).add("one");
		assertEquals(0, mockList.size());

		Mockito.when(mockList.size()).thenReturn(100);
		assertEquals(100, mockList.size());
	}

}
