package com.xxxx.corebanking.lending.service.message.imp;

import com.xxxx.corebanking.lending.service.message.support.TransactionCode;
import com.xxxx.corebanking.lending.service.message.support.TransactionTypeAnnotation;
import com.xxxx.corebanking.lending.service.message.MessageHandler;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import java.util.concurrent.ThreadLocalRandom;

@Service
@TransactionTypeAnnotation(value = TransactionCode.ACCOUNT_OVERVIEW)
public class LoanAccountOverviewHandler implements MessageHandler {
    @Override
    public String processRequest(Message msg) {
        int sleepInterval = ThreadLocalRandom.current( ).nextInt( 500 );
        try {
            Thread.sleep( sleepInterval );
        } catch (InterruptedException e) {
            e.printStackTrace( );
        }
        return "--->Response from LoanAccountOverview";
    }
}
