package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class xt6 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: xt6$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class RunnableC1289a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f22052a;
            public final /* synthetic */ Context b;

            public RunnableC1289a(String str, Context context) {
                this.f22052a = str;
                this.b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f22052a) || a.d(this.b, this.f22052a)) {
                    for (int i = 0; i < 4; i++) {
                        String strE = b.e(this.b);
                        if (TextUtils.isEmpty(strE) || !a.d(this.b, strE)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized void a(Context context, zz6 zz6Var, String str, String str2) {
            if (context == null || zz6Var == null || str == null) {
                return;
            }
            b(context, zz6Var.e(str), str2);
        }

        public static synchronized void b(Context context, String str, String str2) {
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                b.c(context, str, str2);
            }
            new Thread(new RunnableC1289a(str, context)).start();
        }

        public static synchronized boolean d(Context context, String str) {
            w97.f("mspl", "stat sub " + str);
            try {
                if ((vt6.I().n() ? new s77() : new v97()).b(null, context, str) == null) {
                    return false;
                }
                b.a(context, str);
                return true;
            } catch (Throwable th) {
                w97.d(th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {
        public static synchronized int a(Context context, String str) {
            w97.f("RecordPref", "stat remove " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                a aVarB = b(context);
                if (aVarB.f22053a.isEmpty()) {
                    return 0;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, String> entry : aVarB.f22053a.entrySet()) {
                        if (str.equals(entry.getValue())) {
                            arrayList.add(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        aVarB.f22053a.remove((String) it.next());
                    }
                    d(context, aVarB);
                    return arrayList.size();
                } catch (Throwable th) {
                    w97.d(th);
                    int size = aVarB.f22053a.size();
                    d(context, new a());
                    return size;
                }
            }
            return 0;
        }

        public static synchronized a b(Context context) {
            try {
                String strA = ff7.a(null, context, "alipay_cashier_statistic_record", null);
                if (TextUtils.isEmpty(strA)) {
                    return new a();
                }
                return new a(strA);
            } catch (Throwable th) {
                w97.d(th);
                return new a();
            }
        }

        public static synchronized String c(Context context, String str, String str2) {
            w97.f("RecordPref", "stat append " + str2 + " , " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString();
                }
                a aVarB = b(context);
                if (aVarB.f22053a.size() > 20) {
                    aVarB.f22053a.clear();
                }
                aVarB.f22053a.put(str2, str);
                d(context, aVarB);
                return str2;
            }
            return null;
        }

        public static synchronized void d(Context context, a aVar) {
            if (aVar == null) {
                try {
                    aVar = new a();
                } catch (Throwable th) {
                    w97.d(th);
                }
            }
            ff7.c(null, context, "alipay_cashier_statistic_record", aVar.a());
        }

        public static synchronized String e(Context context) {
            w97.f("RecordPref", "stat peek");
            if (context == null) {
                return null;
            }
            a aVarB = b(context);
            if (aVarB.f22053a.isEmpty()) {
                return null;
            }
            try {
                return aVarB.f22053a.entrySet().iterator().next().getValue();
            } catch (Throwable th) {
                w97.d(th);
                return null;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LinkedHashMap<String, String> f22053a = new LinkedHashMap<>();

            public a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.f22053a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    w97.d(th);
                    return new JSONArray().toString();
                }
            }

            public a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.f22053a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    w97.d(th);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {
        public static synchronized long a(Context context) {
            return d.a(context, "alipay_cashier_ap_seq_v");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {
        public static synchronized long a(Context context, String str) {
            long j;
            String strA;
            try {
                strA = ff7.a(null, context, str, null);
            } catch (Throwable unused) {
            }
            j = (!TextUtils.isEmpty(strA) ? Long.parseLong(strA) : 0L) + 1;
            try {
                ff7.c(null, context, str, Long.toString(j));
            } catch (Throwable unused2) {
            }
            return j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {
        public static synchronized long a(Context context) {
            return d.a(context, "alipay_cashier_statistic_v");
        }
    }

    public static void a(ru6 ru6Var, String str, String str2) {
        if (ru6Var == null) {
            return;
        }
        ru6Var.j.g(str, str2);
    }

    public static void b(ru6 ru6Var, String str, String str2, String str3) {
        if (ru6Var == null) {
            return;
        }
        ru6Var.j.h(str, str2, str3);
    }

    public static void c(ru6 ru6Var, String str, String str2, Throwable th) {
        if (ru6Var == null) {
            return;
        }
        ru6Var.j.i(str, str2, th);
    }

    public static void d(ru6 ru6Var, String str, String str2, Throwable th, String str3) {
        if (ru6Var == null) {
            return;
        }
        ru6Var.j.j(str, str2, th, str3);
    }

    public static void e(ru6 ru6Var, String str, Throwable th) {
        if (ru6Var == null || th == null) {
            return;
        }
        ru6Var.j.i(str, th.getClass().getSimpleName(), th);
    }

    public static synchronized void f(Context context, ru6 ru6Var, String str, String str2) {
        if (context == null || ru6Var == null) {
            return;
        }
        try {
            b.c(context, ru6Var.j.e(str), str2);
        } catch (Throwable th) {
            w97.d(th);
        }
    }

    public static void g(ru6 ru6Var, String str, String str2, String str3) {
        if (ru6Var == null) {
            return;
        }
        ru6Var.j.n(str, str2, str3);
    }

    public static synchronized void h(Context context, ru6 ru6Var, String str, String str2) {
        if (context == null || ru6Var == null) {
            return;
        }
        a.a(context, ru6Var.j, str, str2);
    }
}
