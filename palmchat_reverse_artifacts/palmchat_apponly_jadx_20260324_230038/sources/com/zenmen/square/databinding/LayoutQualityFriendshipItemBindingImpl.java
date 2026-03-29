package com.zenmen.square.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.widget.FlowLayout;
import com.zenmen.square.R$id;
import com.zenmen.square.mvp.holder.QualityFriendShipViewHolder;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.ko;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutQualityFriendshipItemBindingImpl extends LayoutQualityFriendshipItemBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts o = null;

    @Nullable
    public static final SparseIntArray p;

    @NonNull
    public final FrameLayout l;

    @NonNull
    public final LeftDrawableText m;
    public long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R$id.root_content, 10);
        sparseIntArray.put(R$id.iv_qf_avatar_container, 11);
    }

    public LayoutQualityFriendshipItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, o, p));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        NearByBean.Extra extra;
        synchronized (this) {
            j = this.n;
            this.n = 0L;
        }
        NearByBean nearByBean = this.k;
        long j2 = j & 3;
        if (j2 != 0) {
            if (nearByBean != null) {
                str = nearByBean.nickname;
                str4 = nearByBean.avatar;
                i2 = nearByBean.onlineStatusCode;
                i = nearByBean.age;
                extra = nearByBean.extra;
            } else {
                str = null;
                str4 = null;
                i2 = 0;
                i = 0;
                extra = null;
            }
            boolean z = i2 == 1;
            if (j2 != 0) {
                j |= z ? 8L : 4L;
            }
            String str5 = extra != null ? extra.desc : null;
            i = z ? 0 : 8;
            str3 = str4;
            str2 = str5;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            i = 0;
        }
        if ((j & 3) != 0) {
            this.mBindingComponent.getQualityFriendShipViewHolder().w(this.f16225a, nearByBean);
            this.b.setVisibility(i);
            this.mBindingComponent.getQualityFriendShipViewHolder().s(this.c, str3);
            this.mBindingComponent.getQualityFriendShipViewHolder().r(this.m, i);
            this.mBindingComponent.getQualityFriendShipViewHolder().v(this.f, nearByBean);
            this.mBindingComponent.getQualityFriendShipViewHolder().p(this.g, nearByBean);
            this.mBindingComponent.getQualityFriendShipViewHolder().t(this.h, nearByBean);
            TextViewBindingAdapter.setText(this.i, str);
            TextViewBindingAdapter.setText(this.j, str2);
            this.mBindingComponent.getQualityFriendShipViewHolder().u(this.j, nearByBean);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.zenmen.square.databinding.LayoutQualityFriendshipItemBinding
    public void p(@Nullable NearByBean nearByBean) {
        this.k = nearByBean;
        synchronized (this) {
            this.n |= 1;
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

    public LayoutQualityFriendshipItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LeftDrawableText) objArr[7], (ImageView) objArr[9], (ImageView) objArr[8], (FrameLayout) objArr[11], (ConstraintLayout) objArr[10], (FlowLayout) objArr[4], (LeftDrawableText) objArr[6], (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[5]);
        this.n = -1L;
        ensureBindingComponentIsNotNull(QualityFriendShipViewHolder.class);
        this.f16225a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.l = frameLayout;
        frameLayout.setTag(null);
        LeftDrawableText leftDrawableText = (LeftDrawableText) objArr[2];
        this.m = leftDrawableText;
        leftDrawableText.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
