package com.vivo.push.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class InsideNotificationItem extends UPSNotificationMessage {
    private int mAppType;
    private int mDisplayStyle;
    private int mInnerPriority;
    private boolean mIsShowBigPicOnMobileNet;
    private int mMessageBizType;
    private int mMessageType;
    private boolean mNoShowOnForeground = false;
    private int mNotifyDisplayStatus;
    private String mReactPackage;
    private String mSuitReactVersion;
    private String mWindowPeriod;

    private int parsingNotifyStyle() {
        int i = this.mDisplayStyle;
        return ((i & 32) == 0 && (i & 16) != 0) ? 1 : 0;
    }

    public int getAppType() {
        return this.mAppType;
    }

    public int getDisplayStyle() {
        return this.mDisplayStyle;
    }

    public int getInnerPriority() {
        return this.mInnerPriority;
    }

    public int getMessageBizType() {
        return this.mMessageBizType;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public int getNotifyDisplayStatus() {
        return this.mNotifyDisplayStatus;
    }

    public String getReactPackage() {
        return this.mReactPackage;
    }

    public String getSuitReactVersion() {
        return this.mSuitReactVersion;
    }

    public String getWindowPeriod() {
        return this.mWindowPeriod;
    }

    public boolean isNoShowOnForeground() {
        return this.mNoShowOnForeground;
    }

    public boolean isOperateMsg() {
        return this.mMessageBizType == 0;
    }

    public boolean isShowBigPicOnMobileNet() {
        return this.mIsShowBigPicOnMobileNet;
    }

    public void noShowOnForeground() {
        this.mNoShowOnForeground = true;
    }

    public void setAppType(int i) {
        this.mAppType = i;
    }

    public void setDisplayStyle(int i) {
        this.mDisplayStyle = i;
        this.mNotifyDisplayStatus = parsingNotifyStyle();
    }

    public void setInnerPriority(int i) {
        this.mInnerPriority = i;
    }

    public void setIsShowBigPicOnMobileNet(boolean z) {
        this.mIsShowBigPicOnMobileNet = z;
    }

    public void setMessageBizType(int i) {
        this.mMessageBizType = i;
    }

    public void setMessageType(int i) {
        this.mMessageType = i;
    }

    public void setReactPackage(String str) {
        this.mReactPackage = str;
    }

    public void setSuitReactVersion(String str) {
        this.mSuitReactVersion = str;
    }

    public void setWindowPeriod(String str) {
        this.mWindowPeriod = str;
    }
}
