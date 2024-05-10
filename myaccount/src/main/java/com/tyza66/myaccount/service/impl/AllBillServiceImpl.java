package com.tyza66.myaccount.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyza66.myaccount.mapper.AllBillMapper;
import com.tyza66.myaccount.pojo.AllBill;
import com.tyza66.myaccount.service.AllBillService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

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

    @Override
    public Integer getBillSize(String infoKey, String noteKey, String upOrDown, String startTime, String endTime) {
        QueryWrapper<AllBill> allBillQueryWrapper = new QueryWrapper<>();
        //没被删除
        allBillQueryWrapper.ne("IS_DELETE", "1");
        //有信息关键词
        if (infoKey != null && !infoKey.equals("")) {
            allBillQueryWrapper.like("USE_TO", infoKey);
        }
        //有备注关键词
        if (noteKey != null && !noteKey.equals("")) {
            allBillQueryWrapper.like("NOTES", noteKey);
        }
        //查询日期之间的
        if (startTime != null && !startTime.equals("") && endTime != null && !endTime.equals("")) {
            allBillQueryWrapper.between("TIME", startTime, endTime);
        }
        List<AllBill> allBills = baseMapper.selectList(allBillQueryWrapper);
        return allBills.size();
    }

    @Override
    public List<AllBill> getBillList(String infoKey, String noteKey, String upOrDown, String startTime, String endTime, Integer page, Integer size) {
        QueryWrapper<AllBill> allBillQueryWrapper = new QueryWrapper<>();
        //没被删除
        //allBillQueryWrapper.ne("IS_DELETE", "1");
        //最新时间的排在前面
        allBillQueryWrapper.orderByDesc("TIME");
        //有信息关键词
        if (infoKey != null && !infoKey.equals("")) {
            allBillQueryWrapper.like("USE_TO", infoKey);
        }
        //有备注关键词
        if (noteKey != null && !noteKey.equals("")) {
            allBillQueryWrapper.like("NOTES", noteKey);
        }
        //查询日期之后的
        if (startTime != null && !startTime.equals("")) {
            allBillQueryWrapper.ge("TIME", startTime);
        }
        //查询日期之前的
        if (endTime != null && !endTime.equals("")) {
            allBillQueryWrapper.le("TIME", endTime);
        }
        //收入还是支出
        if (upOrDown != null && !upOrDown.equals("")) {
            if (upOrDown.equals("up")) {
                allBillQueryWrapper.ge("REVENUE", 0);
            } else if (upOrDown.equals("down")) {
                allBillQueryWrapper.lt("REVENUE", 0);
            }
        }
        Page<AllBill> allBillPage = baseMapper.selectPage(new Page<>(page, size), allBillQueryWrapper);
        List<AllBill> records = allBillPage.getRecords();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        for(AllBill one: records){
            one.setTimeString(simpleDateFormat.format(one.getTime()));
        }
        return records;
    }

    @Override
    public Double getDayCost(Timestamp date) {
        return baseMapper.getAllOutBill(date);
    }

    @Override
    public Double getDayRevenue(Timestamp date) {
        return baseMapper.getAllInBill(date);
    }

    @Override
    public Double getDayCostByUseTo(Timestamp date, String useTo) {
        return baseMapper.getOneOutBill(date, useTo);
    }

    @Override
    public Double getDayRevenueByUseTo(Timestamp date, String useTo) {
        return baseMapper.getOneInBill(date, useTo);
    }


}
