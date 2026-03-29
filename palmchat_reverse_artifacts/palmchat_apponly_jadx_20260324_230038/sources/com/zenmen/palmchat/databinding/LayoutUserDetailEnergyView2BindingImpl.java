package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LightingAnimationView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LayoutUserDetailEnergyView2BindingImpl extends LayoutUserDetailEnergyView2Binding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts i = null;

    @Nullable
    public static final SparseIntArray j;
    public long h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.progress_container, 1);
        sparseIntArray.put(R.id.energy_progress, 2);
        sparseIntArray.put(R.id.energy_percentage, 3);
        sparseIntArray.put(R.id.anim_view, 4);
        sparseIntArray.put(R.id.exceed_layout, 5);
        sparseIntArray.put(R.id.exceed_text, 6);
    }

    public LayoutUserDetailEnergyView2BindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, i, j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        return true;
    }

    public LayoutUserDetailEnergyView2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LightingAnimationView) objArr[4], (TextView) objArr[3], (ProgressBar) objArr[2], (LinearLayout) objArr[5], (TextView) objArr[6], (ConstraintLayout) objArr[1], (LinearLayout) objArr[0]);
        this.h = -1L;
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
