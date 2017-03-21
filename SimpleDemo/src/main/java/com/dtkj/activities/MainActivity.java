package com.dtkj.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dtkj.R;
import com.dtkj.library.utils.DTBuilderUtils;
import com.dtkj.library.widgets.CountDownView;
import com.dtkj.library.widgets.CustomImageCarousel;
import com.dtkj.library.widgets.CustomTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.title_bar) CustomTitleBar mTitleBar;
    @BindView(R.id.cic_image) CustomImageCarousel mCicImage;
    @BindView(R.id.tv_send_message) TextView mTvSendMessage;

    private CountDownView mCountDownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mTitleBar);
        mTitleBar.setNavigationIcon(R.mipmap.ic_launcher);
        mTitleBar.setTitle(R.string.text_dtkj_register);

//        testCustomImageCarousel();
        textCountDownView();
    }

    @OnClick({R.id.tv_send_message})
    void clickAction(View view) {
        switch (view.getId()) {
            case R.id.tv_send_message:
                mCountDownView.start();
                break;
            default:
                break;
        }
    }

    private void testCustomImageCarousel() {
        mCicImage.setVisibility(View.VISIBLE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
            .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mCicImage.setLayoutParams(layoutParams);
        Integer[] resId = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        mCicImage.fillDataByDrawable(resId);
        mCicImage.show();
    }

    private void textCountDownView() {
        mTvSendMessage.setVisibility(View.VISIBLE);
        mCountDownView = new CountDownView(60 * 1000, 1000, mTvSendMessage);
        mCountDownView.initBuilder(DTBuilderUtils.initShortMessage());
    }
}
