package com.kwad.sdk.core.network.idc.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private final long aKp;
    private volatile boolean aKq = false;

    public a(long j, boolean z) {
        this.aKp = j;
    }

    public final boolean JD() {
        return this.aKq;
    }

    public final long JE() {
        return this.aKp;
    }

    public final a bu(boolean z) {
        this.aKq = true;
        return this;
    }
}
