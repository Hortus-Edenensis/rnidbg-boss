package com.kwad.sdk.core.videocache;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class p implements m {
    protected volatile String aQr;
    protected volatile int length = Integer.MIN_VALUE;
    protected String url;

    public abstract String Mn();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.aQr + "'}";
    }
}
