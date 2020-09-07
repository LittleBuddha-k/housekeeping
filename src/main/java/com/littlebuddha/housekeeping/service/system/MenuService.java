package com.littlebuddha.housekeeping.service.system;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Menu;
import com.littlebuddha.housekeeping.mapper.system.MenuMapper;
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

    public List<Menu> findMenuByOperator(Menu menu) {
        List<Menu> dataMenus = new ArrayList<>();
        List<Menu> list = menuMapper.findList(menu);
        //一级菜单
        for (Menu oneMenu : list) {
            if ("1".equals(oneMenu.getParentId())) {
                dataMenus.add(oneMenu);//加入一级菜单
            }
        }
        //通过一级菜单查询二级菜单
        if (dataMenus.size() > 0) {
            for (Menu firstMenu : dataMenus) {
                firstMenu.setChildrenMenus(menuMapper.findChildrenList(firstMenu));
                //通过二级菜单查询三级菜单
                for (Menu secondMenu : firstMenu.getChildrenMenus()) {
                    secondMenu.setChildrenMenus(menuMapper.findChildrenList(secondMenu));
                    //通过三级菜单查询四级菜单
                    for (Menu threeMenu : secondMenu.getChildrenMenus()) {
                        threeMenu.setChildrenMenus(menuMapper.findChildrenList(threeMenu));
                        //通过四级菜单查询五级菜单
                        for (Menu fourMenu : threeMenu.getChildrenMenus()) {
                            fourMenu.setChildrenMenus(menuMapper.findChildrenList(fourMenu));
                        }
                    }
                }
            }
        }
        return dataMenus;
    }

    public Page<Menu> findPage(Page<Menu> page, Menu menu) {
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
    public void deleteByLogic(Menu menu) {
        menuMapper.deleteByLogic(menu);
    }

    @Transactional
    public void deleteByPhysics(Menu menu) {
        menuMapper.deleteByPhysics(menu);
    }
}
