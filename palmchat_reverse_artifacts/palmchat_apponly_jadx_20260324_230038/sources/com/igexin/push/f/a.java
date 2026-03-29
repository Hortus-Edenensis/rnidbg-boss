package com.igexin.push.f;

import android.os.Message;
import com.igexin.push.core.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a implements com.igexin.push.f.b.c {
    private static final long b = 360000;
    private static a c = null;
    private static String d = "CheckCondition";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7329a = 0;

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private static boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = com.igexin.push.core.e.S;
        if (j <= 0) {
            com.igexin.push.core.e.S = jCurrentTimeMillis - 60000;
            return true;
        }
        if (jCurrentTimeMillis - j <= 60000) {
            return false;
        }
        com.igexin.push.core.e.S = jCurrentTimeMillis;
        return true;
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        com.igexin.c.a.c.a.b("CheckConditionTask", "CheckConditionTask start to run check condition status...");
        Message messageObtain = Message.obtain();
        messageObtain.what = com.igexin.push.core.b.T;
        d.a.f7200a.a(messageObtain);
    }

    @Override // com.igexin.push.f.b.c
    public final boolean c() {
        return System.currentTimeMillis() - this.f7329a > b;
    }

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
        this.f7329a = j;
    }

    public final void a(boolean z) {
        if (!z || d()) {
            b();
        }
    }
}
