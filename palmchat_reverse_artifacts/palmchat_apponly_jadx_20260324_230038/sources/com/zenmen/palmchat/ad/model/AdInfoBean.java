package com.zenmen.palmchat.ad.model;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdInfoBean implements Serializable {
    private int mBeginTime;
    private int mBehavior;
    private float mBottom;
    private float mClickUpX;
    private float mClickUpY;
    private float mClickX;
    private float mClickY;
    private int mEndTime;
    private float mLeft;
    private String mPhonePPI;
    private int mPlayFirstFrame;
    private int mPlayLastFrame;
    private int mPlayTime;
    private float mRight;
    private int mScene;
    private int mStatus;
    private float mTop;
    private int mType;
    private int mVideoTime;

    public AdInfoBean() {
    }

    public float convertClickX() {
        return this.mClickX - this.mLeft;
    }

    public float convertClickY() {
        return this.mClickY - this.mTop;
    }

    public int getBeginTime() {
        return this.mBeginTime;
    }

    public int getBehavior() {
        return this.mBehavior;
    }

    public float getBottom() {
        return this.mBottom;
    }

    public float getClickUpX() {
        return this.mClickUpX;
    }

    public float getClickUpY() {
        return this.mClickUpY;
    }

    public int getClickX() {
        return (int) this.mClickX;
    }

    public int getClickY() {
        return (int) this.mClickY;
    }

    public int getEndTime() {
        return this.mEndTime;
    }

    public int getHeight() {
        return (int) (this.mBottom - this.mTop);
    }

    public float getLeft() {
        return this.mLeft;
    }

    public String getPhonePPI() {
        return this.mPhonePPI;
    }

    public int getPlayFirstFrame() {
        return this.mPlayFirstFrame;
    }

    public int getPlayLastFrame() {
        return this.mPlayLastFrame;
    }

    public int getPlayTime() {
        return this.mPlayTime;
    }

    public float getRight() {
        return this.mRight;
    }

    public int getScene() {
        return this.mScene;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public float getTop() {
        return this.mTop;
    }

    public int getType() {
        return this.mType;
    }

    public int getVideoTime() {
        return this.mVideoTime;
    }

    public int getWidth() {
        return (int) (this.mRight - this.mLeft);
    }

    public void setBeginTime(int i) {
        this.mBeginTime = i;
    }

    public void setBehavior(int i) {
        this.mBehavior = i;
    }

    public void setBottom(float f) {
        this.mBottom = f;
    }

    public void setClickUpX(float f) {
        this.mClickUpX = f;
    }

    public void setClickUpY(float f) {
        this.mClickUpY = f;
    }

    public void setClickX(float f) {
        this.mClickX = f;
    }

    public void setClickY(float f) {
        this.mClickY = f;
    }

    public void setEndTime(int i) {
        this.mEndTime = i;
    }

    public void setLeft(float f) {
        this.mLeft = f;
    }

    public void setPhonePPI(String str) {
        this.mPhonePPI = str;
    }

    public void setPlayFirstFrame(int i) {
        this.mPlayFirstFrame = i;
    }

    public void setPlayLastFrame(int i) {
        this.mPlayLastFrame = i;
    }

    public void setPlayTime(int i) {
        this.mPlayTime = i;
    }

    public void setRight(float f) {
        this.mRight = f;
    }

    public void setScene(int i) {
        this.mScene = i;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public void setTop(float f) {
        this.mTop = f;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setVideoTime(int i) {
        this.mVideoTime = i;
    }

    public String toString() {
        return "AdInfoBean{mLeft=" + this.mLeft + ", mTop=" + this.mTop + ", mRight=" + this.mRight + ", mBottom=" + this.mBottom + ", mClickX=" + this.mClickX + ", mClickY=" + this.mClickY + ", mClickUpX=" + this.mClickUpX + ", mClickUpY=" + this.mClickUpY + ", mVideoTime=" + this.mVideoTime + ", mPlayTime=" + this.mPlayTime + ", mPhonePPI=" + this.mPhonePPI + ", mBeginTime=" + this.mBeginTime + ", mEndTime=" + this.mEndTime + ", mPlayFirstFrame=" + this.mPlayFirstFrame + ", mPlayLastFrame=" + this.mPlayLastFrame + ", mScene=" + this.mScene + ", mType=" + this.mType + ", mBehavior=" + this.mBehavior + ", mStatus=" + this.mStatus + '}';
    }

    public AdInfoBean(float f, float f2, float f3, float f4) {
        this.mLeft = f;
        this.mTop = f2;
        this.mRight = f3;
        this.mBottom = f4;
    }
}
