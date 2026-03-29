package defpackage;

import android.text.TextUtils;
import com.zenmen.square.comment.model.AddCommentParam;
import com.zenmen.square.comment.model.CommentPostBean;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.comment.model.UserInfoItem;
import com.zenmen.square.comment.struct.CommentItem;
import com.zenmen.square.comment.struct.CommentReplyItem;
import com.zenmen.square.comment.struct.UnitedException;
import com.zenmen.square.comment.ui.b;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import java.util.ArrayList;
import java.util.Calendar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class li0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ro6 f19007a;
    public UserInfoItem b;
    public b c;
    public yk2 d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements at2<CommentPostBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentViewModel f19008a;
        public final /* synthetic */ int b;

        public a(CommentViewModel commentViewModel, int i) {
            this.f19008a = commentViewModel;
            this.b = i;
        }

        @Override // defpackage.at2
        public void a(UnitedException unitedException) {
            if (li0.this.f19007a != null) {
                li0.this.f19007a.D(this.f19008a, this.b, unitedException);
            }
        }

        @Override // defpackage.at2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CommentPostBean commentPostBean) {
            if (li0.this.f19007a != null) {
                if (si0.d()) {
                    CommentViewModel commentViewModel = this.f19008a;
                    if (commentViewModel.type == 0) {
                        CommentItem commentItem = commentViewModel.commentItem;
                        if (commentItem != null) {
                            commentItem.isAduit = true;
                        }
                    } else {
                        CommentReplyItem commentReplyItem = commentViewModel.commentReplyItem;
                        if (commentReplyItem != null) {
                            commentReplyItem.isAduit = true;
                        }
                    }
                }
                li0.this.f19007a.E(commentPostBean, this.f19008a, this.b);
            }
        }
    }

    public void b(ro6 ro6Var) {
        this.f19007a = ro6Var;
    }

    public void c(b bVar) {
        this.c = bVar;
    }

    public void d(yk2 yk2Var) {
        this.d = yk2Var;
    }

    public void e(UserInfoItem userInfoItem) {
        this.b = userInfoItem;
    }

    public boolean f(SquareFeed squareFeed, ResultBean resultBean, CommentViewModel commentViewModel, String str, int i, int i2, int i3) {
        CommentViewModel commentViewModel2;
        if (commentViewModel == null) {
            commentViewModel2 = new CommentViewModel(0, new CommentItem(), null);
            commentViewModel2.commentItem.setMedia(false);
        } else {
            CommentViewModel commentViewModel3 = new CommentViewModel(1, null, new CommentReplyItem());
            if (commentViewModel.type == 0) {
                commentViewModel3.commentReplyItem.setCmtId(commentViewModel.commentItem.getCmtId());
            } else {
                if (commentViewModel.commentReplyItem == null) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                CommentReplyItem commentReplyItem = new CommentReplyItem();
                commentReplyItem.setUser(commentViewModel.commentReplyItem.getUser());
                arrayList.add(commentReplyItem);
                commentViewModel3.commentReplyItem.setQuoteReplies(arrayList);
                commentViewModel3.commentReplyItem.setCmtId(commentViewModel.commentReplyItem.getCmtId());
                commentViewModel.commentReplyItem.getReplyId();
            }
            commentViewModel3.commentReplyItem.setMedia(false);
            b bVar = this.c;
            iH = bVar != null ? bVar.h(commentViewModel, i) : 0;
            commentViewModel2 = commentViewModel3;
        }
        UserInfoItem userInfoItemFromUserInfoItem = UserInfoItem.fromUserInfoItem(this.b);
        commentViewModel2.setCRContent(str);
        commentViewModel2.setCRUser(userInfoItemFromUserInfoItem);
        commentViewModel2.setCRTime(System.currentTimeMillis());
        commentViewModel2.sendStatus = CommentViewModel.SendStatus.NONE;
        if (!TextUtils.isEmpty(squareFeed.uid)) {
            commentViewModel2.setIsAuthor(squareFeed.uid.equals(this.b.getUid()));
        } else if (!TextUtils.isEmpty(squareFeed.exid)) {
            commentViewModel2.setIsAuthor(squareFeed.exid.equals(this.b.getExid()));
        }
        a aVar = new a(commentViewModel2, iH);
        if (commentViewModel2.type == 0) {
            commentViewModel2.setToNickname(squareFeed.nickname);
            commentViewModel2.setExToUid(squareFeed.exid);
            AddCommentParam addCommentParam = new AddCommentParam();
            addCommentParam.feedId = squareFeed.id;
            addCommentParam.content = str;
            addCommentParam.exFeedUid = squareFeed.exid;
            addCommentParam.exFromDiscussionUid = this.b.getExid();
            String str2 = squareFeed.exid;
            addCommentParam.exToDiscussionUid = str2;
            addCommentParam.toDiscussionUid = squareFeed.uid;
            addCommentParam.exToSuperDiscussionUid = str2;
            addCommentParam.random = Long.toString(Calendar.getInstance().getTimeInMillis());
            addCommentParam.feed = squareFeed.momentsFeed;
            addCommentParam.sourceType = i2;
            addCommentParam.from = i3;
            this.d.addComment(addCommentParam, aVar);
        } else {
            commentViewModel2.setToNickname(commentViewModel.getCRUser().getName());
            commentViewModel2.setExToUid(commentViewModel.getCRUser().getExid());
            commentViewModel2.setToDiscussionId(commentViewModel.getCRId());
            AddCommentParam addCommentParam2 = new AddCommentParam();
            addCommentParam2.feedId = squareFeed.id;
            addCommentParam2.content = str;
            addCommentParam2.exFeedUid = squareFeed.exid;
            addCommentParam2.exFromDiscussionUid = this.b.getExid();
            addCommentParam2.exToDiscussionUid = commentViewModel.getCRUser().getExid();
            addCommentParam2.toDiscussionUid = commentViewModel.getCRUser().getUid();
            addCommentParam2.toDiscussionId = commentViewModel.getCRId();
            addCommentParam2.exToSuperDiscussionUid = commentViewModel.getExToUid();
            addCommentParam2.random = Long.toString(Calendar.getInstance().getTimeInMillis());
            addCommentParam2.feed = squareFeed.momentsFeed;
            addCommentParam2.replyCommentInfo = commentViewModel;
            addCommentParam2.sourceType = i2;
            addCommentParam2.from = i3;
            this.d.addReply(addCommentParam2, aVar);
        }
        return true;
    }
}
