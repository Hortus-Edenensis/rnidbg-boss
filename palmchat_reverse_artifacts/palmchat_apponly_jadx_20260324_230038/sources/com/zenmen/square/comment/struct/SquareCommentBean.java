package com.zenmen.square.comment.struct;

import androidx.annotation.Keep;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.greendao.model.Comment;
import defpackage.dn0;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class SquareCommentBean implements BaseBean {
    public int businessFrom;
    public List<Comment> childComments;
    public String city;
    public String content;
    public int discussionNum;
    public int discussionStatus;
    public long discussionTime;
    public int discussionType;
    public String exFeedUid;
    public String exFromUid;
    public String exToUid;
    public long feedId;
    public int feedStatus;
    public int feedType;
    public String headImgUrl;
    public long id;
    public boolean ifLike;
    public int likeNum;
    public String nickname;
    public int sex;
    public String thumbnailUrl;
    public long toDiscussionId;
    public String toNickname;
    public String userExt;
    public long version;

    public SquareCommentBean convertCommentToSquare(Comment comment) {
        List<Comment> list = comment.childComments;
        if (list != null && !list.isEmpty()) {
            this.childComments = list;
        }
        this.id = comment.getId().longValue();
        this.discussionType = comment.commentType;
        this.exToUid = comment.getToUid();
        this.content = comment.getContent();
        this.discussionTime = comment.getCreateDt().longValue();
        this.likeNum = 0;
        this.exFeedUid = String.valueOf(comment.feedUid);
        this.exFromUid = String.valueOf(comment.getFromUid());
        ContactInfoItem contactInfoItemA = dn0.a(comment.getFromUid());
        if (contactInfoItemA != null) {
            this.nickname = contactInfoItemA.getNickName();
            this.sex = contactInfoItemA.getGender();
            this.headImgUrl = contactInfoItemA.getIconURL();
        }
        return this;
    }
}
