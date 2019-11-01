package com.sdh.controller;

import com.sdh.pojo.ClazSdh;
import com.sdh.pojo.RoleSdh;
import com.sdh.pojo.UserSdh;
import com.sdh.service.ClazSdhService;
import com.sdh.service.RoleSdhService;
import com.sdh.service.UserSdhService;
import com.sdh.utils.R;
import com.sdh.vo.UserRoleVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    /**
     * todo: 用户登录
     * @param userSdh
     * @return 成功：去list页面，失败返回登陆页面
     */
    @PostMapping("login")
    public String login(UserSdh userSdh){
        System.out.println(userSdh);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userSdh.getUsername(), userSdh.getPassword());
        subject.login(token);
        if(subject.isAuthenticated()){
            return "forward:/claz/listClaz";
        }
        return "redirect:login";
    }

    /**
     * todo: 验证码
     * @param session
     * @param code
     * @return
     */
    @RequestMapping("captchaCheck")
    @ResponseBody
    public R captchaCheck(HttpSession session, String code){
        String captcha = (String) session.getAttribute("captcha");
        System.out.println(captcha+" "+code);
        int data;
        if(code.equalsIgnoreCase(captcha)){
            data=1;
        }else{
            data=0;
        }
        return new R(data);
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

    @RequestMapping("logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:login";
    }

}
