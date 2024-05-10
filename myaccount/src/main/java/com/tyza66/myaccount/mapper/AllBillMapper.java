package com.tyza66.myaccount.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tyza66.myaccount.pojo.AllBill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

/**
 * Author: tyza66
 * Date: 2023/9/14 9:21
 * Github: https://github.com/tyza66
 **/

public interface AllBillMapper extends BaseMapper<AllBill> {

    // 添加一条账单记录
    @Insert("INSERT INTO `myaccount`.`ALL_BILL` (`TIME`, `REVENUE`, `USE_TO`, `NOTES`,`IS_DELETE`) VALUES (SYSDATE(), #{revenue}, #{useTo}, #{notes},0)")
    Boolean saveBill(AllBill allBill);

    // 获取某天中的所有的消费记录总金额
    @Select("SELECT SUM(REVENUE) FROM `myaccount`.`ALL_BILL` WHERE DATE(TIME) = DATE(#{time}) AND REVENUE < 0")
    Double getAllOutBill(Timestamp time);

    // 获取某天某种消费用途的总金额
    @Select("SELECT SUM(REVENUE) FROM `myaccount`.`ALL_BILL` WHERE DATE(TIME) = DATE(#{time}) AND USE_TO = #{useTo} AND REVENUE < 0")
    Double getOneOutBill(Timestamp time, String useTo);

    // 获取某天所有入账的总金额
    @Select("SELECT SUM(REVENUE) FROM `myaccount`.`ALL_BILL` WHERE DATE(TIME) = DATE(#{time}) AND REVENUE > 0")
    Double getAllInBill(Timestamp time);

    // 某天某种入账用途的总金额
    @Select("SELECT SUM(REVENUE) FROM `myaccount`.`ALL_BILL` WHERE DATE(TIME) = DATE(#{time}) AND USE_TO = #{useTo} AND REVENUE > 0")
    Double getOneInBill(Timestamp time, String useTo);

}
