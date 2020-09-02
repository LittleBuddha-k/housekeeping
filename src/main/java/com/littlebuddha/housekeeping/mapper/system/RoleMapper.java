package com.littlebuddha.housekeeping.mapper.system;

import com.littlebuddha.housekeeping.entity.system.Operator;
import com.littlebuddha.housekeeping.entity.system.Role;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;

import java.util.Set;

public interface RoleMapper extends BaseMapper<Role> {

    Set<String> findRolesByOperator(Operator operator);
}
