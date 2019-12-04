package com.xxxx.corebanking.lending.service.message.imp;

import com.xxxx.corebanking.lending.service.message.support.TransactionCode;
import com.xxxx.corebanking.lending.service.message.support.TransactionTypeAnnotation;
import com.xxxx.corebanking.lending.service.message.MessageHandler;
import org.springframework.stereotype.Service;

import javax.jms.Message;

@Service
@TransactionTypeAnnotation(value = TransactionCode.ACCOUNT_OVERVIEW)
public class LoanAccountOverviewHandler implements MessageHandler {
    @Override
    public String processRequest(Message msg) {
        System.out.println( "Processing Request in -> " + this.getClass( ).getName( ) );
        return "--->Response from LoanAccountOverview";
    }
}
