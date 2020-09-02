package com.littlebuddha.housekeeping.mapper.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.Area;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;

import java.util.List;

public interface AreaMapper extends BaseMapper<Area> {
    List<Area> findByCityCode(String cityCode);
}
