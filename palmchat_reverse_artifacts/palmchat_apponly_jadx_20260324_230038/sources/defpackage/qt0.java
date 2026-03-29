package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.daemon.doubleprocess.c;
import com.lantern.daemon.doubleprocess.nativ.NativeDaemonAPI21;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class qt0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlarmManager f20314a;
    public PendingIntent b;
    public com.lantern.daemon.doubleprocess.b c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20315a;

        public a(Context context) {
            this.f20315a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            File dir = this.f20315a.getDir("indicators", 0);
            new NativeDaemonAPI21(this.f20315a).doDaemon(new File(dir, "indicator_p").getAbsolutePath(), new File(dir, "indicator_d").getAbsolutePath(), new File(dir, "observer_p").getAbsolutePath(), new File(dir, "observer_d").getAbsolutePath());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20316a;

        public b(Context context) {
            this.f20316a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            File dir = this.f20316a.getDir("indicators", 0);
            new NativeDaemonAPI21(this.f20316a).doDaemon(new File(dir, "indicator_d").getAbsolutePath(), new File(dir, "indicator_p").getAbsolutePath(), new File(dir, "observer_d").getAbsolutePath(), new File(dir, "observer_p").getAbsolutePath());
        }
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void a(Context context, com.lantern.daemon.doubleprocess.b bVar) {
        Intent intent = new Intent();
        intent.putExtra(az.at, "persistent");
        intent.setComponent(new ComponentName(context.getPackageName(), bVar.f7534a.b));
        context.startService(intent);
        f(context, bVar.f7534a.b);
        b bVar2 = new b(context);
        bVar2.setPriority(10);
        bVar2.start();
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void b(Context context, com.lantern.daemon.doubleprocess.b bVar) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), bVar.b.b));
        context.startService(intent);
        f(context, bVar.f7534a.b);
        a aVar = new a(context);
        aVar.setPriority(10);
        aVar.start();
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public boolean c(Context context) {
        return g(context);
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void d() {
        this.f20314a.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.b);
        com.lantern.daemon.doubleprocess.b bVar = this.c;
        if (bVar != null) {
            bVar.getClass();
        }
        Process.killProcess(Process.myPid());
    }

    public final void e(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.exists()) {
            return;
        }
        file2.createNewFile();
    }

    public final void f(Context context, String str) {
        if (this.f20314a == null) {
            this.f20314a = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        }
        if (this.b == null) {
            Intent intent = new Intent();
            intent.putExtra(az.at, "persistent");
            intent.setComponent(new ComponentName(context.getPackageName(), str));
            intent.setFlags(16);
            this.b = PendingIntent.getService(context, 0, intent, 0);
        }
        this.f20314a.cancel(this.b);
    }

    public final boolean g(Context context) {
        File dir = context.getDir("indicators", 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            e(dir, "indicator_p");
            e(dir, "indicator_d");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
