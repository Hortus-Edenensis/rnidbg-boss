package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.igexin.sdk.PushConsts;
import com.ss.android.socialbase.downloader.depend.gi;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.downloader.dw;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile u f10604a;
    private static boolean ay;
    private static volatile n b;
    private static final int bc;
    private static volatile ExecutorService bg;
    private static volatile ExecutorService bq;
    private static volatile ExecutorService c;
    private static int cj;
    private static volatile com.ss.android.socialbase.downloader.b.nr d;
    private static volatile ExecutorService dw;
    private static com.ss.android.socialbase.downloader.b.fx eh;
    private static volatile t fx;
    private static volatile o gi;
    private static volatile gi h;
    private static volatile com.ss.android.socialbase.downloader.impls.u iz;
    private static volatile IDownloadHttpService jk;
    private static volatile ExecutorService k;
    private static volatile DownloadReceiver kj;
    private static volatile IDownloadHttpService l;
    private static volatile boolean lf;
    private static int mh;
    private static volatile com.ss.android.socialbase.downloader.network.n mv;
    private static volatile ExecutorService my;
    private static volatile k n;
    private static volatile jk nr;
    private static volatile ExecutorService o;
    private static final int oa;
    private static volatile com.ss.android.socialbase.downloader.network.iz pb;
    private static volatile ja pn;
    private static volatile ScheduledExecutorService q;
    private static volatile x qq;
    private static volatile l s;
    private static final List<Object> su;
    private static volatile ExecutorService sx;
    private static volatile com.ss.android.socialbase.downloader.network.n t;
    private static boolean tk;
    private static volatile Context u;
    private static sx v;
    private static final int w;
    private static final List<com.ss.android.socialbase.downloader.depend.t> wi;
    private static volatile com.ss.android.socialbase.downloader.network.iz wq;
    private static volatile k x;
    private static volatile dw xg;
    private static final int xw;
    private static int y;
    private static boolean yd;
    private static volatile bg z;
    private static volatile List<m> rh = new ArrayList();
    private static volatile boolean ja = false;
    private static volatile OkHttpClient bf = null;
    private static final List<com.ss.android.socialbase.downloader.depend.mv> m = new ArrayList();

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private static boolean f10605jp = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.fx$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public interface InterfaceC0874u {
            void u();
        }

        mv nr();

        bq u(InterfaceC0874u interfaceC0874u);

        k u();
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        bc = iAvailableProcessors;
        xw = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        oa = iAvailableProcessors;
        w = iAvailableProcessors;
        cj = 8192;
        wi = new ArrayList();
        su = new ArrayList();
        yd = true;
        ay = false;
        lf = false;
    }

    private fx() {
    }

    public static com.ss.android.socialbase.downloader.network.n a() {
        if (mv == null) {
            synchronized (fx.class) {
                if (mv == null) {
                    mv = new com.ss.android.socialbase.downloader.impls.iz();
                }
            }
        }
        return mv;
    }

    public static IDownloadHttpService b() {
        return jk;
    }

    public static bg bc() {
        if (z == null) {
            synchronized (fx.class) {
                if (z == null) {
                    z = new com.ss.android.socialbase.downloader.impls.jk();
                }
            }
        }
        return z;
    }

    @NonNull
    public static JSONObject bf() {
        return (h == null || h.u() == null) ? com.ss.android.socialbase.downloader.constants.pn.f10603a : h.u();
    }

    public static OkHttpClient bg() {
        if (bf == null) {
            synchronized (fx.class) {
                if (bf == null) {
                    bf = dw().build();
                }
            }
        }
        return bf;
    }

    public static ScheduledExecutorService bq() {
        if (q == null) {
            synchronized (fx.class) {
                if (q == null) {
                    q = new com.bytedance.sdk.component.jk.b.pn(1, new com.ss.android.socialbase.downloader.a.u("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return q;
    }

    public static com.ss.android.socialbase.downloader.network.iz c() {
        return wq;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.b.fx cj() {
        if (eh == null) {
            eh = new com.ss.android.socialbase.downloader.b.fx() { // from class: com.ss.android.socialbase.downloader.downloader.fx.3
                @Override // com.ss.android.socialbase.downloader.b.fx
                public void nr(int i, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.b.fx
                public void u(int i, String str, JSONObject jSONObject) {
                }
            };
        }
        return eh;
    }

    public static List<com.ss.android.socialbase.downloader.depend.mv> d() {
        return m;
    }

    public static OkHttpClient.Builder dw() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (c != null) {
            builder.dispatcher(new Dispatcher(c));
        }
        return builder;
    }

    private static void fx(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                u(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                u(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                u(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                u(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                u(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                nr(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                u(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                u(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                u(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                fx(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                b(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                pn(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                iz(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                x(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                n(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                u(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                nr(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                u(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                gi = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                cj = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                u(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                ja = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                mh = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                u(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                wq = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                dw tTNetHandler = downloaderBuilder.getTTNetHandler();
                xg = tTNetHandler;
                if (tTNetHandler.u()) {
                    u(xg.nr());
                    u(xg.fx());
                } else {
                    u(n());
                    u(a());
                }
            }
            nr(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                u(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    public static k gi() {
        if (n == null) {
            synchronized (fx.class) {
                if (n == null) {
                    n = f10604a.u();
                }
            }
        }
        return n;
    }

    public static t h() {
        if (fx == null) {
            synchronized (fx.class) {
                if (fx == null) {
                    fx = new com.ss.android.socialbase.downloader.impls.a();
                }
            }
        }
        return fx;
    }

    public static com.ss.android.socialbase.downloader.network.n iz() {
        return t;
    }

    public static int ja() {
        return mh;
    }

    public static boolean jk() {
        return com.ss.android.socialbase.downloader.n.u.fx().u("switch_not_auto_boot_service", ay ? 1 : 0) > 0;
    }

    public static ja jp() {
        return pn;
    }

    public static ExecutorService k() {
        return bg != null ? bg : my();
    }

    public static jk kj() {
        if (nr == null) {
            synchronized (fx.class) {
                if (nr == null) {
                    nr = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return nr;
    }

    public static ExecutorService l() {
        if (k == null) {
            synchronized (fx.class) {
                if (k == null) {
                    int i = bc;
                    com.bytedance.sdk.component.jk.b.b bVar = new com.bytedance.sdk.component.jk.b.b(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.a.u("DownloadThreadPool-cpu-fixed", true));
                    try {
                        bVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable unused) {
                    }
                    k = bVar;
                }
            }
        }
        return k;
    }

    public static n m() {
        if (b == null) {
            synchronized (fx.class) {
                if (b == null) {
                    b = new com.ss.android.socialbase.downloader.impls.fx();
                }
            }
        }
        return b;
    }

    public static u mh() {
        return f10604a;
    }

    public static ExecutorService mv() {
        return my != null ? my : l();
    }

    public static ExecutorService my() {
        if (o == null) {
            synchronized (fx.class) {
                if (o == null) {
                    int i = oa;
                    com.bytedance.sdk.component.jk.b.b bVar = new com.bytedance.sdk.component.jk.b.b(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.a.u("DownloadThreadPool-mix-fixed", true));
                    try {
                        bVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable unused) {
                    }
                    o = bVar;
                }
            }
        }
        return o;
    }

    public static IDownloadHttpService n() {
        if (l == null) {
            synchronized (fx.class) {
                if (l == null) {
                    l = new com.ss.android.socialbase.downloader.impls.x();
                }
            }
        }
        return l;
    }

    public static synchronized void nr(DownloaderBuilder downloaderBuilder) {
        fx(downloaderBuilder);
    }

    public static ExecutorService o() {
        if (dw == null) {
            synchronized (fx.class) {
                if (dw == null) {
                    int i = xw;
                    com.bytedance.sdk.component.jk.b.b bVar = new com.bytedance.sdk.component.jk.b.b(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.a.u("DownloadThreadPool-chunk-fixed", true));
                    try {
                        bVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable unused) {
                    }
                    dw = bVar;
                }
            }
        }
        return dw;
    }

    public static synchronized Context oa() {
        return u;
    }

    public static boolean pb() {
        return yd;
    }

    public static List<m> pn() {
        List<m> list;
        synchronized (rh) {
            list = rh;
        }
        return list;
    }

    public static com.ss.android.socialbase.downloader.network.iz q() {
        if (pb == null) {
            synchronized (fx.class) {
                if (pb == null) {
                    pb = new com.ss.android.socialbase.downloader.network.iz() { // from class: com.ss.android.socialbase.downloader.downloader.fx.2
                        @Override // com.ss.android.socialbase.downloader.network.iz
                        public List<InetAddress> u(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return pb;
    }

    public static synchronized l qq() {
        return s;
    }

    public static com.ss.android.socialbase.downloader.impls.u rh() {
        if (iz == null) {
            synchronized (fx.class) {
                if (iz == null) {
                    iz = new com.ss.android.socialbase.downloader.impls.pn();
                }
            }
        }
        return iz;
    }

    public static ExecutorService s() {
        return sx != null ? sx : my();
    }

    public static boolean su() {
        StringBuilder sb = new StringBuilder("supportMultiProc::=");
        sb.append(f10604a != null);
        com.ss.android.socialbase.downloader.fx.u.u("wjd", sb.toString());
        return f10604a != null;
    }

    public static ExecutorService sx() {
        if (bq == null) {
            synchronized (fx.class) {
                if (bq == null) {
                    int i = w;
                    com.bytedance.sdk.component.jk.b.b bVar = new com.bytedance.sdk.component.jk.b.b(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.a.u("DownloadThreadPool-db-fixed", true));
                    try {
                        bVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable unused) {
                    }
                    bq = bVar;
                }
            }
        }
        return bq;
    }

    public static synchronized o t() {
        return gi;
    }

    public static sx tk() {
        return v;
    }

    public static void u(sx sxVar) {
    }

    public static synchronized boolean w() {
        return tk;
    }

    public static boolean wi() {
        return lf;
    }

    public static void wq() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.pn.fx)) {
            com.ss.android.socialbase.downloader.constants.pn.fx = "oppo";
            com.ss.android.socialbase.downloader.constants.pn.nr = "oppo".toUpperCase();
        }
    }

    public static com.ss.android.socialbase.downloader.b.nr x() {
        return d;
    }

    public static synchronized int xg() {
        return cj;
    }

    public static dw xw() {
        if (xg == null) {
            synchronized (fx.class) {
                if (xg == null) {
                    xg = new dw.u();
                }
            }
        }
        return xg;
    }

    public static x y() {
        if (qq == null) {
            synchronized (fx.class) {
                if (qq == null) {
                    qq = new com.ss.android.socialbase.downloader.impls.nr();
                }
            }
        }
        return qq;
    }

    private static void yd() {
        if (kj == null) {
            kj = new DownloadReceiver();
        }
        if (f10605jp) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            u.registerReceiver(kj, intentFilter);
            f10605jp = true;
        } catch (Throwable unused) {
        }
    }

    public static k z() {
        if (x == null) {
            synchronized (fx.class) {
                if (x == null) {
                    x = new com.ss.android.socialbase.downloader.impls.n();
                }
            }
        }
        return x;
    }

    private static void b(ExecutorService executorService) {
        if (executorService != null) {
            my = executorService;
        }
    }

    private static void iz(ExecutorService executorService) {
        if (executorService != null) {
            sx = executorService;
        }
    }

    public static synchronized void u(DownloaderBuilder downloaderBuilder) {
        if (lf) {
            com.ss.android.socialbase.downloader.fx.u.pn("DownloadComponentManager", "component has init");
            return;
        }
        boolean z2 = ja;
        fx(downloaderBuilder);
        if (nr == null) {
            nr = new com.ss.android.socialbase.downloader.impls.b();
        }
        if (x == null) {
            x = new com.ss.android.socialbase.downloader.impls.n();
        }
        if (n == null && f10604a != null) {
            n = f10604a.u();
        }
        if (fx == null) {
            fx = new com.ss.android.socialbase.downloader.impls.a();
        }
        if (iz == null) {
            iz = new com.ss.android.socialbase.downloader.impls.pn();
        }
        if (b == null) {
            b = new com.ss.android.socialbase.downloader.impls.fx();
        }
        if (qq == null) {
            qq = new com.ss.android.socialbase.downloader.impls.nr();
        }
        if (z == null) {
            z = new com.ss.android.socialbase.downloader.impls.jk();
        }
        int i = y;
        if (i <= 0 || i > bc) {
            y = bc;
        }
        yd();
        if (ja && !z2 && !com.ss.android.socialbase.downloader.jk.iz.fx()) {
            com.ss.android.socialbase.downloader.impls.l.u(true).startService();
        } else if (com.ss.android.socialbase.downloader.jk.iz.b()) {
            ExecutorService executorServiceMv = mv();
            if (executorServiceMv != null) {
                executorServiceMv.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.fx.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context contextOa = fx.oa();
                        if (contextOa != null) {
                            com.ss.android.socialbase.downloader.jk.iz.b(contextOa);
                        }
                    }
                });
            }
        } else {
            Context contextOa = oa();
            if (contextOa != null) {
                com.ss.android.socialbase.downloader.jk.iz.b(contextOa);
            }
        }
        wq();
        lf = true;
    }

    private static void x(ExecutorService executorService) {
        if (executorService != null) {
            bg = executorService;
        }
    }

    public static synchronized void nr() {
        if (ja) {
            return;
        }
        ja = true;
        try {
            Intent intent = new Intent(oa(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            oa().startService(intent);
            if (!com.ss.android.socialbase.downloader.jk.iz.fx()) {
                com.ss.android.socialbase.downloader.impls.l.u(true).startService();
            }
        } catch (Throwable unused) {
            ja = false;
        }
    }

    private static void pn(ExecutorService executorService) {
        if (executorService != null) {
            o = executorService;
        }
    }

    private static void n(ExecutorService executorService) {
        if (executorService != null) {
            bq = executorService;
        }
    }

    public static void nr(com.ss.android.socialbase.downloader.depend.t tVar) {
        List<com.ss.android.socialbase.downloader.depend.t> list = wi;
        synchronized (list) {
            if (tVar != null) {
                if (list.contains(tVar)) {
                    list.remove(tVar);
                }
            }
        }
    }

    public static void nr(DownloadTask downloadTask, int i) {
        List<Object> list = su;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.ss.android.socialbase.downloader.network.x nr(String str, List<com.ss.android.socialbase.downloader.model.fx> list, int i, boolean z2, DownloadInfo downloadInfo) throws Throwable {
        com.ss.android.socialbase.downloader.network.n nVarIz = i == 1 ? iz() : a();
        if (nVarIz != null) {
            IOException iOException = null;
            long jCurrentTimeMillis = 0;
            if (z2) {
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        try {
                            com.ss.android.socialbase.downloader.network.x xVarU = nVarIz.u(str, list);
                            if (z2) {
                                com.ss.android.socialbase.downloader.b.u.u(xVarU, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i, null, downloadInfo);
                            }
                            return xVarU;
                        } catch (IOException e) {
                            e = e;
                            iOException = e;
                            throw iOException;
                        }
                    } catch (Throwable th) {
                        th = th;
                        IOException iOException2 = iOException;
                        if (z2) {
                            com.ss.android.socialbase.downloader.b.u.u(null, str, null, System.currentTimeMillis() - jCurrentTimeMillis, "head", i, iOException2, downloadInfo);
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    IOException iOException22 = iOException;
                    if (z2) {
                    }
                    throw th;
                }
            } else {
                com.ss.android.socialbase.downloader.network.x xVarU2 = nVarIz.u(str, list);
                if (z2) {
                }
                return xVarU2;
            }
            iOException = e;
            throw iOException;
        } else {
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i));
        }
    }

    public static void nr(ExecutorService executorService) {
        if (executorService != null) {
            c = executorService;
        }
    }

    public static void nr(Runnable runnable) {
        nr(runnable, false);
    }

    public static void nr(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.jk.iz.b()) {
            runnable.run();
        } else {
            mv().execute(runnable);
        }
    }

    private static void nr(int i) {
        if (i > 0) {
            y = i;
        }
    }

    public static synchronized void u() {
        try {
            if (f10605jp && kj != null && u != null) {
                u.unregisterReceiver(kj);
                f10605jp = false;
            }
        } catch (Exception unused) {
        }
    }

    private static void nr(boolean z2) {
        yd = z2;
    }

    public static void u(m mVar) {
        if (mVar == null) {
            return;
        }
        synchronized (rh) {
            rh.add(mVar);
        }
    }

    public static void u(com.ss.android.socialbase.downloader.depend.t tVar) {
        List<com.ss.android.socialbase.downloader.depend.t> list = wi;
        synchronized (list) {
            if (tVar != null) {
                if (!list.contains(tVar)) {
                    list.add(tVar);
                }
            }
        }
    }

    public static void u(com.ss.android.socialbase.downloader.constants.b bVar) {
        List<com.ss.android.socialbase.downloader.depend.t> list = wi;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.t tVar : list) {
                if (tVar != null && bVar != com.ss.android.socialbase.downloader.constants.b.SYNC_START && bVar == com.ss.android.socialbase.downloader.constants.b.SYNC_SUCCESS) {
                    tVar.u();
                }
            }
            if (bVar == com.ss.android.socialbase.downloader.constants.b.SYNC_SUCCESS) {
                wi.clear();
            }
        }
    }

    public static synchronized boolean fx() {
        return ja;
    }

    public static void u(DownloadTask downloadTask, int i) {
        List<Object> list = su;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private static void fx(ExecutorService executorService) {
        if (executorService != null) {
            k = executorService;
        }
    }

    public static void fx(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.jk.iz.b()) {
            runnable.run();
        } else {
            sx().execute(runnable);
        }
    }

    public static com.ss.android.socialbase.downloader.network.a u(boolean z2, int i, String str, List<com.ss.android.socialbase.downloader.model.fx> list) throws Exception {
        return u(z2, i, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.a u(boolean z2, int i, String str, String str2, List<com.ss.android.socialbase.downloader.model.fx> list, int i2, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.fx> list2;
        int i3;
        com.ss.android.socialbase.downloader.network.a aVarU;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.fx> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.fx("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i3 = 1;
        } else if (z2) {
            list2 = list;
            i3 = i2;
        } else {
            i3 = 2;
            list2 = list;
        }
        int[] iArrU = u(i3);
        Exception exc = null;
        for (int i4 : iArrU) {
            try {
                aVarU = u(i, str, str2, list2, i4, z3, downloadInfo);
            } catch (Exception e) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.jk.iz.x(e) && com.ss.android.socialbase.downloader.jk.iz.fx(list2)) {
                    com.ss.android.socialbase.downloader.fx.u.u("dcach::http exception 304, throw excepiton, not retry " + e);
                    throw e;
                }
                exc = e;
            }
            if (aVarU != null) {
                return aVarU;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.ss.android.socialbase.downloader.network.a u(int i, String str, String str2, List<com.ss.android.socialbase.downloader.model.fx> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Throwable {
        IDownloadHttpService iDownloadHttpServiceB = i2 == 1 ? b() : n();
        if (iDownloadHttpServiceB != null) {
            IOException iOException = null;
            long jCurrentTimeMillis = 0;
            if (z2) {
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        try {
                            com.ss.android.socialbase.downloader.network.a aVarDownloadWithConnection = iDownloadHttpServiceB.downloadWithConnection(i, str, list);
                            if (z2) {
                                com.ss.android.socialbase.downloader.b.u.u(aVarDownloadWithConnection, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i2, null, downloadInfo);
                            }
                            return aVarDownloadWithConnection;
                        } catch (IOException e) {
                            e = e;
                            iOException = e;
                            throw iOException;
                        }
                    } catch (Throwable th) {
                        th = th;
                        IOException iOException2 = iOException;
                        if (z2) {
                            com.ss.android.socialbase.downloader.b.u.u(null, str, str2, System.currentTimeMillis() - jCurrentTimeMillis, "get", i2, iOException2, downloadInfo);
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    IOException iOException22 = iOException;
                    if (z2) {
                    }
                    throw th;
                }
            } else {
                com.ss.android.socialbase.downloader.network.a aVarDownloadWithConnection2 = iDownloadHttpServiceB.downloadWithConnection(i, str, list);
                if (z2) {
                }
                return aVarDownloadWithConnection2;
            }
            iOException = e;
            throw iOException;
        } else {
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
        }
    }

    public static com.ss.android.socialbase.downloader.network.x u(String str, List<com.ss.android.socialbase.downloader.model.fx> list) throws Exception {
        return u(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.x u(String str, List<com.ss.android.socialbase.downloader.model.fx> list, int i, boolean z2, DownloadInfo downloadInfo) throws Exception {
        com.ss.android.socialbase.downloader.network.x xVarNr;
        Exception e = null;
        for (int i2 : u(i)) {
            try {
                xVarNr = nr(str, list, i2, z2, downloadInfo);
            } catch (Exception e2) {
                e = e2;
            }
            if (xVarNr != null) {
                return xVarNr;
            }
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    private static int[] u(int i) {
        if (i == 1) {
            return new int[]{0};
        }
        if (i == 2) {
            return new int[]{1};
        }
        if (i != 3) {
            return new int[]{1, 0};
        }
        return new int[]{0, 1};
    }

    public static synchronized void u(l lVar) {
        if (lVar != null) {
            s = lVar;
            if (nr instanceof com.ss.android.socialbase.downloader.impls.b) {
                ((com.ss.android.socialbase.downloader.impls.b) nr).n();
            }
        }
    }

    public static void u(ExecutorService executorService) {
        if (executorService != null) {
            dw = executorService;
        }
    }

    private static void u(List<com.ss.android.socialbase.downloader.depend.mv> list) {
        List<com.ss.android.socialbase.downloader.depend.mv> list2 = m;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void u(boolean z2) {
        ay = z2;
    }

    public static void u(Runnable runnable) {
        u(runnable, false);
    }

    public static void u(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.jk.iz.b()) {
            runnable.run();
        } else {
            l().execute(runnable);
        }
    }

    public static Future u(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return bq().schedule(runnable, j, timeUnit);
    }

    public static void u(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            jk = iDownloadHttpService;
        }
        tk = jk != null;
    }

    public static void u(com.ss.android.socialbase.downloader.network.n nVar) {
        if (nVar != null) {
            t = nVar;
        }
    }

    private static void u(jk jkVar) {
        if (jkVar != null) {
            nr = jkVar;
        }
    }

    private static void u(t tVar) {
        if (tVar != null) {
            fx = tVar;
        }
    }

    private static void u(com.ss.android.socialbase.downloader.b.nr nrVar) {
        if (nrVar != null) {
            d = nrVar;
        }
    }

    public static void u(gi giVar) {
        h = giVar;
        com.ss.android.socialbase.downloader.n.u.u();
    }

    private static void u(n nVar) {
        if (nVar != null) {
            b = nVar;
        }
    }

    public static void u(ja jaVar) {
        if (jaVar != null) {
            pn = jaVar;
        }
    }

    private static void u(x xVar) {
        if (xVar != null) {
            qq = xVar;
        }
    }

    public static synchronized void u(Context context) {
        if (context != null) {
            if (u == null) {
                u = context.getApplicationContext();
                com.ss.android.socialbase.downloader.u.u.u().u(u);
            }
        }
    }

    public static int u(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return u(taskKey, downloadInfo.getSavePath());
    }

    public static int u(String str, String str2) {
        t tVarH = h();
        if (tVarH == null) {
            return 0;
        }
        return tVarH.u(str, str2);
    }

    public static void u(com.ss.android.socialbase.downloader.b.fx fxVar) {
        eh = fxVar;
    }

    public static void u(u uVar) {
        com.ss.android.socialbase.downloader.fx.u.u("wjd", "setIndependentServiceCreator::creator=" + uVar);
        f10604a = uVar;
    }
}
