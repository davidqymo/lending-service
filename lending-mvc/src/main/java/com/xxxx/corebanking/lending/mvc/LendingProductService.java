package com.xxxx.corebanking.lending.mvc;

import com.xxxx.corebanking.lending.entity.LoanProductControl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class LendingProductService {

    @RequestMapping("/hello")
    @ResponseBody
    public LoanProductControl hello() {
        LoanProductControl control = new LoanProductControl( );
        control.setProductId( "HML" );
        control.setProductDescription( "住房抵押贷款" );
        control.setCreateTime( new Date( System.currentTimeMillis( ) ) );
        control.setCreateTime( new Date( System.currentTimeMillis( ) ) );
        return control;
    }

    @RequestMapping("/")
    @ResponseBody
    public String defaultPage() {
        return "<h1>Default Welcome Page !</h1>";
    }
}
