package com.igexin.c.a.c;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.c.a.d.g;
import com.igexin.push.config.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    private static volatile a b;
    private static final List<String> c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Logger f7047a;

    private a() {
        try {
            this.f7047a = new Logger(GtcProvider.context());
            this.f7047a.setGlobalTag("gtsdk");
            this.f7047a.setLogcatEnable(false);
            this.f7047a.setLogFileNameSuffix("GTSDK");
            this.f7047a.setStackOffset(1);
            this.f7047a.setFileEnableProperty("sdk.debug");
            List<String> list = c;
            list.add(g.h);
            list.add("ScheduleQueue");
        } catch (Throwable unused) {
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private static Logger b() {
        return a().f7047a;
    }

    private static void c(String str, String str2) {
        try {
            if (a().f7047a == null || str == null || c.contains(str)) {
                return;
            }
            a().f7047a.logcat(2, null, str2, null);
        } catch (Throwable unused) {
        }
    }

    private static void d(String str, String str2) {
        try {
            if (a().f7047a == null || str == null || c.contains(str)) {
                return;
            }
            a().f7047a.logcat(3, null, str2, null);
        } catch (Throwable unused) {
        }
    }

    private static void e(String str, String str2) {
        try {
            if (a().f7047a == null || str == null || c.contains(str)) {
                return;
            }
            a().f7047a.logcat(4, null, str2, null);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2) {
        try {
            if (a().f7047a == null || str == null || c.contains(str)) {
                return;
            }
            a().f7047a.e(str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2);
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, String str2) {
        try {
            if (a().f7047a == null || str == null || c.contains(str)) {
                return;
            }
            a().f7047a.d(str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Object... objArr) {
        try {
            if (a().f7047a != null) {
                if (objArr.length > 0) {
                    str = String.format(str, objArr);
                }
                a().f7047a.filelog(1, null, str, null);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Throwable th) {
        try {
            if (a().f7047a != null) {
                a().f7047a.e(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(boolean z) {
        try {
            e.a(Boolean.valueOf(z));
            if (a().f7047a != null) {
                a().f7047a.setLogcatEnable(false);
                a().f7047a.setFileEnableProperty("sdk.debug");
            }
        } catch (Throwable unused) {
        }
    }
}
