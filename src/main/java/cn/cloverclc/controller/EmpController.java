package cn.cloverclc.controller;

import cn.cloverclc.model.entity.Employee;
import cn.cloverclc.service.EmpService;
import cn.cloverclc.common.Result;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/emp")
public class EmpController {

    @Resource
    private EmpService empService;

    @GetMapping
    public Result<List<Employee>> listAll() {
        List<Employee> employeeList = empService.list();
        return Result.success(employeeList);
    }

    @GetMapping("/{id}")
    public Result<Employee> getEmpById(@PathVariable Integer id) {
        Employee employee = empService.getById(id);
        if (employee == null) {
            return Result.error("500","员工不存在");
        }
        return Result.success(employee);
    }

    @PostMapping("/add")
    public Result<Void> addEmp(@RequestBody Employee emp) {
        boolean result = empService.save(emp);
        if (result) {
            return Result.success();
        }
        return Result.error("添加失败");

    }

    @DeleteMapping("/del/{id}")
    public Result<Void> delEmp(@PathVariable Integer id) {
        boolean result = empService.removeById(id);
        if (result) {
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PutMapping("/update")
    public Result<Void> updateEmp(@RequestBody Employee emp) {
        boolean result = empService.update(emp);
        if (result) {
            return Result.success();
        }
        return Result.error("员工不存在或无字段需要更新");

    }

}
