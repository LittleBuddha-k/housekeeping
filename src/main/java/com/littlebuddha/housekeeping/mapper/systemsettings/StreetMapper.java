package com.littlebuddha.housekeeping.mapper.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.Area;
import com.littlebuddha.housekeeping.entity.systemsettings.Street;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;

import java.util.List;

public interface StreetMapper extends BaseMapper<Street> {
    List<Area> findByAreaCode(String areaCode);
}
