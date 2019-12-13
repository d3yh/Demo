package com.dyh.controller;

import com.dyh.entity.ResultMap;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.request.TmallCrmMemberFrontBindRequest;
import com.taobao.api.request.TmallCrmMemberGetRequest;
import com.taobao.api.response.TmallCrmMemberFrontBindResponse;
import com.taobao.api.response.TmallCrmMemberGetResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Date 2019/12/6 15:52
 * @Author 丁宇辉
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    private  String serviceUrl = "http://gw.api.taobao.com/router/rest";
    private  String sellerId = "177718746";
    private  String appsecret = "1fa11faa1a6b8c10f460b8dffb57fdfa";
    private  String appkey = "23086869";
    private  String sessionKey = "61017226c5bce4a94342d469abef7b1e042510c8c97d429177718746";
    DefaultTaobaoClient taobaoClient = new DefaultTaobaoClient(serviceUrl,appkey,appsecret);

    @RequestMapping("/getMember")
    @ResponseBody
    public ResultMap getMember(String userNick){

        ResultMap resultMap = new ResultMap();

        TmallCrmMemberGetRequest request = new TmallCrmMemberGetRequest();
        request.setUserNick(userNick);

        try {
            TmallCrmMemberGetResponse response = taobaoClient.execute(request, sessionKey);
            if (response != null && response.isSuccess()){
                resultMap.put("member",response.getCrmMember());
            }else {
                resultMap.addError(response.getSubCode());
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    @RequestMapping("/bind")
    @ResponseBody
    public ResultMap bindConfirm(String userNick, String mobile, String code){
        ResultMap resultMap = new ResultMap();
        TmallCrmMemberFrontBindRequest request = new TmallCrmMemberFrontBindRequest();
        request.setUserNick(userNick);
        request.setCode(code);
        request.setMobile(mobile);

        try {
            TmallCrmMemberFrontBindResponse response = taobaoClient.execute(request, sessionKey);
            if(!response.isSuccess()){
                resultMap.addError(response.getSubCode());
            }
        } catch (ApiException e) {
            e.printStackTrace();

        }
        return resultMap;
    }



}
