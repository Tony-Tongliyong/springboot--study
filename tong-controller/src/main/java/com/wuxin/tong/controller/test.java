package com.wuxin.tong.controller;


import com.wuxin.tong.service.service.TableStatisticStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: tongly
 * @contact:wuxin@yscredit.com
 * @file: test
 * @time: 2018/11/27 15:49
 * @desc:
 */
@Controller
@RequestMapping("/test")
public class test {

    @Autowired
    private TableStatisticStatusService tableStatisticStatusService;
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("/status")
    @ResponseBody
    public String status(Long id){
        return tableStatisticStatusService.select(id);
    }


}