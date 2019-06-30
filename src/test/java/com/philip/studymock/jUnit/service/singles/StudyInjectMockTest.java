package com.philip.studymock.jUnit.service.singles;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by philipl on 2019/6/30.
 */
@RunWith(MockitoJUnitRunner.class)
public class StudyInjectMockTest {

    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionary myDictionary;

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect(){
        Mockito.when(wordMap.get("aWorld")).thenReturn("aMeaning");
        Assert.assertEquals("aMeaning", myDictionary.getMeaning("aWorld"));
    }


}


class MyDictionary {
    Map<String, String> wordMap;

    public MyDictionary() {
        wordMap = new HashMap<String, String>();
    }

    public void add(final String word, final String meaning) {
        wordMap.put(word, meaning);
    }

    public String getMeaning(final String word) {
        return wordMap.get(word);
    }
}