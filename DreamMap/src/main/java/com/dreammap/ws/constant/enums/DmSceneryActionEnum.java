package com.dreammap.ws.constant.enums;

import com.dreammap.arch.abstracts.interfaces.enums.DmEnumInterface;
import com.dreammap.ws.constant.name.DmUserActionName;

/**
 * Created by Lenovo on 2017/4/24.
 */
public enum DmSceneryActionEnum implements DmEnumInterface {
    RECOMMEND(DmUserActionName.USER_ACTION_REGISTER,170);

    private String name;
    private int value;

    DmSceneryActionEnum(String name, int value){
        this.name=name;
        this.value=value;
    }
}
