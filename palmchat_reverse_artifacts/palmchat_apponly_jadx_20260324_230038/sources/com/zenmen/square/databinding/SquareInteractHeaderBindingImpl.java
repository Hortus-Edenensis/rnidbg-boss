package com.zenmen.square.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.widget.MSVGAImageView;
import com.zenmen.square.R$id;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareInteractHeaderBindingImpl extends SquareInteractHeaderBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts s = null;

    @Nullable
    public static final SparseIntArray t;

    @NonNull
    public final LinearLayout q;
    public long r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R$id.num1, 1);
        sparseIntArray.put(R$id.image1, 2);
        sparseIntArray.put(R$id.label1, 3);
        sparseIntArray.put(R$id.text1, 4);
        sparseIntArray.put(R$id.num2, 5);
        sparseIntArray.put(R$id.image2, 6);
        sparseIntArray.put(R$id.label2, 7);
        sparseIntArray.put(R$id.text2, 8);
        sparseIntArray.put(R$id.num3, 9);
        sparseIntArray.put(R$id.image3, 10);
        sparseIntArray.put(R$id.label3, 11);
        sparseIntArray.put(R$id.text3, 12);
        sparseIntArray.put(R$id.rank, 13);
        sparseIntArray.put(R$id.btn, 14);
        sparseIntArray.put(R$id.hot_svga, 15);
        sparseIntArray.put(R$id.btn_txt, 16);
    }

    public SquareInteractHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, s, t));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.r = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.r != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.r = 1L;
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

    public SquareInteractHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[14], (TextView) objArr[16], (MSVGAImageView) objArr[15], (ImageView) objArr[2], (ImageView) objArr[6], (ImageView) objArr[10], (View) objArr[3], (View) objArr[7], (View) objArr[11], (TextView) objArr[1], (TextView) objArr[5], (TextView) objArr[9], (TextView) objArr[13], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[12]);
        this.r = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.q = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
