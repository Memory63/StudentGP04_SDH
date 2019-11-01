package com.sdh.realm;

import com.sdh.pojo.UserSdh;
import com.sdh.service.PermSdhService;
import com.sdh.service.RoleSdhService;
import com.sdh.service.UserSdhService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * @ClassName MyRealm
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 11:16
 * @Version 1.0
 */
@Setter
public class MyRealm extends AuthorizingRealm {

    private PermSdhService permSdhService;
    private RoleSdhService roleSdhService;
    private UserSdhService userSdhService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限获取");
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> permission = permSdhService.queryAllPermByUsername(username);
        Set<String> role = roleSdhService.queryAllRoleByUsername(username);
        System.out.println("perm"+permission);
        System.out.println("role"+role);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(role);
        simpleAuthorizationInfo.setStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("用户登录");
        String username = (String) token.getPrincipal();
        UserSdh userSdh = userSdhService.queryUserSdhByUsername(username);
        if(userSdh ==null){
            return null;
        }
        return new SimpleAuthenticationInfo(
                userSdh.getUsername(), userSdh.getPassword(), ByteSource.Util.bytes(userSdh.getSalt()),this.getName());
    }
}
