package com.dyl.shop.categorysecond.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dyl.shop.categorysecond.vo.CategorySecond;
import com.dyl.shop.product.vo.Product;

/**
 * 
 * @Description:
 * @Author: duyunlei
 * @Date: 2016年4月2日 下午1:03:14
 */
@Repository
public class CategorySecondDao {

  @Resource
  private SessionFactory sessionFactory;

  public int findCount() {

    Long l = (long) sessionFactory.getCurrentSession().createQuery("select count(*) from CategorySecond ").uniqueResult();

    return l.intValue();
  }

  public List<CategorySecond> findPage(int begin, int limit) {

    return sessionFactory.getCurrentSession().createQuery("from CategorySecond").setFirstResult(begin).setMaxResults(limit).list();
  }

  public void save(CategorySecond categorySecond) {

    sessionFactory.getCurrentSession().save(categorySecond);
  }

  public CategorySecond findByCsid(Integer csid) {
    return (CategorySecond) sessionFactory.getCurrentSession().createQuery("from CategorySecond where csid = ?").setParameter(0, csid).uniqueResult();
  }

  public void delete(CategorySecond categorySecond) {

    sessionFactory.getCurrentSession().delete(categorySecond);

  }

  public void update(CategorySecond categorySecond) {

    sessionFactory.getCurrentSession().update(categorySecond);

  }

  public List<CategorySecond> findAll() {
    return sessionFactory.getCurrentSession().createQuery("from CategorySecond ").list();
  }

}
