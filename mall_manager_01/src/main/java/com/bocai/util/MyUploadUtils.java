package com.bocai.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MyUploadUtils {
//上传功能，返回文件的名称（时间戳+文件原始名称）
	//上传一个文件
	public static String upload_image(MultipartFile file) throws Exception{
		String image_name = "";
		if(!file.isEmpty()){
			image_name
				= System.currentTimeMillis() + file.getOriginalFilename();//时间戳+文件原始名称
			file.transferTo(new File(MyGetPropertiesUtils.getUploadPath()+"/"+image_name));
		}
		return image_name;
	}
	//批量上传
	public static List<String> upload_images(MultipartFile[] files) throws Exception{
		
		List<String> list = new ArrayList<String>();
		for (MultipartFile file : files) {
			if(!file.isEmpty()){
				String image_name
				= System.currentTimeMillis() + file.getOriginalFilename();//时间戳+文件原始名称
				file.transferTo(new File(MyGetPropertiesUtils.getUploadPath()+"/"+image_name));
				list.add(image_name);
			}
		}
		
		return list;
	}
}
