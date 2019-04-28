package com.slightlee.yadmin.sys.controller;

import com.slightlee.common.utils.R;
import com.slightlee.yadmin.sys.pojo.SysMenu;
import com.slightlee.yadmin.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description:  菜单
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 20:49
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController{

    private final SysMenuService sysMenuService;

    @Autowired
    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    /**
     *  导航菜单
     */
    @RequestMapping("/nav")
    public R navigation(){
        List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId());
        return R.ok().put("menuList",menuList);
    }

    /**
     *  导航菜单(上方导航点击，左侧导航内容改变)
     */
    @RequestMapping("/nav2")
    public R navigation(Integer menuType){
        List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId(),menuType);
        return R.ok().put("menuList",menuList);
    }


    /**
     *  所有菜单列表
     */
    @RequestMapping("/list")
    public R list(){
        List<SysMenu> menuList = sysMenuService.list();
        for (SysMenu sysMenu : menuList) {
            SysMenu parentMenu = sysMenuService.getById(sysMenu.getParentId());
            if (parentMenu !=null){
                sysMenu.setParentName(parentMenu.getName());
            }
        }
        return R.ok().put("data",menuList);
    }

    /**
     *  根菜单
     */
    @RequestMapping("queryListParentId")
    public R queryListParentId(){
        List<SysMenu> menuList = sysMenuService.queryListParentId(0L);
        return  R.ok().put("menuList",menuList);
    }

}
