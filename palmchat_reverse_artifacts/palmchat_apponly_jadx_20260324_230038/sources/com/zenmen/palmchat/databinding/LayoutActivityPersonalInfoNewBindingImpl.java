package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.CommonInfoCellView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LayoutActivityPersonalInfoNewBindingImpl extends LayoutActivityPersonalInfoNewBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts v = null;

    @Nullable
    public static final SparseIntArray w;

    @NonNull
    public final LinearLayout t;
    public long u;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        w = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.avatarList, 2);
        sparseIntArray.put(R.id.avatarEdit, 3);
        sparseIntArray.put(R.id.name, 4);
        sparseIntArray.put(R.id.gender, 5);
        sparseIntArray.put(R.id.birthday, 6);
        sparseIntArray.put(R.id.signature, 7);
        sparseIntArray.put(R.id.intentions, 8);
        sparseIntArray.put(R.id.occupation, 9);
        sparseIntArray.put(R.id.income, 10);
        sparseIntArray.put(R.id.hometown, 11);
        sparseIntArray.put(R.id.house, 12);
        sparseIntArray.put(R.id.car, 13);
        sparseIntArray.put(R.id.feedList, 14);
        sparseIntArray.put(R.id.editFeed, 15);
        sparseIntArray.put(R.id.personalityCharacteristics, 16);
        sparseIntArray.put(R.id.likePersonalityCharacteristics, 17);
        sparseIntArray.put(R.id.fond, 18);
        sparseIntArray.put(R.id.hobby, 19);
    }

    public LayoutActivityPersonalInfoNewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, v, w));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.u = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.u != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.u = 1L;
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

    public LayoutActivityPersonalInfoNewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (RecyclerView) objArr[2], (CommonInfoCellView) objArr[6], (CommonInfoCellView) objArr[13], (TextView) objArr[15], (RecyclerView) objArr[14], (CommonInfoCellView) objArr[18], (CommonInfoCellView) objArr[5], (TextView) objArr[19], (CommonInfoCellView) objArr[11], (CommonInfoCellView) objArr[12], (CommonInfoCellView) objArr[10], (CommonInfoCellView) objArr[8], (CommonInfoCellView) objArr[17], (CommonInfoCellView) objArr[4], (CommonInfoCellView) objArr[9], (CommonInfoCellView) objArr[16], (TextView) objArr[7], (View) objArr[1]);
        this.u = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.t = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
