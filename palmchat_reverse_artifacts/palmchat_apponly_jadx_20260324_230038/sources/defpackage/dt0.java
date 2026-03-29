package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class dt0 {
    public static final String d = "dt0";
    public static final int e;
    public static final int f;
    public static final int g;
    public static final BlockingQueue<Runnable> h;
    public static final BlockingQueue<Runnable> i;
    public static final ExecutorService j;
    public static final ExecutorService k;
    public static final ConcurrentHashMap<String, ct0> l;
    public static final List<ct0> m;
    public static final ConcurrentHashMap<String, ct0> n;
    public static final ConcurrentHashMap<String, ct0> o;
    public static dt0 p;
    public static String q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17134a;
    public int b = 10;
    public boolean c = true;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        e = iAvailableProcessors;
        int i2 = iAvailableProcessors + 1;
        f = i2;
        int i3 = (iAvailableProcessors * 2) + 1;
        g = i3;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(56);
        h = linkedBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue(256);
        i = linkedBlockingQueue2;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        j = vw5.f(i2, i3, 3L, timeUnit, linkedBlockingQueue, "DLTask");
        k = vw5.f(i2, i3, 1L, timeUnit, linkedBlockingQueue2, "DLThread");
        l = new ConcurrentHashMap<>();
        m = Collections.synchronizedList(new ArrayList());
        n = new ConcurrentHashMap<>();
        o = new ConcurrentHashMap<>();
    }

    public dt0(Context context) {
        this.f17134a = context;
    }

    public static dt0 j() {
        return p;
    }

    public static dt0 k(Context context) {
        if (p == null) {
            p = new dt0(context);
        }
        return p;
    }

    public static dt0 l(Context context, String str) {
        if (p == null) {
            p = new dt0(context);
        }
        q = str;
        return p;
    }

    public synchronized dt0 a() {
        List<ct0> list = m;
        if (!list.isEmpty()) {
            j.execute(new et0(this.f17134a, list.remove(0)));
        }
        return p;
    }

    public synchronized dt0 b(ft0 ft0Var) {
        k.execute(ft0Var);
        return p;
    }

    public synchronized dt0 c(ct0 ct0Var) {
        n.put(ct0Var.e, ct0Var);
        return p;
    }

    public void d(String str) {
        h(str);
        ConcurrentHashMap<String, ct0> concurrentHashMap = l;
        ct0 ct0VarH = concurrentHashMap.containsKey(str) ? concurrentHashMap.get(str) : ys0.d(this.f17134a).h(str);
        if (ct0VarH != null) {
            File file = new File(ct0VarH.d, ct0VarH.c);
            if (file.exists()) {
                file.delete();
            }
        }
        ys0.d(this.f17134a).b(str);
        ys0.d(this.f17134a).a(str);
    }

    public void e(String str, String str2, String str3, il2 il2Var) {
        g(str, str2, str3, null, il2Var, false);
    }

    public void f(String str, String str2, String str3, il2 il2Var, boolean z) {
        g(str, str2, str3, null, il2Var, z);
    }

    public void g(String str, String str2, String str3, List<bt0> list, il2 il2Var, boolean z) {
        ct0 ct0VarH;
        boolean z2 = il2Var != null;
        if (TextUtils.isEmpty(str)) {
            if (z2) {
                il2Var.onError(2, "Url can not be null.");
                return;
            }
            return;
        }
        if (!ht0.f(this.f17134a)) {
            if (z2) {
                il2Var.onError(0, "Network is not available.");
                return;
            }
            return;
        }
        if (l.containsKey(str)) {
            if (il2Var != null) {
                il2Var.onError(101, str + " is downloading.");
                return;
            }
            return;
        }
        ConcurrentHashMap<String, ct0> concurrentHashMap = n;
        if (concurrentHashMap.containsKey(str)) {
            if (ws0.f21788a) {
                Log.d(d, "Resume task from memory.");
            }
            ct0VarH = concurrentHashMap.remove(str);
        } else {
            if (ws0.f21788a) {
                Log.d(d, "Resume task from database.");
            }
            ct0VarH = ys0.d(this.f17134a).h(str);
            if (ct0VarH != null) {
                ct0VarH.p.clear();
                ct0VarH.p.addAll(ys0.d(this.f17134a).g(str));
                if (ct0VarH.p.size() == 0) {
                    ys0.d(this.f17134a).b(str);
                }
            }
        }
        if (ct0VarH == null || ct0VarH.p.size() == 0) {
            if (ws0.f21788a) {
                Log.d(d, "New task will be start.");
            }
            ct0VarH = new ct0();
            ct0VarH.e = str;
            ct0VarH.f = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f17134a.getCacheDir().getAbsolutePath();
            }
            ct0VarH.d = str2;
            ct0VarH.c = str3;
            this.c = true;
        } else {
            this.c = false;
            ct0VarH.j = false;
            ct0VarH.i = true;
            Iterator<gt0> it = ct0VarH.p.iterator();
            while (it.hasNext()) {
                it.next().e = false;
            }
        }
        if (z) {
            ct0VarH.f = str;
        }
        ct0VarH.g = 0;
        ct0VarH.o = ht0.e(list, ct0VarH);
        if (b13.e() != null && b13.e().size() > 0) {
            for (Map.Entry<String, String> entry : b13.e().entrySet()) {
                ht0.a(ct0VarH.o, entry.getKey(), entry.getValue());
            }
        }
        ct0VarH.q = il2Var;
        ct0VarH.h = z2;
        ConcurrentHashMap<String, ct0> concurrentHashMap2 = l;
        if (concurrentHashMap2.size() >= this.b) {
            if (ws0.f21788a) {
                Log.w(d, "Downloading urls is out of range.");
            }
            m.add(ct0VarH);
            return;
        }
        if (ws0.f21788a) {
            Log.d(d, "Prepare download from " + ct0VarH.e);
        }
        if (z2) {
            il2Var.onPrepare();
        }
        concurrentHashMap2.put(str, ct0VarH);
        j.execute(new et0(this.f17134a, ct0VarH));
    }

    public void h(String str) {
        ConcurrentHashMap<String, ct0> concurrentHashMap = l;
        if (concurrentHashMap.containsKey(str)) {
            ct0 ct0Var = concurrentHashMap.get(str);
            ct0Var.j = true;
            if (ct0Var.p.isEmpty()) {
                return;
            }
            Iterator<gt0> it = ct0Var.p.iterator();
            while (it.hasNext()) {
                it.next().e = true;
            }
        }
    }

    public boolean i() {
        return this.c;
    }

    public boolean m(String str) {
        return l.containsKey(str);
    }

    public synchronized dt0 n(String str) {
        l.remove(str);
        return p;
    }

    public void o(String str, il2 il2Var) {
        ct0 ct0Var = l.get(str);
        if (ct0Var == null) {
            ct0Var = n.get(str);
        }
        if (ct0Var != null) {
            ct0Var.q = il2Var;
            ct0Var.h = true;
        }
    }
}
