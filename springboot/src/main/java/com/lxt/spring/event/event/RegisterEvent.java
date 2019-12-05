package com.lxt.spring.event.event;

import com.lxt.spring.event.entity.SysUser;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassName: RegisterEvent
 * @Author: lxt
 * @Description: 注册事件
 * @Version: 1.0
 */
public class RegisterEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param sysUser the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public RegisterEvent(SysUser sysUser) {
        super(sysUser);
    }
}
