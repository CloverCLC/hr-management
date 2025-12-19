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
        log.info("开始获取员工列表");
        try {
            List<Employee> employees = employeeDao.getAllEmployee();
            log.info("获取员工列表完成，共查询到 {} 条员工记录", employees.size());
            log.info("Done");
            return employees;
        }catch (Exception e) {
            log.error("获取员工列表失败", e);
            log.info("Done");
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployeeById(Integer id) {
        log.info("开始查询empno为 {} 的员工",id);
        try {
            Employee employee = employeeDao.getEmployeeByEmpno(id);
            if (employee != null) {
                log.info("成功查询到empno为 {} 的员工",id);
            }else{
                log.info("未查询到empno为 {} 的员工",id);
            }
            log.info("Done");
            return employee;
        }catch (Exception e) {
            log.error("查询员工失败", e);
            log.info("Done");
            return null;
        }
    }

    @Override
    public Integer addEmployee(Employee employee) {
        log.info("开始添加员工");
        try {
            Integer res =employeeDao.insertEmployee(employee);
            log.info("数据库添加 {} 行",res);
            log.info("Done");
            return res;
        } catch (Exception e) {
            log.error("添加员工失败", e);
            log.info("Done");
            return null;
        }
    }

    @Override
    public Integer removeEmployeeById(Integer id) {
        log.info("开始删除员工");
        try {
            Integer res =employeeDao.deleteEmployeeByEmpno(id);
            log.info("数据库删除 {} 行",res);
            log.info("Done");
            return res;
        } catch (Exception e) {
            log.error("删除员工失败", e);
            log.info("Done");
            return null;
        }
    }

    @Override
    public Integer updateEmployee(Employee employee) {
        log.info("开始修改员工");
        try {
            Integer res =employeeDao.updateEmployee(employee);
            log.info("数据库修改 {} 行",res);
            log.info("Done");
            return res;
        } catch (Exception e) {
            log.error("修改员工失败", e);
            log.info("Done");
            return null;
        }
    }
}
