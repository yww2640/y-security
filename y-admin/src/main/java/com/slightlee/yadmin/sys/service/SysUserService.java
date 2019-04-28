package com.slightlee.yadmin.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slightlee.common.utils.R;
import com.slightlee.yadmin.sys.pojo.SysUser;

import java.util.List;

/**
 * description:
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 2:25
 */
public interface SysUserService extends IService<SysUser> {

    /**
     *  查询用户的所有菜单ID
     * @param userId
     * @return
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     *  根据条件 用户名 、手机号、邮箱 模糊查询
     */
    R getAllUser(Integer pageNo, Integer pageSize, String searchKey, String searchValue);

    /**
     *  添加用户
     */
    void add(SysUser sysUser);

}
