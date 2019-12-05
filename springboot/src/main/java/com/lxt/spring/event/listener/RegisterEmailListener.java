package com.lxt.spring.event.listener;

import com.lxt.spring.event.entity.SysUser;
import com.lxt.spring.event.event.RegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RegisterEmailListener
 * @Author: lxt
 * @Description: 监听用户注册，发送邮件
 * @Version: 1.0
 */
@Slf4j
@Component
public class RegisterEmailListener implements ApplicationListener<RegisterEvent> {

    /**
     * 监听注册事件
     * @param event
     */
//    @Async
    @Override
    public void onApplicationEvent(RegisterEvent event) {
        SysUser sysUser = (SysUser) event.getSource();
        log.info("用户[{}]注册成功，开始发送邮件...",sysUser);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("用户[{}]注册成功，结束发送邮件...",sysUser);
    }
}
