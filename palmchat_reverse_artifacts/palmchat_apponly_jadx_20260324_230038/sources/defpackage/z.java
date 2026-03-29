package defpackage;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.lantern.analytics.anr.ANRException;
import com.zm.fda.Z2500.Z200O.O022Z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class z extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f22306a;
    public boolean b;
    public Context c;
    public List<String> d;
    public BroadcastReceiver e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            v.a("onReceive: anr", Long.valueOf(System.currentTimeMillis()));
            if (intent == null || !O022Z.h.equals(intent.getAction())) {
                return;
            }
            if (!z.this.b && Debug.isDebuggerConnected()) {
                v.h("调试状态忽略ANR(可以设置setIgnoreDebugger(true))");
                return;
            }
            try {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfoF = z.this.f(context, 10000L);
                if (processErrorStateInfoF == null) {
                    v.a("proc state is unvisiable!", new Object[0]);
                } else {
                    v.f("onAppNotResponding");
                    z.this.f22306a.a(ANRException.New(processErrorStateInfoF));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(ANRException aNRException);
    }

    public z(Context context) {
        super("|ANR-WatchDog|");
        this.b = false;
        this.d = new ArrayList();
        this.e = new a();
        this.c = context;
    }

    public final boolean c(List<String> list, String str) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().trim().contains(str)) {
                return true;
            }
        }
        return false;
    }

    public z d(b bVar) {
        this.f22306a = bVar;
        return this;
    }

    public void e(boolean z) {
        this.b = z;
    }

    public ActivityManager.ProcessErrorStateInfo f(Context context, long j) {
        int iMyPid = Process.myPid();
        if (j < 0) {
            j = 0;
        }
        v.a("to find! %s", new Object[0]);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        long j2 = j / 500;
        int i = 0;
        while (true) {
            v.a("waiting! %s", new Object[0]);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2 && iMyPid == processErrorStateInfo.pid && !c(this.d, processErrorStateInfo.shortMsg)) {
                        v.a("found! %s", processErrorStateInfo.shortMsg);
                        this.d.add(processErrorStateInfo.shortMsg);
                        return processErrorStateInfo;
                    }
                    v.a("not mind proc! %s", processErrorStateInfo.shortMsg);
                }
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            v.a("Wait", new Object[0]);
            int i2 = i + 1;
            if (i >= j2) {
                return null;
            }
            i = i2;
        }
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        v.a("ANR-WatchDog exit", new Object[0]);
        try {
            this.c.unregisterReceiver(this.e);
        } catch (Exception unused) {
        }
        return super.quit();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        super.start();
        v.f("ANR-WatchDog start");
        try {
            Handler handler = new Handler(getLooper());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(O022Z.h);
            this.c.registerReceiver(this.e, intentFilter, null, handler);
        } catch (Exception unused) {
        }
    }
}
