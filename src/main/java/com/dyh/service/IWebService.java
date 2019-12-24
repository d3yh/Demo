package com.dyh.service;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Service
@WebService(name = "MasterDataService",
        targetNamespace = "http://IWebService/service.dyh.com")
public interface IWebService {

    @WebMethod
    String emrService(@WebParam String data);

}
