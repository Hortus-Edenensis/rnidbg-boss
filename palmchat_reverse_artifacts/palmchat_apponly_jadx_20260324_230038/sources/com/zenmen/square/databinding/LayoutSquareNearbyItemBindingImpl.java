package com.zenmen.square.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.google.android.flexbox.FlexboxLayout;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.palmchat.widget.LightingAnimationView;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.mvp.holder.NearByViewHolder;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.ui.widget.NearByFeedContainer;
import defpackage.ko;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutSquareNearbyItemBindingImpl extends LayoutSquareNearbyItemBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts A = null;

    @Nullable
    public static final SparseIntArray B;

    @NonNull
    public final FrameLayout y;
    public long z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        B = sparseIntArray;
        sparseIntArray.put(R$id.root_content, 16);
        sparseIntArray.put(R$id.anim_view, 17);
        sparseIntArray.put(R$id.tv_nearby_user_desc, 18);
        sparseIntArray.put(R$id.iv_feed_ai_chat, 19);
        sparseIntArray.put(R$id.iv_super_expose_item_enter_arrow, 20);
        sparseIntArray.put(R$id.iv_feed_map_separation, 21);
        sparseIntArray.put(R$id.iv_nearby_desc_polish, 22);
        sparseIntArray.put(R$id.blur_wrapper, 23);
    }

    public LayoutSquareNearbyItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 24, A, B));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        boolean z;
        String str;
        Drawable drawable;
        long j2;
        String str2;
        int i2;
        int colorFromResource;
        TextView textView;
        int i3;
        NearByBean.Extra extra;
        int i4;
        boolean z2;
        int i5;
        int i6;
        String str3;
        synchronized (this) {
            j = this.z;
            this.z = 0L;
        }
        NearByBean nearByBean = this.x;
        long j3 = j & 3;
        if (j3 != 0) {
            if (nearByBean != null) {
                str = nearByBean.onlineStatusDesc;
                i4 = nearByBean.userType;
                z2 = nearByBean.official;
                j2 = nearByBean.distance;
                i5 = nearByBean.gender;
                extra = nearByBean.extra;
            } else {
                extra = null;
                str = null;
                i4 = 0;
                j2 = 0;
                z2 = false;
                i5 = 0;
            }
            if (j3 != 0) {
                j |= z2 ? 8L : 4L;
            }
            z = i4 == 18;
            int i7 = z2 ? 0 : 8;
            boolean z3 = i5 == 1;
            if ((j & 3) != 0) {
                j = z ? j | 512 : j | 256;
            }
            if ((j & 3) != 0) {
                j |= z3 ? 128L : 64L;
            }
            if (extra != null) {
                str3 = extra.desc;
                i6 = extra.type;
            } else {
                i6 = 0;
                str3 = null;
            }
            drawable = z3 ? AppCompatResources.getDrawable(this.g.getContext(), R$drawable.icon_sex_female) : AppCompatResources.getDrawable(this.g.getContext(), R$drawable.icon_sex_male);
            boolean z4 = i6 == 1;
            if ((j & 3) != 0) {
                j |= z4 ? 32L : 16L;
            }
            int i8 = z4 ? 0 : 8;
            i = i7;
            str2 = str3;
            i2 = i8;
        } else {
            i = 0;
            z = false;
            str = null;
            drawable = null;
            j2 = 0;
            str2 = null;
            i2 = 0;
        }
        long j4 = 256 & j;
        if (j4 != 0) {
            boolean z5 = (nearByBean != null ? nearByBean.onlineStatusCode : 0) == 1;
            if (j4 != 0) {
                j |= z5 ? 2048L : 1024L;
            }
            if (z5) {
                textView = this.u;
                i3 = R$color.Aa;
            } else {
                textView = this.u;
                i3 = R$color.Gd;
            }
            colorFromResource = ViewDataBinding.getColorFromResource(textView, i3);
        } else {
            colorFromResource = 0;
        }
        long j5 = j & 3;
        int colorFromResource2 = j5 != 0 ? z ? ViewDataBinding.getColorFromResource(this.u, R$color.lite_black) : colorFromResource : 0;
        if (j5 != 0) {
            this.mBindingComponent.getNearByViewHolder().F(this.c, nearByBean);
            this.d.setVisibility(i2);
            ImageViewBindingAdapter.setImageDrawable(this.g, drawable);
            this.mBindingComponent.getNearByViewHolder().C(this.h, nearByBean);
            TextViewBindingAdapter.setText(this.i, str2);
            this.mBindingComponent.getNearByViewHolder().y(this.j, nearByBean);
            TextViewBindingAdapter.setText(this.k, str2);
            this.mBindingComponent.getNearByViewHolder().G(this.m, nearByBean);
            this.mBindingComponent.getNearByViewHolder().E(this.o, nearByBean);
            this.mBindingComponent.getNearByViewHolder().A(this.p, nearByBean);
            this.mBindingComponent.getNearByViewHolder().H(this.q, nearByBean);
            this.mBindingComponent.getNearByViewHolder().z(this.s, j2);
            this.mBindingComponent.getNearByViewHolder().D(this.t, nearByBean);
            TextViewBindingAdapter.setText(this.u, str);
            this.u.setTextColor(colorFromResource2);
            this.w.setVisibility(i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.z != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.z = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.zenmen.square.databinding.LayoutSquareNearbyItemBinding
    public void p(@Nullable NearByBean nearByBean) {
        this.x = nearByBean;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(ko.g);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.g != i) {
            return false;
        }
        p((NearByBean) obj);
        return true;
    }

    public LayoutSquareNearbyItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LightingAnimationView) objArr[17], (FrameLayout) objArr[23], (LeftDrawableText) objArr[10], (FrameLayout) objArr[14], (ImageView) objArr[19], (ImageView) objArr[21], (ImageView) objArr[4], (ImageView) objArr[2], (TextView) objArr[13], (LXPortraitView) objArr[1], (TextView) objArr[12], (TextView) objArr[22], (TextView) objArr[11], (ImageView) objArr[20], (ImageView) objArr[6], (NearByFeedContainer) objArr[15], (RelativeLayout) objArr[7], (ConstraintLayout) objArr[16], (TextView) objArr[8], (TextView) objArr[3], (TextView) objArr[9], (FlexboxLayout) objArr[18], (TextView) objArr[5]);
        this.z = -1L;
        ensureBindingComponentIsNotNull(NearByViewHolder.class);
        this.c.setTag(null);
        this.d.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.m.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.y = frameLayout;
        frameLayout.setTag(null);
        this.q.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.w.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
