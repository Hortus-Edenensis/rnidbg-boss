package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ActivitySuperExposeHomeBindingImpl extends ActivitySuperExposeHomeBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts k = null;

    @Nullable
    public static final SparseIntArray l;
    public long j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.top_image_bg2, 1);
        sparseIntArray.put(R.id.top_image_bg1, 2);
        sparseIntArray.put(R.id.m_pager, 3);
        sparseIntArray.put(R.id.top_view, 4);
        sparseIntArray.put(R.id.toolbar_view, 5);
        sparseIntArray.put(R.id.back, 6);
        sparseIntArray.put(R.id.tablayout2, 7);
        sparseIntArray.put(R.id.super_title, 8);
    }

    public ActivitySuperExposeHomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, k, l));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.j = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public ActivitySuperExposeHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[6], (ViewPager) objArr[3], (RelativeLayout) objArr[0], (TextView) objArr[8], (TabLayout) objArr[7], (RelativeLayout) objArr[5], (ImageView) objArr[2], (ImageView) objArr[1], (FrameLayout) objArr[4]);
        this.j = -1L;
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
