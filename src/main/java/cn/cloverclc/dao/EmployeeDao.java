package cn.cloverclc.dao;
import cn.cloverclc.model.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {

}
