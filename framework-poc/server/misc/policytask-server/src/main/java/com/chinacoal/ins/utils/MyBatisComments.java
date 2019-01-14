package com.chinacoal.ins.utils;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

/**
 * @description:MyBatis 自动生成添加中文注释
 *
 */
public class MyBatisComments extends DefaultCommentGenerator{
	private Properties	properties;
	private Properties	systemPro;
	private boolean		suppressDate;
	private boolean		suppressAllComments;
	private String		currentDateStr;
	public MyBatisComments(){
		super();
		properties=new Properties();
		systemPro=System.getProperties();
		suppressDate=false;
		suppressAllComments=false;
		currentDateStr=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	}
	public void addJavaFileComment(CompilationUnit compilationUnit){
		return;
	}
	public void addComment(XmlElement xmlElement){
		return;
	}
	public void addRootComment(XmlElement rootElement){
		return;
	}
	public void addConfigurationProperties(Properties properties){
		this.properties.putAll(properties);
		suppressDate=isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
		suppressAllComments=isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
	}
	protected void addJavadocTag(JavaElement javaElement,boolean markAsDoNotDelete){
		javaElement.addJavaDocLine(" *");
		StringBuilder sb=new StringBuilder();
		sb.append(" * ");
		sb.append(MergeConstants.NEW_ELEMENT_TAG);
		if (markAsDoNotDelete) {
			sb.append(" do_not_delete_during_merge");
		}
		String s=getDateString();
		if (s!=null) {
			sb.append(s);
		}
		javaElement.addJavaDocLine(sb.toString());
	}
	protected String getDateString(){
		String result=null;
		if (!suppressDate) {
			result=currentDateStr;
		}
		return result;
	}
	/**
	 * 类注释
	 */
	public void addClassComment(InnerClass innerClass,IntrospectedTable introspectedTable){
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb=new StringBuilder();
		innerClass.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append(" ");
		sb.append(getDateString());
		innerClass.addJavaDocLine(sb.toString().replace("\n"," "));
		innerClass.addJavaDocLine(" */");
	}
	/**
	 * 枚举字段注释
	 */
	public void addEnumComment(InnerEnum innerEnum,IntrospectedTable introspectedTable){
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb=new StringBuilder();
		innerEnum.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		innerEnum.addJavaDocLine(sb.toString().replace("\n"," "));
		innerEnum.addJavaDocLine(" */");
	}
	/**
	 *Dto字段注释
	 */
	public void addFieldComment(Field field,IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn){
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb=new StringBuilder();
		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		field.addJavaDocLine(sb.toString().replace("\n"," "));
		field.addJavaDocLine(" */");
	}
	/**
	 * Mapping类字段注释
	 */
	public void addFieldComment(Field field,IntrospectedTable introspectedTable){
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb=new StringBuilder();
		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(field.getName());
		field.addJavaDocLine(sb.toString().replace("\n"," "));
		field.addJavaDocLine(" */");
	}
	/**
	 * 方法注释
	 */
	public void addGeneralMethodComment(Method method,IntrospectedTable introspectedTable){
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb=new StringBuilder();
		method.addJavaDocLine("/**");
		sb.append(" * ");
		method.addJavaDocLine(sb.toString().replace("\n"," "));
		sb.setLength(0);
		sb.append(" * description:");
		sb.append(method.getName());
		method.addJavaDocLine(sb.toString().replace("\n"," "));
		sb.setLength(0);
		sb.append(" * @author:  ");
		sb.append(systemPro.getProperty("user.name"));
		method.addJavaDocLine(sb.toString().replace("\n"," "));
		sb.setLength(0);
		sb.append(" * @date: ");
		sb.append(currentDateStr);
		method.addJavaDocLine(sb.toString().replace("\n"," "));
		sb.setLength(0);
		sb.append(" * @since: 1.0");
		method.addJavaDocLine(sb.toString().replace("\n"," "));
		method.addJavaDocLine(" */");
	}
	/**
	 * get方法注释
	 */
	public void addGetterComment(Method method,IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn){
		if (suppressAllComments) {
			return;
		}
		method.addJavaDocLine("/**");
		StringBuilder sb=new StringBuilder();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString().replace("\n"," "));
		sb.setLength(0);
		sb.append(" * @return ");
		sb.append(introspectedColumn.getActualColumnName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString().replace("\n"," "));
		method.addJavaDocLine(" */");
	}
	/**
	 * set方法注释
	 */
	public void addSetterComment(Method method,IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn){
		if (suppressAllComments) {
			return;
		}
		method.addJavaDocLine("/**");
		StringBuilder sb=new StringBuilder();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString().replace("\n"," "));
		Parameter parm=method.getParameters().get(0);
		sb.setLength(0);
		sb.append(" * @param ");
		sb.append(parm.getName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString().replace("\n"," "));
		method.addJavaDocLine(" */");
	}
	/**
	 * 类注释
	 */
	public void addClassComment(InnerClass innerClass,IntrospectedTable introspectedTable,boolean markAsDoNotDelete){
		if (suppressAllComments) {
			return;
		}
		StringBuilder sb=new StringBuilder();
		innerClass.addJavaDocLine("/**");
		sb.append(" * 描述:");
		sb.append(introspectedTable.getFullyQualifiedTable()+"表的实体类");
		innerClass.addJavaDocLine(sb.toString().replace("\n"," "));
		sb.setLength(0);
		sb.append(" * @version");
		innerClass.addJavaDocLine(sb.toString().replace("\n"," "));
		sb.setLength(0);
		sb.append(" * @author:  ");
		sb.append(systemPro.getProperty("user.name"));
		innerClass.addJavaDocLine(sb.toString().replace("\n"," "));
		sb.setLength(0);
		sb.append(" * @创建时间: ");
		sb.append(currentDateStr);
		innerClass.addJavaDocLine(sb.toString().replace("\n"," "));
		innerClass.addJavaDocLine(" */");
	}
}
