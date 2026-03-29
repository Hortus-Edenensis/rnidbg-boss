package com.xiaomi.push.service;

import com.xiaomi.push.C1401r;
import com.xiaomi.push.he;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f11755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f981a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        boolean a(he heVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    public static void a(b bVar) {
        f981a = bVar;
    }

    public static boolean a(he heVar) {
        if (f11755a == null || heVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("rc params is null, not cpra");
            return false;
        }
        if (com.xiaomi.push.j.m651a(C1401r.m660a())) {
            return f11755a.a(heVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("rc app not permission to cpra");
        return false;
    }
}
