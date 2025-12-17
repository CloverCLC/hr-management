package cn.cloverclc.dao;
import cn.cloverclc.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.io.Serializable;
import java.util.List;

public interface EmployeeDao extends BaseMapper<Employee> {
    List<Employee> selectEmployee();

    @Override
    Employee selectById(Serializable id);

    @Override
    int deleteById(Employee entity);
}
