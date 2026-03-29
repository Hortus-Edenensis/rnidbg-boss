package com.zenmen.square.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PageIndicatorView extends LxRelativeLayout {
    public View.OnClickListener indicatorOnclickListener;
    private int indicatorTotalWidth;
    private c mConfig;
    private LinearLayout mIndicatorContainer;
    private ViewPager.SimpleOnPageChangeListener mOnScrollListener;
    private ViewPager mPager;
    private ImageView mSelectedView;
    private float pageWidth;
    private Point screenSize;
    private float translationOffset;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ViewPager.SimpleOnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
            PageIndicatorView.this.onPageScrolled(i, f, i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PageIndicatorView.this.mPager.setCurrentItem(((Integer) view.getTag()).intValue());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {
        public int c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16545a = 1291845631;
        public int b = -1;
        public int d = -1;
        public int e = a46.b(com.zenmen.palmchat.c.b(), 4.0f);
        public int f = a46.b(com.zenmen.palmchat.c.b(), 3.0f);
        public int g = a46.b(com.zenmen.palmchat.c.b(), 17.0f);

        public int g() {
            return this.c;
        }

        public int h() {
            return this.d;
        }

        public c i(int i) {
            this.c = i;
            return this;
        }

        public c j(int i) {
            this.e = i;
            return this;
        }
    }

    public PageIndicatorView(Context context) {
        super(context);
        this.pageWidth = 0.0f;
        this.translationOffset = 0.0f;
        this.mOnScrollListener = new a();
        this.indicatorOnclickListener = new b();
    }

    private void initWithConfig() {
        this.screenSize = a46.m(getContext());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.mConfig.h();
        setLayoutParams(layoutParams);
        this.mIndicatorContainer.removeAllViews();
        if (this.mConfig.g() <= 1) {
            return;
        }
        int iB = a46.b(getContext(), 2.0f);
        int i = (this.screenSize.x - ((this.mConfig.c + 1) * this.mConfig.f)) / this.mConfig.c;
        this.indicatorTotalWidth = (this.screenSize.x - (this.mConfig.f * 2)) - i;
        int iB2 = (a46.b(getContext(), 20.0f) - this.mConfig.e) / 2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f = iB;
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(this.mConfig.f16545a);
        for (int i2 = 0; i2 < this.mConfig.c; i2++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setPadding(0, iB2, 0, iB2);
            imageView.setImageDrawable(gradientDrawable);
            imageView.setTag(Integer.valueOf(i2));
            imageView.setOnClickListener(this.indicatorOnclickListener);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -1);
            layoutParams2.leftMargin = this.mConfig.f;
            this.mIndicatorContainer.addView(imageView, layoutParams2);
        }
        ImageView imageView2 = this.mSelectedView;
        if (imageView2 != null) {
            removeView(imageView2);
        }
        this.mSelectedView = new ImageView(getContext());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f);
        gradientDrawable2.setColor(this.mConfig.b);
        this.mSelectedView.setImageDrawable(gradientDrawable2);
        this.mSelectedView.setPadding(0, iB2, 0, iB2);
        addView(this.mSelectedView, new RelativeLayout.LayoutParams(i, -1));
        this.mSelectedView.setTranslationX(this.mConfig.f);
        this.mPager.addOnPageChangeListener(this.mOnScrollListener);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.mIndicatorContainer = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.mIndicatorContainer, -1, -1);
    }

    public void initConfig(c cVar, ViewPager viewPager) {
        this.mPager = viewPager;
        if (cVar == null) {
            cVar = new c();
        }
        this.mConfig = cVar;
        initWithConfig();
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.translationOffset <= 0.0f) {
            float f2 = this.screenSize.x + this.mConfig.g;
            this.pageWidth = f2;
            this.translationOffset = this.indicatorTotalWidth / (f2 * (this.mConfig.c - 1));
        }
        float f3 = this.translationOffset;
        if (f3 > 0.0f) {
            this.mSelectedView.setTranslationX(((i2 + (this.pageWidth * i)) * f3) + this.mConfig.f);
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pageWidth = 0.0f;
        this.translationOffset = 0.0f;
        this.mOnScrollListener = new a();
        this.indicatorOnclickListener = new b();
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pageWidth = 0.0f;
        this.translationOffset = 0.0f;
        this.mOnScrollListener = new a();
        this.indicatorOnclickListener = new b();
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.pageWidth = 0.0f;
        this.translationOffset = 0.0f;
        this.mOnScrollListener = new a();
        this.indicatorOnclickListener = new b();
    }
}
