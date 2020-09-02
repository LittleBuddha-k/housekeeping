package com.littlebuddha.housekeeping.service.systemsettings;

import com.littlebuddha.housekeeping.entity.systemsettings.Area;
import com.littlebuddha.housekeeping.entity.systemsettings.City;
import com.littlebuddha.housekeeping.mapper.systemsettings.AreaMapper;
import com.littlebuddha.housekeeping.mapper.systemsettings.CityMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 城市业务层
 */
@Service
public class CityService extends BaseService<City, CityMapper> {

    @Autowired
    private CityMapper cityMapper;

    public City get(String id) {
        return cityMapper.get(id);
    }

    public List<City> findList(City city) {
        List<City> list = cityMapper.findList(city);
        return list;
    }

    @Transactional
    public int save(City city) {
        super.save(city);
        return 0;
    }

    @Transactional
    public void deleteByPhysics(City city){
        super.deleteByPhysics(city);
    }

    @Transactional
    public void deleteAllByPhysics(City city){
        super.deleteByPhysics(city);
    }
}
