package com.zenmen.square.databinding;

import android.graphics.drawable.Drawable;
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
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.show.DYPageIndicator;
import com.zenmen.square.show.FeedShowDetailFragment;
import com.zenmen.square.ui.widget.DoubleClickView;
import com.zenmen.square.ui.widget.ExpandableTextView;
import com.zenmen.square.ui.widget.LoopingSquareHackyViewPager;
import defpackage.ko;
import defpackage.p64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutSquareShowMediaViewBindingImpl extends LayoutSquareShowMediaViewBinding implements p64.a {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts k0 = null;

    @Nullable
    public static final SparseIntArray l0;

    @NonNull
    public final ImageView S;

    @NonNull
    public final TextView T;

    @Nullable
    public final View.OnClickListener U;

    @Nullable
    public final View.OnClickListener V;

    @Nullable
    public final View.OnClickListener W;

    @Nullable
    public final View.OnClickListener X;

    @Nullable
    public final View.OnClickListener Y;

    @Nullable
    public final View.OnClickListener Z;

    @Nullable
    public final View.OnClickListener e0;

    @Nullable
    public final View.OnClickListener f0;

    @Nullable
    public final View.OnClickListener g0;

    @Nullable
    public final View.OnClickListener h0;

    @Nullable
    public final View.OnClickListener i0;
    public long j0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l0 = sparseIntArray;
        sparseIntArray.put(R$id.feed_media_viewpager, 21);
        sparseIntArray.put(R$id.v_feed_detail_cover, 22);
        sparseIntArray.put(R$id.infoLayout, 23);
        sparseIntArray.put(R$id.rl_feed_detail_bottom, 24);
        sparseIntArray.put(R$id.bottom_page_indicator, 25);
        sparseIntArray.put(R$id.rl_location_time_gallery, 26);
        sparseIntArray.put(R$id.iv_feed_location_icon, 27);
        sparseIntArray.put(R$id.tv_feed_location_label, 28);
        sparseIntArray.put(R$id.tv_feed_time_label, 29);
        sparseIntArray.put(R$id.iv_btn_comment_feed_b, 30);
        sparseIntArray.put(R$id.layout_feed_detail_praise_b, 31);
        sparseIntArray.put(R$id.cl_userinfo_b, 32);
        sparseIntArray.put(R$id.ll_content_location_second, 33);
        sparseIntArray.put(R$id.rl_location_time_second, 34);
        sparseIntArray.put(R$id.iv_feed_location_icon_second, 35);
        sparseIntArray.put(R$id.tv_feed_location_label_second, 36);
        sparseIntArray.put(R$id.tv_feed_time_label_second, 37);
        sparseIntArray.put(R$id.feed_detail_title_bar, 38);
        sparseIntArray.put(R$id.title_bar, 39);
        sparseIntArray.put(R$id.tv_page_indicator, 40);
        sparseIntArray.put(R$id.iv_wishes_icon, 41);
        sparseIntArray.put(R$id.tv_wishes_content, 42);
    }

    public LayoutSquareShowMediaViewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 43, k0, l0));
    }

    @Override // p64.a
    public final void a(int i, View view) {
        switch (i) {
            case 1:
                FeedShowDetailFragment feedShowDetailFragment = this.R;
                if (feedShowDetailFragment != null) {
                    feedShowDetailFragment.e1(view);
                }
                break;
            case 2:
                FeedShowDetailFragment feedShowDetailFragment2 = this.R;
                if (feedShowDetailFragment2 != null) {
                    feedShowDetailFragment2.e1(view);
                }
                break;
            case 3:
                FeedShowDetailFragment feedShowDetailFragment3 = this.R;
                if (feedShowDetailFragment3 != null) {
                    feedShowDetailFragment3.e1(view);
                }
                break;
            case 4:
                FeedShowDetailFragment feedShowDetailFragment4 = this.R;
                if (feedShowDetailFragment4 != null) {
                    feedShowDetailFragment4.e1(view);
                }
                break;
            case 5:
                FeedShowDetailFragment feedShowDetailFragment5 = this.R;
                if (feedShowDetailFragment5 != null) {
                    feedShowDetailFragment5.e1(view);
                }
                break;
            case 6:
                FeedShowDetailFragment feedShowDetailFragment6 = this.R;
                if (feedShowDetailFragment6 != null) {
                    feedShowDetailFragment6.e1(view);
                }
                break;
            case 7:
                FeedShowDetailFragment feedShowDetailFragment7 = this.R;
                if (feedShowDetailFragment7 != null) {
                    feedShowDetailFragment7.e1(view);
                }
                break;
            case 8:
                FeedShowDetailFragment feedShowDetailFragment8 = this.R;
                if (feedShowDetailFragment8 != null) {
                    feedShowDetailFragment8.onArrowPress(view);
                }
                break;
            case 9:
                FeedShowDetailFragment feedShowDetailFragment9 = this.R;
                if (feedShowDetailFragment9 != null) {
                    feedShowDetailFragment9.onArrowPress(view);
                }
                break;
            case 10:
                FeedShowDetailFragment feedShowDetailFragment10 = this.R;
                if (feedShowDetailFragment10 != null) {
                    feedShowDetailFragment10.e1(view);
                }
                break;
            case 11:
                FeedShowDetailFragment feedShowDetailFragment11 = this.R;
                if (feedShowDetailFragment11 != null) {
                    feedShowDetailFragment11.e1(view);
                }
                break;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        Drawable drawable2;
        String str;
        String commentCountShow;
        String str2;
        int i;
        int i2;
        int i3;
        long j2;
        String str3;
        String praiseCountShow;
        boolean z;
        int i4;
        boolean z2;
        long createTime;
        boolean ifLike;
        synchronized (this) {
            j = this.j0;
            this.j0 = 0L;
        }
        SquareFeed squareFeed = this.Q;
        long j3 = 5;
        long j4 = j & 5;
        String str4 = null;
        if (j4 != 0) {
            if (squareFeed != null) {
                str4 = squareFeed.headImgUrl;
                str3 = squareFeed.topicName;
                commentCountShow = squareFeed.getCommentCountShow();
                i2 = squareFeed.tagId;
                z2 = squareFeed.hiddenDiscussion;
                createTime = squareFeed.getCreateTime();
                ifLike = squareFeed.getIfLike();
                i4 = squareFeed.sex;
                praiseCountShow = squareFeed.getPraiseCountShow();
                z = squareFeed.official;
            } else {
                str3 = null;
                commentCountShow = null;
                praiseCountShow = null;
                z = false;
                i4 = 0;
                i2 = 0;
                z2 = false;
                createTime = 0;
                ifLike = false;
            }
            if (j4 != 0) {
                j |= z2 ? 256L : 128L;
            }
            if ((j & 5) != 0) {
                j |= ifLike ? 1024L : 512L;
            }
            if ((j & 5) != 0) {
                j |= z ? 16L : 8L;
            }
            i = z2 ? 8 : 0;
            drawable2 = ifLike ? AppCompatResources.getDrawable(this.l.getContext(), R$drawable.icon_praise_feeddetail_selected_new) : AppCompatResources.getDrawable(this.l.getContext(), R$drawable.icon_praise_feeddetail_none_white_new);
            boolean z3 = i4 == 1;
            int i5 = z ? 0 : 8;
            if ((j & 5) != 0) {
                j |= z3 ? 64L : 32L;
            }
            drawable = AppCompatResources.getDrawable(this.S.getContext(), z3 ? R$drawable.icon_sex_female : R$drawable.icon_sex_male);
            i3 = i5;
            j2 = createTime;
            str2 = str3;
            str = praiseCountShow;
        } else {
            drawable = null;
            drawable2 = null;
            str = null;
            commentCountShow = null;
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            j2 = 0;
        }
        if ((4 & j) != 0) {
            this.b.setOnClickListener(this.W);
            this.g.setOnClickListener(this.U);
            this.i.setOnClickListener(this.X);
            this.j.setOnClickListener(this.i0);
            this.l.setOnClickListener(this.g0);
            this.o.setOnClickListener(this.Y);
            this.r.setOnClickListener(this.e0);
            this.v.setOnClickListener(this.Z);
            this.F.setOnClickListener(this.V);
            this.G.setOnClickListener(this.h0);
            this.L.setOnClickListener(this.f0);
            j3 = 5;
        }
        if ((j & j3) != 0) {
            this.mBindingComponent.getFeedShowDetailFragment().M0(this.g, str4);
            ImageViewBindingAdapter.setImageDrawable(this.l, drawable2);
            this.mBindingComponent.getFeedShowDetailFragment().s1(this.p, squareFeed);
            this.r.setVisibility(i);
            this.mBindingComponent.getFeedShowDetailFragment().l1(this.t, squareFeed);
            this.mBindingComponent.getFeedShowDetailFragment().g1(this.v, squareFeed);
            ImageViewBindingAdapter.setImageDrawable(this.S, drawable);
            this.mBindingComponent.getFeedShowDetailFragment().n1(this.T, j2);
            TextViewBindingAdapter.setText(this.A, commentCountShow);
            this.mBindingComponent.getFeedShowDetailFragment().h1(this.B, squareFeed);
            this.mBindingComponent.getFeedShowDetailFragment().i1(this.C, squareFeed);
            TextViewBindingAdapter.setText(this.E, str);
            this.mBindingComponent.getFeedShowDetailFragment().p1(this.F, i2);
            this.mBindingComponent.getFeedShowDetailFragment().r1(this.G, str2);
            this.mBindingComponent.getFeedShowDetailFragment().m1(this.L, squareFeed);
            this.M.setVisibility(i3);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j0 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j0 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.zenmen.square.databinding.LayoutSquareShowMediaViewBinding
    public void p(@Nullable SquareFeed squareFeed) {
        this.Q = squareFeed;
        synchronized (this) {
            this.j0 |= 1;
        }
        notifyPropertyChanged(ko.d);
        super.requestRebind();
    }

    @Override // com.zenmen.square.databinding.LayoutSquareShowMediaViewBinding
    public void q(@Nullable FeedShowDetailFragment feedShowDetailFragment) {
        this.R = feedShowDetailFragment;
        synchronized (this) {
            this.j0 |= 2;
        }
        notifyPropertyChanged(ko.h);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.d == i) {
            p((SquareFeed) obj);
        } else {
            if (ko.h != i) {
                return false;
            }
            q((FeedShowDetailFragment) obj);
        }
        return true;
    }

    public LayoutSquareShowMediaViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (DYPageIndicator) objArr[25], (ImageView) objArr[19], (ConstraintLayout) objArr[32], (RelativeLayout) objArr[0], (LinearLayout) objArr[38], (LoopingSquareHackyViewPager) objArr[21], (EffectiveShapeView) objArr[10], (RelativeLayout) objArr[23], (ImageView) objArr[18], (ImageView) objArr[17], (ImageView) objArr[30], (ImageView) objArr[8], (ImageView) objArr[27], (ImageView) objArr[35], (ImageView) objArr[5], (ImageView) objArr[14], (ImageView) objArr[41], (LinearLayout) objArr[6], (LinearLayout) objArr[31], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[33], (LinearLayout) objArr[20], (ConstraintLayout) objArr[24], (RelativeLayout) objArr[26], (RelativeLayout) objArr[34], (ConstraintLayout) objArr[39], (TextView) objArr[7], (ExpandableTextView) objArr[2], (ExpandableTextView) objArr[16], (TextView) objArr[9], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[28], (TextView) objArr[36], (TextView) objArr[29], (TextView) objArr[37], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[40], (TextView) objArr[42], (DoubleClickView) objArr[22]);
        this.j0 = -1L;
        ensureBindingComponentIsNotNull(FeedShowDetailFragment.class);
        this.b.setTag(null);
        this.d.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.l.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.r.setTag(null);
        this.t.setTag(null);
        this.v.setTag(null);
        ImageView imageView = (ImageView) objArr[11];
        this.S = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[15];
        this.T = textView;
        textView.setTag(null);
        this.A.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.E.setTag(null);
        this.F.setTag(null);
        this.G.setTag(null);
        this.L.setTag(null);
        this.M.setTag(null);
        setRootTag(view);
        this.U = new p64(this, 6);
        this.V = new p64(this, 2);
        this.W = new p64(this, 10);
        this.X = new p64(this, 9);
        this.Y = new p64(this, 3);
        this.Z = new p64(this, 11);
        this.e0 = new p64(this, 4);
        this.f0 = new p64(this, 7);
        this.g0 = new p64(this, 5);
        this.h0 = new p64(this, 1);
        this.i0 = new p64(this, 8);
        invalidateAll();
    }
}
