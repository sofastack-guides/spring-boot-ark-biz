package com.alipay.sofa.springbootarkbiz.rest;

import com.alipay.sofa.facade.AppService;
import com.alipay.sofa.facade.SampleService;
import com.alipay.sofa.serverless.common.api.AutowiredFromBase;
import com.alipay.sofa.serverless.common.api.SpringServiceFinder;
import com.alipay.sofa.sofaarkspringguides.EnvClient;
import com.alipay.sofa.springbootarkbiz.model.Param;
import com.alipay.sofa.springbootarkbiz.model.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SampleController {

    @AutowiredFromBase(name = "sampleServiceImplNew")
    private SampleService sampleServiceImplNew;

    @AutowiredFromBase(name = "sampleServiceImpl")
    private SampleService sampleServiceImpl;

    @AutowiredFromBase
    private List<SampleService> sampleServiceList;

    @AutowiredFromBase
    private Map<String, SampleService> sampleServiceMap;

    @AutowiredFromBase
    private AppService appService;

    @AutowiredFromBase
    private EnvClient envClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {

        sampleServiceImplNew.service();

        sampleServiceImpl.service();

        for (SampleService sampleService : sampleServiceList) {
            sampleService.service();
        }

        for (String beanName : sampleServiceMap.keySet()) {
            sampleServiceMap.get(beanName).service();
        }

        appService.getAppName();

        envClient.getEnv();


        SampleService sampleServiceImplFromFinder = SpringServiceFinder.getBaseService("sampleServiceImpl");
        String result = sampleServiceImplFromFinder.service();
        System.out.println(result);

        Map<String, SampleService> sampleServiceMapFromFinder = SpringServiceFinder.listBaseServices(SampleService.class);
        for (String beanName : sampleServiceMapFromFinder.keySet()) {
            String result1 = sampleServiceMapFromFinder.get(beanName).service();
            System.out.println(result1);
        }

        return "hello to ark dynamic deploy";
    }
}
