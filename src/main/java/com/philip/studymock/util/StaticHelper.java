package com.philip.studymock.util;

/**
 * Created by philipl on 2019/6/30.
 */
public class StaticHelper {

    public static Integer getRandomInteger(){
        double random = Math.random() * 5000d;
        return new Double(random).intValue();
    }
}
