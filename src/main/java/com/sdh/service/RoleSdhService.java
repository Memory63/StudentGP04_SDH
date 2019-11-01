package com.sdh.service;

import com.sdh.pojo.RoleSdh;

import java.util.List;
import java.util.Set;

/**
 * @ClassName RoleSdhService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 16:00
 * @Version 1.0
 */
public interface RoleSdhService {
    List<RoleSdh> queryRoleAll();
    void insertUserRole(Integer roleId,Integer userId);
    Set<String> queryAllRoleByUsername(String username);
}
