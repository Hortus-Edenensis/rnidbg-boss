package com.zenmen.square.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.mvp.holder.NestTagHeaderViewHolder;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.ui.widget.NestTagInfoView;
import defpackage.ko;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutNestTagHeaderViewBindingImpl extends LayoutNestTagHeaderViewBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts l = null;

    @Nullable
    public static final SparseIntArray m;

    @NonNull
    public final RelativeLayout j;
    public long k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R$id.btn_private_chat, 8);
    }

    public LayoutNestTagHeaderViewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, l, m));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        ContactInfoItem contactInfoItem;
        SquareTagBean squareTagBean;
        Drawable drawable;
        String signature;
        String nameForShow;
        int gender;
        Context context;
        int i;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        SquareFeed squareFeed = this.i;
        long j2 = j & 3;
        String age = null;
        if (j2 != 0) {
            if (squareFeed != null) {
                squareTagBean = squareFeed.squareTagBean;
                contactInfoItem = squareFeed.contactInfoItem;
            } else {
                contactInfoItem = null;
                squareTagBean = null;
            }
            if (contactInfoItem != null) {
                age = contactInfoItem.getAge();
                signature = contactInfoItem.getSignature();
                nameForShow = contactInfoItem.getNameForShow();
                gender = contactInfoItem.getGender();
            } else {
                signature = null;
                nameForShow = null;
                gender = 0;
            }
            boolean z = gender == 1;
            if (j2 != 0) {
                j |= z ? 8L : 4L;
            }
            if (z) {
                context = this.d.getContext();
                i = R$drawable.icon_sex_female;
            } else {
                context = this.d.getContext();
                i = R$drawable.icon_sex_male;
            }
            drawable = AppCompatResources.getDrawable(context, i);
        } else {
            contactInfoItem = null;
            squareTagBean = null;
            drawable = null;
            signature = null;
            nameForShow = null;
        }
        if ((j & 3) != 0) {
            NestTagHeaderViewHolder.r(this.f16223a, age);
            NestTagHeaderViewHolder.t(this.c, contactInfoItem);
            ImageViewBindingAdapter.setImageDrawable(this.d, drawable);
            TextViewBindingAdapter.setText(this.e, nameForShow);
            NestTagHeaderViewHolder.s(this.f, contactInfoItem);
            NestTagHeaderViewHolder.v(this.g, squareTagBean);
            NestTagHeaderViewHolder.u(this.h, signature);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.zenmen.square.databinding.LayoutNestTagHeaderViewBinding
    public void p(@Nullable SquareFeed squareFeed) {
        this.i = squareFeed;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(ko.d);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.d != i) {
            return false;
        }
        p((SquareFeed) obj);
        return true;
    }

    public LayoutNestTagHeaderViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[5], (ImageView) objArr[2], (TextView) objArr[3], (EffectiveShapeView) objArr[1], (NestTagInfoView) objArr[7], (TextView) objArr[6]);
        this.k = -1L;
        this.f16223a.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.j = relativeLayout;
        relativeLayout.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
