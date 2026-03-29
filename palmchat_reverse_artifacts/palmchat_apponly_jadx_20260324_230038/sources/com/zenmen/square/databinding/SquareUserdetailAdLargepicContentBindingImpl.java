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
import com.zenmen.palmchat.ad.compliance.AdComInfoAllLayout2;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$id;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareUserdetailAdLargepicContentBindingImpl extends SquareUserdetailAdLargepicContentBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts m = null;

    @Nullable
    public static final SparseIntArray n;

    @NonNull
    public final LinearLayout k;
    public long l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R$id.ad_icon, 1);
        sparseIntArray.put(R$id.ad_sign, 2);
        sparseIntArray.put(R$id.ad_img, 3);
        sparseIntArray.put(R$id.ad_video, 4);
        sparseIntArray.put(R$id.ad_close, 5);
        sparseIntArray.put(R$id.ad_name, 6);
        sparseIntArray.put(R$id.ad_app_name, 7);
        sparseIntArray.put(R$id.app_download_btn, 8);
        sparseIntArray.put(R$id.ad_action, 9);
        sparseIntArray.put(R$id.ad_com_info_layout, 10);
    }

    public SquareUserdetailAdLargepicContentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, m, n));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.l = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 1L;
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

    public SquareUserdetailAdLargepicContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[9], (TextView) objArr[7], (ImageView) objArr[5], (AdComInfoAllLayout2) objArr[10], (ImageView) objArr[1], (EffectiveShapeView) objArr[3], (TextView) objArr[6], (TextView) objArr[2], (FrameLayout) objArr[4], (NestHuaWeiNativeAppButton) objArr[8]);
        this.l = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.k = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
