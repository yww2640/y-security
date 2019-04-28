package com.slightlee.yadmin.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slightlee.yadmin.sys.pojo.SysMenu;

import java.util.List;

/**
 * description:
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 20:47
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     *  根据父菜单，查询子菜单
     */
    List<SysMenu> queryListParentId(Long parentId);

    /**
     *  根据父菜单，查询子菜单
     */
    List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     *  获取用户菜单列表
     */
    List<SysMenu> getUserMenuList(Long userId);

    List<SysMenu> getUserMenuList(Long userId,Integer menuType);

    /**
     * 删除
     */
    void delete(Long menuId);
}
