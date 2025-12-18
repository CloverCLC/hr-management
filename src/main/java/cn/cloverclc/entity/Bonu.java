package cn.cloverclc.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Bonu {
    private int id;
    private int empno;
    private Double comm;
    private Date bonus_data;
}
