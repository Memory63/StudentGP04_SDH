package com.sdh.controller;

import com.sdh.pojo.ClazSdh;
import com.sdh.pojo.RoleSdh;
import com.sdh.service.ClazSdhService;
import com.sdh.service.RoleSdhService;
import com.sdh.service.UserSdhService;
import com.sdh.vo.UserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 15:26
 * @Version 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserSdhService userSdhService;
    @Autowired
    private RoleSdhService roleSdhService;
    @Autowired
    private ClazSdhService clazSdhService;

    /**
     * todo:注册用户信息
     * @param userRoleVo
     * @return
     */
    @PostMapping("register")
    public String register(UserRoleVo userRoleVo){
        System.out.println(userRoleVo);
        userSdhService.insertUser(userRoleVo);
        return "redirect:login";
    }

    @PostMapping("login")
    public String login(UserRoleVo userRoleVo){
        System.out.println(userRoleVo);
        userSdhService.insertUser(userRoleVo);
        return "";
    }

    /**
     * todo: 转发到登录页面
     * @return
     */
    @GetMapping("login")
    public String loginPage(){
        return "WEB-INF/login";
    }

    /**
     * todo: 跳转注册页面,需要角色信息和班级信息
     * @param model
     * @return
     */
    @GetMapping("register")
    public String registerPage(Model model){
        List<RoleSdh> roleSdhs = roleSdhService.queryRoleAll();
        List<ClazSdh> clazSdhs = clazSdhService.queryClazAll();
        model.addAttribute("roles",roleSdhs);
        model.addAttribute("clazs",clazSdhs);
        return "WEB-INF/register";
    }

}
