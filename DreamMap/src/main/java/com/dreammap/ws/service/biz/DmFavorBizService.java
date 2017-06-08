package com.dreammap.ws.service.biz;/**
 * Created by Lenovo on 2017/5/13.
 */

import com.dreammap.arch.abstracts.interfaces.enums.DmEnumInterface;
import com.dreammap.arch.abstracts.interfaces.service.DmBizServiceInterface;
import com.dreammap.arch.abstracts.services.bizservice.DmBizServiceAbstract;
import com.dreammap.arch.bean.DmResponse;
import com.dreammap.arch.contants.DmActionEnum;
import com.dreammap.arch.util.DmResponseFormatter;
import com.dreammap.ws.bean.DmFavor;
import com.dreammap.ws.constant.enums.DmFavorActionEnum;
import com.dreammap.ws.constant.name.DmBizServiceName;
import com.dreammap.ws.service.data.DmFavorDataService;
import com.dreammap.ws.utils.DmTokenTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Title: DmFavorBizService
 * Project: DreamMap
 * Package: com.dreammap.ws.service.biz
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/5/13
 */
@Component
@Resource(name = DmBizServiceName.FAVOR_SERVICE)
public class DmFavorBizService extends DmBizServiceAbstract implements DmBizServiceInterface {

    @Autowired
    private DmFavorDataService dmFavorDataService;

    @Override
    public Object execute(DmEnumInterface action, Map<String, Object> params) {
        Object response = null;
        if (action instanceof DmActionEnum) {
            response = this.processEntityAction((DmActionEnum)action, params);
        } else if (action instanceof DmFavorActionEnum) {
            response = this.processBizAction(action, params);
        }
        return response;
    }

    protected Object processBizAction(DmEnumInterface actionType, Map<String, Object> params) {
        DmResponse response = null;
        switch ((DmFavorActionEnum)actionType) {
            case CONQUER:
                response=this.conquer(params);
                break;
            default:
                break;
        }
        return response;
    }

    private  DmResponse conquer(Map<String, Object> params){
        DmResponse response = DmResponseFormatter.format();
        try {
            if(params.containsKey("favorId")&&params.containsKey("token")){
                String favorId = (String) params.get("favorId");
                String token = (String) params.get("token");
                if(DmTokenTool.checkToken(token)){
                    response.setData(this.dmFavorDataService.upd(Integer.parseInt(favorId)));
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
    protected Object add(Map<String, Object> params) {
        DmResponse response = DmResponseFormatter.format();
        try {
            if(params.containsKey("userId")&&params.containsKey("token")&&params.containsKey("sceneryId")){
                String userId = (String) params.get("userId");
                String sceneryId = (String) params.get("sceneryId");
                String token = (String) params.get("token");
                if(DmTokenTool.checkToken(token)){
                    DmFavor dmFavor = new DmFavor();
                    dmFavor.setUserId(Integer.parseInt(userId));
                    dmFavor.setSceneryId(Integer.parseInt(sceneryId));
                    response.setData(this.dmFavorDataService.add(dmFavor));
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
                String userId = (String) params.get("userId");
                String token = (String) params.get("token");
                if(DmTokenTool.checkToken(token)){
                    response.setData(this.dmFavorDataService.lst(Integer.parseInt(userId)));
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
