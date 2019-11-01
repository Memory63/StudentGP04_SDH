package com.sdh.test;

import com.sdh.dao.UserSdhDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName DaoTest
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 15:15
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DaoTest {

    @Autowired
    private UserSdhDao userSdhDao;

    @Test
    public void testDaoInsertUser(){
//        userSdhDao.insertUser();
    }
}
