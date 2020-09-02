package com.littlebuddha.housekeeping.mapper.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.Role;

import java.util.List;

public interface RoleMenuMapper{
    List<String> findByRole(Role role);
}
