package com.tyza66.myaccount.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.myaccount.pojo.AllBill;
import com.tyza66.myaccount.service.AllBillService;
import com.tyza66.myaccount.service.impl.AllBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tyza66
 * Date: 2023/9/14 9:24
 * Github: https://github.com/tyza66
 **/

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private AllBillServiceImpl allBillService;

    @PostMapping("/add")
    public JSON addBill(@RequestBody AllBill allBill) {
        JSONObject obj = JSONUtil.createObj();
        boolean save = allBillService.saveBill(allBill);
        if (save) {
            obj.set("msg", "ok");
            obj.set("code", 200);
        }
        else{
            obj.set("msg", "error");
            obj.set("code", 500);
        }
        return obj;
    }
}
