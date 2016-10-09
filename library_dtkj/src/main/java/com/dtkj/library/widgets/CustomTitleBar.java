package com.dtkj.library.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
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
 */

public class CustomTitleBar extends Toolbar {
    private ImageView titleImageLeft;
    private TextView titleTextLeft;
    private TextView titleTextCenter;
    private ImageView titleImageRight;
    private TextView titleTextRight;

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context);
        initWidgets(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);

        Drawable drawableLeft = typedArray.getDrawable(R.styleable.CustomTitleBar_title_image_left);

        String textLeft = typedArray.getString(R.styleable.CustomTitleBar_title_text_left);
        int textLeftColor = typedArray.getColor(R.styleable.CustomTitleBar_title_text_left_color, Color.WHITE);

        String textCenter = typedArray.getString(R.styleable.CustomTitleBar_title_text_center);
        int textCenterColor = typedArray.getColor(R.styleable.CustomTitleBar_title_text_center_color, Color.WHITE);

        Drawable drawableRight = typedArray.getDrawable(R.styleable.CustomTitleBar_title_image_right);

        String textRight = typedArray.getString(R.styleable.CustomTitleBar_title_text_right);
        int textRightColor = typedArray.getColor(R.styleable.CustomTitleBar_title_text_right_color, Color.WHITE);

        titleImageLeft.setImageDrawable(drawableLeft);
        titleImageLeft.setVisibility(null == drawableLeft ? GONE : VISIBLE);

        titleTextLeft.setText(textLeft);
        titleTextLeft.setTextColor(textLeftColor);
        titleTextLeft.setVisibility(TextUtils.isEmpty(textLeft) ? GONE : VISIBLE);

        titleTextCenter.setText(textCenter);
        titleTextCenter.setTextColor(textCenterColor);
        titleTextCenter.setVisibility(TextUtils.isEmpty(textCenter) ? GONE : VISIBLE);

        titleImageRight.setImageDrawable(drawableRight);
        titleImageRight.setVisibility(null == titleImageRight ? GONE : VISIBLE);

        titleTextRight.setText(textRight);
        titleTextRight.setTextColor(textRightColor);
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
}
