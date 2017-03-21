package com.dtkj.library.builders;

/**
 * Created by sword on 17/3/21.
 * Email: 1619153872@qq.com
 * Description: the builder for CountDownView
 *
 * @see com.dtkj.library.widgets.CountDownView
 */

public class CountDownBuilder {
    public String TEXT_ON_TICK = "";
    public String TEXT_ON_FINISH = "";
    public boolean ENABLED_ON_TICK = false;
    public boolean ENABLED_ON_FINISH = false;

    public CountDownBuilder textOnTick(String text) {
        TEXT_ON_TICK = text;
        return this;
    }

    public CountDownBuilder textOnFinish(String text) {
        TEXT_ON_FINISH = text;
        return this;
    }

    public CountDownBuilder enabledOnTick(boolean enable) {
        ENABLED_ON_TICK = enable;
        return this;
    }

    public CountDownBuilder enabledOnFinish(boolean enable) {
        ENABLED_ON_FINISH = enable;
        return this;
    }
}
