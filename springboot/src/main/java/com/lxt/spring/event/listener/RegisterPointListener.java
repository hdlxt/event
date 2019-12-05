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
 * @ClassName: RegisterPointListener
 * @Author: lxt
 * @Description: 监听用户注册，添加积分
 * @Version: 1.0
 */
@Slf4j
@Component
public class RegisterPointListener implements SmartApplicationListener{

    /**
     * 事件类型判断
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == RegisterEvent.class;
    }
    /**
     * 事件源类型判断
     * @param sourceType
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == SysUser.class;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * 监听注册事件
     * @param event
     */
    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent event) {
        SysUser sysUser = (SysUser) event.getSource();
        log.info("用户[{}]注册成功，开始添加积分...",sysUser);
    }
}
