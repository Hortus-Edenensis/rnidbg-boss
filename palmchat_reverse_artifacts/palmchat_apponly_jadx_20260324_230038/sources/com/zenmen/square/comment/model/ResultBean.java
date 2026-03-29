package com.zenmen.square.comment.model;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ResultBean implements Serializable {
    public String commentContent;
    public int commentCount;
    public String source;

    public Author getAuthor() {
        return new Author();
    }

    public String getChannelId() {
        return null;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public long getCurrentPlayingTime() {
        return 0L;
    }

    public String getExtInfo() {
        return null;
    }

    public String getId() {
        return null;
    }

    public long getRealPlayingTime() {
        return 0L;
    }

    public void setCommentCount(int i) {
        this.commentCount = i;
    }

    public void setSource(String str) {
    }
}
