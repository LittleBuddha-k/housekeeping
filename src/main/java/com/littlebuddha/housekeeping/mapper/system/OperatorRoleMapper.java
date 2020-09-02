package com.littlebuddha.housekeeping.mapper.system;

import com.littlebuddha.housekeeping.entity.system.Operator;

import java.util.List;

public interface OperatorRoleMapper{
    List<String> findByOperator(Operator operator);
}
