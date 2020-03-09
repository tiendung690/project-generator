package com.project.generator.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.project.generator.common.util.JsonUtils;

@MappedJdbcTypes({ JdbcType.VARCHAR })
@MappedTypes({ List.class, ArrayList.class })
public class ListTypeHandler extends BaseTypeHandler<Object> {

	public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		preparedStatement.setString(i, JsonUtils.stringify(parameter));
	}

	@Override
	public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {

		return JsonUtils.parse(rs.getString(columnName), Object.class);
	}

	@Override
	public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

		return JsonUtils.parse(rs.getString(columnIndex), Object.class);
	}

	@Override
	public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

		return JsonUtils.parse(cs.getString(columnIndex), Object.class);
	}
}