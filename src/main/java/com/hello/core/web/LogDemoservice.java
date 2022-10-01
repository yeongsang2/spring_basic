package com.hello.core.web;


import com.hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoservice {

    private final ObjectProvider<MyLogger> objectProvider;

    public void logic(String id) {
        MyLogger myLogger = objectProvider.getObject();
        myLogger.log("service id = "+ id);
    }
}
