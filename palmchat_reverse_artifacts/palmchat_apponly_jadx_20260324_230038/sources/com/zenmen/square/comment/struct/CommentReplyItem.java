package com.zenmen.square.comment.struct;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.comment.model.UserInfoItem;
import defpackage.dn0;
import defpackage.pi0;
import defpackage.v4;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentReplyItem implements Serializable, pi0 {
    private String city;
    private long cmtId;
    private String content;
    private int discussionType;
    public String exToUid;
    private Map<String, String> extParams;
    public boolean isAduit;
    private boolean isAuthor;
    private boolean isAuthorLike;
    private boolean isLike;
    public boolean isMedia;
    private boolean isSelf;
    private int likeCnt;
    private String location;
    private List<CommentReplyItem> quoteReplies;
    private int replyCnt;
    private long replyId;
    private long replyTime;
    private long toDiscussionId;
    public String toNickname;
    private UserInfoItem user;
    public long version;

    @Nullable
    public static CommentReplyItem fromMessageModelWithNoParentCmt() {
        return new CommentReplyItem();
    }

    public static CommentReplyItem fromReplyInfo(SquareCommentBean squareCommentBean) {
        CommentReplyItem commentReplyItem = new CommentReplyItem();
        commentReplyItem.setReplyId(squareCommentBean.id);
        commentReplyItem.setExToUid(squareCommentBean.exToUid);
        commentReplyItem.setToDiscussionId(squareCommentBean.toDiscussionId);
        commentReplyItem.setDiscussionType(squareCommentBean.discussionType);
        commentReplyItem.setContent(squareCommentBean.content);
        commentReplyItem.setCity(squareCommentBean.city);
        commentReplyItem.setUser(UserInfoItem.fromUserInfo(squareCommentBean));
        ContactInfoItem contactInfoItemA = squareCommentBean.businessFrom == 1 ? dn0.a(squareCommentBean.exToUid) : dn0.b(squareCommentBean.exToUid);
        String nameForShow = contactInfoItemA != null ? contactInfoItemA.getNameForShow() : null;
        if (TextUtils.isEmpty(nameForShow)) {
            nameForShow = squareCommentBean.toNickname;
        }
        commentReplyItem.setToNickname(nameForShow);
        commentReplyItem.setReplyTime(squareCommentBean.discussionTime);
        commentReplyItem.setLikeCnt(squareCommentBean.likeNum);
        commentReplyItem.setReplyCnt(squareCommentBean.discussionNum);
        commentReplyItem.setLike(squareCommentBean.ifLike);
        commentReplyItem.setSelf(squareCommentBean.exFromUid.equals(v4.e(c.b())));
        commentReplyItem.setLocation("");
        commentReplyItem.setIsAuthor(squareCommentBean.exFromUid.equals(squareCommentBean.exFeedUid));
        commentReplyItem.setIsAuthorLike(false);
        commentReplyItem.setMedia(false);
        commentReplyItem.isAduit = "1".equals(Integer.valueOf(squareCommentBean.feedStatus));
        commentReplyItem.version = squareCommentBean.version;
        return commentReplyItem;
    }

    public static List<CommentReplyItem> fromReplyInfoList() {
        return new ArrayList();
    }

    @Override // defpackage.pi0
    public String getCRCity() {
        return this.city;
    }

    @Override // defpackage.pi0
    public String getCRContent() {
        return this.content;
    }

    @Override // defpackage.pi0
    public long getCRId() {
        return this.replyId;
    }

    @Override // defpackage.pi0
    public int getCRLikeCnt() {
        return this.likeCnt;
    }

    @Override // defpackage.pi0
    public String getCRLocation() {
        return this.location;
    }

    @Override // defpackage.pi0
    public int getCRReplyCnt() {
        return this.replyCnt;
    }

    @Override // defpackage.pi0
    public long getCRTime() {
        return this.replyTime;
    }

    @Override // defpackage.pi0
    public UserInfoItem getCRUser() {
        return this.user;
    }

    public String getCity() {
        return this.city;
    }

    public long getCmtId() {
        return this.cmtId;
    }

    public String getContent() {
        return this.content;
    }

    @Override // defpackage.pi0
    public int getDiscussionType() {
        return this.discussionType;
    }

    @Override // defpackage.pi0
    public String getExToUid() {
        return this.exToUid;
    }

    public Map<String, String> getExtParams() {
        return this.extParams;
    }

    public int getLikeCnt() {
        return this.likeCnt;
    }

    public String getLocation() {
        return this.location;
    }

    public List<CommentReplyItem> getQuoteReplies() {
        return this.quoteReplies;
    }

    public int getReplyCnt() {
        return this.replyCnt;
    }

    public long getReplyId() {
        return this.replyId;
    }

    public long getReplyTime() {
        return this.replyTime;
    }

    @Override // defpackage.pi0
    public long getToDiscussionId() {
        return this.toDiscussionId;
    }

    @Override // defpackage.pi0
    public String getToNickname() {
        return this.toNickname;
    }

    public UserInfoItem getUser() {
        return this.user;
    }

    @Override // defpackage.pi0
    public long getVersion() {
        return this.version;
    }

    @Override // defpackage.pi0
    public boolean isAuthor() {
        return this.isAuthor;
    }

    @Override // defpackage.pi0
    public boolean isAuthorLike() {
        return this.isAuthorLike;
    }

    @Override // defpackage.pi0
    public boolean isCRLike() {
        return this.isLike;
    }

    public boolean isLike() {
        return this.isLike;
    }

    public boolean isMedia() {
        return this.isMedia;
    }

    @Override // defpackage.pi0
    public boolean isMediaUser() {
        return this.isMedia;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    @Override // defpackage.pi0
    public void setCRCity(String str) {
        this.city = str;
    }

    @Override // defpackage.pi0
    public void setCRContent(String str) {
        this.content = str;
    }

    @Override // defpackage.pi0
    public void setCRId(long j) {
        this.replyId = j;
    }

    @Override // defpackage.pi0
    public void setCRLike(boolean z) {
        this.isLike = z;
    }

    @Override // defpackage.pi0
    public void setCRLikeCnt(int i) {
        this.likeCnt = i;
    }

    @Override // defpackage.pi0
    public void setCRLocation(String str) {
        this.location = str;
    }

    @Override // defpackage.pi0
    public void setCRReplyCnt(int i) {
        this.replyCnt = i;
    }

    @Override // defpackage.pi0
    public void setCRTime(long j) {
        this.replyTime = j;
    }

    @Override // defpackage.pi0
    public void setCRUser(UserInfoItem userInfoItem) {
        this.user = userInfoItem;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCmtId(long j) {
        this.cmtId = j;
    }

    public void setContent(String str) {
        this.content = str;
    }

    @Override // defpackage.pi0
    public void setDiscussionType(int i) {
        this.discussionType = i;
    }

    @Override // defpackage.pi0
    public void setExToUid(String str) {
        this.exToUid = str;
    }

    public void setExtParams(Map<String, String> map) {
        this.extParams = map;
    }

    @Override // defpackage.pi0
    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    @Override // defpackage.pi0
    public void setIsAuthorLike(boolean z) {
        this.isAuthorLike = z;
    }

    public void setLike(boolean z) {
        this.isLike = z;
    }

    public void setLikeCnt(int i) {
        this.likeCnt = i;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setMedia(boolean z) {
        this.isMedia = z;
    }

    public void setQuoteReplies(List<CommentReplyItem> list) {
        this.quoteReplies = list;
    }

    public void setReplyCnt(int i) {
        this.replyCnt = i;
    }

    public void setReplyId(long j) {
        this.replyId = j;
    }

    public void setReplyTime(long j) {
        this.replyTime = j;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    @Override // defpackage.pi0
    public void setToDiscussionId(long j) {
        this.toDiscussionId = j;
    }

    @Override // defpackage.pi0
    public void setToNickname(String str) {
        this.toNickname = str;
    }

    public void setUser(UserInfoItem userInfoItem) {
        this.user = userInfoItem;
    }

    @Override // defpackage.pi0
    public void setVersion(long j) {
        this.version = j;
    }

    public String toString() {
        return "ReplyModel{replyId='" + this.replyId + "', cmtId='" + this.cmtId + "', content='" + this.content + "', user=" + this.user + ", replyTime=" + this.replyTime + ", likeCnt=" + this.likeCnt + ", replyCnt=" + this.replyCnt + ", isLike=" + this.isLike + ", isSelf=" + this.isSelf + ", location='" + this.location + "', quoteReplies=" + this.quoteReplies + ", extParams=" + this.extParams + '}';
    }
}
