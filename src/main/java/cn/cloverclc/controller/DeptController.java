package cn.cloverclc.controller;

import cn.cloverclc.entity.Department;
import cn.cloverclc.service.Interface.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public List<Department> listAll(){
        return deptService.getAllDepartment();
    }
    @GetMapping("/{id}")
    public Department getById(@PathVariable int id){
        return deptService.getDepartmentById(id);
    }
    @PostMapping("/add")
    public boolean add(@RequestBody Department dept){
        return deptService.addDepartment(dept);
    }
    @PutMapping("/update")
    public boolean update(@RequestBody Department dept){
        return deptService.updateDepartment(dept);
    }
    @DeleteMapping("/del/{id}")
    public boolean delete(@PathVariable int id){
        return deptService.removeDepartment(id);
    }
}
