package cn.cloverclc.service;

import cn.cloverclc.model.entity.Employee;
import cn.cloverclc.model.vo.EmployeeVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


public interface EmpService extends IService<Employee> {
    IPage<EmployeeVO> selectEmployeePage(Integer current, Integer size);
}