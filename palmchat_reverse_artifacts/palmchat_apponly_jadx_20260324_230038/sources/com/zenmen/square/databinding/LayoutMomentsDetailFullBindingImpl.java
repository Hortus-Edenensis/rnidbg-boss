package com.zenmen.square.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.ui.widget.common.ClickShowMoreLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$string;
import com.zenmen.square.fragment.MomentDetailFragment;
import com.zenmen.square.mvvm.MediaFriendViewModel;
import com.zenmen.square.ui.widget.DoubleClickView;
import com.zenmen.square.ui.widget.PageIndicatorView;
import com.zenmen.square.ui.widget.SquareHackyViewPager;
import defpackage.ko;
import defpackage.p64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutMomentsDetailFullBindingImpl extends LayoutMomentsDetailFullBinding implements p64.a {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts T = null;

    @Nullable
    public static final SparseIntArray U;

    @NonNull
    public final TextView I;

    @NonNull
    public final ImageView J;

    @Nullable
    public final View.OnClickListener K;

    @Nullable
    public final View.OnClickListener L;

    @Nullable
    public final View.OnClickListener M;

    @Nullable
    public final View.OnClickListener N;

    @Nullable
    public final View.OnClickListener O;

    @Nullable
    public final View.OnClickListener P;

    @Nullable
    public final View.OnClickListener Q;

    @Nullable
    public final View.OnClickListener R;
    public long S;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        U = sparseIntArray;
        sparseIntArray.put(R$id.layout_mediaview, 17);
        sparseIntArray.put(R$id.viewpager, 18);
        sparseIntArray.put(R$id.v_feed_detail_cover, 19);
        sparseIntArray.put(R$id.infoLayout, 20);
        sparseIntArray.put(R$id.rl_feed_detail_bottom, 21);
        sparseIntArray.put(R$id.iv_btn_comment_feed, 22);
        sparseIntArray.put(R$id.layout_feed_detail_praise, 23);
        sparseIntArray.put(R$id.tool_bar_ll, 24);
        sparseIntArray.put(R$id.feed_detail_title_bar, 25);
        sparseIntArray.put(R$id.title_bar, 26);
        sparseIntArray.put(R$id.iv_wishes_icon, 27);
        sparseIntArray.put(R$id.tv_wishes_content, 28);
        sparseIntArray.put(R$id.page_indicator, 29);
        sparseIntArray.put(R$id.indicator, 30);
        sparseIntArray.put(R$id.mask, 31);
        sparseIntArray.put(R$id.prsbar, 32);
    }

    public LayoutMomentsDetailFullBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 33, T, U));
    }

    @Override // p64.a
    public final void a(int i, View view) {
        switch (i) {
            case 1:
                MomentDetailFragment momentDetailFragment = this.H;
                if (momentDetailFragment != null) {
                    momentDetailFragment.i1(view);
                }
                break;
            case 2:
                MomentDetailFragment momentDetailFragment2 = this.H;
                if (momentDetailFragment2 != null) {
                    momentDetailFragment2.i1(view);
                }
                break;
            case 3:
                MomentDetailFragment momentDetailFragment3 = this.H;
                if (momentDetailFragment3 != null) {
                    momentDetailFragment3.y0(view);
                }
                break;
            case 4:
                MomentDetailFragment momentDetailFragment4 = this.H;
                if (momentDetailFragment4 != null) {
                    momentDetailFragment4.onArrowPress(view);
                }
                break;
            case 5:
                MomentDetailFragment momentDetailFragment5 = this.H;
                if (momentDetailFragment5 != null) {
                    momentDetailFragment5.onAvatarClick(view);
                }
                break;
            case 6:
                MomentDetailFragment momentDetailFragment6 = this.H;
                if (momentDetailFragment6 != null) {
                    momentDetailFragment6.onChatBtnClick(view);
                }
                break;
            case 7:
                MomentDetailFragment momentDetailFragment7 = this.H;
                if (momentDetailFragment7 != null) {
                    momentDetailFragment7.onMoreBtnClick(view);
                }
                break;
            case 8:
                MomentDetailFragment momentDetailFragment8 = this.H;
                if (momentDetailFragment8 != null) {
                    momentDetailFragment8.onChatBtnClick(view);
                }
                break;
        }
    }

    @Override // com.zenmen.square.databinding.LayoutMomentsDetailFullBinding
    public void b(@Nullable MomentDetailFragment momentDetailFragment) {
        this.H = momentDetailFragment;
        synchronized (this) {
            this.S |= 2;
        }
        notifyPropertyChanged(ko.c);
        super.requestRebind();
    }

    @Override // com.zenmen.square.databinding.LayoutMomentsDetailFullBinding
    public void c(@Nullable MediaFriendViewModel mediaFriendViewModel) {
        this.G = mediaFriendViewModel;
        synchronized (this) {
            this.S |= 1;
        }
        notifyPropertyChanged(ko.e);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x010e A[PHI: r2
      0x010e: PHI (r2v2 long) = (r2v1 long), (r2v26 long) binds: [B:58:0x00f3, B:67:0x0108] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void executeBindings() {
        long j;
        long j2;
        long j3;
        String str;
        String str2;
        Drawable drawable;
        Drawable drawable2;
        String str3;
        int i;
        int i2;
        boolean zCanDelete;
        int i3;
        int i4;
        FeedBean feedBeanC;
        ContactInfoItem contactInfoItemA;
        long createDt;
        String commentCountShow;
        String str4;
        String praiseCountShow;
        boolean zIsIfLike;
        int gender;
        Context context;
        int i5;
        synchronized (this) {
            j = this.S;
            this.S = 0L;
        }
        MediaFriendViewModel mediaFriendViewModel = this.G;
        long j4 = j & 5;
        ContactInfoItem contactInfoItem = null;
        String iconURL = null;
        if (j4 != 0) {
            if (mediaFriendViewModel != null) {
                feedBeanC = mediaFriendViewModel.c();
                contactInfoItemA = mediaFriendViewModel.a();
            } else {
                feedBeanC = null;
                contactInfoItemA = null;
            }
            if (feedBeanC != null) {
                createDt = feedBeanC.getCreateDt();
                zIsIfLike = feedBeanC.isIfLike();
                zCanDelete = feedBeanC.canDelete();
                str4 = feedBeanC.content;
                praiseCountShow = feedBeanC.getPraiseCountShow();
                commentCountShow = feedBeanC.getCommentCountShow();
            } else {
                createDt = 0;
                commentCountShow = null;
                str4 = null;
                praiseCountShow = null;
                zIsIfLike = false;
                zCanDelete = false;
            }
            if (j4 != 0) {
                j |= zIsIfLike ? 16L : 8L;
            }
            if ((j & 5) != 0) {
                j = zCanDelete ? j | 64 | 4096 : j | 32 | 2048;
            }
            if (contactInfoItemA != null) {
                iconURL = contactInfoItemA.getIconURL();
                gender = contactInfoItemA.getGender();
            } else {
                gender = 0;
            }
            drawable = zIsIfLike ? AppCompatResources.getDrawable(this.k.getContext(), R$drawable.icon_praise_feeddetail_selected) : AppCompatResources.getDrawable(this.k.getContext(), R$drawable.icon_praise_feeddetail_none_white);
            i = zCanDelete ? 4 : 0;
            boolean zIsEmpty = TextUtils.isEmpty(str4);
            boolean z = gender == 1;
            if ((j & 5) != 0) {
                j |= zIsEmpty ? 16384L : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            if ((j & 5) != 0) {
                j |= z ? 1024L : 512L;
            }
            i2 = zIsEmpty ? 8 : 0;
            if (z) {
                context = this.J.getContext();
                i5 = R$drawable.icon_sex_female;
            } else {
                context = this.J.getContext();
                i5 = R$drawable.icon_sex_male;
            }
            drawable2 = AppCompatResources.getDrawable(context, i5);
            str3 = commentCountShow;
            str = iconURL;
            j2 = createDt;
            j3 = 2048;
            contactInfoItem = contactInfoItemA;
            str2 = praiseCountShow;
        } else {
            j2 = 0;
            j3 = 2048;
            str = null;
            str2 = null;
            drawable = null;
            drawable2 = null;
            str3 = null;
            i = 0;
            i2 = 0;
            zCanDelete = false;
        }
        long j5 = j & j3;
        if (j5 == 0) {
            i3 = 0;
        } else {
            boolean zIsOfficialAccount = contactInfoItem != null ? contactInfoItem.isOfficialAccount() : false;
            if (j5 != 0) {
                j |= zIsOfficialAccount ? 256L : 128L;
            }
            if (!zIsOfficialAccount) {
                i3 = 8;
            }
        }
        long j6 = 5 & j;
        if (j6 != 0) {
            i4 = zCanDelete ? 8 : i3;
        } else {
            i4 = 0;
        }
        if ((j & 4) != 0) {
            this.f16222a.setOnClickListener(this.O);
            this.b.setOnClickListener(this.N);
            this.c.setOnClickListener(this.R);
            TextView textView = this.c;
            MomentDetailFragment.e1(textView, textView.getResources().getString(R$string.square_comment_hint));
            this.f.setOnClickListener(this.L);
            this.i.setOnClickListener(this.Q);
            this.k.setOnClickListener(this.M);
            this.n.setOnClickListener(this.K);
            this.q.setOnClickListener(this.P);
        }
        if (j6 != 0) {
            this.f.setVisibility(i);
            MomentDetailFragment.c1(this.f, str);
            ImageViewBindingAdapter.setImageDrawable(this.k, drawable);
            MomentDetailFragment.h1(this.l, mediaFriendViewModel);
            MomentDetailFragment.g1(this.I, j2);
            this.I.setVisibility(i);
            ImageViewBindingAdapter.setImageDrawable(this.J, drawable2);
            this.J.setVisibility(i);
            TextViewBindingAdapter.setText(this.x, str3);
            this.y.setVisibility(i2);
            TextViewBindingAdapter.setText(this.z, str2);
            MomentDetailFragment.f1(this.A, mediaFriendViewModel);
            this.B.setVisibility(i4);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.S != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.S = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.e == i) {
            c((MediaFriendViewModel) obj);
        } else {
            if (ko.c != i) {
                return false;
            }
            b((MomentDetailFragment) obj);
        }
        return true;
    }

    public LayoutMomentsDetailFullBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[14], (ImageView) objArr[15], (TextView) objArr[1], (RelativeLayout) objArr[0], (LinearLayout) objArr[25], (EffectiveShapeView) objArr[8], (TextView) objArr[30], (RelativeLayout) objArr[20], (ImageView) objArr[7], (ImageView) objArr[22], (ImageView) objArr[5], (ImageView) objArr[12], (ImageView) objArr[27], (LinearLayout) objArr[3], (LinearLayout) objArr[23], (ConstraintLayout) objArr[17], (LinearLayout) objArr[16], (RelativeLayout) objArr[31], (PageIndicatorView) objArr[29], (ProgressBar) objArr[32], (ConstraintLayout) objArr[21], (ConstraintLayout) objArr[26], (LinearLayout) objArr[24], (TextView) objArr[4], (ClickShowMoreLayout) objArr[2], (TextView) objArr[6], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[28], (DoubleClickView) objArr[19], (SquareHackyViewPager) objArr[18]);
        this.S = -1L;
        this.f16222a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.f.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.n.setTag(null);
        this.q.setTag(null);
        TextView textView = (TextView) objArr[13];
        this.I = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[9];
        this.J = imageView;
        imageView.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        this.B.setTag(null);
        setRootTag(view);
        this.K = new p64(this, 2);
        this.L = new p64(this, 5);
        this.M = new p64(this, 3);
        this.N = new p64(this, 7);
        this.O = new p64(this, 6);
        this.P = new p64(this, 8);
        this.Q = new p64(this, 4);
        this.R = new p64(this, 1);
        invalidateAll();
    }
}
