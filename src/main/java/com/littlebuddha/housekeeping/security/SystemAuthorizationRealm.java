package com.littlebuddha.housekeeping.security;

import com.littlebuddha.housekeeping.common.utils.MD5Encryption;
import com.littlebuddha.housekeeping.entity.systemsettings.Operator;
import com.littlebuddha.housekeeping.mapper.systemsettings.MenuMapper;
import com.littlebuddha.housekeeping.mapper.systemsettings.OperatorMapper;
import com.littlebuddha.housekeeping.mapper.systemsettings.RoleMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author ck
 * @date 2020/7/6 15:04
 */
@Service
public class SystemAuthorizationRealm extends AuthorizingRealm {

    @Autowired
    private OperatorMapper operatorMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String name = usernamePasswordToken.getUsername();
        String password = String.valueOf(usernamePasswordToken.getPassword());

        //根据token的用户、密码去数据库查询是否存在
        Operator operator = operatorMapper.selectByName(name);

        if(operator == null) {
            throw new UnknownAccountException("账户不存在");
        }

        String passwordEncryption = MD5Encryption.getEncryptionPassword(password,operator.getSalt());

        if(!passwordEncryption.equals(operator.getPassword())){
            throw new CredentialsException("密码错误");
        }
        //返回的信息是从数据库中取出的的信息
        return new SimpleAuthenticationInfo(operator,password, ByteSource.Util.bytes(operator.getSalt()),getName());
    }

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //根据身份信息
        Operator principal = (Operator) principalCollection.getPrimaryPrincipal();
        //连接数据库
        //查询角色列表
        Set<String> roles = roleMapper.findRolesByOperator(principal);
        //查询权限列表
        Set<String> permissions = menuMapper.findPermissionsByOperator(principal);
        //todo查询权限,根据user的id查询权限表的权限

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上面查询到的权限列表赋值给SimpleAuthorizationInfo并返回
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 修改权限后调用此方法，立即清空本地缓存，修改立即生效
     */
    public void clearCached(){
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principalCollection);
    }
}
