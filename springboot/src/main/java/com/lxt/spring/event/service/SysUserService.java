package com.lxt.spring.event.service;

import com.lxt.spring.event.entity.SysUser;
import com.lxt.spring.event.event.RegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SysUserService
 * @Author: lxt
 * @Description: 用户业务
 * @Version: 1.0
 */
@Service
@Slf4j
public class SysUserService {

    @Autowired
    private ApplicationContext applicationContext;

    public void register(SysUser sysUser){
        log.info("开始注册用户",sysUser);
        // 添加用户
        save(sysUser);
        log.info("开始发布用户注册事件:{}",sysUser);
        // 发布用户注册事件
        publishRegisterEvent(sysUser);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("结束注册用户",sysUser);

    }

    public void save(SysUser sysUser){
        log.info("添加用户成功：{}",sysUser);
        sysUser.setId(System.currentTimeMillis());
    }

    private void publishRegisterEvent(SysUser sysUser) {
        applicationContext.publishEvent(new RegisterEvent(sysUser));
    }
}
