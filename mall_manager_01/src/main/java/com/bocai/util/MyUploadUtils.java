package com.bocai.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MyUploadUtils {
//�ϴ����ܣ������ļ������ƣ�ʱ���+�ļ�ԭʼ���ƣ�
	//�ϴ�һ���ļ�
	public static String upload_image(MultipartFile file) throws Exception{
		String image_name = "";
		if(!file.isEmpty()){
			image_name
				= System.currentTimeMillis() + file.getOriginalFilename();//ʱ���+�ļ�ԭʼ����
			file.transferTo(new File(MyGetPropertiesUtils.getUploadPath()+"/"+image_name));
		}
		return image_name;
	}
	//�����ϴ�
	public static List<String> upload_images(MultipartFile[] files) throws Exception{
		
		List<String> list = new ArrayList<String>();
		for (MultipartFile file : files) {
			if(!file.isEmpty()){
				String image_name
				= System.currentTimeMillis() + file.getOriginalFilename();//ʱ���+�ļ�ԭʼ����
				file.transferTo(new File(MyGetPropertiesUtils.getUploadPath()+"/"+image_name));
				list.add(image_name);
			}
		}
		
		return list;
	}
}
