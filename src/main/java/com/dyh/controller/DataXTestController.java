package com.dyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Date 2019/12/13 11:42
 * @Author 丁宇辉
 */
@Controller
@RequestMapping("/datax")
public class DataXTestController {

    private String dataxPath = "D:/datax/bin/datax.py";
    private String jsonPath = "D:/datax/job/mysql2odps.json";
    private String pythonPath = "C:/Python27/python.exe";


    /**
     * 通过调用Python执行datax的数据库同步
     * @return
     */
    @RequestMapping("test")
    @ResponseBody
    public String dataxTest(){

        try {
            System.out.println("start");
            String windowcmd =  pythonPath+" "+dataxPath+" "+ jsonPath;
            System.out.println(windowcmd);
            Process pr = Runtime.getRuntime().exec(windowcmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");

        } catch (Exception e) {
            e.printStackTrace();
            return "同步失败";
        }

        return "同步成功";
    }
}
