package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ae;
import com.xiaomi.push.bb;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bl;
import com.xiaomi.push.bm;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f11334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile a f12a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f13a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Config f14a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private IEventProcessor f15a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private IPerfProcessor f16a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f17a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ExecutorService f19a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f18a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    static {
        f11334a = j.m650a() ? 30 : 10;
    }

    private a(Context context) {
        this.f13a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f15a.b();
        } catch (Exception e) {
            b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f16a.b();
        } catch (Exception e) {
            b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f13a).m83a().isEventUploadSwitchOpen()) {
            final bi biVar = new bi(this.f13a);
            int eventUploadFrequency = (int) a(this.f13a).m83a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
            }
            if (System.currentTimeMillis() - bm.a(this.f13a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                ae.a(this.f13a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        biVar.run();
                    }
                }, 10);
            }
            synchronized (a.class) {
                if (!ae.a(this.f13a).a((ae.a) biVar, eventUploadFrequency)) {
                    ae.a(this.f13a).m155a("100886");
                    ae.a(this.f13a).a((ae.a) biVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        if (a(this.f13a).m83a().isPerfUploadSwitchOpen()) {
            final bj bjVar = new bj(this.f13a);
            int perfUploadFrequency = (int) a(this.f13a).m83a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
            }
            if (System.currentTimeMillis() - bm.a(this.f13a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                ae.a(this.f13a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        bjVar.run();
                    }
                }, 15);
            }
            synchronized (a.class) {
                if (!ae.a(this.f13a).a((ae.a) bjVar, perfUploadFrequency)) {
                    ae.a(this.f13a).m155a("100887");
                    ae.a(this.f13a).a((ae.a) bjVar, perfUploadFrequency);
                }
            }
        }
    }

    public void c() {
        if (m83a().isPerfUploadSwitchOpen()) {
            bk bkVar = new bk();
            bkVar.a(this.f16a);
            bkVar.a(this.f13a);
            this.f19a.execute(bkVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f15a;
        if (iEventProcessor != null) {
            iEventProcessor.mo86a(eventClientReport);
            if (a() >= 10) {
                d();
                ae.a(this.f13a).m155a("100888");
            } else {
                a(new ae.a() { // from class: com.xiaomi.clientreport.manager.a.3
                    @Override // com.xiaomi.push.ae.a
                    /* JADX INFO: renamed from: a */
                    public String mo207a() {
                        return "100888";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.a() > 0) {
                            a.this.f19a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.d();
                                }
                            });
                        }
                    }
                }, f11334a);
            }
        }
    }

    public static a a(Context context) {
        if (f12a == null) {
            synchronized (a.class) {
                if (f12a == null) {
                    f12a = new a(context);
                }
            }
        }
        return f12a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f16a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo86a(perfClientReport);
            if (b() >= 10) {
                e();
                ae.a(this.f13a).m155a("100889");
            } else {
                a(new ae.a() { // from class: com.xiaomi.clientreport.manager.a.4
                    @Override // com.xiaomi.push.ae.a
                    /* JADX INFO: renamed from: a */
                    public String mo207a() {
                        return "100889";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.b() > 0) {
                            a.this.f19a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.e();
                                }
                            });
                        }
                    }
                }, f11334a);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Config m83a() {
        if (this.f14a == null) {
            this.f14a = Config.defaultConfig(this.f13a);
        }
        return this.f14a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> map = this.f18a;
        int i = 0;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, com.xiaomi.clientreport.data.a> map2 = this.f18a.get(it.next());
                if (map2 != null) {
                    Iterator<String> it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        com.xiaomi.clientreport.data.a aVar = map2.get(it2.next());
                        if (aVar instanceof PerfClientReport) {
                            i = (int) (((long) i) + ((PerfClientReport) aVar).perfCounts);
                        }
                    }
                }
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m84a() {
        a(this.f13a).f();
        a(this.f13a).g();
    }

    public void a(String str) {
        this.f17a = str;
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f14a = config;
        this.f15a = iEventProcessor;
        this.f16a = iPerfProcessor;
        iEventProcessor.setEventMap(this.b);
        this.f16a.setPerfMap(this.f18a);
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f14a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f14a.isPerfUploadSwitchOpen() && j == this.f14a.getEventUploadFrequency() && j2 == this.f14a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f14a.getEventUploadFrequency();
            long perfUploadFrequency = this.f14a.getPerfUploadFrequency();
            Config configBuild = Config.getBuilder().setAESKey(bl.a(this.f13a)).setEventEncrypted(this.f14a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f13a);
            this.f14a = configBuild;
            if (!configBuild.isEventUploadSwitchOpen()) {
                ae.a(this.f13a).m155a("100886");
            } else if (eventUploadFrequency != configBuild.getEventUploadFrequency()) {
                b.c(this.f13a.getPackageName() + "reset event job " + configBuild.getEventUploadFrequency());
                f();
            }
            if (!this.f14a.isPerfUploadSwitchOpen()) {
                ae.a(this.f13a).m155a("100887");
                return;
            }
            if (perfUploadFrequency != configBuild.getPerfUploadFrequency()) {
                b.c(this.f13a.getPackageName() + " reset perf job " + configBuild.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m85b() {
        if (m83a().isEventUploadSwitchOpen()) {
            bk bkVar = new bk();
            bkVar.a(this.f13a);
            bkVar.a(this.f15a);
            this.f19a.execute(bkVar);
        }
    }

    private void a(ae.a aVar, int i) {
        ae.a(this.f13a).b(aVar, i);
    }

    public void a(final EventClientReport eventClientReport) {
        if (m83a().isEventUploadSwitchOpen()) {
            this.f19a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(eventClientReport);
                }
            });
        }
    }

    public void a(final PerfClientReport perfClientReport) {
        if (m83a().isPerfUploadSwitchOpen()) {
            this.f19a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(perfClientReport);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map = this.b;
        if (map == null) {
            return 0;
        }
        Iterator<String> it = map.keySet().iterator();
        int size = 0;
        while (it.hasNext()) {
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.b.get(it.next());
            size += arrayList != null ? arrayList.size() : 0;
        }
        return size;
    }

    public EventClientReport a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = bb.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f13a.getPackageName());
        eventClientReport.setSdkVersion(this.f17a);
        return eventClientReport;
    }
}
