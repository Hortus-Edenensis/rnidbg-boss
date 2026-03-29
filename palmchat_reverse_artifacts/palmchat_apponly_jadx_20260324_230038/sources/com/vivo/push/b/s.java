package com.vivo.push.b;

import com.qiniu.android.collect.ReportItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11209a;
    private int b;

    public s(int i) {
        super(i);
        this.f11209a = null;
        this.b = 0;
    }

    @Override // com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        dVar.a(ReportItem.RequestKeyRequestId, this.f11209a);
        dVar.a("status_msg_code", this.b);
    }

    @Override // com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        this.f11209a = dVar.a(ReportItem.RequestKeyRequestId);
        this.b = dVar.b("status_msg_code", this.b);
    }

    public final String h() {
        return this.f11209a;
    }

    public final int i() {
        return this.b;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "OnReceiveCommand";
    }
}
