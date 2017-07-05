package com.demo.common.tag;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import com.demo.entity.Permission;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.util.AuthUtil;

public class GIPSRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		System.out.println(" go here doGetAuthorizationInfo");
		User user = AuthUtil.getCurrentUser();
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
        simpleAuthorInfo.addRoles(getRoles(user));
        simpleAuthorInfo.addStringPermissions(getPermCodes(user));
        return simpleAuthorInfo;
	}

	/**
     * 获取权限，string存放的是权限编码
     * @param user
     * @return
     */
    private List<String> getPermCodes(User user) {

        List<String> perms = new ArrayList<String>();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            List<Permission> _perms = role.getPermissions();
            for (Permission _perm : _perms) {
                perms.add(_perm.getPermCode());
            }
        }
        return perms;
    }


    /**
     * 获取角色集合，string存放的角色名称
     * @param user
     * @return
     */
    private List<String> getRoles(User user) {

        List<String> roles = new ArrayList<String>();
        for (Role role : user.getRoles()) {
            roles.add(role.getRoleName());
        }
        return roles;
    }
    
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println(" go here doGetAuthenticationInfo");
		UsernamePasswordToken token = (UsernamePasswordToken)arg0; 
        User user = null ;//userService.findByAccountName(token.getUsername()) ;//通过帐号获取用户实例

        if (user != null && ByteSource.Util.bytes(token.getPassword())
                .equals(ByteSource.Util.bytes(user.getPassword()))) {//用户校验
            setSessionInfo(user);
            return  new SimpleAuthenticationInfo(user.getAccountName(), user.getPassword(), user.getNickName());   //验证成功之后进行授权
        }

        return null ;
	}
	
	 private void setSessionInfo(User user){

	        Subject sub = SecurityUtils.getSubject();
	        Session session = sub.getSession();

	        //显示的设置权限和角色，避免下次再去数据库获取，提高效率
	        List<Role> roles = user.getRoles();
	        for (int i = 0; i < roles.size(); i++) {
	            Role role = roles.get(i);
	            List<Permission> perms = role.getPermissions();
	            for (Permission permission : perms) {}
	            role.setPermissions(perms);
	            roles.set(i,role);
	        }
	        user.setRoles(roles);

	        session.setAttribute("CURRENT_USER", user);
	    }

}
