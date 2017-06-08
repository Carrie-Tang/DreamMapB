package com.dreammap.arch.abstracts.controllers;/**
 * Created by Lenovo on 2017/4/22.
 */

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: DmControllerAbstract
 * Project: DreamMap
 * Package: com.dreammap.arch.abstracts
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/22
 */
public abstract class DmControllerAbstract {

    protected final static String URL_EXTENSION = ".service";

    protected Map<String, Object> resolveParams(HttpServletRequest httpRequest) {
        Map<String,Object> params = new HashMap<String,Object>();
        Enumeration em = httpRequest.getParameterNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            Object value = httpRequest.getParameter(name);
            params.put(name,value);
        }
        return params;
    }

}
