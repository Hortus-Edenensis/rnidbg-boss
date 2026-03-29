package com.zenmen.square.comment.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bytedance.bpea.entry.common.DataType;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.friendcircle.bean.SquareSimpleComment;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.comment.model.CommentChangeInfo;
import com.zenmen.square.comment.model.CommentLoadState;
import com.zenmen.square.comment.model.CommentModel;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.model.GetCommentsParam;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.comment.model.UserInfoItem;
import com.zenmen.square.comment.struct.CommentItem;
import com.zenmen.square.comment.struct.CommentReplyItem;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.comment.ui.CommentAdapter;
import com.zenmen.square.comment.ui.CommentListView;
import com.zenmen.square.comment.ui.a;
import com.zenmen.square.comment.widget.RichTextView;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import defpackage.an1;
import defpackage.ap3;
import defpackage.ay5;
import defpackage.b05;
import defpackage.cw4;
import defpackage.et2;
import defpackage.mi0;
import defpackage.nq3;
import defpackage.oi0;
import defpackage.qi0;
import defpackage.qj5;
import defpackage.qq3;
import defpackage.sd3;
import defpackage.si0;
import defpackage.sy5;
import defpackage.ti0;
import defpackage.v4;
import defpackage.xl1;
import defpackage.yk2;
import defpackage.zk5;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentDialog extends LXBottomSheetDialog implements com.zenmen.square.comment.ui.b {
    public ResultBean A;
    public ResultBean B;
    public int C;
    public long E;
    public yk2 F;
    public oi0 G;
    public qi0 H;
    public Map<Long, Integer> I;
    public Context J;
    public String K;
    public View L;
    public boolean M;
    public SquareFeed N;
    public int O;
    public int P;
    public nq3.b Q;
    public CommentListView h;
    public CommentAdapter i;
    public View j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public RichTextView n;
    public TextView o;
    public View p;
    public TextView q;
    public TextView r;
    public View s;
    public View t;
    public RichTextView u;
    public ImageView v;
    public ay5 w;
    public boolean x;
    public et2 y;
    public UserInfoItem z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f16195a;
        public final /* synthetic */ int b;

        public a(CommentViewModel commentViewModel, int i) {
            this.f16195a = commentViewModel;
            this.b = i;
        }

        @Override // com.zenmen.square.comment.ui.a.d
        public void a(com.zenmen.square.comment.ui.a aVar, a.c cVar) {
            if (cVar.e() == 0) {
                CommentDialog.this.T(this.f16195a.getCRContent());
                return;
            }
            if (cVar.e() == 1) {
                qj5.j(CommentDialog.this.N, this.f16195a.getCRUser().getExid());
                CommentDialog.this.G.i(CommentDialog.this.getContext(), CommentDialog.this.N, this.f16195a);
            } else if (cVar.e() == 2) {
                qj5.k(CommentDialog.this.N, this.f16195a.getCRUser().getExid());
                CommentDialog.this.f0(this.f16195a, this.b);
            } else {
                if (cVar.e() == 3) {
                    return;
                }
                cVar.e();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f16196a;
        public final /* synthetic */ int b;

        public b(CommentViewModel commentViewModel, int i) {
            this.f16196a = commentViewModel;
            this.b = i;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            materialDialog.cancel();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            CommentDialog.this.U(this.f16196a, this.b);
            materialDialog.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements nq3.b {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CommentDialog.this.i.i(false);
            }
        }

        public d() {
        }

        @Override // nq3.b
        public void a(int i, Object obj, int i2) {
            CommentViewModel commentViewModelS;
            CommentItem commentItem;
            if (i == 1) {
                CommentViewModel commentViewModel = (CommentViewModel) obj;
                if (CommentDialog.this.X()) {
                    if (CommentDialog.this.h.needScrollToPosition(i2)) {
                        CommentDialog.this.h.scrollToPosition(i2);
                    }
                    CommentDialog.this.i.e(commentViewModel, i2);
                }
                if (CommentDialog.this.i != null && commentViewModel != null && commentViewModel.commentReplyItem != null && (commentViewModelS = CommentDialog.this.i.s(commentViewModel.commentReplyItem.getCmtId())) != null && (commentItem = commentViewModelS.commentItem) != null) {
                    CommentDialog.this.I.put(Long.valueOf(commentViewModelS.commentItem.getCmtId()), Integer.valueOf((CommentDialog.this.I.containsKey(Long.valueOf(commentItem.getCmtId())) ? CommentDialog.this.I.get(Long.valueOf(commentViewModelS.commentItem.getCmtId())).intValue() : 0) + 1));
                    CommentItem commentItem2 = commentViewModelS.commentItem;
                    commentItem2.setReplyCnt(commentItem2.getReplyCnt() + 1);
                }
                CommentDialog.this.i0(null);
                CommentDialog.this.h0(new CommentChangeInfo(CommentChangeInfo.STATE.ADD, 1));
                sy5.e(CommentDialog.this.getContext(), R$string.square_comment_send_success, 0).g();
                return;
            }
            if (i == 4) {
                String str = (String) obj;
                if (CommentDialog.this.X()) {
                    if (i2 < 0) {
                        CommentDialog.this.h.smoothScrollBy(0, -CommentDialog.this.C);
                    }
                    CommentDialog.this.C = 0;
                    CommentDialog.this.h.postDelayed(new a(), 500L);
                    CommentDialog.this.i.G();
                }
                CommentDialog.this.i0(str);
                return;
            }
            if (i == 2) {
                UnitedException unitedException = (UnitedException) obj;
                if (!TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.f(CommentDialog.this.J, unitedException.getErrorMsg(), 1).g();
                    return;
                }
                if (unitedException.getCode() != 1901 && unitedException.getCode() != 1911) {
                    sy5.e(CommentDialog.this.J, R$string.square_http_error, 1).g();
                    return;
                }
                if (!TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.f(CommentDialog.this.J, unitedException.getErrorMsg(), 1).g();
                } else if (unitedException.getCode() == 1911) {
                    sy5.e(CommentDialog.this.J, com.zenmen.palmchat.friendcircle.R$string.feed_comment_delete_error, 1).g();
                } else {
                    sy5.e(CommentDialog.this.J, com.zenmen.palmchat.friendcircle.R$string.feed_content_delete_error, 1).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ti0.c {
        public e() {
        }

        @Override // ti0.c
        public void a(CommentViewModel commentViewModel, int i) {
            CommentDialog.this.a0(commentViewModel, i);
        }

        @Override // ti0.c
        public void b(CommentViewModel commentViewModel, int i) throws Throwable {
            CommentDialog commentDialog = CommentDialog.this;
            commentDialog.g0(commentDialog.u.getText().toString(), commentViewModel, i, false);
        }

        @Override // ti0.c
        public void c(CommentViewModel commentViewModel, int i) {
            CommentDialog.this.e0(commentViewModel, i);
        }

        @Override // ti0.c
        public void d(CommentAdapter.CommentViewHolder commentViewHolder, CommentViewModel commentViewModel, int i) {
            if (si0.e(commentViewModel)) {
                CommentDialog commentDialog = CommentDialog.this;
                commentDialog.Y(commentViewHolder, commentViewModel, i, commentDialog.B);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements CommentListView.c {
        public f() {
        }

        @Override // com.zenmen.square.comment.ui.CommentListView.c
        public void a() {
            CommentViewModel commentViewModelR = CommentDialog.this.i.r();
            int itemCount = CommentDialog.this.i.getItemCount() - 1;
            if (commentViewModelR != null) {
                CommentLoadState commentLoadState = commentViewModelR.commentLoadState;
                if (!commentLoadState.hasMore || commentLoadState.isLoading) {
                    return;
                }
                commentLoadState.isLoading = true;
                CommentDialog.this.i.I(commentViewModelR, itemCount);
                CommentDialog.this.a0(commentViewModelR, itemCount);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CommentDialog.this.M) {
                CommentDialog.this.b0();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommentDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            CommentDialog commentDialog = CommentDialog.this;
            commentDialog.g0(commentDialog.u.getText().toString(), null, -1, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            CommentDialog commentDialog = CommentDialog.this;
            commentDialog.g0(commentDialog.u.getText().toString(), null, -1, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f16206a;

        public k(View view) {
            this.f16206a = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ap3.a().x().c();
            this.f16206a.setVisibility(8);
        }
    }

    public CommentDialog(Context context, SquareFeed squareFeed) {
        super(context);
        this.w = new ay5();
        this.C = 0;
        this.E = 0L;
        this.I = new HashMap();
        this.M = false;
        this.O = 0;
        this.P = 0;
        this.Q = new d();
        b05.d("CommentDialog()");
        this.J = context;
        xl1.e(context);
        this.N = squareFeed;
        this.G = new oi0(context, squareFeed);
        this.H = new qi0();
        UserInfoItem userInfoItemH = this.G.h();
        this.z = userInfoItemH;
        et2 et2Var = new et2((Activity) context, this, userInfoItemH, squareFeed);
        this.y = et2Var;
        et2Var.h(this.Q);
        this.y.c(new c());
        if (squareFeed.businessFrom == 1) {
            this.F = new qq3(context);
        } else {
            this.F = new CommentModel();
        }
        this.y.f(this.F);
        this.G.c(this);
    }

    public final void S(ViewGroup viewGroup) {
        this.h = (CommentListView) viewGroup.findViewById(R$id.commentList);
        ArrayList arrayList = new ArrayList();
        this.j = viewGroup.findViewById(R$id.vs_comment_emptyview);
        this.k = (ImageView) viewGroup.findViewById(R$id.vs_comment_emptyview_icon);
        TextView textView = (TextView) viewGroup.findViewById(R$id.vs_comment_emptyview_text);
        this.l = textView;
        textView.setText(si0.c(getContext()));
        CommentAdapter commentAdapter = new CommentAdapter(getContext(), this.N, arrayList, this.z);
        this.i = commentAdapter;
        if (this.N.businessFrom == 1) {
            commentAdapter.C(false);
        } else {
            commentAdapter.C(true);
        }
        this.i.B(this.j);
        this.i.D(new e());
        this.h.setAdapter(this.i);
        this.h.setOnLoadMoreListener(new f());
        this.i.notifyDataSetChanged();
        this.p = viewGroup.findViewById(R$id.video_tab_loading_view);
        this.j.setOnClickListener(new g());
        this.q = (TextView) viewGroup.findViewById(R$id.vs_comment_title);
        this.r = (TextView) viewGroup.findViewById(R$id.tv_comment_count);
        this.s = viewGroup.findViewById(R$id.rl_comment_title);
        View viewFindViewById = viewGroup.findViewById(R$id.vs_comment_close);
        this.t = viewFindViewById;
        viewFindViewById.setOnClickListener(new h());
        RichTextView richTextView = (RichTextView) viewGroup.findViewById(R$id.edit_message_area);
        this.u = richTextView;
        richTextView.setHint(si0.b(getContext()));
        this.u.setOnClickListener(new i());
        ResultBean resultBean = this.B;
        if (resultBean != null) {
            i0(resultBean.commentContent);
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.vs_comment_emoji);
        this.v = imageView;
        imageView.setOnClickListener(new j());
        this.x = true;
        View viewFindViewById2 = viewGroup.findViewById(R$id.input_rl);
        this.L = viewFindViewById2;
        viewFindViewById2.setVisibility(0);
        V(viewGroup);
    }

    public final void T(String str) {
        ((ClipboardManager) getContext().getSystemService(DataType.CLIPBOARD)).setText(str);
    }

    public final void U(CommentViewModel commentViewModel, int i2) {
        this.G.d(this.N, commentViewModel, i2, this.B, this.z.getWid());
    }

    public final void V(View view) {
        View viewFindViewById = view.findViewById(R$id.risk_notify_layout);
        String strA = ap3.a().x().a();
        if (TextUtils.isEmpty(strA)) {
            viewFindViewById.setVisibility(8);
            return;
        }
        zn6.b("risktip_feedcomment");
        viewFindViewById.setVisibility(0);
        ((TextView) view.findViewById(R$id.risk_notify_tv)).setText(strA);
        view.findViewById(R$id.risk_notify_close).setOnClickListener(new k(viewFindViewById));
    }

    public final void W() {
        getWindow().setDimAmount(o() == null ? 0.6f : 0.0f);
    }

    public final boolean X() {
        return this.x;
    }

    public final void Y(CommentAdapter.CommentViewHolder commentViewHolder, CommentViewModel commentViewModel, int i2, ResultBean resultBean) {
        this.G.j(commentViewHolder, this.N, commentViewModel, this.B, this.z.getWid(), resultBean);
    }

    public final void Z(ResultBean resultBean) {
        c0(resultBean);
        b0();
    }

    @Override // com.zenmen.square.comment.ui.b
    public void a(mi0 mi0Var, CommentViewModel commentViewModel, int i2) {
        CommentLoadState commentLoadState = commentViewModel.commentLoadState;
        boolean zG = mi0Var.g();
        commentLoadState.isLoading = false;
        commentLoadState.hasMore = zG;
        commentLoadState.nextLoadSeq = mi0Var.d();
        commentLoadState.nextLoadWeight = mi0Var.f();
        commentLoadState.score = mi0Var.c();
        if (mi0Var.a().size() > 0) {
            commentLoadState.version = mi0Var.a().get(mi0Var.a().size() - 1).version;
        }
        this.i.I(commentViewModel, i2);
        this.i.d(mi0Var.a(), mi0Var.b(), i2);
        if (zG) {
            return;
        }
        h0(new CommentChangeInfo(CommentChangeInfo.STATE.COMMENT_LOADMOREFINISH, this.i.t()));
    }

    public final void a0(CommentViewModel commentViewModel, int i2) {
        if (commentViewModel.type != 2) {
            if (commentViewModel.commentLoadState == null) {
                Log.e("findbugs", "model.commentLoadState is null");
                return;
            }
            GetCommentsParam getCommentsParam = new GetCommentsParam();
            SquareFeed squareFeed = this.N;
            getCommentsParam.feed = squareFeed.momentsFeed;
            getCommentsParam.version = commentViewModel.commentLoadState.version;
            getCommentsParam.feedId = squareFeed.id;
            getCommentsParam.reqListType = 1;
            getCommentsParam.exFeedUid = squareFeed.exid;
            this.G.f(getCommentsParam, commentViewModel, this.B.getId(), this.B.getExtInfo(), i2);
            return;
        }
        qj5.o(this.N);
        GetCommentsParam getCommentsParam2 = new GetCommentsParam();
        SquareFeed squareFeed2 = this.N;
        getCommentsParam2.feed = squareFeed2.momentsFeed;
        getCommentsParam2.version = commentViewModel.commentLoadState.version;
        getCommentsParam2.feedId = squareFeed2.id;
        getCommentsParam2.reqListType = 2;
        getCommentsParam2.exFeedUid = squareFeed2.exid;
        getCommentsParam2.toDiscussionId = commentViewModel.getCRId();
        getCommentsParam2.exToDiscussionUid = commentViewModel.getCRUser().getExid();
        this.G.g(getCommentsParam2, commentViewModel, this.B.getId(), this.B.getExtInfo(), i2);
        this.i.I(commentViewModel, i2);
    }

    @Override // com.zenmen.square.comment.ui.b
    public void b(UnitedException unitedException) {
        this.p.setVisibility(8);
        this.j.setVisibility(0);
        this.k.setImageResource(R$drawable.icon_square_comment_state_err);
        String string = this.J.getString(R$string.square_http_error);
        if (!TextUtils.isEmpty(unitedException.getErrorMsg())) {
            string = this.J.getString(R$string.square_fvt_comment_dialog_load_fail);
        }
        this.l.setText(string);
        sy5.f(this.J, string, 0).g();
    }

    public final void b0() {
        this.I.clear();
        this.i.E(this.B);
        this.i.j();
        this.j.setVisibility(8);
        this.p.setVisibility(0);
        CommentLoadState commentLoadState = this.i.r().commentLoadState;
        GetCommentsParam getCommentsParam = new GetCommentsParam();
        SquareFeed squareFeed = this.N;
        getCommentsParam.feed = squareFeed.momentsFeed;
        getCommentsParam.exFeedUid = squareFeed.exid;
        getCommentsParam.feedId = squareFeed.id;
        getCommentsParam.reqListType = 1;
        getCommentsParam.version = 0L;
        this.G.e(getCommentsParam);
    }

    @Override // com.zenmen.square.comment.ui.b
    public SquareFeed c() {
        return this.N;
    }

    public final void c0(ResultBean resultBean) {
        this.B = resultBean;
        this.A = resultBean;
        i0(resultBean.commentContent);
        h0(new CommentChangeInfo(CommentChangeInfo.STATE.REFRESH, 0));
    }

    @Override // com.zenmen.square.comment.ui.b
    public void d(CommentAdapter.CommentViewHolder commentViewHolder, Boolean bool, CommentViewModel commentViewModel, String str) {
        boolean zIsCRLike = commentViewModel.isCRLike();
        if (bool.booleanValue()) {
            commentViewModel.setCRLike(!zIsCRLike);
            commentViewModel.setCRLikeCnt(Math.max(0, commentViewModel.getCRLikeCnt() + (zIsCRLike ? -1 : 1)));
            if (commentViewHolder != null) {
                commentViewHolder.j.updateView(commentViewModel);
                commentViewHolder.m.setVisibility(commentViewModel.isAuthorLike() ? 0 : 8);
            }
        }
    }

    public void d0(ResultBean resultBean, int i2, int i3) {
        show();
        resultBean.setCommentCount(this.N.discussionNum);
        this.O = i2;
        this.P = i3;
        this.K = resultBean.getChannelId();
        Z(resultBean);
        this.E = System.currentTimeMillis();
        this.L.setVisibility(0);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        CommentAdapter commentAdapter = this.i;
        if (commentAdapter != null) {
            commentAdapter.z();
        }
    }

    @Override // com.zenmen.square.comment.ui.b
    public void e(CommentViewModel commentViewModel, int i2, cw4 cw4Var) {
        CommentReplyItem commentReplyItem;
        CommentItem commentItem;
        if (this.i.p() != null && cw4Var.a() != null) {
            Iterator<CommentReplyItem> it = cw4Var.a().iterator();
            while (it.hasNext()) {
                CommentReplyItem next = it.next();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.i.p().size()) {
                        break;
                    }
                    CommentViewModel commentViewModel2 = this.i.p().get(i3);
                    int i4 = commentViewModel2.type;
                    if (i4 != 0 || (commentItem = commentViewModel2.commentItem) == null) {
                        if (i4 == 1 && (commentReplyItem = commentViewModel2.commentReplyItem) != null && commentReplyItem.getReplyId() == next.getReplyId()) {
                            it.remove();
                            break;
                        }
                        i3++;
                    } else {
                        if (commentItem.getCmtId() == next.getReplyId()) {
                            it.remove();
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        Log.d("onLoadMoreReplySuc", "onLoadMoreReplySuc total cmt count=" + commentViewModel.commentItem.getReplyCnt());
        CommentLoadState commentLoadState = commentViewModel.commentLoadState;
        if (!this.I.containsKey(Long.valueOf(commentViewModel.commentItem.getCmtId()))) {
            Log.d("onLoadMoreReplySuc", "onLoadMoreReplySuc init filter replies count=" + commentLoadState.filterReplies.size());
            this.I.put(Long.valueOf(commentViewModel.commentItem.getCmtId()), Integer.valueOf(commentLoadState.filterReplies.size()));
        }
        long j2 = commentLoadState.commentId;
        int size = cw4Var.a().size();
        Log.d("onLoadMoreReplySuc", "onLoadMoreReplySuc curnt load replies count=" + size);
        int iIntValue = (this.I.containsKey(Long.valueOf(commentViewModel.commentItem.getCmtId())) ? this.I.get(Long.valueOf(commentViewModel.commentItem.getCmtId())).intValue() : 0) + size;
        Log.d("onLoadMoreReplySuc", "onLoadMoreReplySuc total load replies count=" + iIntValue);
        this.I.put(Long.valueOf(commentViewModel.commentItem.getCmtId()), Integer.valueOf(iIntValue));
        commentLoadState.isLoading = false;
        commentLoadState.remainCount = commentViewModel.commentItem.getReplyCnt() - iIntValue;
        Log.d("onLoadMoreReplySuc", "onLoadMoreReplySuc remainCount=" + commentLoadState.remainCount);
        commentLoadState.hasMore = cw4Var.d();
        if (size > 0) {
            commentLoadState.version = cw4Var.a().get(size - 1).version;
        }
        boolean z = commentLoadState.hasMore;
        commentLoadState.nextLoadCount = 10;
        commentLoadState.nextLoadSeq = cw4Var.b();
        commentLoadState.nextLoadWeight = (int) cw4Var.c();
        if (z) {
            this.i.I(commentViewModel, i2);
        } else {
            this.i.k(commentViewModel, i2);
        }
        this.i.g(cw4Var.a(), z, i2);
        if (z) {
            return;
        }
        h0(new CommentChangeInfo(CommentChangeInfo.STATE.REPLY_LOADMOREFINISH, this.i.q(j2)));
    }

    public final void e0(CommentViewModel commentViewModel, int i2) {
        String strB;
        qj5.n(this.N);
        com.zenmen.square.comment.ui.a aVar = new com.zenmen.square.comment.ui.a(getContext());
        ArrayList arrayList = new ArrayList();
        if (this.N.businessFrom == 1) {
            strB = v4.e(com.zenmen.palmchat.c.b());
        } else {
            strB = v4.b(com.zenmen.palmchat.c.b());
            if (!commentViewModel.getCRUser().getExid().equals(strB)) {
                arrayList.add(new a.c(1, getContext().getString(R$string.square_share_report), R$drawable.square_comment_report_menu));
            }
        }
        if (TextUtils.isEmpty(this.N.exid)) {
            if (!TextUtils.isEmpty(this.N.uid) && (this.N.uid.equals(strB) || commentViewModel.getCRUser().getUid().equals(strB))) {
                arrayList.add(new a.c(2, getContext().getString(R$string.square_comment_delete), R$drawable.square_comment_delete_menu));
            }
        } else if (this.N.exid.equals(strB) || commentViewModel.getCRUser().getExid().equals(strB)) {
            arrayList.add(new a.c(2, getContext().getString(R$string.square_comment_delete), R$drawable.square_comment_delete_menu));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        aVar.f(arrayList);
        aVar.g(new a(commentViewModel, i2));
        aVar.show();
    }

    @Override // com.zenmen.square.comment.ui.b
    public void f(BaseNetBean baseNetBean, CommentViewModel commentViewModel, int i2) {
        List<SquareSimpleComment> list;
        if (!baseNetBean.isSuccess()) {
            sy5.f(getContext(), baseNetBean.getErrMsg(), 1).g();
            return;
        }
        sy5.e(getContext(), R$string.square_comment_delete_success, 1).g();
        h0(new CommentChangeInfo(CommentChangeInfo.STATE.DELETE, -this.i.k(commentViewModel, i2)));
        CommentItem commentItem = commentViewModel.commentItem;
        if (commentItem == null || commentItem.discussionType != 1 || (list = this.N.discussions) == null) {
            return;
        }
        for (SquareSimpleComment squareSimpleComment : list) {
            if (squareSimpleComment.id == commentViewModel.getCRId()) {
                this.N.discussions.remove(squareSimpleComment);
                SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                squareFeedEvent.eventType = 2;
                squareFeedEvent.feed = this.N;
                an1.c().l(squareFeedEvent);
                return;
            }
        }
    }

    public final void f0(CommentViewModel commentViewModel, int i2) {
        new sd3(getContext()).k("确定要删除吗？").P("删除").L("取消").h(false).f(new b(commentViewModel, i2)).e().show();
    }

    @Override // com.zenmen.square.comment.ui.b
    public void g(CommentViewModel commentViewModel, int i2) {
        commentViewModel.commentLoadState.isLoading = false;
        this.i.I(commentViewModel, i2);
    }

    public void g0(String str, CommentViewModel commentViewModel, int i2, boolean z) throws Throwable {
        if (commentViewModel != null) {
            this.i.i(true);
            this.C = this.h.scrollToNextShotDate(i2);
        }
        this.y.i(this.B, str, commentViewModel, i2, this.O, z, this.P);
        this.j.setVisibility(8);
        new HashMap();
    }

    @Override // com.zenmen.square.comment.ui.b
    public int h(CommentViewModel commentViewModel, int i2) {
        CommentAdapter commentAdapter = this.i;
        if (commentAdapter != null) {
            return commentAdapter.h(commentViewModel, i2);
        }
        return 0;
    }

    public void h0(CommentChangeInfo commentChangeInfo) {
        ResultBean resultBean = this.A;
        if (resultBean != null) {
            int iK = this.G.k(commentChangeInfo, resultBean);
            View view = this.s;
            if (view != null) {
                if (iK > 0) {
                    view.setVisibility(0);
                    TextView textView = this.r;
                    if (textView != null) {
                        textView.setText(String.format("(%d)", Integer.valueOf(iK)));
                    }
                } else {
                    view.setVisibility(4);
                }
            }
            TextView textView2 = this.m;
            if (textView2 != null) {
                textView2.setText(zk5.f(iK));
            }
        }
    }

    @Override // android.app.Dialog
    public void hide() {
        super.hide();
        if (this.w.a()) {
            this.w.b();
        }
    }

    @Override // com.zenmen.square.comment.ui.b
    public void i(mi0 mi0Var) throws Throwable {
        this.p.setVisibility(8);
        CommentLoadState commentLoadState = this.i.r().commentLoadState;
        boolean zG = mi0Var.g();
        commentLoadState.nextLoadSeq = mi0Var.d();
        commentLoadState.nextLoadWeight = mi0Var.f();
        commentLoadState.score = mi0Var.c();
        if (mi0Var.a().size() == 0) {
            this.j.setVisibility(0);
            this.k.setImageResource(R$drawable.icon_square_load_state_empty_comment);
            this.l.setText(si0.c(getContext()));
            g0(this.u.getText().toString(), null, -1, false);
        } else {
            commentLoadState.version = mi0Var.a().get(mi0Var.a().size() - 1).version;
            this.i.y(null, mi0Var.a(), mi0Var.b(), zG);
        }
        if (zG) {
            commentLoadState.nextLoadCount = 10;
        } else {
            h0(new CommentChangeInfo(CommentChangeInfo.STATE.COMMENT_LOADMOREFINISH, this.i.t()));
        }
        this.h.checkLoadMore();
        SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
        squareFeedEvent.eventType = 2;
        SquareFeed squareFeed = this.N;
        squareFeedEvent.feed = squareFeed;
        squareFeed.discussions = mi0Var.e();
        an1.c().l(squareFeedEvent);
    }

    public final void i0(String str) {
        RichTextView richTextView = this.u;
        if (richTextView != null) {
            richTextView.setEmojiText(str);
            ResultBean resultBean = this.B;
            if (resultBean != null) {
                resultBean.commentContent = str;
            }
        }
        RichTextView richTextView2 = this.n;
        if (richTextView2 != null) {
            richTextView2.setEmojiText(str);
        }
        if (this.o != null) {
            boolean z = !TextUtils.isEmpty(str) && si0.a(str);
            this.o.setTextColor(!z ? -7565934 : -249768);
            this.o.setEnabled(z);
        }
    }

    @Override // com.zenmen.square.comment.ui.b
    public Context j() {
        return getContext();
    }

    @Override // com.zenmen.square.comment.ui.b
    public void k(int i2, String str) {
        if (i2 == 1901 || i2 == 1911) {
            if (i2 == 1911) {
                sy5.e(this.J, com.zenmen.palmchat.friendcircle.R$string.feed_comment_delete_error, 1).g();
                return;
            } else {
                sy5.e(this.J, com.zenmen.palmchat.friendcircle.R$string.feed_content_delete_error, 1).g();
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            sy5.e(getContext(), R$string.square_http_error, 1).g();
        } else {
            sy5.f(getContext(), str, 1).g();
        }
    }

    @Override // com.zenmen.square.comment.ui.b
    public void l(CommentViewModel commentViewModel, int i2) {
        CommentLoadState commentLoadState = commentViewModel.commentLoadState;
        commentLoadState.isLoading = false;
        commentLoadState.hasMore = true;
        this.i.I(commentViewModel, i2);
        sy5.e(getContext(), R$string.square_fvt_comment_dialog_load_fail, 1).g();
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R$layout.square_comment, (ViewGroup) null);
        S(viewGroup);
        return viewGroup;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog, com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        W();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.w.d();
        this.w.c();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements et2.c {
        public c() {
        }

        @Override // et2.c
        public void onDismiss() {
        }

        @Override // et2.c
        public void onShow() {
        }
    }
}
