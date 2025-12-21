package cn.cloverclc.controller;

import cn.cloverclc.model.entity.Employee;
import cn.cloverclc.service.Interface.EmpService;
import cn.cloverclc.common.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result<List<Employee>> listAll() {
        List<Employee> employeeList = empService.getAllEmployee();
        return Result.success(employeeList);
    }

    @GetMapping("/{id}")
    public Result<Employee> getEmpById(@PathVariable Integer id) {
        Employee employee = empService.getEmployeeById(id);
        return Result.success(employee);
    }

    @PostMapping("/add")
    public Result<Integer> addEmp(@RequestBody Employee emp) {
        int result = empService.addEmployee(emp);
        return Result.success(result);
    }

    @DeleteMapping("/del/{id}")
    public Result<Integer> delEmp(@PathVariable Integer id) {
        int result = empService.removeEmployeeById(id);
        return Result.success(result);
    }

    @PutMapping("/update")
    public Result<Integer> updateEmp(@RequestBody Employee emp) {
        int result = empService.updateEmployee(emp);
        return Result.success(result);
    }

}
