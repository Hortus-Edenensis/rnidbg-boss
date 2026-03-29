package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.hm;
import com.bytedance.embedapplog.ky;
import com.bytedance.embedapplog.pn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class cb {
    private static final List<pn> b;
    private static String jk;
    private static boolean l;
    private static final String nr;
    private static long t;
    static final String u;
    private final boolean iz;
    private Map<String, String> mv;
    private final Context n;
    private final ky pn;
    private Long s;
    private final dd x;
    private final ReentrantLock fx = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f5059a = new AtomicBoolean(false);

    static {
        String str = cb.class.getSimpleName() + "#";
        nr = str;
        u = str;
        b = new ArrayList();
    }

    public cb(Context context) {
        this.n = context.getApplicationContext();
        ky kyVarU = j.u(context);
        this.pn = kyVarU;
        if (kyVarU != null) {
            this.iz = kyVarU.u(context);
        } else {
            this.iz = false;
        }
        this.x = new dd(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int iIntValue;
        try {
            this.fx.lock();
            qf qfVarU = this.x.u();
            long jLongValue = -1;
            boolean z = false;
            if (qfVarU != null) {
                jk = qfVarU.u;
                Boolean bool = qfVarU.fx;
                l = bool != null && bool.booleanValue();
                Long l2 = qfVarU.x;
                t = l2 == null ? -1L : l2.longValue();
                this.mv = qfVarU.u();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> pairU = u(this.n);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            qf qfVar = null;
            String string = null;
            if (pairU.first != null) {
                if (qfVarU != null) {
                    string = qfVarU.nr;
                    iIntValue = qfVarU.iz.intValue() + 1;
                } else {
                    iIntValue = -1;
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                String str = string;
                if (iIntValue <= 0) {
                    iIntValue = 1;
                }
                qf qfVar2 = new qf((String) pairU.first, str, (Boolean) pairU.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.s);
                this.x.u(qfVar2);
                qfVar = qfVar2;
            }
            if (qfVar != null) {
                jk = qfVar.u;
                Boolean bool2 = qfVar.fx;
                if (bool2 != null && bool2.booleanValue()) {
                    z = true;
                }
                l = z;
                Long l3 = qfVar.x;
                if (l3 != null) {
                    jLongValue = l3.longValue();
                }
                t = jLongValue;
                this.mv = qfVar.u();
            }
        } finally {
            this.fx.unlock();
            u(new pn.u(jk, l, t), fx());
        }
    }

    private static Object[] fx() {
        Object[] array;
        List<pn> list = b;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    public void nr() {
        if (this.f5059a.compareAndSet(false, true)) {
            u(new Runnable() { // from class: com.bytedance.embedapplog.cb.1
                @Override // java.lang.Runnable
                public void run() {
                    cb.this.b();
                }
            });
        }
    }

    @Nullable
    @WorkerThread
    public Map<String, String> u(long j) {
        if (!this.iz) {
            return null;
        }
        if (!u.nr) {
            qf qfVarU = this.x.u();
            if (qfVarU != null) {
                return qfVarU.u();
            }
            return null;
        }
        nr();
        if (this.mv == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.fx.tryLock(j, TimeUnit.MILLISECONDS)) {
                    this.fx.unlock();
                }
            } catch (InterruptedException e) {
                ti.u(e);
            }
        }
        return this.mv;
    }

    @AnyThread
    public static void u(@Nullable pn pnVar) {
        List<pn> list = b;
        synchronized (list) {
            list.add(pnVar);
        }
        String str = jk;
        if (str != null) {
            u(new pn.u(str, l, t), new Object[]{pnVar});
        }
    }

    public ky u() {
        return this.pn;
    }

    private static void u(@Nullable pn.u uVar, Object[] objArr) {
        if (uVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((pn) obj).u(uVar);
        }
    }

    public static void u(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            ti.u(e);
        }
    }

    public static <K, V> void u(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> u(Context context) {
        String str;
        Boolean boolValueOf;
        ky.u uVarNr;
        ky kyVar = this.pn;
        if (kyVar == null || (uVarNr = kyVar.nr(context)) == null) {
            str = null;
            boolValueOf = null;
        } else {
            str = uVarNr.nr;
            boolValueOf = Boolean.valueOf(uVarNr.fx);
            if (uVarNr instanceof hm.u) {
                this.s = Long.valueOf(((hm.u) uVarNr).u);
            }
        }
        return new Pair<>(str, boolValueOf);
    }

    private static void u(Runnable runnable) {
        pq.u(u + "-query", runnable);
    }
}
