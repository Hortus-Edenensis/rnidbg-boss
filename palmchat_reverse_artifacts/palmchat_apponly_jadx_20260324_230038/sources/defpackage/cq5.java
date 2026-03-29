package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.RemoteException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cq5 extends dq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16900a;

    public cq5(Context context) {
        this.f16900a = context;
    }

    @Override // defpackage.yo2
    public void cancelSync(ap2 ap2Var) {
        z4.a().d(true);
    }

    public final void onManualStart() {
        synchronized (this) {
            new HashMap().put("type", "account_manual_start");
        }
    }

    @Override // defpackage.yo2
    public void onUnsyncableAccount(zo2 zo2Var) throws RemoteException {
        LogUtil.d("AccountSync", "sasn.onUnsyncableAccount");
        zo2Var.c(false);
    }

    @Override // defpackage.yo2
    public void startSync(ap2 ap2Var, String str, Account account, Bundle bundle) throws RemoteException {
        if (bundle == null || !bundle.getBoolean("force", false)) {
            ap2Var.a(new SyncResult());
            return;
        }
        if (bundle.getBoolean("ignore_backoff", false)) {
            ap2Var.a(SyncResult.ALREADY_IN_PROGRESS);
        } else {
            ap2Var.a(new SyncResult());
            z4.a().d(true);
        }
        onManualStart();
    }
}
