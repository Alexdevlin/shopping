package com.dyl.shop.category.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dyl.shop.category.service.CategoryService;
/**
 * 
 * @Description: 
 * @Author: duyunlei
 * @Date: 2016年4月2日 下午1:01:06
 */
@Controller
@Scope("prototype")
public class CategoryAction {

  @Resource
  private CategoryService categoryService;

}
