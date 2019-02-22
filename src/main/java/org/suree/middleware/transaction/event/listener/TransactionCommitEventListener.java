package org.suree.middleware.transaction.event.listener;

import org.springframework.context.ApplicationListener;
import org.suree.middleware.transaction.event.TransactionCommitEvent;

public class TransactionCommitEventListener implements ApplicationListener<TransactionCommitEvent> {

    public void onApplicationEvent(TransactionCommitEvent transactionCommitEvent) {

    }
}
