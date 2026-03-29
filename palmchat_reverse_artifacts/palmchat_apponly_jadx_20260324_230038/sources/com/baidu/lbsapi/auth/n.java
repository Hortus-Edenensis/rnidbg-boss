package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class n implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3379a;
    final /* synthetic */ String b;
    final /* synthetic */ LBSAuthManager c;

    public n(LBSAuthManager lBSAuthManager, String str, String str2) {
        this.c = lBSAuthManager;
        this.f3379a = str;
        this.b = str2;
    }

    @Override // com.baidu.lbsapi.auth.e.a
    public void a(String str) {
        this.c.a(this.f3379a, str, this.b);
    }
}
