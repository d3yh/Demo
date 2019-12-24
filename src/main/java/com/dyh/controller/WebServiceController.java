package com.dyh.controller;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Date 2019/12/23 10:20
 * @Author 丁宇辉
 */
@Controller
@RequestMapping("webservice")
public class WebServiceController {


    @RequestMapping("query")
    @ResponseBody
    public  String wenServiceTest(){

//        WeatherWebService weatherWebService = new WeatherWebService();
//        WeatherWebServiceSoap weatherWebServiceSoap = weatherWebService.getWeatherWebServiceSoap();
//
//        ArrayOfString city = weatherWebServiceSoap.getWeatherbyCityName("深圳");

//        for (String c : city.getString()){
//            System.out.println(c);
//        }

//        for (int i = 0; i < city.getString().size(); i++){
//            System.out.println(city.getString().get(i) + "i的值："+i);
//        }


        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://www.webxml.com.cn/WebServices/ChinaStockWebService.asmx?wsdl");
        Object[] objects = new Object[0];

        try {
            objects = client.invoke("getStockInfoByCode","sh000001");


            System.out.println("返回数据:" + objects[0]);

        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return "heihei";
    }
}
