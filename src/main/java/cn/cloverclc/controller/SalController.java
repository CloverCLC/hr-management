package cn.cloverclc.controller;


import cn.cloverclc.common.Result;
import cn.cloverclc.model.entity.Salgrade;
import cn.cloverclc.service.SalService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/sal")
public class SalController {

    @Resource
    private SalService salService;
    @GetMapping
    public Result<List<Salgrade>> listAll() {
        List<Salgrade> list = salService.findAll();
        return Result.success(list);
    }
}
