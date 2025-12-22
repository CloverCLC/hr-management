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
        List<Employee> employeeList = empService.findAll();
        return Result.success(employeeList);
    }

    @GetMapping("/{id}")
    public Result<Employee> getEmpById(@PathVariable Integer id) {
        Employee employee = empService.findById(id);
        return Result.success(employee);
    }

    @PostMapping("/add")
    public Result<Integer> addEmp(@RequestBody Employee emp) {
        int result = empService.insert(emp);
        return Result.success(result);
    }

    @DeleteMapping("/del/{id}")
    public Result<Integer> delEmp(@PathVariable Integer id) {
        int result = empService.delete(id);
        return Result.success(result);
    }

    @PutMapping("/update")
    public Result<Integer> updateEmp(@RequestBody Employee emp) {
        int result = empService.update(emp);
        return Result.success(result);
    }

}
