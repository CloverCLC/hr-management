package cn.cloverclc.service;

import cn.cloverclc.model.entity.Employee;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


public interface EmpService extends IService<Employee> {
    IPage<Employee> getUserPage(Integer current, Integer size);
}