package com.slightlee.yadmin.sys.controller;

import com.slightlee.yadmin.sys.pojo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * description:
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/26/26 0:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogBackTest {

    private static final Logger logger = LoggerFactory.getLogger(SysUserControllerTest.class);

    @Test
    public void logTest(){
        logger.info("logTest info {}","info 测试");
    }

}
