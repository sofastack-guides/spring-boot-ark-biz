package com.alipay.sofa.springbootarkbiz.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello to ark dynamic deploy";
    }
}
