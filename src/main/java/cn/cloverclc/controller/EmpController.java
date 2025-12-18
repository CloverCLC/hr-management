package cn.cloverclc.controller;

import cn.cloverclc.entity.Employee;
import cn.cloverclc.service.Interface.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public List<Employee> listAll() {
        return empService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmpById(@PathVariable Integer id) {
        return empService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public boolean addEmp(@RequestBody Employee emp) {
        return empService.addEmployee(emp);
    }

    @DeleteMapping("/del/{id}")
    public boolean delEmp(@PathVariable Integer id) {
        return empService.removeEmployeeById(id);
    }

    @PutMapping("/update")
    public boolean updateEmp(@RequestBody Employee emp) {
        return empService.updateEmployee(emp);
    }

}
