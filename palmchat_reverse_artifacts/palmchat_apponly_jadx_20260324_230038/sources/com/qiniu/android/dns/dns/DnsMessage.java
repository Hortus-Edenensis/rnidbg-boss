package com.qiniu.android.dns.dns;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class DnsMessage {
    static final int OpCodeIQuery = 1;
    static final int OpCodeQuery = 0;
    static final int OpCodeStatus = 2;
    static final int OpCodeUpdate = 5;
    protected short messageId = 0;
    protected int opCode = 0;
    protected int rd = 1;
    protected int ra = 0;

    public int getMessageId() {
        return this.messageId;
    }

    public int getOpCode() {
        return this.opCode;
    }

    public int getRA() {
        return this.ra;
    }

    public int getRD() {
        return this.rd;
    }
}
