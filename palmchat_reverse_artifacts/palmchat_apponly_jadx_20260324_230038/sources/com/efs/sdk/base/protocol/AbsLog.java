package com.efs.sdk.base.protocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbsLog implements ILogProtocol {
    private String cp = "none";

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private byte f5602de = 1;
    private String logType;

    public AbsLog(String str) {
        this.logType = str;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLogType() {
        return this.logType;
    }

    public boolean isCp() {
        return !this.cp.equals("none");
    }

    public boolean isDe() {
        return this.f5602de != 1;
    }

    public void setCp(String str) {
        this.cp = str;
    }

    public void setDe(byte b) {
        this.f5602de = b;
    }
}
