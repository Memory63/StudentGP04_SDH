package com.sdh.dao;

import com.sdh.pojo.ClazSdh;
import com.sdh.pojo.UserSdh;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ClazSdhDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 16:06
 * @Version 1.0
 */
public interface ClazSdhDao {
    List<ClazSdh> queryClazAll();

    List<UserSdh> queryStudent(@Param("clazId") Integer clazId);
}
