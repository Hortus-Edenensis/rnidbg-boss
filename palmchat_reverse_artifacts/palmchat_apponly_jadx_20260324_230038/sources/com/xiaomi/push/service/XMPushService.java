package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.igexin.sdk.PushConsts;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.C1401r;
import com.xiaomi.push.bh;
import com.xiaomi.push.bl;
import com.xiaomi.push.cg;
import com.xiaomi.push.cn;
import com.xiaomi.push.ct;
import com.xiaomi.push.cx;
import com.xiaomi.push.db;
import com.xiaomi.push.dp;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.dz;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.er;
import com.xiaomi.push.ey;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fd;
import com.xiaomi.push.ff;
import com.xiaomi.push.fg;
import com.xiaomi.push.fi;
import com.xiaomi.push.fk;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fq;
import com.xiaomi.push.fz;
import com.xiaomi.push.ga;
import com.xiaomi.push.gd;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.hb;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.n;
import com.xiaomi.push.service.q;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class XMPushService extends Service implements fd {
    private static boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ContentObserver f872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ey f874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fa f875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fb f876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private f f879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private k f880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private r f881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private t f882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private as f884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.h f885a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f891a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11669a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private int f892b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f871a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Class f887a = XMJobService.class;
    private int c = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ak f883a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.n f886a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Messenger f873a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Collection<aa> f890a = Collections.synchronizedCollection(new ArrayList());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<n> f889a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ff f877a = new ff() { // from class: com.xiaomi.push.service.XMPushService.1
        @Override // com.xiaomi.push.ff
        public void a(fo foVar) {
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new m(foVar));
        }

        @Override // com.xiaomi.push.ff
        public void a(er erVar) {
            if (com.xiaomi.push.service.e.a(erVar)) {
                at.a().a(erVar.e(), SystemClock.elapsedRealtime(), XMPushService.this.m683a());
            }
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new d(erVar));
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final Object f898a;

        private a() {
            this.f898a = new Object();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!an.q.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.m74a("[Alarm] cancel the old ping timer");
                dz.a();
                return;
            }
            if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000L);
                    com.xiaomi.channel.commonutils.logger.b.m74a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f898a) {
                try {
                    this.f898a.wait(j);
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("[Alarm] interrupt from waiting state. " + e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f898a) {
                try {
                    this.f898a.notifyAll();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("[Alarm] notify lock. " + e);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final am.b f11686a;

        public c(am.b bVar) {
            super(12);
            this.f11686a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            this.f11686a.a(am.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return TextUtils.equals(((c) obj).f11686a.g, this.f11686a.g);
            }
            return false;
        }

        public int hashCode() {
            return this.f11686a.g.hashCode();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind time out. chid=" + this.f11686a.g;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private er f11687a;

        public d(er erVar) {
            super(8);
            this.f11687a = erVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            XMPushService.this.f883a.a(this.f11687a);
            if (com.xiaomi.push.service.e.a(this.f11687a)) {
                XMPushService.this.a(new at.a(), C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends j {
        public e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            if (XMPushService.this.m687a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("should not connect. quit the job.");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.au.m174a();
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends j {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Exception f901a;
        public int b;

        public g(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f901a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            XMPushService.this.a(this.b, this.f901a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends j {
        public h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            XMPushService.this.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Intent f11692a;

        public i(Intent intent) {
            super(15);
            this.f11692a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            XMPushService.this.d(this.f11692a);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Handle intent action = " + this.f11692a.getAction();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class j extends n.b {
        public j(int i) {
            super(i);
        }

        public abstract String a();

        /* JADX INFO: renamed from: a */
        public abstract void mo403a();

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f11761a;
            if (i != 4 && i != 8) {
                com.xiaomi.channel.commonutils.logger.b.m75a(com.xiaomi.channel.commonutils.logger.a.f11331a, a());
            }
            mo403a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends BroadcastReceiver {
        public k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m74a("[HB] hold short heartbeat, " + com.xiaomi.push.j.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            XMPushService.this.f886a.m754a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private fo f11695a;

        public m(fo foVar) {
            super(8);
            this.f11695a = foVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            XMPushService.this.f883a.a(this.f11695a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface n {
        /* JADX INFO: renamed from: a */
        void mo482a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends j {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f904a;

        public o(boolean z) {
            super(4);
            this.f904a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            if (XMPushService.this.m692c()) {
                try {
                    if (!this.f904a) {
                        ep.a();
                    }
                    XMPushService.this.f875a.b(this.f904a);
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q extends j {
        public q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m687a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends BroadcastReceiver {
        public r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t extends BroadcastReceiver {
        public t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f891a) {
                XMPushService.this.f891a = true;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    private void d() {
        com.xiaomi.push.av avVarM168a = com.xiaomi.push.au.m168a();
        com.xiaomi.push.service.m.a(getApplicationContext()).a(avVarM168a);
        if (avVarM168a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + avVarM168a.m178a() + "[" + avVarM168a.m180b() + "], state: " + avVarM168a.m177a() + "/" + avVarM168a.m176a());
            com.xiaomi.channel.commonutils.logger.b.m75a("XMPushService", sb.toString());
            NetworkInfo.State stateM177a = avVarM168a.m177a();
            if (stateM177a == NetworkInfo.State.SUSPENDED || stateM177a == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m75a("XMPushService", "network changed, no active network");
        }
        if (eo.a() != null) {
            eo.a().m405a();
        }
        fz.m471a((Context) this);
        this.f874a.d();
        if (com.xiaomi.push.au.m175a((Context) this)) {
            if (m692c() && m679f()) {
                b(false);
            }
            if (!m692c() && !m693d()) {
                this.f886a.a(1);
                a(new e());
            }
            db.a(this).a();
        } else {
            a(new g(2, null));
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!m687a()) {
            dz.a();
        } else {
            if (dz.m395a()) {
                return;
            }
            dz.a(true);
        }
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    private boolean m679f() {
        if (SystemClock.elapsedRealtime() - this.f871a < 30000) {
            return false;
        }
        return com.xiaomi.push.au.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    public boolean m680g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* JADX INFO: renamed from: i, reason: collision with other method in class */
    private boolean m682i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m644b((Context) this) && !com.xiaomi.push.i.m641a(getApplicationContext());
    }

    private boolean j() {
        int iIntValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.f11669a;
        int i3 = this.f892b;
        if (i2 > i3) {
            if (iIntValue >= i2 || iIntValue < i3) {
                return true;
            }
        } else if (i2 < i3 && iIntValue >= i2 && iIntValue < i3) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ah.a(this).a(gk.ForegroundServiceSwitch.a(), false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f873a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] strArrSplit;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        C1401r.a((Context) this);
        com.xiaomi.push.service.p pVarM765a = com.xiaomi.push.service.q.m765a((Context) this);
        if (pVarM765a != null) {
            com.xiaomi.push.x.a(pVarM765a.f11767a);
        }
        if (com.xiaomi.push.j.m651a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f878a = new a();
            com.xiaomi.push.m.a(this, this.f878a, new IntentFilter(an.q), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            b = true;
            handler.post(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                        ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m74a("[Alarm] disable ping receiver may be failure. " + th);
                    }
                }
            });
        }
        this.f873a = new Messenger(new Handler() { // from class: com.xiaomi.push.service.XMPushService.8
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    try {
                        int i2 = message.what;
                        if (i2 == 17) {
                            Object obj = message.obj;
                            if (obj != null) {
                                XMPushService.this.onStart((Intent) obj, 1);
                            }
                        } else if (i2 == 18) {
                            Message messageObtain = Message.obtain((Handler) null, 0);
                            messageObtain.what = 18;
                            Bundle bundle = new Bundle();
                            bundle.putString("xmsf_region", com.xiaomi.push.service.b.a(XMPushService.this.getApplicationContext()).a());
                            messageObtain.setData(bundle);
                            message.replyTo.send(messageObtain);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        ao.a(this);
        fb fbVar = new fb(null, 5222, "xiaomi.com", null) { // from class: com.xiaomi.push.service.XMPushService.9
            @Override // com.xiaomi.push.fb
            /* JADX INFO: renamed from: a */
            public byte[] mo446a() {
                try {
                    dp.b bVar = new dp.b();
                    bVar.a(ax.a().m732a());
                    return bVar.m398a();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("getOBBString err: " + e2.toString());
                    return null;
                }
            }
        };
        this.f876a = fbVar;
        fbVar.a(true);
        this.f874a = new ey(this, this.f876a);
        this.f885a = m685a();
        dz.a(this);
        this.f874a.a(this);
        this.f883a = new ak(this);
        this.f884a = new as(this);
        new com.xiaomi.push.service.i().a();
        eo.m406a().a(this);
        this.f886a = new com.xiaomi.push.service.n("Connection Controller Thread");
        am amVarA = am.a();
        amVarA.b();
        amVarA.a(new am.a() { // from class: com.xiaomi.push.service.XMPushService.10
            @Override // com.xiaomi.push.service.am.a
            public void a() {
                XMPushService.this.e();
                if (am.a().m715a() <= 0) {
                    XMPushService xMPushService = XMPushService.this;
                    xMPushService.a(xMPushService.new g(12, null));
                }
            }
        });
        if (k()) {
            h();
        }
        gd.a(this).a(new com.xiaomi.push.service.o(this), "UPLOADER_PUSH_CHANNEL");
        a(new ga(this));
        a(new bd(this));
        if (com.xiaomi.push.j.m651a((Context) this)) {
            a(new al());
            if (com.xiaomi.push.i.m640a()) {
                a(new n() { // from class: com.xiaomi.push.service.XMPushService.11
                    @Override // com.xiaomi.push.service.XMPushService.n
                    /* JADX INFO: renamed from: a */
                    public void mo482a() {
                        bh.a(XMPushService.this.getApplicationContext());
                    }
                });
            }
        }
        a(new h());
        this.f890a.add(ay.a(this));
        if (m681h()) {
            this.f879a = new f();
            com.xiaomi.push.m.a(this, this.f879a, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE), (String) null, (Handler) null);
            this.f888a = com.xiaomi.push.au.m170a((Context) this);
        }
        if (com.xiaomi.push.j.m651a(getApplicationContext())) {
            this.f882a = new t();
            com.xiaomi.push.m.a(this, this.f882a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            k kVar = new k();
            this.f880a = kVar;
            com.xiaomi.push.m.a(this, kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f872a = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.push.service.XMPushService.12
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        super.onChange(z);
                        boolean zM680g = XMPushService.this.m680g();
                        com.xiaomi.channel.commonutils.logger.b.m74a("SuperPowerMode:" + zM680g);
                        XMPushService.this.e();
                        if (!zM680g) {
                            XMPushService.this.a(true);
                        } else {
                            XMPushService xMPushService = XMPushService.this;
                            xMPushService.a(xMPushService.new g(24, null));
                        }
                    }
                };
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f872a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] iArrM676a = m676a();
            if (iArrM676a != null) {
                this.f881a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                com.xiaomi.push.m.a(this, this.f881a, intentFilter, (String) null, (Handler) null);
                this.f11669a = iArrM676a[0];
                this.f892b = iArrM676a[1];
                com.xiaomi.channel.commonutils.logger.b.m74a("falldown initialized: " + this.f11669a + "," + this.f892b);
            }
        }
        cn.a(this, this.f874a);
        ct.a(this, this.f874a);
        String str = "";
        if (pVarM765a != null) {
            try {
                if (!TextUtils.isEmpty(pVarM765a.f1005a) && (strArrSplit = pVarM765a.f1005a.split("@")) != null && strArrSplit.length > 0) {
                    str = strArrSplit[0];
                }
            } catch (Exception unused) {
            }
        }
        cx.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        f fVar = this.f879a;
        if (fVar != null) {
            a(fVar);
            this.f879a = null;
        }
        Object obj = this.f888a;
        if (obj != null) {
            com.xiaomi.push.au.a(this, obj);
            this.f888a = null;
        }
        t tVar = this.f882a;
        if (tVar != null) {
            a(tVar);
            this.f882a = null;
        }
        k kVar = this.f880a;
        if (kVar != null) {
            a(kVar);
            this.f880a = null;
        }
        r rVar = this.f881a;
        if (rVar != null) {
            a(rVar);
            this.f881a = null;
        }
        a aVar = this.f878a;
        if (aVar != null) {
            a(aVar);
            this.f878a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f872a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f872a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f890a.clear();
        this.f886a.m757b();
        a(new j(2) { // from class: com.xiaomi.push.service.XMPushService.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "disconnect for service destroy.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                if (XMPushService.this.f875a != null) {
                    XMPushService.this.f875a.b(15, (Exception) null);
                    XMPushService.this.f875a = null;
                }
            }
        });
        a(new l());
        am.a().b();
        am.a().a(this, 15);
        am.a().m719a();
        this.f874a.b(this);
        ax.a().m734a();
        dz.a();
        i();
        cn.b(this, this.f874a);
        ct.b(this, this.f874a);
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m74a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            try {
                String stringExtra = intent.getStringExtra(an.v);
                String stringExtra2 = intent.getStringExtra(an.F);
                String stringExtra3 = intent.getStringExtra("mipush_app_package");
                if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction()) || "miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                    com.xiaomi.channel.commonutils.logger.b.m75a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", intent.getAction(), stringExtra, stringExtra2, stringExtra3, com.xiaomi.push.j.a(intent)));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m75a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), stringExtra, stringExtra2, stringExtra3));
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() cause error: " + th.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f886a.m755a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    am.a().a(this, 14);
                    stopSelf();
                } else {
                    a(new i(intent));
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                a(new i(intent));
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + jCurrentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return com.xiaomi.push.j.m651a((Context) this) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(1:4)(1:5)|6|(2:12|(3:14|(1:16)(1:17)|18)(10:19|20|(1:22)|23|(1:25)|36|26|(1:28)|32|(2:34|35)(1:38)))(1:10)|11|20|(0)|23|(0)|36|26|(0)|32|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e5, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de A[Catch: Exception -> 0x00e4, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e4, blocks: (B:26:0x00d8, B:28:0x00de), top: B:36:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        String str;
        cg.a().m261d();
        com.xiaomi.push.service.m.a(getApplicationContext()).m748a();
        com.xiaomi.push.service.b bVarA = com.xiaomi.push.service.b.a(getApplicationContext());
        String strA = bVarA.a();
        com.xiaomi.channel.commonutils.logger.b.m75a("XMPushService", "region of cache is " + strA);
        String strName = "";
        if (TextUtils.isEmpty(strA)) {
            String strB = b();
            str = strB;
            strA = com.xiaomi.push.j.a(strB).name();
        } else {
            str = "";
        }
        String str2 = "CN";
        if (!TextUtils.isEmpty(strA) && com.xiaomi.push.n.China.name().equals(strA)) {
            bVarA.a(strA, true);
            bVarA.b("CN", true);
        } else {
            if (TextUtils.isEmpty(strA)) {
                strA = com.xiaomi.push.n.China.name();
                com.xiaomi.channel.commonutils.logger.b.m76a("XMPushService", "after check, appRegion is ", strA, ", countryCode=", str);
                if (com.xiaomi.push.n.China.name().equals(strA)) {
                    fb.a("cn.app.chat.xiaomi.net");
                }
                a(strA);
                if (m681h()) {
                    com.xiaomi.channel.commonutils.logger.b.m75a("XMPushService", "-->postOnCreate(): try trigger connect now");
                    final j jVar = new j(11) { // from class: com.xiaomi.push.service.XMPushService.13
                        @Override // com.xiaomi.push.service.XMPushService.j
                        public String a() {
                            return "prepare the mi push account.";
                        }

                        @Override // com.xiaomi.push.service.XMPushService.j
                        /* JADX INFO: renamed from: a */
                        public void mo403a() {
                            w.a(XMPushService.this);
                            if (com.xiaomi.push.au.m175a((Context) XMPushService.this)) {
                                XMPushService.this.a(true);
                            }
                        }
                    };
                    a(jVar);
                    com.xiaomi.push.service.q.a(new q.a() { // from class: com.xiaomi.push.service.XMPushService.14
                        @Override // com.xiaomi.push.service.q.a
                        public void a() {
                            XMPushService.this.a(jVar);
                        }
                    });
                }
                if (C1401r.m662a()) {
                    this.f885a.a(this);
                }
                if ("com.xiaomi.xmsf".equals(getPackageName())) {
                    return;
                }
                com.xiaomi.push.g.a((Context) this, getApplicationInfo(), true);
                return;
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                str2 = "";
            } else {
                strName = com.xiaomi.push.n.China.name();
            }
            bVarA.a(strName, true);
            bVarA.b(str2, true);
            strA = strName;
        }
        str = str2;
        com.xiaomi.channel.commonutils.logger.b.m76a("XMPushService", "after check, appRegion is ", strA, ", countryCode=", str);
        if (com.xiaomi.push.n.China.name().equals(strA)) {
        }
        a(strA);
        if (m681h()) {
        }
        if (C1401r.m662a()) {
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
        }
    }

    /* JADX INFO: renamed from: h, reason: collision with other method in class */
    private boolean m681h() {
        boolean zEquals;
        String packageName = getPackageName();
        if ("com.xiaomi.xmsf".equals(packageName)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("current sdk expect region is cn");
            zEquals = com.xiaomi.push.n.China.name().equals(com.xiaomi.push.service.b.a(getApplicationContext()).a());
        } else {
            zEquals = !com.xiaomi.push.service.r.a(this).m770b(packageName);
        }
        if (!zEquals) {
            com.xiaomi.channel.commonutils.logger.b.m76a("XMPushService", "-->isPushEnabled(): isEnabled=", Boolean.valueOf(zEquals), ", package=", packageName, ", region=", com.xiaomi.push.service.b.a(getApplicationContext()).a());
        }
        return zEquals;
    }

    private String b() {
        String strA;
        com.xiaomi.push.ag.a();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            ap apVarA = ap.a(this);
            String strA2 = null;
            while (true) {
                if (!TextUtils.isEmpty(strA2) && apVarA.a() != 0) {
                    strA = a();
                    break;
                }
                if (TextUtils.isEmpty(strA2)) {
                    strA2 = a();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i2++;
            }
        } else {
            strA = "CN";
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("wait coutrycode :" + strA + " cost = " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " , count = " + i2);
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        fa faVar = this.f875a;
        if (faVar != null && faVar.m442b()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
            return;
        }
        fa faVar2 = this.f875a;
        if (faVar2 != null && faVar2.m443c()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
            return;
        }
        this.f876a.b(com.xiaomi.push.au.m171a((Context) this));
        g();
        if (this.f875a == null) {
            am.a().a(this);
            c(false);
        }
    }

    private void g() {
        try {
            this.f874a.a(this.f877a, new fk() { // from class: com.xiaomi.push.service.XMPushService.5
                @Override // com.xiaomi.push.fk
                /* JADX INFO: renamed from: a */
                public boolean mo264a(fo foVar) {
                    return true;
                }
            });
            this.f874a.e();
            this.f875a = this.f874a;
        } catch (fi e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f874a.b(3, e2);
        }
    }

    private void i() {
        synchronized (this.f889a) {
            this.f889a.clear();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p extends j {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        am.b f905a;

        public p(am.b bVar) {
            super(4);
            this.f905a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            try {
                this.f905a.a(am.c.unbind, 1, 16, (String) null, (String) null);
                fa faVar = XMPushService.this.f875a;
                am.b bVar = this.f905a;
                faVar.a(bVar.g, bVar.f939b);
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(xMPushService.new b(this.f905a), 300L);
            } catch (fi e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "rebind the client. " + this.f905a.g;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s extends j {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        am.b f906a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f907a;
        int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        String f908b;

        public s(am.b bVar, int i, String str, String str2) {
            super(9);
            this.f906a = bVar;
            this.b = i;
            this.f907a = str;
            this.f908b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            if (this.f906a.f934a != am.c.unbind && XMPushService.this.f875a != null) {
                try {
                    fa faVar = XMPushService.this.f875a;
                    am.b bVar = this.f906a;
                    faVar.a(bVar.g, bVar.f939b);
                } catch (fi e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f906a.a(am.c.unbind, this.b, 0, this.f908b, this.f907a);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "unbind the channel. " + this.f906a.g;
        }
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public static boolean m678e() {
        return b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        am.b f899a;

        public b(am.b bVar) {
            super(9);
            this.f899a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* JADX INFO: renamed from: a */
        public void mo403a() {
            try {
                if (XMPushService.this.m692c()) {
                    am amVarA = am.a();
                    am.b bVar = this.f899a;
                    am.b bVarA = amVarA.a(bVar.g, bVar.f939b);
                    if (bVarA == null) {
                        com.xiaomi.channel.commonutils.logger.b.m74a("ignore bind because the channel " + this.f899a.g + " is removed ");
                    } else if (bVarA.f934a == am.c.unbind) {
                        bVarA.a(am.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f875a.a(bVarA);
                        ep.a(XMPushService.this, bVarA);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m74a("trying duplicate bind, ingore! " + bVarA.f934a);
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e);
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind the client. " + this.f899a.g;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m683a() {
        if (this.c < 0) {
            this.c = com.xiaomi.push.g.a((Context) this, "com.xiaomi.xmsf");
        }
        return this.c;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private int[] m676a() {
        String[] strArrSplit;
        String strA = ah.a(getApplicationContext()).a(gk.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(strA) && (strArrSplit = strA.split(",")) != null && strArrSplit.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(strArrSplit[0]).intValue();
                int iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
                iArr[1] = iIntValue;
                int i2 = iArr[0];
                if (i2 >= 0 && i2 <= 23 && iIntValue >= 0 && iIntValue <= 23 && i2 != iIntValue) {
                    return iArr;
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private void b(boolean z) {
        this.f871a = SystemClock.elapsedRealtime();
        if (!m692c()) {
            a(true);
        } else if (com.xiaomi.push.au.m175a((Context) this)) {
            c(new o(z));
        } else {
            c(new g(17, null));
            a(true);
        }
    }

    private String a() {
        String strM648a = com.xiaomi.push.j.m648a("ro.miui.region");
        return TextUtils.isEmpty(strM648a) ? com.xiaomi.push.j.m648a("ro.product.locale.region") : strM648a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Intent intent) {
        long j2;
        er erVarA;
        String stringExtra = intent.getStringExtra(an.F);
        String stringExtra2 = intent.getStringExtra(an.J);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        am amVarA = am.a();
        if (bundleExtra != null) {
            fn fnVar = (fn) a(new fn(bundleExtra), stringExtra, stringExtra2);
            if (fnVar == null) {
                return;
            } else {
                erVarA = er.a(fnVar, amVarA.a(fnVar.k(), fnVar.m()).h);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(an.s));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(an.t);
                String stringExtra4 = intent.getStringExtra(an.u);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                am.b bVarA = amVarA.a(stringExtra5, String.valueOf(j2));
                if (bVarA != null) {
                    er erVar = new er();
                    try {
                        erVar.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    erVar.a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    erVar.a(j2, stringExtra3, stringExtra4);
                    erVar.a(intent.getStringExtra("ext_pkt_id"));
                    erVar.a(byteArrayExtra, bVarA.h);
                    com.xiaomi.channel.commonutils.logger.b.m74a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    erVarA = erVar;
                } else {
                    erVarA = null;
                }
            }
        }
        if (erVarA != null) {
            c(new aw(this, erVarA));
        }
    }

    private static void a(String str) {
        if (com.xiaomi.push.n.China.name().equals(str)) {
            cg.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            cg.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            cg.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            cg.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            cg.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            cg.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            cg.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Intent intent) {
        int i2;
        String strB;
        SharedPreferences sharedPreferences;
        am amVarA = am.a();
        boolean z = true;
        int i3 = 0;
        if (!an.d.equalsIgnoreCase(intent.getAction()) && !an.j.equalsIgnoreCase(intent.getAction())) {
            if (an.i.equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra(an.F);
                String stringExtra2 = intent.getStringExtra(an.v);
                String stringExtra3 = intent.getStringExtra(an.s);
                com.xiaomi.channel.commonutils.logger.b.m74a("Service called close channel chid = " + stringExtra2 + " res = " + am.b.a(stringExtra3));
                if (TextUtils.isEmpty(stringExtra2)) {
                    Iterator<String> it = amVarA.m718a(stringExtra).iterator();
                    while (it.hasNext()) {
                        a(it.next(), 2);
                    }
                    return;
                } else if (TextUtils.isEmpty(stringExtra3)) {
                    a(stringExtra2, 2);
                    return;
                } else {
                    a(stringExtra2, stringExtra3, 2, null, null);
                    return;
                }
            }
            if (an.e.equalsIgnoreCase(intent.getAction())) {
                b(intent);
                return;
            }
            if (an.g.equalsIgnoreCase(intent.getAction())) {
                c(intent);
                return;
            }
            if (an.f.equalsIgnoreCase(intent.getAction())) {
                fo foVarA = a(new fm(intent.getBundleExtra("ext_packet")), intent.getStringExtra(an.F), intent.getStringExtra(an.J));
                if (foVarA != null) {
                    c(new aw(this, er.a(foVarA, amVarA.a(foVarA.k(), foVarA.m()).h)));
                    return;
                }
                return;
            }
            if (an.h.equalsIgnoreCase(intent.getAction())) {
                fo foVarA2 = a(new fq(intent.getBundleExtra("ext_packet")), intent.getStringExtra(an.F), intent.getStringExtra(an.J));
                if (foVarA2 != null) {
                    c(new aw(this, er.a(foVarA2, amVarA.a(foVarA2.k(), foVarA2.m()).h)));
                    return;
                }
                return;
            }
            if (an.k.equals(intent.getAction())) {
                String stringExtra4 = intent.getStringExtra(an.v);
                String stringExtra5 = intent.getStringExtra(an.s);
                if (stringExtra4 != null) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("request reset connection from chid = " + stringExtra4);
                    am.b bVarA = am.a().a(stringExtra4, stringExtra5);
                    if (bVarA != null && bVarA.h.equals(intent.getStringExtra(an.B)) && bVarA.f934a == am.c.binded) {
                        fa faVarM684a = m684a();
                        if (faVarM684a == null || !faVarM684a.a(SystemClock.elapsedRealtime() - C.DEFAULT_SEEK_FORWARD_INCREMENT_MS)) {
                            c(new q());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            String string = null;
            bVarA = null;
            am.b bVarA2 = null;
            string = null;
            if (an.l.equals(intent.getAction())) {
                String stringExtra6 = intent.getStringExtra(an.F);
                List<String> listM718a = amVarA.m718a(stringExtra6);
                if (listM718a.isEmpty()) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("open channel should be called first before update info, pkg=" + stringExtra6);
                    return;
                }
                String stringExtra7 = intent.getStringExtra(an.v);
                String stringExtra8 = intent.getStringExtra(an.s);
                if (TextUtils.isEmpty(stringExtra7)) {
                    stringExtra7 = listM718a.get(0);
                }
                if (TextUtils.isEmpty(stringExtra8)) {
                    Collection<am.b> collectionM717a = amVarA.m717a(stringExtra7);
                    if (collectionM717a != null && !collectionM717a.isEmpty()) {
                        bVarA2 = collectionM717a.iterator().next();
                    }
                } else {
                    bVarA2 = amVarA.a(stringExtra7, stringExtra8);
                }
                if (bVarA2 != null) {
                    if (intent.hasExtra(an.D)) {
                        bVarA2.e = intent.getStringExtra(an.D);
                    }
                    if (intent.hasExtra(an.E)) {
                        bVarA2.f = intent.getStringExtra(an.E);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) && !"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                    if (ap.a(getApplicationContext()).m725a() && ap.a(getApplicationContext()).a() == 0) {
                        com.xiaomi.channel.commonutils.logger.b.m74a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                        return;
                    }
                    final byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                    final String stringExtra9 = intent.getStringExtra("mipush_app_package");
                    boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                    final int intExtra = intent.getIntExtra("mipush_env_type", 1);
                    com.xiaomi.push.service.r.a(this).d(stringExtra9);
                    if (booleanExtra && !"com.xiaomi.xmsf".equals(getPackageName())) {
                        c(new j(14) { // from class: com.xiaomi.push.service.XMPushService.2
                            @Override // com.xiaomi.push.service.XMPushService.j
                            public String a() {
                                return "clear account cache.";
                            }

                            @Override // com.xiaomi.push.service.XMPushService.j
                            /* JADX INFO: renamed from: a */
                            public void mo403a() {
                                com.xiaomi.push.service.q.m767a((Context) XMPushService.this);
                                am.a().m720a("5");
                                com.xiaomi.push.x.a(intExtra);
                                XMPushService.this.f876a.c(fb.a());
                                com.xiaomi.channel.commonutils.logger.b.m74a("clear account and start registration. " + stringExtra9);
                                XMPushService.this.a(byteArrayExtra, stringExtra9);
                            }
                        });
                        return;
                    } else {
                        a(byteArrayExtra, stringExtra9);
                        return;
                    }
                }
                if (!"com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) && !"com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    if (aq.f11729a.equals(intent.getAction())) {
                        String stringExtra10 = intent.getStringExtra("uninstall_pkg_name");
                        if (stringExtra10 == null || TextUtils.isEmpty(stringExtra10.trim())) {
                            return;
                        }
                        try {
                            PackageInfo packageInfo = getPackageManager().getPackageInfo(stringExtra10, 0);
                            if (packageInfo == null || packageInfo.applicationInfo == null || !com.xiaomi.push.i.m642a((Context) this, packageInfo.packageName)) {
                                z = false;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m74a("dual space's app uninstalled " + stringExtra10);
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        if ("com.xiaomi.channel".equals(stringExtra10) && !am.a().m717a("1").isEmpty() && z) {
                            a("1", 0);
                            com.xiaomi.channel.commonutils.logger.b.m74a("close the miliao channel as the app is uninstalled.");
                            return;
                        }
                        SharedPreferences sharedPreferences2 = getSharedPreferences("pref_registered_pkg_names", 0);
                        String string2 = sharedPreferences2.getString(stringExtra10, null);
                        if (TextUtils.isEmpty(string2) || !z) {
                            return;
                        }
                        SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
                        editorEdit.remove(stringExtra10);
                        editorEdit.commit();
                        if (x.m784b((Context) this, stringExtra10)) {
                            x.c(this, stringExtra10);
                        }
                        x.m778a((Context) this, stringExtra10);
                        ac.a(getApplicationContext(), stringExtra10);
                        if (!m692c() || string2 == null) {
                            return;
                        }
                        try {
                            w.a(this, w.a(stringExtra10, string2));
                            com.xiaomi.channel.commonutils.logger.b.m74a("uninstall " + stringExtra10 + " msg sent");
                            return;
                        } catch (fi e2) {
                            com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e2.getMessage());
                            a(10, e2);
                            return;
                        }
                    }
                    if (aq.b.equals(intent.getAction())) {
                        String stringExtra11 = intent.getStringExtra("data_cleared_pkg_name");
                        if (TextUtils.isEmpty(stringExtra11)) {
                            return;
                        }
                        try {
                            sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                            if (sharedPreferences != null) {
                                try {
                                    string = sharedPreferences.getString(stringExtra11, null);
                                } catch (Throwable th) {
                                    th = th;
                                    com.xiaomi.channel.commonutils.logger.b.m74a("Fail to get sp or appId : " + th);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            sharedPreferences = null;
                        }
                        if (!TextUtils.isEmpty(string)) {
                            SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                            editorEdit2.remove(stringExtra11);
                            editorEdit2.commit();
                            if (x.m784b((Context) this, stringExtra11)) {
                                x.c(this, stringExtra11);
                            }
                            x.m778a((Context) this, stringExtra11);
                            a(stringExtra11, hp.a(w.b(stringExtra11, string)), true);
                        }
                        ac.a((Context) this, stringExtra11);
                        if (com.xiaomi.push.j.m651a(getApplicationContext())) {
                            v.a(stringExtra11);
                            return;
                        }
                        return;
                    }
                    if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                        String stringExtra12 = intent.getStringExtra(an.F);
                        int intExtra2 = intent.getIntExtra(an.G, -2);
                        if (TextUtils.isEmpty(stringExtra12)) {
                            return;
                        }
                        if (intExtra2 >= -1) {
                            x.a(this, stringExtra12, intExtra2, intent.getIntExtra(an.H, -1));
                            return;
                        } else {
                            x.a(this, stringExtra12, intent.getStringExtra(an.L), intent.getStringExtra(an.M));
                            return;
                        }
                    }
                    if ("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION".equals(intent.getAction())) {
                        String stringExtra13 = intent.getStringExtra(an.F);
                        if (TextUtils.isEmpty(stringExtra13)) {
                            return;
                        }
                        x.m783b((Context) this, stringExtra13);
                        return;
                    }
                    if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                        String stringExtra14 = intent.getStringExtra(an.F);
                        String stringExtra15 = intent.getStringExtra(an.K);
                        if (intent.hasExtra(an.I)) {
                            int intExtra3 = intent.getIntExtra(an.I, 0);
                            strB = com.xiaomi.push.ba.b(stringExtra14 + intExtra3);
                            i3 = intExtra3;
                            z = false;
                        } else {
                            strB = com.xiaomi.push.ba.b(stringExtra14);
                        }
                        if (TextUtils.isEmpty(stringExtra14) || !TextUtils.equals(stringExtra15, strB)) {
                            com.xiaomi.channel.commonutils.logger.b.d("invalid notification for " + stringExtra14);
                            return;
                        }
                        if (z) {
                            x.c(this, stringExtra14);
                            return;
                        } else {
                            x.b(this, stringExtra14, i3);
                            return;
                        }
                    }
                    if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                        String stringExtra16 = intent.getStringExtra("mipush_app_package");
                        if (!TextUtils.isEmpty(stringExtra16)) {
                            com.xiaomi.push.service.r.a(this).b(stringExtra16);
                        }
                        if ("com.xiaomi.xmsf".equals(getPackageName())) {
                            return;
                        }
                        a(19, (Exception) null);
                        e();
                        stopSelf();
                        return;
                    }
                    if (!"com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) && !"com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                            String stringExtra17 = intent.getStringExtra("mipush_app_package");
                            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                            gj gjVar = new gj();
                            try {
                                hp.a(gjVar, byteArrayExtra2);
                                gd.a(this).a(gjVar, stringExtra17);
                                return;
                            } catch (hu e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                                return;
                            }
                        }
                        if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m74a("[Alarm] Service called on timer");
                            if (m682i()) {
                                if (dz.m395a()) {
                                    com.xiaomi.channel.commonutils.logger.b.m74a("enter falldown mode, stop alarm");
                                    dz.a();
                                }
                            } else {
                                dz.a(false);
                                if (m679f()) {
                                    b(false);
                                }
                            }
                            a aVar = this.f878a;
                            if (aVar != null) {
                                aVar.a();
                                return;
                            }
                            return;
                        }
                        if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m74a("Service called on check alive.");
                            if (m679f()) {
                                b(false);
                                return;
                            }
                            return;
                        }
                        if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                            com.xiaomi.channel.commonutils.logger.b.m74a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                            dz.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                            return;
                        }
                        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                            d();
                            return;
                        }
                        if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                            a(intent);
                            return;
                        }
                        if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(intent.getAction())) {
                            if (intent.getExtras() == null || (i2 = intent.getExtras().getInt("effectivePeriod", 0)) <= 0 || i2 > 604800) {
                                return;
                            }
                            com.xiaomi.push.service.m.a(getApplicationContext()).a(i2);
                            return;
                        }
                        if ("action_cr_config".equals(intent.getAction())) {
                            boolean booleanExtra2 = intent.getBooleanExtra("action_cr_event_switch", false);
                            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
                            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_perf_switch", false);
                            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
                            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_event_en", true);
                            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
                            Config configBuild = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra2).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra3).setPerfUploadFrequency(longExtra2).setAESKey(bl.a(getApplicationContext())).setEventEncrypted(booleanExtra4).setMaxFileLength(longExtra3).build(getApplicationContext());
                            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                                return;
                            }
                            ds.a(getApplicationContext(), configBuild);
                            return;
                        }
                        if (an.n.equals(intent.getAction())) {
                            com.xiaomi.push.service.l.a(getApplicationContext(), intent);
                            return;
                        } else {
                            if (an.o.equals(intent.getAction())) {
                                String stringExtra18 = intent.getStringExtra("ext_downward_pkt_id");
                                if (TextUtils.isEmpty(stringExtra18)) {
                                    return;
                                }
                                at.a().b(stringExtra18, intent.getLongExtra("ext_app_receive_time", 0L));
                                return;
                            }
                            return;
                        }
                    }
                    String stringExtra19 = intent.getStringExtra("mipush_app_package");
                    byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                    String stringExtra20 = intent.getStringExtra("mipush_app_id");
                    String stringExtra21 = intent.getStringExtra("mipush_app_token");
                    if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        com.xiaomi.push.service.r.a(this).c(stringExtra19);
                    }
                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        com.xiaomi.push.service.r.a(this).e(stringExtra19);
                        com.xiaomi.push.service.r.a(this).f(stringExtra19);
                    }
                    if (byteArrayExtra3 == null) {
                        com.xiaomi.push.service.t.a(this, stringExtra19, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                        return;
                    }
                    com.xiaomi.push.service.t.b(stringExtra19, byteArrayExtra3);
                    a(new com.xiaomi.push.service.s(this, stringExtra19, stringExtra20, stringExtra21, byteArrayExtra3));
                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        if (this.f879a == null) {
                            this.f879a = new f();
                            com.xiaomi.push.m.a(this, this.f879a, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE), (String) null, (Handler) null);
                        }
                        if (this.f888a == null) {
                            this.f888a = com.xiaomi.push.au.m170a((Context) this);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String stringExtra22 = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                boolean booleanExtra5 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                if (com.xiaomi.push.service.k.a(byteArrayExtra4, stringExtra22)) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("duplicate msg from: " + String.valueOf(stringExtra22));
                    return;
                }
                if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    com.xiaomi.push.service.r.a(this).a(stringExtra22);
                    if (com.xiaomi.push.j.m651a(getApplicationContext())) {
                        v.a(stringExtra22);
                    }
                }
                a(stringExtra22, byteArrayExtra4, booleanExtra5);
                return;
            }
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                if (m682i()) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m74a("exit falldown mode, activate alarm.");
                e();
                if (m692c() || m693d()) {
                    return;
                }
                a(true);
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && m682i() && dz.m395a()) {
                com.xiaomi.channel.commonutils.logger.b.m74a("enter falldown mode, stop alarm.");
                dz.a();
                return;
            }
            return;
        }
        String stringExtra23 = intent.getStringExtra(an.v);
        if (TextUtils.isEmpty(intent.getStringExtra(an.B))) {
            com.xiaomi.channel.commonutils.logger.b.m74a("security is empty. ignore.");
            return;
        }
        if (!TextUtils.isEmpty(stringExtra23)) {
            boolean zM675a = m675a(stringExtra23, intent);
            am.b bVarA3 = a(stringExtra23, intent);
            if (!com.xiaomi.push.au.b(this)) {
                this.f885a.a(this, bVarA3, false, 2, null);
                return;
            }
            if (m692c()) {
                am.c cVar = bVarA3.f934a;
                if (cVar == am.c.unbind) {
                    c(new b(bVarA3));
                    return;
                }
                if (zM675a) {
                    c(new p(bVarA3));
                    return;
                } else if (cVar == am.c.binding) {
                    com.xiaomi.channel.commonutils.logger.b.m74a(String.format("the client is binding. %1$s %2$s.", bVarA3.g, am.b.a(bVarA3.f939b)));
                    return;
                } else {
                    if (cVar == am.c.binded) {
                        this.f885a.a(this, bVarA3, true, 0, null);
                        return;
                    }
                    return;
                }
            }
            a(true);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(an.F);
        String stringExtra2 = intent.getStringExtra(an.J);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        fn[] fnVarArr = new fn[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            fn fnVar = new fn((Bundle) parcelableArrayExtra[i2]);
            fnVarArr[i2] = fnVar;
            fn fnVar2 = (fn) a(fnVar, stringExtra, stringExtra2);
            fnVarArr[i2] = fnVar2;
            if (fnVar2 == null) {
                return;
            }
        }
        am amVarA = am.a();
        er[] erVarArr = new er[length];
        for (int i3 = 0; i3 < length; i3++) {
            fn fnVar3 = fnVarArr[i3];
            erVarArr[i3] = er.a(fnVar3, amVarA.a(fnVar3.k(), fnVar3.m()).h);
        }
        c(new com.xiaomi.push.service.c(this, erVarArr));
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("digest");
        com.xiaomi.push.service.m.a(getApplicationContext()).m749a(string);
        cn.a(this, string);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m686a() {
        if (SystemClock.elapsedRealtime() - this.f871a >= fg.a() && com.xiaomi.push.au.c(this)) {
            b(true);
        }
    }

    public void a(final String str, final byte[] bArr, boolean z) {
        Collection<am.b> collectionM717a = am.a().m717a("5");
        if (collectionM717a.isEmpty()) {
            if (z) {
                com.xiaomi.push.service.t.b(str, bArr);
            }
        } else if (collectionM717a.iterator().next().f934a == am.c.binded) {
            a(new j(4) { // from class: com.xiaomi.push.service.XMPushService.3
                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "send mi push message";
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* JADX INFO: renamed from: a */
                public void mo403a() {
                    try {
                        w.a(XMPushService.this, str, bArr);
                    } catch (fi e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        XMPushService.this.a(10, e2);
                    }
                }
            });
        } else if (z) {
            com.xiaomi.push.service.t.b(str, bArr);
        }
    }

    private void c(j jVar) {
        this.f886a.a(jVar);
    }

    private void c(boolean z) {
        try {
            if (C1401r.m662a()) {
                if (z) {
                    if (com.xiaomi.push.j.m651a((Context) this)) {
                        Intent intent = new Intent("miui.intent.action.NETWORK_CONNECTED");
                        intent.addFlags(1073741824);
                        sendBroadcast(intent);
                    }
                    for (aa aaVar : (aa[]) this.f890a.toArray(new aa[0])) {
                        aaVar.mo736a();
                    }
                    return;
                }
                if (com.xiaomi.push.j.m651a((Context) this)) {
                    Intent intent2 = new Intent("miui.intent.action.NETWORK_BLOCKED");
                    intent2.addFlags(1073741824);
                    sendBroadcast(intent2);
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m74a("register request without payload");
            return;
        }
        hb hbVar = new hb();
        try {
            hp.a(hbVar, bArr);
            if (hbVar.f655a == gf.Registration) {
                hf hfVar = new hf();
                try {
                    hp.a(hfVar, hbVar.m559a());
                    a(new com.xiaomi.push.service.s(this, hbVar.b(), hfVar.b(), hfVar.c(), bArr));
                    dt.a(getApplicationContext()).a(hbVar.b(), "E100003", hfVar.a(), 6002, null);
                } catch (hu e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m74a("register request with invalid payload");
            }
        } catch (hu e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m691b() {
        try {
            Class<?> clsA = C1401r.a(this, "miui.os.Build");
            Field field = clsA.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = clsA.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = clsA.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public com.xiaomi.push.service.h m689b() {
        return this.f885a;
    }

    public void b(j jVar) {
        this.f886a.a(jVar.f11761a, jVar);
    }

    @Override // com.xiaomi.push.fd
    public void b(fa faVar) {
        eo.a().b(faVar);
        c(true);
        this.f884a.m727a();
        if (!dz.m395a() && !m682i()) {
            com.xiaomi.channel.commonutils.logger.b.m74a("reconnection successful, reactivate alarm.");
            dz.a(true);
        }
        Iterator<am.b> it = am.a().m716a().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f891a || !com.xiaomi.push.j.m651a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.ae.a(getApplicationContext()).a(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.6
            @Override // java.lang.Runnable
            public void run() {
                XMPushService.this.f891a = true;
                try {
                    com.xiaomi.channel.commonutils.logger.b.m74a("try to trigger the wifi digest broadcast.");
                    Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                    if (systemService != null) {
                        com.xiaomi.push.aw.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m692c() {
        fa faVar = this.f875a;
        return faVar != null && faVar.m443c();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m690b() {
        com.xiaomi.push.service.m.a(getApplicationContext()).m753d();
        Iterator it = new ArrayList(this.f889a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).mo482a();
        }
    }

    private fo a(fo foVar, String str, String str2) {
        am amVarA = am.a();
        List<String> listM718a = amVarA.m718a(str);
        if (listM718a.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.m74a("open channel should be called first before sending a packet, pkg=" + str);
            return null;
        }
        foVar.o(str);
        String strK = foVar.k();
        if (TextUtils.isEmpty(strK)) {
            strK = listM718a.get(0);
            foVar.l(strK);
        }
        am.b bVarA = amVarA.a(strK, foVar.m());
        if (!m692c()) {
            com.xiaomi.channel.commonutils.logger.b.m74a("drop a packet as the channel is not connected, chid=" + strK);
            return null;
        }
        if (bVarA != null && bVarA.f934a == am.c.binded) {
            if (TextUtils.equals(str2, bVarA.i)) {
                return foVar;
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("invalid session. " + str2);
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("drop a packet as the channel is not opened, chid=" + strK);
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m675a(String str, Intent intent) {
        am.b bVarA = am.a().a(str, intent.getStringExtra(an.s));
        boolean z = false;
        if (bVarA == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(an.J);
        String stringExtra2 = intent.getStringExtra(an.B);
        if (!TextUtils.isEmpty(bVarA.i) && !TextUtils.equals(stringExtra, bVarA.i)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("session changed. old session=" + bVarA.i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(bVarA.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.ba.a(stringExtra2));
        return true;
    }

    private am.b a(String str, Intent intent) {
        am.b bVarA = am.a().a(str, intent.getStringExtra(an.s));
        if (bVarA == null) {
            bVarA = new am.b(this);
        }
        bVarA.g = intent.getStringExtra(an.v);
        bVarA.f939b = intent.getStringExtra(an.s);
        bVarA.c = intent.getStringExtra(an.z);
        bVarA.f936a = intent.getStringExtra(an.F);
        bVarA.e = intent.getStringExtra(an.D);
        bVarA.f = intent.getStringExtra(an.E);
        bVarA.f938a = intent.getBooleanExtra(an.C, false);
        bVarA.h = intent.getStringExtra(an.B);
        bVarA.i = intent.getStringExtra(an.J);
        bVarA.d = intent.getStringExtra(an.A);
        bVarA.f935a = this.f885a;
        bVarA.a((Messenger) intent.getParcelableExtra(an.N));
        bVarA.f928a = getApplicationContext();
        am.a().a(bVarA);
        return bVarA;
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        am.b bVarA = am.a().a(str, str2);
        if (bVarA != null) {
            a(new s(bVarA, i2, str4, str3));
        }
        am.a().m721a(str, str2);
    }

    private void a(String str, int i2) {
        Collection<am.b> collectionM717a = am.a().m717a(str);
        if (collectionM717a != null) {
            for (am.b bVar : collectionM717a) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        am.a().m720a(str);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j2) {
        try {
            this.f886a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m74a("can't execute job err = " + e2.getMessage());
        }
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    public void a(er erVar) throws fi {
        fa faVar = this.f875a;
        if (faVar != null) {
            faVar.b(erVar);
            return;
        }
        throw new fi("try send msg while connection is null.");
    }

    public void a(er[] erVarArr) throws fi {
        fa faVar = this.f875a;
        if (faVar != null) {
            faVar.a(erVarArr);
            return;
        }
        throw new fi("try send msg while connection is null.");
    }

    public void a(boolean z) {
        this.f884a.a(z);
    }

    public void a(am.b bVar) {
        if (bVar != null) {
            long jA = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m74a("schedule rebind job in " + (jA / 1000));
            a(new b(bVar), jA);
        }
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        fa faVar = this.f875a;
        sb.append(faVar == null ? null : Integer.valueOf(faVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m74a(sb.toString());
        fa faVar2 = this.f875a;
        if (faVar2 != null) {
            faVar2.b(i2, exc);
            this.f875a = null;
        }
        a(7);
        a(4);
        am.a().a(this, i2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m687a() {
        boolean zM175a = com.xiaomi.push.au.m175a((Context) this);
        boolean z = am.a().m715a() > 0;
        boolean z2 = !m691b();
        boolean zM681h = m681h();
        boolean z3 = !m680g();
        boolean z4 = zM175a && z && z2 && zM681h && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(zM175a), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(zM681h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public com.xiaomi.push.service.h m685a() {
        return new com.xiaomi.push.service.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            com.xiaomi.push.ag.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.au.b(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public fa m684a() {
        return this.f875a;
    }

    public void a(int i2) {
        this.f886a.a(i2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m688a(int i2) {
        return this.f886a.m756a(i2);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        eo.a().a(faVar);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, int i2, Exception exc) {
        eo.a().a(faVar, i2, exc);
        if (m682i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, Exception exc) {
        eo.a().a(faVar, exc);
        c(false);
        if (m682i()) {
            return;
        }
        a(false);
    }

    public void a(n nVar) {
        synchronized (this.f889a) {
            this.f889a.add(nVar);
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m693d() {
        fa faVar = this.f875a;
        return faVar != null && faVar.m442b();
    }
}
