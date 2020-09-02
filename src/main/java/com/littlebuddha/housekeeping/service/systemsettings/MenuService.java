package com.littlebuddha.housekeeping.service.systemsettings;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.systemsettings.Menu;
import com.littlebuddha.housekeeping.mapper.systemsettings.MenuMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService extends BaseService<Menu, MenuMapper> {

    @Autowired
    private MenuMapper menuMapper;

    public Menu get(String id) {
        return menuMapper.get(id);
    }

    public List<Menu> findList(Menu menu) {
        List<Menu> list = menuMapper.findList(menu);
        return list;
    }

    public List<Menu> findMenuByOperator(Menu menu){
        List<Menu> menus = menuMapper.findMenuByOperator(menu);
        List<Menu> parentMenus = new ArrayList<>();
        return menus;
    }

    public Page<Menu> findPage(Page<Menu> page,Menu menu){
        Page<Menu> menuPage = super.findPage(page, menu);
        return menuPage;
    }

    public Page<Menu> findParentPage(Page<Menu> page, Menu menu) {
        Page<Menu> menuPage = super.findPage(page, menu);
        return menuPage;
    }

    public Page<Menu> findChildrenPage(Page<Menu> page, Menu menu) {

        Page<Menu> menuPage = super.findPage(page, menu);
        List<Menu> menus = menuPage.getData();
        List<Menu> childrenMenus = menus;
        return menuPage;
    }

    @Transactional
    public int save(Menu menu) {
        int row = super.save(menu);
        return row;
    }

    @Transactional
    public void deleteByLogic(Menu menu){
        menuMapper.deleteByLogic(menu);
    }

    @Transactional
    public void deleteByPhysics(Menu menu){
        menuMapper.deleteByPhysics(menu);
    }
}
