package cn.cloverclc.dao;

import cn.cloverclc.model.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {

}
