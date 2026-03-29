package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ae;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bi extends ae.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11441a;

    public bi(Context context) {
        this.f11441a = context;
    }

    @Override // com.xiaomi.push.ae.a
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo207a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f11441a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.f11441a).m85b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f11441a).m83a().isEventUploadSwitchOpen();
    }
}
