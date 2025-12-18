package cn.cloverclc.service.Impl;


import cn.cloverclc.dao.DepartmentDao;
import cn.cloverclc.entity.Department;
import cn.cloverclc.service.Interface.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getAllDepartment(){
        return departmentDao.getAllDepartment();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentDao.getDepartmentByDeptno(id);
    }


    @Override
    public boolean addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public boolean removeDepartment(Integer id) {
        return departmentDao.deleteDepartment(id);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }
}
