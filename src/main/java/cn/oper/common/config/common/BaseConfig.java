package cn.oper.common.config.common;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.oper.common.config.common.enums.FileTypeEnums;

public class BaseConfig {

	private static Log logger = LogFactory.getLog(BaseConfig.class);
	
	/**
	 * 将指定配置文件中的Value装载到实体对象中
	 * @param filePath		配置文件路径
	 * @param obj			实体Bean
	 */
	protected static void init(BaseConfig obj, String filePath, FileTypeEnums fType){
		
		Map<String, Object> configMap = getConfigValue(filePath, fType);
		if(null == configMap){
			logger.error("初始化注入配置文件 参数失败");
			return;
		}
		try {
			String fieldName = "";
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				//判断,目标字段修饰符只能为: private static
				if(field.getModifiers() != 10){
					continue;
				}
				fieldName = field.getName();
				if(null == fieldName){
					continue;
				}
				field.setAccessible(true);	////将私有成员设置为可访问
				field.set(fieldName, configMap.get(fieldName.toUpperCase()));
				logger.info(fieldName + " = " + configMap.get(fieldName.toUpperCase()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取配置文件中的值
	 * @param filePath		配置文件路径
	 * @param fType			配置文件类型
	 * @return				Map<String, Object>
	 */
	private static Map<String, Object> getConfigValue(String filePath, FileTypeEnums fType){
		CompositeConfiguration config = getConfiguration(filePath, fType);
		return parseConfigToMap(config);
	}
	
	/**
	 * 解析配置文件
	 * @param config	CompositeConfiguration
	 * @return			Map<String, Object>
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, Object> parseConfigToMap(CompositeConfiguration config){
		if(null == config){
			return null;
		}
		String key = "", value = "";
		Map<String, Object> configMap = new HashMap<String, Object>();
		Iterator<String> iterator = config.getKeys();
		
		while(iterator.hasNext()){
			key = iterator.next();
			value = config.getString(key, "");
			
			key = key.replaceAll("_", "").toUpperCase();
			
			configMap.put(key, value);
		}
		return configMap;
	}
	
	
	/**
	 * 生成指定配置文件类型的 Configuration
	 * @param filePath		配置文件路径
	 * @param fType			配置文件类型
	 * @return				CompositeConfiguration
	 */
	private static CompositeConfiguration getConfiguration(String filePath, FileTypeEnums fType) {
		
		CompositeConfiguration config = null;
		try {
			if(FileTypeEnums.XML_FILE.equals(fType)){
				config = new CompositeConfiguration();
				XMLConfiguration xmlConfig = new XMLConfiguration(filePath);
				config.addConfiguration(xmlConfig);
			}else if(FileTypeEnums.PROPERTIES_FILE.equals(fType)){
				config = new CompositeConfiguration();
				PropertiesConfiguration propertiesConfig = new PropertiesConfiguration(filePath);
				config.addConfiguration(propertiesConfig);
			}
		} catch (Exception e) {
			logger.error("装载配置文件出错, 配置文件路径为: "+filePath);
			e.printStackTrace();
			return null;
		}
		return config;
	}
	
	
}
