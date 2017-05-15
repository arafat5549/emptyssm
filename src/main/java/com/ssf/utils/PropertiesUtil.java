package com.ssf.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读取properties文件 键值对
 */
public class PropertiesUtil {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

	private static final String DEFAULT_MYBATIS_CONFIG_FILE="mybatis-config.xml";
	//private static SqlSessionFactory sqlSessionFactory;
	
	private static final Properties PROPERTIES = new Properties();
	
	static//编译时期
	{
		try {
			InputStream is = DataSourceFactory.class.getResourceAsStream("/jdbc.properties");
			PROPERTIES.load(is);
			for (Object key : PROPERTIES.keySet()) {
				System.out.println(key+","+PROPERTIES.getProperty((String) key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
	/////////////////// 读取Properties ////////////////////

//	public static Boolean getBoolean(Properties p, String name, Boolean defaultValue) {
//		return BooleanUtil.toBooleanObject(p.getProperty(name), defaultValue);
//	}
//
//	public static Integer getInt(Properties p, String name, Integer defaultValue) {
//		return NumberUtil.toIntObject(p.getProperty(name), defaultValue);
//	}
//
//	public static Long getLong(Properties p, String name, Long defaultValue) {
//		return NumberUtil.toLongObject(p.getProperty(name), defaultValue);
//	}
//
//	public static Double getDouble(Properties p, String name, Double defaultValue) {
//		return NumberUtil.toDoubleObject(p.getProperty(name), defaultValue);
//	}
//
//	public static String getString(Properties p, String name, String defaultValue) {
//		return p.getProperty(name, defaultValue);
//	}
//
//	/////////// 加载Properties////////
//	/**
//	 * 从文件路径加载properties.
//	 * 
//	 * 路径支持从外部文件或resources文件加载, "file://"或无前缀代表外部文件, "classpath://"代表resources,
//	 */
//	public static Properties loadFromFile(String generalPath) {
//		Properties p = new Properties();
//		InputStream is = null;
//		try {
//			is = URLResourceUtil.asStream(generalPath);
//			p.load(is);
//		} catch (IOException e) {
//			logger.warn("Load property from " + generalPath + " fail ", e);
//		} finally {
//			IOUtils.closeQuietly(is);
//		}
//		return p;
//	}
//
//	/**
//	 * 从字符串内容加载Properties
//	 */
//	public static Properties loadFromString(String content) {
//		Properties p = new Properties();
//		Reader reader = new StringReader(content);
//		try {
//			p.load(reader);
//		} catch (IOException ignored) {
//		} finally {
//			IOUtil.closeQuietly(reader);
//		}
//
//		return p;
//	}
}
