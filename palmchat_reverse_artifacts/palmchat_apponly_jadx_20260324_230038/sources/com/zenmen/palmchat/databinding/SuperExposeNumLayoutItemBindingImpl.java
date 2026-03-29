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
import com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.recycler.SuperExposeTabRecyclerItemLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeNumLayoutItemBindingImpl extends SuperExposeNumLayoutItemBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts o = null;

    @Nullable
    public static final SparseIntArray p;
    public long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.img, 1);
        sparseIntArray.put(R.id.tag_layout, 2);
        sparseIntArray.put(R.id.tag_layout_1, 3);
        sparseIntArray.put(R.id.tag_green_bg_1, 4);
        sparseIntArray.put(R.id.item_tag_1, 5);
        sparseIntArray.put(R.id.tag_layout_2, 6);
        sparseIntArray.put(R.id.tag_green_bg_2, 7);
        sparseIntArray.put(R.id.item_tag_2, 8);
        sparseIntArray.put(R.id.name_age_layout, 9);
        sparseIntArray.put(R.id.name, 10);
        sparseIntArray.put(R.id.age, 11);
        sparseIntArray.put(R.id.distance, 12);
    }

    public SuperExposeNumLayoutItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, o, p));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.n = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 1L;
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

    public SuperExposeNumLayoutItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[11], (TextView) objArr[12], (EffectiveShapeView) objArr[1], (SuperExposeTabRecyclerItemLayout) objArr[0], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[10], (LinearLayout) objArr[9], (View) objArr[4], (View) objArr[7], (LinearLayout) objArr[2], (LinearLayout) objArr[3], (LinearLayout) objArr[6]);
        this.n = -1L;
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
