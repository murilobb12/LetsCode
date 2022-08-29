package com.letscode.hello.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface HelloService {

    Logger log = LoggerFactory.getLogger(HelloService.class);

    public String getHorario();


}
