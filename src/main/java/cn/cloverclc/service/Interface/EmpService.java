package cn.cloverclc.service.Interface;

import cn.cloverclc.entity.Employee;

import java.util.List;

public interface EmpService {

//    查询所有员工
    List<Employee> getAllEmployee();

//    根据ID查询员工
    Employee getEmployeeById(Integer id);

//    添加员工
    Integer addEmployee(Employee employee);

//    删除员工
    Integer removeEmployeeById(Integer id);

//    更新员工
    Integer updateEmployee(Employee employee);


}
