package cn.cloverclc.service.Impl;

import cn.cloverclc.dao.EmployeeDao;
import cn.cloverclc.entity.Employee;
import cn.cloverclc.service.Interface.EmpService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class EmpServiceImpl implements EmpService {
    private static final Logger log = LoggerFactory.getLogger(EmpServiceImpl.class);


    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployee() {
        log.info("开始获取所有员工列表");
        try {
            List<Employee> employees = employeeDao.getAllEmployee();
            log.info("获取员工列表完成，共查询到 {} 条员工记录", employees.size());
            return employees;
        }catch (Exception e) {
            log.error("获取员工列表失败", e);
            return null;
        }
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
