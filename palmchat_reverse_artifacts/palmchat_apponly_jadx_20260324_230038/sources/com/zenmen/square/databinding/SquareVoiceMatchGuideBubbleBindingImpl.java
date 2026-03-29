package com.zenmen.square.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.lxviewswitcher.CustomLoopingViewSwitcher;
import com.zenmen.square.R$id;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareVoiceMatchGuideBubbleBindingImpl extends SquareVoiceMatchGuideBubbleBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts i = null;

    @Nullable
    public static final SparseIntArray j;
    public long h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R$id.content_layout, 1);
        sparseIntArray.put(R$id.head_layout, 2);
        sparseIntArray.put(R$id.des_layout, 3);
        sparseIntArray.put(R$id.title, 4);
        sparseIntArray.put(R$id.sub_title, 5);
        sparseIntArray.put(R$id.reddot, 6);
    }

    public SquareVoiceMatchGuideBubbleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    public SquareVoiceMatchGuideBubbleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[1], (LinearLayout) objArr[3], (CustomLoopingViewSwitcher) objArr[2], (TextView) objArr[6], (FrameLayout) objArr[0], (TextView) objArr[5], (TextView) objArr[4]);
        this.h = -1L;
        this.e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
