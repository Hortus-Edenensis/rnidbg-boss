package com.zenmen.square.comment.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$anim;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.comment.model.CommentLoadState;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.comment.model.UserInfoItem;
import com.zenmen.square.comment.struct.CommentItem;
import com.zenmen.square.comment.struct.CommentReplyItem;
import com.zenmen.square.comment.widget.RichTextView;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import defpackage.fg6;
import defpackage.fs;
import defpackage.gi5;
import defpackage.gr2;
import defpackage.k36;
import defpackage.k86;
import defpackage.me1;
import defpackage.ri0;
import defpackage.si0;
import defpackage.ti0;
import defpackage.z66;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ResultBean e;
    public AlphaAnimation f;
    public List<CommentViewModel> i;
    public UserInfoItem j;
    public HashSet<Long> k;
    public SquareFeed l;
    public CommentViewModel m;
    public Context n;
    public LayoutInflater o;
    public ti0.c p;
    public View r;
    public int g = -1;
    public boolean h = true;
    public boolean q = false;

    /* JADX INFO: compiled from: SearchBox */
    public class CommentViewHolder extends RecyclerView.ViewHolder {
        public final EffectiveShapeView d;
        public final ImageView e;
        public final TextView f;
        public final TextView g;
        public final ImageView h;
        public final RichTextView i;
        public final CommentLikeView j;
        public final View k;
        public final View l;
        public final View m;
        public final View n;
        public final View o;
        public final TextView p;
        public final TextView q;
        public final ImageView r;

        public CommentViewHolder(View view) {
            super(view);
            this.k = view.findViewById(R$id.videosdk_comment_item_layout);
            this.d = (EffectiveShapeView) view.findViewById(R$id.commentUserAvatar);
            this.e = (ImageView) view.findViewById(R$id.commentUserGender);
            this.f = (TextView) view.findViewById(R$id.nickName);
            this.g = (TextView) view.findViewById(R$id.iv_author_icon);
            this.h = (ImageView) view.findViewById(R$id.iv_verified);
            this.i = (RichTextView) view.findViewById(R$id.commentContent);
            this.j = (CommentLikeView) view.findViewById(R$id.likeLayout);
            this.l = view.findViewById(R$id.sendFailedTV);
            this.m = view.findViewById(R$id.authorLiked);
            this.n = view.findViewById(R$id.highLightView);
            this.o = view.findViewById(R$id.comment_item_divider);
            this.p = (TextView) view.findViewById(R$id.time);
            this.q = (TextView) view.findViewById(R$id.reply);
            this.r = (ImageView) view.findViewById(R$id.iv_vip);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class FooterViewHolder extends RecyclerView.ViewHolder {
        public View d;
        public TextView e;
        public View f;
        public View g;
        public View h;
        public View i;

        public FooterViewHolder(View view) {
            super(view);
            this.d = view.findViewById(R$id.footerContent);
            this.e = (TextView) view.findViewById(R$id.loadMoreTv);
            this.g = view.findViewById(R$id.line_left);
            this.h = view.findViewById(R$id.line_right);
            this.f = view.findViewById(R$id.loadMoreView);
            this.i = view.findViewById(R$id.loadMoreLayout);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ReplyLoadMoreViewHolder extends RecyclerView.ViewHolder {
        public TextView d;
        public View e;
        public View f;

        public ReplyLoadMoreViewHolder(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R$id.loadMoreTv);
            this.e = view.findViewById(R$id.loadMoreView);
            this.f = view.findViewById(R$id.loadMoreLayout);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ReplyViewHolder extends CommentViewHolder {
        public ReplyViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f16190a;
        public final /* synthetic */ int b;

        public b(CommentViewModel commentViewModel, int i) {
            this.f16190a = commentViewModel;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CommentAdapter.this.p != null) {
                CommentAdapter.this.p.b(this.f16190a, this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f16191a;
        public final /* synthetic */ int b;

        public c(CommentViewModel commentViewModel, int i) {
            this.f16191a = commentViewModel;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CommentAdapter.this.p != null) {
                CommentAdapter.this.p.b(this.f16191a, this.b);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f16192a;

        public d(CommentViewModel commentViewModel) {
            this.f16192a = commentViewModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CommentAdapter.this.l == null || this.f16192a.getCommentReplyOperater() == null || this.f16192a.getCommentReplyOperater().getCRUser() == null) {
                return;
            }
            UserInfoItem cRUser = this.f16192a.getCommentReplyOperater().getCRUser();
            z66.c(10, CommentAdapter.this.l.id, cRUser.getUid(), cRUser.getExid(), CommentAdapter.this.l, CommentAdapter.this.n);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16193a;
        public CommentViewHolder b;

        public e(int i) {
            this.f16193a = i;
        }

        public void a(CommentViewHolder commentViewHolder) {
            this.b = commentViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommentAdapter.this.w(view, this.b, this.f16193a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16194a;

        public f(int i) {
            this.f16194a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            CommentAdapter.this.x(view, this.f16194a);
            return true;
        }
    }

    public CommentAdapter(Context context, SquareFeed squareFeed, List<CommentViewModel> list, UserInfoItem userInfoItem) {
        this.l = squareFeed;
        this.i = list;
        this.j = userInfoItem;
        this.n = context;
        this.o = LayoutInflater.from(context);
        v();
    }

    public final void A(boolean z, CommentViewHolder commentViewHolder, int i, int i2) {
        if (z) {
            si0.g(this.n, commentViewHolder.i, i, k36.b(1.0f));
        } else {
            si0.f(this.n, commentViewHolder.i, i2);
        }
    }

    public void B(View view) {
        this.r = view;
    }

    public void C(boolean z) {
        this.h = z;
    }

    public void D(ti0.c cVar) {
        this.p = cVar;
    }

    public void E(ResultBean resultBean) {
        this.e = resultBean;
    }

    public final void F(View view) {
        view.clearAnimation();
        view.startAnimation(AnimationUtils.loadAnimation(this.n, R$anim.square_click_like_anim));
    }

    public void G() {
        if (this.r == null) {
            return;
        }
        if (this.i == null || getItemCount() <= 0) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
    }

    public void H(boolean z, boolean z2) {
        this.m.commentLoadState.hasMore = z2;
        if (z) {
            notifyItemChanged(this.i.size() - 1);
        }
    }

    public void I(CommentViewModel commentViewModel, int i) {
        notifyItemChanged(i);
    }

    public void d(List<CommentItem> list, long j, int i) {
        f(CommentViewModel.genCommentViewModel(m(list), j), i);
    }

    public void e(CommentViewModel commentViewModel, int i) {
        this.i.add(i, commentViewModel);
        notifyItemInserted(i);
        if (i != this.i.size() - 1) {
            notifyItemRangeChanged(i, this.i.size() - i);
        }
        G();
    }

    public final void f(List<CommentViewModel> list, int i) {
        if (fs.a(this.i, i)) {
            if (i >= 0) {
                this.i.addAll(i, list);
            } else {
                this.i.addAll(list);
            }
            notifyItemRangeInserted(i, list.size());
            if (i != this.i.size() - 1) {
                notifyItemRangeChanged(i, this.i.size() - i);
            }
        }
    }

    public void g(List<CommentReplyItem> list, boolean z, int i) {
        f(CommentViewModel.genCommentViewModelFromReplyList(n(list), z), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.i.size();
        if (size == 1 && this.i.get(0).type == 3) {
            return 0;
        }
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.i.get(i).type;
    }

    public int h(CommentViewModel commentViewModel, int i) {
        if (commentViewModel == null) {
            return 0;
        }
        int i2 = 1;
        for (int i3 = i + 1; i3 < this.i.size() && this.i.get(i3).type == 1; i3++) {
            i2++;
        }
        return i + i2;
    }

    public void i(boolean z) {
        CommentViewModel commentViewModel = this.m;
        if (commentViewModel.footerShow != z) {
            commentViewModel.footerShow = z;
            notifyDataSetChanged();
        }
    }

    public void j() {
        this.i.clear();
        this.m.commentLoadState = new CommentLoadState();
        this.i.add(this.m);
        notifyDataSetChanged();
        G();
    }

    public int k(CommentViewModel commentViewModel, int i) {
        int i2;
        boolean z;
        int i3;
        if (commentViewModel.type == 0) {
            i2 = 1;
            z = true;
            for (int i4 = i + 1; i4 < this.i.size() && ((i3 = this.i.get(i4).type) == 1 || i3 == 2); i4++) {
                i2++;
                if (i3 == 2) {
                    z = false;
                }
            }
        } else {
            i2 = 1;
            z = true;
        }
        l(i, i2);
        return z ? i2 : commentViewModel.getCRReplyCnt() + 1;
    }

    public final void l(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            if (i3 < i || i3 >= i + i2) {
                arrayList.add(this.i.get(i3));
            }
        }
        this.i.clear();
        this.i.addAll(arrayList);
        if (this.i.size() == 1 && this.i.get(0) == this.m) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeRemoved(i, i2);
            if (i != this.i.size() - 1) {
                notifyItemRangeChanged(i, this.i.size() - i);
            }
        }
        G();
    }

    public final List<CommentItem> m(List<CommentItem> list) {
        ArrayList arrayList = new ArrayList();
        if (this.k == null) {
            return list;
        }
        for (CommentItem commentItem : list) {
            if (!this.k.contains(Long.valueOf(commentItem.getCmtId()))) {
                arrayList.add(commentItem);
            }
        }
        return arrayList;
    }

    public final List<CommentReplyItem> n(List<CommentReplyItem> list) {
        ArrayList arrayList = new ArrayList();
        if (this.k != null) {
            for (CommentReplyItem commentReplyItem : list) {
                if (!this.k.contains(Long.valueOf(commentReplyItem.getReplyId()))) {
                    arrayList.add(commentReplyItem);
                }
            }
        } else if (list != null) {
            return list;
        }
        return arrayList;
    }

    public final void o(View view, boolean z) {
        if (view != null) {
            if (!this.q || z) {
                this.q = true;
                view.setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.f = alphaAnimation;
                alphaAnimation.setDuration(2000L);
                this.f.setAnimationListener(new a(view));
                view.startAnimation(this.f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0201  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i) {
        View view;
        View view2;
        int i2;
        int i3;
        int i4;
        String str;
        int i5;
        int i6;
        CommentViewModel commentViewModel = this.i.get(i);
        e eVar = new e(i);
        f fVar = new f(i);
        int i7 = commentViewModel.type;
        if (i7 == 0) {
            CommentViewHolder commentViewHolder = (CommentViewHolder) viewHolder;
            eVar.a(commentViewHolder);
            View view3 = commentViewHolder.o;
            if (view3 != null) {
                view3.setVisibility(i > 0 ? 0 : 4);
            }
            UserInfoItem userInfoItemU = u(commentViewModel.getCRUser());
            gr2.j().h(k86.p(userInfoItemU.getHeadUrl()), commentViewHolder.d, a46.l());
            commentViewHolder.d.changeShapeType(1);
            if (commentViewModel.getCommentReplyOperater() != null && commentViewModel.getCommentReplyOperater().getCRUser() != null) {
                if (!"lx".equals(commentViewModel.getCommentReplyOperater().getCRUser().getAccFrom()) && "wifi".equals(commentViewModel.getCommentReplyOperater().getCRUser().getAccFrom())) {
                    commentViewHolder.d.setAlpha(0.5f);
                } else {
                    commentViewHolder.d.setAlpha(1.0f);
                }
            }
            if (userInfoItemU.getSex() == 1) {
                commentViewHolder.e.setImageResource(R$drawable.icon_sex_female);
            } else if (userInfoItemU.getSex() == 0) {
                commentViewHolder.e.setImageResource(R$drawable.icon_sex_male);
            }
            commentViewHolder.f.setText(userInfoItemU.getName());
            int iG = fg6.g(userInfoItemU.getContactExtBean());
            if (fg6.q(iG)) {
                commentViewHolder.r.setImageResource(fg6.c(iG));
                commentViewHolder.r.setVisibility(0);
            } else {
                commentViewHolder.r.setVisibility(8);
            }
            commentViewHolder.f.setTextColor(fg6.o(this.n, iG));
            if (commentViewModel.isAuthor()) {
                i5 = 0;
                commentViewHolder.g.setVisibility(0);
                i6 = 8;
            } else {
                i5 = 0;
                i6 = 8;
                commentViewHolder.g.setVisibility(8);
            }
            if (commentViewModel.isAuthorLike()) {
                commentViewHolder.m.setVisibility(i5);
            } else {
                commentViewHolder.m.setVisibility(i6);
            }
            commentViewHolder.j.setOnClickListener(eVar);
            commentViewHolder.d.setOnClickListener(eVar);
            commentViewHolder.f.setOnClickListener(eVar);
            commentViewHolder.j.updateView(commentViewModel);
            commentViewHolder.k.setOnLongClickListener(fVar);
            commentViewHolder.k.setOnClickListener(eVar);
            String strC = ri0.c(this.n, commentViewModel.getCRTime());
            CommentViewModel.SendStatus sendStatus = commentViewModel.sendStatus;
            CommentViewModel.SendStatus sendStatus2 = CommentViewModel.SendStatus.FAIL;
            if (sendStatus == sendStatus2 || sendStatus == CommentViewModel.SendStatus.RESENDSUCCESS || sendStatus == CommentViewModel.SendStatus.SENDING) {
                commentViewHolder.j.setVisibility(4);
                strC = null;
            } else {
                commentViewHolder.j.setVisibility(0);
            }
            commentViewHolder.j.setVisibility(this.h ? 0 : 8);
            commentViewHolder.i.setOnLongClickListener(fVar);
            commentViewHolder.i.setEmojiText(ri0.a(this.n, commentViewModel.getCRContent(), null, "", null));
            if (si0.d()) {
                boolean z = commentViewModel.commentItem.isAduit;
                int i8 = R$drawable.square_comment_varifing;
                A(z, commentViewHolder, i8, i8);
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(strC)) {
                sb.append(strC);
            }
            String cRCity = commentViewModel.getCRCity();
            str = TextUtils.isEmpty(cRCity) ? "未知" : cRCity;
            if (gi5.s()) {
                if (sb.length() > 0) {
                    sb.append(" · ");
                }
                sb.append(str);
            }
            if (!TextUtils.isEmpty(sb)) {
                commentViewHolder.p.setText(sb);
            }
            commentViewHolder.q.setOnClickListener(new b(commentViewModel, i));
            commentViewHolder.q.setVisibility(0);
            CommentViewModel.SendStatus sendStatus3 = commentViewModel.sendStatus;
            if (sendStatus3 == sendStatus2 || sendStatus3 == CommentViewModel.SendStatus.RESENDSUCCESS) {
                commentViewHolder.l.setVisibility(0);
            } else {
                commentViewHolder.l.setVisibility(8);
            }
            commentViewHolder.l.setOnClickListener(eVar);
            view2 = commentViewModel.needHighLightAnimation ? commentViewHolder.n : null;
        } else if (i7 == 1) {
            ReplyViewHolder replyViewHolder = (ReplyViewHolder) viewHolder;
            eVar.a(replyViewHolder);
            UserInfoItem userInfoItemU2 = u(commentViewModel.getCRUser());
            gr2.j().h(k86.p(userInfoItemU2.getHeadUrl()), replyViewHolder.d, a46.l());
            replyViewHolder.d.changeShapeType(1);
            if (commentViewModel.getCommentReplyOperater() != null && commentViewModel.getCommentReplyOperater().getCRUser() != null) {
                if (!"lx".equals(commentViewModel.getCommentReplyOperater().getCRUser().getAccFrom()) && "wifi".equals(commentViewModel.getCommentReplyOperater().getCRUser().getAccFrom())) {
                    replyViewHolder.d.setAlpha(0.5f);
                } else {
                    replyViewHolder.d.setAlpha(1.0f);
                }
            }
            if (userInfoItemU2.getSex() == 1) {
                replyViewHolder.e.setImageResource(R$drawable.icon_sex_female);
            } else if (userInfoItemU2.getSex() == 0) {
                replyViewHolder.e.setImageResource(R$drawable.icon_sex_male);
            }
            replyViewHolder.f.setText(userInfoItemU2.getName());
            int iG2 = fg6.g(userInfoItemU2.getContactExtBean());
            if (fg6.q(iG2)) {
                replyViewHolder.r.setImageResource(fg6.e(iG2));
                replyViewHolder.r.setVisibility(0);
            } else {
                replyViewHolder.r.setVisibility(8);
            }
            replyViewHolder.f.setTextColor(fg6.o(this.n, iG2));
            if (commentViewModel.isAuthor()) {
                i3 = 0;
                replyViewHolder.g.setVisibility(0);
                i4 = 8;
            } else {
                i3 = 0;
                i4 = 8;
                replyViewHolder.g.setVisibility(8);
            }
            if (commentViewModel.isAuthorLike()) {
                replyViewHolder.m.setVisibility(i3);
            } else {
                replyViewHolder.m.setVisibility(i4);
            }
            int discussionType = commentViewModel.commentReplyItem.getDiscussionType();
            String str2 = (discussionType == 1 || discussionType == 2) ? null : commentViewModel.commentReplyItem.toNickname;
            replyViewHolder.d.setOnClickListener(eVar);
            replyViewHolder.f.setOnClickListener(eVar);
            replyViewHolder.j.setOnClickListener(eVar);
            replyViewHolder.j.updateView(commentViewModel);
            replyViewHolder.k.setOnLongClickListener(fVar);
            replyViewHolder.k.setOnClickListener(eVar);
            String strC2 = ri0.c(this.n, commentViewModel.getCRTime());
            CommentViewModel.SendStatus sendStatus4 = commentViewModel.sendStatus;
            CommentViewModel.SendStatus sendStatus5 = CommentViewModel.SendStatus.FAIL;
            if (sendStatus4 == sendStatus5 || sendStatus4 == CommentViewModel.SendStatus.RESENDSUCCESS || sendStatus4 == CommentViewModel.SendStatus.SENDING) {
                replyViewHolder.j.setVisibility(4);
                strC2 = null;
            } else {
                replyViewHolder.j.setVisibility(0);
            }
            replyViewHolder.j.setVisibility(this.h ? 0 : 8);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(strC2)) {
                sb2.append(strC2);
            }
            String cRCity2 = commentViewModel.getCRCity();
            str = TextUtils.isEmpty(cRCity2) ? "未知" : cRCity2;
            if (gi5.s()) {
                if (sb2.length() > 0) {
                    sb2.append(" · ");
                }
                sb2.append(str);
            }
            if (!TextUtils.isEmpty(sb2)) {
                replyViewHolder.p.setText(sb2);
            }
            replyViewHolder.q.setOnClickListener(new c(commentViewModel, i));
            replyViewHolder.q.setVisibility(0);
            replyViewHolder.i.setOnLongClickListener(fVar);
            replyViewHolder.i.setEmojiText(ri0.a(this.n, commentViewModel.getCRContent(), str2, "", new d(commentViewModel)));
            if (si0.d()) {
                boolean z2 = commentViewModel.commentReplyItem.isAduit;
                int i9 = R$drawable.square_comment_varifing;
                A(z2, replyViewHolder, i9, i9);
            }
            CommentViewModel.SendStatus sendStatus6 = commentViewModel.sendStatus;
            if (sendStatus6 == sendStatus5 || sendStatus6 == CommentViewModel.SendStatus.RESENDSUCCESS) {
                replyViewHolder.l.setVisibility(0);
            } else {
                replyViewHolder.l.setVisibility(8);
            }
            replyViewHolder.l.setOnClickListener(eVar);
            if (commentViewModel.needHighLightAnimation) {
                view2 = replyViewHolder.n;
            }
        } else {
            if (i7 == 3) {
                FooterViewHolder footerViewHolder = (FooterViewHolder) viewHolder;
                ViewGroup.LayoutParams layoutParams = footerViewHolder.d.getLayoutParams();
                if (getItemCount() == 1) {
                    layoutParams.height = 0;
                } else if (commentViewModel.footerShow) {
                    layoutParams.height = k36.c(this.n);
                } else {
                    layoutParams.height = me1.b(this.n, 80);
                }
                footerViewHolder.d.setLayoutParams(layoutParams);
                if (commentViewModel.commentLoadState.hasMore) {
                    footerViewHolder.g.setVisibility(8);
                    footerViewHolder.h.setVisibility(8);
                    footerViewHolder.e.setText(R$string.square_comment_loadmore);
                    i2 = 0;
                } else {
                    i2 = 0;
                    footerViewHolder.g.setVisibility(0);
                    footerViewHolder.h.setVisibility(0);
                    footerViewHolder.e.setText(R$string.square_comment_nomore);
                }
                if (commentViewModel.commentLoadState.isLoading) {
                    footerViewHolder.f.setVisibility(i2);
                    footerViewHolder.e.setVisibility(8);
                } else {
                    footerViewHolder.f.setVisibility(8);
                    footerViewHolder.e.setVisibility(i2);
                }
                view = null;
                viewHolder.itemView.setOnLongClickListener(null);
                footerViewHolder.i.setOnClickListener(eVar);
            } else {
                view = null;
                ReplyLoadMoreViewHolder replyLoadMoreViewHolder = (ReplyLoadMoreViewHolder) viewHolder;
                if (this.i.get(Math.max(0, i - 1)).commentItem != null) {
                    replyLoadMoreViewHolder.f.setPadding(k36.b(62.0f), 0, 0, 0);
                } else {
                    replyLoadMoreViewHolder.f.setPadding(k36.b(94.0f), 0, 0, 0);
                }
                replyLoadMoreViewHolder.d.setText(this.n.getString(R$string.square_comment_loadmore_reply_sec));
                replyLoadMoreViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.square_coment_item_loadmore_arrow, 0);
                if (commentViewModel.commentLoadState.isLoading) {
                    replyLoadMoreViewHolder.e.setVisibility(0);
                    replyLoadMoreViewHolder.d.setVisibility(8);
                } else {
                    replyLoadMoreViewHolder.e.setVisibility(8);
                    replyLoadMoreViewHolder.d.setVisibility(0);
                }
                replyLoadMoreViewHolder.f.setOnClickListener(eVar);
            }
            view2 = view;
        }
        CommentItem commentItem = commentViewModel.commentItem;
        o(view2, commentItem != null ? commentItem.isNeedHl : false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new CommentViewHolder(View.inflate(viewGroup.getContext(), R$layout.square_comment_item, null)) : i == 1 ? new ReplyViewHolder(View.inflate(viewGroup.getContext(), R$layout.square_comment_item_reply, null)) : i == 3 ? new FooterViewHolder(View.inflate(viewGroup.getContext(), R$layout.square_comment_item_footer, null)) : new ReplyLoadMoreViewHolder(View.inflate(viewGroup.getContext(), R$layout.square_comment_item_reply_loadmore, null));
    }

    public List<CommentViewModel> p() {
        return this.i;
    }

    public int q(long j) {
        int i = 0;
        int replyCnt = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            CommentViewModel commentViewModel = this.i.get(i2);
            int i3 = commentViewModel.type;
            if (i3 == 0) {
                if (commentViewModel.commentItem.getCmtId() == j) {
                    replyCnt = commentViewModel.commentItem.getReplyCnt();
                }
            } else if (i3 == 1 && commentViewModel.commentReplyItem.getCmtId() == j) {
                i++;
            }
        }
        return i - replyCnt;
    }

    public CommentViewModel r() {
        return this.m;
    }

    public CommentViewModel s(long j) {
        List<CommentViewModel> list = this.i;
        if (list == null) {
            return null;
        }
        for (CommentViewModel commentViewModel : list) {
            CommentItem commentItem = commentViewModel.commentItem;
            if (commentItem != null && commentItem.getCmtId() == j) {
                return commentViewModel;
            }
        }
        return null;
    }

    public int t() {
        int iMax = 0;
        int replyCnt = 0;
        int i = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            CommentViewModel commentViewModel = this.i.get(i2);
            int i3 = commentViewModel.type;
            if (i3 == 0) {
                iMax += Math.max(replyCnt, i) + 1;
                replyCnt = commentViewModel.commentItem.getReplyCnt();
            } else {
                if (i3 == 1) {
                    i++;
                } else if (i3 == 3) {
                    iMax += Math.max(replyCnt, i);
                }
            }
            i = 0;
        }
        return iMax;
    }

    public final void v() {
        CommentViewModel commentViewModel = new CommentViewModel(3, null, null);
        this.m = commentViewModel;
        commentViewModel.commentLoadState = new CommentLoadState();
        this.i.add(this.m);
    }

    public void w(View view, CommentViewHolder commentViewHolder, int i) {
        List<CommentViewModel> list = this.i;
        if (list == null || i >= list.size()) {
            return;
        }
        CommentViewModel commentViewModel = this.i.get(i);
        int id = view.getId();
        if (id == R$id.likeLayout) {
            F(((CommentLikeView) view).getIconView());
            this.p.d(commentViewHolder, commentViewModel, i);
            return;
        }
        if (id == R$id.videosdk_comment_item_layout || id == R$id.commentContent) {
            this.p.b(commentViewModel, i);
            return;
        }
        if (id != R$id.nickName && id != R$id.commentUserAvatar) {
            if (id != R$id.sendFailedTV && id == R$id.loadMoreLayout) {
                this.p.a(commentViewModel, i);
                return;
            }
            return;
        }
        if (this.l == null || commentViewModel.getCommentReplyOperater() == null || commentViewModel.getCommentReplyOperater().getCRUser() == null) {
            return;
        }
        UserInfoItem cRUser = commentViewModel.getCommentReplyOperater().getCRUser();
        z66.c(10, this.l.id, cRUser.getUid(), cRUser.getExid(), this.l, this.n);
    }

    public void x(View view, int i) {
        CommentViewModel commentViewModel = this.i.get(i);
        int id = view.getId();
        if (id == R$id.videosdk_comment_item_layout || id == R$id.commentContent) {
            this.p.c(commentViewModel, i);
        }
    }

    public void y(CommentItem commentItem, List<CommentItem> list, long j, boolean z) {
        this.i.clear();
        if (list != null) {
            this.i.addAll(CommentViewModel.genCommentViewModel(m(list), j));
        }
        H(false, z);
        this.i.add(this.m);
        notifyDataSetChanged();
        G();
    }

    public void z() {
        AlphaAnimation alphaAnimation = this.f;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f16189a;

        public a(View view) {
            this.f16189a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f16189a.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public final UserInfoItem u(UserInfoItem userInfoItem) {
        return userInfoItem;
    }
}
