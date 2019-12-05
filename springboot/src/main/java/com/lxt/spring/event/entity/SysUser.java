package com.lxt.spring.event.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName: SysUser
 * @Author: lxt
 * @Description: 用户实体
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
public class SysUser {

    private long id;
    private String name;
    private int age;
}
