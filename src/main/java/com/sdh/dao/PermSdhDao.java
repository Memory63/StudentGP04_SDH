package com.sdh.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @ClassName PermSdhDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 17:29
 * @Version 1.0
 */
public interface PermSdhDao {
    Set<String> queryAllPermByUsername(@Param("username") String username);
}
