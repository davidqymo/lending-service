package com.xxxx.corebanking.lending.service.message.support;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionTypeAnnotation {
    String value();
}
