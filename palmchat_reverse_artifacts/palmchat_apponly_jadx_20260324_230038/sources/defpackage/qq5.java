package defpackage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qq5 {
    public static qq5 b = new qq5();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f20304a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f20305a;

        public a() {
        }
    }

    public static qq5 c() {
        return b;
    }

    public Account a(Context context) {
        if (this.f20304a == null) {
            this.f20304a = b(context);
        }
        return this.f20304a.f20305a;
    }

    public final a b(Context context) {
        a aVar = new a();
        try {
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.zenmen.palmchat.AccountType");
            LogUtil.e("SystemAccountManagerWrapper", "getAccount" + accountsByType.length);
            if (accountsByType.length > 0) {
                aVar.f20305a = accountsByType[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar;
    }

    public void d() {
        this.f20304a = null;
        LogUtil.e("SystemAccountManagerWrapper", "onAccountInfoChange");
    }
}
