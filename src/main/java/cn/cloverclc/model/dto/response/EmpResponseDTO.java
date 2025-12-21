package cn.cloverclc.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpResponseDTO {
    private Integer empno;
    private String ename;
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
