package com.zenmen.palmchat.giftkit.event;

import androidx.annotation.Keep;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class PackPanelUpdateEvent implements ds0.a {
    public long balance;
    public boolean netError;
    public int panelId;

    public PackPanelUpdateEvent(int i, boolean z, long j) {
        this.balance = j;
        this.panelId = i;
        this.netError = z;
    }
}
