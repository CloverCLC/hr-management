package cn.cloverclc.service.Impl;

import cn.cloverclc.dao.EmployeeDao;
import cn.cloverclc.entity.Employee;
import cn.cloverclc.service.Interface.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> listAllEmployees() {
        return employeeDao.selectAllEmployee();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    public boolean removeEmployeeById(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdateEmployee(Employee employee) {
        return false;
    }
}
