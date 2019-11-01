package com.sdh.service;

import com.sdh.pojo.ClazSdh;
import com.sdh.pojo.UserSdh;

import java.util.List;

/**
 * @ClassName ClazSdhService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 16:08
 * @Version 1.0
 */
public interface ClazSdhService {
    List<ClazSdh> queryClazAll();

    List<UserSdh> queryStudent(Integer clazId);
}
