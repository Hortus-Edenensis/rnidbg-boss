package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class en implements fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    fa f389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    XMPushService f390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Exception f391a;
    private long e;
    private long f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f388a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f392a = "";

    public en(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f390a = xMPushService;
        b();
        int iMyUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(iMyUid);
            this.e = TrafficStats.getUidTxBytes(iMyUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f388a = 0L;
        this.c = 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (au.m175a((Context) this.f390a)) {
            this.f388a = jElapsedRealtime;
        }
        if (this.f390a.m692c()) {
            this.c = jElapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f392a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        ej ejVar = new ej();
        ejVar.f367a = (byte) 0;
        ejVar.a(ei.CHANNEL_ONLINE_RATE.a());
        ejVar.a(this.f392a);
        ejVar.d((int) (System.currentTimeMillis() / 1000));
        ejVar.b((int) (this.b / 1000));
        ejVar.c((int) (this.d / 1000));
        eo.m406a().a(ejVar);
        b();
    }

    public Exception a() {
        return this.f391a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m405a() {
        XMPushService xMPushService = this.f390a;
        if (xMPushService == null) {
            return;
        }
        String strM171a = au.m171a((Context) xMPushService);
        boolean zB = au.b(this.f390a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f388a;
        if (j > 0) {
            this.b += jElapsedRealtime - j;
            this.f388a = 0L;
        }
        long j2 = this.c;
        if (j2 != 0) {
            this.d += jElapsedRealtime - j2;
            this.c = 0L;
        }
        if (zB) {
            if ((!TextUtils.equals(this.f392a, strM171a) && this.b > 30000) || this.b > 5400000) {
                c();
            }
            this.f392a = strM171a;
            if (this.f388a == 0) {
                this.f388a = jElapsedRealtime;
            }
            if (this.f390a.m692c()) {
                this.c = jElapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fd
    public void b(fa faVar) {
        m405a();
        this.c = SystemClock.elapsedRealtime();
        ep.a(0, ei.CONN_SUCCESS.a(), faVar.mo438a(), faVar.a());
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar) {
        this.f11545a = 0;
        this.f391a = null;
        this.f389a = faVar;
        this.f392a = au.m171a((Context) this.f390a);
        ep.a(0, ei.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, int i, Exception exc) {
        long uidRxBytes;
        long uidTxBytes;
        if (this.f11545a == 0 && this.f391a == null) {
            this.f11545a = i;
            this.f391a = exc;
            ep.b(faVar.mo438a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long jM436a = faVar.m436a() - this.c;
            if (jM436a < 0) {
                jM436a = 0;
            }
            this.d += jM436a + ((long) (fg.b() / 2));
            this.c = 0L;
        }
        m405a();
        int iMyUid = Process.myUid();
        try {
            uidRxBytes = TrafficStats.getUidRxBytes(iMyUid);
            uidTxBytes = TrafficStats.getUidTxBytes(iMyUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Failed to obtain traffic data: " + e);
            uidRxBytes = -1;
            uidTxBytes = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (uidRxBytes - this.f) + ", tx=" + (uidTxBytes - this.e));
        this.f = uidRxBytes;
        this.e = uidTxBytes;
    }

    @Override // com.xiaomi.push.fd
    public void a(fa faVar, Exception exc) {
        ep.a(0, ei.CHANNEL_CON_FAIL.a(), 1, faVar.mo438a(), au.b(this.f390a) ? 1 : 0);
        m405a();
    }
}
