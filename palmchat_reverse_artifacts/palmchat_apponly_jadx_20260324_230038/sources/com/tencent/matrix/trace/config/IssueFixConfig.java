package com.tencent.matrix.trace.config;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class IssueFixConfig {
    private static final IssueFixConfig sInstance = new IssueFixConfig();
    private boolean enableFixSpApply;

    public static IssueFixConfig getsInstance() {
        return sInstance;
    }

    public boolean isEnableFixSpApply() {
        return this.enableFixSpApply;
    }

    public void setEnableFixSpApply(boolean z) {
        this.enableFixSpApply = z;
    }
}
