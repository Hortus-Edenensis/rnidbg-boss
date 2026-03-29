package com.zenmen.square.databinding;

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
import com.wifi.ad.core.feedbanner.NestHuaWeiNativeAppButton;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$id;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareUserdetailAdLargedivContentBindingImpl extends SquareUserdetailAdLargedivContentBinding {

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
        sparseIntArray.put(R$id.ad_img, 1);
        sparseIntArray.put(R$id.ad_video, 2);
        sparseIntArray.put(R$id.shake, 3);
        sparseIntArray.put(R$id.ad_close, 4);
        sparseIntArray.put(R$id.ad_name, 5);
        sparseIntArray.put(R$id.ad_app_name, 6);
        sparseIntArray.put(R$id.ad_icon, 7);
        sparseIntArray.put(R$id.ad_sign, 8);
        sparseIntArray.put(R$id.app_download_btn, 9);
        sparseIntArray.put(R$id.ad_action, 10);
        sparseIntArray.put(R$id.ad_com_info_layout, 11);
    }

    public SquareUserdetailAdLargedivContentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    public SquareUserdetailAdLargedivContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[10], (TextView) objArr[6], (ImageView) objArr[4], (AdComInfoAllLayout) objArr[11], (ImageView) objArr[7], (EffectiveShapeView) objArr[1], (TextView) objArr[5], (TextView) objArr[8], (FrameLayout) objArr[2], (NestHuaWeiNativeAppButton) objArr[9], (ShakeView) objArr[3]);
        this.m = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.l = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
