package com.bocai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
}
