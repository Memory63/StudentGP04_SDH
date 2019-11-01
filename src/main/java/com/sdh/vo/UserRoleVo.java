package com.sdh.vo;

import com.sdh.pojo.UserSdh;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserRoleVo
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 15:48
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleVo extends UserSdh {
    private Integer roleId;
}
