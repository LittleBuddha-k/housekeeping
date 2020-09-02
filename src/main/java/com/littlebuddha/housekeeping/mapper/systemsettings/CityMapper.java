package com.littlebuddha.housekeeping.mapper.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.City;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;

import java.util.List;

public interface CityMapper extends BaseMapper<City> {
    List<City> findByProvinceCode(String provinceCode);
}
