package com.dreammap.ws.constant.enums;

import com.dreammap.arch.abstracts.interfaces.enums.DmEnumInterface;
import com.dreammap.ws.constant.name.DmUserActionName;

/**
 * Created by Lenovo on 2017/4/24.
 */
public enum DmUserActionEnum implements DmEnumInterface {
    REGISTER(DmUserActionName.USER_ACTION_REGISTER,170),
    SENDMSG(DmUserActionName.USER_ACTION_SENDMSG,171),
    CONFIRM(DmUserActionName.USER_ACTION_CONFIRM,172),
    LOGIN(DmUserActionName.USER_ACTION_LOGIN,173),
    LOGOUT(DmUserActionName.USER_ACTION_LOGOUT,174);

    private String name;
    private int value;

    DmUserActionEnum(String name,int value){
        this.name=name;
        this.value=value;
    }
}
