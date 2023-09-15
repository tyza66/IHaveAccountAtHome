package com.tyza66.myaccount.service;

import com.tyza66.myaccount.pojo.AllBill;

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
}
