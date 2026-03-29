package com.zm.fda.Z2500.Z200O;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.zm.fda.Z2500.Z0225;
import com.zm.fda.utils.EventLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z extends HandlerThread {
    public static final String f = "fda_crash_AnrWd";
    public static final String g = "FDA-ANR";
    public static final String h = "android.intent.action.ANR";
    public static final String i = "/data/anr/";
    public static final String j = "trace";
    public static final long k = 10000;
    public static final long l = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16694a;
    public Z0225 b;
    public List<String> c;
    public FileObserver d;
    public BroadcastReceiver e;

    /* JADX INFO: compiled from: SearchBox */
    public class OO22Z extends BroadcastReceiver {
        public OO22Z() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            EventLog.d(O022Z.f, "onReceive action:", action);
            if (TextUtils.equals(action, O022Z.h)) {
                O022Z.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ZZ00Z extends FileObserver {
        public ZZ00Z(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if (str != null && str.contains("trace")) {
                O022Z.this.a();
            }
        }
    }

    public O022Z(Context context, Z0225 z0225) {
        super(g);
        this.c = new CopyOnWriteArrayList();
        this.f16694a = context;
        this.b = z0225;
    }

    private void b() {
        try {
            this.e = new OO22Z();
            Handler handler = new Handler(getLooper());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(h);
            this.f16694a.registerReceiver(this.e, intentFilter, null, handler);
            EventLog.d(f, "registerReceiver");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c() {
        try {
            ZZ00Z zz00z = new ZZ00Z(i);
            this.d = zz00z;
            zz00z.startWatching();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        try {
            BroadcastReceiver broadcastReceiver = this.e;
            if (broadcastReceiver != null) {
                this.f16694a.unregisterReceiver(broadcastReceiver);
            }
            FileObserver fileObserver = this.d;
            if (fileObserver != null) {
                fileObserver.stopWatching();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.quit();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        super.start();
        if (this.f16694a == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            b();
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            ActivityManager.ProcessErrorStateInfo processErrorStateInfoA = a(10000L);
            if (processErrorStateInfoA == null) {
                return;
            }
            this.c.clear();
            Z0225 z0225 = this.b;
            if (z0225 != null) {
                z0225.a(com.zm.fda.Z2500.Z200O.ZZ00Z.a(processErrorStateInfoA));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private ActivityManager.ProcessErrorStateInfo a(long j2) {
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) this.f16694a.getSystemService("activity");
        long j3 = j2 / 500;
        int i2 = 0;
        while (true) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null && processesInErrorState.size() > 0) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2 && iMyPid == processErrorStateInfo.pid && !a(this.c, processErrorStateInfo.shortMsg)) {
                        this.c.add(processErrorStateInfo.shortMsg);
                        return processErrorStateInfo;
                    }
                }
            }
            try {
                Thread.sleep(500L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            int i3 = i2 + 1;
            if (i2 >= j3) {
                return null;
            }
            i2 = i3;
        }
    }

    private boolean a(List<String> list, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().trim().contains(str)) {
                return true;
            }
        }
        return false;
    }
}
