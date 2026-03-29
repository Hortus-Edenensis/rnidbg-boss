package com.ss.bytertc.engine.type;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ProblemFeedbackRoomInfo {
    public String roomId;
    public String userId;

    public ProblemFeedbackRoomInfo() {
    }

    @CalledByNative
    public String getRoomId() {
        return this.roomId;
    }

    @CalledByNative
    public String getUserId() {
        return this.userId;
    }

    public ProblemFeedbackRoomInfo(String str, String str2) {
        this.roomId = str;
        this.userId = str2;
    }
}
