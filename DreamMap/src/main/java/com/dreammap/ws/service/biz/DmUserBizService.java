package com.dreammap.ws.service.biz;/**
 * Created by Lenovo on 2017/4/24.
 */

import com.dreammap.arch.abstracts.interfaces.enums.DmEnumInterface;
import com.dreammap.arch.abstracts.interfaces.service.DmBizServiceInterface;
import com.dreammap.arch.abstracts.services.bizservice.DmBizServiceAbstract;
import com.dreammap.arch.bean.DmResponse;
import com.dreammap.arch.contants.DmActionEnum;
import com.dreammap.arch.util.DmResponseFormatter;
import com.dreammap.ws.bean.DmUser;
import com.dreammap.ws.constant.enums.DmUserActionEnum;
import com.dreammap.ws.constant.name.DmBizServiceName;
import com.dreammap.ws.service.data.DmUserDataService;
import com.dreammap.ws.utils.DmMD5Tool;
import com.dreammap.ws.utils.DmMSGTool;
import com.dreammap.ws.utils.DmTokenTool;
import com.dreammap.ws.utils.RedisTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Title: DmUserBizService
 * Project: DreamMap
 * Package: com.dreammap.ws.service.biz
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */
@Component
@Resource(name = DmBizServiceName.USER_SERVICE)
public class DmUserBizService extends DmBizServiceAbstract implements DmBizServiceInterface{

    @Autowired
    private DmUserDataService dmUserDataService;

    @Override
    public Object execute(DmEnumInterface action, Map<String, Object> params) {
        Object response = null;
        if (action instanceof DmActionEnum) {
            response = this.processEntityAction((DmActionEnum)action, params);
        } else if (action instanceof DmUserActionEnum) {
            response = this.processBizAction(action, params);
        }
        return response;
    }

    protected Object processBizAction(DmEnumInterface actionType, Map<String, Object> params) {
        DmResponse response = null;
        switch ((DmUserActionEnum)actionType) {
            case SENDMSG:
                response = this.sendMSG(params);
                break;
            case CONFIRM:
                response = this.confirm(params);
                break;
            case LOGIN:
                response = this.login(params);
                break;
            case LOGOUT:
                response = this.logout(params);
                break;
            default:
                break;
        }
        return response;
    }

    protected DmResponse logout(Map<String, Object> params){
        RedisTool redisTool = new RedisTool();
        DmResponse response = DmResponseFormatter.format();
        try {
            if(params.containsKey("userId")&&params.containsKey("token")){
                String userId = (String) params.get("userId");
                String token = (String) params.get("token");
                DmUser dmUser = this.dmUserDataService.one(Integer.parseInt(userId));
                if(null!=dmUser&&DmTokenTool.checkToken(token)){
                    redisTool.delete(token);
                    response.setData(true);
                }else {
                    response.setData("用户未登录");
                }
            }else {
                response.setData("Incorrect parameters");
            }
        }catch (Exception e){
            response = DmResponseFormatter.format(e);
        }
        return response;
    }

    protected DmResponse login(Map<String, Object> params){
        RedisTool redisTool = new RedisTool();
        DmResponse response = DmResponseFormatter.format();
        try {
            if(params.containsKey("phone")&&params.containsKey("password")){
                String phone = (String) params.get("phone");
                String password = (String) params.get("password");
                DmUser dmUser = this.dmUserDataService.getOneByPhone(phone);
                if(null!=dmUser){
                    if(dmUser.getPassword().equals(DmMD5Tool.getMd5(password))){
                        dmUser.setPassword(null);
                        String token = DmTokenTool.getToken(dmUser.getUserName());
                        dmUser.setToken(token);
                        response.setData(dmUser);
                    }else{
                        response.setData("请输入正确的密码");
                    }
                }else {
                    response.setData("用户未注册");
                }
            }else {
                response.setData("Incorrect parameters");
            }
        }catch (Exception e){
            response = DmResponseFormatter.format(e);
        }
        return response;
    }

    protected DmResponse sendMSG(Map<String, Object> params){
        RedisTool redisTool = new RedisTool();
        DmResponse response = DmResponseFormatter.format();
        try {
            if(params.containsKey("phone")){
                String phone = (String) params.get("phone");
                String msg = DmMSGTool.getMsgCode();
                boolean flag = DmMSGTool.sendRegMSG(phone,DmMSGTool.smsCodeFormat(msg));
                if(flag){
                    redisTool.set(phone,msg,300);
                }
                response.setData(flag);
            }else {
                response.setData("Incorrect parameters");
            }
        }catch (Exception e){
            response = DmResponseFormatter.format(e);
        }
        return response;
    }

    protected DmResponse confirm(Map<String, Object> params){
        DmResponse response = DmResponseFormatter.format();
        try {
            if(params.containsKey("phone")&&params.containsKey("msg")){
                String phone = (String) params.get("phone");
                String msg = (String) params.get("msg");

                response.setData(this.checkMSG(phone,msg));
            }else {
                response.setData("Incorrect parameters");
            }
        }catch (Exception e){
            response = DmResponseFormatter.format(e);
        }

        return response;
    }

    private boolean checkMSG(String phone,String msg){
        RedisTool redisTool = new RedisTool();
        String standardMSG = redisTool.get(phone);
        return msg.equals(standardMSG)&&null!=msg;
    }

    @Override
    protected Object add(Map<String, Object> params) {
        DmResponse response = DmResponseFormatter.format();
        try {
            if(params.containsKey("userName")&&params.containsKey("phone")&&params.containsKey("password")){
                DmUser user = new DmUser();
                String userName = (String) params.get("userName");
                String phone = (String) params.get("phone");
                String password = (String) params.get("password");
                user.setUserName(userName);
                user.setPhone(phone);
                user.setPassword(DmMD5Tool.getMd5(password));
                this.dmUserDataService.add(user);
                user.setPassword(null);
                response.setData(user);
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
        return null;
    }

    @Override
    protected Object one(Map<String, Object> params) {
        return null;
    }
}
