package com.zenmen.palmchat.greendao.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface ISupperFeedBean<T> {
    boolean canDelete();

    String getAvatar();

    String getCommentCountShow();

    String getContent();

    long getCreateTime();

    String getExid();

    long getFeedId();

    long getFeedType();

    int getGender();

    boolean getIfLike();

    String getNickname();

    T getOriginData();

    String getPraiseCountShow();

    String getUid();

    boolean hideComment();

    boolean isEmptyFeed();
}
