package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName UserSdh
 * @Description 班级表claz_sdh
 * @Author SDH
 * @CreateDate 2019/11/1 14:54
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermSdh {
    private Integer Id;
    private String  perm;
    private Date crateTime;
}
