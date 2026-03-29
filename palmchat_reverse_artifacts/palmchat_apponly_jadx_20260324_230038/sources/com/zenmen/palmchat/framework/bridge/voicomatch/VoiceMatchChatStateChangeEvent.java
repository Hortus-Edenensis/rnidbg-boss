package com.zenmen.palmchat.framework.bridge.voicomatch;

import androidx.annotation.Keep;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VoiceMatchChatStateChangeEvent implements ds0.a {
    public boolean isUserInvitePublishInfo;
    public boolean isUserPublishInfo;

    public VoiceMatchChatStateChangeEvent(boolean z, boolean z2) {
        this.isUserPublishInfo = z;
        this.isUserInvitePublishInfo = z2;
    }
}
