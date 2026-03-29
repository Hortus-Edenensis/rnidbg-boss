package com.baidu.lbsapi.auth;

import java.util.Hashtable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3378a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;

    public m(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.f3378a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a("status = " + this.f3378a + "; forced = " + this.b + "checkAK = " + this.f.a(this.c, this.d));
        int i = this.f3378a;
        if (i != 601 && !this.b && i != -1 && !this.f.a(this.c, this.d)) {
            if (602 == this.f3378a) {
                b.a("authenticate wait ");
                if (LBSAuthManager.h != null) {
                    LBSAuthManager.h.b();
                }
            } else {
                b.a("authenticate else");
            }
            this.f.a(this.c, (String) null, this.d);
            return;
        }
        b.a("authenticate sendAuthRequest");
        String[] strArrB = d.b(LBSAuthManager.f3367a);
        if (strArrB == null || strArrB.length <= 1) {
            this.f.a(this.b, this.c, this.e, this.d, LBSAuthManager.b, LBSAuthManager.c, LBSAuthManager.d, LBSAuthManager.e);
            return;
        }
        b.a("authStrings.length:" + strArrB.length);
        b.a("more sha1 auth");
        this.f.a(this.b, this.c, this.e, strArrB, this.d, LBSAuthManager.b, LBSAuthManager.c, LBSAuthManager.d, LBSAuthManager.e);
    }
}
