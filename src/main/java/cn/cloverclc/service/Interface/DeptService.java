package cn.cloverclc.service.Interface;

import cn.cloverclc.model.entity.Department;

import java.util.List;

public interface DeptService {

    List<Department> getAllDepartment();

    Department getDepartmentById(Integer id);

    Integer addDepartment(Department department);

    Integer removeDepartment(Integer id);

    Integer updateDepartment(Department department);

}
