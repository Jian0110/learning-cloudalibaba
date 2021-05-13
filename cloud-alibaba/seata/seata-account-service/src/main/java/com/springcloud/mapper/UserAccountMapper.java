package com.springcloud.mapper;

import com.springcloud.entity.UserAccount;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface UserAccountMapper extends Mapper<UserAccount> {
    @Select("update user_account set balance=#{balance}  where id=#{id}")
    Boolean updateBalance(UserAccount UserAccount);
}