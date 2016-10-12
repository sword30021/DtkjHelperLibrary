package com.dtkj.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dtkj.R;
import com.dtkj.library.widgets.CustomImageCarousel;
import com.dtkj.library.widgets.CustomTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.title_bar) CustomTitleBar mTitleBar;
    @BindView(R.id.cic_image) CustomImageCarousel mCicImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mTitleBar);
        mTitleBar.setNavigationIcon(R.mipmap.ic_launcher);
        mTitleBar.setTitle(R.string.text_dtkj_register);
        testCustomImageCarousel();
    }

    private void testCustomImageCarousel() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
            .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mCicImage.setLayoutParams(layoutParams);
        Integer[] resId = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        mCicImage.fillDataByDrawable(resId);
        mCicImage.show();
    }
}
