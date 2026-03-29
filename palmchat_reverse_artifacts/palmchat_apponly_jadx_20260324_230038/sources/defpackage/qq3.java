package defpackage;

import android.content.Context;
import android.util.Log;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.friendcircle.bean.MomentsDetailEvent;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.comment.model.AddCommentParam;
import com.zenmen.square.comment.model.CommentPostBean;
import com.zenmen.square.comment.model.GetCommentsParam;
import com.zenmen.square.comment.model.LikeCommentParam;
import com.zenmen.square.comment.model.RemoveCommentParam;
import com.zenmen.square.comment.struct.CommentItem;
import com.zenmen.square.comment.struct.SquareCommentBean;
import com.zenmen.square.comment.struct.UnitedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class qq3 implements yk2 {
    public static final String c = "qq3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ki0 f20301a;
    public int b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements q64 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ at2 f20302a;
        public final /* synthetic */ AddCommentParam b;

        public a(at2 at2Var, AddCommentParam addCommentParam) {
            this.f20302a = at2Var;
            this.b = addCommentParam;
        }

        @Override // defpackage.q64
        public void a(NetResponseData netResponseData) {
            boolean z;
            if (netResponseData == null) {
                at2 at2Var = this.f20302a;
                if (at2Var != null) {
                    at2Var.a(new UnitedException(-1, ""));
                }
                Log.d(qq3.c, "addComment responsedata is null");
                return;
            }
            Log.d(qq3.c, "addComment success");
            tq3.e().j(netResponseData);
            List<Comment> list = netResponseData.comments;
            if (list == null || list.isEmpty()) {
                at2 at2Var2 = this.f20302a;
                if (at2Var2 != null) {
                    at2Var2.a(new UnitedException(-1, ""));
                    return;
                }
                return;
            }
            Comment comment = list.get(list.size() - 1);
            CommentPostBean commentPostBean = new CommentPostBean();
            commentPostBean.id = comment.getId().longValue();
            commentPostBean.feedId = netResponseData.feedId;
            commentPostBean.content = comment.getContent();
            AddCommentParam addCommentParam = this.b;
            if (addCommentParam.replyCommentInfo != null) {
                Iterator<Comment> it = addCommentParam.feed.getComments().iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Comment next = it.next();
                    if (next.getId().equals(comment.toCommentId)) {
                        boolean z2 = next.toCommentId.longValue() != 0;
                        comment.oneLevelCommentId = next.oneLevelCommentId;
                        z = z2;
                    }
                }
                if (z) {
                    comment.commentType = 3;
                    commentPostBean.discussionType = 3;
                } else {
                    comment.commentType = 2;
                    commentPostBean.discussionType = 2;
                }
            } else {
                comment.commentType = 1;
                comment.oneLevelCommentId = comment.getId().longValue();
                commentPostBean.discussionType = 1;
            }
            this.b.feed.addComment(comment);
            this.f20302a.onSuccess(commentPostBean);
            if (qq3.this.b == 19 || qq3.this.b == 17) {
                return;
            }
            MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
            momentsDetailEvent.eventType = 2;
            momentsDetailEvent.feed = this.b.feed;
            an1.c().l(momentsDetailEvent);
        }

        @Override // defpackage.q64
        public void onFail(int i, String str) {
            at2 at2Var = this.f20302a;
            if (at2Var != null) {
                at2Var.a(new UnitedException(i, str));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements FeedNetDao.FeedNetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RemoveCommentParam f20303a;
        public final /* synthetic */ at2 b;

        public b(RemoveCommentParam removeCommentParam, at2 at2Var) {
            this.f20303a = removeCommentParam;
            this.b = at2Var;
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            LogUtil.i(qq3.c, "deleteComment fail, error is " + exc.toString());
            at2 at2Var = this.b;
            if (at2Var != null) {
                at2Var.a(new UnitedException(-1, "'"));
            }
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            if (netResponse != null) {
                int i = netResponse.resultCode;
                if (i == 0) {
                    BaseNetBean baseNetBean = new BaseNetBean();
                    baseNetBean.resultCode = 0;
                    RemoveCommentParam removeCommentParam = this.f20303a;
                    removeCommentParam.feed.removeComment(removeCommentParam.discussionId);
                    MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
                    momentsDetailEvent.eventType = 2;
                    momentsDetailEvent.feed = this.f20303a.feed;
                    an1.c().l(momentsDetailEvent);
                    at2 at2Var = this.b;
                    if (at2Var != null) {
                        at2Var.onSuccess(baseNetBean);
                        return;
                    }
                    return;
                }
                if (i == 1901 || i == 1911) {
                    at2 at2Var2 = this.b;
                    if (at2Var2 != null) {
                        at2Var2.a(new UnitedException(netResponse.resultCode, "'"));
                        return;
                    }
                    return;
                }
                LogUtil.i(qq3.c, "deleteComment fail, resultCode is " + netResponse.resultCode);
                at2 at2Var3 = this.b;
                if (at2Var3 != null) {
                    at2Var3.a(new UnitedException(-1, "'"));
                }
            }
        }
    }

    public qq3(Context context) {
        this.b = 0;
        this.f20301a = new ki0(context);
    }

    @Override // defpackage.yk2
    public void addComment(AddCommentParam addCommentParam, at2<CommentPostBean> at2Var) {
        Comment comment;
        if (addCommentParam.replyCommentInfo != null) {
            comment = new Comment();
            comment.setFromUid(addCommentParam.toDiscussionUid);
            comment.setId(Long.valueOf(addCommentParam.replyCommentInfo.getCRId()));
        } else {
            comment = null;
        }
        this.f20301a.a(addCommentParam.feed, comment, addCommentParam.content, addCommentParam.from, addCommentParam.sourceType, new a(at2Var, addCommentParam));
    }

    @Override // defpackage.yk2
    public void addReply(AddCommentParam addCommentParam, at2<CommentPostBean> at2Var) {
        addComment(addCommentParam, at2Var);
    }

    @Override // defpackage.yk2
    public void getCommentList(GetCommentsParam getCommentsParam, at2<mi0> at2Var) {
        Feed feed = getCommentsParam.feed;
        feed.setComments(feed.getComments());
        List<Comment> oneLevelComments = feed.getOneLevelComments();
        if (oneLevelComments != null) {
            ArrayList<SquareCommentBean> arrayList = new ArrayList();
            mi0 mi0Var = new mi0();
            if (!oneLevelComments.isEmpty()) {
                for (Comment comment : oneLevelComments) {
                    SquareCommentBean squareCommentBean = new SquareCommentBean();
                    squareCommentBean.convertCommentToSquare(comment);
                    squareCommentBean.businessFrom = 1;
                    arrayList.add(squareCommentBean);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (SquareCommentBean squareCommentBean2 : arrayList) {
                squareCommentBean2.businessFrom = 1;
                arrayList2.add(CommentItem.fromCommentInfo(squareCommentBean2));
            }
            mi0Var.h(arrayList2);
            if (at2Var != null) {
                at2Var.onSuccess(mi0Var);
            }
        }
    }

    @Override // defpackage.yk2
    public void removeComment(RemoveCommentParam removeCommentParam, at2<BaseNetBean> at2Var) {
        Feed feed;
        if (at2Var == null || removeCommentParam.discussionId == 0 || (feed = removeCommentParam.feed) == null || feed.getUid() == null) {
            return;
        }
        FeedNetDao.deleteComment(Long.valueOf(removeCommentParam.discussionId), removeCommentParam.feed.getFeedId(), removeCommentParam.feed.getUid(), tq3.e, removeCommentParam.feed.getFeedSource(), removeCommentParam.feed.getAdvId(), new b(removeCommentParam, at2Var));
    }

    @Override // defpackage.yk2
    public void removeReply(RemoveCommentParam removeCommentParam, at2<BaseNetBean> at2Var) {
        removeComment(removeCommentParam, at2Var);
    }

    public qq3(Context context, int i) {
        this.b = 0;
        this.f20301a = new ki0(context);
        this.b = i;
    }

    @Override // defpackage.yk2
    public void cancelCommentLike(LikeCommentParam likeCommentParam, at2<Boolean> at2Var) {
    }

    @Override // defpackage.yk2
    public void cancelLikeReply(LikeCommentParam likeCommentParam, at2<Boolean> at2Var) {
    }

    @Override // defpackage.yk2
    public void commentLike(LikeCommentParam likeCommentParam, at2<Boolean> at2Var) {
    }

    @Override // defpackage.yk2
    public void getReplyList(GetCommentsParam getCommentsParam, at2<cw4> at2Var) {
    }

    @Override // defpackage.yk2
    public void likeReply(LikeCommentParam likeCommentParam, at2<Boolean> at2Var) {
    }
}
