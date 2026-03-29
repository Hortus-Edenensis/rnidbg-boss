package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class lw6 extends q17 {
    @Override // defpackage.q17
    public void h(String str, String str2, boolean z, byte b) {
        if ((b >= i() || i() != -1) && z) {
            if (k17.k() || k17.l()) {
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
    }
}
