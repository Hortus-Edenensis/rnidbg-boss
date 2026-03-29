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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.mvp.holder.NestTopicFeedViewHolder;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.ko;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutSquareNestTopicFeedItemBindingImpl extends LayoutSquareNestTopicFeedItemBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts o = null;

    @Nullable
    public static final SparseIntArray p;

    @NonNull
    public final ConstraintLayout m;
    public long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R$id.iv_feed_pic, 4);
        sparseIntArray.put(R$id.square_video_play_btn, 5);
        sparseIntArray.put(R$id.nest_topic_item_cover, 6);
        sparseIntArray.put(R$id.bottom_info, 7);
        sparseIntArray.put(R$id.iv_feed_location_icon, 8);
        sparseIntArray.put(R$id.tv_feed_location_label, 9);
        sparseIntArray.put(R$id.tv_feed_create_time_detail, 10);
        sparseIntArray.put(R$id.tv_feed_content_desc, 11);
    }

    public LayoutSquareNestTopicFeedItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, o, p));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        int i;
        Context context;
        int i2;
        synchronized (this) {
            j = this.n;
            this.n = 0L;
        }
        SquareFeed squareFeed = this.l;
        long j2 = j & 3;
        String str = null;
        List<Media> list = null;
        if (j2 != 0) {
            if (squareFeed != null) {
                list = squareFeed.mediaList;
                i = squareFeed.sex;
            } else {
                i = 0;
            }
            int size = list != null ? list.size() : 0;
            boolean z = i == 1;
            if (j2 != 0) {
                j |= z ? 8L : 4L;
            }
            boolean z2 = size > 1;
            String strValueOf = String.valueOf(size);
            if (z) {
                context = this.g.getContext();
                i2 = R$drawable.icon_sex_female;
            } else {
                context = this.g.getContext();
                i2 = R$drawable.icon_sex_male;
            }
            drawable = AppCompatResources.getDrawable(context, i2);
            if ((j & 3) != 0) {
                j |= z2 ? 32L : 16L;
            }
            i = z2 ? 0 : 4;
            str = strValueOf;
        } else {
            drawable = null;
        }
        if ((j & 3) != 0) {
            this.d.setVisibility(i);
            TextViewBindingAdapter.setText(this.d, str);
            this.mBindingComponent.getNestTopicFeedViewHolder().t(this.m, squareFeed);
            this.mBindingComponent.getNestTopicFeedViewHolder().s(this.f, squareFeed);
            ImageViewBindingAdapter.setImageDrawable(this.g, drawable);
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

    @Override // com.zenmen.square.databinding.LayoutSquareNestTopicFeedItemBinding
    public void p(@Nullable SquareFeed squareFeed) {
        this.l = squareFeed;
        synchronized (this) {
            this.n |= 1;
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

    public LayoutSquareNestTopicFeedItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RelativeLayout) objArr[7], (ImageView) objArr[8], (EffectiveShapeView) objArr[4], (LeftDrawableText) objArr[3], (View) objArr[6], (ConstraintLayout) objArr[1], (ImageView) objArr[2], (ImageView) objArr[5], (AppCompatTextView) objArr[11], (TextView) objArr[10], (TextView) objArr[9]);
        this.n = -1L;
        ensureBindingComponentIsNotNull(NestTopicFeedViewHolder.class);
        this.d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.m = constraintLayout;
        constraintLayout.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
