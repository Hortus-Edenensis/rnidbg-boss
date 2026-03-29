package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.dz;
import com.xiaomi.push.service.XMJobService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
@TargetApi(21)
public class eb implements dz.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    JobScheduler f11532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Context f359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f360a = false;

    public eb(Context context) {
        this.f359a = context;
        this.f11532a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    public void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f359a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + builder.build().getId() + " in " + j);
        this.f11532a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.dz.a
    public void a(boolean z) {
        if (z || this.f360a) {
            long jB = fg.b();
            if (z) {
                a();
                jB -= SystemClock.elapsedRealtime() % jB;
            }
            this.f360a = true;
            a(jB);
        }
    }

    @Override // com.xiaomi.push.dz.a
    public void a() {
        this.f360a = false;
        this.f11532a.cancel(1);
    }

    @Override // com.xiaomi.push.dz.a
    /* JADX INFO: renamed from: a */
    public boolean mo396a() {
        return this.f360a;
    }
}
