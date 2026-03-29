package defpackage;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.text.TextUtils;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.account.SyncService;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class aq5 extends AbstractThreadedSyncAdapter {
    public static String d = SyncService.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1554a;
    public long b;
    public Context c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", "accountSync onPerformSync");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", "accountSync onPerformSync | not login");
        }
    }

    public aq5(Context context, boolean z) {
        super(context, z);
        this.f1554a = 0L;
        this.b = 240000L;
        this.c = context;
    }

    public final void a(Account account, Context context) {
        LogUtil.i(d, 3, new a(), (Throwable) null);
        if (!(TextUtils.isEmpty(AccountUtils.p(context)) || TextUtils.isEmpty(AccountUtils.o(context)))) {
            context.sendBroadcast(new Intent("com.zenmen.palmchat.daemon.accountSync"));
        } else {
            LogUtil.i(d, 3, new b(), (Throwable) null);
            AccountUtils.w(context, account);
        }
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        if (Math.abs(this.f1554a - System.currentTimeMillis()) > this.b) {
            this.f1554a = System.currentTimeMillis();
            try {
                a(account, this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
