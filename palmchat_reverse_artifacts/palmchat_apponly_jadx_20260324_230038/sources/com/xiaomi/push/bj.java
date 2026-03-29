package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ae;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bj extends ae.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11442a;

    public bj(Context context) {
        this.f11442a = context;
    }

    @Override // com.xiaomi.push.ae.a
    /* JADX INFO: renamed from: a */
    public String mo207a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.f11442a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.f11442a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e);
        }
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f11442a).m83a().isPerfUploadSwitchOpen();
    }
}
