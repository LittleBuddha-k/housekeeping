package com.littlebuddha.housekeeping.service.system;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Menu;
import com.littlebuddha.housekeeping.mapper.system.MenuMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.apache.commons.lang3.StringUtils;
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

    public Page<Menu> findPage(Page<Menu> page, Menu menu) {
        Page<Menu> menuPage = super.findPage(page, menu);
        return menuPage;
    }

    public List<Menu> findMenuByOperator(Menu menu){
        List<Menu> menuByOperator = menuMapper.findMenuByOperator(menu);
        return menuByOperator;
    }

    public Menu findTheBiggestMenu(Menu menu){
        Menu theBiggestMenu = menuMapper.findTheBiggestMenu(menu);
        return theBiggestMenu;
    };

    public List<Menu> findLevelOneMenus(Menu menu){
        List<Menu> operatorsMenus = findMenuByOperator(menu);
        Menu parentMenus = findTheBiggestMenu(menu);
        List<Menu> levelOneMenus = new ArrayList<>();
        for (Menu operatorsMenu : operatorsMenus) {
            if (parentMenus != null && StringUtils.isNotBlank(parentMenus.getId()) && parentMenus.getId().equals(operatorsMenu.getParentId())){
                levelOneMenus.add(operatorsMenu);
            }
        }
        return levelOneMenus;
    }

    @Transactional
    public int save(Menu menu) {
        if(menu.getParentId() == null || StringUtils.isBlank(menu.getParentId())){
            Menu theBiggestMenu = findTheBiggestMenu(menu);
            menu.setParentId(theBiggestMenu.getId());
        }
        int row = super.save(menu);
        return row;
    }

    @Transactional
    public void deleteByLogic(Menu menu) {
        menuMapper.deleteByLogic(menu);
    }

    @Transactional
    public void deleteByPhysics(Menu menu) {
        menuMapper.deleteByPhysics(menu);
    }
}
