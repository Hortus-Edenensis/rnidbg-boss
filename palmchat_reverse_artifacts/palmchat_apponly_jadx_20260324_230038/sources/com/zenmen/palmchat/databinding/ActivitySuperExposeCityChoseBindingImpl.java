package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ActivitySuperExposeCityChoseBindingImpl extends ActivitySuperExposeCityChoseBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts m = null;

    @Nullable
    public static final SparseIntArray n;
    public long l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.top_view, 1);
        sparseIntArray.put(R.id.toolbar_view, 2);
        sparseIntArray.put(R.id.back, 3);
        sparseIntArray.put(R.id.super_title, 4);
        sparseIntArray.put(R.id.head_title, 5);
        sparseIntArray.put(R.id.head_subtitle, 6);
        sparseIntArray.put(R.id.m_recycleview, 7);
        sparseIntArray.put(R.id.bottom_layout, 8);
        sparseIntArray.put(R.id.tip_text, 9);
        sparseIntArray.put(R.id.btn_next, 10);
    }

    public ActivitySuperExposeCityChoseBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, m, n));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.l = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 1L;
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

    public ActivitySuperExposeCityChoseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (LinearLayout) objArr[8], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[5], (RecyclerView) objArr[7], (RelativeLayout) objArr[0], (TextView) objArr[4], (TextView) objArr[9], (RelativeLayout) objArr[2], (FrameLayout) objArr[1]);
        this.l = -1L;
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
