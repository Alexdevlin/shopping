package com.dyl.shop.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.shop.product.dao.ProductDao;
import com.dyl.shop.product.vo.Product;
import com.dyl.shop.utils.PageBean;

/**
 * 
 * @Description: 
 * @Author: duyunlei
 * @Date: 2016年4月2日 下午1:07:55
 */
@Service
@Transactional
public class ProductService {

	@Resource
	private ProductDao productDao;

	// 查询热门商品
	public List<Product> findHot() {
		return productDao.findHot();
	}

	// 查询最新的商品
	public List<Product> findNew() {
		return productDao.findNew();
	}

	// 根据pid查询商品详细信息

	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	public PageBean<Product> findByPageCid(Integer cid, int page) {

		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCid(cid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Product> findAll(Integer page) {

		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPage(page);
		int limit = 10;
		pageBean.setLimit(limit);
		int totalCount = 0;
		totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);

		int totalPage = 0;
		if (totalCount % limit == 0) {

			totalPage = totalCount / limit;
		} else {

			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);

		int begin = (page - 1) * limit;

		List<Product> list = productDao.findPage(begin, limit);

		pageBean.setList(list);
		return pageBean;
	}

	public void save(Product product) {

		
		productDao.save(product);
	}

	public void delete(Product product) {

		productDao.delete(product);
	}

	public void update(Product product) {

	
		productDao.update(product);
	}
}
