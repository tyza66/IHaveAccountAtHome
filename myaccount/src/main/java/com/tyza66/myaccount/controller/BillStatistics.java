package com.tyza66.myaccount.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.myaccount.service.impl.AllBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * Name: 账单统计
 * Author: tyza66
 * Date: 2024/5/10 19:43
 * Github: https://github.com/tyza66
 **/

@RestController
@RequestMapping("/statistics")
public class BillStatistics {
    @Autowired
    private AllBillServiceImpl allBillService;

    // 获取所有收入的金额
    @GetMapping("/allIn")
    public JSON getAllInStatistics(@RequestParam("time") String time) {
        JSONObject obj = JSONUtil.createObj();
        obj.set("data",allBillService.getDayRevenue(new Timestamp(Long.parseLong(time))));
        obj.set("msg", "ok");
        obj.set("code", 200);
        return obj;
    }

    @GetMapping("/oneIn")
    public JSON getOneInStatistics(@RequestParam("time") String time,@RequestParam("type") String type) {
        JSONObject obj = JSONUtil.createObj();
        obj.set("data",allBillService.getDayRevenueByUseTo((new Timestamp(Long.parseLong(time))),type));
        obj.set("msg", "ok");
        obj.set("code", 200);
        return obj;
    }

    @GetMapping("/allOut")
    public JSON getAllOutStatistics(@RequestParam("time") String time){
        JSONObject obj = JSONUtil.createObj();
        obj.set("data",allBillService.getDayCost(new Timestamp(Long.parseLong(time))));
        obj.set("msg", "ok");
        obj.set("code", 200);
        return obj;
    }

    @GetMapping("/oneOut")
    public JSON getOneOutStatistics(@RequestParam("time") String time,@RequestParam("type") String type) {
        JSONObject obj = JSONUtil.createObj();
        obj.set("data",allBillService.getDayCostByUseTo((new Timestamp(Long.parseLong(time))),type));
        obj.set("msg", "ok");
        obj.set("code", 200);
        return obj;
    }

}
