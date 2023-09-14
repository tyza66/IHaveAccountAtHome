package com.tyza66.myaccount.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyza66.myaccount.mapper.AllBillMapper;
import com.tyza66.myaccount.pojo.AllBill;
import com.tyza66.myaccount.service.AllBillService;
import org.springframework.stereotype.Service;

/**
 * Author: tyza66
 * Date: 2023/9/14 9:23
 * Github: https://github.com/tyza66
 **/

@Service
public class AllBillServiceImpl extends ServiceImpl<AllBillMapper, AllBill> implements AllBillService {
    @Override
    public Boolean saveBill(AllBill allBill) {
        Boolean aBoolean = baseMapper.saveBill(allBill);
        return aBoolean;
    }
}
