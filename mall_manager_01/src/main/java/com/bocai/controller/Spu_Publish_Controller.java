package com.bocai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bocai.bean.T_MALL_PRODUCT;
import com.bocai.service.Spu_Publish_Service;
import com.bocai.util.MyUploadUtils;

@Controller
public class Spu_Publish_Controller {

	@Autowired
	Spu_Publish_Service spu_Publish_Service;
	
	@RequestMapping("goto_Spu_Publish")
	public String goto_Spu_Publish(){
		return "manager/spu_publish";
	}
	
	@RequestMapping(value="spu_Publish",method=RequestMethod.POST)
	public String spu_Publish(T_MALL_PRODUCT t_mall_product,@RequestParam("files") MultipartFile[] files) throws Exception{
		//��һ�����ϴ�ͼƬ
		List<String> upload_images = MyUploadUtils.upload_images(files);
		//�ڶ���������Ʒ���������
		t_mall_product.setShp_tp(upload_images.get(0));//���ϴ��ĵ�һ��ͼƬ����Ϊͷͼ
		spu_Publish_Service.insert_product(t_mall_product);
		//������������ƷͼƬ�����ͼƬ
		spu_Publish_Service.insert_product_image(t_mall_product.getId(),upload_images);
		//���Ĳ���Ϊ��ֹ�ظ��ύ���ض���ط���ҳ��
		return "redirect:/goto_Spu_Publish.do";
	}
}
