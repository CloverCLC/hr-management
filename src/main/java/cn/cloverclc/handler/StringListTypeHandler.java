package cn.cloverclc.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 明确指定支持的Java类型为List
@MappedTypes(List.class)
// 明确指定支持的数据库类型为VARCHAR
@MappedJdbcTypes(JdbcType.VARCHAR)
public class StringListTypeHandler extends BaseTypeHandler<List<String>> {

    // 插入/更新时：List<String> -> 逗号分隔字符串
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            // 若List为null，数据库存入null
            ps.setString(i, null);
            return;
        }
        // 若List为空集合，数据库存入空字符串（而非null，避免查询返回null）
        if (parameter.isEmpty()) {
            ps.setString(i, "");
            return;
        }
        // 正常List转换为逗号分隔字符串
        String str = parameter.stream().collect(Collectors.joining(","));
        ps.setString(i, str);
    }

    // 查询时：逗号分隔字符串 -> List<String>（按列名查询）
    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        return parseStrToList(str);
    }

    // 查询时：逗号分隔字符串 -> List<String>（按列索引查询）
    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        return parseStrToList(str);
    }

    // 存储过程查询时使用
    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        return parseStrToList(str);
    }

    // 公共解析方法：字符串转List<String>（核心优化：返回空集合而非null）
    private List<String> parseStrToList(String str) {
        // 1. 数据库字段为null：返回空集合（可根据业务调整为null，这里推荐空集合）
        if (str == null) {
            return new ArrayList<>();
        }
        // 2. 数据库字段为空白字符串（含纯空格）：返回空集合
        String trimStr = str.trim();
        if (trimStr.isEmpty()) {
            return new ArrayList<>();
        }
        // 3. 正常逗号分隔字符串：转换为List<String>（转为ArrayList，支持增删操作，避免Arrays.asList的固定长度限制）
        return new ArrayList<>(Arrays.asList(trimStr.split(",")));
    }
}