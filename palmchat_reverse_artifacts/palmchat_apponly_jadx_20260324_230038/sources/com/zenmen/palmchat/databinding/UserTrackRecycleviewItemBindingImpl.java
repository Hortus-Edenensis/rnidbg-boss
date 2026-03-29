package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserTrackRecycleviewItemBindingImpl extends UserTrackRecycleviewItemBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts i = null;

    @Nullable
    public static final SparseIntArray j;
    public long h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.head_img, 1);
        sparseIntArray.put(R.id.content_layout, 2);
        sparseIntArray.put(R.id.nickname, 3);
        sparseIntArray.put(R.id.sex_image, 4);
        sparseIntArray.put(R.id.sub_title, 5);
        sparseIntArray.put(R.id.btn_say_hi, 6);
    }

    public UserTrackRecycleviewItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    public UserTrackRecycleviewItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LeftDrawableText) objArr[6], (LinearLayout) objArr[2], (LXPortraitView) objArr[1], (TextView) objArr[3], (RelativeLayout) objArr[0], (ImageView) objArr[4], (TextView) objArr[5]);
        this.h = -1L;
        this.e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
