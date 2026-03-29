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
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout2;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$id;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareUserdetailAdMultipicContentBindingImpl extends SquareUserdetailAdMultipicContentBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts n = null;

    @Nullable
    public static final SparseIntArray o;

    @NonNull
    public final LinearLayout l;
    public long m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o = sparseIntArray;
        sparseIntArray.put(R$id.ad_icon, 1);
        sparseIntArray.put(R$id.ad_sign, 2);
        sparseIntArray.put(R$id.ad_img_1, 3);
        sparseIntArray.put(R$id.ad_img_2, 4);
        sparseIntArray.put(R$id.ad_close_1, 5);
        sparseIntArray.put(R$id.ad_img_3, 6);
        sparseIntArray.put(R$id.ad_close_2, 7);
        sparseIntArray.put(R$id.ad_name, 8);
        sparseIntArray.put(R$id.ad_app_name, 9);
        sparseIntArray.put(R$id.ad_action, 10);
        sparseIntArray.put(R$id.ad_com_info_layout, 11);
    }

    public SquareUserdetailAdMultipicContentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, n, o));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.m = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 1L;
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

    public SquareUserdetailAdMultipicContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[10], (TextView) objArr[9], (ImageView) objArr[5], (ImageView) objArr[7], (AdComInfoAllLayout2) objArr[11], (ImageView) objArr[1], (EffectiveShapeView) objArr[3], (EffectiveShapeView) objArr[4], (EffectiveShapeView) objArr[6], (TextView) objArr[8], (TextView) objArr[2]);
        this.m = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.l = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
