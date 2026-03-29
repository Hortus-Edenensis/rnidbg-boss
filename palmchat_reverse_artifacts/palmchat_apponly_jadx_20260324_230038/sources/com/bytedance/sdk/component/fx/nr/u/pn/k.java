package com.bytedance.sdk.component.fx.nr.u.pn;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends IOException {
    public final nr u;

    public k(nr nrVar) {
        super("stream was reset: ".concat(String.valueOf(nrVar)));
        this.u = nrVar;
    }
}
