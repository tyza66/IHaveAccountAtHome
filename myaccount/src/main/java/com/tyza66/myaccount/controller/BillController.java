package com.tyza66.myaccount.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyza66.myaccount.pojo.AllBill;
import com.tyza66.myaccount.service.AllBillService;
import com.tyza66.myaccount.service.impl.AllBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        } else {
            obj.set("msg", "error");
            obj.set("code", 500);
        }
        return obj;
    }

    @GetMapping("/get")
    public JSON getBill(@RequestParam(value = "infoKey",required = false) String infoKey,
                        @RequestParam(value = "noteKey",required = false) String noteKey,
                        @RequestParam(value = "upOrDown",required = false) String upOrDown,
                        @RequestParam(value = "startTime",required = false) String startTime,
                        @RequestParam(value = "endTime",required = false) String endTime,
                        @RequestParam("page") Integer page,
                        @RequestParam("size") Integer size) {
        JSONObject obj = JSONUtil.createObj();
        Integer billSize = allBillService.getBillSize(infoKey, noteKey, upOrDown, startTime, endTime);
        obj.set("msg", "ok");
        obj.set("code", 200);
        obj.set("size", billSize);
        obj.set("data", allBillService.getBillList(infoKey, noteKey, upOrDown, startTime, endTime, page, size));
        return obj;
    }

    @PostMapping("/delete")
    public JSON deleteBill(@RequestBody AllBill bill) {
        JSONObject obj = JSONUtil.createObj();
        AllBill allBill = new AllBill();
        allBill.setId(bill.getId());
        allBill.setIsDelete(1);
        boolean save = allBillService.saveBill(allBill);
        if (save) {
            obj.set("msg", "ok");
            obj.set("code", 200);
        } else {
            obj.set("msg", "error");
            obj.set("code", 500);
        }
        return obj;
    }

    @PostMapping("/update")
    public JSON updateBill(@RequestBody AllBill bill) {
        JSONObject obj = JSONUtil.createObj();
        boolean save = allBillService.saveBill(bill);
        if (save) {
            obj.set("msg", "ok");
            obj.set("code", 200);
        } else {
            obj.set("msg", "error");
            obj.set("code", 500);
        }
        return obj;
    }

}
