package cn.cloverclc.controller;

import cn.cloverclc.model.entity.Department;
import cn.cloverclc.service.DeptService;
import cn.cloverclc.common.Result;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dept")
@CrossOrigin(origins = "http://localhost:8081")
public class DeptController {
    @Resource
    private DeptService deptService;
    @GetMapping
    public Result<List<Department>> listAll(){
        List<Department> departmentsList = deptService.findAll();
        return Result.success(departmentsList);
    }
    @GetMapping("/{id}")
    public Result<Department> getById(@PathVariable int id){
        Department department = deptService.findById(id);
        return Result.success(department);
    }
    @PostMapping("/add")
    public Result<Integer> add(@RequestBody Department dept){
        Integer result = deptService.insert(dept);
        return Result.success(result);
    }
    @PutMapping("/update")
    public Result<Integer> update(@RequestBody Department dept){
        Integer result = deptService.update(dept);
        return Result.success(result);
    }
    @DeleteMapping("/del/{id}")
    public Result<Integer> delete(@PathVariable int id){
        Integer result = deptService.delete(id);
        return Result.success(result);
    }
}
