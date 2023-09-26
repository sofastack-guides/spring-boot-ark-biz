package com.alipay.sofa.springbootarkbiz;

import com.alipay.sofa.springbootarkbiz.model.Param;
import com.alipay.sofa.springbootarkbiz.model.Result;

public interface Provider {

    Result provide(Param param);
}
