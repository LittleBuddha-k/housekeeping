package com.littlebuddha.housekeeping.mapper.other;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<E> {

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public E get(String id);

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public E get(E entity);

    /**
     * 根据实体名称和字段名称和字段值获取唯一记录
     *
     * @param propertyName
     * @param value
     * @return
     */
    public  E findUniqueByProperty(@Param(value="propertyName")String propertyName, @Param(value="value")Object value);


    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     * @param entity
     * @return
     */
    public List<E> findList(E entity);

    /**
     * 查询所有数据列表
     * @param entity
     * @return
     */
    public List<E> findAllList(E entity);

    /**
     * 查询所有数据列表
     * @see public List<T> findAllList(T entity)
     * @return
     */
    @Deprecated
    public List<E> findAllList();

    /**
     * 插入数据
     * @param entity
     * @return
     */
    public int insert(E entity);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    public int update(E entity);

    /**
     * 逻辑删除
     * @param entity
     */
    public void deleteByLogic(E entity);

    /**
     * 物理删除，数据不能恢复
     * @param entity
     */
    public void deleteByPhysics(E entity);
}
