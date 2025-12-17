package cn.cloverclc.dao;
import cn.cloverclc.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
    @Select("SELECT * FROM emp")
    List<Employee> selectAllEmployee();
}
