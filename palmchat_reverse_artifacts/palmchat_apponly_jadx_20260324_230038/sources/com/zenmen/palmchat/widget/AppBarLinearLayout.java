package com.zenmen.palmchat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AppBarLinearLayout extends LinearLayout {
    private int currentOffset;
    private boolean needSetStopBg;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private View stopChildView;
    private View stopChildViewBg;
    private b stopViewTopChangeListener;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AppBarLayout.OnOffsetChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15963a = -100000086;

        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (AppBarLinearLayout.this.stopChildView == null || i == this.f15963a) {
                return;
            }
            LogUtil.i("AppBarLinearLayout", "onOffsetChanged verticalOffset=" + i + " getTop()=" + AppBarLinearLayout.this.getTop() + "stopChildView.getTop()=" + AppBarLinearLayout.this.stopChildView.getTop());
            AppBarLinearLayout.this.currentOffset = i;
            int top = (-AppBarLinearLayout.this.currentOffset) - AppBarLinearLayout.this.getTop();
            int iClamp = MathUtils.clamp(top, 0, top);
            ViewCompat.offsetTopAndBottom(AppBarLinearLayout.this.stopChildView, iClamp - AppBarLinearLayout.this.stopChildView.getTop());
            LogUtil.i("AppBarLinearLayout", "onOffsetChanged verticalOffset=" + i + " getTop()=" + AppBarLinearLayout.this.getTop() + "stopChildView.getTop()=" + AppBarLinearLayout.this.stopChildView.getTop() + " offset=" + (iClamp - AppBarLinearLayout.this.stopChildView.getTop()));
            AppBarLinearLayout.e(AppBarLinearLayout.this);
            if (AppBarLinearLayout.this.stopChildView.getTop() > 0) {
                if (AppBarLinearLayout.this.stopChildViewBg == null || !AppBarLinearLayout.this.needSetStopBg) {
                    return;
                }
                AppBarLinearLayout.this.stopChildViewBg.setVisibility(0);
                return;
            }
            if (AppBarLinearLayout.this.stopChildViewBg == null || AppBarLinearLayout.this.stopChildViewBg.getVisibility() == 8) {
                return;
            }
            AppBarLinearLayout.this.stopChildViewBg.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    public AppBarLinearLayout(Context context) {
        super(context);
        this.stopChildView = null;
        this.stopChildViewBg = null;
        this.needSetStopBg = false;
        initView();
    }

    public static /* bridge */ /* synthetic */ b e(AppBarLinearLayout appBarLinearLayout) {
        appBarLinearLayout.getClass();
        return null;
    }

    private void initView() {
        setChildrenDrawingOrderEnabled(true);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        return (i - i2) - 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.onOffsetChangedListener == null) {
                this.onOffsetChangedListener = new a();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.onOffsetChangedListener);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.onOffsetChangedListener;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.stopChildView == null) {
            this.stopChildView = findViewById(R.id.find_tab_header);
        }
        if (this.stopChildViewBg == null && this.needSetStopBg) {
            View viewFindViewById = this.stopChildView.findViewById(R.id.topBgView);
            this.stopChildViewBg = viewFindViewById;
            if (viewFindViewById != null) {
                ((FrameLayout.LayoutParams) viewFindViewById.getLayoutParams()).setMargins(0, -a46.n(getContext()), 0, 0);
            }
        }
    }

    public void setNeedSetStopBg(boolean z) {
        this.needSetStopBg = z;
    }

    public AppBarLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.stopChildView = null;
        this.stopChildViewBg = null;
        this.needSetStopBg = false;
        initView();
    }

    public AppBarLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.stopChildView = null;
        this.stopChildViewBg = null;
        this.needSetStopBg = false;
        initView();
    }

    public AppBarLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.stopChildView = null;
        this.stopChildViewBg = null;
        this.needSetStopBg = false;
        initView();
    }

    public void setStopViewTopChangeListener(b bVar) {
    }
}
