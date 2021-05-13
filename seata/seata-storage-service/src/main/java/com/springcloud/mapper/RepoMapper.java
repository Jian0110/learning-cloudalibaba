package com.springcloud.mapper;

import com.springcloud.entity.Repo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface RepoMapper extends Mapper<Repo> {
    @Select("update repo set amount=#{amount}  where id=#{id}")
    Boolean updateAmount(Repo repo);
}