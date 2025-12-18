package cn.cloverclc.dao;


import cn.cloverclc.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentDao extends BaseMapper<Department> {

    @Select("SELECT * FROM dept")
    List<Department> getAllDepartment();

    @Select("SELECT * FROM dept WHERE deptno = #{deptno}")
    Department getDepartmentByDeptno(Integer deptno);

    @Insert("INSERT INTO dept(dname,loc) VALUES(#{dname},#{loc})")
    boolean addDepartment(Department department);

    @Update("UPDATE dept SET dname=#{dname},loc=#{loc} WHERE deptno = #{deptno};")
    boolean updateDepartment(Department department);

    @Delete("DELETE FROM dept WHERE deptno=#{deptno}")
    boolean deleteDepartment(Integer deptno);

}
