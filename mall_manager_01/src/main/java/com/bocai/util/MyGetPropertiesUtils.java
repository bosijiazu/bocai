package com.bocai.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//在properties文件中获取上传路径
public class MyGetPropertiesUtils {

	public static String getUploadPath () throws IOException {
		
		InputStream inputStream
			= MyGetPropertiesUtils.class.getClassLoader().getResourceAsStream("uploadPath.properties");
		
		Properties properties = new Properties();
		
		properties.load(inputStream);
		
		String uploadPath = properties.getProperty("windows.imagePath");
		
		return uploadPath;
	}
}
