package com.slightlee.yadmin.sys.controller;

import com.slightlee.yadmin.sys.pojo.SysUser;
import com.slightlee.yadmin.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 18:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserControllerTest {

   private static final Logger logger = LoggerFactory.getLogger(SysUserControllerTest.class);

    @Autowired
    SysUserService sysUserService;

    /**
     *  用户信息测试
     */
    @Test
    public void list(){
        List<SysUser> list = sysUserService.list();
        logger.info("list结果 {}",list);
    }
}
