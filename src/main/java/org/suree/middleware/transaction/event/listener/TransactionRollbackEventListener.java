package org.suree.middleware.transaction.event.listener;

import org.springframework.context.ApplicationListener;
import org.suree.middleware.transaction.event.TransactionRollbackEvent;

public class TransactionRollbackEventListener implements ApplicationListener<TransactionRollbackEvent> {

    public void onApplicationEvent(TransactionRollbackEvent transactionRollbackEvent) {

    }
}
