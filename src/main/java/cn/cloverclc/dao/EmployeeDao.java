package cn.cloverclc.dao;
import cn.cloverclc.model.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {

//    检索全部
    @Select("SELECT\n" +
            "  e.empno,\n" +
            "  e.ename,\n" +
            "  e.job,\n" +
            "  e.mgr,\n" +
            "  e.hiredate,\n" +
            "  e.sal,\n" +
            "  e.comm,\n" +
            "  COALESCE(e.deptno,0) AS deptno,\n" +
            "  d.dname AS dname\n" +
            "FROM emp e \n" +
            "LEFT JOIN dept d on e.deptno = d.deptno;")
    List<Employee> getAllEmployee();

//    根据empno检索
    @Select("SELECT * FROM emp WHERE empno = #{empno}")
    Employee getEmployeeByEmpno(Integer empno);

//    添加员工
    @Insert("INSERT INTO emp (ename,job,mgr,sal,comm) VALUES (#{ename},#{job},#{mgr},#{sal},#{comm})")
    Integer insertEmployee(Employee employee);

//    更新字段
    @Update("UPDATE emp SET status=CAST(#{status} AS emp_status),job=#{job},mgr=#{mgr},sal=#{sal},comm=#{comm},deptno=#{deptno} WHERE empno = #{empno}")
    Integer updateEmployee(Employee employee);

//    根据empno删除员工
    @Delete("DELETE FROM emp WHERE empno=#{empno}")
    Integer deleteEmployeeByEmpno(Integer empno);
}
