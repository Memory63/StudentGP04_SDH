package com.sdh.dao;

import com.sdh.pojo.UserSdh;
import com.sdh.vo.UserRoleVo;

/**
 * @ClassName UserSdhDao
 * @Description TODO: 用户层
 * @Author SDH
 * @CreateDate 2019/11/1 15:06
 * @Version 1.0
 */
public interface UserSdhDao {
    /**
     * 添加用户信息
     * @param userRoleVo
     */
    void insertUser(UserRoleVo userRoleVo);

    UserSdh queryUserSdhByUsername(String username);
}
