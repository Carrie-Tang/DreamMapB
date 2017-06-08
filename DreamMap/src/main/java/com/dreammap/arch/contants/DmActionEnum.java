package com.dreammap.arch.contants;

import com.dreammap.arch.abstracts.interfaces.enums.DmEnumInterface;

/**
 * Created by Lenovo on 2017/4/24.
 */
public enum DmActionEnum implements DmEnumInterface{
    /**
     * Entity action names.
     * The first one is no-use but for place holder.
     * */
    ENTITY("ENTITY", 0),
    ADD(DmActionName.ACTION_ADD, 1),
    DEL(DmActionName.ACTION_DEL, 2),
    UPD(DmActionName.ACTION_UPD, 3),
    ONE(DmActionName.ACTION_ONE, 4),
    LST(DmActionName.ACTION_LST, 5);

    private String name;
    private int value;

    DmActionEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
