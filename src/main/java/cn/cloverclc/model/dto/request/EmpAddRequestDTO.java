package cn.cloverclc.model.dto.request;

import lombok.Data;

@Data
public class EmpAddRequestDTO {

    private String name;
    private String job;
    private Integer mgr;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
