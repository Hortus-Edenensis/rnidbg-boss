package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f11781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f1023a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        Map<String, String> a(Context context, hb hbVar);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        void m774a(Context context, hb hbVar);

        void a(Context context, hb hbVar, he heVar);

        boolean a(Context context, hb hbVar, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(hb hbVar);

        void a(String str);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean m775a(hb hbVar);
    }

    public static void a(Context context, hb hbVar, he heVar) {
        a aVar = f11781a;
        if (aVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
        } else {
            aVar.a(context, hbVar, heVar);
        }
    }

    public static boolean a(Context context, hb hbVar, boolean z) {
        a aVar = f11781a;
        if (aVar != null && hbVar != null) {
            return aVar.a(context, hbVar, z);
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("pepa judement listener or container is null");
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m772a(Context context, hb hbVar) {
        a aVar = f11781a;
        if (aVar != null && hbVar != null) {
            aVar.m774a(context, hbVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m74a("handle msg wrong");
        }
    }

    public static Map<String, String> a(Context context, hb hbVar) {
        a aVar = f11781a;
        if (aVar != null && hbVar != null) {
            return aVar.a(context, hbVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("pepa listener or container is null");
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m773a(hb hbVar) {
        b bVar = f1023a;
        if (bVar != null && hbVar != null) {
            return bVar.m775a(hbVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("pepa handleReceiveMessage is null");
        return false;
    }

    public static void a(hb hbVar) {
        b bVar = f1023a;
        if (bVar != null && hbVar != null) {
            bVar.a(hbVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m74a("pepa clearMessage is null");
        }
    }

    public static void a(String str) {
        b bVar = f1023a;
        if (bVar != null && str != null) {
            bVar.a(str);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m74a("pepa clearMessage is null");
        }
    }
}
