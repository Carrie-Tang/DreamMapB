package com.dreammap.arch.abstracts.interfaces.service;

import com.dreammap.arch.abstracts.interfaces.enums.DmEnumInterface;

import java.util.Map;

/**
 * Created by Lenovo on 2017/4/22.
 */
public interface DmBizServiceInterface {
    public Object execute(DmEnumInterface action, Map<String,Object> map);
}
