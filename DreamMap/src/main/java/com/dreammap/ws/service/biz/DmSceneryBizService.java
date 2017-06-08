package com.dreammap.ws.service.biz;/**
 * Created by Lenovo on 2017/5/13.
 */

import com.dreammap.arch.abstracts.interfaces.enums.DmEnumInterface;
import com.dreammap.arch.abstracts.interfaces.service.DmBizServiceInterface;
import com.dreammap.arch.abstracts.services.bizservice.DmBizServiceAbstract;
import com.dreammap.arch.bean.DmResponse;
import com.dreammap.arch.contants.DmActionEnum;
import com.dreammap.arch.util.DmResponseFormatter;
import com.dreammap.ws.constant.enums.DmSceneryActionEnum;
import com.dreammap.ws.constant.name.DmBizServiceName;
import com.dreammap.ws.service.data.DmSceneryDataService;
import com.dreammap.ws.utils.DmTokenTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Title: DmSceneryBizService
 * Project: DreamMap
 * Package: com.dreammap.ws.service.biz
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/5/13
 */
@Component
@Resource(name = DmBizServiceName.SCENERY_SERVICE)
public class DmSceneryBizService extends DmBizServiceAbstract implements DmBizServiceInterface {

    @Autowired
    private DmSceneryDataService dmSceneryDataService;


    @Override
    public Object execute(DmEnumInterface action, Map<String, Object> params) {
        Object response = null;
        if (action instanceof DmActionEnum) {
            response = this.processEntityAction((DmActionEnum)action, params);
        } else if (action instanceof DmSceneryActionEnum) {
            response = this.processBizAction(action, params);
        }
        return response;
    }

    protected Object processBizAction(DmEnumInterface actionType, Map<String, Object> params) {
        DmResponse response = null;
        switch ((DmSceneryActionEnum)actionType) {
            case RECOMMEND:
                break;
            default:
                break;
        }
        return response;
    }

    @Override
    protected Object add(Map<String, Object> params) {
        return null;
    }

    @Override
    protected Object del(Map<String, Object> params) {
        return null;
    }

    @Override
    protected Object upd(Map<String, Object> params) {
        return null;
    }

    @Override
    protected Object lst(Map<String, Object> params) {
        DmResponse response = DmResponseFormatter.format();
        try {
            if(params.containsKey("userId")&&params.containsKey("token")){
                String token = (String) params.get("token");
                if(DmTokenTool.checkToken(token)){
                    response.setData(this.dmSceneryDataService.lst());
                }else {
                    response.setData("请您先登录");
                }
            }else {
                response.setData("Incorrect parameters");
            }
        }catch (Exception e){
            response = DmResponseFormatter.format(e);
        }
        return response;
    }

    @Override
    protected Object one(Map<String, Object> params) {
        return null;
    }
}
