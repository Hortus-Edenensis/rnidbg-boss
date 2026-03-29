package com.igexin.push.c;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f extends com.igexin.push.f.b.f {
    private static f c;
    private boolean e;
    private static final String b = b.f7102a + f.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f7109a = new AtomicBoolean(false);

    private f() {
        super(10L, (byte) 0);
        this.p = true;
    }

    private void a(long j) {
        a(j, TimeUnit.MILLISECONDS);
    }

    public static synchronized f g() {
        if (c == null) {
            c = new f();
        }
        return c;
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 20150607;
    }

    @Override // com.igexin.push.f.b.f
    public final void h() {
        long j = b.c;
        a(j, TimeUnit.MILLISECONDS);
        if (this.e) {
            String str = b;
            com.igexin.c.a.c.a.a(str, "detect task already stop");
            com.igexin.c.a.c.a.a(str + "|detect task already stop", new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = b;
        sb.append(str2);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(j / 1000);
        sb.append("s passed, do task method, start redect ~~~~");
        com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
        boolean zE = com.igexin.push.g.c.e();
        com.igexin.push.core.e.n = zE;
        if (zE) {
            c.a().c();
            return;
        }
        com.igexin.c.a.c.a.a(str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + (j / 1000) + "s passed, network is unavailable, stop ###", new Object[0]);
    }

    public final void i() {
        this.p = false;
        this.e = true;
        l();
    }
}
