package com.littlebuddha.housekeeping.service.other;

import com.littlebuddha.housekeeping.entity.other.DataEntity;
import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ck
 * @date 2020/7/13 9:23
 */
public class BaseService<E extends DataEntity,M extends BaseMapper<E>> {

    /**
     * 持久层对象
     */
    @Autowired
    protected M mapper;

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public E get(String id) {
        return mapper.get(id);
    }

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public E get(E entity) {
        return mapper.get(entity);
    }

    /**
     * 查询列表数据
     * @param entity
     * @return
     */
    public List<E> findList(E entity) {
        return mapper.findList(entity);
    }


    /**
     * 查询所有列表数据
     * @param entity
     * @return
     */
    public List<E> findAllList(E entity) {
        return mapper.findAllList(entity);
    }

    /**
     *
     */
    public Page<E> findPage(Page<E> page,E entity){
        int filtered = mapper.findAllList(entity).size();
        page.setRecordsFiltered(filtered);
        page.setRecordsTotal(filtered);
        List<E> list = mapper.findList(entity);
        page.setData(list);
        return page;
    }

    /**
     * 保存数据（插入或更新）
     * @param entity
     */
    @Transactional(readOnly = false)
    public int save(E entity) {
        int row = 0;
        if (entity.getIsNewData()){
            entity.preInsert();
            row = mapper.insert(entity);
        }else{
            entity.preUpdate();
            row = mapper.update(entity);
        }
        return row;
    }

    public void deleteByLogic(E entity){
        mapper.deleteByLogic(entity);
    }

    public void deleteByPhysics(E entity){
        mapper.deleteByPhysics(entity);
    }
}
