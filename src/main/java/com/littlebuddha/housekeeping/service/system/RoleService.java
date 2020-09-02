package com.littlebuddha.housekeeping.service.system;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Role;
import com.littlebuddha.housekeeping.mapper.system.RoleMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService extends BaseService<Role, RoleMapper> {

    @Autowired
    private RoleMapper roleMapper;

    public Role get(String id) {
        return roleMapper.get(id);
    }

    public List<Role> findList(Role role) {
        List<Role> list = roleMapper.findList(role);
        return list;
    }

    public Page<Role> findPage(Page<Role> page,Role role){
        Page<Role> menuPage = super.findPage(page, role);
        return menuPage;
    }

    @Transactional
    public int save(Role role) {
        int row = super.save(role);
        return row;
    }

    @Transactional
    public void deleteByLogic(Role role){
        roleMapper.deleteByLogic(role);
    }

    @Transactional
    public void deleteByPhysics(Role role){
        roleMapper.deleteByPhysics(role);
    }
}
