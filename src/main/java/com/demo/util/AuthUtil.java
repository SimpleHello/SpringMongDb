package com.demo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


import com.demo.entity.Permission;
import com.demo.entity.Role;
import com.demo.entity.User;

public class AuthUtil {
	 /**
     * 获取当前用户
     * @return
     */
    public static User  getCurrentUser(){ 
        Subject sub = SecurityUtils.getSubject();
        Session session = sub.getSession();
        User user = (User) session.getAttribute("CURRENT_USER");
        return user ;
    }


    /**
     * 在用户中获取权限信息
     * @return
     */
    public static List<Permission>  getCurrentUserPermissions() {

        User user = AuthUtil.getCurrentUser();
        List<Permission> perms = new ArrayList<Permission>();
        for (Role role : user.getRoles()) {
            for (Permission permission : role.getPermissions()) {
                perms.add(permission);
            }
        }

        perms = filterRepAndSort(perms);

        return perms;
    }


    /**
     * 去重，排序
     * @param perms
     * @return
     */
    private static List<Permission> filterRepAndSort(List<Permission> perms) {

         for ( int i = 0 ; i < perms.size() - 1 ; i++ ) {  
             for ( int j = perms.size() - 1 ; j > i; j-- ) {  
               if (perms.get(j).getOrderNo() == perms.get(i).getOrderNo()) {  
                   perms.remove(j);  
               }   
              }   
            }   

        Collections.sort(perms, new Comparator<Permission>() {

            @Override
            public int compare(Permission p1, Permission p2) {
                return p1.getOrderNo() - p2.getOrderNo();
            }

        });

        return perms;

    }
}