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
import com.zenmen.palmchat.ad.VisibleDetectView;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$id;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareNearbyAdListItemBigpicBindingImpl extends SquareNearbyAdListItemBigpicBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts u = null;

    @Nullable
    public static final SparseIntArray v;

    @NonNull
    public final LinearLayout s;
    public long t;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R$id.vip_entrance, 2);
        sparseIntArray.put(R$id.ad_app_icon, 3);
        sparseIntArray.put(R$id.ad_app_name, 4);
        sparseIntArray.put(R$id.ad_title, 5);
        sparseIntArray.put(R$id.ad_drop, 6);
        sparseIntArray.put(R$id.ad_sign, 7);
        sparseIntArray.put(R$id.ad_native_close, 8);
        sparseIntArray.put(R$id.ad_main, 9);
        sparseIntArray.put(R$id.ad_video, 10);
        sparseIntArray.put(R$id.ad_img, 11);
        sparseIntArray.put(R$id.ad_logo, 12);
        sparseIntArray.put(R$id.app_download_btn, 13);
        sparseIntArray.put(R$id.ad_action, 14);
        sparseIntArray.put(R$id.shake, 15);
        sparseIntArray.put(R$id.ad_discount_info_layout, 16);
        sparseIntArray.put(R$id.ad_discount_info_textview, 17);
        sparseIntArray.put(R$id.ad_com_info_layout, 18);
    }

    public SquareNearbyAdListItemBigpicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, u, v));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.t = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.t != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.t = 1L;
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

    public SquareNearbyAdListItemBigpicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[14], (EffectiveShapeView) objArr[3], (TextView) objArr[4], (AdComInfoAllLayout) objArr[18], (LinearLayout) objArr[16], (TextView) objArr[17], (LinearLayout) objArr[6], (EffectiveShapeView) objArr[11], (ImageView) objArr[12], (FrameLayout) objArr[9], (ImageView) objArr[8], (TextView) objArr[7], (TextView) objArr[5], (FrameLayout) objArr[10], (NestHuaWeiNativeAppButton) objArr[13], (ShakeView) objArr[15], (View) objArr[2], (VisibleDetectView) objArr[0]);
        this.t = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.s = linearLayout;
        linearLayout.setTag(null);
        this.r.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
