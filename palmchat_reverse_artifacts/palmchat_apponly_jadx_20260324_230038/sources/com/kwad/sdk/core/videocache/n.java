package com.kwad.sdk.core.videocache;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class n {
    public final long aQq;
    public final String aQr;
    public final String url;

    public n(String str, long j, String str2) {
        this.url = str;
        this.aQq = j;
        this.aQr = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.aQq + ", mime='" + this.aQr + "'}";
    }
}
