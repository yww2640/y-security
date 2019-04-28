package com.slightlee.yadmin.sys.controller;

import com.slightlee.common.utils.R;
import com.slightlee.yadmin.annotation.SysLog;
import com.slightlee.yadmin.sys.pojo.SysUser;
import com.slightlee.yadmin.sys.service.SysUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;


/**
 * description: 用户信息
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 2:29
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController{

    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     *  用户信息
     * @return userList
     */
    @RequestMapping("/list")
    public R list(@RequestParam Integer page, @RequestParam Integer limit,
                  @RequestParam(required = false) String searchKey,
                  @RequestParam(required = false) String searchValue){
        R r = sysUserService.getAllUser(page, limit, searchKey, searchValue);
        return r;
    }

    /**
     *   添加用户
     */
    @SysLog("添加用户")
    @RequestMapping("/save")
    public R save(@RequestBody SysUser sysUser){

        sysUserService.add(sysUser);

        return R.ok();
    }


    /**
     *   修改用户
     */
    @SysLog("修改用户")
    @RequestMapping("/update")
    public R update(@RequestBody SysUser sysUser){
        sysUserService.updateById(sysUser);
        return R.ok();
    }


    /**
     *   删除用户
     */
    @SysLog("删除用户")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] userIds){
        if(ArrayUtils.contains(userIds,1L)){
            return R.error("系统管理员不能删除");
        }
        if(ArrayUtils.contains(userIds, getUserId())){
            return R.error("当前用户不能删除");
        }
        sysUserService.removeByIds(Arrays.asList(userIds));
        return R.ok();
    }

    /**
     *  获取登录的用户信息
     */
    @RequestMapping("/info")
    public R info(){
        return R.ok().put("user",getUser());
    }

}
