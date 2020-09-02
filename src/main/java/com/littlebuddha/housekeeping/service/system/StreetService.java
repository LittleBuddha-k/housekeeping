package com.littlebuddha.housekeeping.service.system;

import com.littlebuddha.housekeeping.entity.system.Street;
import com.littlebuddha.housekeeping.mapper.system.StreetMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 区域业务层
 */
@Service
public class StreetService extends BaseService<Street, StreetMapper> {

    @Autowired
    private StreetMapper streetMapper;

    public Street get(String id) {
        return streetMapper.get(id);
    }

    public List<Street> findList(Street street) {
        List<Street> list = streetMapper.findList(street);
        return list;
    }

    @Transactional
    public int save(Street street) {
        super.save(street);
        return 0;
    }

    @Transactional
    public void deleteByPhysics(Street street){
        super.deleteByPhysics(street);
    }

    @Transactional
    public void deleteAllByPhysics(Street street){
        super.deleteByPhysics(street);
    }
}
