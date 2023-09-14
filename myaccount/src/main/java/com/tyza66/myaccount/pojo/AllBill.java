package com.tyza66.myaccount.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Author: tyza66
 * Date: 2023/9/14 9:18
 * Github: https://github.com/tyza66
 **/

@Data
public class AllBill {
    Integer id;
    Timestamp time;
    BigDecimal revenue;
    String useTo;
    String notes;
    String isDelete;
}
