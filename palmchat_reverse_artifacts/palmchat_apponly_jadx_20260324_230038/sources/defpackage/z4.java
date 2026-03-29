package defpackage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.PeriodicSync;
import android.os.Build;
import android.os.Bundle;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class z4 {
    public static z4 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Account f22340a;
    public String b;

    public static z4 a() {
        z4 z4Var;
        synchronized (z4.class) {
            if (c == null) {
                c = new z4();
            }
            z4Var = c;
        }
        return z4Var;
    }

    public static void c(Context context, boolean z) {
        String string = context.getString(R.string.farmore_syncnew_label);
        String string2 = context.getString(R.string.farmore_syncnew_type);
        String string3 = context.getString(R.string.farmore_syncnew_provider);
        try {
            AccountManager accountManager = AccountManager.get(context);
            Account account = null;
            for (Account account2 : accountManager.getAccountsByType(string2)) {
                if (string.equals(account2.name)) {
                    account = account2;
                }
            }
            if (!z) {
                if (account == null || Build.VERSION.SDK_INT < 22) {
                    return;
                }
                accountManager.removeAccountExplicitly(account);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (account == null && !u4.a(string2, jCurrentTimeMillis)) {
                Account account3 = new Account(string, string2);
                if (accountManager.addAccountExplicitly(account3, null, null)) {
                    u4.b(string2, jCurrentTimeMillis);
                    account = account3;
                }
            }
            if (account != null) {
                LogUtil.d("AccountSync", "asn.1");
                ContentResolver.setSyncAutomatically(account, string3, true);
                ContentResolver.setMasterSyncAutomatically(true);
                a().b(context, account, string3);
            }
        } catch (Throwable unused) {
        }
    }

    public void b(Context context, Account account, String str) {
        try {
            this.f22340a = account;
            this.b = str;
            if (!ContentResolver.isSyncPending(account, str)) {
                LogUtil.d("AccountSync", "asn.2");
                d(true);
            }
            long jB = dt1.b(context);
            List<PeriodicSync> periodicSyncs = ContentResolver.getPeriodicSyncs(this.f22340a, str);
            boolean z = false;
            if (periodicSyncs != null && periodicSyncs.size() > 0) {
                LogUtil.d("AccountSync", "asn.3");
                if (periodicSyncs.get(0).period != jB) {
                    ContentResolver.removePeriodicSync(this.f22340a, str, Bundle.EMPTY);
                } else {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            LogUtil.d("AccountSync", "asn.4");
            Bundle bundle = new Bundle();
            bundle.putBoolean("periodic", true);
            ContentResolver.addPeriodicSync(account, str, bundle, jB);
        } catch (Exception unused) {
        }
    }

    public void d(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            if (z) {
                bundle.putBoolean("require_charging", true);
            }
            ContentResolver.requestSync(this.f22340a, this.b, bundle);
        } catch (Exception unused) {
        }
    }
}
