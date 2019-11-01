package com.sdh.service.impl;

import com.sdh.dao.RoleSdhDao;
import com.sdh.dao.UserSdhDao;
import com.sdh.service.UserSdhService;
import com.sdh.vo.UserRoleVo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName UserSdhService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 15:25
 * @Version 1.0
 */
@Service
public class UserSdhServiceImpl implements UserSdhService {

    @Autowired
    private UserSdhDao userSdhDao;
    @Autowired
    private RoleSdhDao roleSdhDao;

    /**
     * todo:添加用户信息,并添加用户关联角色信息
     * @param userRoleVo
     */
    @Override
    public void insertUser(UserRoleVo userRoleVo) {
        String salt = UUID.randomUUID().toString();
        String password = new Sha256Hash(userRoleVo.getPassword(), salt, 1000).toBase64();
        userRoleVo.setPassword(password);
        userRoleVo.setSalt(salt);
        userRoleVo.setRegistTime(new Date());
        userRoleVo.setId(null);
        userSdhDao.insertUser(userRoleVo);
        roleSdhDao.insertUserRole(userRoleVo.getRoleId(),userRoleVo.getId());
    }
}
