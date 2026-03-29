package defpackage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.daemon.PersistentService;
import com.lantern.daemon.doubleprocess.AssistantReceiver;
import com.lantern.daemon.doubleprocess.AssistantService;
import com.lantern.daemon.doubleprocess.PersistentReceiver;
import com.lantern.daemon.doubleprocess.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class pt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20091a = "pt0";
    public static b b;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public jl2 f20092a;
        public Context b;
        public com.lantern.daemon.doubleprocess.a c;

        public static void h(Context context, int i) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(context, (Class<?>) PersistentService.class);
            intent.putExtra(az.at, NotificationCompat.CATEGORY_ALARM);
            PendingIntent service = PendingIntent.getService(context, 1024, intent, 134217728);
            alarmManager.cancel(service);
            alarmManager.setInexactRepeating(2, SystemClock.elapsedRealtime(), i, service);
        }

        public final com.lantern.daemon.doubleprocess.b b(Context context) {
            String packageName = context.getPackageName();
            return new com.lantern.daemon.doubleprocess.b(new b.a(packageName + ":persistent", PersistentService.class.getCanonicalName(), PersistentReceiver.class.getCanonicalName()), new b.a(packageName + ":assistant", AssistantService.class.getCanonicalName(), AssistantReceiver.class.getCanonicalName()), null);
        }

        public final void c() {
            f(this.b);
            e(this.b);
            h(this.b, 3600000);
            try {
                Intent intent = new Intent(this.b, (Class<?>) PersistentService.class);
                intent.putExtra(az.at, "startService");
                this.b.startService(intent);
            } catch (Exception e) {
                Log.e(pt0.f20091a, "doStart: ", e);
            }
        }

        public String d(Context context) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
        }

        public void e(Context context) {
            ey2.c(context, 67890000);
        }

        public final void f(Context context) {
            try {
                String packageName = context.getPackageName();
                String strD = d(context);
                String str = packageName + ".sync";
                AccountManager accountManager = AccountManager.get(context);
                Account account = null;
                for (Account account2 : accountManager.getAccountsByType(str)) {
                    if (strD.equals(account2.name)) {
                        account = account2;
                    }
                }
                if (account == null) {
                    Account account3 = new Account(strD, str);
                    if (accountManager.addAccountExplicitly(account3, null, null)) {
                        account = account3;
                    }
                }
                if (account != null) {
                    String str2 = packageName + ".sync.provider";
                    ContentResolver.setSyncAutomatically(account, str2, true);
                    ContentResolver.addPeriodicSync(account, str2, Bundle.EMPTY, 3600L);
                }
            } catch (Exception e) {
                Log.e(pt0.f20091a, "initSyncAccount: ", e);
            }
        }

        public void g(String str) {
            jl2 jl2Var = this.f20092a;
            if (jl2Var != null) {
                jl2Var.a(str);
            }
            Log.i(pt0.f20091a, String.format("onLive: %s, version %s", str, "1.1.0.8"));
        }

        public b(Context context, jl2 jl2Var) {
            this.b = context;
            this.f20092a = jl2Var;
            if (Build.VERSION.SDK_INT < 26) {
                com.lantern.daemon.doubleprocess.a aVar = new com.lantern.daemon.doubleprocess.a(b(context));
                this.c = aVar;
                aVar.c(context);
            }
        }
    }

    public static void a(Context context, jl2 jl2Var) {
        b = new b(context, jl2Var);
    }

    public static void b(String str) {
        b bVar = b;
        if (bVar == null) {
            return;
        }
        bVar.g(str);
    }

    public static void c() {
        b bVar = b;
        if (bVar == null) {
            return;
        }
        bVar.c();
    }
}
