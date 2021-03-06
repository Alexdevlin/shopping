package com.dyl.shop.adminuser.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dyl.shop.adminuser.vo.AdminUser;

/**
 * 
 * @Description:
 * @Author: duyunlei
 * @Date: 2016年4月2日 下午12:54:48
 */
@Repository
public class AdminUserDao {

  @Resource
  private SessionFactory sessionFactory;

  public AdminUser login(String username, String password) {

    return (AdminUser) sessionFactory.getCurrentSession().createQuery("from AdminUser where username=? and password =?").setParameter(0, username).setParameter(1, password).uniqueResult();
  }

}
