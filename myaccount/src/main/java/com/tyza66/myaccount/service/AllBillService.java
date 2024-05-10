package com.tyza66.myaccount.service;

import com.tyza66.myaccount.pojo.AllBill;

import java.sql.Timestamp;
import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/9/14 9:22
 * Github: https://github.com/tyza66
 **/

public interface AllBillService {

    Boolean saveBill(AllBill allBill);

    Integer getBillSize(String infoKey,String noteKey,String upOrDown,String startTime,String endTime);

    List<AllBill> getBillList(String infoKey,String noteKey,String upOrDown,String startTime,String endTime,Integer page,Integer size);

    // 获取某一天的支出总额
    Double getDayCost(Timestamp date);

    // 获取某一天的收入总额
    Double getDayRevenue(Timestamp date);

    // 获取某一天某种支出的总额
    Double getDayCostByUseTo(Timestamp date, String useTo);

    // 获取某一天某种收入的总额
    Double getDayRevenueByUseTo(Timestamp date, String useTo);



}
