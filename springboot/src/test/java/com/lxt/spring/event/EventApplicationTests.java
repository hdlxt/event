package com.lxt.spring.event;

import com.lxt.spring.event.entity.SysUser;
import com.lxt.spring.event.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventApplicationTests {

    @Autowired
    private SysUserService sysUserService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testEvent(){
        sysUserService.register(new SysUser()
                .setName("lxt")
                .setAge(18));
    }
}
