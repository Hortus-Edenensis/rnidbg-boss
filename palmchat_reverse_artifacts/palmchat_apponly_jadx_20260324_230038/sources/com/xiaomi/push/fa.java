package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f11564a = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected fb f435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected XMPushService f437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected int f433a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected long f434a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected volatile long f442b = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    protected volatile long f445c = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f440a = new LinkedList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Collection<fd> f439a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected final Map<ff, a> f441a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected final Map<ff, a> f444b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected fj f436a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected String f438a = "";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected String f443b = "";
    private int c = 2;
    protected final int b = f11564a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    static {
        f432a = false;
        try {
            f432a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fg.m447a();
    }

    public fa(XMPushService xMPushService, fb fbVar) {
        this.f435a = fbVar;
        this.f437a = xMPushService;
        m441b();
    }

    private String a(int i) {
        return i == 1 ? com.huawei.openalliance.ad.constant.x.bq : i == 0 ? "connecting" : i == 2 ? NetworkUtil.NETWORK_CLASS_DISCONNECTED : "unknown";
    }

    public abstract void a(fo foVar);

    public abstract void a(am.b bVar);

    public abstract void a(String str, String str2);

    public abstract void a(er[] erVarArr);

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m440b() {
        return this.f435a.b();
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(er erVar);

    public abstract void b(boolean z);

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m443c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f440a) {
            this.f440a.clear();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ff f11565a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private fk f446a;

        public a(ff ffVar, fk fkVar) {
            this.f11565a = ffVar;
            this.f446a = fkVar;
        }

        public void a(fo foVar) {
            fk fkVar = this.f446a;
            if (fkVar == null || fkVar.mo264a(foVar)) {
                this.f11565a.a(foVar);
            }
        }

        public void a(er erVar) {
            this.f11565a.a(erVar);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean mo431a() {
        return false;
    }

    public void b(fd fdVar) {
        this.f439a.remove(fdVar);
    }

    public synchronized void c() {
        this.e = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public fb m437a() {
        return this.f435a;
    }

    public void b(ff ffVar, fk fkVar) {
        if (ffVar != null) {
            this.f444b.put(ffVar, new a(ffVar, fkVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo438a() {
        return this.f435a.c();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m436a() {
        return this.f445c;
    }

    public void a(fd fdVar) {
        if (fdVar == null || this.f439a.contains(fdVar)) {
            return;
        }
        this.f439a.add(fdVar);
    }

    public void b(ff ffVar) {
        this.f444b.remove(ffVar);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m441b() {
        String property;
        if (this.f435a.m445a() && this.f436a == null) {
            Class<?> cls = null;
            try {
                property = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                property = null;
            }
            if (property != null) {
                try {
                    cls = Class.forName(property);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cls == null) {
                this.f436a = new ez(this);
                return;
            }
            try {
                this.f436a = (fj) cls.getConstructor(fa.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public void a(ff ffVar, fk fkVar) {
        if (ffVar != null) {
            this.f441a.put(ffVar, new a(ffVar, fkVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public void a(ff ffVar) {
        this.f441a.remove(ffVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<ff, a> m439a() {
        return this.f441a;
    }

    public int a() {
        return this.f433a;
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.c;
        if (i != i3) {
            com.xiaomi.channel.commonutils.logger.b.m74a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.an.a(i2)));
        }
        if (au.m175a((Context) this.f437a)) {
            m435a(i);
        }
        if (i == 1) {
            this.f437a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m74a("try set connected while not connecting.");
            }
            this.c = i;
            Iterator<fd> it = this.f439a.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            return;
        }
        if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m74a("try set connecting while not disconnected.");
            }
            this.c = i;
            Iterator<fd> it2 = this.f439a.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
            return;
        }
        if (i == 2) {
            this.f437a.a(10);
            int i4 = this.c;
            if (i4 == 0) {
                Iterator<fd> it3 = this.f439a.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                Iterator<fd> it4 = this.f439a.iterator();
                while (it4.hasNext()) {
                    it4.next().a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m442b() {
        return this.c == 0;
    }

    public int b() {
        return this.c;
    }

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m74a("setChallenge hash = " + ba.a(str).substring(0, 8));
            this.f438a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m74a("ignore setChallenge because connection was disconnected");
        }
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m435a(int i) {
        synchronized (this.f440a) {
            if (i == 1) {
                this.f440a.clear();
            } else {
                this.f440a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f440a.size() > 6) {
                    this.f440a.remove(0);
                }
            }
        }
    }
}
