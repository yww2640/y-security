package com.slightlee.yadmin.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slightlee.common.utils.R;
import com.slightlee.common.utils.StringUtil;
import com.slightlee.yadmin.sys.mapper.SysUserMapper;
import com.slightlee.yadmin.sys.pojo.SysUser;
import com.slightlee.yadmin.sys.service.SysUserService;
import com.slightlee.yadmin.sys.shiro.ShiroUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @author : SLIGHTLEE
 * @date : 2019/4/25/25 2:28
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return sysUserMapper.queryAllMenuId(userId);
    }

    @Override
    public R getAllUser(Integer pageNo, Integer pageSize, String searchKey, String searchValue) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        if(StringUtil.isNotBlank(searchKey)){
            wrapper.like(searchKey,searchValue);
        }
        IPage<SysUser> page = new Page<>(pageNo,pageSize);
        IPage<SysUser> iPage = sysUserMapper.selectPage(page, wrapper);
        return R.ok().put("count",iPage.getTotal()).put("data",iPage.getRecords());
    }

    @Override
    public void add(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        sysUser.setSalt(salt);
        sysUser.setPassword(ShiroUtils.sha256(sysUser.getPassword(),salt));
        sysUser.setCreateUserId(ShiroUtils.getUserId());
        this.save(sysUser);
    }
}
