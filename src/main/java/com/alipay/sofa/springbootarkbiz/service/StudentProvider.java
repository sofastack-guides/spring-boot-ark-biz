package com.alipay.sofa.springbootarkbiz.service;

import com.alipay.sofa.springbootarkbiz.Provider;
import com.alipay.sofa.springbootarkbiz.model.Param;
import com.alipay.sofa.springbootarkbiz.model.Result;
import com.alipay.sofa.springbootarkbiz.model.Student;
import com.alipay.sofa.springbootarkbiz.model.Teacher;
import org.springframework.stereotype.Service;

/**
 * @author: yuanyuan
 * @date: 2023/9/25 3:27 下午
 */
@Service
public class StudentProvider implements Provider {

    @Override
    public Result provide(Param param) {
        Result result = new Result();
        result.setSuccess(true);
        result.setPeople(new Student());
        return result;
    }
}
