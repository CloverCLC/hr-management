package cn.cloverclc.service.Impl;

import cn.cloverclc.annotation.LogRecord;
import cn.cloverclc.dao.EmployeeDao;
import cn.cloverclc.model.entity.Employee;
import cn.cloverclc.service.EmpService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class EmpServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements EmpService {

    @Override

    public IPage<Employee> getUserPage(Integer current, Integer size) {
        IPage<Employee> page = new Page<>(current, size);
        IPage<Employee> EmpPage = this.page(page);
        return EmpPage;
    }
}
