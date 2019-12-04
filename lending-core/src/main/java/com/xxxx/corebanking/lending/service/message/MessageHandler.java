package com.xxxx.corebanking.lending.service.message;

import javax.jms.Message;

public interface MessageHandler {

    String processRequest(Message msg);
}
