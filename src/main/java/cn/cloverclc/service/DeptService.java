package cn.cloverclc.service;

import cn.cloverclc.dao.DepartmentDao;
import cn.cloverclc.model.entity.Department;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService extends ServiceImpl<DepartmentDao, Department> {
    public List<Department> findAll() {
        return baseMapper.selectList(null);
    }
    public Department findById(Integer id) {
        return baseMapper.selectById(id);
    }
    public Integer insert(Department department) {
        return baseMapper.insert(department);
    }
    public Integer update(Department department) {
        return baseMapper.updateById(department);
    }
    public Integer delete(Integer id) {
        return baseMapper.deleteById(id);
    }
}
