package com.anythy.wechat.cofig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

/**
 * Created by Leach on 0002 2018/3/2.
 */
@EnableAutoConfiguration
public class WebsocketSourceConfiguration {
    @Bean
    TomcatEmbeddedServletContainerFactory servletWebServerFactory(){
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        return factory;
    }
}
