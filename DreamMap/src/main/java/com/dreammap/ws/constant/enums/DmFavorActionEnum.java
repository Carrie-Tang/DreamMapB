package com.dreammap.ws.constant.enums;

import com.dreammap.arch.abstracts.interfaces.enums.DmEnumInterface;
import com.dreammap.ws.constant.name.DmFavorActionName;

/**
 * Created by Lenovo on 2017/4/24.
 */
public enum DmFavorActionEnum implements DmEnumInterface {
    CONQUER(DmFavorActionName.FAVOR_ACTION_CONQUER,200);

    private String name;
    private int value;

    DmFavorActionEnum(String name, int value){
        this.name=name;
        this.value=value;
    }
}
