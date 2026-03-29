package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.daemon.doubleprocess.b;
import com.lantern.daemon.doubleprocess.c;
import com.lantern.daemon.doubleprocess.nativ.NativeDaemonAPI20;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class tt0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21062a = "bin";
    public final String b = "daemon";
    public AlarmManager c;
    public PendingIntent d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21063a;
        public final /* synthetic */ b b;

        public a(Context context, b bVar) {
            this.f21063a = context;
            this.b = bVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            new NativeDaemonAPI20(this.f21063a).doDaemon(this.f21063a.getPackageName(), this.b.b.b, new File(this.f21063a.getDir("bin", 0), "daemon").getAbsolutePath());
        }
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void a(Context context, b bVar) {
        Intent intent = new Intent();
        intent.putExtra(az.at, "persistent");
        intent.setComponent(new ComponentName(context.getPackageName(), bVar.f7534a.b));
        context.startService(intent);
        Process.killProcess(Process.myPid());
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void b(Context context, b bVar) {
        h(context, bVar.b.b);
        a aVar = new a(context, bVar);
        aVar.setPriority(10);
        aVar.start();
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public boolean c(Context context) {
        return j(context);
    }

    @Override // com.lantern.daemon.doubleprocess.c
    public void d() {
        this.c.setRepeating(3, SystemClock.elapsedRealtime(), 100L, this.d);
        Process.killProcess(Process.myPid());
    }

    public final void e(Context context, String str, File file, String str2) throws InterruptedException, IOException {
        f(file, context.getAssets().open(str), str2);
    }

    public final void f(File file, InputStream inputStream, String str) throws InterruptedException, IOException {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                fileOutputStream.close();
                inputStream.close();
                Runtime.getRuntime().exec("chmod " + str + " " + absolutePath).waitFor();
                return;
            }
            fileOutputStream.write(bArr, 0, i);
        }
    }

    public final boolean g(Context context, String str, String str2) {
        try {
            return Arrays.asList(context.getAssets().list(str)).contains(str2);
        } catch (IOException unused) {
            return false;
        }
    }

    public final void h(Context context, String str) {
        if (this.c == null) {
            this.c = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        }
        if (this.d == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), str));
            intent.setFlags(16);
            this.d = PendingIntent.getService(context, 0, intent, 0);
        }
        this.c.cancel(this.d);
    }

    public final boolean i(Context context, String str, String str2, String str3) {
        String str4;
        File file = new File(context.getDir(str, 0), str3);
        if (file.exists()) {
            return true;
        }
        try {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str2)) {
                str4 = "";
            } else {
                str4 = str2 + File.separator;
            }
            sb.append(str4);
            sb.append(str3);
            e(context, sb.toString(), file, "700");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean j(Context context) {
        String str = Build.CPU_ABI;
        new ArrayList();
        String str2 = "armeabi-v7a";
        if (!str.startsWith("armeabi-v7a")) {
            str2 = "arm64-v8a";
            if (!str.startsWith("arm64-v8a")) {
                str2 = "armeabi";
            }
        }
        return i(context, "bin", g(context, str2, "daemon") ? str2 : "armeabi", "daemon");
    }
}
