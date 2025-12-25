package cn.cloverclc.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("emp")
public class Employee {
    @TableId(value = "empno", type = IdType.AUTO)
    private Integer id;
    @Schema(description = "姓名",example = "李四")
    @TableField("ename")
    private String name;
    @TableField(value = "status",typeHandler = EmpStatusTypeHandler.class)
    private String status;
    private String job;
    private Integer mgr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
    private String email;
    private String mobile;

    @TableField(exist = false)
    private String dname;
    @TableField(exist = false)
    private String subordinate;
    @TableField(exist = false)
    private Integer salgrade;
}
