package com.auth.service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import	java.util.Optional;

import com.auth.data.entity.MyUserDetail;
import com.auth.data.entity.SysUser;
import com.auth.data.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@Slf4j
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private SysUserMapper sysUserMapper;
    final static String  passIds="015301191023900316959820200506101058,015301190823900432160620200506162113,015301190823900432160620200506113705,015301190623380201551520200506124848,020000530101620017171720200506080206,015301190923900400591320200506115951,015301190923900316055420200506132341,015301190923900316055420200506124505,015301190823370400823420200506080745,020000530101600019206120200506125916,015301190923900400591320200506091021,015301190823900462874420200506092809";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户姓名不能为空");
        }
        MyUserDetail user = sysUserMapper.selectByUsername(username);
        Assert.isNull(user, "user must be not null");
        Optional.ofNullable(user).orElseThrow(()->new UsernameNotFoundException("数据库没有该用户"));
        return user ;
    }

    public static void main(String[] args) {
        String tableSuffix = "2020-06-01".substring(0,7).replace("-","");
        System.out.println(tableSuffix);
    }
}
