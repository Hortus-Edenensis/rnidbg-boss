package com.zx.a.I8b7;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class p0 implements k0 {
    @Override // com.zx.a.I8b7.k0
    public void a(int i, String str, String str2) {
        if (i == 1) {
            Log.v(str, str2);
            return;
        }
        if (i == 2) {
            Log.d(str, str2);
            return;
        }
        if (i == 3) {
            Log.i(str, str2);
        } else if (i == 4) {
            Log.w(str, str2);
        } else {
            if (i != 5) {
                return;
            }
            Log.e(str, str2);
        }
    }
}
