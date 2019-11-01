package com.sdh.service.impl;

import com.sdh.dao.ClazSdhDao;
import com.sdh.pojo.ClazSdh;
import com.sdh.pojo.UserSdh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ClazSdhService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 16:08
 * @Version 1.0
 */
@Service
public class ClazSdhServiceImpl implements com.sdh.service.ClazSdhService {

    @Autowired
    private ClazSdhDao clazSdhDao;

    /**
     * todo: 获取所有班级信息
     * @return
     */
    @Override
    public List<ClazSdh> queryClazAll() {
        return clazSdhDao.queryClazAll();
    }

    @Override
    public List<UserSdh> queryStudent(Integer clazId) {
        return clazSdhDao.queryStudent(clazId);
    }
}
