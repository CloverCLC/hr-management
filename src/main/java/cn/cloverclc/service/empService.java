package cn.cloverclc.service;


import org.springframework.stereotype.Service;

@Service
public class empService {
    public static empService getInstance() {
        return new empService();
    }
}
