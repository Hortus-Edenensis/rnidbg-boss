package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.ui.adapter.TabAdapter;
import defpackage.ep2;
import defpackage.fm2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TabLayoutScroll extends FrameLayout implements ep2 {
    protected HorizontalRecyclerView horizontalRecyclerView;
    protected fm2 indicatorView;
    protected int space_horizontal;
    protected int space_vertical;

    public TabLayoutScroll(@NonNull Context context) {
        this(context, null);
    }

    private void addTab() {
        addView(this.horizontalRecyclerView, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public int dpAdapt(Context context, float f) {
        return dpAdapt(context, f, 360.0f);
    }

    public HorizontalRecyclerView getHorizontalRecyclerView() {
        return this.horizontalRecyclerView;
    }

    public fm2 getIndicatorView() {
        return this.indicatorView;
    }

    public int getSpace_horizontal() {
        return this.space_horizontal;
    }

    public int getSpace_vertical() {
        return this.space_vertical;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 1) {
            throw new RuntimeException("Exception:You must add only one IndicatorView type of IIndicatorView in " + getClass().getName());
        }
        try {
            this.indicatorView = (fm2) getChildAt(0);
            addTab();
        } catch (Exception unused) {
            throw new RuntimeException("Exception:You must add only one IndicatorView type of IIndicatorView in " + getClass().getName());
        }
    }

    public TabLayoutScroll setAdapter(TabAdapter tabAdapter) {
        if (this.horizontalRecyclerView.getAdapter() == null) {
            this.horizontalRecyclerView.addItemDecoration(new LinearItemDecoration(tabAdapter).b(this.space_horizontal).c(this.space_vertical));
        }
        this.horizontalRecyclerView.setAdapter(tabAdapter);
        return this;
    }

    public <T extends ep2> T setIndicatorView(fm2 fm2Var) {
        fm2 fm2Var2 = this.indicatorView;
        if (fm2Var2 != null) {
            removeView(fm2Var2.getView());
        }
        removeView(fm2Var.getView());
        this.indicatorView = fm2Var;
        addView(fm2Var.getView());
        return this;
    }

    public TabLayoutScroll setSpace_horizontal(int i) {
        this.space_horizontal = i;
        return this;
    }

    public TabLayoutScroll setSpace_vertical(int i) {
        this.space_vertical = i;
        return this;
    }

    public TabLayoutScroll(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.horizontalRecyclerView = new HorizontalRecyclerView(context);
        if (attributeSet == null) {
            setSpace_horizontal(dpAdapt(context, 20.0f));
            setSpace_vertical(dpAdapt(context, 8.0f));
            addTab();
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabLayoutScroll);
            setSpace_horizontal(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, dpAdapt(context, 20.0f)));
            setSpace_vertical(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, dpAdapt(context, 8.0f)));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public int dpAdapt(Context context, float f, float f2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        float f3 = displayMetrics.density;
        float f4 = i / f3;
        float f5 = i2 / f3;
        if (f5 <= f4) {
            f4 = f5;
        }
        return (int) ((((f * f4) / f2) * f3) + 0.5f);
    }

    public <T extends View> T getView() {
        return this;
    }
}
