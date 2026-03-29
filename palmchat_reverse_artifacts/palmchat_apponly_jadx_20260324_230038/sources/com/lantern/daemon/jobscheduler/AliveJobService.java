package com.lantern.daemon.jobscheduler;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.PersistableBundle;
import defpackage.ey2;
import defpackage.pt0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(21)
public class AliveJobService extends JobService {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JobParameters f7537a;

        public a(JobParameters jobParameters) {
            this.f7537a = jobParameters;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AliveJobService.this.jobFinished(this.f7537a, true);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        pt0.b(extras != null ? extras.getString("type") : null);
        new Handler().postDelayed(new a(jobParameters), 100L);
        ey2.b(this, jobParameters.getJobId());
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
