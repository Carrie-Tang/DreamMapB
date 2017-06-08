package com.dreammap.ws.utils;/**
 * Created by Lenovo on 2017/4/24.
 */

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import java.util.Random;

/**
 * Title: DmMSGTool
 * Project: DreamMap
 * Package: com.dreammap.ws.utils
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class DmMSGTool {

    private final static String MSG_URL = "http://gw.api.taobao.com/router/rest";
    private final static String MSG_APPKEY = "23770315";
    private final static String MSG_SECRET = "74d91349bc68d95ac3a2f20e000cc305";

    private final static String SIGN_NAME = "梦想地图";
    private final static String TEMP_CODE = "SMS_63185206";

    public final static boolean sendRegMSG(String phone,String msg) throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(MSG_URL, MSG_APPKEY, MSG_SECRET);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        /**
         * req.setExtend( "$userId" );
         * 用于确定用户身份的其他字段
         */
        req.setSmsType( "normal" );
        req.setSmsFreeSignName( SIGN_NAME );
        req.setSmsParamString( msg );
        req.setRecNum( phone );
        req.setSmsTemplateCode( TEMP_CODE );
        AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
        return rsp.getResult().getSuccess();
    }

    public final static String smsCodeFormat(String msg){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{smsCode:'");
        stringBuilder.append(msg);
        stringBuilder.append("'}");
        return stringBuilder.toString();
    }

    public static String getMsgCode(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

}
