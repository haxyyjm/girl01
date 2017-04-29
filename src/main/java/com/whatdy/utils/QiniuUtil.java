package com.whatdy.utils;

import com.qiniu.util.Auth;
import com.whatdy.properties.QiniuProperties;
import org.springframework.beans.factory.annotation.Autowired;

//七牛云工具类
public class QiniuUtil {

    private static volatile  QiniuUtil instance ;

    private String accessKey ;
    private String secretKey ;
    private String bucket ;

    @Autowired
    private QiniuProperties qiniu;

    private QiniuUtil() {
    }
    //单例
    public static QiniuUtil getInstance(){
        if (instance ==null) {
            synchronized (QiniuUtil.class) {
                if (instance == null) {
                    instance = new QiniuUtil();
                }
            }
        }
        return  instance;
    }
    public  Auth getAuth(){
        accessKey = qiniu.getAccessKey();
        secretKey = qiniu.getSecretKey();
        bucket = qiniu.getBucket();
        return  Auth.create(accessKey,secretKey);
    }

}
