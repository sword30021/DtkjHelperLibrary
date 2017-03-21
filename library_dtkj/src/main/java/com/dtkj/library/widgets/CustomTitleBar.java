package com.dtkj.library.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dtkj.library.R;

/**
 * Created by sword on 16/10/8.
 * Email: 1619153872@qq.com
 * Description: custom title bar
 */

public class CustomTitleBar extends Toolbar {
    private ImageView titleImageLeft;
    private TextView titleTextLeft;
    private TextView titleTextCenter;
    private ImageView titleImageRight;
    private TextView titleTextRight;
    private int defColor = R.color.color_title_text;

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        initWidgets(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);

        defColor = typedArray.getColor(R.styleable.CustomTitleBar_text_default_color,
            getResources().getColor(defColor));

        Drawable drawableLeft = typedArray.getDrawable(R.styleable.CustomTitleBar_title_image_left);

        String textLeft = typedArray.getString(R.styleable.CustomTitleBar_title_text_left);
        int textLeftColor = typedArray.getColor(R.styleable.CustomTitleBar_title_text_left_color, defColor);
        float textLeftSize = typedArray.getInt(R.styleable.CustomTitleBar_title_text_left_size, 16);

        String textCenter = typedArray.getString(R.styleable.CustomTitleBar_title_text_center);
        int textCenterColor = typedArray.getColor(R.styleable.CustomTitleBar_title_text_center_color, defColor);
        float textCenterSize = typedArray.getInt(R.styleable.CustomTitleBar_title_text_center_size, 18);

        Drawable drawableRight = typedArray.getDrawable(R.styleable.CustomTitleBar_title_image_right);

        String textRight = typedArray.getString(R.styleable.CustomTitleBar_title_text_right);
        int textRightColor = typedArray.getColor(R.styleable.CustomTitleBar_title_text_right_color, defColor);
        float textRightSize = typedArray.getInt(R.styleable.CustomTitleBar_title_text_right_size, 16);

        titleImageLeft.setImageDrawable(drawableLeft);
        titleImageLeft.setVisibility(null == drawableLeft ? GONE : VISIBLE);

        titleTextLeft.setText(textLeft);
        titleTextLeft.setTextColor(textLeftColor);
        titleTextLeft.setTextSize(textLeftSize);
        titleTextLeft.setVisibility(TextUtils.isEmpty(textLeft) ? GONE : VISIBLE);

        titleTextCenter.setText(textCenter);
        titleTextCenter.setTextColor(textCenterColor);
        titleTextCenter.setTextSize(textCenterSize);
        titleTextCenter.setVisibility(TextUtils.isEmpty(textCenter) ? GONE : VISIBLE);

        titleImageRight.setImageDrawable(drawableRight);
        titleImageRight.setVisibility(null == titleImageRight ? GONE : VISIBLE);

        titleTextRight.setText(textRight);
        titleTextRight.setTextColor(textRightColor);
        titleTextRight.setTextSize(textRightSize);
        titleTextRight.setVisibility(TextUtils.isEmpty(textRight) ? GONE : VISIBLE);

        typedArray.recycle();
    }

    private void initWidgets(Context context) {
        View.inflate(context, R.layout.custom_title_bar, this);
        titleImageLeft = (ImageView) findViewById(R.id.title_image_left);
        titleTextLeft = (TextView) findViewById(R.id.title_text_left);
        titleTextCenter = (TextView) findViewById(R.id.title_text_center);
        titleImageRight = (ImageView) findViewById(R.id.title_image_right);
        titleTextRight = (TextView) findViewById(R.id.title_text_right);
    }

    public ImageView getTitleImageLeft() {
        return titleImageLeft;
    }

    public TextView getTitleTextLeft() {
        return titleTextLeft;
    }

    public TextView getTitleTextCenter() {
        return titleTextCenter;
    }

    public ImageView getTitleImageRight() {
        return titleImageRight;
    }

    public TextView getTitleTextRight() {
        return titleTextRight;
    }

    public void setTitleImageLeft(int leftImageRes) {
        titleImageLeft.setVisibility(VISIBLE);
        titleImageLeft.setImageResource(leftImageRes);
    }

    public void setTitleTextLeft(int leftTextRes) {
        titleTextLeft.setVisibility(VISIBLE);
        titleTextLeft.setText(leftTextRes);
    }

    public void setTitleTextLeft(CharSequence leftTextRes) {
        titleTextLeft.setVisibility(VISIBLE);
        titleTextLeft.setText(leftTextRes);
    }

    public void setTitleTextCenter(int centerTextRes) {
        titleTextCenter.setVisibility(VISIBLE);
        titleTextCenter.setText(centerTextRes);
    }

    public void setTitleTextCenter(CharSequence centerTextRes) {
        titleTextCenter.setVisibility(VISIBLE);
        titleTextCenter.setText(centerTextRes);
    }

    public void setTitleImageRight(int rightImageRes) {
        titleImageRight.setVisibility(VISIBLE);
        titleImageLeft.setImageResource(rightImageRes);
    }

    public void setTitleTextRight(int rightTextRes) {
        titleTextRight.setVisibility(VISIBLE);
        titleTextRight.setText(rightTextRes);
    }

    public void setTitleTextRight(CharSequence rightTextRes) {
        titleTextRight.setVisibility(VISIBLE);
        titleTextRight.setText(rightTextRes);
    }

    public void onBackListener() {
        ((Activity) getContext()).finish();
    }

    public void showOrHideLeftImage() {
        if (VISIBLE == titleImageLeft.getVisibility()) titleImageLeft.setVisibility(GONE);
        else titleImageLeft.setVisibility(VISIBLE);
    }

    public void showOrHideLeftText() {
        if (VISIBLE == titleTextLeft.getVisibility()) titleTextLeft.setVisibility(GONE);
        else titleTextLeft.setVisibility(VISIBLE);
    }

    public void showOrHideCenterText() {
        if (VISIBLE == titleTextCenter.getVisibility()) titleTextCenter.setVisibility(GONE);
        else titleTextCenter.setVisibility(VISIBLE);
    }

    public void showOrHideRightImage() {
        if (VISIBLE == titleImageRight.getVisibility()) titleImageRight.setVisibility(GONE);
        else titleImageRight.setVisibility(VISIBLE);
    }

    public void showOrHideRightText() {
        if (VISIBLE == titleTextRight.getVisibility()) titleTextRight.setVisibility(GONE);
        else titleTextRight.setVisibility(VISIBLE);
    }

}
