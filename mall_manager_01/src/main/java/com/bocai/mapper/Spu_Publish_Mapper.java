package com.bocai.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.bocai.bean.T_MALL_PRODUCT;

public interface Spu_Publish_Mapper {
	//����Ʒ���������
	void insert_product(T_MALL_PRODUCT t_mall_product);

	//�ڶ���������ƷͼƬ�����ͼƬ
	void insert_product_image(@Param("id") int id,@Param("upload_images") List<String> upload_images);

}
