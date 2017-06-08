package com.dreammap.ws.utils;/**
 * Created by Lenovo on 2017/4/24.
 */

import org.springframework.util.DigestUtils;

/**
 * Title: DmTokenTool
 * Project: DreamMap
 * Package: com.dreammap.ws.utils
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class DmTokenTool {

    private final static String TOKEN = "DM";

    private final static String FLAG = "Y";

    public final static String getToken(String userName){
        RedisTool redisTool = new RedisTool();
        String data = userName + System.currentTimeMillis();
        String encodeStr = DigestUtils.md5DigestAsHex(data.getBytes());
        redisTool.set(encodeStr,FLAG,3600*24*3);
        return encodeStr;
    }

    public final static boolean checkToken(String token){
        RedisTool redisTool = new RedisTool();
        if(TOKEN.equals(token)){
            return true;
        }else{
            String tokenResult = redisTool.get(token);
            if(FLAG.equals(tokenResult)){
                return true;
            }else{
                return false;
            }
        }
    }

}
