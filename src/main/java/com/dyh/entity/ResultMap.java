package com.dyh.entity;

import java.util.HashMap;


public class ResultMap<K, V> extends HashMap {

    public static final String SUCCESS = "success";

    public static final String CODE = "errorCode";

    public ResultMap() {
        this.put(SUCCESS, true);
        this.put(CODE, "");
    }

    public void addError(String code) {
        this.put(SUCCESS, false);
        this.put(CODE, code);
    }

    public boolean isError(String code) {
        if (this.get(SUCCESS) != null && !(Boolean) this.get(SUCCESS) &&
                this.get(CODE) != null && this.get(CODE).equals(code)) {
            return true;
        }
        return false;
    }

    public String getCode(){
        return (String) this.get(CODE);
    }

    public boolean isSuccess(){
        if (this.get(SUCCESS) != null && (Boolean) this.get(SUCCESS)) {
            return true;
        }
        return false;
    }

}
