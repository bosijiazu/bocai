package com.bocai.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bocai.bean.T_MALL_PRODUCT;

public interface Spu_Publish_Service {

	//往商品表插入数据
	void insert_product(T_MALL_PRODUCT t_mall_product);

	//第二步：往商品图片表添加图片
	void insert_product_image(int id, List<String> upload_images);

	//根据一级分类、二级分类和商标id查询所有的商品信息
	List<T_MALL_PRODUCT> select_spu_by_class_1_2_tm_id(int class_1_id, int class_2_id, int tm_id);

}
