package com.zenmen.square.databinding;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.zenmen.listui.widget.LeftDrawableText;
import com.zenmen.palmchat.ui.widget.commentwidget.CommentContentsLayout;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$string;
import com.zenmen.square.mvp.holder.FeedViewHolder;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.view.widget.FeedItemMultiPicView;
import com.zenmen.square.mvp.view.widget.FeedItemVenusView;
import com.zenmen.square.ui.widget.ExpandableTextView;
import com.zenmen.square.ui.widget.SquareItemVideoView;
import defpackage.ko;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedLayoutItemViewBindingImpl extends FeedLayoutItemViewBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts e0 = null;

    @Nullable
    public static final SparseIntArray f0;

    @NonNull
    public final ConstraintLayout Y;
    public long Z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f0 = sparseIntArray;
        sparseIntArray.put(R$id.feed_item_head, 27);
        sparseIntArray.put(R$id.rl_super_expose_item_enter, 28);
        sparseIntArray.put(R$id.iv_super_expose_item_enter_arrow, 29);
        sparseIntArray.put(R$id.iv_feed_more, 30);
        sparseIntArray.put(R$id.iv_wishes_icon, 31);
        sparseIntArray.put(R$id.tv_wishes_content, 32);
        sparseIntArray.put(R$id.anchor, 33);
        sparseIntArray.put(R$id.ll_tag, 34);
        sparseIntArray.put(R$id.tv_text_only_location, 35);
        sparseIntArray.put(R$id.rl_media_area, 36);
        sparseIntArray.put(R$id.iv_feed_location_icon, 37);
        sparseIntArray.put(R$id.tv_feed_location_label, 38);
        sparseIntArray.put(R$id.tv_feed_create_time_detail, 39);
        sparseIntArray.put(R$id.iv_btn_comment_feed, 40);
        sparseIntArray.put(R$id.layout_feed_praise, 41);
        sparseIntArray.put(R$id.layout_feed_comment_content, 42);
        sparseIntArray.put(R$id.rl_praise_guide, 43);
        sparseIntArray.put(R$id.rl_praise_guide_bubble, 44);
        sparseIntArray.put(R$id.tv_praise_guide, 45);
        sparseIntArray.put(R$id.arrow_guide, 46);
        sparseIntArray.put(R$id.rl_say_hi_guide, 47);
        sparseIntArray.put(R$id.tv_say_hi_guide, 48);
    }

    public FeedLayoutItemViewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 49, e0, f0));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        Drawable drawable;
        String str3;
        Drawable drawable2;
        String str4;
        String str5;
        String str6;
        String praiseCountShow;
        double d;
        int i;
        boolean z;
        int i2;
        int i3;
        long j3;
        int i4;
        int i5;
        String commentCountShow;
        String str7;
        String str8;
        String str9;
        String str10;
        double d2;
        boolean z2;
        int i6;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean zIsFriend;
        boolean z6;
        long j4;
        String str11;
        Resources resources;
        int i7;
        Context context;
        int i8;
        long j5;
        long j6;
        long j7;
        long j8;
        synchronized (this) {
            j = this.Z;
            this.Z = 0L;
        }
        SquareFeed squareFeed = this.X;
        long j9 = j & 3;
        Drawable drawable3 = null;
        String str12 = null;
        if (j9 != 0) {
            if (squareFeed != null) {
                String str13 = squareFeed.city;
                String str14 = squareFeed.topicName;
                str8 = squareFeed.year;
                commentCountShow = squareFeed.getCommentCountShow();
                zIsFriend = squareFeed.isFriend();
                z6 = squareFeed.showBigDate;
                z5 = squareFeed.hiddenDiscussion;
                String str15 = squareFeed.month;
                long createTime = squareFeed.getCreateTime();
                boolean ifLike = squareFeed.getIfLike();
                double d3 = squareFeed.distance;
                str9 = str15;
                int i9 = squareFeed.sex;
                String str16 = squareFeed.day;
                boolean zCanDelete = squareFeed.canDelete();
                praiseCountShow = squareFeed.getPraiseCountShow();
                str10 = str16;
                z2 = squareFeed.official;
                z3 = ifLike;
                str7 = str13;
                i6 = i9;
                str12 = str14;
                z4 = zCanDelete;
                j4 = createTime;
                d2 = d3;
            } else {
                str7 = null;
                str8 = null;
                str9 = null;
                praiseCountShow = null;
                str10 = null;
                d2 = 0.0d;
                z2 = false;
                i6 = 0;
                z3 = false;
                z4 = false;
                z5 = false;
                zIsFriend = false;
                z6 = false;
                j4 = 0;
                commentCountShow = null;
            }
            if (j9 != 0) {
                if (zIsFriend) {
                    j7 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    j8 = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                } else {
                    j7 = j | 16384;
                    j8 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                }
                j = j7 | j8;
            }
            if ((j & 3) != 0) {
                j |= z5 ? 2048L : 1024L;
            }
            if ((j & 3) != 0) {
                j |= z3 ? 512L : 256L;
            }
            if ((j & 3) != 0) {
                if (z4) {
                    j5 = j | 128;
                    j6 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                } else {
                    j5 = j | 64;
                    j6 = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                }
                j = j5 | j6;
            }
            if ((j & 3) != 0) {
                j |= z2 ? 32L : 16L;
            }
            boolean zIsEmpty = TextUtils.isEmpty(str12);
            String str17 = str7;
            if (zIsFriend) {
                resources = this.P.getResources();
                str11 = str8;
                i7 = R$string.square_btn_go_priv_chat;
            } else {
                str11 = str8;
                resources = this.P.getResources();
                i7 = R$string.square_btn_go_say_hi;
            }
            String string = resources.getString(i7);
            Drawable drawable4 = AppCompatResources.getDrawable(this.f.getContext(), zIsFriend ? R$drawable.icon_message_hi_left : R$drawable.icon_say_hi_left);
            int i10 = z5 ? 8 : 0;
            if (z3) {
                context = this.g.getContext();
                i8 = R$drawable.icon_praise_selected_new;
            } else {
                context = this.g.getContext();
                i8 = R$drawable.icon_praise_none_new;
            }
            drawable = AppCompatResources.getDrawable(context, i8);
            boolean z7 = i6 == 1;
            int i11 = z4 ? 0 : 4;
            int i12 = z4 ? 4 : 0;
            int i13 = z2 ? 0 : 8;
            if ((j & 3) != 0) {
                j |= zIsEmpty ? 8L : 4L;
            }
            if ((j & 3) != 0) {
                j |= z7 ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : 4096L;
            }
            int i14 = zIsEmpty ? 8 : 0;
            drawable2 = AppCompatResources.getDrawable(this.l.getContext(), z7 ? R$drawable.icon_sex_female : R$drawable.icon_sex_male);
            i4 = i13;
            i2 = i10;
            z = z6;
            i5 = i14;
            j3 = j4;
            str = str10;
            str6 = str17;
            i = i11;
            i3 = i12;
            str5 = str12;
            str2 = str9;
            drawable3 = drawable4;
            d = d2;
            j2 = 3;
            str4 = string;
            str3 = str11;
        } else {
            j2 = 3;
            str = null;
            str2 = null;
            drawable = null;
            str3 = null;
            drawable2 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            praiseCountShow = null;
            d = 0.0d;
            i = 0;
            z = false;
            i2 = 0;
            i3 = 0;
            j3 = 0;
            i4 = 0;
            i5 = 0;
            commentCountShow = null;
        }
        if ((j & j2) != 0) {
            this.mBindingComponent.getFeedViewHolder().H(this.d, squareFeed);
            ImageViewBindingAdapter.setImageDrawable(this.f, drawable3);
            ImageViewBindingAdapter.setImageDrawable(this.g, drawable);
            this.mBindingComponent.getFeedViewHolder().w(this.h, squareFeed);
            this.mBindingComponent.getFeedViewHolder().z(this.k, squareFeed);
            ImageViewBindingAdapter.setImageDrawable(this.l, drawable2);
            this.mBindingComponent.getFeedViewHolder().y(this.m, squareFeed);
            this.mBindingComponent.getFeedViewHolder().C(this.n, squareFeed);
            this.mBindingComponent.getFeedViewHolder().L(this.p, squareFeed);
            this.r.setVisibility(i2);
            this.t.setVisibility(i3);
            this.mBindingComponent.getFeedViewHolder().M(this.x, squareFeed);
            this.mBindingComponent.getFeedViewHolder().x(this.Y, z);
            this.mBindingComponent.getFeedViewHolder().I(this.y, squareFeed);
            TextViewBindingAdapter.setText(this.F, commentCountShow);
            this.G.setVisibility(i);
            this.mBindingComponent.getFeedViewHolder().F(this.H, squareFeed);
            this.mBindingComponent.getFeedViewHolder().J(this.I, j3, d, str6);
            TextViewBindingAdapter.setText(this.K, str);
            TextViewBindingAdapter.setText(this.M, str2);
            this.mBindingComponent.getFeedViewHolder().G(this.N, squareFeed);
            TextViewBindingAdapter.setText(this.O, str3);
            TextViewBindingAdapter.setText(this.P, str4);
            this.Q.setVisibility(i4);
            TextViewBindingAdapter.setText(this.R, praiseCountShow);
            this.V.setVisibility(i5);
            this.mBindingComponent.getFeedViewHolder().K(this.V, str5);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.Z != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.Z = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.zenmen.square.databinding.FeedLayoutItemViewBinding
    public void p(@Nullable SquareFeed squareFeed) {
        this.X = squareFeed;
        synchronized (this) {
            this.Z |= 1;
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

    public FeedLayoutItemViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[33], (ImageView) objArr[46], (ConstraintLayout) objArr[27], (ImageView) objArr[2], (ImageView) objArr[40], (ImageView) objArr[25], (ImageView) objArr[22], (LXPortraitView) objArr[1], (ImageView) objArr[37], (ImageView) objArr[30], (FeedItemMultiPicView) objArr[12], (ImageView) objArr[4], (FeedItemVenusView) objArr[14], (SquareItemVideoView) objArr[13], (ImageView) objArr[29], (ImageView) objArr[6], (ImageView) objArr[31], (RelativeLayout) objArr[20], (CommentContentsLayout) objArr[42], (RelativeLayout) objArr[24], (RelativeLayout) objArr[41], (ConstraintLayout) objArr[0], (LinearLayout) objArr[34], (LinearLayout) objArr[9], (ConstraintLayout) objArr[15], (RelativeLayout) objArr[36], (RelativeLayout) objArr[43], (RelativeLayout) objArr[44], (RelativeLayout) objArr[47], (RelativeLayout) objArr[28], (TextView) objArr[21], (TextView) objArr[8], (ExpandableTextView) objArr[10], (TextView) objArr[7], (TextView) objArr[39], (TextView) objArr[17], (TextView) objArr[38], (TextView) objArr[18], (TextView) objArr[3], (TextView) objArr[19], (TextView) objArr[26], (TextView) objArr[5], (TextView) objArr[23], (TextView) objArr[45], (TextView) objArr[48], (LeftDrawableText) objArr[35], (LeftDrawableText) objArr[11], (TextView) objArr[32]);
        this.Z = -1L;
        ensureBindingComponentIsNotNull(FeedViewHolder.class);
        this.d.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.p.setTag(null);
        this.r.setTag(null);
        this.t.setTag(null);
        this.v.setTag(null);
        this.x.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[16];
        this.Y = constraintLayout;
        constraintLayout.setTag(null);
        this.y.setTag(null);
        this.F.setTag(null);
        this.G.setTag(null);
        this.H.setTag(null);
        this.I.setTag(null);
        this.K.setTag(null);
        this.M.setTag(null);
        this.N.setTag(null);
        this.O.setTag(null);
        this.P.setTag(null);
        this.Q.setTag(null);
        this.R.setTag(null);
        this.V.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
