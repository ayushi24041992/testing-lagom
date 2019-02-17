package com.knoldus.com.impl;
import com.google.inject.AbstractModule;
import com.knoldus.DemoService;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;


public class DemoModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {
        bindService(DemoService.class, DemoServiceImpl.class);
    }
}