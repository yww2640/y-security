package com.slightlee.yadmin.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.slightlee.yadmin.sys.pojo.SysUser;

import java.util.List;

/**
 * description:
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 2:21
 */
public interface SysUserMapper extends BaseMapper<SysUser> {


    /**
     * 查询用户的所有权限
     * @return
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     * @param userId
     * @return
     */
    List<Long> queryAllMenuId(Long userId);
}
