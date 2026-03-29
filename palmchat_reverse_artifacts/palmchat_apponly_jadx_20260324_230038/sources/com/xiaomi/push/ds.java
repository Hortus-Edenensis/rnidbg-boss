package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f11523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Map<String, gp> f340a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void uploader(Context context, gj gjVar);
    }

    public static int a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m381a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    public static void a(a aVar) {
        f11523a = aVar;
    }

    private static void a(Context context, gj gjVar) {
        if (m383a(context.getApplicationContext())) {
            com.xiaomi.push.service.ba.a(context.getApplicationContext(), gjVar);
            return;
        }
        a aVar = f11523a;
        if (aVar != null) {
            aVar.uploader(context, gjVar);
        }
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static EventClientReport a(Context context, String str, String str2, int i, long j, String str3) {
        EventClientReport eventClientReportA = a(str);
        eventClientReportA.eventId = str2;
        eventClientReportA.eventType = i;
        eventClientReportA.eventTime = j;
        eventClientReportA.eventContent = str3;
        return eventClientReportA;
    }

    public static PerfClientReport a(Context context, int i, long j, long j2) {
        PerfClientReport perfClientReportA = a();
        perfClientReportA.code = i;
        perfClientReportA.perfCounts = j;
        perfClientReportA.perfLatencies = j2;
        return perfClientReportA;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m383a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                gj gjVarA = a(context, it.next());
                if (!com.xiaomi.push.service.az.a(gjVarA, false)) {
                    a(context, gjVarA);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static gj a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gj gjVar = new gj();
        gjVar.d("category_client_report_data");
        gjVar.a("push_sdk_channel");
        gjVar.a(1L);
        gjVar.b(str);
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(context.getPackageName());
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f(com.xiaomi.push.service.az.a());
        gjVar.c("quality_support");
        return gjVar;
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new dq(context), new dr(context));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m382a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static Config a(Context context) {
        boolean zA = com.xiaomi.push.service.ah.a(context).a(gk.PerfUploadSwitch.a(), false);
        boolean zA2 = com.xiaomi.push.service.ah.a(context).a(gk.EventUploadNewSwitch.a(), false);
        return Config.getBuilder().setEventUploadSwitchOpen(zA2).setEventUploadFrequency(com.xiaomi.push.service.ah.a(context).a(gk.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(zA).setPerfUploadFrequency(com.xiaomi.push.service.ah.a(context).a(gk.PerfUploadFrequency.a(), 86400)).build(context);
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof gf) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof gp) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof ed) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static gp m380a(String str) {
        if (f340a == null) {
            synchronized (gp.class) {
                if (f340a == null) {
                    f340a = new HashMap();
                    for (gp gpVar : gp.values()) {
                        f340a.put(gpVar.f535a.toLowerCase(), gpVar);
                    }
                }
            }
        }
        gp gpVar2 = f340a.get(str.toLowerCase());
        return gpVar2 != null ? gpVar2 : gp.Invalid;
    }
}
