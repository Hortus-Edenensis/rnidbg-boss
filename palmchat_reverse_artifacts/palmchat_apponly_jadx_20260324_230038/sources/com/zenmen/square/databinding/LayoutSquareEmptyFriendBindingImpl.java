package com.zenmen.square.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.ko;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutSquareEmptyFriendBindingImpl extends LayoutSquareEmptyFriendBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts e = null;

    @Nullable
    public static final SparseIntArray f = null;

    @NonNull
    public final LinearLayout c;
    public long d;

    public LayoutSquareEmptyFriendBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, e, f));
    }

    @Override // com.zenmen.square.databinding.LayoutSquareEmptyFriendBinding
    public void b(@Nullable SquareFeed squareFeed) {
        this.b = squareFeed;
        synchronized (this) {
            this.d |= 1;
        }
        notifyPropertyChanged(ko.f18729a);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.d;
            this.d = 0L;
        }
        SquareFeed squareFeed = this.b;
        long j2 = j & 3;
        String content = (j2 == 0 || squareFeed == null) ? null : squareFeed.getContent();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f16227a, content);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.d = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.f18729a != i) {
            return false;
        }
        b((SquareFeed) obj);
        return true;
    }

    public LayoutSquareEmptyFriendBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.d = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.c = linearLayout;
        linearLayout.setTag(null);
        this.f16227a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
