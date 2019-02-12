package com.wuxin.tong;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: tongly
 * @contact:wuxin@yscredit.com
 * @file: MyShiroRealm
 * @time: 2018/12/8 11:29
 * @desc:
 */
public class MyShiroRealm  {

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        logger.info("-----授权-----");
//        Object user = null;
////        User user = (User) principalCollection.getPrimaryPrincipal();
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
////        authorizationInfo.setRoles(userAuthService.findRoles(user));
////        authorizationInfo.setStringPermissions(userAuthService.findPermissions(user));
//        return authorizationInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        logger.info("-----认证-----");
//        // 将AuthenticationToken转化为UsernamePasswordToken
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        // 从token中得到用户名和密码
//        String username = token.getUsername().trim();
//        String password = "";
//        if (token.getPassword() != null) {
//            password = new String(token.getPassword());
//        }
//        logger.info("-----username:{},password:{}-----", username, password);
//        Object user = null;
////        User user = userAuthService.login(username, password);
//        if (user != null) {
//            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password.toCharArray(), getName());
//            return info;
//        }
//        return null;
//    }
}