package com.zenmen.palmchat.conversations.threadbubble.bean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadsBubbleBean {
    boolean enable;
    long expiredTime;
    String iconUrl;
    boolean showCloseButton;
    boolean showCountdown;
    int treasureBoxStatus;
    String url;

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getTreasureBoxStatus() {
        return this.treasureBoxStatus;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isShowCloseButton() {
        return this.showCloseButton;
    }

    public boolean isShowCountdown() {
        return this.showCountdown;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setExpiredTime(long j) {
        this.expiredTime = j;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setShowCloseButton(boolean z) {
        this.showCloseButton = z;
    }

    public void setShowCountdown(boolean z) {
        this.showCountdown = z;
    }

    public void setTreasureBoxStatus(int i) {
        this.treasureBoxStatus = this.treasureBoxStatus;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
