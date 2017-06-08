package com.dreammap.arch.util;/**
 * Created by Lenovo on 2017/4/24.
 */

import com.dreammap.arch.bean.DmResponse;

/**
 * Title: DmResponseFormatter
 * Project: DreamMap
 * Package: com.dreammap.arch.util
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class DmResponseFormatter {

    /**
     * Used when getting correct response data
     * */
    public static DmResponse format(Object data) {
        DmResponse response = new DmResponse();

        /**
         * Set request code
         */
        response.setRc(0);
        /**
         * Set error info
         * */
        response.setData(data);
        /**
         * Set exception info
         * */
        response.setErrorInfo("Request Success");
        /**
         * Set IPs
         * */
        response.setIps(DmIPTool.getIPs());
        return response;
    }

    public static DmResponse format() {
        DmResponse response = new DmResponse();

        /**
         * Set request code
         */
        response.setRc(0);
        /**
         * Set exception info
         * */
        response.setErrorInfo("Request Success");
        /**
         * Set IPs
         * */
        response.setIps(DmIPTool.getIPs());
        return response;
    }

    /**
     * Used when catching exception
     * */
    public static DmResponse format(Exception ex) {
        DmResponse response = new DmResponse();

        /**
         * Set request code
         */
        response.setRc(1);
        /**
         * Set Error Info
         */
        response.setErrorInfo("[" + ex.getClass().getName() + "]" + ex.getMessage());
        /**
         * Set IPs
         * */
        response.setIps(DmIPTool.getIPs());
        return response;
    }
}
