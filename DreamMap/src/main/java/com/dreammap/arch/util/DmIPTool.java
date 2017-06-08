package com.dreammap.arch.util;/**
 * Created by Lenovo on 2017/4/24.
 */

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: DmIPTool
 * Project: DreamMap
 * Package: com.dreammap.arch.util
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class DmIPTool {

    public static Map<String, Object> getIPs() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, Object> ips = new HashMap<String, Object>();
        ips.put("X-Forwarded-For", request.getHeader("X-Forwarded-For"));
        ips.put("X-Real-IP", request.getHeader("X-Real-IP"));
        ips.put("Proxy-Client-IP", request.getHeader("Proxy-Client-IP"));
        ips.put("WL-Proxy-Client-IP", request.getHeader("WL-Proxy-Client-IP"));
        ips.put("RemoteAddr", request.getRemoteAddr());
        return ips;
    }

}
