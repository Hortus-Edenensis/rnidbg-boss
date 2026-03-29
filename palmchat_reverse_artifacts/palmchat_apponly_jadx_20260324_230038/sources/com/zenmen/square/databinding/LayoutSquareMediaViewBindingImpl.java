package com.zenmen.square.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
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
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.palmchat.widget.MSVGAImageView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$string;
import com.zenmen.square.fragment.FeedDetailFragment;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.ui.widget.DoubleClickView;
import com.zenmen.square.ui.widget.ExpandableTextView;
import com.zenmen.square.ui.widget.SquareHackyViewPager;
import defpackage.ko;
import defpackage.p64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutSquareMediaViewBindingImpl extends LayoutSquareMediaViewBinding implements p64.a {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts v0 = null;

    @Nullable
    public static final SparseIntArray w0;

    @NonNull
    public final ImageView g0;

    @NonNull
    public final TextView h0;

    @Nullable
    public final View.OnClickListener i0;

    @Nullable
    public final View.OnClickListener j0;

    @Nullable
    public final View.OnClickListener k0;

    @Nullable
    public final View.OnClickListener l0;

    @Nullable
    public final View.OnClickListener m0;

    @Nullable
    public final View.OnClickListener n0;

    @Nullable
    public final View.OnClickListener o0;

    @Nullable
    public final View.OnClickListener p0;

    @Nullable
    public final View.OnClickListener q0;

    @Nullable
    public final View.OnClickListener r0;

    @Nullable
    public final View.OnClickListener s0;

    @Nullable
    public final View.OnClickListener t0;
    public long u0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        w0 = sparseIntArray;
        sparseIntArray.put(R$id.feed_media_viewpager, 23);
        sparseIntArray.put(R$id.v_feed_detail_cover, 24);
        sparseIntArray.put(R$id.infoLayout, 25);
        sparseIntArray.put(R$id.rl_feed_detail_bottom, 26);
        sparseIntArray.put(R$id.rl_location_time_gallery, 27);
        sparseIntArray.put(R$id.iv_feed_location_icon, 28);
        sparseIntArray.put(R$id.tv_feed_location_label, 29);
        sparseIntArray.put(R$id.tv_feed_time_label, 30);
        sparseIntArray.put(R$id.layout_gift, 31);
        sparseIntArray.put(R$id.iv_gift_image, 32);
        sparseIntArray.put(R$id.tv_gift_txt, 33);
        sparseIntArray.put(R$id.layout_recommend, 34);
        sparseIntArray.put(R$id.super_expose_v1_enter_from4_image, 35);
        sparseIntArray.put(R$id.iv_btn_comment_feed_b, 36);
        sparseIntArray.put(R$id.layout_feed_detail_praise_b, 37);
        sparseIntArray.put(R$id.tv_say_hi_b, 38);
        sparseIntArray.put(R$id.svga_say_hi, 39);
        sparseIntArray.put(R$id.cl_userinfo_b, 40);
        sparseIntArray.put(R$id.ll_content_location_second, 41);
        sparseIntArray.put(R$id.rl_location_time_second, 42);
        sparseIntArray.put(R$id.iv_feed_location_icon_second, 43);
        sparseIntArray.put(R$id.tv_feed_location_label_second, 44);
        sparseIntArray.put(R$id.tv_feed_time_label_second, 45);
        sparseIntArray.put(R$id.feed_detail_title_bar, 46);
        sparseIntArray.put(R$id.title_bar, 47);
        sparseIntArray.put(R$id.tv_page_indicator, 48);
        sparseIntArray.put(R$id.iv_wishes_icon, 49);
        sparseIntArray.put(R$id.tv_wishes_content, 50);
        sparseIntArray.put(R$id.small_gift_container, 51);
        sparseIntArray.put(R$id.large_gift_container, 52);
    }

    public LayoutSquareMediaViewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 53, v0, w0));
    }

    @Override // p64.a
    public final void a(int i, View view) {
        switch (i) {
            case 1:
                FeedDetailFragment feedDetailFragment = this.f0;
                if (feedDetailFragment != null) {
                    feedDetailFragment.e1(view);
                }
                break;
            case 2:
                FeedDetailFragment feedDetailFragment2 = this.f0;
                if (feedDetailFragment2 != null) {
                    feedDetailFragment2.e1(view);
                }
                break;
            case 3:
                FeedDetailFragment feedDetailFragment3 = this.f0;
                if (feedDetailFragment3 != null) {
                    feedDetailFragment3.e1(view);
                }
                break;
            case 4:
                FeedDetailFragment feedDetailFragment4 = this.f0;
                if (feedDetailFragment4 != null) {
                    feedDetailFragment4.e1(view);
                }
                break;
            case 5:
                FeedDetailFragment feedDetailFragment5 = this.f0;
                if (feedDetailFragment5 != null) {
                    feedDetailFragment5.e1(view);
                }
                break;
            case 6:
                FeedDetailFragment feedDetailFragment6 = this.f0;
                if (feedDetailFragment6 != null) {
                    feedDetailFragment6.e1(view);
                }
                break;
            case 7:
                FeedDetailFragment feedDetailFragment7 = this.f0;
                if (feedDetailFragment7 != null) {
                    feedDetailFragment7.e1(view);
                }
                break;
            case 8:
                FeedDetailFragment feedDetailFragment8 = this.f0;
                if (feedDetailFragment8 != null) {
                    feedDetailFragment8.e1(view);
                }
                break;
            case 9:
                FeedDetailFragment feedDetailFragment9 = this.f0;
                if (feedDetailFragment9 != null) {
                    feedDetailFragment9.onArrowPress(view);
                }
                break;
            case 10:
                FeedDetailFragment feedDetailFragment10 = this.f0;
                if (feedDetailFragment10 != null) {
                    feedDetailFragment10.onArrowPress(view);
                }
                break;
            case 11:
                FeedDetailFragment feedDetailFragment11 = this.f0;
                if (feedDetailFragment11 != null) {
                    feedDetailFragment11.e1(view);
                }
                break;
            case 12:
                FeedDetailFragment feedDetailFragment12 = this.f0;
                if (feedDetailFragment12 != null) {
                    feedDetailFragment12.e1(view);
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
        Drawable drawable3;
        int i;
        int i2;
        int i3;
        long j2;
        String str3;
        int i4;
        String str4;
        String praiseCountShow;
        boolean z;
        int i5;
        boolean zIsFriend;
        boolean z2;
        long createTime;
        boolean ifLike;
        synchronized (this) {
            j = this.u0;
            this.u0 = 0L;
        }
        SquareFeed squareFeed = this.e0;
        long j3 = 5;
        long j4 = j & 5;
        String str5 = null;
        if (j4 != 0) {
            if (squareFeed != null) {
                str5 = squareFeed.headImgUrl;
                str4 = squareFeed.topicName;
                commentCountShow = squareFeed.getCommentCountShow();
                i = squareFeed.tagId;
                zIsFriend = squareFeed.isFriend();
                z2 = squareFeed.hiddenDiscussion;
                createTime = squareFeed.getCreateTime();
                ifLike = squareFeed.getIfLike();
                i5 = squareFeed.sex;
                praiseCountShow = squareFeed.getPraiseCountShow();
                z = squareFeed.official;
            } else {
                str4 = null;
                commentCountShow = null;
                praiseCountShow = null;
                z = false;
                i5 = 0;
                i = 0;
                zIsFriend = false;
                z2 = false;
                createTime = 0;
                ifLike = false;
            }
            if (j4 != 0) {
                j |= zIsFriend ? 1024L : 512L;
            }
            if ((j & 5) != 0) {
                j |= z2 ? 64L : 32L;
            }
            if ((j & 5) != 0) {
                j |= ifLike ? 4096L : 2048L;
            }
            if ((j & 5) != 0) {
                j |= z ? 16L : 8L;
            }
            drawable2 = AppCompatResources.getDrawable(this.m.getContext(), zIsFriend ? R$drawable.icon_send_message_new_b : R$drawable.icon_say_hi_new_b);
            i2 = z2 ? 8 : 0;
            drawable3 = ifLike ? AppCompatResources.getDrawable(this.l.getContext(), R$drawable.icon_praise_feeddetail_selected_new) : AppCompatResources.getDrawable(this.l.getContext(), R$drawable.icon_praise_feeddetail_none_white_new);
            boolean z3 = i5 == 1;
            int i6 = z ? 0 : 8;
            if ((j & 5) != 0) {
                j |= z3 ? 256L : 128L;
            }
            drawable = AppCompatResources.getDrawable(this.g0.getContext(), z3 ? R$drawable.icon_sex_female : R$drawable.icon_sex_male);
            i3 = i6;
            j2 = createTime;
            str2 = str4;
            str = praiseCountShow;
        } else {
            drawable = null;
            drawable2 = null;
            str = null;
            commentCountShow = null;
            str2 = null;
            drawable3 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            j2 = 0;
        }
        if ((j & 4) != 0) {
            this.f16232a.setOnClickListener(this.i0);
            this.b.setOnClickListener(this.o0);
            FeedDetailFragment feedDetailFragment = this.mBindingComponent.getFeedDetailFragment();
            TextView textView = this.b;
            i4 = i3;
            str3 = str2;
            feedDetailFragment.h1(textView, textView.getResources().getString(R$string.square_comment_hint));
            this.g.setOnClickListener(this.s0);
            this.i.setOnClickListener(this.r0);
            this.j.setOnClickListener(this.m0);
            this.l.setOnClickListener(this.n0);
            this.t.setOnClickListener(this.q0);
            this.y.setOnClickListener(this.j0);
            this.A.setOnClickListener(this.l0);
            this.N.setOnClickListener(this.t0);
            this.O.setOnClickListener(this.k0);
            this.U.setOnClickListener(this.p0);
            j3 = 5;
        } else {
            str3 = str2;
            i4 = i3;
        }
        if ((j & j3) != 0) {
            this.b.setVisibility(i2);
            this.mBindingComponent.getFeedDetailFragment().g1(this.g, str5);
            ImageViewBindingAdapter.setImageDrawable(this.l, drawable3);
            ImageViewBindingAdapter.setImageDrawable(this.m, drawable2);
            this.mBindingComponent.getFeedDetailFragment().u1(this.q, squareFeed);
            this.t.setVisibility(i2);
            this.mBindingComponent.getFeedDetailFragment().n1(this.w, squareFeed);
            this.mBindingComponent.getFeedDetailFragment().i1(this.y, squareFeed);
            this.mBindingComponent.getFeedDetailFragment().j1(this.A, squareFeed);
            ImageViewBindingAdapter.setImageDrawable(this.g0, drawable);
            this.mBindingComponent.getFeedDetailFragment().r1(this.h0, j2);
            TextViewBindingAdapter.setText(this.J, commentCountShow);
            this.mBindingComponent.getFeedDetailFragment().k1(this.K, squareFeed);
            this.mBindingComponent.getFeedDetailFragment().l1(this.L, squareFeed);
            TextViewBindingAdapter.setText(this.M, str);
            this.mBindingComponent.getFeedDetailFragment().s1(this.N, i);
            this.mBindingComponent.getFeedDetailFragment().t1(this.O, str3);
            this.mBindingComponent.getFeedDetailFragment().p1(this.U, squareFeed);
            this.V.setVisibility(i4);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.u0 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.u0 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.zenmen.square.databinding.LayoutSquareMediaViewBinding
    public void p(@Nullable FeedDetailFragment feedDetailFragment) {
        this.f0 = feedDetailFragment;
        synchronized (this) {
            this.u0 |= 2;
        }
        notifyPropertyChanged(ko.b);
        super.requestRebind();
    }

    @Override // com.zenmen.square.databinding.LayoutSquareMediaViewBinding
    public void q(@Nullable SquareFeed squareFeed) {
        this.e0 = squareFeed;
        synchronized (this) {
            this.u0 |= 1;
        }
        notifyPropertyChanged(ko.d);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.d == i) {
            q((SquareFeed) obj);
        } else {
            if (ko.b != i) {
                return false;
            }
            p((FeedDetailFragment) obj);
        }
        return true;
    }

    public LayoutSquareMediaViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[21], (TextView) objArr[2], (ConstraintLayout) objArr[40], (RelativeLayout) objArr[0], (LinearLayout) objArr[46], (SquareHackyViewPager) objArr[23], (EffectiveShapeView) objArr[12], (RelativeLayout) objArr[25], (ImageView) objArr[20], (ImageView) objArr[19], (ImageView) objArr[36], (ImageView) objArr[8], (ImageView) objArr[11], (ImageView) objArr[28], (ImageView) objArr[43], (ImageView) objArr[32], (ImageView) objArr[16], (ImageView) objArr[49], (FrameLayout) objArr[52], (LinearLayout) objArr[6], (LinearLayout) objArr[37], (LinearLayout) objArr[31], (ConstraintLayout) objArr[1], (LinearLayout) objArr[34], (LinearLayout) objArr[10], (ConstraintLayout) objArr[41], (LinearLayout) objArr[22], (ConstraintLayout) objArr[26], (RelativeLayout) objArr[27], (RelativeLayout) objArr[42], (FrameLayout) objArr[51], (MSVGAImageView) objArr[35], (SVGAImageView) objArr[39], (ConstraintLayout) objArr[47], (TextView) objArr[7], (ExpandableTextView) objArr[3], (ExpandableTextView) objArr[18], (TextView) objArr[9], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[29], (TextView) objArr[44], (TextView) objArr[30], (TextView) objArr[45], (TextView) objArr[33], (TextView) objArr[14], (TextView) objArr[15], (TextView) objArr[48], (TextView) objArr[38], (TextView) objArr[50], (DoubleClickView) objArr[24]);
        this.u0 = -1L;
        ensureBindingComponentIsNotNull(FeedDetailFragment.class);
        this.f16232a.setTag(null);
        this.b.setTag(null);
        this.d.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.q.setTag(null);
        this.t.setTag(null);
        this.w.setTag(null);
        this.y.setTag(null);
        this.A.setTag(null);
        ImageView imageView = (ImageView) objArr[13];
        this.g0 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[17];
        this.h0 = textView;
        textView.setTag(null);
        this.J.setTag(null);
        this.K.setTag(null);
        this.L.setTag(null);
        this.M.setTag(null);
        this.N.setTag(null);
        this.O.setTag(null);
        this.U.setTag(null);
        this.V.setTag(null);
        setRootTag(view);
        this.i0 = new p64(this, 11);
        this.j0 = new p64(this, 6);
        this.k0 = new p64(this, 2);
        this.l0 = new p64(this, 12);
        this.m0 = new p64(this, 9);
        this.n0 = new p64(this, 5);
        this.o0 = new p64(this, 1);
        this.p0 = new p64(this, 8);
        this.q0 = new p64(this, 4);
        this.r0 = new p64(this, 10);
        this.s0 = new p64(this, 7);
        this.t0 = new p64(this, 3);
        invalidateAll();
    }
}
