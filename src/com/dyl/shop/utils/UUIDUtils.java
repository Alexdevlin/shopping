package com.dyl.shop.utils;

import java.util.UUID;

/**
 * 
 * @Description: 生成UUID工具类
 * @Author: duyunlei
 * @Date: 2016年4月2日 下午1:10:33
 */
public class UUIDUtils {
	
	public static String getUUID(){
		
		return UUID.randomUUID().toString().replace("-", "");
	}

}
