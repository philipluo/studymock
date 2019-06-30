package com.philip.studymock.jUnit.service.singles;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.junit.Assert.*;

/**
 * Created by philipl on 2019/6/30.
 */
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class StudyBDDMockito {

    @Mock
    List<String> mockedList;

    @Test
    public void testBDDMockito() {
        given(mockedList.size()).willReturn(10);
        int size = mockedList.size();
        log.debug("size: {}", size);
        assertEquals(10, size);
        verify(mockedList, Mockito.atLeastOnce()).size();
    }


}
