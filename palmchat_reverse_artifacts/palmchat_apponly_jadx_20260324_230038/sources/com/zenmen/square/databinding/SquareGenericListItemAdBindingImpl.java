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
import com.zenmen.square.ad.AdPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareGenericListItemAdBindingImpl extends SquareGenericListItemAdBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts C = null;

    @Nullable
    public static final SparseIntArray E;

    @NonNull
    public final LinearLayout A;
    public long B;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        E = sparseIntArray;
        sparseIntArray.put(R$id.vip_entrance, 2);
        sparseIntArray.put(R$id.ad_app_icon, 3);
        sparseIntArray.put(R$id.ad_app_name, 4);
        sparseIntArray.put(R$id.ad_infor, 5);
        sparseIntArray.put(R$id.ad_drop, 6);
        sparseIntArray.put(R$id.ad_sign, 7);
        sparseIntArray.put(R$id.ad_native_close, 8);
        sparseIntArray.put(R$id.ad_title, 9);
        sparseIntArray.put(R$id.ad_main_normal, 10);
        sparseIntArray.put(R$id.ad_video_wrapper, 11);
        sparseIntArray.put(R$id.ad_video, 12);
        sparseIntArray.put(R$id.ad_img, 13);
        sparseIntArray.put(R$id.ad_logo_normal, 14);
        sparseIntArray.put(R$id.app_download_btn, 15);
        sparseIntArray.put(R$id.ad_action_normal, 16);
        sparseIntArray.put(R$id.shake_normal, 17);
        sparseIntArray.put(R$id.ad_main_group, 18);
        sparseIntArray.put(R$id.ad_pager, 19);
        sparseIntArray.put(R$id.ad_logo_group, 20);
        sparseIntArray.put(R$id.app_download_btn_group, 21);
        sparseIntArray.put(R$id.ad_action_group, 22);
        sparseIntArray.put(R$id.shake_group, 23);
        sparseIntArray.put(R$id.ad_discount_info_layout, 24);
        sparseIntArray.put(R$id.ad_discount_info_textview, 25);
        sparseIntArray.put(R$id.ad_com_info_layout, 26);
    }

    public SquareGenericListItemAdBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 27, C, E));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.B = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.B != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.B = 1L;
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

    public SquareGenericListItemAdBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[22], (TextView) objArr[16], (EffectiveShapeView) objArr[3], (TextView) objArr[4], (AdComInfoAllLayout) objArr[26], (LinearLayout) objArr[24], (TextView) objArr[25], (LinearLayout) objArr[6], (EffectiveShapeView) objArr[13], (TextView) objArr[5], (ImageView) objArr[20], (ImageView) objArr[14], (FrameLayout) objArr[18], (FrameLayout) objArr[10], (ImageView) objArr[8], (AdPager) objArr[19], (TextView) objArr[7], (TextView) objArr[9], (FrameLayout) objArr[12], (FrameLayout) objArr[11], (NestHuaWeiNativeAppButton) objArr[15], (NestHuaWeiNativeAppButton) objArr[21], (ShakeView) objArr[23], (ShakeView) objArr[17], (View) objArr[2], (VisibleDetectView) objArr[0]);
        this.B = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.A = linearLayout;
        linearLayout.setTag(null);
        this.z.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
