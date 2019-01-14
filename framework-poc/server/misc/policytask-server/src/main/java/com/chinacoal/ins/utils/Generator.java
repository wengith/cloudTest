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
 * @description:  Mybatis��ʵ����,SQLӳ���ļ�,Mapper�ӿڵ��Զ����ɹ���
 *  ʹ�÷���:
 *  1. ��mybatis-generator-core-1.3.2.jar����
 *  2. ��дGenerator�����ļ�
 *  3 .�޸�generatorConfig.xml�����ļ�
 *   (1),��������
 *   (2),ʵ�����·��,SQLӳ���ļ���·��,Mapper�ӿڰ�·��
 *   (3),table�ڵ�ı�����ʵ������
 *  ע��: ��ϸ���table�ڵ��ʵ������,��Ҫ����Ŀ������ʵ����ͬ��,�������븲��
 */
public class Generator {

	public static void main(String[] args) throws URISyntaxException {
		try {
			System.out.println("Generate ########################### ��ʼ");
			List<String> warnings=new ArrayList<String>();
			boolean overwrite=true;
			ClassLoader classloader=Thread.currentThread().getContextClassLoader();
			InputStream is=classloader.getResourceAsStream("generator/generatorConfig.xml");
			ConfigurationParser cp=new ConfigurationParser(warnings);
			Configuration config=cp.parseConfiguration(is);
			DefaultShellCallback callback=new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
			myBatisGenerator.generate(null);
			System.out.println("Generate ########################### ���");
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
