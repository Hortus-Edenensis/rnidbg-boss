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
import com.wifi.ad.core.feedbanner.NestHuaWeiNativeAppButton;
import com.zenmen.palmchat.ad.ShakeView;
import com.zenmen.palmchat.ad.VisibleDetectView;
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$id;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareNearbyAdListItemMultipicBindingImpl extends SquareNearbyAdListItemMultipicBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts y = null;

    @Nullable
    public static final SparseIntArray z;

    @NonNull
    public final LinearLayout w;
    public long x;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R$id.vip_entrance, 2);
        sparseIntArray.put(R$id.ad_app_icon, 3);
        sparseIntArray.put(R$id.ad_app_name, 4);
        sparseIntArray.put(R$id.ad_title, 5);
        sparseIntArray.put(R$id.ad_drop, 6);
        sparseIntArray.put(R$id.ad_sign, 7);
        sparseIntArray.put(R$id.ad_native_close, 8);
        sparseIntArray.put(R$id.ad_img1, 9);
        sparseIntArray.put(R$id.ad_img2, 10);
        sparseIntArray.put(R$id.ad_banner1, 11);
        sparseIntArray.put(R$id.ad_logo1, 12);
        sparseIntArray.put(R$id.ad_action1, 13);
        sparseIntArray.put(R$id.ad_img3, 14);
        sparseIntArray.put(R$id.ad_banner2, 15);
        sparseIntArray.put(R$id.ad_logo2, 16);
        sparseIntArray.put(R$id.app_download_btn, 17);
        sparseIntArray.put(R$id.ad_action2, 18);
        sparseIntArray.put(R$id.shake, 19);
        sparseIntArray.put(R$id.ad_discount_info_layout, 20);
        sparseIntArray.put(R$id.ad_discount_info_textview, 21);
        sparseIntArray.put(R$id.ad_com_info_layout, 22);
    }

    public SquareNearbyAdListItemMultipicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, y, z));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.x = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.x != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.x = 1L;
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

    public SquareNearbyAdListItemMultipicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[13], (TextView) objArr[18], (EffectiveShapeView) objArr[3], (TextView) objArr[4], (LinearLayout) objArr[11], (LinearLayout) objArr[15], (AdComInfoAllLayout) objArr[22], (LinearLayout) objArr[20], (TextView) objArr[21], (LinearLayout) objArr[6], (EffectiveShapeView) objArr[9], (EffectiveShapeView) objArr[10], (EffectiveShapeView) objArr[14], (ImageView) objArr[12], (ImageView) objArr[16], (ImageView) objArr[8], (TextView) objArr[7], (TextView) objArr[5], (NestHuaWeiNativeAppButton) objArr[17], (ShakeView) objArr[19], (View) objArr[2], (VisibleDetectView) objArr[0]);
        this.x = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.w = linearLayout;
        linearLayout.setTag(null);
        this.v.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
