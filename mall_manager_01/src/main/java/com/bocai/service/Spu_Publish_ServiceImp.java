package com.bocai.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bocai.bean.T_MALL_PRODUCT;
import com.bocai.mapper.Spu_Publish_Mapper;

@Service
public class Spu_Publish_ServiceImp implements Spu_Publish_Service {

	@Autowired
	Spu_Publish_Mapper spu_Publish_Mapper;

	//往商品表插入数据
	@Override
	public void insert_product(T_MALL_PRODUCT t_mall_product) {
		spu_Publish_Mapper.insert_product(t_mall_product);
	}

	//往商品图片表添加图片
	@Override
	public void insert_product_image(int id, List<String> upload_images) {
		spu_Publish_Mapper.insert_product_image(id,upload_images);
	}

	//根据一级分类、二级分类和商标id查询所有的商品信息
	@Override
	public List<T_MALL_PRODUCT> select_spu_by_class_1_2_tm_id(int class_1_id, int class_2_id, int tm_id) {
		Map map = new HashMap();
		map.put("class_1_id", class_1_id);
		map.put("class_2_id", class_2_id);
		map.put("tm_id", tm_id);
		List<T_MALL_PRODUCT> list = spu_Publish_Mapper.select_spu_by_class_1_2_tm_id(map);
		return list;
	}
}
