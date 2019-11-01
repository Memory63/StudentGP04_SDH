package com.sdh.service.impl;

import com.sdh.dao.PermSdhDao;
import com.sdh.service.PermSdhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName PermSdhServiceImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 17:39
 * @Version 1.0
 */
@Service
public class PermSdhServiceImpl implements PermSdhService {

    @Autowired
    private PermSdhDao permSdhDao;

    @Override
    public Set<String> queryAllPermByUsername(String username) {
        return permSdhDao.queryAllPermByUsername(username);
    }
}
