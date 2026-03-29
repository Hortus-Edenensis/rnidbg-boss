package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class oe {
    public static oe k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19743a;
    public int b;
    public int c;
    public Handler d;
    public d f;
    public HandlerThread g;
    public c h;
    public boolean e = true;
    public final int i = 10;
    public final long j = 86400000;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                oe oeVar = oe.this;
                oeVar.c = (oeVar.c + 1) % 10;
            } else if (i == 1) {
                oe.this.o();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19745a;

        public b(d dVar) {
            this.f19745a = dVar;
            put("action", "ANR");
            put("shortMsg", TextUtils.isEmpty(dVar.b) ? "ProcessErrorStateInfo is NULL" : dVar.b);
            put(SharePluginInfo.ISSUE_TRACE_STACK, dVar.d);
            put("processName", dVar.f19747a);
            put("longMsg", dVar.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<oe> f19746a;

        public c(Looper looper) {
            super(looper);
        }

        public void a(oe oeVar) {
            this.f19746a = new WeakReference<>(oeVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            oe oeVar = this.f19746a.get();
            if (oeVar == null || !oeVar.e) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                oeVar.b = this.f19746a.get().c;
                oeVar.d.sendEmptyMessage(0);
                sendEmptyMessageDelayed(1, 5000L);
            } else {
                if (i != 1) {
                    return;
                }
                if (oeVar.c == oeVar.b) {
                    oeVar.e = false;
                    LogUtil.i("AnrWatchHelper", "anr happened in here");
                    oeVar.l();
                }
                sendEmptyMessage(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19747a;
        public String b;
        public String c;
        public String d;

        public d() {
        }
    }

    public static oe i() {
        if (k == null) {
            synchronized (oe.class) {
                if (k == null) {
                    k = new oe();
                }
            }
        }
        return k;
    }

    public static Map<String, String> k() {
        HashMap map = new HashMap();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces != null) {
            Thread thread = Looper.getMainLooper().getThread();
            if (thread != null && !allStackTraces.containsKey(thread)) {
                allStackTraces.put(thread, thread.getStackTrace());
            }
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                try {
                    new JSONObject().put("threadName", entry.getKey().toString());
                    StackTraceElement[] value = entry.getValue();
                    StringBuilder sb = new StringBuilder();
                    for (StackTraceElement stackTraceElement : value) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                    map.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    public final ActivityManager.ProcessErrorStateInfo h() {
        ActivityManager activityManager = (ActivityManager) this.f19743a.getSystemService("activity");
        int i = 0;
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        while (true) {
            LogUtil.i("AnrWatchHelper", "waiting");
            try {
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.ProcessErrorStateInfo next = it.next();
                        if (next.condition == 2) {
                            LogUtil.i("AnrWatchHelper", "found");
                            processErrorStateInfo = next;
                            break;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (processErrorStateInfo != null) {
                return processErrorStateInfo;
            }
            try {
                Thread.sleep(500L);
                LogUtil.i("AnrWatchHelper", "Thread sleep" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i2 = i + 1;
            if (i >= 60) {
                LogUtil.i("AnrWatchHelper", "end");
                return null;
            }
            i = i2;
        }
    }

    public final String j(Map<String, String> map) {
        String str = null;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (str2.startsWith("main(")) {
                    str = map.get(str2);
                }
            }
        }
        return str;
    }

    public void l() {
        Map<String, String> mapK = k();
        String strJ = j(mapK);
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoH = h();
        if (mapK != null && mapK.size() > 0) {
            d dVar = new d();
            dVar.d = strJ;
            if (processErrorStateInfoH == null || processErrorStateInfoH.pid != Process.myPid()) {
                q(dVar);
            } else {
                LogUtil.i("AnrWatchHelper", "error=================================");
                dVar.f19747a = processErrorStateInfoH.processName;
                String str = processErrorStateInfoH.shortMsg;
                dVar.b = str;
                dVar.c = processErrorStateInfoH.longMsg;
                d dVar2 = this.f;
                if (dVar2 == null || !str.equals(dVar2.b)) {
                    q(dVar);
                }
                this.f = dVar;
            }
        }
        m();
    }

    public final void m() {
        this.b = 0;
        this.c = 0;
        this.e = true;
    }

    public void n(Context context) {
        if (this.g != null) {
            LogUtil.i("AnrWatchHelper", "anr watch thread has started, no need to start it");
            this.d.removeMessages(1);
            return;
        }
        LogUtil.i("AnrWatchHelper", "start anr watch thread");
        this.f19743a = context.getApplicationContext();
        HandlerThread handlerThreadA = lg2.a("check-message-coming");
        this.g = handlerThreadA;
        handlerThreadA.start();
        c cVar = new c(this.g.getLooper());
        this.h = cVar;
        cVar.a(this);
        this.d = new a(Looper.getMainLooper());
        this.h.sendEmptyMessage(0);
    }

    public void o() {
        if (this.g == null) {
            LogUtil.i("AnrWatchHelper", "hasn't start anr watch thread, no need to stop it");
            return;
        }
        LogUtil.i("AnrWatchHelper", "stop anr watch thread");
        this.g.quit();
        this.g = null;
    }

    public void p() {
        this.d.sendEmptyMessageDelayed(1, 5000L);
    }

    public final void q(d dVar) {
        long jLongValue;
        String str;
        String strI = r75.i(AppContext.getContext(), "sp_key_anr_upload");
        long jLongValue2 = 0;
        if (strI != null) {
            try {
                String[] strArrSplit = strI.split("_");
                String str2 = strArrSplit[0];
                str = strArrSplit[1];
                jLongValue = Long.valueOf(str2).longValue();
            } catch (Exception e) {
                e = e;
                jLongValue = 0;
            }
            try {
                jLongValue2 = Long.valueOf(str).longValue();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } else {
            jLongValue = 0;
        }
        long jB = ir5.b();
        if ((jLongValue2 < 10 || Math.abs(jB - jLongValue) > 86400000) && !TextUtils.isEmpty(dVar.b)) {
            LogUtil.i("AnrWatchHelper", LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, new b(dVar), (Throwable) null);
            long j = 1;
            if (Math.abs(jB - jLongValue) > 86400000) {
                jLongValue = jB;
            } else {
                j = 1 + jLongValue2;
            }
            r75.r(AppContext.getContext(), "sp_key_anr_upload", String.valueOf(jLongValue) + "_" + j);
        }
    }
}
