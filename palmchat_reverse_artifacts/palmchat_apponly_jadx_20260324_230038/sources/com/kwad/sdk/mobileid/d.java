package com.kwad.sdk.mobileid;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    private String aYh;
    private String errorReason;
    private boolean success;

    public d(boolean z, String str) {
        this.success = z;
        this.errorReason = str;
    }

    public final String Po() {
        return this.errorReason;
    }

    public final String Pp() {
        return this.aYh;
    }

    public final void gD(String str) {
        this.aYh = str;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String toString() {
        return "UaidErrorReason{success=" + this.success + ", errorReason='" + this.errorReason + "', extraErrorMsg='" + this.aYh + "'}";
    }
}
