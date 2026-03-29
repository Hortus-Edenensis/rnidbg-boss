package com.zenmen.palmchat.friendcircle.databinding;

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
import com.wifi.ad.core.feedbanner.ClearLogoNativeAdContainer;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.widget.EffectiveShapeView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MomentsAdNestNewBindingImpl extends MomentsAdNestNewBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts r = null;

    @Nullable
    public static final SparseIntArray s;

    @NonNull
    public final LinearLayout p;
    public long q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        s = sparseIntArray;
        sparseIntArray.put(R$id.vip_entrance, 3);
        sparseIntArray.put(R$id.ad_app_icon, 4);
        sparseIntArray.put(R$id.ad_app_name, 5);
        sparseIntArray.put(R$id.ad_infor, 6);
        sparseIntArray.put(R$id.ad_container_main, 7);
        sparseIntArray.put(R$id.ad_video_wrapper, 8);
        sparseIntArray.put(R$id.ad_video, 9);
        sparseIntArray.put(R$id.ad_img, 10);
        sparseIntArray.put(R$id.ad_logo_normal, 11);
        sparseIntArray.put(R$id.ad_action_normal, 12);
        sparseIntArray.put(R$id.ad_title, 13);
        sparseIntArray.put(R$id.ad_drop, 14);
        sparseIntArray.put(R$id.ad_sign, 15);
    }

    public MomentsAdNestNewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, r, s));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.q = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.q != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.q = 1L;
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

    public MomentsAdNestNewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[12], (EffectiveShapeView) objArr[4], (TextView) objArr[5], (LinearLayout) objArr[1], (LinearLayout) objArr[7], (LinearLayout) objArr[14], (EffectiveShapeView) objArr[10], (TextView) objArr[6], (ImageView) objArr[11], (TextView) objArr[15], (ClearLogoNativeAdContainer) objArr[0], (TextView) objArr[13], (FrameLayout) objArr[9], (FrameLayout) objArr[8], (View) objArr[3]);
        this.q = -1L;
        this.d.setTag(null);
        this.k.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.p = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
