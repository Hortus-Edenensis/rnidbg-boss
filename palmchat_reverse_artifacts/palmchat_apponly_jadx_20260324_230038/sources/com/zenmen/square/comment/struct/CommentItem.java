package com.zenmen.square.comment.struct;

import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.square.comment.model.UserInfoItem;
import defpackage.pi0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentItem implements Serializable, pi0 {
    private List<CommentReplyItem> authorReplies;
    private String city;
    private long cmtId;
    private long cmtTime;
    private String content;
    public int discussionType;
    public String exToUid;
    private List<CommentReplyItem> hotReplies;
    public boolean isAduit;
    private boolean isAuthor;
    private boolean isAuthorLike;
    private boolean isDelete;
    private boolean isHot;
    private boolean isLike;
    public boolean isMedia;
    public boolean isNeedHl;
    public boolean isTop;
    private int likeCnt;
    private String location;
    private List<CommentReplyItem> quoteReplies;
    private int replyCnt;
    private double score = -1.0d;
    private List<CommentReplyItem> showReplies;
    public String toNickname;
    private UserInfoItem user;
    public long version;

    public static CommentItem fromCommentInfo(SquareCommentBean squareCommentBean) {
        CommentItem commentItem = new CommentItem();
        commentItem.setCmtId(squareCommentBean.id);
        commentItem.setExToUid(squareCommentBean.exToUid);
        commentItem.setContent(squareCommentBean.content);
        commentItem.setCity(squareCommentBean.city);
        commentItem.setUser(UserInfoItem.fromUserInfo(squareCommentBean));
        commentItem.setCmtTime(squareCommentBean.discussionTime);
        commentItem.setLikeCnt(squareCommentBean.likeNum);
        commentItem.setReplyCnt(squareCommentBean.discussionNum);
        commentItem.setLike(squareCommentBean.ifLike);
        commentItem.setHot(false);
        commentItem.setDiscussionType(squareCommentBean.discussionType);
        commentItem.setLocation("");
        commentItem.setIsAuthor(squareCommentBean.exFromUid.equals(squareCommentBean.exFeedUid));
        commentItem.setIsAuthorLike(false);
        commentItem.setMedia(false);
        commentItem.setIsTop(false);
        commentItem.setScore(0.0d);
        commentItem.isAduit = false;
        commentItem.version = squareCommentBean.version;
        List<Comment> list = squareCommentBean.childComments;
        if (list != null && !list.isEmpty()) {
            commentItem.showReplies = new ArrayList();
            for (Comment comment : squareCommentBean.childComments) {
                SquareCommentBean squareCommentBean2 = new SquareCommentBean();
                squareCommentBean2.businessFrom = squareCommentBean.businessFrom;
                squareCommentBean2.convertCommentToSquare(comment);
                commentItem.showReplies.add(CommentReplyItem.fromReplyInfo(squareCommentBean2));
            }
        }
        return commentItem;
    }

    public static List<CommentItem> fromCommentInfoList() {
        return new ArrayList();
    }

    public List<CommentReplyItem> getAuthorReplies() {
        return this.authorReplies;
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
        return this.cmtId;
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
        return this.cmtTime;
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

    public long getCmtTime() {
        return this.cmtTime;
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

    public List<CommentReplyItem> getHotReplies() {
        return this.hotReplies;
    }

    public boolean getIsTop() {
        return this.isTop;
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

    public double getScore() {
        return this.score;
    }

    public List<CommentReplyItem> getShowReplies() {
        return this.showReplies;
    }

    @Override // defpackage.pi0
    public long getToDiscussionId() {
        return 0L;
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

    public boolean isDelete() {
        return this.isDelete;
    }

    public boolean isHot() {
        return this.isHot;
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

    public void setAuthorReplies(List<CommentReplyItem> list) {
        this.authorReplies = list;
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
        this.cmtId = j;
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
        this.cmtTime = j;
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

    public void setCmtTime(long j) {
        this.cmtTime = j;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDelete(boolean z) {
        this.isDelete = z;
    }

    @Override // defpackage.pi0
    public void setDiscussionType(int i) {
        this.discussionType = i;
    }

    @Override // defpackage.pi0
    public void setExToUid(String str) {
        this.exToUid = str;
    }

    public void setHot(boolean z) {
        this.isHot = z;
    }

    public void setHotReplies(List<CommentReplyItem> list) {
        this.hotReplies = list;
    }

    @Override // defpackage.pi0
    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    @Override // defpackage.pi0
    public void setIsAuthorLike(boolean z) {
        this.isAuthorLike = z;
    }

    public void setIsTop(boolean z) {
        this.isTop = z;
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

    public void setScore(double d) {
        this.score = d;
    }

    public void setShowReplies(List<CommentReplyItem> list) {
        this.showReplies = list;
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
        return "CommentModel{cmtId='" + this.cmtId + "', content='" + this.content + "', user=" + this.user + ", cmtTime=" + this.cmtTime + ", likeCnt=" + this.likeCnt + ", replyCnt=" + this.replyCnt + ", isLike=" + this.isLike + ", isHot=" + this.isHot + ", location='" + this.location + "', authorReplies=" + this.authorReplies + ", hotReplies=" + this.hotReplies + ", quoteReplies=" + this.quoteReplies + '}';
    }

    @Override // defpackage.pi0
    public void setToDiscussionId(long j) {
    }
}
