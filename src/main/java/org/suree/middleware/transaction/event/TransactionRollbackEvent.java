package org.suree.middleware.transaction.event;

import org.springframework.context.ApplicationEvent;

public class TransactionRollbackEvent extends ApplicationEvent {

    public TransactionRollbackEvent(Object o){
        super(o);
    }
}
