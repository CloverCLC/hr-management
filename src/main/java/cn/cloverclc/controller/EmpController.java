package cn.cloverclc.controller;

import cn.cloverclc.entity.Employee;
import cn.cloverclc.service.Interface.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public List<Employee> listAll(){
        return empService.listAllEmployees();
    }

}
