package com.bocai.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bocai.bean.T_MALL_PRODUCT;

public interface Spu_Publish_Service {

	//����Ʒ����������
	void insert_product(T_MALL_PRODUCT t_mall_product);

	//�ڶ���������ƷͼƬ������ͼƬ
	void insert_product_image(int id, List<String> upload_images);

}