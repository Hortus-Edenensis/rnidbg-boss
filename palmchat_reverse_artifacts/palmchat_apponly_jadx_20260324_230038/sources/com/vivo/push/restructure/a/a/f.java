package com.vivo.push.restructure.a.a;

import com.vivo.push.PushClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f11264a;
    final /* synthetic */ String b;
    final /* synthetic */ e c;

    public f(e eVar, int i, String str) {
        this.c = eVar;
        this.f11264a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f11264a;
        if (i == 3) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).unBindAlias(this.b, null);
        } else if (i == 4) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).delTopic(this.b, null);
        }
    }
}
