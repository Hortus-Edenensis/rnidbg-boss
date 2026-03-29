package com.vivo.push.g;

import android.content.Context;
import android.content.Intent;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11236a;
    final /* synthetic */ Map b;
    final /* synthetic */ e c;

    public f(e eVar, Context context, Map map) {
        this.c = eVar;
        this.f11236a = context;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent launchIntentForPackage = this.f11236a.getPackageManager().getLaunchIntentForPackage(this.f11236a.getPackageName());
        if (launchIntentForPackage == null) {
            com.vivo.push.util.t.a("NotifyOpenClientTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(268435456);
        e.b(launchIntentForPackage, this.b);
        this.f11236a.startActivity(launchIntentForPackage);
    }
}
