package cn.cloverclc;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan("cn.cloverclc.dao")
@EnableScheduling
public class HrApp {
    public static void main(String[] args) {
        SpringApplication.run(HrApp.class, args);
    }
}
