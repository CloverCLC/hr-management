package cn.cloverclc.service.Interface;

import cn.cloverclc.entity.Employee;
import java.util.List;

public interface EmpService {
    /**
     * 查询所有员工
     * @return 员工列表
     */
    List<Employee> listAllEmployees();

    /**
     * 根据ID查询员工
     * @param id 员工ID
     * @return 员工信息（null表示不存在）
     */
    Employee getEmployeeById(Long id);

    /**
     * 删除员工
     * @param id 员工ID
     * @return true=删除成功，false=删除失败
     */
    boolean removeEmployeeById(Long id);

    /**
     * 新增/修改员工（通用保存，ID为空则新增，非空则修改）
     * @param employee 员工信息
     * @return true=操作成功，false=操作失败
     */
    boolean saveOrUpdateEmployee(Employee employee);


}
