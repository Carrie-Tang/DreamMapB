package com.dreammap.arch.util;/**
 * Created by Lenovo on 2017/5/12.
 */

import com.google.gson.Gson;

/**
 * Title: DmJsonTool
 * Project: DreamMap
 * Package: com.dreammap.arch.util
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/5/12
 */

public class DmJsonTool {
    public static String toJson(Object data){
        Gson gson = new Gson();
        return gson.toJson(data);
    }
}
