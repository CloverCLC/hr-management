package cn.cloverclc.model.entity;


import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.lang.reflect.Type;
import java.sql.*;


@MappedTypes(EmpStatus.class)
public class EmpStatusTypeHandler extends BaseTypeHandler<EmpStatus> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EmpStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.name(), Types.OTHER);
    }

    @Override
    public EmpStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return value != null ? EmpStatus.valueOf(value) : null;
    }

    @Override
    public EmpStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return value != null ? EmpStatus.valueOf(value) : null;
    }

    @Override
    public EmpStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return value != null ? EmpStatus.valueOf(value) : null;
    }
}
