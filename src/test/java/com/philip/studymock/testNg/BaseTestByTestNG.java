package com.philip.studymock.testNg;

import com.philip.studymock.StudymockApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.IHookCallBack;
import org.testng.ITestResult;

/**
 * Created by philipl on 2019/6/30.
 * how to use testNg in spring boot:
 * https://www.jianshu.com/p/28af813ea322
 */
@SpringBootTest(classes = {StudymockApplication.class})
@Slf4j
public class BaseTestByTestNG extends AbstractTestNGSpringContextTests{

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        try {
            super.run(callBack, testResult);
        } finally {
            if (testResult != null) {
                logger.info(String.format("test case: %s ,elapsed %d", testResult.getName(), System.currentTimeMillis() - testResult.getStartMillis()));
            }
        }
    }
}
