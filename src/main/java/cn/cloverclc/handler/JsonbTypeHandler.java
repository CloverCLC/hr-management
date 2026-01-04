package cn.cloverclc.handler;



import cn.cloverclc.model.entity.EmergencyContact;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

// 支持的 Java 类型（实体类/Map）
@MappedTypes({EmergencyContact.class, java.util.Map.class})
// 适配 jsonb 类型（JdbcType.OTHER）
@MappedJdbcTypes(JdbcType.OTHER)
public class JsonbTypeHandler extends AbstractJsonTypeHandler<Object> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final Class<?> type;

    public JsonbTypeHandler(Class<?> type) {
        this.type = type;
    }

    @Override
    protected Object parse(String json) {
        try {
            return OBJECT_MAPPER.readValue(json, this.type);
        } catch (Exception e) {
            throw new RuntimeException("jsonb 反序列化失败", e);
        }
    }

    @Override
    protected String toJson(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("jsonb 序列化失败", e);
        }
    }

    // 针对性适配 jsonb 入库
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        String json = toJson(parameter);
        ps.setObject(i, json, Types.OTHER); // 适配 jsonb 类型
    }
}