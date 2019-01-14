package com.github.pagehelper.dialect.helper;


import com.github.pagehelper.Page;
import com.github.pagehelper.dialect.AbstractHelperDialect;
import com.github.pagehelper.util.MetaObjectUtil;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.reflection.MetaObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: wen
 * @date: 2019/1/9 10:33
 * @description: 重写PageHelper的OracleDialect类方法，优先加载该类。
 */
public class OracleDialect extends AbstractHelperDialect {

	@Override
	public Object processPageParameter(MappedStatement ms, Map<String, Object> paramMap, Page page, BoundSql boundSql, CacheKey pageKey)
	{
		paramMap.put("First_PageHelper", Integer.valueOf(page.getEndRow()));
		paramMap.put("Second_PageHelper", Integer.valueOf(page.getStartRow()));

		pageKey.update(Integer.valueOf(page.getEndRow()));
		pageKey.update(Integer.valueOf(page.getStartRow()));
		if (boundSql.getParameterMappings() != null)
		{
			List<ParameterMapping> newParameterMappings = new ArrayList();
			if ((boundSql != null) && (boundSql.getParameterMappings() != null)) {
				newParameterMappings.addAll(boundSql.getParameterMappings());
			}
			newParameterMappings.add(new ParameterMapping.Builder(ms.getConfiguration(), "First_PageHelper", Integer.class).build());
			newParameterMappings.add(new ParameterMapping.Builder(ms.getConfiguration(), "Second_PageHelper", Integer.class).build());
			MetaObject metaObject = MetaObjectUtil.forObject(boundSql);
			metaObject.setValue("parameterMappings", newParameterMappings);
		}
		return paramMap;
	}

	@Override
	public String getPageSql(String sql, Page page, CacheKey pageKey)
	{
		StringBuilder sqlBuilder = new StringBuilder(sql.length() + 120);
		sqlBuilder.append("SELECT * FROM ( ");
		sqlBuilder.append(" SELECT TMP_PAGE.*, ROWNUM PAGE_ROW FROM ( ");
		sqlBuilder.append(sql);
		sqlBuilder.append(" ) TMP_PAGE WHERE ROWNUM <= ? ");
		sqlBuilder.append(" ) WHERE PAGE_ROW > ? ");
		return sqlBuilder.toString();
	}
}
