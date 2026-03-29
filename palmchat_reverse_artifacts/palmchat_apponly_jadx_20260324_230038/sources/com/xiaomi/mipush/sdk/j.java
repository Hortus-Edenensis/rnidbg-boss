package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f11377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f60a;

    private j(Context context) {
        this.f60a = context.getApplicationContext();
    }

    private static j a(Context context) {
        if (f11377a == null) {
            synchronized (j.class) {
                if (f11377a == null) {
                    f11377a = new j(context);
                }
            }
        }
        return f11377a;
    }

    public static void b(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 2, z);
    }

    public static void c(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 3, z);
    }

    public static void d(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 4, z);
    }

    public static void e(Context context, hb hbVar, boolean z) {
        b bVarM99a = b.m99a(context);
        if (TextUtils.isEmpty(bVarM99a.m107c()) || TextUtils.isEmpty(bVarM99a.d())) {
            a(context).a(hbVar, 6, z);
        } else if (bVarM99a.m111f()) {
            a(context).a(hbVar, 7, z);
        } else {
            a(context).a(hbVar, 5, z);
        }
    }

    public static void a(Context context, hb hbVar, boolean z) {
        a(context).a(hbVar, 1, z);
    }

    public static void a(Context context, hb hbVar) {
        a(context).a(hbVar, 0, true);
    }

    private void a(hb hbVar, int i, boolean z) {
        if (com.xiaomi.push.j.m651a(this.f60a) || !com.xiaomi.push.j.m650a() || hbVar == null || hbVar.f655a != gf.SendMessage || hbVar.m553a() == null || !z) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("click to start activity result:" + String.valueOf(i));
        he heVar = new he(hbVar.m553a().m519a(), false);
        heVar.c(gp.SDK_START_ACTIVITY.f535a);
        heVar.b(hbVar.m554a());
        heVar.d(hbVar.f662b);
        HashMap map = new HashMap();
        heVar.f674a = map;
        map.put("result", String.valueOf(i));
        u.a(this.f60a).a(heVar, gf.Notification, false, false, null, true, hbVar.f662b, hbVar.f658a, true, false);
    }
}
