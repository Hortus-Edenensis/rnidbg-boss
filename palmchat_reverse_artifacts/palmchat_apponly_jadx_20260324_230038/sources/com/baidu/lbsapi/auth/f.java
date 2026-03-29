package com.baidu.lbsapi.auth;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3371a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ e e;

    public f(e eVar, String str, int i, String str2, String str3) {
        this.e = eVar;
        this.f3371a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        b.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        this.e.a(new i(this.e.f3370a).a(this.e.b, this.f3371a, this.b, this.c, this.d));
    }
}
