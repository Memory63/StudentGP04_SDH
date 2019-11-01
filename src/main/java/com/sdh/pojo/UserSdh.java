package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName UserSdh
 * @Description 用户表user_sdh
 * @Author SDH
 * @CreateDate 2019/11/1 14:54
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSdh {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String gender;
    private Date registTime;
    private Integer clazId;
}
