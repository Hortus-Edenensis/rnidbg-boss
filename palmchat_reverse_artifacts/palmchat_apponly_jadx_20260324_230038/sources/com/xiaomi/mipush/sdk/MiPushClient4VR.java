package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.he;
import com.xiaomi.push.service.aj;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        he heVar = new he();
        heVar.c(gp.VRUpload.f535a);
        heVar.b(b.m99a(context).m100a());
        heVar.d(context.getPackageName());
        heVar.a("data", str);
        heVar.a(aj.a());
        u.a(context).a(heVar, gf.Notification, (gs) null);
    }
}
