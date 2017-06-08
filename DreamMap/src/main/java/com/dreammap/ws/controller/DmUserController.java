package com.dreammap.ws.controller;/**
 * Created by Lenovo on 2017/4/24.
 */

import com.dreammap.arch.abstracts.controllers.DmControllerAbstract;
import com.dreammap.arch.abstracts.interfaces.controller.DmControllerInterface;
import com.dreammap.arch.abstracts.interfaces.service.DmBizServiceInterface;
import com.dreammap.arch.contants.DmActionEnum;
import com.dreammap.arch.contants.DmActionName;
import com.dreammap.arch.util.DmResponseFormatter;
import com.dreammap.ws.constant.enums.DmUserActionEnum;
import com.dreammap.ws.constant.name.DmBizServiceName;
import com.dreammap.ws.constant.name.DmUserActionName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Title: DmUserController
 * Project: DreamMap
 * Package: com.dreammap.ws.controller
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */
@Component
@Scope("request")
@Path(value = "/user")
public class DmUserController extends DmControllerAbstract implements DmControllerInterface{

    @Autowired
    @Qualifier(DmBizServiceName.USER_SERVICE)
    private DmBizServiceInterface bizService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value = DmActionName.ACTION_AUTH + URL_EXTENSION)
    public Object auth(@Context HttpServletRequest httpRequest){
        Map<String,Object> params = this.resolveParams(httpRequest);
        Object data = DmResponseFormatter.format("Ces't la vie!");
        return data;
    }

    @Transactional(
            value = "mainTransactionManager",
            timeout = 30,
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            readOnly = false,
            rollbackFor = Exception.class)
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value = DmUserActionName.USER_ACTION_REGISTER + URL_EXTENSION)
    @Override
    public Object add(@Context HttpServletRequest httpRequest) {
        Map<String,Object> params = this.resolveParams(httpRequest);
        Object rtnData = this.bizService.execute(DmActionEnum.ADD,params);
        return rtnData;
    }

    @Override
    public Object del(@Context HttpServletRequest httpRequest) {
        return null;
    }

    @Override
    public Object upd(@Context HttpServletRequest httpRequest) {
        return null;
    }

    @Override
    public Object one(@Context HttpServletRequest httpRequest) {
        return null;
    }

    @Override
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value = DmActionName.ACTION_LST + URL_EXTENSION)
    public Object lst(@Context HttpServletRequest httpRequest) {
        Map<String, Object> params = this.resolveParams(httpRequest);
        Object rtnData = this.bizService.execute(DmActionEnum.LST, params);
        return rtnData;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value = DmUserActionName.USER_ACTION_SENDMSG + URL_EXTENSION)
    public Object sendMSG(@Context HttpServletRequest httpRequest) {
        Map<String, Object> params = this.resolveParams(httpRequest);
        Object rtnData = this.bizService.execute(DmUserActionEnum.SENDMSG, params);
        return rtnData;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value = DmUserActionName.USER_ACTION_CONFIRM + URL_EXTENSION)
    public Object confirm(@Context HttpServletRequest httpRequest) {
        Map<String, Object> params = this.resolveParams(httpRequest);
        Object rtnData = this.bizService.execute(DmUserActionEnum.CONFIRM, params);
        return rtnData;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value =  DmUserActionName.USER_ACTION_LOGIN + URL_EXTENSION)
    public Object login(@Context HttpServletRequest httpRequest) {
        Map<String, Object> params = this.resolveParams(httpRequest);
        Object rtnData = this.bizService.execute(DmUserActionEnum.LOGIN, params);
        return rtnData;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value =  DmUserActionName.USER_ACTION_LOGOUT + URL_EXTENSION)
    public Object logout(@Context HttpServletRequest httpRequest) {
        Map<String, Object> params = this.resolveParams(httpRequest);
        Object rtnData = this.bizService.execute(DmUserActionEnum.LOGOUT, params);
        return rtnData;
    }
}
