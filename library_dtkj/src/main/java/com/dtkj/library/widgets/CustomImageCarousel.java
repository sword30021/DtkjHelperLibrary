package com.dtkj.library.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.dtkj.library.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sword on 16/10/12.
 */

public class CustomImageCarousel extends RelativeLayout {

    private ViewPager mViewPager;
    private LinearLayout mLayoutIndicator;
    private List<View> viewList = new ArrayList<View>();
    private Handler refreshHandler;
    private OnItemChangeListener onItemChangeListener;
    private OnItemClickListener onItemClickListener;
    private int totelCount = 0;
    private int currentIndex = 0;
    //    public static final int INDICATOR_STYLE_AD = 0;
//    public static final int INDICATOR_STYLE_GUIDE = 1;
//    private int defaultStyle = INDICATOR_STYLE_AD;
    private long refreshTime = 0l;

    public interface OnItemChangeListener {
        void onPosition(int position, int totalCount);
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, int position);
    }

    public CustomImageCarousel(Context context) {
        super(context);
        initWidgets(context);
    }

    public CustomImageCarousel(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidgets(context);
    }

    private void initWidgets(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_image_carousel, this);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mLayoutIndicator = (LinearLayout) findViewById(R.id.layout_indicator);

        mViewPager.setOnPageChangeListener(new PageChangeListener());
        refreshHandler = new ScrollIndicateHandler(CustomImageCarousel.this);
    }

    /**
     * add single View
     *
     * @param view
     */
    public void addViewItem(View view) {
        final int position = viewList.size();
        view.setOnClickListener(new ItemClickListener(position));
        this.viewList.add(view);
    }

    /**
     * set ItemClickListener
     */
    private class ItemClickListener implements OnClickListener {
        private int position = 0;

        public ItemClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.OnItemClick(view, position);
            }
        }
    }

    /**
     * set Drawable array
     *
     * @param resArray Drawable array
     */
    public void fillDataByDrawable(final Integer resArray[]) {
        if (resArray == null)
            throw new NullPointerException();
        this.fillDataByDrawable(Arrays.asList(resArray));
    }

    /**
     * set Drawable list
     *
     * @param resList Drawable list
     */
    public void fillDataByDrawable(final List<Integer> resList) {
        if (resList == null)
            throw new NullPointerException();
        final int len = resList.size();
        if (len > 0) {
            for (int index = 0; index < len; index++) {
                final ImageView pageItem = new ImageView(getContext());
                pageItem.setImageResource(resList.get(index));
                addViewItem(pageItem);
            }
        }
    }

    public void fillDataByUrl(Context context, final List<String> resList, int defRes) {
        if (resList == null)
            throw new NullPointerException();

        final int len = resList.size();
        if (len > 0) {
            for (int index = 0; index < len; index++) {
                final ImageView pageItem = new ImageView(getContext());
                Glide.with(context).load(resList.get(index)).placeholder(defRes).crossFade().into(pageItem);
                addViewItem(pageItem);
            }
        }
    }

    /**
     * set show item current
     *
     * @param index postion
     */
    public void setCurrentItem(int index) {
        this.currentIndex = index;
        mViewPager.setCurrentItem(currentIndex);
    }

    /**
     * set anchor style, default INDICATOR_ARROW_ROUND_STYLE
     *
     * @param style INDICATOR_USERGUIDE_STYLE or INDICATOR_ARROW_ROUND_STYLE
     */
    public void setIndicateStyle(int style) {
//        this.defaultStyle = style;
    }

    /**
     * add OnItemChangeListener
     *
     * @param onItemChangeListener callback
     */
    public void setOnItemChangeListener(OnItemChangeListener onItemChangeListener) {
        if (onItemChangeListener == null) {
            throw new NullPointerException();
        }
        this.onItemChangeListener = onItemChangeListener;
    }

    /**
     * add setOnItemClickListener
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * show
     */
    public void show() {
        this.totelCount = viewList.size();
        final LayoutParams params = (LayoutParams) mLayoutIndicator.getLayoutParams();
        mLayoutIndicator.setLayoutParams(params);
        for (int index = 0; index < this.totelCount; index++) {
            final View indicator = new ImageView(getContext());
            mLayoutIndicator.addView(indicator, index);
        }
        refreshHandler.sendEmptyMessage(currentIndex);
        mViewPager.setAdapter(new MyPagerAdapter(this.viewList));
        mViewPager.setCurrentItem(currentIndex, true);
    }

    /**
     * deal page change
     */
    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageSelected(int index) {
            currentIndex = index;
            refreshHandler.sendEmptyMessage(index);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    }

    /**
     * refresh indicate anchor
     */
    protected void refreshIndicateView() {
        this.refreshTime = System.currentTimeMillis();

        for (int index = 0; index < totelCount; index++) {
            final ImageView imageView = (ImageView) mLayoutIndicator.getChildAt(index);
            if (this.currentIndex == index) {
                imageView.setBackgroundResource(R.drawable.ic_dot_focus);
            } else {
                imageView.setBackgroundResource(R.drawable.ic_dot_normal);
            }
        }

        if (this.onItemChangeListener != null) {
            try {
                this.onItemChangeListener.onPosition(this.currentIndex, this.totelCount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class ScrollIndicateHandler extends Handler {
        private final WeakReference<CustomImageCarousel> scrollIndicateViewRef;

        public ScrollIndicateHandler(CustomImageCarousel scrollIndicateView) {
            this.scrollIndicateViewRef = new WeakReference<CustomImageCarousel>(scrollIndicateView);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            CustomImageCarousel scrollIndicateView = scrollIndicateViewRef.get();
            if (scrollIndicateView != null) {
                scrollIndicateView.refreshIndicateView();
            }
        }
    }

    private class MyPagerAdapter extends PagerAdapter {
        private List<View> pageViews = new ArrayList<View>();

        public MyPagerAdapter(List<View> pageViews) {
            this.pageViews = pageViews;
        }

        @Override
        public int getCount() {
            return pageViews.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(pageViews.get(arg1));
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(pageViews.get(arg1));
            return pageViews.get(arg1);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }
    }

    public ViewPager getViewPager() {
        return mViewPager;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getTotalCount() {
        return this.totelCount;
    }

    public long getRefreshTime() {
        return this.refreshTime;
    }
}
