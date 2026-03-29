package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b implements b.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f8800a;
    private int b;

    public b(int i, p pVar) {
        this.b = i;
        this.f8800a = pVar;
    }

    @Override // com.opos.mobad.f.a.a.o
    public void a(int i, int i2, String str) {
        com.opos.cmn.an.f.a.b("AdDelegateListener", "onChannelFailed =" + this.b + "," + i + ",code=" + i2 + ",msg=" + str);
        this.f8800a.a(m.a(this.b, i, i2, str));
    }

    @Override // com.opos.mobad.ad.b.a
    public void onAdClose() {
        this.f8800a.e(this.b);
    }

    @Override // com.opos.mobad.ad.b.a
    public void onAdFailed(int i, String str) {
        a(this.b, i, str);
    }

    @Override // com.opos.mobad.ad.b.a
    public void onAdReady() {
        this.f8800a.d(this.b);
    }
}
