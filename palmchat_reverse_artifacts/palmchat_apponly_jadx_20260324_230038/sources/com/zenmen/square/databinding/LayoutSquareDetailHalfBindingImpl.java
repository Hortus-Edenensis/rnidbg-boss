package com.zenmen.square.databinding;

import android.content.Context;
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
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.zenmen.palmchat.greendao.model.ISupperFeedBean;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.comment.ui.CommentListView;
import com.zenmen.square.comment.widget.RichTextView;
import com.zenmen.square.comment.widget.VideoTabLoadingView;
import defpackage.ko;
import defpackage.p64;
import defpackage.sl2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LayoutSquareDetailHalfBindingImpl extends LayoutSquareDetailHalfBinding implements p64.a {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts R = null;

    @Nullable
    public static final SparseIntArray S;

    @NonNull
    public final RelativeLayout K;

    @NonNull
    public final LinearLayout L;

    @Nullable
    public final View.OnClickListener M;

    @Nullable
    public final View.OnClickListener N;

    @Nullable
    public final View.OnClickListener O;

    @Nullable
    public final View.OnClickListener P;
    public long Q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        S = sparseIntArray;
        sparseIntArray.put(R$id.toolbar, 12);
        sparseIntArray.put(R$id.feed_detail_title_bar, 13);
        sparseIntArray.put(R$id.title_bar, 14);
        sparseIntArray.put(R$id.iv_back, 15);
        sparseIntArray.put(R$id.tv_official, 16);
        sparseIntArray.put(R$id.iv_vip, 17);
        sparseIntArray.put(R$id.create_time, 18);
        sparseIntArray.put(R$id.feed_content_container, 19);
        sparseIntArray.put(R$id.rl_comment_title, 20);
        sparseIntArray.put(R$id.vs_comment_title, 21);
        sparseIntArray.put(R$id.tv_comment_count, 22);
        sparseIntArray.put(R$id.commentList, 23);
        sparseIntArray.put(R$id.vs_comment_emptyview, 24);
        sparseIntArray.put(R$id.vs_comment_emptyview_icon, 25);
        sparseIntArray.put(R$id.vs_comment_emptyview_text, 26);
        sparseIntArray.put(R$id.video_tab_loading_view, 27);
        sparseIntArray.put(R$id.edit_message_area, 28);
        sparseIntArray.put(R$id.vs_comment_emoji, 29);
        sparseIntArray.put(R$id.layout_gift, 30);
        sparseIntArray.put(R$id.iv_gift_image, 31);
        sparseIntArray.put(R$id.tv_gift_txt, 32);
        sparseIntArray.put(R$id.small_gift_container, 33);
        sparseIntArray.put(R$id.large_gift_container, 34);
    }

    public LayoutSquareDetailHalfBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 35, R, S));
    }

    @Override // p64.a
    public final void a(int i, View view) {
        if (i == 1) {
            sl2 sl2Var = this.J;
            if (sl2Var != null) {
                sl2Var.onViewClick(view);
                return;
            }
            return;
        }
        if (i == 2) {
            sl2 sl2Var2 = this.J;
            if (sl2Var2 != null) {
                sl2Var2.onViewClick(view);
                return;
            }
            return;
        }
        if (i == 3) {
            sl2 sl2Var3 = this.J;
            if (sl2Var3 != null) {
                sl2Var3.onViewClick(view);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        sl2 sl2Var4 = this.J;
        if (sl2Var4 != null) {
            sl2Var4.onViewClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        Drawable drawable;
        int i;
        String praiseCountShow;
        boolean zHideComment;
        int gender;
        boolean ifLike;
        Context context;
        int i2;
        synchronized (this) {
            j = this.Q;
            this.Q = 0L;
        }
        ISupperFeedBean iSupperFeedBean = this.I;
        long j2 = j & 5;
        Drawable drawable2 = null;
        String nickname = null;
        if (j2 != 0) {
            if (iSupperFeedBean != null) {
                zHideComment = iSupperFeedBean.hideComment();
                nickname = iSupperFeedBean.getNickname();
                gender = iSupperFeedBean.getGender();
                ifLike = iSupperFeedBean.getIfLike();
                praiseCountShow = iSupperFeedBean.getPraiseCountShow();
            } else {
                praiseCountShow = null;
                zHideComment = false;
                gender = 0;
                ifLike = false;
            }
            if (j2 != 0) {
                j |= zHideComment ? 256L : 128L;
            }
            if ((j & 5) != 0) {
                j |= ifLike ? 64L : 32L;
            }
            int i3 = zHideComment ? 8 : 0;
            boolean z = gender == 1;
            Drawable drawable3 = AppCompatResources.getDrawable(this.l.getContext(), ifLike ? R$drawable.icon_praise_selected_new : R$drawable.icon_praise_none_new);
            if ((j & 5) != 0) {
                j |= z ? 16L : 8L;
            }
            if (z) {
                context = this.t.getContext();
                i2 = R$drawable.icon_sex_female;
            } else {
                context = this.t.getContext();
                i2 = R$drawable.icon_sex_male;
            }
            drawable = AppCompatResources.getDrawable(context, i2);
            int i4 = i3;
            str2 = praiseCountShow;
            str = nickname;
            drawable2 = drawable3;
            i = i4;
        } else {
            str = null;
            str2 = null;
            drawable = null;
            i = 0;
        }
        if ((4 & j) != 0) {
            this.f16226a.setOnClickListener(this.M);
            this.b.setOnClickListener(this.N);
            this.h.setOnClickListener(this.P);
            this.p.setOnClickListener(this.O);
        }
        if ((j & 5) != 0) {
            this.i.setVisibility(i);
            ImageViewBindingAdapter.setImageDrawable(this.l, drawable2);
            this.q.setVisibility(i);
            this.L.setVisibility(i);
            TextViewBindingAdapter.setText(this.r, str);
            ImageViewBindingAdapter.setImageDrawable(this.t, drawable);
            TextViewBindingAdapter.setText(this.A, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.Q != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.Q = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.zenmen.square.databinding.LayoutSquareDetailHalfBinding
    public void p(@Nullable sl2 sl2Var) {
        this.J = sl2Var;
        synchronized (this) {
            this.Q |= 2;
        }
        notifyPropertyChanged(ko.c);
        super.requestRebind();
    }

    @Override // com.zenmen.square.databinding.LayoutSquareDetailHalfBinding
    public void q(@Nullable ISupperFeedBean iSupperFeedBean) {
        this.I = iSupperFeedBean;
        synchronized (this) {
            this.Q |= 1;
        }
        notifyPropertyChanged(ko.d);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ko.d == i) {
            q((ISupperFeedBean) obj);
        } else {
            if (ko.c != i) {
                return false;
            }
            p((sl2) obj);
        }
        return true;
    }

    public LayoutSquareDetailHalfBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (ImageView) objArr[5], (CommentListView) objArr[23], (TextView) objArr[18], (RichTextView) objArr[28], (ConstraintLayout) objArr[19], (LinearLayout) objArr[13], (EffectiveShapeView) objArr[1], (LinearLayout) objArr[8], (ImageView) objArr[15], (ImageView) objArr[31], (ImageView) objArr[10], (ImageView) objArr[17], (FrameLayout) objArr[34], (LinearLayout) objArr[30], (LinearLayout) objArr[9], (ImageView) objArr[6], (TextView) objArr[3], (RelativeLayout) objArr[20], (ImageView) objArr[2], (FrameLayout) objArr[33], (ConstraintLayout) objArr[14], (Toolbar) objArr[12], (TextView) objArr[22], (TextView) objArr[32], (TextView) objArr[16], (TextView) objArr[11], (VideoTabLoadingView) objArr[27], (ImageView) objArr[29], (LinearLayout) objArr[24], (ImageView) objArr[25], (TextView) objArr[26], (TextView) objArr[21]);
        this.Q = -1L;
        this.f16226a.setTag(null);
        this.b.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.l.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.K = relativeLayout;
        relativeLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[7];
        this.L = linearLayout;
        linearLayout.setTag(null);
        this.r.setTag(null);
        this.t.setTag(null);
        this.A.setTag(null);
        setRootTag(view);
        this.M = new p64(this, 2);
        this.N = new p64(this, 3);
        this.O = new p64(this, 4);
        this.P = new p64(this, 1);
        invalidateAll();
    }
}
