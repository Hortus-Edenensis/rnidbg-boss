package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ae;
import com.xiaomi.push.gf;
import com.xiaomi.push.gl;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.gx;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class o extends ae.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f64a = false;

    public o(Context context) {
        this.f11381a = context;
    }

    @Override // com.xiaomi.push.ae.a
    /* JADX INFO: renamed from: a */
    public String mo207a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        ah ahVarA = ah.a(this.f11381a);
        gx gxVar = new gx();
        if (this.f64a) {
            gxVar.a(0);
            gxVar.b(0);
        } else {
            gxVar.a(ai.a(ahVarA, gl.MISC_CONFIG));
            gxVar.b(ai.a(ahVarA, gl.PLUGIN_CONFIG));
        }
        he heVar = new he("-1", false);
        heVar.c(gp.DailyCheckClientConfig.f535a);
        heVar.a(hp.a(gxVar));
        com.xiaomi.channel.commonutils.logger.b.b("OcVersionCheckJob", "-->check version: checkMessage=", gxVar);
        u.a(this.f11381a).a(heVar, gf.Notification, (gs) null);
    }
}
