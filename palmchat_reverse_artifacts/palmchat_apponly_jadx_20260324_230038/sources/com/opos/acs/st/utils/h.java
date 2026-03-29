package com.opos.acs.st.utils;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import java.lang.reflect.Field;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class h extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7720a;
    private long b;
    private long c;
    private Context d;

    public h(Context context, long j, long j2, long j3) {
        this.d = context;
        this.f7720a = j;
        this.b = j2;
        this.c = j3;
    }

    public void a(long j) {
        a(TimerTask.class, this, AnalyticsConfig.RTD_PERIOD, Long.valueOf(j));
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        long j;
        f.b("ReportTimerTask", "run timer report task now!!!");
        if (this.d != null) {
            boolean zE = k.e();
            boolean zD = com.opos.cmn.an.h.c.a.d(this.d);
            if (!zE || !zD) {
                f.b("ReportTimerTask", "schedule task,shouldRunTimer=" + zE + ",hasNet=" + zD);
                return;
            }
            k.d(this.d);
            long j2 = this.f7720a;
            if (j2 != 0) {
                long j3 = this.b;
                if (j3 == 0 || j2 == j3) {
                    return;
                }
                if (k.h(this.d) && this.c == this.f7720a) {
                    a(this.b);
                    j = this.b;
                } else {
                    if (k.h(this.d) || this.c != this.b) {
                        return;
                    }
                    a(this.f7720a);
                    j = this.f7720a;
                }
                this.c = j;
            }
        }
    }

    public static boolean a(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
            return true;
        } catch (Exception e) {
            f.c("ReportTimerTask", "setDeclaredField!", e);
            return false;
        }
    }
}
