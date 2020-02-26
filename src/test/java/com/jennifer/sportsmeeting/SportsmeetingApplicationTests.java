package com.jennifer.sportsmeeting;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class SportsmeetingApplicationTests {

    @Resource
    private DataSource dataSource;
    @Test
    void contextLoads() {
        System.out.println(this.dataSource);
    }

}
