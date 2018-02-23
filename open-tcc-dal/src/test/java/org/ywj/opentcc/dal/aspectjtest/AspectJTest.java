package org.ywj.opentcc.dal.aspectjtest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Log4jConfigurer;
import org.ywj.opentcc.dal.aop.AopComponent;
import org.ywj.opentcc.dal.configuration.DaoConfiguration;

import java.io.FileNotFoundException;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {DaoConfiguration.class})
public class AspectJTest {

//    @Before
//    public void init() {
//        try {
//            Log4jConfigurer.initLogging("classpath:log/log4j.properties");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

//    static {
//        try {
//            Log4jConfigurer.initLogging("classpath:log/log4j.properties");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    @Autowired
    private AopComponent aopComponent;

    @Test
    public void myTest() {
        aopComponent.print();
    }
}
