package defpackage;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class bc7 extends q17 {
    public final dw6 c;

    public bc7(dw6 dw6Var) {
        this.c = dw6Var;
    }

    @Override // defpackage.q17
    public final void h(String str, String str2, boolean z, byte b) {
        dw6 dw6Var;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f() != -1 && b >= f() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (dw6Var = this.c) != null) {
            dw6Var.b(str, str2, b, k());
        }
        if (!z || i() == -1 || b < i()) {
            return;
        }
        if (b == 1) {
            Log.v(str, str2);
            return;
        }
        if (b == 2) {
            Log.d(str, str2);
            return;
        }
        if (b == 3) {
            Log.i(str, str2);
        } else if (b == 4) {
            Log.w(str, str2);
        } else {
            if (b != 5) {
                return;
            }
            Log.e(str, str2);
        }
    }
}
