package com.lantern.daemon.dp3.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.PeriodicSync;
import android.os.Build;
import android.os.Bundle;
import com.lantern.daemon.dp3.R;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AccountSync {
    public static AccountSync instance;
    public Account account;
    public Context context;

    public static AccountSync getInstance() {
        AccountSync accountSync;
        synchronized (AccountSync.class) {
            if (instance == null) {
                instance = new AccountSync();
            }
            accountSync = instance;
        }
        return accountSync;
    }

    public void init(Context context, long j) {
        String string = context.getString(R.string.account_label);
        String string2 = context.getString(R.string.account_type);
        String string3 = context.getString(R.string.account_provider);
        try {
            this.context = context.getApplicationContext();
            this.account = new Account(string, string2);
            AccountManager accountManager = AccountManager.get(this.context);
            if (accountManager.getAccountsByType(string2).length <= 0) {
                accountManager.addAccountExplicitly(this.account, null, Bundle.EMPTY);
                ContentResolver.setIsSyncable(this.account, string3, 1);
                ContentResolver.setSyncAutomatically(this.account, string3, true);
                ContentResolver.setMasterSyncAutomatically(true);
            }
            if (!ContentResolver.isSyncPending(this.account, string3)) {
                requestSync(true);
            }
            List<PeriodicSync> periodicSyncs = ContentResolver.getPeriodicSyncs(this.account, string3);
            if (periodicSyncs != null && periodicSyncs.size() > 0) {
                return;
            }
            Account account = this.account;
            Bundle bundle = Bundle.EMPTY;
            long j2 = Build.VERSION.SDK_INT < 24 ? 3600L : 900L;
            if (j <= 0) {
                j = j2;
            }
            ContentResolver.addPeriodicSync(account, string3, bundle, j);
        } catch (Exception unused) {
        }
    }

    public void requestSync(boolean z) {
        try {
            String string = this.context.getString(R.string.account_provider);
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            if (z) {
                bundle.putBoolean("require_charging", true);
            }
            ContentResolver.requestSync(this.account, string, bundle);
        } catch (Exception unused) {
        }
    }
}
