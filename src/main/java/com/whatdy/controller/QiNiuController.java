package com.whatdy.controller;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.whatdy.properties.QiniuProperties;
import com.whatdy.utils.QiniuUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("qiniu")
public class QiNiuController {

    private final static Logger logger = LoggerFactory.getLogger(QiNiuController.class);

    @Autowired
    private QiniuProperties qiniu;

    @RequestMapping("index")
    public String index(){
        QiniuUtil qiniuUtil = QiniuUtil.getInstance();
        Auth auth = qiniuUtil.getAuth();
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        putPolicy.put("callbackUrl", "http://localhost:8080/qiniu/upload/callback");
        putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        putPolicy.put("callbackBodyType", "application/json");
        long expireSeconds = 3600;
        String token = auth.uploadToken(qiniu.getBucket(), null, expireSeconds, putPolicy);
        logger.info("========token========="+ token);
        return "qiniu";
    }
    //七牛云回调
    @RequestMapping("uploadCallback")
    @ResponseBody
    public String callback(){
        return "uploadCallback" ;
    }



}
