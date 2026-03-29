package com.zenmen.square.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
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
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.mvp.holder.SquareInteractViewHolder;
import com.zenmen.square.mvp.model.bean.SquareInteractBean;
import com.zenmen.square.mvp.model.bean.SquareInteractDetail;
import com.zenmen.square.ui.widget.InteractNestImageContainer;
import defpackage.ko;
import defpackage.p64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutSquareInteractItemBindingImpl extends LayoutSquareInteractItemBinding implements p64.a {

    @Nullable
    public static final SparseIntArray A;

    @Nullable
    public static final ViewDataBinding.IncludedLayouts z = null;

    @NonNull
    public final ImageView r;

    @NonNull
    public final TextView s;

    @Nullable
    public final View.OnClickListener t;

    @Nullable
    public final View.OnClickListener u;

    @Nullable
    public final View.OnClickListener v;

    @Nullable
    public final View.OnClickListener w;

    @Nullable
    public final View.OnClickListener x;
    public long y;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R$id.content_layout, 14);
        sparseIntArray.put(R$id.tv_delete, 15);
        sparseIntArray.put(R$id.ll_nest_avatar_container, 16);
    }

    public LayoutSquareInteractItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, z, A));
    }

    @Override // p64.a
    public final void a(int i, View view) {
        if (i == 1) {
            SquareInteractViewHolder squareInteractViewHolder = this.q;
            if (squareInteractViewHolder != null) {
                squareInteractViewHolder.onClick(view);
                return;
            }
            return;
        }
        if (i == 2) {
            SquareInteractViewHolder squareInteractViewHolder2 = this.q;
            if (squareInteractViewHolder2 != null) {
                squareInteractViewHolder2.onClick(view);
                return;
            }
            return;
        }
        if (i == 3) {
            SquareInteractViewHolder squareInteractViewHolder3 = this.q;
            if (squareInteractViewHolder3 != null) {
                squareInteractViewHolder3.onClick(view);
                return;
            }
            return;
        }
        if (i == 4) {
            SquareInteractViewHolder squareInteractViewHolder4 = this.q;
            if (squareInteractViewHolder4 != null) {
                squareInteractViewHolder4.onClick(view);
                return;
            }
            return;
        }
        if (i != 5) {
            return;
        }
        SquareInteractViewHolder squareInteractViewHolder5 = this.q;
        if (squareInteractViewHolder5 != null) {
            squareInteractViewHolder5.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        String str;
        int i;
        int i2;
        SquareInteractDetail squareInteractDetail;
        boolean z2;
        String str2;
        int i3;
        int i4;
        synchronized (this) {
            j = this.y;
            this.y = 0L;
        }
        SquareInteractBean squareInteractBean = this.p;
        long j2 = j & 6;
        String str3 = null;
        if (j2 != 0) {
            if (squareInteractBean != null) {
                squareInteractDetail = squareInteractBean.singleInteract;
                z2 = squareInteractBean.ifAggregation;
            } else {
                squareInteractDetail = null;
                z2 = false;
            }
            if (j2 != 0) {
                j |= z2 ? 256L : 128L;
            }
            if (squareInteractDetail != null) {
                str3 = squareInteractDetail.nickname;
                str2 = squareInteractDetail.headImgUrl;
                i4 = squareInteractDetail.feedType;
                i3 = squareInteractDetail.sex;
            } else {
                str2 = null;
                i3 = 0;
                i4 = 0;
            }
            int i5 = z2 ? 8 : 0;
            boolean z3 = i4 == 3;
            boolean z4 = i3 == 1;
            if ((j & 6) != 0) {
                j |= z3 ? 64L : 32L;
            }
            if ((j & 6) != 0) {
                j |= z4 ? 16L : 8L;
            }
            int i6 = z3 ? 0 : 8;
            drawable = AppCompatResources.getDrawable(this.r.getContext(), z4 ? R$drawable.icon_sex_female : R$drawable.icon_sex_male);
            i = i5;
            str = str3;
            str3 = str2;
            i2 = i6;
        } else {
            drawable = null;
            str = null;
            i = 0;
            i2 = 0;
        }
        if ((4 & j) != 0) {
            this.b.setOnClickListener(this.u);
            this.d.setOnClickListener(this.x);
            this.g.setOnClickListener(this.t);
            this.m.setOnClickListener(this.v);
            this.n.setOnClickListener(this.w);
        }
        if ((j & 6) != 0) {
            this.mBindingComponent.getSquareInteractViewHolder().t(this.c, squareInteractBean);
            this.mBindingComponent.getSquareInteractViewHolder().p(this.d, str3);
            this.mBindingComponent.getSquareInteractViewHolder().x(this.e, squareInteractBean);
            ImageViewBindingAdapter.setImageDrawable(this.r, drawable);
            this.mBindingComponent.getSquareInteractViewHolder().r(this.s, squareInteractBean);
            this.mBindingComponent.getSquareInteractViewHolder().s(this.h, squareInteractBean);
            this.mBindingComponent.getSquareInteractViewHolder().q(this.j, squareInteractBean);
            TextViewBindingAdapter.setText(this.k, str);
            this.mBindingComponent.getSquareInteractViewHolder().w(this.l, squareInteractBean);
            this.mBindingComponent.getSquareInteractViewHolder().u(this.m, squareInteractBean);
            this.n.setVisibility(i);
            this.mBindingComponent.getSquareInteractViewHolder().v(this.n, squareInteractBean);
            this.o.setVisibility(i2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.y != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.y = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.zenmen.square.databinding.LayoutSquareInteractItemBinding
    public void p(@Nullable SquareInteractBean squareInteractBean) {
        this.p = squareInteractBean;
        synchronized (this) {
            this.y |= 2;
        }
        notifyPropertyChanged(ko.f18729a);
        super.requestRebind();
    }

    @Override // com.zenmen.square.databinding.LayoutSquareInteractItemBinding
    public void q(@Nullable SquareInteractViewHolder squareInteractViewHolder) {
        this.q = squareInteractViewHolder;
        synchronized (this) {
            this.y |= 1;
        }
        notifyPropertyChanged(ko.c);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.c == i) {
            q((SquareInteractViewHolder) obj);
        } else {
            if (ko.f18729a != i) {
                return false;
            }
            p((SquareInteractBean) obj);
        }
        return true;
    }

    public LayoutSquareInteractItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[14], (RelativeLayout) objArr[10], (HorizontalScrollView) objArr[6], (EffectiveShapeView) objArr[1], (EffectiveShapeView) objArr[11], (InteractNestImageContainer) objArr[16], (ConstraintLayout) objArr[0], (TextView) objArr[13], (TextView) objArr[15], (TextView) objArr[7], (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[9], (ImageView) objArr[12]);
        this.y = -1L;
        ensureBindingComponentIsNotNull(SquareInteractViewHolder.class);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.r = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.s = textView;
        textView.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        setRootTag(view);
        this.t = new p64(this, 1);
        this.u = new p64(this, 5);
        this.v = new p64(this, 3);
        this.w = new p64(this, 4);
        this.x = new p64(this, 2);
        invalidateAll();
    }
}
