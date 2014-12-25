package cn.oper.common.config.manage;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.DefaultConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ConfigurationManager {
	
	private Logger logger = LoggerFactory.getLogger(ConfigurationManager.class);
	
	private Configuration configuration;
	
	//XML文件路径
	private static String xmlPath = ConfigurationManager.class.getClass().getResource("/config.xml").toString();
	
	
	/**
	 * 通过内部类实现单例模式,优点可以实现赖加载又避免了线程安全问题
	 */
	static class ConfigurationInstance{
		private static ConfigurationManager manager = new ConfigurationManager();
	}

	/**
	 * 构造器私有化
	 */
	private ConfigurationManager(){
		loadingConfiguration();
	}
	
	/**
	 * 对外暴露一个钩子
	 */
	public static ConfigurationManager getInstance(){
		return ConfigurationInstance.manager;
	}
	
	public static ConfigurationManager getInstance(String xmlName){
		xmlPath = xmlName;
		ConfigurationManager configurationManager  =  ConfigurationInstance.manager;
		return configurationManager;
	}
	
	/**
	 * 返回配置文件操作句柄
	 * @return		Configuration
	 */
	public Configuration getConfiguration(){
		return this.configuration;
	}
	
	/**
	 * 加载配置文件
	 */
	public void loadingConfiguration(){
		
		try {

			DefaultConfigurationBuilder configurationBuilder = new DefaultConfigurationBuilder(xmlPath);
			this.configuration = configurationBuilder.getConfiguration();
			
		} catch (ConfigurationException e) {
			logger.warn("'xmlPath' file no exist: xmlPath="+xmlPath);
//			e.printStackTrace();
		}
		
	}

}
