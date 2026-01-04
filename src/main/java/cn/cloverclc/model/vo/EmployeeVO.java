package cn.cloverclc.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(description = "员工信息VO")
public class  EmployeeVO {
    @Schema(description = "员工ID")
    private Integer empno;

    @Schema(description = "员工姓名")
    private String name;

    @Schema(description = "部门名称")
    private String dname;

    @Schema(description = "总收入(工资+奖金)")
    private BigDecimal totalIncome;

    @Schema(description = "薪资等级")
    private Integer salgrade;


    @Schema(description = "下级员工姓名列表")
    private List<String> subordinateNames;

    @Schema(description = "联系方式")
    private String contactInfo;
}