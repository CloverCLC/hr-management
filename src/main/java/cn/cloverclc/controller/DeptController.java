package cn.cloverclc.controller;

import cn.cloverclc.entity.Department;
import cn.cloverclc.service.Interface.DeptService;
import cn.cloverclc.common.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result<List<Department>> listAll(){
        List<Department> departmentsList = deptService.getAllDepartment();
        return Result.success(departmentsList);
    }
    @GetMapping("/{id}")
    public Result<Department> getById(@PathVariable int id){
        Department department = deptService.getDepartmentById(id);
        return Result.success(department);
    }
    @PostMapping("/add")
    public Result<Integer> add(@RequestBody Department dept){
        Integer result = deptService.addDepartment(dept);
        return Result.success(result);
    }
    @PutMapping("/update")
    public Result<Integer> update(@RequestBody Department dept){
        Integer result = deptService.updateDepartment(dept);
        return Result.success(result);
    }
    @DeleteMapping("/del/{id}")
    public Result<Integer> delete(@PathVariable int id){
        Integer result = deptService.removeDepartment(id);
        return Result.success(result);
    }
}
