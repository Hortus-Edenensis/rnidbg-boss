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
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LightingAnimationView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FragmentSuperExposeMyselfBindingImpl extends FragmentSuperExposeMyselfBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts l = null;

    @Nullable
    public static final SparseIntArray m;

    @NonNull
    public final RelativeLayout j;
    public long k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.top_view, 1);
        sparseIntArray.put(R.id.top_image_layout, 2);
        sparseIntArray.put(R.id.intro_layout, 3);
        sparseIntArray.put(R.id.order_history, 4);
        sparseIntArray.put(R.id.super_expose_intro_layout, 5);
        sparseIntArray.put(R.id.bottom_layout, 6);
        sparseIntArray.put(R.id.des_num, 7);
        sparseIntArray.put(R.id.to_super, 8);
        sparseIntArray.put(R.id.anim_view1, 9);
    }

    public FragmentSuperExposeMyselfBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, l, m));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.k = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 1L;
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

    public FragmentSuperExposeMyselfBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LightingAnimationView) objArr[9], (RelativeLayout) objArr[6], (TextView) objArr[7], (LinearLayout) objArr[3], (RelativeLayout) objArr[4], (RelativeLayout) objArr[5], (TextView) objArr[8], (ImageView) objArr[2], (FrameLayout) objArr[1]);
        this.k = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.j = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
