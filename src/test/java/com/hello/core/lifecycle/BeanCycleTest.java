package com.hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanCycleTest  {

    @Test
    public void lifeCycleTest(){

        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetWorkClient client = ac.getBean(NetWorkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{

        @Bean
        public NetWorkClient netWorkClient(){
            NetWorkClient netWorkClient=  new NetWorkClient();
            netWorkClient.setUrl("http://hello-srping");
            return netWorkClient;
        }
    }
}
