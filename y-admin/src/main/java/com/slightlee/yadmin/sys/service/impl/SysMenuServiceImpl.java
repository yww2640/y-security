package com.slightlee.yadmin.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slightlee.common.utils.Constant;
import com.slightlee.yadmin.sys.mapper.SysMenuMapper;
import com.slightlee.yadmin.sys.pojo.SysMenu;
import com.slightlee.yadmin.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 20:48
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper,SysMenu> implements SysMenuService{

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> queryListParentId(Long parentId) {
        return sysMenuMapper.queryListParentId(parentId);
    }

    public List<SysMenu> queryListParentIdAndMenuType(Long parentId, Integer menuType) {
        return sysMenuMapper.queryListParentIdAndMenuType(parentId,menuType);
    }


    @Override
    public List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenu> menuList = queryListParentId(parentId);
        if(menuIdList == null){
            return  menuList;
        }
        List<SysMenu>  userMenuList = new ArrayList<>();
        for (SysMenu sysMenu : userMenuList){
            if (userMenuList.contains(sysMenu.getMenuId())){
                userMenuList.add(sysMenu);
            }
        }
        return userMenuList;
    }

    public List<SysMenu> queryListParentIdAndMenuType(Long parentId, Integer menuType, List<Long> menuIdList) {

        List<SysMenu> menuList = queryListParentIdAndMenuType(parentId,menuType);

        if(menuIdList == null){
            return  menuList;
        }
        List<SysMenu>  userMenuList = new ArrayList<>();
        for (SysMenu sysMenu : userMenuList){
            if (userMenuList.contains(sysMenu.getMenuId())){
                userMenuList.add(sysMenu);
            }
        }
        return userMenuList;
    }



    @Override
    public List<SysMenu> getUserMenuList(Long userId) {
        // 如果是系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            return getAllMenuList(null);
        }
        // 用户菜单列表
        return null;
    }

    @Override
    public List<SysMenu> getUserMenuList(Long userId, Integer menuType) {

        // 如果是系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            return getAllMenuList(menuType,null);
        }
        // 用户菜单列表

        return null;
    }

    public List<SysMenu> getAllMenuList(List<Long> menuIdList){
        // 查询根菜单 列表
        List<SysMenu> menuList = queryListParentId(0L, menuIdList);
        // 递归获取子菜单列表
        getMenuTreeList(menuList, menuIdList);
        return menuList;
    }

    public List<SysMenu> getAllMenuList(Integer menuType,List<Long> menuIdList){
        // 查询根菜单 列表
        List<SysMenu> menuList = queryListParentIdAndMenuType(0L,menuType,menuIdList);
        // 递归获取子菜单列表
        getMenuTreeList(menuList, menuIdList);
        return menuList;
    }


    /**
     * 递归
     */
    public List<SysMenu> getMenuTreeList(List<SysMenu> menuList,List<Long> menuIdList){

        List<SysMenu> subMenuList = new ArrayList<SysMenu>();
        for (SysMenu sysMenu : menuList){
            //目录
            if ( sysMenu.getType() == Constant.MenuType.CATALOG.getValue()){
                sysMenu.setList(getMenuTreeList(queryListParentId(sysMenu.getMenuId(),menuIdList),menuIdList));
            }
            subMenuList.add(sysMenu);
        }
        return subMenuList;
    }


    @Override
    public void delete(Long menuId) {

    }
}
