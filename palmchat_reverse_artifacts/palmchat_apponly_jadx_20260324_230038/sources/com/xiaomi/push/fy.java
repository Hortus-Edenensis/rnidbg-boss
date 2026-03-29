package com.xiaomi.push;

import com.xiaomi.push.af;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static af f11587a = new af(true, 20);

    public static void a(final Runnable runnable) {
        f11587a.a(new af.b() { // from class: com.xiaomi.push.fy.1
            @Override // com.xiaomi.push.af.b
            public void b() {
                runnable.run();
            }
        });
    }

    public static void a(af.b bVar) {
        f11587a.a(bVar);
    }

    public static void a(af.b bVar, long j) {
        f11587a.a(bVar, j);
    }
}
