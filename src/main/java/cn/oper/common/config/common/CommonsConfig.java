package cn.oper.common.config.common;

import cn.oper.common.config.common.enums.FileTypeEnums;

public class CommonsConfig extends BaseConfig{

	private static String pictureBasePath;
	private static String resourceBasePath;
	
	
	static{
		String filePath = "/conf/commons.properties";
		FileTypeEnums fType = FileTypeEnums.PROPERTIES_FILE;
		init(new CommonsConfig(), filePath, fType);
	}

	public static String getPictureBasePath(){
		return pictureBasePath;
	}
	
	public static String getResourceBasePath(){
		return resourceBasePath;
	}

}
