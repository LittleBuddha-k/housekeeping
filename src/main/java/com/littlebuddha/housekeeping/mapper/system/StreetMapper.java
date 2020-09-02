package com.littlebuddha.housekeeping.mapper.system;

import com.littlebuddha.housekeeping.entity.system.Area;
import com.littlebuddha.housekeeping.entity.system.Street;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;

import java.util.List;

public interface StreetMapper extends BaseMapper<Street> {
    List<Area> findByAreaCode(String areaCode);
}
