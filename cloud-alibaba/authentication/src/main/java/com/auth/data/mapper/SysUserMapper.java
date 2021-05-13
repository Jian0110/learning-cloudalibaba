package com.auth.data.mapper;

import com.auth.data.entity.MyUserDetail;
import com.auth.data.entity.SysUser;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends Mapper<SysUser> {
    @Select("select * from user where username = #{username}")
    MyUserDetail selectByUsername(@Param("username") String username);

}