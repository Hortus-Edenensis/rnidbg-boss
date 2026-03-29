package com.zenmen.palmchat.databinding;

import android.util.SparseIntArray;
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
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.bridge.voicomatch.MatchPropInfoCardView;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.LightingAnimationView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LayoutVoiceMatchPanelBindingImpl extends LayoutVoiceMatchPanelBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts M = null;

    @Nullable
    public static final SparseIntArray N;

    @NonNull
    public final RelativeLayout K;
    public long L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        N = sparseIntArray;
        sparseIntArray.put(R.id.user_info_layout, 1);
        sparseIntArray.put(R.id.svga, 2);
        sparseIntArray.put(R.id.icon, 3);
        sparseIntArray.put(R.id.retry_layout, 4);
        sparseIntArray.put(R.id.empty_iv, 5);
        sparseIntArray.put(R.id.retry_tv, 6);
        sparseIntArray.put(R.id.ab_layout, 7);
        sparseIntArray.put(R.id.ab_des_1, 8);
        sparseIntArray.put(R.id.ab_des_2, 9);
        sparseIntArray.put(R.id.match_info_layout, 10);
        sparseIntArray.put(R.id.match_info_main_tv, 11);
        sparseIntArray.put(R.id.match_info_sub_loop_layout, 12);
        sparseIntArray.put(R.id.match_info_sub_tv, 13);
        sparseIntArray.put(R.id.fastmatching_layout, 14);
        sparseIntArray.put(R.id.fast_matching_title, 15);
        sparseIntArray.put(R.id.fast_match_flash, 16);
        sparseIntArray.put(R.id.fastmatchingicon, 17);
        sparseIntArray.put(R.id.fast_matching_des, 18);
        sparseIntArray.put(R.id.prop_card_layout, 19);
        sparseIntArray.put(R.id.fast_guide_layout, 20);
        sparseIntArray.put(R.id.fast_guide_content_layout, 21);
        sparseIntArray.put(R.id.fast_icon, 22);
        sparseIntArray.put(R.id.fast_title, 23);
        sparseIntArray.put(R.id.fast_price, 24);
        sparseIntArray.put(R.id.fast_subtitle, 25);
        sparseIntArray.put(R.id.fast_btn, 26);
        sparseIntArray.put(R.id.fast_guide_matching_count, 27);
        sparseIntArray.put(R.id.city_guide_layout, 28);
        sparseIntArray.put(R.id.city_icon, 29);
        sparseIntArray.put(R.id.city_title, 30);
        sparseIntArray.put(R.id.city_price, 31);
        sparseIntArray.put(R.id.city_subtitle, 32);
        sparseIntArray.put(R.id.city_btn, 33);
        sparseIntArray.put(R.id.anim_view1, 34);
        sparseIntArray.put(R.id.matching_fail_prop_layout, 35);
    }

    public LayoutVoiceMatchPanelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 36, M, N));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.L = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L = 1L;
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

    public LayoutVoiceMatchPanelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (TextView) objArr[9], (LinearLayout) objArr[7], (LightingAnimationView) objArr[34], (TextView) objArr[33], (LinearLayout) objArr[28], (ImageView) objArr[29], (TextView) objArr[31], (TextView) objArr[32], (TextView) objArr[30], (ImageView) objArr[5], (TextView) objArr[26], (LinearLayout) objArr[21], (RelativeLayout) objArr[20], (TextView) objArr[27], (ImageView) objArr[22], (ImageView) objArr[16], (TextView) objArr[18], (TextView) objArr[15], (TextView) objArr[24], (TextView) objArr[25], (TextView) objArr[23], (LinearLayout) objArr[14], (ImageView) objArr[17], (EffectiveShapeView) objArr[3], (LinearLayout) objArr[10], (TextView) objArr[11], (FrameLayout) objArr[12], (TextView) objArr[13], (MatchPropInfoCardView) objArr[35], (LinearLayout) objArr[19], (LinearLayout) objArr[4], (TextView) objArr[6], (SVGAImageView) objArr[2], (RelativeLayout) objArr[1]);
        this.L = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.K = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
