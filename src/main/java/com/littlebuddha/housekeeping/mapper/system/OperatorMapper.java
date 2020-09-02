package com.littlebuddha.housekeeping.mapper.system;

import com.littlebuddha.housekeeping.entity.system.Operator;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperatorMapper extends BaseMapper<Operator> {

    Operator get(String id);

    Operator selectByNameAndPassword(@Param(value = "name") String name,
                                     @Param(value = "password")String password);

    //通过用户名查询用户
    Operator selectByName(@Param(value = "name") String name);

    List<Operator> list(Operator operator);

    int insert(Operator operator);

    int update(Operator operator);

    int deleteByLogic(String id);

    int deleteByPhysics(String id);
}
