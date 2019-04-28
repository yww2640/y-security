package com.slightlee.yadmin.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slightlee.yadmin.sys.pojo.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description:
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 20:46
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     *  根据父菜单，查询子菜单
     */
    List<SysMenu> queryListParentId(Long parentId);


    /**
     *  根据父菜单以及菜单类型，查询子菜单
     */
    List<SysMenu> queryListParentIdAndMenuType(@Param(value = "parentId") Long parentId, @Param(value = "menuType") Integer menuType);


}
