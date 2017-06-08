package com.dreammap.arch.aspect;/**
 * Created by Lenovo on 2017/4/22.
 */

import com.dreammap.arch.util.DmResponseFormatter;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Title: DmResponseAspect
 * Project: DreamMap
 * Package: com.dreammap.arch.aspect
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/22
 */
public class DmResponseAspect {

    private Gson gson = new Gson();
    public Object parseResultToJson(ProceedingJoinPoint joinPoint){
        Object data;
        try {
            data = joinPoint.proceed();

        } catch (Throwable e) {
            data = DmResponseFormatter.format((Exception)e);
        }
        Object rtnData = gson.toJson(data);
        return rtnData;
    }
}
