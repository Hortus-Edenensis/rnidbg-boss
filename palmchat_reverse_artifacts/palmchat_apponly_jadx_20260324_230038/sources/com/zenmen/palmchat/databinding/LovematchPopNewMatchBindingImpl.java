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
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LovematchPopNewMatchBindingImpl extends LovematchPopNewMatchBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts k = null;

    @Nullable
    public static final SparseIntArray l;

    @NonNull
    public final LinearLayout i;
    public long j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.close, 1);
        sparseIntArray.put(R.id.avatar_wrapper, 2);
        sparseIntArray.put(R.id.avatar, 3);
        sparseIntArray.put(R.id.sex, 4);
        sparseIntArray.put(R.id.info, 5);
        sparseIntArray.put(R.id.intention, 6);
        sparseIntArray.put(R.id.occupation, 7);
        sparseIntArray.put(R.id.enter, 8);
    }

    public LovematchPopNewMatchBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    public LovematchPopNewMatchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EffectiveShapeView) objArr[3], (FrameLayout) objArr[2], (ImageView) objArr[1], (TextView) objArr[8], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (ImageView) objArr[4]);
        this.j = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.i = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
