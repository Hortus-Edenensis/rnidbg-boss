package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class hx6 extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
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
        i27.e("shouldUpdateId, notifyFlag : ".concat(String.valueOf(intExtra)));
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
            i27 i27VarB = i27.b();
            o84 o84Var = "oaid".equals(stringExtra) ? i27VarB.b : "vaid".equals(stringExtra) ? i27VarB.d : "aaid".equals(stringExtra) ? i27VarB.c : "udid".equals(stringExtra) ? i27VarB.f18094a : null;
            if (o84Var == null) {
                return;
            }
            o84Var.e();
        }
    }
}
