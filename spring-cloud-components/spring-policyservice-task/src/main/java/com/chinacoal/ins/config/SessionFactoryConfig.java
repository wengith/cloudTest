package com.chinacoal.ins.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author: wen
 * @date: 2019/1/7 15:48
 * @description:
 */

//@Configuration
public class SessionFactoryConfig {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	@Value("${mybatis.mybatisConfigFilePath}")
	private String mybatisConfigFilePath;
	@Value("${mybatis.mapper-locations}")
	private String mapperPath;
	@Value("${mybatis.entityPackage}")
	private String entityPackage;

	@Value("${pagehelper.offsetAsPageNum}")
	private String offsetAsPageNum;
	@Value("${pagehelper.rowBoundsWithCount}")
	private String rowBoundsWithCount;
	@Value("${pagehelper.supportMethodsArguments}")
	private String supportMethodsArguments;
	@Value("${pagehelper.helperDialect}")
	private String helperDialect;
	@Value("${pagehelper.reasonable}")
	private String reasonable;

	@Primary
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
		sessionFactory.setMapperLocations(resolver.getResources(packageSearchPath));
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setTypeAliasesPackage(entityPackage);

		//分页插件
		PageInterceptor pageInterceptor = this.initPageInterceptor();
		sessionFactory.setPlugins(new Interceptor[] {pageInterceptor});

		return sessionFactory;
	}

	public PageInterceptor initPageInterceptor(){
		PageInterceptor pageInterceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.setProperty("helperDialect", helperDialect);
		properties.setProperty("offsetAsPageNum", offsetAsPageNum);
		properties.setProperty("rowBoundsWithCount", rowBoundsWithCount);
		properties.setProperty("supportMethodsArguments",supportMethodsArguments);
		properties.setProperty("reasonable", reasonable);
		pageInterceptor.setProperties(properties);
		return pageInterceptor;
	}
}
