package com.littlebuddha.housekeeping.common.utils;

import com.littlebuddha.housekeeping.entity.system.Menu;
import com.littlebuddha.housekeeping.entity.system.Operator;
import com.littlebuddha.housekeeping.entity.system.Role;
import com.littlebuddha.housekeeping.mapper.system.MenuMapper;
import com.littlebuddha.housekeeping.mapper.system.OperatorRoleMapper;
import com.littlebuddha.housekeeping.mapper.system.RoleMapper;
import com.littlebuddha.housekeeping.mapper.system.RoleMenuMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取当前登录用户信息
 * @author ck
 * @date 2020/7/29 15:03
 */
@Service
public class UserUtils {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private OperatorRoleMapper operatorRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    public static Operator getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
        Operator currentUser = (Operator) subject.getPrincipal();
        return currentUser;
    }

    /**
     * 获取当前登录者对象
     */
    public static Operator getPrincipal(){
        try{
            Subject subject = SecurityUtils.getSubject();
            Operator principal = (Operator)subject.getPrincipal();
            if (principal != null){
                return principal;
            }
//			subject.logout();
        }catch (UnavailableSecurityManagerException e) {

        }catch (InvalidSessionException e){

        }
        return null;
    }

    /**
     * 获取当前用户菜单列表
     */
    public List<Menu> getCurrentUserMenu(){
        Subject subject = SecurityUtils.getSubject();
        Operator principal = (Operator) subject.getPrincipal();
        //根据operator的id查询出角色，在set回operator
        List<String> roleIds = operatorRoleMapper.findByOperator(principal);
        List<Role> roles = roleMapper.findList(new Role());
        List<Role> operatorRoles = new ArrayList<>();//需要set给operator的list
        for (String roleId : roleIds) {
            for (Role role : roles) {
                if(roleId.length() != 0 && role != null && roleId.equals(role.getId())){
                    operatorRoles.add(role);
                }
            }
        }
        //需要将菜单列表设置
        List<Menu> menus = menuMapper.findList(new Menu());
        List<Menu> roleMenus = null;//通过角色查询菜单列表的中转list
        List<String> menuIds = new ArrayList<>();//用来存放已有角色的菜单列表
        //根据已经查找好的已有的operatorRoles列表来设置菜单
        for (Role operatorRole : operatorRoles) {
            menuIds = roleMenuMapper.findByRole(operatorRole);
        }



        principal.setRoles(operatorRoles);

        return null;
    }
}
