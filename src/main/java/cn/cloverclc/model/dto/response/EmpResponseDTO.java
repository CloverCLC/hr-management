package cn.cloverclc.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EmpResponseDTO {
    private Integer id;
    private String name;
    private String status;
    private String job;
    private Integer mgr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
    private String dname;
}
