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
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.mvp.holder.FriendMessageViewHolder;
import com.zenmen.square.mvp.model.bean.PlaceFeed;
import defpackage.ko;
import defpackage.p64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutSquareFriendMsgItemBindingImpl extends LayoutSquareFriendMsgItemBinding implements p64.a {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts v = null;

    @Nullable
    public static final SparseIntArray w;

    @NonNull
    public final ImageView p;

    @Nullable
    public final View.OnClickListener q;

    @Nullable
    public final View.OnClickListener r;

    @Nullable
    public final View.OnClickListener s;

    @Nullable
    public final View.OnClickListener t;
    public long u;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        w = sparseIntArray;
        sparseIntArray.put(R$id.content_layout, 11);
        sparseIntArray.put(R$id.tv_delete, 12);
        sparseIntArray.put(R$id.feed_image, 13);
    }

    public LayoutSquareFriendMsgItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, v, w));
    }

    @Override // p64.a
    public final void a(int i, View view) {
        if (i == 1) {
            FriendMessageViewHolder friendMessageViewHolder = this.o;
            if (friendMessageViewHolder != null) {
                friendMessageViewHolder.onClick(view);
                return;
            }
            return;
        }
        if (i == 2) {
            FriendMessageViewHolder friendMessageViewHolder2 = this.o;
            if (friendMessageViewHolder2 != null) {
                friendMessageViewHolder2.onClick(view);
                return;
            }
            return;
        }
        if (i == 3) {
            FriendMessageViewHolder friendMessageViewHolder3 = this.o;
            if (friendMessageViewHolder3 != null) {
                friendMessageViewHolder3.onClick(view);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        FriendMessageViewHolder friendMessageViewHolder4 = this.o;
        if (friendMessageViewHolder4 != null) {
            friendMessageViewHolder4.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        int i;
        Comment comment;
        Feed feed;
        int i2;
        synchronized (this) {
            j = this.u;
            this.u = 0L;
        }
        PlaceFeed placeFeed = this.n;
        long j2 = j & 6;
        Drawable drawable = null;
        if (j2 != 0) {
            if (placeFeed != null) {
                comment = placeFeed.comment;
                feed = placeFeed.feed;
                i2 = placeFeed.sex;
            } else {
                comment = null;
                feed = null;
                i2 = 0;
            }
            String commentCreatorName = comment != null ? comment.getCommentCreatorName() : null;
            int feedType = feed != null ? feed.getFeedType() : 0;
            boolean z = i2 == 1;
            boolean z2 = i2 == -1;
            if (j2 != 0) {
                j |= z ? 16L : 8L;
            }
            if ((j & 6) != 0) {
                j |= z2 ? 64L : 32L;
            }
            Drawable drawable2 = AppCompatResources.getDrawable(this.p.getContext(), z ? R$drawable.icon_sex_female : R$drawable.icon_sex_male);
            i = z2 ? 8 : 0;
            i = feedType;
            str = commentCreatorName;
            drawable = drawable2;
        } else {
            str = null;
            i = 0;
        }
        if ((4 & j) != 0) {
            this.c.setOnClickListener(this.t);
            this.e.setOnClickListener(this.r);
            this.k.setOnClickListener(this.q);
            this.l.setOnClickListener(this.s);
        }
        if ((j & 6) != 0) {
            this.mBindingComponent.getFriendMessageViewHolder().q(this.c, placeFeed);
            this.mBindingComponent.getFriendMessageViewHolder().s(this.d, placeFeed);
            this.p.setVisibility(i);
            ImageViewBindingAdapter.setImageDrawable(this.p, drawable);
            this.mBindingComponent.getFriendMessageViewHolder().p(this.f, placeFeed);
            this.mBindingComponent.getFriendMessageViewHolder().t(this.h, placeFeed);
            TextViewBindingAdapter.setText(this.i, str);
            this.mBindingComponent.getFriendMessageViewHolder().r(this.j, placeFeed);
            this.mBindingComponent.getFriendMessageViewHolder().u(this.m, i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.u != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.u = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.zenmen.square.databinding.LayoutSquareFriendMsgItemBinding
    public void p(@Nullable PlaceFeed placeFeed) {
        this.n = placeFeed;
        synchronized (this) {
            this.u |= 2;
        }
        notifyPropertyChanged(ko.f18729a);
        super.requestRebind();
    }

    @Override // com.zenmen.square.databinding.LayoutSquareFriendMsgItemBinding
    public void q(@Nullable FriendMessageViewHolder friendMessageViewHolder) {
        this.o = friendMessageViewHolder;
        synchronized (this) {
            this.u |= 1;
        }
        notifyPropertyChanged(ko.c);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.c == i) {
            q((FriendMessageViewHolder) obj);
        } else {
            if (ko.f18729a != i) {
                return false;
            }
            p((PlaceFeed) obj);
        }
        return true;
    }

    public LayoutSquareFriendMsgItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[11], (RelativeLayout) objArr[13], (EffectiveShapeView) objArr[1], (EffectiveShapeView) objArr[8], (ConstraintLayout) objArr[0], (TextView) objArr[10], (TextView) objArr[12], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[7], (ImageView) objArr[9]);
        this.u = -1L;
        ensureBindingComponentIsNotNull(FriendMessageViewHolder.class);
        this.c.setTag(null);
        this.d.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.p = imageView;
        imageView.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        setRootTag(view);
        this.q = new p64(this, 3);
        this.r = new p64(this, 1);
        this.s = new p64(this, 4);
        this.t = new p64(this, 2);
        invalidateAll();
    }
}
