package com.oplus.log.core;

import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.log.core.e;
import defpackage.gw6;
import defpackage.hw6;
import defpackage.k17;
import defpackage.kh7;
import defpackage.o17;
import defpackage.ve7;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d extends Thread {
    public boolean e;
    public File f;
    public boolean g;
    public long h;
    public c i;
    public ConcurrentLinkedQueue<e> j;
    public String k;
    public String l;
    public String m;
    public long n;
    public long o;
    public long p;
    public String q;
    public String r;
    public ve7 t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7569a = new Object();
    public final Object b = new Object();
    public volatile boolean d = true;
    public ConcurrentLinkedQueue<e> s = new ConcurrentLinkedQueue<>();
    public final hw6 c = new hw6();
    public final gw6 u = new gw6();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ve7 {
        public a() {
        }

        @Override // defpackage.ve7
        public final void a(String str, int i) {
            if (d.this.t != null) {
                d.this.t.a(str, i);
            }
        }
    }

    public d(ConcurrentLinkedQueue<e> concurrentLinkedQueue, String str, String str2, long j, long j2, long j3, String str3, String str4, String str5) {
        this.j = concurrentLinkedQueue;
        this.k = str;
        this.l = str2;
        this.m = str5;
        this.n = j;
        this.o = j2;
        this.p = j3;
        this.q = str3;
        this.r = str4;
    }

    public final void b() {
        if (this.e) {
            return;
        }
        synchronized (this.f7569a) {
            this.f7569a.notify();
        }
    }

    public final void c(long j) {
        File[] fileArrListFiles;
        File file = new File(this.l);
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null) {
                try {
                    if (file2.lastModified() <= j) {
                        file2.delete();
                    }
                } catch (Exception e) {
                    if (k17.k()) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public final void d() {
        if (com.oplus.log.core.a.b) {
            Log.d("LoganThread", "Logan flush start");
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.logan_flush();
        }
    }

    public final boolean e() {
        try {
            StatFs statFs = new StatFs(this.l);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > this.p;
        } catch (IllegalArgumentException e) {
            if (!k17.k()) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048 A[Catch: InterruptedException -> 0x0195, all -> 0x01a4, TryCatch #0 {InterruptedException -> 0x0195, blocks: (B:10:0x000e, B:12:0x0018, B:13:0x0023, B:15:0x0027, B:17:0x002d, B:19:0x0031, B:28:0x0048, B:30:0x004c, B:31:0x0072, B:33:0x0078, B:35:0x007e, B:36:0x0085, B:38:0x0089, B:39:0x0092, B:41:0x00a3, B:43:0x00af, B:45:0x00bc, B:53:0x00d5, B:55:0x00f1, B:57:0x00fc, B:58:0x0101, B:60:0x010f, B:61:0x0127, B:62:0x0141, B:64:0x014f, B:65:0x015b, B:67:0x015f, B:69:0x0163, B:70:0x016f, B:51:0x00d1, B:71:0x0180, B:73:0x0184, B:75:0x0188, B:77:0x018f, B:22:0x003b), top: B:92:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d1 A[Catch: InterruptedException -> 0x0195, all -> 0x01a4, TryCatch #0 {InterruptedException -> 0x0195, blocks: (B:10:0x000e, B:12:0x0018, B:13:0x0023, B:15:0x0027, B:17:0x002d, B:19:0x0031, B:28:0x0048, B:30:0x004c, B:31:0x0072, B:33:0x0078, B:35:0x007e, B:36:0x0085, B:38:0x0089, B:39:0x0092, B:41:0x00a3, B:43:0x00af, B:45:0x00bc, B:53:0x00d5, B:55:0x00f1, B:57:0x00fc, B:58:0x0101, B:60:0x010f, B:61:0x0127, B:62:0x0141, B:64:0x014f, B:65:0x015b, B:67:0x015f, B:69:0x0163, B:70:0x016f, B:51:0x00d1, B:71:0x0180, B:73:0x0184, B:75:0x0188, B:77:0x018f, B:22:0x003b), top: B:92:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d5 A[Catch: InterruptedException -> 0x0195, all -> 0x01a4, TryCatch #0 {InterruptedException -> 0x0195, blocks: (B:10:0x000e, B:12:0x0018, B:13:0x0023, B:15:0x0027, B:17:0x002d, B:19:0x0031, B:28:0x0048, B:30:0x004c, B:31:0x0072, B:33:0x0078, B:35:0x007e, B:36:0x0085, B:38:0x0089, B:39:0x0092, B:41:0x00a3, B:43:0x00af, B:45:0x00bc, B:53:0x00d5, B:55:0x00f1, B:57:0x00fc, B:58:0x0101, B:60:0x010f, B:61:0x0127, B:62:0x0141, B:64:0x014f, B:65:0x015b, B:67:0x015f, B:69:0x0163, B:70:0x016f, B:51:0x00d1, B:71:0x0180, B:73:0x0184, B:75:0x0188, B:77:0x018f, B:22:0x003b), top: B:92:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014f A[Catch: InterruptedException -> 0x0195, all -> 0x01a4, TryCatch #0 {InterruptedException -> 0x0195, blocks: (B:10:0x000e, B:12:0x0018, B:13:0x0023, B:15:0x0027, B:17:0x002d, B:19:0x0031, B:28:0x0048, B:30:0x004c, B:31:0x0072, B:33:0x0078, B:35:0x007e, B:36:0x0085, B:38:0x0089, B:39:0x0092, B:41:0x00a3, B:43:0x00af, B:45:0x00bc, B:53:0x00d5, B:55:0x00f1, B:57:0x00fc, B:58:0x0101, B:60:0x010f, B:61:0x0127, B:62:0x0141, B:64:0x014f, B:65:0x015b, B:67:0x015f, B:69:0x0163, B:70:0x016f, B:51:0x00d1, B:71:0x0180, B:73:0x0184, B:75:0x0188, B:77:0x018f, B:22:0x003b), top: B:92:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015f A[Catch: InterruptedException -> 0x0195, all -> 0x01a4, TryCatch #0 {InterruptedException -> 0x0195, blocks: (B:10:0x000e, B:12:0x0018, B:13:0x0023, B:15:0x0027, B:17:0x002d, B:19:0x0031, B:28:0x0048, B:30:0x004c, B:31:0x0072, B:33:0x0078, B:35:0x007e, B:36:0x0085, B:38:0x0089, B:39:0x0092, B:41:0x00a3, B:43:0x00af, B:45:0x00bc, B:53:0x00d5, B:55:0x00f1, B:57:0x00fc, B:58:0x0101, B:60:0x010f, B:61:0x0127, B:62:0x0141, B:64:0x014f, B:65:0x015b, B:67:0x015f, B:69:0x0163, B:70:0x016f, B:51:0x00d1, B:71:0x0180, B:73:0x0184, B:75:0x0188, B:77:0x018f, B:22:0x003b), top: B:92:0x000e, outer: #1 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        kh7 kh7Var;
        super.run();
        while (this.d) {
            synchronized (this.f7569a) {
                boolean z2 = true;
                this.e = true;
                try {
                    e eVarPoll = this.j.poll();
                    if (eVarPoll == null) {
                        this.e = false;
                        this.f7569a.wait();
                        this.e = true;
                    } else {
                        int i = eVarPoll.f7571a;
                        if (i != 0) {
                            int i2 = e.a.b;
                            if ((i == e.a.f7572a && (kh7Var = eVarPoll.c) != null && (!TextUtils.isEmpty(kh7Var.c))) || eVarPoll.f7571a == e.a.c) {
                                z = true;
                            }
                            if (z) {
                                if (this.i == null) {
                                    c cVar = new c();
                                    this.i = cVar;
                                    cVar.setOnLoganProtocolStatus(new a());
                                    this.i.logan_init(this.k, this.l, (int) this.o, this.q, this.r);
                                    this.i.logan_debug(com.oplus.log.core.a.b);
                                }
                                int i3 = eVarPoll.f7571a;
                                if (i3 == e.a.f7572a) {
                                    kh7 kh7Var2 = eVarPoll.c;
                                    if (com.oplus.log.core.a.b) {
                                        Log.d("LoganThread", "Logan write start");
                                    }
                                    if (this.f == null) {
                                        this.f = new File(this.l);
                                    }
                                    hw6 hw6Var = this.c;
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.setTimeInMillis(System.currentTimeMillis());
                                    if (hw6Var.f18066a == null) {
                                        hw6Var.f18066a = calendar;
                                        if (z2) {
                                            long jCurrentTimeMillis = System.currentTimeMillis();
                                            c(jCurrentTimeMillis - this.n);
                                            c cVar2 = this.i;
                                            hw6 hw6Var2 = this.c;
                                            String str = this.m;
                                            StringBuilder sb = new StringBuilder();
                                            if (!TextUtils.isEmpty(str)) {
                                                sb.append(str);
                                                if (!str.endsWith("_")) {
                                                    sb.append("_");
                                                }
                                            }
                                            String strJ = o17.j(o17.a());
                                            if (!TextUtils.isEmpty(strJ)) {
                                                sb.append(strJ.replace(".", "_").replace(":", "_"));
                                                sb.append("_");
                                            }
                                            sb.append(hw6Var2.b.format(new Date(jCurrentTimeMillis)));
                                            sb.append(".dog3");
                                            cVar2.logan_open(sb.toString());
                                        }
                                        if (System.currentTimeMillis() - this.h > 60000) {
                                            this.g = e();
                                            this.h = System.currentTimeMillis();
                                        }
                                        if (this.g) {
                                            gw6 gw6Var = this.u;
                                            if (gw6Var != null) {
                                                kh7Var2.c = gw6Var.a(kh7Var2.f18691a, kh7Var2.c, kh7Var2.b);
                                            }
                                            this.i.logan_write(kh7Var2.g, kh7Var2.c, kh7Var2.f, kh7Var2.e, kh7Var2.d);
                                        }
                                    } else {
                                        if (calendar.get(1) == hw6Var.f18066a.get(1) && calendar.get(6) == hw6Var.f18066a.get(6) && calendar.get(11) == hw6Var.f18066a.get(11)) {
                                            z2 = false;
                                        }
                                        if (z2) {
                                        }
                                        if (System.currentTimeMillis() - this.h > 60000) {
                                        }
                                        if (this.g) {
                                        }
                                    }
                                } else {
                                    if (i3 == e.a.b) {
                                        throw null;
                                    }
                                    if (i3 == e.a.c) {
                                        d();
                                        e.b bVar = eVarPoll.b;
                                        if (bVar != null) {
                                            bVar.a();
                                        }
                                    }
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                } catch (InterruptedException e) {
                    if (k17.k()) {
                        e.printStackTrace();
                    }
                    this.e = false;
                }
            }
        }
    }
}
