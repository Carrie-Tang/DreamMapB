package com.dreammap.arch.abstracts.services.bizservice;/**
 * Created by Lenovo on 2017/4/22.
 */

import com.dreammap.arch.contants.DmActionEnum;

import java.util.Map;

/**
 * Title: DmBizServiceAbstract
 * Project: DreamMap
 * Package: com.dreammap.arch.abstracts.services
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/22
 */

public abstract class DmBizServiceAbstract {

    protected Object processEntityAction(DmActionEnum actionType, Map<String, Object> params) {
        Object response = null;
        switch ((DmActionEnum)actionType) {
            case ADD:
                response = this.add(params);
                break;
            case DEL:
                response = this.del(params);
                break;
            case UPD:
                response = this.upd(params);
                break;
            case ONE:
                response = this.one(params);
                break;
            case LST:
                response = this.lst(params);
                break;
            default:
                response = new Object();
                break;
        }
        return response;
    }

    /**
     * Abstract method to process biz action,
     * implemented by biz service class
     * */
    protected abstract Object add(Map<String, Object> params);
    protected abstract Object del(Map<String, Object> params);
    protected abstract Object upd(Map<String, Object> params);
    protected abstract Object lst(Map<String, Object> params);
    protected abstract Object one(Map<String, Object> params);
}
