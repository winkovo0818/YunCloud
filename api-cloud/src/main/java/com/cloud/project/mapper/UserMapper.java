package com.cloud.project.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.common.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}

