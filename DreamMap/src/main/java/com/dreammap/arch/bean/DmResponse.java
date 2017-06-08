package com.dreammap.arch.bean;/**
 * Created by Lenovo on 2017/4/24.
 */

/**
 * Title: DmResponse
 * Project: DreamMap
 * Package: com.dreammap.arch.bean
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class DmResponse {
    private Integer rc;
    private Object data;
    private String errorInfo;
    private Object ips;

    public Integer getRc() {
        return rc;
    }

    public void setRc(Integer rc) {
        this.rc = rc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Object getIps() {
        return ips;
    }

    public void setIps(Object ips) {
        this.ips = ips;
    }
}
