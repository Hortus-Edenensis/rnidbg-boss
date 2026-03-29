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
import com.zenmen.palmchat.widget.MarqueeTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LayoutActivityVoiceMatchBindingImpl extends LayoutActivityVoiceMatchBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts s = null;

    @Nullable
    public static final SparseIntArray t;
    public long r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.video_match_container, 1);
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.back, 3);
        sparseIntArray.put(R.id.rule, 4);
        sparseIntArray.put(R.id.title, 5);
        sparseIntArray.put(R.id.tab_layout, 6);
        sparseIntArray.put(R.id.tab_voice, 7);
        sparseIntArray.put(R.id.tab_video, 8);
        sparseIntArray.put(R.id.video_new_layout, 9);
        sparseIntArray.put(R.id.voice_match_container, 10);
        sparseIntArray.put(R.id.layout_level_root, 11);
        sparseIntArray.put(R.id.layout_level_bubble, 12);
        sparseIntArray.put(R.id.tv_level_bubble, 13);
        sparseIntArray.put(R.id.level_entrance, 14);
        sparseIntArray.put(R.id.level_entrance_tv, 15);
        sparseIntArray.put(R.id.svga, 16);
    }

    public LayoutActivityVoiceMatchBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    public LayoutActivityVoiceMatchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (LinearLayout) objArr[12], (RelativeLayout) objArr[11], (RelativeLayout) objArr[14], (TextView) objArr[15], (RelativeLayout) objArr[0], (ImageView) objArr[4], (SVGAImageView) objArr[16], (LinearLayout) objArr[6], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[5], (RelativeLayout) objArr[2], (MarqueeTextView) objArr[13], (FrameLayout) objArr[1], (FrameLayout) objArr[9], (FrameLayout) objArr[10]);
        this.r = -1L;
        this.f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
