package com.tyza66.myaccount.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Author: tyza66
 * Date: 2023/9/14 9:18
 * Github: https://github.com/tyza66
 **/

@Data
@TableName("ALL_BILL")
public class AllBill {
    Integer id;
    Timestamp time;
    @TableField(exist = false)
    String timeString;
    BigDecimal revenue;
    String useTo;
    String notes;
    @TableLogic
    Integer isDelete;
}
