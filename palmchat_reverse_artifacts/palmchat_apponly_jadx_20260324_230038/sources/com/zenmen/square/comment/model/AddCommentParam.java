package com.zenmen.square.comment.model;

import androidx.annotation.Keep;
import com.zenmen.palmchat.greendao.model.Feed;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AddCommentParam {
    public String content;
    public String exFeedUid;
    public String exFromDiscussionUid;
    public String exToDiscussionUid;
    public String exToSuperDiscussionUid;
    public Feed feed;
    public long feedId;
    public int from;
    public String random;
    public CommentViewModel replyCommentInfo;
    public int sourceType;
    public long toDiscussionId;
    public String toDiscussionUid;
}
