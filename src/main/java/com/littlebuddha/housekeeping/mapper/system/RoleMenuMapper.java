package com.littlebuddha.housekeeping.mapper.system;

import com.littlebuddha.housekeeping.entity.system.Role;

import java.util.List;

public interface RoleMenuMapper{
    List<String> findByRole(Role role);
}
