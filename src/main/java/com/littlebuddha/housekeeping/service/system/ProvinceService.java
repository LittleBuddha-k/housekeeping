package com.littlebuddha.housekeeping.service.system;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Province;
import com.littlebuddha.housekeeping.mapper.system.ProvinceMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 区域业务层
 */
@Service
public class ProvinceService extends BaseService<Province, ProvinceMapper> {

    @Autowired
    private ProvinceMapper provinceMapper;

    public Province get(String id) {
        return provinceMapper.get(id);
    }

    public List<Province> findList(Province province) {
        List<Province> list = provinceMapper.findList(province);
        return list;
    }

    public List<Province> findAllList(Province province) {
        List<Province> allList = provinceMapper.findAllList(province);
        return allList;
    }

    public Page<Province> findPage(Page<Province> page,Province province){
        List<Province> provinceList = provinceMapper.findList(province);
        page.setData(provinceList);
        int filtered = super.findAllList(province).size();
        page.setRecordsFiltered(filtered);
        page.setRecordsTotal(filtered);
        return page;
    }

    @Transactional
    public int save(Province province) {
        super.save(province);
        return 0;
    }

    @Transactional
    public void deleteByPhysics(Province province){
        super.deleteByPhysics(province);
    }

    @Transactional
    public void deleteAllByPhysics(Province province){
        super.deleteByPhysics(province);
    }
}
