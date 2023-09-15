package com.tyza66.myaccount.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tyza66.myaccount.pojo.AllBill;
import org.apache.ibatis.annotations.Insert;

/**
 * Author: tyza66
 * Date: 2023/9/14 9:21
 * Github: https://github.com/tyza66
 **/

public interface AllBillMapper extends BaseMapper<AllBill> {

    @Insert("INSERT INTO `myaccount`.`ALL_BILL` (`TIME`, `REVENUE`, `USE_TO`, `NOTES`,`IS_DELETE`) VALUES (SYSDATE(), #{revenue}, #{useTo}, #{notes},0)")
    Boolean saveBill(AllBill allBill);
}
