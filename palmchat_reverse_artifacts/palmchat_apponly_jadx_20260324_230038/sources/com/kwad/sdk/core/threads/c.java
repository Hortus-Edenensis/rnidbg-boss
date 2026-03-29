package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    public static final String TAG = "c";
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> aOA = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> aOB = new ConcurrentHashMap<>();
    private static int aOx;
    private static int aOy;
    private static int aOz;
    private static long interval;
    private static long startTime;

    public static /* synthetic */ int Ly() {
        int i = aOx;
        aOx = i + 1;
        return i;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        aOA.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        aOB.put(threadPoolExecutor, str);
    }

    public static void df(final String str) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.threads.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                d dVarET;
                int i;
                if (TextUtils.isEmpty(str) || (dVarET = c.eT(str)) == null || (i = dVarET.aOy) == 0) {
                    return;
                }
                int unused = c.aOy = i;
                if (Math.random() * ((double) c.aOy) >= 1.0d) {
                    return;
                }
                c.a(dVarET);
            }
        });
    }

    public static d eT(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == 0) {
            return null;
        }
        b bVar = new b();
        bVar.aOn = str;
        bVar.aOo = threadPoolExecutor.getCorePoolSize();
        bVar.aOp = threadPoolExecutor.getMaximumPoolSize();
        bVar.aOq = threadPoolExecutor.getPoolSize();
        bVar.aOr = threadPoolExecutor.getActiveCount();
        bVar.aOu = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        ConcurrentHashMap<ThreadPoolExecutor, Long> concurrentHashMap = aOA;
        long jLongValue = (!concurrentHashMap.containsKey(threadPoolExecutor) || concurrentHashMap.get(threadPoolExecutor) == null) ? 0L : concurrentHashMap.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.aOt = completedTaskCount - jLongValue;
        concurrentHashMap.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.a.c) {
            bVar.aOs = ((com.kwad.sdk.core.threads.a.c) threadPoolExecutor).LC();
        } else {
            bVar.aOs = 0L;
        }
        bVar.aOv = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.aOw = aOy;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(d dVar) {
        com.kwad.sdk.core.threads.a.b.aOF = true;
        com.kwad.sdk.core.threads.a.a.aOF = true;
        interval = dVar.interval;
        aOz = dVar.aOE;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new bg() { // from class: com.kwad.sdk.core.threads.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ExecutorService executorServiceES;
                for (String str : GlobalThreadPools.Ls()) {
                    if (str != null && !c.aOB.containsValue(str) && (executorServiceES = GlobalThreadPools.eS(str)) != null && (executorServiceES instanceof ThreadPoolExecutor) && !c.aOA.containsKey(executorServiceES)) {
                        c.a((ThreadPoolExecutor) executorServiceES, str);
                    }
                }
                int poolSize = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.aOB.keySet()) {
                    String str2 = (String) c.aOB.get(threadPoolExecutor);
                    poolSize += threadPoolExecutor.getPoolSize();
                    b bVarB = c.b(threadPoolExecutor, str2);
                    if (bVarB != null) {
                        com.kwad.sdk.commercial.c.s(bVarB);
                    }
                }
                b bVar = new b();
                bVar.aOn = "total";
                bVar.aOq = poolSize;
                com.kwad.sdk.commercial.c.s(bVar);
                c.Ly();
                if (c.aOx < c.aOz) {
                    handler.postDelayed(this, c.interval);
                }
            }
        });
    }
}
