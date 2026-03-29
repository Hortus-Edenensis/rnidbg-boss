package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class fh extends fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Exception f11568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Socket f452a;
    protected XMPushService b;
    private int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    String f453c;
    private String d;
    protected volatile long e;
    protected volatile long f;
    protected volatile long g;
    private long h;

    public fh(XMPushService xMPushService, fb fbVar) {
        super(xMPushService, fbVar);
        this.f11568a = null;
        this.f453c = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.b = xMPushService;
    }

    public Context a() {
        return this.b;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo430a(boolean z);

    @Override // com.xiaomi.push.fa
    public void b(boolean z) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        mo430a(z);
        com.xiaomi.push.service.m.a(this.b).m752c();
        if (z) {
            return;
        }
        this.b.a(new XMPushService.j(13) { // from class: com.xiaomi.push.fh.1
            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                Thread.yield();
                if (!fh.this.m443c() || fh.this.a(jElapsedRealtime)) {
                    return;
                }
                com.xiaomi.push.service.m.a(fh.this.b).m751b();
                fh.this.b.a(22, (Exception) null);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "check the ping-pong." + jCurrentTimeMillis;
            }
        }, 10000L);
    }

    public String c() {
        return ((fa) this).f438a;
    }

    public synchronized void e() {
        try {
            if (!m443c() && !m442b()) {
                a(0, 0, (Exception) null);
                a(((fa) this).f435a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m74a("WARNING: current xmpp has connected");
        } catch (IOException e) {
            throw new fi(e);
        }
    }

    public void f() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }

    @Override // com.xiaomi.push.fa
    /* JADX INFO: renamed from: a */
    public String mo438a() {
        return this.d;
    }

    public void c(final int i, final Exception exc) {
        au.b();
        this.b.a(new XMPushService.j(2) { // from class: com.xiaomi.push.fh.2
            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                fh.this.b.a(i, exc);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "shutdown the connection. " + i + ", " + exc;
            }
        });
    }

    public synchronized void a(int i, Exception exc) {
        if (b() == 2) {
            return;
        }
        a(2, i, exc);
        ((fa) this).f438a = "";
        try {
            this.f452a.close();
        } catch (Throwable unused) {
        }
        this.e = 0L;
        this.f = 0L;
    }

    @Override // com.xiaomi.push.fa
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    public void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g < 300000) {
            if (au.m175a((Context) this.b)) {
                int i = this.c + 1;
                this.c = i;
                if (i >= 2) {
                    String strMo438a = mo438a();
                    com.xiaomi.channel.commonutils.logger.b.m74a("max short conn time reached, sink down current host:" + strMo438a);
                    a(strMo438a, 0L, exc);
                    this.c = 0;
                    return;
                }
                return;
            }
            return;
        }
        this.c = 0;
    }

    public void a(String str, long j, Exception exc) {
        cc ccVarA = cg.a().a(fb.a(), false);
        if (ccVarA != null) {
            ccVarA.b(str, j, 0L, exc);
            cg.a().m260c();
        }
    }

    @Override // com.xiaomi.push.fa
    public void a(er[] erVarArr) throws fi {
        throw new fi("Don't support send Blob");
    }

    private void a(fb fbVar) throws Throwable {
        a(fbVar.c(), fbVar.m444a());
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0348  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i) throws Throwable {
        StringBuilder sb;
        long j;
        int i2;
        String str2;
        boolean z;
        Iterator<String> it;
        String str3;
        cc ccVar;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        this.f11568a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int iIntValue = com.xiaomi.channel.commonutils.logger.b.a("get bucket for host : " + str).intValue();
        cc ccVarA = a(str);
        com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(iIntValue));
        if (ccVarA != null) {
            arrayList = ccVarA.a(true);
        }
        cc ccVarD = cg.a().d(str);
        if (ccVarD != null) {
            for (String str9 : ccVarD.a(true)) {
                if (arrayList.indexOf(str9) == -1) {
                    arrayList.add(str9);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        long j2 = 0;
        this.g = 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strM171a = au.m171a((Context) this.b);
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it2 = arrayList.iterator();
        String str10 = "";
        int i3 = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ((fa) this).f433a++;
            int i4 = i3 + 1;
            try {
                try {
                    try {
                        com.xiaomi.channel.commonutils.logger.b.m74a("begin to connect to " + next);
                        this.f452a = m449a();
                        this.f452a.connect(ce.m249a(next, i), 8000);
                        com.xiaomi.channel.commonutils.logger.b.m74a("tcp connected");
                        this.f452a.setTcpNoDelay(true);
                        this.d = next;
                        mo450a();
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        ((fa) this).f434a = jCurrentTimeMillis2;
                        ((fa) this).f443b = strM171a;
                        if (ccVarA != null) {
                            it = it2;
                            sb = sb2;
                            str3 = strM171a;
                            j = 0;
                            ccVar = ccVarA;
                            try {
                                ccVarA.b(next, jCurrentTimeMillis2, 0L);
                            } catch (Exception e) {
                                e = e;
                                str4 = str10;
                                str5 = str3;
                                try {
                                    this.f11568a = e;
                                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                                    sb.append("SMACK: Could not connect to ");
                                    sb.append(next);
                                    sb.append(" port:");
                                    sb.append(i);
                                    sb.append(" err:");
                                    sb.append(this.f11568a.getClass().getSimpleName());
                                    sb.append("\n");
                                    str2 = TextUtils.isEmpty(str4) ? next : str4 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + next;
                                    ep.a(next, this.f11568a);
                                    if (ccVar != null) {
                                        str7 = str5;
                                        ccVar.b(next, System.currentTimeMillis() - jCurrentTimeMillis, 0L, this.f11568a);
                                    } else {
                                        str7 = str5;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                                    sb.append("SMACK: Could not connect to ");
                                    sb.append(next);
                                    sb.append(" port:");
                                    sb.append(i);
                                    sb.append(" err:");
                                    sb.append(this.f11568a.getClass().getSimpleName());
                                    sb.append("\n");
                                    if (TextUtils.isEmpty(str4)) {
                                    }
                                    ep.a(next, this.f11568a);
                                    if (ccVar == null) {
                                    }
                                    if (!TextUtils.equals(str8, au.m171a((Context) this.b))) {
                                    }
                                }
                                if (TextUtils.equals(str7, au.m171a((Context) this.b))) {
                                    str10 = str2;
                                    sb2 = sb;
                                    strM171a = str7;
                                    i3 = i4;
                                    it2 = it;
                                    j2 = j;
                                    ccVarA = ccVar;
                                } else {
                                    i2 = i4;
                                    z = false;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    this.f11568a = new Exception("abnormal exception", th);
                                    com.xiaomi.channel.commonutils.logger.b.a(th);
                                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                                    sb.append("SMACK: Could not connect to ");
                                    sb.append(next);
                                    sb.append(" port:");
                                    sb.append(i);
                                    sb.append(" err:");
                                    sb.append(this.f11568a.getClass().getSimpleName());
                                    sb.append("\n");
                                    str2 = TextUtils.isEmpty(str10) ? next : str10 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + next;
                                    ep.a(next, this.f11568a);
                                    if (ccVar != null) {
                                        ccVar.b(next, System.currentTimeMillis() - jCurrentTimeMillis, 0L, this.f11568a);
                                    }
                                    str6 = str3;
                                } catch (Throwable th3) {
                                    th = th3;
                                    str4 = str10;
                                    str5 = str3;
                                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                                    sb.append("SMACK: Could not connect to ");
                                    sb.append(next);
                                    sb.append(" port:");
                                    sb.append(i);
                                    sb.append(" err:");
                                    sb.append(this.f11568a.getClass().getSimpleName());
                                    sb.append("\n");
                                    String str11 = TextUtils.isEmpty(str4) ? str4 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + next : next;
                                    ep.a(next, this.f11568a);
                                    if (ccVar == null) {
                                        str8 = str5;
                                        ccVar.b(next, System.currentTimeMillis() - jCurrentTimeMillis, 0L, this.f11568a);
                                    } else {
                                        str8 = str5;
                                    }
                                    if (!TextUtils.equals(str8, au.m171a((Context) this.b))) {
                                        throw th;
                                    }
                                    str2 = str11;
                                    i2 = i4;
                                    z = false;
                                    cg.a().m260c();
                                    int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - jElapsedRealtime);
                                    if (z) {
                                    }
                                }
                                if (TextUtils.equals(str6, au.m171a((Context) this.b))) {
                                    str7 = str6;
                                    str10 = str2;
                                    sb2 = sb;
                                    strM171a = str7;
                                    i3 = i4;
                                    it2 = it;
                                    j2 = j;
                                    ccVarA = ccVar;
                                } else {
                                    i2 = i4;
                                    z = false;
                                }
                            }
                        } else {
                            it = it2;
                            sb = sb2;
                            str3 = strM171a;
                            ccVar = ccVarA;
                            j = 0;
                        }
                        this.g = SystemClock.elapsedRealtime();
                        com.xiaomi.channel.commonutils.logger.b.m74a("connected to " + next + " in " + ((fa) this).f434a);
                        str2 = str10;
                        i2 = i4;
                        z = true;
                        break;
                    } catch (Exception e2) {
                        e = e2;
                        it = it2;
                        sb = sb2;
                        str3 = strM171a;
                        ccVar = ccVarA;
                        j = 0;
                    }
                } catch (Exception e3) {
                    e = e3;
                    it = it2;
                    sb = sb2;
                    ccVar = ccVarA;
                    j = 0;
                    str4 = str10;
                    str5 = strM171a;
                }
            } catch (Throwable th4) {
                th = th4;
                it = it2;
                sb = sb2;
                str3 = strM171a;
                ccVar = ccVarA;
                j = 0;
            }
        }
        sb = sb2;
        j = j2;
        i2 = i3;
        str2 = str10;
        z = false;
        cg.a().m260c();
        int iElapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - jElapsedRealtime);
        if (z) {
            if (this.h == j || SystemClock.elapsedRealtime() - this.h > 480000) {
                this.h = SystemClock.elapsedRealtime();
                ep.a(0, ei.BATCH_TCP_CONN_FAIL.a(), iElapsedRealtime2, str2, au.b(this.b.getApplicationContext()) ? 1 : 0);
            }
            throw new fi(sb.toString());
        }
        ep.a(0, ei.BATCH_TCP_CONN_SUCCESS.a(), iElapsedRealtime2, str2, i2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void mo450a() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Socket m449a() {
        return new Socket();
    }

    public cc a(final String str) {
        cc ccVarA = cg.a().a(str, false);
        if (!ccVarA.b()) {
            fy.a(new Runnable() { // from class: com.xiaomi.push.fh.3
                @Override // java.lang.Runnable
                public void run() {
                    cg.a().a(str, true);
                }
            });
        }
        return ccVarA;
    }
}
