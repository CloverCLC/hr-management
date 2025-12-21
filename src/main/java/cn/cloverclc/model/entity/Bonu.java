package cn.cloverclc.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("Bonus")
public class Bonu {
    @TableId(type = IdType.AUTO)
    private int id;
    private int empno;
    private Double comm;
    private Date bonus_data;
}
