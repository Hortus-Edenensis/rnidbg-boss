package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ra7 extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        boolean zContains = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        jc7.e("shouldUpdateId, notifyFlag : ".concat(String.valueOf(intExtra)));
        if (intExtra == 1) {
            if (TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                zContains = true;
            }
        } else if (intExtra == 2) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
            if (stringArrayListExtra != null) {
                zContains = stringArrayListExtra.contains(context.getPackageName());
            }
        } else if (intExtra == 0) {
        }
        if (zContains) {
            String stringExtra = intent.getStringExtra("openIdType");
            jc7 jc7VarB = jc7.b();
            eu6 eu6Var = "oaid".equals(stringExtra) ? jc7VarB.b : "vaid".equals(stringExtra) ? jc7VarB.d : "aaid".equals(stringExtra) ? jc7VarB.c : "udid".equals(stringExtra) ? jc7VarB.f18384a : null;
            if (eu6Var == null) {
                return;
            }
            eu6Var.e();
        }
    }
}
