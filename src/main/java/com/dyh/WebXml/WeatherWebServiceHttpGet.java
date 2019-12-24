
package com.dyh.WebXml;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WeatherWebServiceHttpGet", targetNamespace = "http://WebXml.com.cn/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WeatherWebServiceHttpGet {


    /**
     * 
     * @param byProvinceName
     * @return
     *     returns com.dyh.WebXml.ArrayOfString
     */
    @WebMethod
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public ArrayOfString getSupportCity(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "byProvinceName")
        String byProvinceName);

    /**
     * 
     * @return
     *     returns com.dyh.WebXml.ArrayOfString
     */
    @WebMethod
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public ArrayOfString getSupportProvince();

    /**
     * 
     * @return
     *     returns com.dyh.WebXml.DataSet
     */
    @WebMethod
    @WebResult(name = "DataSet", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public DataSet getSupportDataSet();

    /**
     * 
     * @param theCityName
     * @return
     *     returns com.dyh.WebXml.ArrayOfString
     */
    @WebMethod
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public ArrayOfString getWeatherbyCityName(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "theCityName")
        String theCityName);

    /**
     * 
     * @param theCityName
     * @param theUserID
     * @return
     *     returns com.dyh.WebXml.ArrayOfString
     */
    @WebMethod
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    public ArrayOfString getWeatherbyCityNamePro(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "theCityName")
        String theCityName,
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "theUserID")
        String theUserID);

}
