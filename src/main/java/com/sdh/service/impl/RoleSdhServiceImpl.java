package com.sdh.service.impl;

import com.sdh.dao.RoleSdhDao;
import com.sdh.pojo.RoleSdh;
import com.sdh.service.RoleSdhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @ClassName RoleSdhServiceImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 16:01
 * @Version 1.0
 */
@Service
public class RoleSdhServiceImpl implements RoleSdhService {

    @Autowired
    private RoleSdhDao roleSdhDao;


    @Override
    public List<RoleSdh> queryRoleAll() {
        return roleSdhDao.queryRoleAll();
    }

    @Override
    public void insertUserRole(Integer roleId, Integer userId) {
        roleSdhDao.insertUserRole(roleId,userId);
    }

    @Override
    public Set<String> queryAllRoleByUsername(String username) {
        return roleSdhDao.queryAllRoleByUsername(username);
    }
}
