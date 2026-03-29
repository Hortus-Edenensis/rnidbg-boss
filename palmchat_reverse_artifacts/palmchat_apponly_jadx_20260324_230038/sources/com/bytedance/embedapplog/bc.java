package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class bc {
    private static final AtomicLong iz = new AtomicLong(1000);
    private static u k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5058a = -1;
    private sf b;
    private sf fx;
    private volatile boolean jk;
    private int l;
    private String mv;
    private int n;
    private final yd nr;
    private String pn;
    private dc s;
    private long t;
    private final mh u;
    private long x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends i {
        private u() {
        }
    }

    public bc(yd ydVar, mh mhVar) {
        this.nr = ydVar;
        this.u = mhVar;
    }

    public static long b() {
        return iz.incrementAndGet();
    }

    public static u pn() {
        if (k == null) {
            k = new u();
        }
        k.nr = System.currentTimeMillis();
        return k;
    }

    public boolean fx() {
        return nr() && this.t == 0;
    }

    public boolean nr() {
        return this.jk;
    }

    public String u() {
        return this.pn;
    }

    public void nr(ju juVar) {
        if (juVar != null) {
            if (this.u.c()) {
                juVar.n = com.bytedance.embedapplog.u.pn();
            }
            juVar.iz = com.bytedance.embedapplog.u.t();
            juVar.x = com.bytedance.embedapplog.u.jk();
            juVar.b = this.pn;
            juVar.fx = b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bundle u(long j, long j2) {
        Bundle bundle;
        if (this.u.iz() && fx()) {
            long j3 = this.x;
            if (j3 > 0 && j - j3 > j2) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.l);
                int i = this.n + 1;
                this.n = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", (j - this.x) / 1000);
                bundle.putString(com.umeng.analytics.pro.w.f10982a, ju.nr(this.f5058a));
                this.x = j;
            }
        } else {
            bundle = null;
        }
        return bundle;
    }

    private synchronized void u(ju juVar, ArrayList<ju> arrayList, boolean z) {
        long j = juVar instanceof u ? -1L : juVar.nr;
        this.pn = UUID.randomUUID().toString();
        iz.set(1000L);
        this.f5058a = j;
        this.jk = z;
        this.t = 0L;
        this.x = 0L;
        if (ti.nr) {
            ti.u("startSession, " + this.pn + ", hadUi:" + z + " data:" + juVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(calendar.get(1));
            sb.append(calendar.get(2));
            sb.append(calendar.get(5));
            String string = sb.toString();
            if (TextUtils.isEmpty(this.mv)) {
                this.mv = this.u.fx();
                this.l = this.u.b();
            }
            if (!string.equals(this.mv)) {
                this.mv = string;
                this.l = 1;
            } else {
                this.l++;
            }
            this.u.u(string, this.l);
            this.n = 0;
            this.x = juVar.nr;
        }
        if (j != -1) {
            dc dcVar = new dc(false);
            dcVar.b = this.pn;
            dcVar.fx = b();
            dcVar.nr = this.f5058a;
            dcVar.s = this.jk ? false : true;
            dcVar.mv = this.nr.fx();
            dcVar.l = this.nr.nr();
            dcVar.iz = com.bytedance.embedapplog.u.t();
            dcVar.x = com.bytedance.embedapplog.u.jk();
            if (this.u.c()) {
                dcVar.n = com.bytedance.embedapplog.u.pn();
            }
            arrayList.add(dcVar);
            this.s = dcVar;
            if (ti.nr) {
                ti.u("gen launch, " + dcVar.b + ", hadUi:" + z, null);
            }
        }
    }

    public static boolean u(ju juVar) {
        if (juVar instanceof sf) {
            return ((sf) juVar).jk();
        }
        return false;
    }

    public boolean u(ju juVar, ArrayList<ju> arrayList) {
        boolean z = juVar instanceof sf;
        boolean zU = u(juVar);
        boolean z2 = true;
        if (this.f5058a == -1) {
            u(juVar, arrayList, u(juVar));
        } else if (!this.jk && zU) {
            u(juVar, arrayList, true);
        } else {
            long j = this.t;
            if (j == 0 || juVar.nr <= j + this.u.qq()) {
                if (this.f5058a > juVar.nr + com.heytap.mcssdk.constant.a.n) {
                    u(juVar, arrayList, zU);
                } else {
                    z2 = false;
                }
            } else if (!gb.nr() && gb.u()) {
                u(juVar, arrayList, zU);
            }
        }
        if (z) {
            sf sfVar = (sf) juVar;
            if (sfVar.jk()) {
                this.t = 0L;
                arrayList.add(juVar);
                if (TextUtils.isEmpty(sfVar.mv)) {
                    sf sfVar2 = this.b;
                    if (sfVar2 != null && (sfVar.nr - sfVar2.nr) - sfVar2.l < 500) {
                        sfVar.mv = sfVar2.s;
                    } else {
                        sf sfVar3 = this.fx;
                        if (sfVar3 != null && (sfVar.nr - sfVar3.nr) - sfVar3.l < 500) {
                            sfVar.mv = sfVar3.s;
                        }
                    }
                }
            } else {
                Bundle bundleU = u(juVar.nr, 0L);
                if (bundleU != null) {
                    com.bytedance.embedapplog.u.u("play_session", bundleU);
                }
                this.t = sfVar.nr;
                arrayList.add(juVar);
                if (sfVar.t()) {
                    this.fx = sfVar;
                } else {
                    this.b = sfVar;
                    this.fx = null;
                }
            }
        } else if (!(juVar instanceof u)) {
            arrayList.add(juVar);
        }
        nr(juVar);
        return z2;
    }
}
