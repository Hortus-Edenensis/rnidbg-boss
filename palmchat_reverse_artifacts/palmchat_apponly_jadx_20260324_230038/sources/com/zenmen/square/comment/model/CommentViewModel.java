package com.zenmen.square.comment.model;

import com.zenmen.square.comment.struct.CommentItem;
import com.zenmen.square.comment.struct.CommentReplyItem;
import defpackage.pi0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentViewModel implements pi0 {
    public static final int TYPE_COMMENT = 0;
    public static final int TYPE_Footer = 3;
    public static final int TYPE_REPLY = 1;
    public static final int TYPE_REPLY_LOADMORE = 2;
    public CommentItem commentItem;
    public CommentLoadState commentLoadState;
    public CommentReplyItem commentReplyItem;
    public boolean footerShow;
    public boolean needHighLightAnimation;
    public SendStatus sendStatus = SendStatus.NONE;
    public int type;

    /* JADX INFO: compiled from: SearchBox */
    public enum SendStatus {
        NONE,
        SENDING,
        FAIL,
        SUCCESS,
        RESENDSUCCESS
    }

    public CommentViewModel() {
    }

    public static ArrayList<CommentViewModel> convertCommentModel(CommentItem commentItem, long j) {
        ArrayList<CommentViewModel> arrayList = new ArrayList<>();
        arrayList.add(new CommentViewModel(0, commentItem, null));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (commentItem.getAuthorReplies() != null) {
            for (CommentReplyItem commentReplyItem : commentItem.getAuthorReplies()) {
                arrayList2.add(new CommentViewModel(1, null, commentReplyItem));
                arrayList3.add(Long.valueOf(commentReplyItem.getReplyId()));
            }
        }
        if (commentItem.getHotReplies() != null) {
            for (CommentReplyItem commentReplyItem2 : commentItem.getHotReplies()) {
                arrayList2.add(new CommentViewModel(1, null, commentReplyItem2));
                arrayList3.add(Long.valueOf(commentReplyItem2.getReplyId()));
            }
        }
        if (commentItem.getShowReplies() != null) {
            Iterator<CommentReplyItem> it = commentItem.getShowReplies().iterator();
            while (it.hasNext()) {
                arrayList2.add(new CommentViewModel(1, null, it.next()));
            }
        }
        arrayList.addAll(arrayList2);
        if (commentItem.getReplyCnt() > arrayList2.size()) {
            CommentViewModel commentViewModel = new CommentViewModel();
            commentViewModel.type = 2;
            CommentLoadState commentLoadState = new CommentLoadState();
            commentViewModel.commentLoadState = commentLoadState;
            commentViewModel.commentItem = commentItem;
            commentLoadState.commentId = commentItem.getCmtId();
            commentViewModel.commentLoadState.remainCount = commentItem.getReplyCnt() - arrayList2.size();
            CommentLoadState commentLoadState2 = commentViewModel.commentLoadState;
            commentLoadState2.queryTime = j;
            commentLoadState2.filterReplies = arrayList3;
            commentLoadState2.nextLoadCount = Math.max(3 - arrayList2.size(), 2);
            if (arrayList2.size() > 0) {
                commentViewModel.commentLoadState.version = ((CommentViewModel) arrayList2.get(arrayList2.size() - 1)).getVersion();
            } else {
                commentViewModel.commentLoadState.version = 0L;
            }
            arrayList.add(commentViewModel);
        }
        return arrayList;
    }

    public static ArrayList<CommentViewModel> genCommentViewModel(List<CommentItem> list, long j) {
        ArrayList<CommentViewModel> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.addAll(convertCommentModel(list.get(i), j));
        }
        return arrayList;
    }

    public static ArrayList<CommentViewModel> genCommentViewModelFromReplyList(List<CommentReplyItem> list, boolean z) {
        ArrayList<CommentViewModel> arrayList = new ArrayList<>();
        Iterator<CommentReplyItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new CommentViewModel(1, null, it.next()));
        }
        return arrayList;
    }

    public static HashSet<Long> genFilterSet(CommentItem commentItem) {
        HashSet<Long> hashSet = new HashSet<>();
        if (commentItem != null) {
            hashSet.add(Long.valueOf(commentItem.getCmtId()));
            if (commentItem.getAuthorReplies() != null) {
                Iterator<CommentReplyItem> it = commentItem.getAuthorReplies().iterator();
                while (it.hasNext()) {
                    hashSet.add(Long.valueOf(it.next().getReplyId()));
                }
            }
            if (commentItem.getHotReplies() != null) {
                Iterator<CommentReplyItem> it2 = commentItem.getHotReplies().iterator();
                while (it2.hasNext()) {
                    hashSet.add(Long.valueOf(it2.next().getReplyId()));
                }
            }
            if (commentItem.getQuoteReplies() != null) {
                Iterator<CommentReplyItem> it3 = commentItem.getQuoteReplies().iterator();
                while (it3.hasNext()) {
                    hashSet.add(Long.valueOf(it3.next().getReplyId()));
                }
            }
        }
        return hashSet;
    }

    @Override // defpackage.pi0
    public String getCRCity() {
        return getCommentReplyOperater().getCRCity();
    }

    @Override // defpackage.pi0
    public String getCRContent() {
        return getCommentReplyOperater().getCRContent();
    }

    @Override // defpackage.pi0
    public long getCRId() {
        pi0 commentReplyOperater = getCommentReplyOperater();
        if (commentReplyOperater == null) {
            return -1L;
        }
        return commentReplyOperater.getCRId();
    }

    @Override // defpackage.pi0
    public int getCRLikeCnt() {
        return getCommentReplyOperater().getCRLikeCnt();
    }

    @Override // defpackage.pi0
    public String getCRLocation() {
        return getCommentReplyOperater().getCRLocation();
    }

    @Override // defpackage.pi0
    public int getCRReplyCnt() {
        return getCommentReplyOperater().getCRReplyCnt();
    }

    @Override // defpackage.pi0
    public long getCRTime() {
        return getCommentReplyOperater().getCRTime();
    }

    @Override // defpackage.pi0
    public UserInfoItem getCRUser() {
        return getCommentReplyOperater().getCRUser();
    }

    public pi0 getCommentReplyOperater() {
        int i = this.type;
        if (i == 0) {
            return this.commentItem;
        }
        if (i == 1) {
            return this.commentReplyItem;
        }
        if (i == 2) {
            return this.commentItem;
        }
        return null;
    }

    @Override // defpackage.pi0
    public int getDiscussionType() {
        return getCommentReplyOperater().getDiscussionType();
    }

    @Override // defpackage.pi0
    public String getExToUid() {
        return getCommentReplyOperater().getExToUid();
    }

    @Override // defpackage.pi0
    public long getToDiscussionId() {
        return getCommentReplyOperater().getToDiscussionId();
    }

    @Override // defpackage.pi0
    public String getToNickname() {
        return getCommentReplyOperater().getToNickname();
    }

    public int getType() {
        return this.type;
    }

    @Override // defpackage.pi0
    public long getVersion() {
        return getCommentReplyOperater().getVersion();
    }

    @Override // defpackage.pi0
    public boolean isAuthor() {
        if (getCommentReplyOperater() != null) {
            return getCommentReplyOperater().isAuthor();
        }
        return false;
    }

    @Override // defpackage.pi0
    public boolean isAuthorLike() {
        return getCommentReplyOperater().isAuthorLike();
    }

    @Override // defpackage.pi0
    public boolean isCRLike() {
        return getCommentReplyOperater().isCRLike();
    }

    public boolean isContent() {
        int i = this.type;
        return i == 0 || i == 1;
    }

    @Override // defpackage.pi0
    public boolean isMediaUser() {
        return getCommentReplyOperater().isMediaUser();
    }

    @Override // defpackage.pi0
    public void setCRCity(String str) {
        getCommentReplyOperater().setCRCity(str);
    }

    @Override // defpackage.pi0
    public void setCRContent(String str) {
        getCommentReplyOperater().setCRContent(str);
    }

    @Override // defpackage.pi0
    public void setCRId(long j) {
        getCommentReplyOperater().setCRId(j);
    }

    @Override // defpackage.pi0
    public void setCRLike(boolean z) {
        getCommentReplyOperater().setCRLike(z);
    }

    @Override // defpackage.pi0
    public void setCRLikeCnt(int i) {
        getCommentReplyOperater().setCRLikeCnt(i);
    }

    @Override // defpackage.pi0
    public void setCRLocation(String str) {
        getCommentReplyOperater().setCRLocation(str);
    }

    @Override // defpackage.pi0
    public void setCRReplyCnt(int i) {
        getCommentReplyOperater().setCRReplyCnt(i);
    }

    @Override // defpackage.pi0
    public void setCRTime(long j) {
        getCommentReplyOperater().setCRTime(j);
    }

    @Override // defpackage.pi0
    public void setCRUser(UserInfoItem userInfoItem) {
        getCommentReplyOperater().setCRUser(userInfoItem);
    }

    @Override // defpackage.pi0
    public void setDiscussionType(int i) {
        getCommentReplyOperater().setDiscussionType(i);
    }

    @Override // defpackage.pi0
    public void setExToUid(String str) {
        getCommentReplyOperater().setExToUid(str);
    }

    @Override // defpackage.pi0
    public void setIsAuthor(boolean z) {
        getCommentReplyOperater().setIsAuthor(z);
    }

    @Override // defpackage.pi0
    public void setIsAuthorLike(boolean z) {
        getCommentReplyOperater().setIsAuthorLike(z);
    }

    @Override // defpackage.pi0
    public void setToDiscussionId(long j) {
        getCommentReplyOperater().setToDiscussionId(j);
    }

    @Override // defpackage.pi0
    public void setToNickname(String str) {
        getCommentReplyOperater().setToNickname(str);
    }

    @Override // defpackage.pi0
    public void setVersion(long j) {
        getCommentReplyOperater().setVersion(j);
    }

    public CommentViewModel(int i, CommentItem commentItem, CommentReplyItem commentReplyItem) {
        this.type = i;
        this.commentItem = commentItem;
        this.commentReplyItem = commentReplyItem;
    }
}
