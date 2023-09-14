package com.tyza66.myaccount.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tyza66
 * Date: 2023/9/14 9:33
 * Github: https://github.com/tyza66
 **/

@RestController
public class CheckController {

    @GetMapping("/check")
    public JSON check() {
        JSONObject obj = JSONUtil.createObj();
        obj.set("msg", "ok");
        obj.set("code", 200);
        return obj;
    }
}
