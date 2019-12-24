package com.dyh.service.impl;

import com.dyh.service.IWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @Date 2019/12/20 18:26
 * @Author 丁宇辉
 */
@Slf4j
@Service
@WebService(name = "MasterDataService",
        targetNamespace = "http://IWebService/service.dyh.com",
        endpointInterface = "com.dyh.service.IWebService")
public class WebServiceImpl implements IWebService {

    private static final String RESPONSE = "<Response><Header><SourceSystem>%s</SourceSystem><MessageID>%s</MessageID></Header><Body><ResultCode>%s</ResultCode><ResultContent>%s</ResultContent></Body></Response>";

    @Override
    public String emrService(String data) {
        log.info("接收参数 => [ {} ]", data);
        if (data.isEmpty()) {
            return "传入的参数为空";
        }
        return String.format(RESPONSE, "01", "", "0", "成功");
    }



}
