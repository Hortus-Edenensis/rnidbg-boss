package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRTCUser;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RtcUser {
    public String metaData;
    public String userId;

    public RtcUser() {
    }

    public String toString() {
        return "RtcUser{uid='" + this.userId + "', metaData='" + this.metaData + "'}";
    }

    public RtcUser(InternalRTCUser internalRTCUser) {
        this.userId = internalRTCUser.userId;
        this.metaData = internalRTCUser.metaData;
    }
}
