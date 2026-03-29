package defpackage;

import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.square.comment.model.AddCommentParam;
import com.zenmen.square.comment.model.CommentPostBean;
import com.zenmen.square.comment.model.GetCommentsParam;
import com.zenmen.square.comment.model.LikeCommentParam;
import com.zenmen.square.comment.model.RemoveCommentParam;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface yk2 {
    void addComment(AddCommentParam addCommentParam, at2<CommentPostBean> at2Var);

    void addReply(AddCommentParam addCommentParam, at2<CommentPostBean> at2Var);

    void cancelCommentLike(LikeCommentParam likeCommentParam, at2<Boolean> at2Var);

    void cancelLikeReply(LikeCommentParam likeCommentParam, at2<Boolean> at2Var);

    void commentLike(LikeCommentParam likeCommentParam, at2<Boolean> at2Var);

    void getCommentList(GetCommentsParam getCommentsParam, at2<mi0> at2Var);

    void getReplyList(GetCommentsParam getCommentsParam, at2<cw4> at2Var);

    void likeReply(LikeCommentParam likeCommentParam, at2<Boolean> at2Var);

    void removeComment(RemoveCommentParam removeCommentParam, at2<BaseNetBean> at2Var);

    void removeReply(RemoveCommentParam removeCommentParam, at2<BaseNetBean> at2Var);
}
