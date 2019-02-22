package org.suree.middleware.transaction.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EventPublisher {

    @Resource
    private ApplicationContext applicationContext;

    public void publish(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }

}
