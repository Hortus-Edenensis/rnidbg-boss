package defpackage;

import android.app.Activity;
import android.content.Context;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bytedance.bpea.entry.common.DataType;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$string;
import com.zenmen.square.comment.model.CommentChangeInfo;
import com.zenmen.square.comment.model.CommentLoadState;
import com.zenmen.square.comment.model.CommentModel;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.model.GetCommentsParam;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.comment.model.UserInfoItem;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.comment.ui.CommentAdapter;
import com.zenmen.square.comment.ui.CommentListView;
import com.zenmen.square.comment.ui.a;
import com.zenmen.square.comment.widget.RichTextView;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import defpackage.et2;
import defpackage.nq3;
import defpackage.ti0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class rq3 implements com.zenmen.square.comment.ui.b {
    public SquareFeed B;
    public Context C;
    public int E;
    public int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CommentListView f20536a;
    public CommentAdapter b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public RichTextView g;
    public TextView h;
    public View i;
    public TextView j;
    public View k;
    public RichTextView l;
    public ImageView m;
    public boolean o;
    public et2 p;
    public UserInfoItem q;
    public ResultBean r;
    public ResultBean s;
    public yk2 u;
    public oi0 v;
    public qi0 w;
    public String y;
    public View z;
    public ay5 n = new ay5();
    public int t = 0;
    public Map<Long, Integer> x = new HashMap();
    public boolean A = false;
    public nq3.b G = new g();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ti0.c {
        public b() {
        }

        @Override // ti0.c
        public void a(CommentViewModel commentViewModel, int i) {
            rq3.this.L(commentViewModel, i);
        }

        @Override // ti0.c
        public void b(CommentViewModel commentViewModel, int i) throws Throwable {
            rq3 rq3Var = rq3.this;
            rq3Var.T(rq3Var.l.getText().toString(), commentViewModel, i, false);
        }

        @Override // ti0.c
        public void c(CommentViewModel commentViewModel, int i) {
            rq3.this.Q(commentViewModel, i);
        }

        @Override // ti0.c
        public void d(CommentAdapter.CommentViewHolder commentViewHolder, CommentViewModel commentViewModel, int i) {
            if (si0.e(commentViewModel)) {
                rq3 rq3Var = rq3.this;
                rq3Var.J(commentViewHolder, commentViewModel, i, rq3Var.s);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements CommentListView.c {
        public c() {
        }

        @Override // com.zenmen.square.comment.ui.CommentListView.c
        public void a() {
            CommentViewModel commentViewModelR = rq3.this.b.r();
            int itemCount = rq3.this.b.getItemCount() - 1;
            if (commentViewModelR != null) {
                CommentLoadState commentLoadState = commentViewModelR.commentLoadState;
                if (!commentLoadState.hasMore || commentLoadState.isLoading) {
                    return;
                }
                commentLoadState.isLoading = true;
                rq3.this.b.I(commentViewModelR, itemCount);
                rq3.this.L(commentViewModelR, itemCount);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (rq3.this.A) {
                rq3.this.M();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            rq3 rq3Var = rq3.this;
            rq3Var.T(rq3Var.l.getText().toString(), null, -1, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            rq3 rq3Var = rq3.this;
            rq3Var.T(rq3Var.l.getText().toString(), null, -1, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements nq3.b {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                rq3.this.b.i(false);
            }
        }

        public g() {
        }

        @Override // nq3.b
        public void a(int i, Object obj, int i2) {
            if (i == 1) {
                CommentViewModel commentViewModel = (CommentViewModel) obj;
                if (rq3.this.I()) {
                    if (rq3.this.f20536a.needScrollToPosition(i2)) {
                        rq3.this.f20536a.scrollToPosition(i2);
                    }
                    rq3.this.b.e(commentViewModel, i2);
                }
                rq3.this.V(null);
                rq3.this.U(new CommentChangeInfo(CommentChangeInfo.STATE.ADD, 1));
                sy5.e(rq3.this.C, R$string.square_comment_send_success, 0).g();
                return;
            }
            if (i == 4) {
                String str = (String) obj;
                if (rq3.this.I()) {
                    if (i2 < 0) {
                        rq3.this.f20536a.smoothScrollBy(0, -rq3.this.t);
                    }
                    rq3.this.t = 0;
                    rq3.this.f20536a.postDelayed(new a(), 500L);
                    rq3.this.b.G();
                }
                rq3.this.V(str);
                return;
            }
            if (i == 2) {
                UnitedException unitedException = (UnitedException) obj;
                if (!TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.f(rq3.this.C, unitedException.getErrorMsg(), 1).g();
                    return;
                }
                if (unitedException.getCode() != 1901 && unitedException.getCode() != 1911) {
                    sy5.e(rq3.this.C, R$string.square_http_error, 1).g();
                    return;
                }
                if (!TextUtils.isEmpty(unitedException.getErrorMsg())) {
                    sy5.f(rq3.this.C, unitedException.getErrorMsg(), 1).g();
                } else if (unitedException.getCode() == 1911) {
                    sy5.e(rq3.this.C, com.zenmen.palmchat.friendcircle.R$string.feed_comment_delete_error, 1).g();
                } else {
                    sy5.e(rq3.this.C, com.zenmen.palmchat.friendcircle.R$string.feed_content_delete_error, 1).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f20545a;
        public final /* synthetic */ int b;

        public h(CommentViewModel commentViewModel, int i) {
            this.f20545a = commentViewModel;
            this.b = i;
        }

        @Override // com.zenmen.square.comment.ui.a.d
        public void a(com.zenmen.square.comment.ui.a aVar, a.c cVar) {
            if (cVar.e() == 0) {
                rq3.this.G(this.f20545a.getCRContent());
                return;
            }
            if (cVar.e() == 1) {
                qj5.j(rq3.this.B, this.f20545a.getCRUser().getExid());
                rq3.this.v.i(rq3.this.C, rq3.this.B, this.f20545a);
            } else if (cVar.e() == 2) {
                qj5.k(rq3.this.B, this.f20545a.getCRUser().getExid());
                rq3.this.R(this.f20545a, this.b);
            } else {
                if (cVar.e() == 3) {
                    return;
                }
                cVar.e();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f20546a;
        public final /* synthetic */ int b;

        public i(CommentViewModel commentViewModel, int i) {
            this.f20546a = commentViewModel;
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
            rq3.this.H(this.f20546a, this.b);
            materialDialog.cancel();
        }
    }

    public rq3(Context context, SquareFeed squareFeed) {
        this.C = context;
        this.B = squareFeed;
        xl1.e(context);
        this.v = new oi0(context, squareFeed);
        this.w = new qi0();
        UserInfoItem userInfoItemH = this.v.h();
        this.q = userInfoItemH;
        et2 et2Var = new et2((Activity) context, this, userInfoItemH, squareFeed);
        this.p = et2Var;
        et2Var.h(this.G);
        this.p.c(new a());
        if (squareFeed.businessFrom == 1) {
            this.u = new qq3(context);
        } else {
            this.u = new CommentModel();
        }
        this.p.f(this.u);
        this.v.c(this);
    }

    public void F(View view) {
        CommentListView commentListView = (CommentListView) view.findViewById(R$id.commentList);
        this.f20536a = commentListView;
        commentListView.setNestedScrollingEnabled(false);
        ArrayList arrayList = new ArrayList();
        this.c = view.findViewById(R$id.vs_comment_emptyview);
        this.d = (ImageView) view.findViewById(R$id.vs_comment_emptyview_icon);
        TextView textView = (TextView) view.findViewById(R$id.vs_comment_emptyview_text);
        this.e = textView;
        textView.setText(si0.c(this.C));
        CommentAdapter commentAdapter = new CommentAdapter(this.C, this.B, arrayList, this.q);
        this.b = commentAdapter;
        if (this.B.businessFrom == 1) {
            commentAdapter.C(false);
        } else {
            commentAdapter.C(true);
        }
        this.b.D(new b());
        this.f20536a.setAdapter(this.b);
        this.f20536a.setOnLoadMoreListener(new c());
        this.b.notifyDataSetChanged();
        this.i = view.findViewById(R$id.video_tab_loading_view);
        this.c.setOnClickListener(new d());
        this.k = view.findViewById(R$id.rl_comment_title);
        this.j = (TextView) view.findViewById(R$id.tv_comment_count);
        RichTextView richTextView = (RichTextView) view.findViewById(R$id.edit_message_area);
        this.l = richTextView;
        richTextView.setHint(si0.b(this.C));
        this.l.setOnClickListener(new e());
        ResultBean resultBean = this.s;
        if (resultBean != null) {
            V(resultBean.commentContent);
        }
        ImageView imageView = (ImageView) view.findViewById(R$id.vs_comment_emoji);
        this.m = imageView;
        imageView.setOnClickListener(new f());
        this.o = true;
        View viewFindViewById = view.findViewById(R$id.input_rl);
        this.z = viewFindViewById;
        SquareFeed squareFeed = this.B;
        viewFindViewById.setVisibility((squareFeed == null || squareFeed.hiddenDiscussion) ? 8 : 0);
        this.o = true;
    }

    public final void G(String str) {
        ((ClipboardManager) this.C.getSystemService(DataType.CLIPBOARD)).setText(str);
    }

    public final void H(CommentViewModel commentViewModel, int i2) {
        this.v.d(this.B, commentViewModel, i2, this.s, this.q.getWid());
    }

    public final boolean I() {
        return this.o;
    }

    public final void J(CommentAdapter.CommentViewHolder commentViewHolder, CommentViewModel commentViewModel, int i2, ResultBean resultBean) {
        this.v.j(commentViewHolder, this.B, commentViewModel, this.s, this.q.getWid(), resultBean);
    }

    public final void K(ResultBean resultBean) {
        N(resultBean);
        M();
    }

    public final void L(CommentViewModel commentViewModel, int i2) {
        if (commentViewModel.type != 2) {
            if (commentViewModel.commentLoadState == null) {
                Log.e("findbugs", "model.commentLoadState is null");
                return;
            }
            GetCommentsParam getCommentsParam = new GetCommentsParam();
            getCommentsParam.version = commentViewModel.commentLoadState.version;
            SquareFeed squareFeed = this.B;
            getCommentsParam.feedId = squareFeed.id;
            getCommentsParam.reqListType = 1;
            getCommentsParam.exFeedUid = squareFeed.exid;
            this.v.f(getCommentsParam, commentViewModel, this.s.getId(), this.s.getExtInfo(), i2);
            return;
        }
        qj5.o(this.B);
        GetCommentsParam getCommentsParam2 = new GetCommentsParam();
        getCommentsParam2.version = commentViewModel.commentLoadState.version;
        SquareFeed squareFeed2 = this.B;
        getCommentsParam2.feedId = squareFeed2.id;
        getCommentsParam2.reqListType = 2;
        getCommentsParam2.exFeedUid = squareFeed2.exid;
        getCommentsParam2.toDiscussionId = commentViewModel.getCRId();
        getCommentsParam2.exToDiscussionUid = commentViewModel.getCRUser().getExid();
        this.v.g(getCommentsParam2, commentViewModel, this.s.getId(), this.s.getExtInfo(), i2);
        this.b.I(commentViewModel, i2);
    }

    public final void M() {
        this.x.clear();
        this.b.E(this.s);
        this.b.j();
        this.c.setVisibility(8);
        this.i.setVisibility(0);
        CommentLoadState commentLoadState = this.b.r().commentLoadState;
        GetCommentsParam getCommentsParam = new GetCommentsParam();
        SquareFeed squareFeed = this.B;
        getCommentsParam.exFeedUid = squareFeed.exid;
        getCommentsParam.feedId = squareFeed.id;
        getCommentsParam.feed = squareFeed.momentsFeed;
        getCommentsParam.reqListType = 1;
        getCommentsParam.version = 0L;
        this.v.e(getCommentsParam);
    }

    public final void N(ResultBean resultBean) {
        this.s = resultBean;
        this.r = resultBean;
        V(resultBean.commentContent);
        U(new CommentChangeInfo(CommentChangeInfo.STATE.REFRESH, 0));
    }

    public void O(SquareFeed squareFeed) {
        this.B = squareFeed;
        et2 et2Var = this.p;
        if (et2Var != null) {
            et2Var.g(squareFeed);
        }
    }

    public void P(ResultBean resultBean, int i2, int i3) {
        resultBean.setCommentCount(this.B.discussionNum);
        this.E = i3;
        this.F = i2;
        this.y = resultBean.getChannelId();
        K(resultBean);
    }

    public final void Q(CommentViewModel commentViewModel, int i2) {
        qj5.n(this.B);
        com.zenmen.square.comment.ui.a aVar = new com.zenmen.square.comment.ui.a(this.C);
        ArrayList arrayList = new ArrayList();
        String strE = v4.e(com.zenmen.palmchat.c.b());
        if (this.B.businessFrom != 1) {
            strE = v4.b(com.zenmen.palmchat.c.b());
            if (!commentViewModel.getCRUser().getExid().equals(strE)) {
                arrayList.add(new a.c(1, this.C.getString(R$string.square_share_report), R$drawable.square_comment_report_menu));
            }
        }
        if (TextUtils.isEmpty(this.B.exid)) {
            if (!TextUtils.isEmpty(this.B.uid) && (this.B.uid.equals(strE) || commentViewModel.getCRUser().getUid().equals(strE))) {
                arrayList.add(new a.c(2, this.C.getString(R$string.square_comment_delete), R$drawable.square_comment_delete_menu));
            }
        } else if (this.B.exid.equals(strE) || commentViewModel.getCRUser().getExid().equals(strE)) {
            arrayList.add(new a.c(2, this.C.getString(R$string.square_comment_delete), R$drawable.square_comment_delete_menu));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        aVar.f(arrayList);
        aVar.g(new h(commentViewModel, i2));
        aVar.show();
    }

    public final void R(CommentViewModel commentViewModel, int i2) {
        new sd3(this.C).k("确定要删除吗？").P("删除").L("取消").h(false).f(new i(commentViewModel, i2)).e().show();
    }

    public void S() throws Throwable {
        T(this.l.getText().toString(), null, -1, false);
    }

    public void T(String str, CommentViewModel commentViewModel, int i2, boolean z) throws Throwable {
        if (this.B.hiddenDiscussion) {
            return;
        }
        if (commentViewModel != null) {
            this.b.i(true);
            this.t = this.f20536a.scrollToNextShotDate(i2);
        }
        this.p.i(this.s, str, commentViewModel, i2, this.F, z, this.E);
        this.c.setVisibility(8);
        new HashMap();
    }

    public void U(CommentChangeInfo commentChangeInfo) {
        ResultBean resultBean = this.r;
        if (resultBean != null) {
            int iK = this.v.k(commentChangeInfo, resultBean);
            View view = this.k;
            if (view != null) {
                if (iK > 0) {
                    view.setVisibility(0);
                    TextView textView = this.j;
                    if (textView != null) {
                        textView.setText(String.format("(%d)", Integer.valueOf(iK)));
                    }
                } else {
                    view.setVisibility(4);
                }
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(zk5.f(iK));
            }
        }
    }

    public final void V(String str) {
        RichTextView richTextView = this.l;
        if (richTextView != null) {
            richTextView.setEmojiText(str);
            ResultBean resultBean = this.s;
            if (resultBean != null) {
                resultBean.commentContent = str;
            }
        }
        RichTextView richTextView2 = this.g;
        if (richTextView2 != null) {
            richTextView2.setEmojiText(str);
        }
        if (this.h != null) {
            boolean z = !TextUtils.isEmpty(str) && si0.a(str);
            this.h.setTextColor(!z ? -7565934 : -249768);
            this.h.setEnabled(z);
        }
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
        this.b.I(commentViewModel, i2);
        this.b.d(mi0Var.a(), mi0Var.b(), i2);
        if (zG) {
            return;
        }
        U(new CommentChangeInfo(CommentChangeInfo.STATE.COMMENT_LOADMOREFINISH, this.b.t()));
    }

    @Override // com.zenmen.square.comment.ui.b
    public void b(UnitedException unitedException) {
        this.i.setVisibility(8);
        this.d.setImageResource(R$drawable.icon_square_comment_state_err);
        String string = this.C.getString(R$string.square_http_error);
        if (!TextUtils.isEmpty(unitedException.getErrorMsg())) {
            string = this.C.getString(R$string.square_fvt_comment_dialog_load_fail);
        }
        this.e.setText(string);
        sy5.f(this.C, string, 0).g();
    }

    @Override // com.zenmen.square.comment.ui.b
    public SquareFeed c() {
        return this.B;
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

    @Override // com.zenmen.square.comment.ui.b
    public void e(CommentViewModel commentViewModel, int i2, cw4 cw4Var) {
        Log.d("onLoadMoreReplySuc", "onLoadMoreReplySuc total cmt count=" + commentViewModel.commentItem.getReplyCnt());
        CommentLoadState commentLoadState = commentViewModel.commentLoadState;
        if (!this.x.containsKey(Long.valueOf(commentViewModel.commentItem.getCmtId()))) {
            Log.d("onLoadMoreReplySuc", "onLoadMoreReplySuc init filter replies count=" + commentLoadState.filterReplies.size());
            this.x.put(Long.valueOf(commentViewModel.commentItem.getCmtId()), Integer.valueOf(commentLoadState.filterReplies.size()));
        }
        long j = commentLoadState.commentId;
        int size = cw4Var.a().size();
        Log.d("onLoadMoreReplySuc", "onLoadMoreReplySuc curnt load replies count=" + size);
        int iIntValue = (this.x.containsKey(Long.valueOf(commentViewModel.commentItem.getCmtId())) ? this.x.get(Long.valueOf(commentViewModel.commentItem.getCmtId())).intValue() : 0) + size;
        Log.d("onLoadMoreReplySuc", "onLoadMoreReplySuc total load replies count=" + iIntValue);
        this.x.put(Long.valueOf(commentViewModel.commentItem.getCmtId()), Integer.valueOf(iIntValue));
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
            this.b.I(commentViewModel, i2);
        } else {
            this.b.k(commentViewModel, i2);
        }
        this.b.g(cw4Var.a(), z, i2);
        if (z) {
            return;
        }
        U(new CommentChangeInfo(CommentChangeInfo.STATE.REPLY_LOADMOREFINISH, this.b.q(j)));
    }

    @Override // com.zenmen.square.comment.ui.b
    public void f(BaseNetBean baseNetBean, CommentViewModel commentViewModel, int i2) {
        if (!baseNetBean.isSuccess()) {
            sy5.f(this.C, baseNetBean.getErrMsg(), 1).g();
            return;
        }
        sy5.e(this.C, R$string.square_comment_delete_success, 1).g();
        U(new CommentChangeInfo(CommentChangeInfo.STATE.DELETE, -this.b.k(commentViewModel, i2)));
        int i3 = commentViewModel.type;
    }

    @Override // com.zenmen.square.comment.ui.b
    public void g(CommentViewModel commentViewModel, int i2) {
        commentViewModel.commentLoadState.isLoading = false;
        this.b.I(commentViewModel, i2);
    }

    @Override // com.zenmen.square.comment.ui.b
    public int h(CommentViewModel commentViewModel, int i2) {
        CommentAdapter commentAdapter = this.b;
        if (commentAdapter != null) {
            return commentAdapter.h(commentViewModel, i2);
        }
        return 0;
    }

    @Override // com.zenmen.square.comment.ui.b
    public void i(mi0 mi0Var) throws Throwable {
        this.i.setVisibility(8);
        CommentLoadState commentLoadState = this.b.r().commentLoadState;
        boolean zG = mi0Var.g();
        commentLoadState.nextLoadSeq = mi0Var.d();
        commentLoadState.nextLoadWeight = mi0Var.f();
        commentLoadState.score = mi0Var.c();
        if (mi0Var.a().size() == 0) {
            this.d.setImageResource(R$drawable.icon_square_load_state_empty_comment);
            this.e.setText(si0.c(this.C));
            T(this.l.getText().toString(), null, -1, false);
        } else {
            commentLoadState.version = mi0Var.a().get(mi0Var.a().size() - 1).version;
            this.b.y(null, mi0Var.a(), mi0Var.b(), zG);
        }
        if (zG) {
            commentLoadState.nextLoadCount = 10;
        } else {
            U(new CommentChangeInfo(CommentChangeInfo.STATE.COMMENT_LOADMOREFINISH, this.b.t()));
        }
        this.f20536a.checkLoadMore();
        if (this.B.businessFrom == 0) {
            SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
            squareFeedEvent.eventType = 2;
            SquareFeed squareFeed = this.B;
            squareFeedEvent.feed = squareFeed;
            squareFeed.discussions = mi0Var.e();
            an1.c().l(squareFeedEvent);
        }
    }

    @Override // com.zenmen.square.comment.ui.b
    public Context j() {
        return this.C;
    }

    @Override // com.zenmen.square.comment.ui.b
    public void k(int i2, String str) {
        if (i2 == 1901 || i2 == 1911) {
            if (i2 == 1911) {
                sy5.e(this.C, com.zenmen.palmchat.friendcircle.R$string.feed_comment_delete_error, 1).g();
                return;
            } else {
                sy5.e(this.C, com.zenmen.palmchat.friendcircle.R$string.feed_content_delete_error, 1).g();
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            sy5.e(this.C, R$string.square_http_error, 1).g();
        } else {
            sy5.f(this.C, str, 1).g();
        }
    }

    @Override // com.zenmen.square.comment.ui.b
    public void l(CommentViewModel commentViewModel, int i2) {
        CommentLoadState commentLoadState = commentViewModel.commentLoadState;
        commentLoadState.isLoading = false;
        commentLoadState.hasMore = true;
        this.b.I(commentViewModel, i2);
        sy5.e(this.C, R$string.square_fvt_comment_dialog_load_fail, 1).g();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements et2.c {
        public a() {
        }

        @Override // et2.c
        public void onDismiss() {
        }

        @Override // et2.c
        public void onShow() {
        }
    }
}
