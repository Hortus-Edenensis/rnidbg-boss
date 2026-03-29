package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LayoutSuperExposeNumAllBindingImpl extends LayoutSuperExposeNumAllBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts u = null;

    @Nullable
    public static final SparseIntArray v;

    @NonNull
    public final LinearLayout s;
    public long t;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.super_num_buy_layout, 3);
        sparseIntArray.put(R.id.count_title, 4);
        sparseIntArray.put(R.id.super_num_title, 5);
        sparseIntArray.put(R.id.super_num_text_dialog, 6);
        sparseIntArray.put(R.id.super_sub_title, 7);
        sparseIntArray.put(R.id.super_num_show_dialog, 8);
        sparseIntArray.put(R.id.super_expose_num_mind, 9);
        sparseIntArray.put(R.id.super_expose_num_distance, 10);
        sparseIntArray.put(R.id.mind_distance_recycler_no_layout, 11);
        sparseIntArray.put(R.id.mind_distance_recycler_all_layout, 12);
        sparseIntArray.put(R.id.mind_all_view, 13);
        sparseIntArray.put(R.id.mind_super_content_failed, 14);
        sparseIntArray.put(R.id.mind_super_expose_num_content, 15);
        sparseIntArray.put(R.id.distance_all_view, 16);
        sparseIntArray.put(R.id.distance_super_content_failed, 17);
        sparseIntArray.put(R.id.distance_super_expose_num_content, 18);
    }

    public LayoutSuperExposeNumAllBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, u, v));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.t = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.t != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.t = 1L;
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

    public LayoutSuperExposeNumAllBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (TextView) objArr[4], (FrameLayout) objArr[16], (LinearLayout) objArr[17], (RecyclerView) objArr[18], (FrameLayout) objArr[13], (FrameLayout) objArr[12], (LinearLayout) objArr[11], (LinearLayout) objArr[14], (RecyclerView) objArr[15], (TextView) objArr[10], (TextView) objArr[9], (FrameLayout) objArr[3], (ImageView) objArr[8], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[7], (View) objArr[2]);
        this.t = -1L;
        this.f13904a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.s = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
