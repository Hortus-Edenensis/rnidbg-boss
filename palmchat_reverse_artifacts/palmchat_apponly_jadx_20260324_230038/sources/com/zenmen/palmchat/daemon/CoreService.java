package com.zenmen.palmchat.daemon;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.messaging.MessagingService;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CoreService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ServiceConnection f13874a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static class InnerService extends Service {
        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) {
            startForeground(10001, new Notification());
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(21)
    public static class JobSchedulerService extends JobService {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "JobSheduler onStartJob");
            }
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) {
            return 1;
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            LogUtil.i("CoreService", 3, new a(), (Throwable) null);
            sendBroadcast(new Intent("com.zenmen.palmchat.daemon.jobsheduler"));
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtil.d("CoreService", "onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtil.d("CoreService", "onServiceDisconnected");
            CoreService.this.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13877a;

        public b(String str) {
            this.f13877a = str;
            put("action", "startMessageService reason =  " + str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f13878a;

        public c(Exception exc) {
            this.f13878a = exc;
            put("action", "startMessageService exception =  " + exc.toString());
        }
    }

    public final void b() {
        LogUtil.d("CoreService", "bindMessageService");
        try {
            bindService(new Intent(this, (Class<?>) MessagingService.class), this.f13874a, 1);
        } catch (Exception unused) {
        }
    }

    public final void c(Intent intent) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onStartCommand, reason = ");
            sb.append(intent == null ? "" : intent.getStringExtra("ACTION_KEY_START"));
            LogUtil.d("CoreService", sb.toString());
            Intent intent2 = new Intent(this, (Class<?>) MessagingService.class);
            if (intent != null) {
                String stringExtra = intent.getStringExtra("ACTION_KEY_START");
                intent2.putExtra("extra_reason", stringExtra);
                LogUtil.i("CoreService", 3, new b(stringExtra), (Throwable) null);
            }
            startService(intent2);
        } catch (Exception e) {
            LogUtil.i("CoreService", 3, new c(e), (Throwable) null);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LogUtil.d("CoreService", "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        LogUtil.d("CoreService", "onCreate");
        super.onCreate();
        b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogUtil.d("CoreService", "onDestroy");
        unbindService(this.f13874a);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 1;
        }
        c(intent);
        return 1;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        Log.d("CoreService", "onTrimMemory---" + i);
        if (i == 15 || i == 60) {
            System.gc();
        }
        super.onTrimMemory(i);
    }
}
