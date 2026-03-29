package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.bridge.voicomatch.MatchPropInfoCardView;
import com.zenmen.palmchat.widget.LightingAnimationView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LayoutVideoMatchPanelBindingImpl extends LayoutVideoMatchPanelBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts L = null;

    @Nullable
    public static final SparseIntArray M;

    @NonNull
    public final RelativeLayout J;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R.id.head_view, 1);
        sparseIntArray.put(R.id.video_screen_render_sv, 2);
        sparseIntArray.put(R.id.error_info_layout, 3);
        sparseIntArray.put(R.id.error_info_image, 4);
        sparseIntArray.put(R.id.error_info_title, 5);
        sparseIntArray.put(R.id.error_info_sub_title, 6);
        sparseIntArray.put(R.id.bottom_layout, 7);
        sparseIntArray.put(R.id.fastmatching_layout, 8);
        sparseIntArray.put(R.id.fast_matching_title, 9);
        sparseIntArray.put(R.id.fast_match_flash, 10);
        sparseIntArray.put(R.id.fastmatchingicon, 11);
        sparseIntArray.put(R.id.fast_matching_des, 12);
        sparseIntArray.put(R.id.prop_card_layout, 13);
        sparseIntArray.put(R.id.fast_guide_layout, 14);
        sparseIntArray.put(R.id.fast_guide_content_layout, 15);
        sparseIntArray.put(R.id.fast_icon, 16);
        sparseIntArray.put(R.id.fast_title, 17);
        sparseIntArray.put(R.id.fast_price, 18);
        sparseIntArray.put(R.id.fast_subtitle, 19);
        sparseIntArray.put(R.id.fast_btn, 20);
        sparseIntArray.put(R.id.fast_guide_matching_count, 21);
        sparseIntArray.put(R.id.city_guide_layout, 22);
        sparseIntArray.put(R.id.city_icon, 23);
        sparseIntArray.put(R.id.city_title, 24);
        sparseIntArray.put(R.id.city_price, 25);
        sparseIntArray.put(R.id.city_subtitle, 26);
        sparseIntArray.put(R.id.city_btn, 27);
        sparseIntArray.put(R.id.anim_view1, 28);
        sparseIntArray.put(R.id.btn, 29);
        sparseIntArray.put(R.id.matching_fail_prop_layout, 30);
        sparseIntArray.put(R.id.match_info_layout, 31);
        sparseIntArray.put(R.id.match_info_main_tv, 32);
        sparseIntArray.put(R.id.match_info_sub_loop_layout, 33);
        sparseIntArray.put(R.id.match_info_sub_tv, 34);
    }

    public LayoutVideoMatchPanelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 35, L, M));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.K = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.K != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K = 1L;
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

    public LayoutVideoMatchPanelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LightingAnimationView) objArr[28], (FrameLayout) objArr[7], (TextView) objArr[29], (TextView) objArr[27], (LinearLayout) objArr[22], (ImageView) objArr[23], (TextView) objArr[25], (TextView) objArr[26], (TextView) objArr[24], (ImageView) objArr[4], (LinearLayout) objArr[3], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[20], (LinearLayout) objArr[15], (RelativeLayout) objArr[14], (TextView) objArr[21], (ImageView) objArr[16], (ImageView) objArr[10], (TextView) objArr[12], (TextView) objArr[9], (TextView) objArr[18], (TextView) objArr[19], (TextView) objArr[17], (LinearLayout) objArr[8], (ImageView) objArr[11], (ImageView) objArr[1], (LinearLayout) objArr[31], (TextView) objArr[32], (FrameLayout) objArr[33], (TextView) objArr[34], (MatchPropInfoCardView) objArr[30], (LinearLayout) objArr[13], (TextureView) objArr[2]);
        this.K = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.J = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
