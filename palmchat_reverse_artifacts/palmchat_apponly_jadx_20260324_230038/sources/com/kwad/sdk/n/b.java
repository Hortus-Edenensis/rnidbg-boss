package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.p;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    private List<com.kwad.sdk.n.a.a> bbS;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final b bbW = new b();
    }

    private static void C(int i, String str) {
        ag.g("ksadsdk_perf_ranger_v2", "aggregation_version" + ("_" + i), str);
    }

    private boolean N(List<String> list) {
        int i;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String[] strArrGV = gV(it.next());
            int length = strArrGV.length;
            boolean zGU = false;
            while (i < length) {
                zGU = gU(strArrGV[i]);
                i = zGU ? 0 : i + 1;
            }
            z &= zGU;
        }
        return z;
    }

    public static b QF() {
        return a.bbW;
    }

    private void QG() {
        long jRE = p.RE();
        if (jRE <= 0) {
            return;
        }
        aV(jRE);
    }

    private static void QI() {
        ag.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", 0L);
    }

    private static void aV(long j) {
        ag.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", j);
    }

    private static void eQ(int i) {
        ag.b("ksadsdk_perf_ranger_v2", "aggregation_sdk" + ("_" + i), 1);
    }

    private static boolean eR(int i) {
        StringBuilder sb = new StringBuilder("aggregation_sdk");
        sb.append("_" + i);
        return ag.c("ksadsdk_perf_ranger_v2", sb.toString(), -1) == 1;
    }

    private static com.kwad.sdk.n.b.a.a eS(int i) {
        com.kwad.sdk.n.b.a.a aVar = new com.kwad.sdk.n.b.a.a();
        String str = "_" + i;
        aVar.fa(i);
        aVar.gY(ag.h("ksadsdk_perf_ranger_v2", "aggregation_version" + str, ""));
        aVar.fb(ag.c("ksadsdk_perf_ranger_v2", "crash_times" + str, 0));
        aVar.fc(ag.c("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, 0));
        aVar.aW(ag.b("ksadsdk_perf_ranger_v2", "ks_launch_delay", -1L));
        aVar.aX(ag.b("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + str, -1L));
        return aVar;
    }

    private static void eT(int i) {
        ag.g("ksadsdk_perf_ranger_v2", "aggregation_version" + ("_" + i), "");
    }

    public static void eU(int i) {
        String str = "_" + i;
        ag.b("ksadsdk_perf_ranger_v2", "crash_times" + str, ag.c("ksadsdk_perf_ranger_v2", "crash_times" + str, -1) + 1);
    }

    private static void eV(int i) {
        ag.b("ksadsdk_perf_ranger_v2", "crash_times" + ("_" + i), 0);
    }

    public static void eW(int i) {
        String str = "_" + i;
        ag.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, ag.c("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, -1) + 1);
    }

    private static void eX(int i) {
        ag.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + ("_" + i), 0);
    }

    private static void eY(int i) {
        ag.a("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + ("_" + i), 0L);
    }

    private static boolean gU(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String[] gV(String str) {
        return str.contains("_") ? str.split("_") : new String[]{str};
    }

    public final void QH() {
        boolean z = false;
        for (int i = 0; i < this.bbS.size(); i++) {
            com.kwad.sdk.n.a.a aVar = this.bbS.get(i);
            if (eR(aVar.bcj)) {
                com.kwad.sdk.commercial.c.v(eS(aVar.bcj));
                z = true;
            }
        }
        if (z) {
            return;
        }
        com.kwad.sdk.commercial.c.v(eS(-1));
    }

    public final void clearAll() {
        for (int i = 0; i < this.bbS.size(); i++) {
            eT(i);
            eV(i);
            eX(i);
            QI();
            eY(i);
        }
    }

    public final void gW(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GlobalThreadPools.Lf().execute(new Runnable() { // from class: com.kwad.sdk.n.b.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.bbS != null && !b.this.bbS.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : b.this.bbS) {
                            if (b.b(str, aVar.bcm)) {
                                b.eU(aVar.bcj);
                            }
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    public final void start() {
        QG();
        List<com.kwad.sdk.n.a.a> list = this.bbS;
        if (list == null) {
            com.kwad.sdk.core.d.c.w(TAG, "aggregationCheckConfigList is null");
            return;
        }
        for (com.kwad.sdk.n.a.a aVar : list) {
            try {
                if (N(aVar.bck)) {
                    eQ(aVar.bcj);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
            }
            try {
                if (aVar.bcl != null) {
                    a(aVar);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e2));
            }
        }
    }

    private void a(com.kwad.sdk.n.a.a aVar) {
        String strA = c.QK().a(aVar.bcl);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        C(aVar.bcj, strA);
    }

    public final void b(d dVar) {
        List<com.kwad.sdk.n.a.a> list = dVar.bbS;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.bbS = list;
    }

    public final void c(final StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        GlobalThreadPools.Lf().execute(new Runnable() { // from class: com.kwad.sdk.n.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.bbS != null && !b.this.bbS.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : b.this.bbS) {
                            if (b.a(stackTraceElementArr, aVar.bcn)) {
                                b.eW(aVar.bcj);
                            }
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static boolean a(StackTraceElement[] stackTraceElementArr, List<String> list) {
        boolean z;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        do {
            z = true;
            if (!it.hasNext()) {
                return true;
            }
            String next = it.next();
            int length = stackTraceElementArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                if (p.a(stackTraceElementArr[i]).contains(next)) {
                    break;
                }
                i++;
            }
        } while (z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}
