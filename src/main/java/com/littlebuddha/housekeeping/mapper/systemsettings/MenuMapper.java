package com.littlebuddha.housekeeping.mapper.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.Menu;
import com.littlebuddha.housekeeping.entity.systemsettings.Operator;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;

import java.util.List;
import java.util.Set;

public interface MenuMapper extends BaseMapper<Menu> {

    Set<String> findPermissionsByOperator(Operator operator);

    List<Menu> findMenuByOperator(Menu menu);
}
