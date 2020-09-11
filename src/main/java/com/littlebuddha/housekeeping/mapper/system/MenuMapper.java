package com.littlebuddha.housekeeping.mapper.system;

import com.littlebuddha.housekeeping.entity.system.Menu;
import com.littlebuddha.housekeeping.entity.system.Operator;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;

import java.util.List;
import java.util.Set;

public interface MenuMapper extends BaseMapper<Menu> {

    Set<String> findPermissionsByOperator(Operator operator);

    List<Menu> findMenuByOperator(Menu menu);

    Menu findTheBiggestMenu(Menu menu);
}
