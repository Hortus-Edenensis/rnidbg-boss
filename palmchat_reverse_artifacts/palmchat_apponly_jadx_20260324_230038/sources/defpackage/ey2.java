package defpackage;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.util.Log;
import com.lantern.daemon.jobscheduler.AliveJobService;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ey2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f17393a;

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(21)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17394a;

        public JobInfo a(JobScheduler jobScheduler, int i) {
            List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
            if (allPendingJobs == null || allPendingJobs.size() <= 0) {
                return null;
            }
            for (JobInfo jobInfo : allPendingJobs) {
                if (jobInfo.getId() == i) {
                    return jobInfo;
                }
            }
            return null;
        }

        public String b(int i) {
            Log.d(pt0.f20091a, String.format("jobName: %d", Integer.valueOf(i)));
            if (i != 0) {
                return null;
            }
            return "jobt";
        }

        public void c(Context context, int i) {
            if (i - this.f17394a == 0) {
                e(context);
            }
        }

        public void d(Context context, int i) {
            Log.i(pt0.f20091a, String.format("JobHelper init: %d", Integer.valueOf(i)));
            this.f17394a = i;
            e(context);
        }

        public void e(Context context) {
            int i = this.f17394a + 0;
            Log.i(pt0.f20091a, String.format("scheduleTimerJob jobid: %d", Integer.valueOf(i)));
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (a(jobScheduler, i) != null) {
                return;
            }
            JobInfo.Builder builder = new JobInfo.Builder(this.f17394a + 0, new ComponentName(context, (Class<?>) AliveJobService.class));
            builder.setPeriodic(3600000L);
            builder.setPersisted(true);
            builder.setRequiresCharging(false);
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setTriggerContentMaxDelay(300000L);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("type", b(0));
            builder.setExtras(persistableBundle);
            jobScheduler.schedule(builder.build());
        }
    }

    public static boolean a() {
        return false;
    }

    public static void b(Context context, int i) {
        if (a()) {
            return;
        }
        if (f17393a == null) {
            f17393a = new a();
        }
        f17393a.c(context, i);
    }

    public static void c(Context context, int i) {
        if (a()) {
            return;
        }
        if (f17393a == null) {
            f17393a = new a();
        }
        f17393a.d(context, i);
    }
}
