package com.opos.mobad.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.mobad.n.a.i;
import com.opos.mobad.n.a.j;
import com.opos.mobad.n.a.k;
import com.opos.mobad.n.a.w;
import com.opos.mobad.n.a.x;
import com.opos.mobad.n.a.y;
import com.opos.mobad.n.a.z;
import com.opos.mobad.service.c.a;
import com.opos.mobad.service.f.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import okio.BufferedSource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC0720a f8567a;
    private String b;
    private int c = 0;
    private Map<Integer, Long> d = new ConcurrentHashMap();
    private Map<Integer, FutureTask<Integer>> e = new ConcurrentHashMap();
    private d f;

    /* JADX INFO: renamed from: com.opos.mobad.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0720a {
        void a(int i);
    }

    public a(d dVar) {
        this.f = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b.C0773b<y> b(Context context, String str) {
        z zVar;
        w.a aVarA = new w.a().a(this.b);
        int i = this.c;
        if (i == -1) {
            zVar = z.UNKNOWN_STATUS;
        } else if (i == 0) {
            zVar = z.NORMAL;
        } else if (i == 1) {
            zVar = z.VIP;
        }
        aVarA.a(zVar);
        b.C0773b<y> c0773bA = com.opos.mobad.service.f.b.a(context, "https://uapi.ads.heytapmobi.com/union/instant/vip/right", new x.a().a(aVarA.b()).a(a(context)).a(str).b(context.getPackageName()).b().b(), new b.a<y>() { // from class: com.opos.mobad.c.a.2
            @Override // com.opos.mobad.service.f.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public y b(BufferedSource bufferedSource) throws IOException {
                if (bufferedSource == null) {
                    return null;
                }
                return y.c.a(bufferedSource);
            }
        });
        Object[] objArr = new Object[2];
        objArr[0] = "getVIPResponse result=";
        objArr[1] = c0773bA != null ? c0773bA.c : com.igexin.push.core.b.m;
        com.opos.cmn.an.f.a.b("AccountManager", objArr);
        return c0773bA;
    }

    public int a(int i) {
        return !b(i) ? 1 : 0;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return a(5);
    }

    private static final j a(Context context) {
        i.a aVarB = new i.a().b(com.opos.mobad.service.d.b.a().getAndroidId()).c(com.opos.cmn.f.c.b()).d(com.opos.mobad.service.c.a.a().h()).e(com.opos.mobad.service.c.a.a().i()).f(com.opos.mobad.service.c.a.a().j()).a(Boolean.valueOf(com.opos.mobad.service.c.a.a().l())).b(Boolean.valueOf(com.opos.mobad.service.c.a.a().f()));
        a.C0768a c0768aM = com.opos.mobad.service.c.a.a().m();
        if (c0768aM != null) {
            aVarB.a(c0768aM.f9210a).a((Integer) 1);
        } else {
            aVarB.a("");
        }
        i iVarB = aVarB.b();
        return new j.a().a(iVarB).a(new k.a().c(com.opos.cmn.an.c.c.c()).a(com.opos.cmn.an.c.d.b()).b(com.opos.cmn.an.c.d.a()).b()).b(com.opos.cmn.an.c.a.a(context)).a(com.opos.cmn.an.c.c.a()).b();
    }

    public String b() {
        return this.b;
    }

    private FutureTask<Integer> b(final Context context, final String str, final int i) {
        com.opos.cmn.an.f.a.b("AccountManager", "checkVIPAdInter posId=", str, ", adType=", Integer.valueOf(i));
        if (TextUtils.isEmpty(this.b) || this.c == 0) {
            return null;
        }
        Map<Integer, FutureTask<Integer>> map = this.e;
        if (map != null && map.containsKey(Integer.valueOf(i))) {
            return this.e.get(Integer.valueOf(i));
        }
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() { // from class: com.opos.mobad.c.a.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer call() throws Exception {
                int iA;
                T t;
                b.C0773b c0773bB = a.this.b(context, str);
                if (a.this.e != null && a.this.e.containsKey(Integer.valueOf(i))) {
                    a.this.e.remove(Integer.valueOf(i));
                }
                if (c0773bB == null || c0773bB.f9237a != 200 || (t = c0773bB.c) == 0) {
                    iA = a.this.a(i);
                } else if (((y) t).i.booleanValue()) {
                    a.this.d.put(Integer.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()));
                    iA = 0;
                } else {
                    iA = 1;
                }
                return Integer.valueOf(iA);
            }
        });
        com.opos.cmn.an.j.b.c(futureTask);
        this.e.put(Integer.valueOf(i), futureTask);
        return futureTask;
    }

    private boolean b(int i) {
        StringBuilder sb;
        String str;
        Long l = this.d.get(Integer.valueOf(i));
        if (l == null) {
            sb = new StringBuilder();
            str = "not available last right:";
        } else {
            if (SystemClock.elapsedRealtime() <= l.longValue() + 60000) {
                return true;
            }
            sb = new StringBuilder();
            str = "over limit time last right:";
        }
        sb.append(str);
        sb.append(i);
        com.opos.cmn.an.f.a.b("AccountManager", sb.toString());
        return false;
    }

    public FutureTask<Integer> a(Context context, String str) {
        return b(context, str, 5);
    }

    public FutureTask<Integer> a(Context context, String str, int i) {
        return b(context, str, i);
    }

    public void a() {
        this.b = null;
        this.c = 0;
        this.f8567a = null;
        this.d = new ConcurrentHashMap();
    }

    public void a(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        com.opos.cmn.an.f.a.b("AccountManager", "vipExercise");
        this.f.d().a(str, str2, str3, str4, str5, str6, this.b);
        if (TextUtils.isEmpty(this.b) || this.f8567a == null) {
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("AccountManager", "onVipExercise");
            this.f8567a.a(i);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("AccountManager", "onVipExercise fail", th);
        }
    }
}
