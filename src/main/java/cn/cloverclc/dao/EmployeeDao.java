package cn.cloverclc.dao;

import cn.cloverclc.model.entity.Employee;
import cn.cloverclc.model.vo.EmployeeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
    IPage<EmployeeVO> selectEmployeePage(Page<EmployeeVO> page);

}
