package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ListitemDynamicExposeHomeBuyBindingImpl extends ListitemDynamicExposeHomeBuyBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts j = null;

    @Nullable
    public static final SparseIntArray k;
    public long i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.label, 1);
        sparseIntArray.put(R.id.num1, 2);
        sparseIntArray.put(R.id.num_add, 3);
        sparseIntArray.put(R.id.num_label1, 4);
        sparseIntArray.put(R.id.num2, 5);
        sparseIntArray.put(R.id.num_label2, 6);
        sparseIntArray.put(R.id.time, 7);
    }

    public ListitemDynamicExposeHomeBuyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, j, k));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.i = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 1L;
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

    public ListitemDynamicExposeHomeBuyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[6], (LinearLayout) objArr[0], (TextView) objArr[7]);
        this.i = -1L;
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
