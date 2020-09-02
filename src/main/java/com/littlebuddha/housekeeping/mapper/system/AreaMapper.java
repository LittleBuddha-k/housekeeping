package com.littlebuddha.housekeeping.mapper.system;

import com.littlebuddha.housekeeping.entity.system.Area;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;

import java.util.List;

public interface AreaMapper extends BaseMapper<Area> {
    List<Area> findByCityCode(String cityCode);
}
