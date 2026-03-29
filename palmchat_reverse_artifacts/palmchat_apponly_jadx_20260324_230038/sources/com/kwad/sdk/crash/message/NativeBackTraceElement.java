package com.kwad.sdk.crash.message;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsJson
public final class NativeBackTraceElement extends BackTraceElement {
    private static final long serialVersionUID = 8646793782725084250L;
    public String mBuildId;
    public String mPc;

    public NativeBackTraceElement(String str, int i) {
        super(str, i);
        this.mBuildId = "";
        this.mPc = "";
    }

    public final String getBuildId() {
        return this.mBuildId;
    }

    public final String getPc() {
        return this.mPc;
    }

    public final void setBuildId(String str) {
        this.mBuildId = str;
    }

    public final void setPc(String str) {
        this.mPc = str;
    }
}
