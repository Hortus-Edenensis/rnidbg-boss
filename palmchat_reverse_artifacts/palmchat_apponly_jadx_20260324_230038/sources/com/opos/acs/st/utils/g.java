package com.opos.acs.st.utils;

import android.content.Context;
import com.opos.cmn.biz.requeststatistic.InitParams;
import com.opos.cmn.biz.requeststatistic.RequestStatisticManager;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g {
    private static volatile g b;
    private static byte[] c = new byte[1];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7719a;

    private g(Context context) {
        if (context != null) {
            this.f7719a = context;
            b();
        }
    }

    public static g a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new g(context);
                }
            }
        }
        return b;
    }

    private void b() {
        RequestStatisticManager.getInstance().init(this.f7719a, new InitParams.Builder().build());
    }

    private boolean c() {
        boolean z = !"WIFI".equalsIgnoreCase(k.b(this.f7719a));
        com.opos.cmn.an.f.a.b("ReportErrorEngine", "isWifi:" + z);
        return z;
    }

    public void a() {
        try {
            if (c()) {
                RequestStatisticManager.getInstance().reportCacheIfNeed();
            }
        } catch (Exception e) {
            f.c("ReportErrorEngine", "report all error Exception", e);
        }
    }

    private void a(StatisticEvent statisticEvent) {
        try {
            RequestStatisticManager.getInstance().report(statisticEvent);
        } catch (Exception e) {
            f.c("ReportErrorEngine", "report error Exception", e);
        }
    }

    public void a(Map map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("errorMap=");
            sb.append(map != null ? map : com.igexin.push.core.b.m);
            f.a("ReportErrorEngine", sb.toString());
            StatisticEvent statisticEventA = com.opos.acs.st.entity.a.a(map);
            if (statisticEventA != null) {
                a(statisticEventA);
            }
        } catch (Exception e) {
            f.c("ReportErrorEngine", "reportOneRecord error Exception", e);
        }
    }
}
