package com.zenmen.palmchat.framework.bridge.voicomatch;

import androidx.annotation.Keep;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VoiceMatchInviteVideoEvent implements ds0.a {
    public boolean deny;
    public boolean invite;

    public VoiceMatchInviteVideoEvent(boolean z, boolean z2) {
        this.invite = z;
        this.deny = z2;
    }
}
