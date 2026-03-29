package com.vivo.push.restructure.b;

import android.content.Context;
import com.vivo.push.PushConfig;
import com.vivo.push.util.ag;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11271a;
    final /* synthetic */ PushConfig b;
    final /* synthetic */ d c;

    public e(d dVar, Context context, PushConfig pushConfig) {
        this.c = dVar;
        this.f11271a = context;
        this.b = pushConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f11271a;
        ag.a(context, context.getPackageName(), this.b.isAgreePrivacyStatement());
    }
}
