package com.cwp;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置类
 */
//配置注解,获取cwp前缀开头的属性，注入类中
@ConfigurationProperties(prefix = "cwp")
public class CwpProperties {


    private  String  url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
