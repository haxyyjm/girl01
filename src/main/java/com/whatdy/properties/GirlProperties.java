package com.whatdy.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取 yml配置文件
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties  {

    @Value("girl.cupSize")
    private String cupSize;

    @Value("girl.age")
    private String age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
