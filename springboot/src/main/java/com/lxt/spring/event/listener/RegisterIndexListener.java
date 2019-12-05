package com.lxt.spring.event.listener;

import com.lxt.spring.event.entity.SysUser;
import com.lxt.spring.event.event.RegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RegisterIndexListener
 * @Author: lxt
 * @Description: 监听用户注册，创建索引
 * @Version: 1.0
 */
@Slf4j
@Component
public class RegisterIndexListener implements SmartApplicationListener {
    /**
     * 监听注册事件
     * @param event
     */
    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent event) {
        SysUser sysUser = (SysUser) event.getSource();
        log.info("用户[{}]注册成功，开始创建索引...",sysUser);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("用户[{}]注册成功，结束创建索引...",sysUser);
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == RegisterEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == SysUser.class;
    }

    @Override
    public int getOrder() {
        return 2;
    }

}
