package com.sdh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdh.pojo.ClazSdh;
import com.sdh.pojo.UserSdh;
import com.sdh.service.ClazSdhService;
import com.sdh.service.UserSdhService;
import com.sdh.vo.UserRoleVo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName ClazController
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/11/1 17:45
 * @Version 1.0
 */
@Controller
@RequestMapping("claz")
public class ClazController {

    @Autowired
    private ClazSdhService clazSdhService;
    @Autowired
    private UserSdhService userSdhService;

    @RequestMapping("listClaz")
    @RequiresAuthentication
    public String listClaz(Model model){
        List<ClazSdh> clazSdhs =clazSdhService.queryClazAll();
        model.addAttribute("listClaz",clazSdhs);
        return "WEB-INF/listClaz";
    }

    @RequestMapping("listStudent")
    public String listStudent(Integer clazId,Model model,Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum=0;
        }
        if(pageSize==null){
            pageSize=5;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<UserSdh> userSdhs = clazSdhService.queryStudent(clazId);
        PageInfo<UserSdh> pageInfo = new PageInfo<>(userSdhs);
        model.addAttribute("listStudent",pageInfo);
        model.addAttribute("clazId",clazId);
        return "WEB-INF/listStudent";
    }

    @GetMapping("add")
    public String addClazPage(){
        return "WEB-INF/addClaz";
    }

    @PostMapping("add")
    public String addClaz(ClazSdh clazSdh){
        System.out.println(clazSdh);
        clazSdhService.insertClaz(clazSdh);
        return "redirect:listClaz";
    }

    @GetMapping("addStudent")
    public String addStudentPage(){
        return "WEB-INF/addStudent";
    }

    @PostMapping("addStudent")
    public String addStudent(UserRoleVo userRoleVo){
        System.out.println(userRoleVo);
        userSdhService.insertUser(userRoleVo);
        return "redirect:listStudent?clazId="+userRoleVo.getClazId();
    }

    @GetMapping("updateStudent")
    public String updateStudentPage(Integer id, Model model){
        model.addAttribute("id",id);
        return "WEB-INF/updateStudent";
    }

    @PostMapping("updateStudent")
    public String updateStudent(UserRoleVo userRoleVo){
        userSdhService.updateStudent(userRoleVo);
        return "WEB-INF/listStudent?clazId="+userRoleVo.getClazId();
    }

}
