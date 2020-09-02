package com.littlebuddha.housekeeping.mapper.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.Operator;

import java.util.List;

public interface OperatorRoleMapper{
    List<String> findByOperator(Operator operator);
}
