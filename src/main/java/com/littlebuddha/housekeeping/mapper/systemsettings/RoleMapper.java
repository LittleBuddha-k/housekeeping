package com.littlebuddha.housekeeping.mapper.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.Operator;
import com.littlebuddha.housekeeping.entity.systemsettings.Role;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;

import java.util.Set;

public interface RoleMapper extends BaseMapper<Role> {

    Set<String> findRolesByOperator(Operator operator);
}
