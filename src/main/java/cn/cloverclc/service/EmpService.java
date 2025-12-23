package cn.cloverclc.service;

import cn.cloverclc.dao.EmployeeDao;
import cn.cloverclc.model.entity.Employee;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpService extends ServiceImpl<EmployeeDao, Employee> {


    public List<Employee> findAll() {

        return baseMapper.selectList(null);
    }
    public Employee findById(Integer id) {

        return baseMapper.selectById(id);
    }
    public Integer insert(Employee employee) {
        return baseMapper.insert(employee);
    }
    public Integer update(Employee employee) {
        return baseMapper.updateById(employee);
    }
    public Integer delete(Integer id) {
        return baseMapper.deleteById(id);
    }
}
