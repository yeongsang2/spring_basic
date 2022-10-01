package com.hello.core.web;


import com.hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoservice {

    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = "+ id);
    }
}
