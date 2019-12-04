package com.xxxx.corebanking.lending.service.message.imp;

import com.xxxx.corebanking.lending.service.message.MessageHandler;
import com.xxxx.corebanking.lending.service.message.support.TransactionCode;
import com.xxxx.corebanking.lending.service.message.support.TransactionTypeAnnotation;
import org.springframework.stereotype.Service;

import javax.jms.Message;

@Service
@TransactionTypeAnnotation(value = TransactionCode.ACCOUNT_ENQUIRY)
public class LoanAccountEnquiryHandler implements MessageHandler {
    @Override
    public String processRequest(Message msg) {
        return "--->Response from LoanAccountEnquiry";
    }
}
