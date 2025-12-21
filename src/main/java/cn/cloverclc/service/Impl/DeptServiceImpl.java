package cn.cloverclc.service.Impl;

import cn.cloverclc.dao.DepartmentDao;
import cn.cloverclc.model.entity.Department;
import cn.cloverclc.service.Interface.DeptService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    private static final Logger log = LoggerFactory.getLogger(EmpServiceImpl.class);
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional(readOnly = true)
    public List<Department> getAllDepartment(){
        log.info("开始获取部门列表");
        try {
            List<Department> departmentList = departmentDao.getAllDepartment();
            log.info("获取部门列表完成，共查询到 {} 条部门记录", departmentList.size());
            log.info("Done");
            return departmentList;
        }catch (Exception e){
            log.error("获取员工列表失败", e);
            log.info("Done");
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Department getDepartmentById(Integer id) {
        log.info("开始查询deptno为 {} 的部门",id);
        try {
            Department department = departmentDao.getDepartmentByDeptno(id);
            if (department != null){
                log.info("成功查询到deptno为 {} 的部门",id);
            }else{
                log.info("未查询到deptno为 {} 的部门",id);
            }
            log.info("Done");
            return department;
        }catch (Exception e){
            log.error("查询部门失败", e);
            log.info("Done");
            return null;
        }
    }

    @Override
    public Integer addDepartment(Department department) {
        log.info("开始添加部门");
        try {
            Integer res = departmentDao.addDepartment(department);
            log.info("数据库添加 {} 行",res);
            log.info("Done");
            return res;
        }catch (Exception e){
            log.error("添加部门失败", e);
            log.info("Done");
            return null;
        }

    }

    @Override
    public Integer removeDepartment(Integer id) {
        log.info("开始删除部门");
        try {
            Integer res = departmentDao.deleteDepartment(id);
            log.info("数据库删除 {} 行",res);
            log.info("Done");
            return res;
        }catch (Exception e){
            log.error("删除部门失败", e);
            log.info("Done");
            return null;
        }
    }

    @Override
    public Integer updateDepartment(Department department) {
        log.info("开始修改部门");
        try {
            Integer res = departmentDao.updateDepartment(department);
            log.info("数据库修改 {} 行",res);
            log.info("Done");
            return res;
        }catch (Exception e){
            log.error("修改部门失败", e);
            log.info("Done");
            return null;
        }
    }
}
