package com.zenmen.square.comment.struct;

import androidx.annotation.Keep;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.palmchat.friendcircle.bean.SquareSimpleComment;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class SquareCommentList implements BaseBean {
    public List<SquareCommentBean> discussionRespDOList;
    public boolean ifHasMore;
    public List<SquareSimpleComment> recShowDiscussions;
}
