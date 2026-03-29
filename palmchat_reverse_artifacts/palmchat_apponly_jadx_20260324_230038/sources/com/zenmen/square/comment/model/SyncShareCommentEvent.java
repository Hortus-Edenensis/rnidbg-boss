package com.zenmen.square.comment.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SyncShareCommentEvent {
    public String channelId;
    public String content;
    public String extInfo;
    public String id;
    public String mediaId;
    private long currentPlayingTime = 0;
    private long realPlayingTime = 0;

    public SyncShareCommentEvent(String str, String str2, String str3) {
        this.id = str;
        this.content = str2;
        this.channelId = str3;
    }

    public long getCurrentPlayingTime() {
        return this.currentPlayingTime;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public long getRealPlayingTime() {
        return this.realPlayingTime;
    }

    public void setCurrentPlayingTime(long j) {
        this.currentPlayingTime = j;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void setRealPlayingTime(long j) {
        this.realPlayingTime = j;
    }
}
