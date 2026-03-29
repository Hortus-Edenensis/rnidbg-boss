package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ag;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11191a;
    final /* synthetic */ z b;

    public aa(z zVar, String str) {
        this.b = zVar;
        this.f11191a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context contextB = com.vivo.push.restructure.a.a().b();
        if (contextB == null) {
            return;
        }
        long j = m.a().f() ? 504L : 354L;
        if (TextUtils.isEmpty(this.f11191a) || !ag.a(contextB, contextB.getPackageName(), this.f11191a, j)) {
            return;
        }
        com.vivo.push.restructure.a.a().e().e();
        this.b.d = "";
    }
}
