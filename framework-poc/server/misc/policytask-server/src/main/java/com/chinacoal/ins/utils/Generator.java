package com.chinacoal.ins.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wen
 * @date: 2018/10/18 17:51
 * @description:  Mybatis的实体类,SQL映射文件,Mapper接口的自动生成工具
 *  使用方法:
 *  1. 把mybatis-generator-core-1.3.2.jar导包
 *  2. 编写Generator生成文件
 *  3 .修改generatorConfig.xml配置文件
 *   (1),连库设置
 *   (2),实体类包路径,SQL映射文件包路径,Mapper接口包路径
 *   (3),table节点的表名和实体类名
 *  注意: 仔细检查table节点的实体类名,不要与项目中已有实体类同名,除非你想覆盖
 */
public class Generator {

	public static void main(String[] args) throws URISyntaxException {
		try {
			System.out.println("Generate ########################### 开始");
			List<String> warnings=new ArrayList<String>();
			boolean overwrite=true;
			ClassLoader classloader=Thread.currentThread().getContextClassLoader();
			InputStream is=classloader.getResourceAsStream("generator/generatorConfig.xml");
			ConfigurationParser cp=new ConfigurationParser(warnings);
			Configuration config=cp.parseConfiguration(is);
			DefaultShellCallback callback=new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
			myBatisGenerator.generate(null);
			System.out.println("Generate ########################### 完成");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		}
	}
}
