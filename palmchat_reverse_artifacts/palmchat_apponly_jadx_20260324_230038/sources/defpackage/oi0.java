package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.DetailedCreativeType;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.R$string;
import com.zenmen.square.comment.model.CommentChangeInfo;
import com.zenmen.square.comment.model.CommentLoadState;
import com.zenmen.square.comment.model.CommentModel;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.model.GetCommentsParam;
import com.zenmen.square.comment.model.LikeCommentParam;
import com.zenmen.square.comment.model.RemoveCommentParam;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.comment.model.UserInfoItem;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.comment.ui.CommentAdapter;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import java.util.Calendar;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class oi0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.zenmen.square.comment.ui.b f19771a;
    public yk2 b;
    public boolean c = false;
    public UserInfoItem d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements at2<mi0> {
        public a() {
        }

        @Override // defpackage.at2
        public void a(UnitedException unitedException) {
            oi0.this.f19771a.b(unitedException);
        }

        @Override // defpackage.at2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(mi0 mi0Var) {
            oi0.this.f19771a.i(mi0Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements at2<cw4> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f19773a;
        public final /* synthetic */ int b;

        public b(CommentViewModel commentViewModel, int i) {
            this.f19773a = commentViewModel;
            this.b = i;
        }

        @Override // defpackage.at2
        public void a(UnitedException unitedException) {
            oi0.this.f19771a.g(this.f19773a, this.b);
        }

        @Override // defpackage.at2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(cw4 cw4Var) {
            oi0.this.f19771a.e(this.f19773a, this.b, cw4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements at2<mi0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f19774a;
        public final /* synthetic */ int b;

        public c(CommentViewModel commentViewModel, int i) {
            this.f19774a = commentViewModel;
            this.b = i;
        }

        @Override // defpackage.at2
        public void a(UnitedException unitedException) {
            oi0.this.f19771a.l(this.f19774a, this.b);
        }

        @Override // defpackage.at2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(mi0 mi0Var) {
            oi0.this.f19771a.a(mi0Var, this.f19774a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements at2<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResultBean f19775a;
        public final /* synthetic */ CommentViewModel b;
        public final /* synthetic */ CommentAdapter.CommentViewHolder c;

        public d(ResultBean resultBean, CommentViewModel commentViewModel, CommentAdapter.CommentViewHolder commentViewHolder) {
            this.f19775a = resultBean;
            this.b = commentViewModel;
            this.c = commentViewHolder;
        }

        @Override // defpackage.at2
        public void a(UnitedException unitedException) {
            oi0.this.c = false;
            if (this.f19775a != null) {
                new HashMap().put("like", this.b.isCRLike() ? "1" : "0");
            }
            if (TextUtils.isEmpty(unitedException.getErrorMsg())) {
                sy5.e(oi0.this.f19771a.j(), R$string.square_http_error, 0).g();
            } else {
                sy5.f(oi0.this.f19771a.j(), unitedException.getErrorMsg(), 0).g();
            }
        }

        @Override // defpackage.at2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Boolean bool) {
            if (bool.booleanValue()) {
                oi0.this.f19771a.d(this.c, bool, this.b, "contentBean.getMediaId()");
            }
            oi0.this.c = false;
            if (this.f19775a != null) {
                new HashMap().put("like", this.b.isCRLike() ? "1" : "0");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements at2<BaseNetBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f19776a;
        public final /* synthetic */ int b;

        public e(CommentViewModel commentViewModel, int i) {
            this.f19776a = commentViewModel;
            this.b = i;
        }

        @Override // defpackage.at2
        public void a(UnitedException unitedException) {
            oi0.this.f19771a.k(unitedException.getCode(), unitedException.getErrorMsg());
            new HashMap();
        }

        @Override // defpackage.at2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseNetBean baseNetBean) {
            oi0.this.f19771a.f(baseNetBean, this.f19776a, this.b);
            new HashMap();
        }
    }

    public oi0(Context context, SquareFeed squareFeed) {
        if (squareFeed.businessFrom == 1) {
            this.b = new qq3(context);
        } else {
            this.b = new CommentModel();
        }
    }

    public void c(com.zenmen.square.comment.ui.b bVar) {
        this.f19771a = bVar;
    }

    public void d(SquareFeed squareFeed, CommentViewModel commentViewModel, int i, ResultBean resultBean, String str) {
        if (commentViewModel.type == 0) {
            commentViewModel.commentItem.getCmtId();
        } else {
            commentViewModel.commentReplyItem.getReplyId();
        }
        if (commentViewModel.type != 0) {
            commentViewModel.commentReplyItem.getReplyId();
        }
        e eVar = new e(commentViewModel, i);
        RemoveCommentParam removeCommentParam = new RemoveCommentParam();
        removeCommentParam.feed = squareFeed.momentsFeed;
        removeCommentParam.discussionId = commentViewModel.getCRId();
        removeCommentParam.exToDiscussionUid = commentViewModel.getExToUid();
        if (commentViewModel.type == 0) {
            this.b.removeComment(removeCommentParam, eVar);
        } else {
            this.b.removeReply(removeCommentParam, eVar);
        }
    }

    public void e(GetCommentsParam getCommentsParam) {
        this.b.getCommentList(getCommentsParam, new a());
    }

    public void f(GetCommentsParam getCommentsParam, CommentViewModel commentViewModel, String str, String str2, int i) {
        CommentLoadState commentLoadState = commentViewModel.commentLoadState;
        if (commentLoadState == null || !commentLoadState.hasMore) {
            return;
        }
        this.b.getCommentList(getCommentsParam, new c(commentViewModel, i));
    }

    public void g(GetCommentsParam getCommentsParam, CommentViewModel commentViewModel, String str, String str2, int i) {
        CommentLoadState commentLoadState = commentViewModel.commentLoadState;
        long j = commentLoadState.commentId;
        commentLoadState.isLoading = true;
        this.b.getReplyList(getCommentsParam, new b(commentViewModel, i));
    }

    public UserInfoItem h() {
        if (this.d == null) {
            this.d = new UserInfoItem();
        }
        if (this.b instanceof qq3) {
            this.d.setBusinessFrom(1);
        }
        ContactInfoItem contactInfoItemA = dn0.a(v4.e(com.zenmen.palmchat.c.b()));
        if (contactInfoItemA != null) {
            this.d.setUid(contactInfoItemA.getUid());
            this.d.setExid(contactInfoItemA.getExid());
            this.d.setHeadUrl(contactInfoItemA.getIconURL());
            this.d.setName(contactInfoItemA.getNameForShow());
            this.d.setSex(contactInfoItemA.getGender());
            this.d.setContactExtBean(contactInfoItemA.getExt());
        }
        return this.d;
    }

    public void i(Context context, SquareFeed squareFeed, CommentViewModel commentViewModel) {
        bj5.b().a().Z(context, commentViewModel.commentItem != null ? DetailedCreativeType.VIDEO : DetailedCreativeType.THREE_IMG, 10, squareFeed.id, commentViewModel.getCRId(), commentViewModel.getExToUid(), squareFeed.exid);
    }

    public void j(CommentAdapter.CommentViewHolder commentViewHolder, SquareFeed squareFeed, CommentViewModel commentViewModel, ResultBean resultBean, String str, ResultBean resultBean2) {
        if (this.c) {
            return;
        }
        int i = commentViewModel.type;
        if (i == 0 && commentViewModel.commentItem == null) {
            return;
        }
        if (i == 0 || commentViewModel.commentReplyItem != null) {
            qj5.e0(squareFeed, commentViewModel, 10);
            boolean zIsCRLike = commentViewModel.isCRLike();
            long cmtId = commentViewModel.type == 0 ? commentViewModel.commentItem.getCmtId() : commentViewModel.commentReplyItem.getReplyId();
            String exid = (commentViewModel.type == 0 ? commentViewModel.commentItem.getUser() : commentViewModel.commentReplyItem.getUser()).getExid();
            d dVar = new d(resultBean2, commentViewModel, commentViewHolder);
            LikeCommentParam likeCommentParam = new LikeCommentParam();
            likeCommentParam.exFeedUid = squareFeed.exid;
            likeCommentParam.feedId = squareFeed.id;
            likeCommentParam.random = Long.toString(Calendar.getInstance().getTimeInMillis());
            likeCommentParam.toCommentId = cmtId;
            likeCommentParam.exFromDiscussionUid = exid;
            if (commentViewModel.type != 0) {
                likeCommentParam.toDiscussionId = commentViewModel.commentReplyItem.getToDiscussionId();
                likeCommentParam.exToDiscussionUid = commentViewModel.getExToUid();
                if (zIsCRLike) {
                    this.b.cancelLikeReply(likeCommentParam, dVar);
                } else {
                    this.b.likeReply(likeCommentParam, dVar);
                }
            } else if (zIsCRLike) {
                this.b.cancelCommentLike(likeCommentParam, dVar);
            } else {
                this.b.commentLike(likeCommentParam, dVar);
            }
            this.c = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int k(CommentChangeInfo commentChangeInfo, ResultBean resultBean) {
        int commentCount = resultBean.getCommentCount();
        CommentChangeInfo.STATE state = commentChangeInfo.status;
        if (state == CommentChangeInfo.STATE.REFRESH || state == CommentChangeInfo.STATE.ADD || state == CommentChangeInfo.STATE.DELETE || state == CommentChangeInfo.STATE.REPLY_LOADMOREFINISH) {
            int i = commentChangeInfo.count;
            commentCount += i;
            if (commentCount <= 0) {
            }
            SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
            squareFeedEvent.eventType = 2;
            SquareFeed squareFeedC = this.f19771a.c();
            squareFeedEvent.feed = squareFeedC;
            squareFeedC.discussionNum = commentCount;
            an1.c().l(squareFeedEvent);
            resultBean.setCommentCount(commentCount);
            return commentCount;
        }
        if (state == CommentChangeInfo.STATE.COMMENT_LOADMOREFINISH) {
            commentCount = commentChangeInfo.count;
        }
        if (commentCount <= 0) {
            commentCount = 0;
        }
        SquareFeedEvent squareFeedEvent2 = new SquareFeedEvent();
        squareFeedEvent2.eventType = 2;
        SquareFeed squareFeedC2 = this.f19771a.c();
        squareFeedEvent2.feed = squareFeedC2;
        squareFeedC2.discussionNum = commentCount;
        an1.c().l(squareFeedEvent2);
        resultBean.setCommentCount(commentCount);
        return commentCount;
    }
}
