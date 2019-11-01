package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class RolePermSdh {
    private Integer Id;
    private Integer permId;
    private Integer roleId;
}
