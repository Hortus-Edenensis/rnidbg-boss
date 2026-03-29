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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXPortraitView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ActivityDynamicExposeHomeBindingImpl extends ActivityDynamicExposeHomeBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts J = null;

    @Nullable
    public static final SparseIntArray K;

    @NonNull
    public final RelativeLayout H;
    public long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.back, 2);
        sparseIntArray.put(R.id.title_txt, 3);
        sparseIntArray.put(R.id.dynamic_chosed_layout, 4);
        sparseIntArray.put(R.id.dynamic_chosed_layout_top, 5);
        sparseIntArray.put(R.id.mine_head_portrait, 6);
        sparseIntArray.put(R.id.nick_name, 7);
        sparseIntArray.put(R.id.text_thumbnail1, 8);
        sparseIntArray.put(R.id.image_layout, 9);
        sparseIntArray.put(R.id.text_view1, 10);
        sparseIntArray.put(R.id.image_view1, 11);
        sparseIntArray.put(R.id.iv_video1, 12);
        sparseIntArray.put(R.id.change_next, 13);
        sparseIntArray.put(R.id.no_dynamic_layout, 14);
        sparseIntArray.put(R.id.to_publish_btn, 15);
        sparseIntArray.put(R.id.to_chose_dynamic_layout, 16);
        sparseIntArray.put(R.id.more_layout, 17);
        sparseIntArray.put(R.id.dynamic_recycler_view, 18);
        sparseIntArray.put(R.id.sex0, 19);
        sparseIntArray.put(R.id.sex1, 20);
        sparseIntArray.put(R.id.sex2, 21);
        sparseIntArray.put(R.id.country, 22);
        sparseIntArray.put(R.id.city, 23);
        sparseIntArray.put(R.id.recyclerView, 24);
        sparseIntArray.put(R.id.bottom_layout, 25);
        sparseIntArray.put(R.id.check_box_layout, 26);
        sparseIntArray.put(R.id.check_box_image, 27);
        sparseIntArray.put(R.id.check_box_url, 28);
        sparseIntArray.put(R.id.pop_tv, 29);
        sparseIntArray.put(R.id.price, 30);
        sparseIntArray.put(R.id.btn_pay_layout, 31);
        sparseIntArray.put(R.id.btn_pay, 32);
    }

    public ActivityDynamicExposeHomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 33, J, K));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.I = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.I != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.I = 1L;
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

    public ActivityDynamicExposeHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (LinearLayout) objArr[25], (TextView) objArr[32], (FrameLayout) objArr[31], (LinearLayout) objArr[13], (ImageView) objArr[27], (LinearLayout) objArr[26], (TextView) objArr[28], (TextView) objArr[23], (TextView) objArr[22], (RelativeLayout) objArr[4], (LinearLayout) objArr[5], (RecyclerView) objArr[18], (LinearLayout) objArr[9], (ShapeableImageView) objArr[11], (ImageView) objArr[12], (LXPortraitView) objArr[6], (LinearLayout) objArr[17], (TextView) objArr[7], (LinearLayout) objArr[14], (TextView) objArr[29], (TextView) objArr[30], (RecyclerView) objArr[24], (TextView) objArr[19], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[8], (AppCompatTextView) objArr[10], (TextView) objArr[3], (LinearLayout) objArr[16], (TextView) objArr[15], (FrameLayout) objArr[1]);
        this.I = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.H = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
