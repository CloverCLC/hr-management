package cn.cloverclc.dao;
import cn.cloverclc.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
//    检索全部

    @Select("SELECT * FROM emp")
    List<Employee> getAllEmployee();

//    根据empno检索
    @Select("SELECT * FROM emp WHERE empno = #{empno}")
    Employee getEmployeeByEmpno(Integer empno);

//    添加员工
    @Insert("INSERT INTO emp (ename,job,mgr,sal,comm) VALUES (#{ename},#{job},#{mgr},#{sal},#{comm})")
    boolean insertEmployee(Employee employee);

//    更新字段
    @Update("UPDATE emp SET status=CAST(#{status} AS emp_status),job=#{job},mgr=#{mgr},sal=#{sal},comm=#{comm},deptno=#{deptno} WHERE empno = #{empno}")
    boolean updateEmployee(Employee employee);

//    根据empno删除员工
    @Delete("DELETE FROM emp WHERE empno=#{empno}")
    boolean deleteEmployeeByEmpno(Integer empno);
}
