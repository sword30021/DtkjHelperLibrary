package com.dtkj.library.widgets;

import android.os.CountDownTimer;
import android.widget.TextView;

import com.dtkj.library.builders.CountDownBuilder;

/**
 * Created by sword on 17/03/21.
 * Email: 1619153872@qq.com
 * Description: custom count down timer
 *
 * @see com.dtkj.library.builders.CountDownBuilder
 */
public class CountDownView extends CountDownTimer {
    private TextView tvTime;
    private CountDownBuilder mCountDownBuilder;

    public CountDownView(long millisInFuture, long countDownInterval, TextView tvTime) {
        super(millisInFuture, countDownInterval);
        this.tvTime = tvTime;
    }

    public void initBuilder(CountDownBuilder countDownBuilder) {
        mCountDownBuilder = countDownBuilder;
    }

    @Override
    public void onTick(long l) {
        tvTime.setEnabled(mCountDownBuilder.ENABLED_ON_TICK);
        tvTime.setText(l / 1000 + mCountDownBuilder.TEXT_ON_TICK);
    }

    @Override
    public void onFinish() {
        tvTime.setText("获取验证码");
        tvTime.setEnabled(mCountDownBuilder.ENABLED_ON_FINISH);
    }
}
