package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gs;
import com.xiaomi.push.he;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile a f11354a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Context f31a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Boolean f33a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f34a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private C0925a f32a = new C0925a();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final ArrayList<gj> f35a = new ArrayList<>();

        /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0925a {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            private ScheduledFuture<?> f38a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            private ScheduledThreadPoolExecutor f39a = new ScheduledThreadPoolExecutor(1);

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final ArrayList<gj> f37a = new ArrayList<>();

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            private final Runnable f36a = new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0925a.this.f37a.size() != 0) {
                        C0925a.this.b();
                    } else if (C0925a.this.f38a != null) {
                        C0925a.this.f38a.cancel(false);
                        C0925a.this.f38a = null;
                    }
                }
            };

            public C0925a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                gj gjVarRemove = this.f37a.remove(0);
                for (he heVar : az.a(Arrays.asList(gjVarRemove), a.this.f31a.getPackageName(), b.m99a(a.this.f31a).m100a(), 30720)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + gjVarRemove.d());
                    u.a(a.this.f31a).a(heVar, gf.Notification, true, (gs) null);
                }
            }

            public void a(final gj gjVar) {
                this.f39a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C0925a.this.f37a.add(gjVar);
                        C0925a.this.a();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f38a == null) {
                    this.f38a = this.f39a.scheduleAtFixedRate(this.f36a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f35a) {
                arrayList.addAll(this.f35a);
                this.f35a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m95a((gj) it.next());
            }
        }

        public static a a() {
            if (f11354a == null) {
                synchronized (a.class) {
                    if (f11354a == null) {
                        f11354a = new a();
                    }
                }
            }
            return f11354a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m93a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m74a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f31a = context;
            this.f33a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        private boolean b(Context context) {
            return b.m99a(context).m100a() == null && !a(this.f31a);
        }

        private boolean b(gj gjVar) {
            if (az.a(gjVar, false)) {
                return false;
            }
            if (this.f33a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + gjVar.d());
                u.a(this.f31a).a(gjVar);
                return true;
            }
            this.f32a.a(gjVar);
            return true;
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m74a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f34a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        private boolean a(Context context) {
            if (!u.a(context).m144a()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m94a() {
            return this.f31a != null;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public synchronized boolean m95a(gj gjVar) {
            if (gjVar == null) {
                return false;
            }
            if (az.a(gjVar, true)) {
                return false;
            }
            boolean z = TextUtils.isEmpty(gjVar.m487a()) && TextUtils.isEmpty(this.f34a);
            boolean z2 = !m94a();
            Context context = this.f31a;
            boolean z3 = context == null || b(context);
            if (!z2 && !z && !z3) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + gjVar.d());
                if (TextUtils.isEmpty(gjVar.d())) {
                    gjVar.f(aj.a());
                }
                if (TextUtils.isEmpty(gjVar.m487a())) {
                    gjVar.a(this.f34a);
                }
                if (TextUtils.isEmpty(gjVar.c())) {
                    gjVar.e(this.f31a.getPackageName());
                }
                if (gjVar.a() <= 0) {
                    gjVar.b(System.currentTimeMillis());
                }
                return b(gjVar);
            }
            if (z) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + gjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_CHANNEL);
            } else if (z2) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + gjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT);
            } else if (z3) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + gjVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID);
            }
            a(gjVar);
            return true;
        }

        private void a(gj gjVar) {
            synchronized (this.f35a) {
                if (!this.f35a.contains(gjVar)) {
                    this.f35a.add(gjVar);
                    if (this.f35a.size() > 100) {
                        this.f35a.remove(0);
                    }
                }
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m93a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c(str2);
        gjVar.a(j);
        gjVar.b(str3);
        return a.a().m95a(gjVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c(str2);
        gjVar.a(j);
        gjVar.b(str3);
        gjVar.a(true);
        gjVar.a("push_sdk_channel");
        return upload(context, gjVar);
    }

    public static boolean upload(Context context, gj gjVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + gjVar.d());
        if (!a.a().m94a()) {
            a.a().m93a(context);
        }
        return a.a().m95a(gjVar);
    }
}
