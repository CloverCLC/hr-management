package cn.cloverclc.service.Impl;

import cn.cloverclc.dao.EmployeeDao;
import cn.cloverclc.entity.Employee;
import cn.cloverclc.service.Interface.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeByEmpno(id);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    @Override
    public boolean removeEmployeeById(Integer id) {
        return employeeDao.deleteEmployeeByEmpno(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }
}
