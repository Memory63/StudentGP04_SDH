package com.sdh.service;

import java.util.Set;

/**
 * @ClassName PermSdhService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 17:37
 * @Version 1.0
 */
public interface PermSdhService {
    Set<String> queryAllPermByUsername(String username);
}
