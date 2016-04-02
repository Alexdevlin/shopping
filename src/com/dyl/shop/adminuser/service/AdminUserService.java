package com.dyl.shop.adminuser.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.shop.adminuser.dao.AdminUserDao;
import com.dyl.shop.adminuser.vo.AdminUser;

/**
 * 
 * @Description:
 * @Author: duyunlei
 * @Date: 2016年4月2日 下午12:56:20
 */
@Service
@Transactional
public class AdminUserService {

  @Resource
  private AdminUserDao adminUserDao;

  public AdminUser login(String username, String password) {

    return adminUserDao.login(username, password);
  }

}
