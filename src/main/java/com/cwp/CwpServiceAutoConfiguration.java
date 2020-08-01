package com.cwp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  自动配置类
 */
@Configuration
@ConditionalOnClass(CwpService.class)  //当CwpService.class 在类路径中时生效
//当配置文件中存在cwp.enabled=open的配置值时生效，如果没配置这个属性值时也生效
@ConditionalOnProperty(prefix = "cwp",name = "enabled",havingValue = "open",matchIfMissing = true)
@EnableConfigurationProperties(CwpProperties.class)//开启配置属性注解,导入CwpProperties类，生成对应的bean
public class CwpServiceAutoConfiguration {

    @Autowired
    private  CwpProperties  cwpProperties;


   @Bean
   @ConditionalOnMissingBean  //当容器中不存在类型为CwpService的Bean时，生成对应的bean
   public CwpService getCwpService(){
       CwpService  cwpService=new CwpService();
       cwpService.setUrl(cwpProperties.getUrl());
       return cwpService;
   }
}
