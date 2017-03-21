package com.dtkj.library.utils;

import com.dtkj.library.builders.CountDownBuilder;

/**
 * Created by sword on 17/03/21.
 * Email: 1619153872@qq.com
 * Description: the utils for builder
 */

public class DTBuilderUtils {

    public static CountDownBuilder initShortMessage() {
        CountDownBuilder countDownBuilder = new CountDownBuilder();
        countDownBuilder
            .textOnTick("秒")
            .textOnFinish("获取验证码")
            .enabledOnTick(false)
            .enabledOnFinish(true);
        return countDownBuilder;
    }

}
