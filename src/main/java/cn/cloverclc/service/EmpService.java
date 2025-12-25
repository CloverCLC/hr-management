package cn.cloverclc.service;

import cn.cloverclc.dao.EmployeeDao;
import cn.cloverclc.model.entity.Employee;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmpService extends ServiceImpl<EmployeeDao, Employee> {
//    public IPage<Employee> findByPage(Integer pageNo, Integer pageSize) {
//        Page<Employee> page = new Page<>(pageNo, pageSize);
//        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
//        return page(page, queryWrapper);
//    }
}
