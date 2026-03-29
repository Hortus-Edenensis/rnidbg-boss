package com.zenmen.media.roomchatdemo.videocallgroup;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoCallGroupUserAttribute implements Serializable, Cloneable {
    public int iconId;
    public String iconUrl;
    public a status;
    public long userCId;
    public long userId;
    public String userName;
    public b usertype;
    public int mute = 0;
    public int cameraon = 0;
    public boolean meetingStart = false;
    public int ctrlId = -1;
    public boolean firstframe = false;
    public boolean voiceDec = false;
    public boolean bstopped = false;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        disable_gone,
        disable_visible,
        connected,
        connecting
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        idle,
        others,
        myself,
        myinviter
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            return (VideoCallGroupUserAttribute) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isSame(VideoCallGroupUserAttribute videoCallGroupUserAttribute) {
        return videoCallGroupUserAttribute != null && this.status == videoCallGroupUserAttribute.status && this.iconId == videoCallGroupUserAttribute.iconId && this.userId == videoCallGroupUserAttribute.userId && this.iconUrl == videoCallGroupUserAttribute.iconUrl && this.userCId == videoCallGroupUserAttribute.userCId && this.userName == videoCallGroupUserAttribute.userName && this.usertype == videoCallGroupUserAttribute.usertype && this.mute == videoCallGroupUserAttribute.mute && this.cameraon == videoCallGroupUserAttribute.cameraon && this.meetingStart == videoCallGroupUserAttribute.meetingStart && this.ctrlId == videoCallGroupUserAttribute.ctrlId;
    }
}
