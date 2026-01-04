package cn.cloverclc;

import cn.cloverclc.dao.EmployeeDao;
import cn.cloverclc.model.entity.Employee;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootTest
public class EmployeeDaoTest {
    @Resource
    private EmployeeDao employeeDao;
}
