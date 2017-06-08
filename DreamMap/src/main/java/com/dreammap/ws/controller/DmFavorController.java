package com.dreammap.ws.controller;/**
 * Created by Lenovo on 2017/5/13.
 */

import com.dreammap.arch.abstracts.controllers.DmControllerAbstract;
import com.dreammap.arch.abstracts.interfaces.controller.DmControllerInterface;
import com.dreammap.arch.abstracts.interfaces.service.DmBizServiceInterface;
import com.dreammap.arch.contants.DmActionEnum;
import com.dreammap.arch.contants.DmActionName;
import com.dreammap.ws.constant.enums.DmFavorActionEnum;
import com.dreammap.ws.constant.name.DmBizServiceName;
import com.dreammap.ws.constant.name.DmFavorActionName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Title: DmSceneryController
 * Project: DreamMap
 * Package: com.dreammap.ws.controller
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/5/13
 */
@Component
@Scope("request")
@Path(value = "/favor")
public class DmFavorController extends DmControllerAbstract implements DmControllerInterface {

    @Autowired
    @Qualifier(DmBizServiceName.FAVOR_SERVICE)
    private DmBizServiceInterface bizService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value = DmActionName.ACTION_ADD + URL_EXTENSION)
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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value = DmActionName.ACTION_LST + URL_EXTENSION)
    @Override
    public Object lst(@Context HttpServletRequest httpRequest) {
        Map<String,Object> params = this.resolveParams(httpRequest);
        Object rtnData = this.bizService.execute(DmActionEnum.LST,params);
        return rtnData;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path(value = DmFavorActionName.FAVOR_ACTION_CONQUER + URL_EXTENSION)
    public Object conquer(@Context HttpServletRequest httpRequest) {
        Map<String,Object> params = this.resolveParams(httpRequest);
        Object rtnData = this.bizService.execute(DmFavorActionEnum.CONQUER,params);
        return rtnData;
    }
}
