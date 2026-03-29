package com.zenmen.media.crop;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class VideoInfo implements Serializable {
    private int fileID;
    private String mDuration;
    private int mHeight;
    private Long mThumbnailId;
    private String mTitle;
    private String mVideoPath;
    private int mWidth;

    public String getDuration() {
        return this.mDuration;
    }

    public int getFileID() {
        return this.fileID;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public long getThumbnailId() {
        return this.mThumbnailId.longValue();
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setDuration(String str) {
        this.mDuration = String.valueOf(Integer.valueOf(str).intValue() / 1000);
    }

    public void setFileID(int i) {
        this.fileID = i;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setVideoPath(String str) {
        this.mVideoPath = str;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setmThumbnailId(long j) {
        this.mThumbnailId = Long.valueOf(j);
    }
}
