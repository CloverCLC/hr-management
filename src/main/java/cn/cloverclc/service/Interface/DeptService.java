package cn.cloverclc.service.Interface;

import cn.cloverclc.entity.Department;

import java.util.List;

public interface DeptService {
    List<Department> getAllDepartment();


    Department getDepartmentById(int id);


    boolean addDepartment(Department department);


    boolean removeDepartment(int id);


    boolean updateDepartment(Department department);

}
