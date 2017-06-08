package com.dreammap.ws.utils;/**
 * Created by Lenovo on 2017/4/24.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

/**
 * Title: DmGsonTool
 * Project: DreamMap
 * Package: com.dreammap.ws.utils
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class DmGsonTool {

    public final static String toJson(Object data){
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    public final static Map<String,Object> fromJson(String data){
        GsonBuilder gb = new GsonBuilder();
        Gson g = gb.create();
        Map<String, Object> map = g.fromJson(data, new TypeToken<Map<String, Object>>() {}.getType());
        return map;
    }
}
