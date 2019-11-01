package com.sdh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdh.pojo.ClazSdh;
import com.sdh.pojo.UserSdh;
import com.sdh.service.ClazSdhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("listClaz")
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

}
