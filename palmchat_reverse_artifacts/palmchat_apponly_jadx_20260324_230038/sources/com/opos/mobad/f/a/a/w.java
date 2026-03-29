package com.opos.mobad.f.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class w extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8829a;

    public w(String str, int i, long j) {
        super(str, j);
        this.f8829a = 3 == i ? "sdk_bidding" : "sdk_dsp";
    }

    @Override // com.opos.mobad.f.a.a.a
    public void a(String str, long j, String str2, int i, long j2, String str3, String str4) {
        com.opos.mobad.c.b.e().a(str, str2, i, j2, str3, this.f8829a, j, str4);
    }

    @Override // com.opos.mobad.f.a.a.a
    public void b(String str, long j, String str2, int i, long j2, String str3, String str4) {
        com.opos.mobad.c.b.e().b(str, str2, i, j2, str3, this.f8829a, j, str4);
    }
}
