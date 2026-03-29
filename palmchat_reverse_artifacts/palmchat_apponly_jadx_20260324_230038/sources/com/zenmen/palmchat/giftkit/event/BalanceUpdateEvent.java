package com.zenmen.palmchat.giftkit.event;

import androidx.annotation.Keep;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class BalanceUpdateEvent implements ds0.a {
    public long balance;

    public BalanceUpdateEvent(long j) {
        this.balance = j;
    }
}
