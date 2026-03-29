package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.push.dz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class XMJobService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Service f11666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private IBinder f869a = null;

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(21)
    public static class a extends JobService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Binder f11667a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Handler f870a;

        /* JADX INFO: renamed from: com.xiaomi.push.service.XMJobService$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class HandlerC0926a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            JobService f11668a;

            public HandlerC0926a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f11668a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                com.xiaomi.channel.commonutils.logger.b.m74a("Job finished " + jobParameters.getJobId());
                this.f11668a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    dz.a(false);
                }
            }
        }

        public a(Service service) {
            this.f11667a = null;
            this.f11667a = (Binder) com.xiaomi.push.aw.a((Object) this, "onBind", new Intent());
            com.xiaomi.push.aw.a((Object) this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f870a == null) {
                this.f870a = new HandlerC0926a(this);
            }
            Handler handler = this.f870a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m74a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f869a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f869a = new a(this).f11667a;
        f11666a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f11666a = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (com.xiaomi.push.j.m651a((Context) this)) {
            return iOnStartCommand;
        }
        return 2;
    }
}
