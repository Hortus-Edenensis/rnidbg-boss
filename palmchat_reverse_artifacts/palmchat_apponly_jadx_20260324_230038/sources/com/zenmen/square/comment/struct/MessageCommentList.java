package com.zenmen.square.comment.struct;

import androidx.annotation.Keep;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.square.mvp.model.bean.MessageCommentBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class MessageCommentList implements BaseBean {
    public List<MessageCommentBean> discussionRespDOList;
    public boolean ifHasMore;
}
