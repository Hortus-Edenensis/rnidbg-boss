package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class o implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3380a;
    final /* synthetic */ String b;
    final /* synthetic */ LBSAuthManager c;

    public o(LBSAuthManager lBSAuthManager, String str, String str2) {
        this.c = lBSAuthManager;
        this.f3380a = str;
        this.b = str2;
    }

    @Override // com.baidu.lbsapi.auth.g.a
    public void a(String str) {
        this.c.a(this.f3380a, str, this.b);
    }
}
