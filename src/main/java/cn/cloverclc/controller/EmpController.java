package cn.cloverclc.controller;

import cn.cloverclc.annotation.LogRecord;
import cn.cloverclc.model.entity.Employee;

import cn.cloverclc.common.Result;

import cn.cloverclc.service.Impl.EmpServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/emp")
public class EmpController {

    @Resource
    private EmpServiceImpl empService;

    @GetMapping
    @LogRecord
    public Result<List<Employee>> listAll() {
        List<Employee> employeeList = empService.list();
        return Result.success(employeeList);
    }
//SOAP/GraphQL/RPC
    @GetMapping("/{id}")
    @LogRecord
    public Result<Employee> getEmpById(@PathVariable Integer id) {
        Employee employee = empService.getById(id);
        if (employee == null) {
            return Result.error("500","员工不存在");
        }
        return Result.success(employee);
    }

    @PostMapping("/add")
    @LogRecord
    public Result<Void> addEmp(@RequestBody Employee emp) {
        boolean result = empService.save(emp);
        if (result) {
            return Result.success();
        }
        return Result.error("添加失败");

    }

    @PutMapping("/del/{id}")
    @LogRecord
    public Result<Void> delEmp(@PathVariable Integer id) {
        boolean result = empService.removeById(id);
        if (result) {
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PutMapping("/update")
    @LogRecord
    public Result<Void> updateEmp(@RequestBody Employee emp) {
        boolean result = empService.updateById(emp);
        if (result) {
            return Result.success();
        }
        return Result.error("员工不存在或无字段需要更新");

    }
    @GetMapping("/page")
    @LogRecord
    public Result<IPage<Employee>> getEmpPage(@RequestParam(defaultValue = "1") Integer current,
                                              @RequestParam(defaultValue = "10") Integer size) {
        IPage result = empService.selectEmployeePage(current, size);
        return Result.success(result);
    }

}
