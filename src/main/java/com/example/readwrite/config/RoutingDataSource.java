package com.example.readwrite.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();

        log.info("▶▶▶ 트랜잭션 명: {}", transactionName);
        log.info("▶▶▶ 현재 readOnly 여부: {}", isReadOnly);

        return isReadOnly ? "read" : "write";
    }
}
