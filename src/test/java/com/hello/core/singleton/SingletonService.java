package com.hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // static -> 객체끼리 공유

    private SingletonService(){}

    public static SingletonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);

        assertThat(singletonService1).isEqualTo(singletonService2);
        // 같은 객체 instance 반환
        // same -> == 비교 객체 instance가 같은지
        // equal -> java의 equals

    }


}
