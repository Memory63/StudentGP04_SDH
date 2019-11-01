package com.sdh.dao;

import com.sdh.pojo.RoleSdh;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName RoleSdh
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 15:42
 * @Version 1.0
 */
public interface RoleSdhDao {

    List<RoleSdh> queryRoleAll();

    void insertUserRole(@Param("roleId") Integer roleId,@Param("userId") Integer userId);
}
