package com.littlebuddha.housekeeping.service.system;

import com.littlebuddha.housekeeping.entity.system.Area;
import com.littlebuddha.housekeeping.mapper.system.AreaMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 区域业务层
 */
@Service
public class AreaService extends BaseService<Area, AreaMapper> {

    @Autowired
    private AreaMapper areaMapper;

    public Area get(String id) {
        return areaMapper.get(id);
    }

    public List<Area> findList(Area area) {
        List<Area> list = areaMapper.findList(area);
        return list;
    }

    @Transactional
    public int save(Area area) {
        super.save(area);
        return 0;
    }

    @Transactional
    public void deleteByPhysics(Area area){
        super.deleteByPhysics(area);
    }

    @Transactional
    public void deleteAllByPhysics(Area area){
        super.deleteByPhysics(area);
    }
}
