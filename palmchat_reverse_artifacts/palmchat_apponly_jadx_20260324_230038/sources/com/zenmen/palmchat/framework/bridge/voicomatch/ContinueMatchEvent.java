package com.zenmen.palmchat.framework.bridge.voicomatch;

import androidx.annotation.Keep;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class ContinueMatchEvent implements ds0.a {
    public int from;
    public int type;

    public ContinueMatchEvent(int i, int i2) {
        this.from = i;
        this.type = i2;
    }
}
