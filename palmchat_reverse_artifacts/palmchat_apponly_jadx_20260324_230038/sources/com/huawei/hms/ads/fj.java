package com.huawei.hms.ads;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class fj extends ff {
    private fj() {
    }

    public static fm Code() {
        return new fj();
    }

    @Override // com.huawei.hms.ads.fm
    public fm Code(String str, String str2) {
        fm fmVar = this.Code;
        if (fmVar != null) {
            fmVar.Code(str, str2);
        }
        return this;
    }

    @Override // com.huawei.hms.ads.fm
    public void Code(fo foVar, int i, String str) {
        if (foVar == null) {
            return;
        }
        Code(foVar.V(), i, str);
        fm fmVar = this.Code;
        if (fmVar != null) {
            fmVar.Code(foVar, i, str);
        }
    }

    private void Code(String str, int i, String str2) {
        if (str == null) {
            return;
        }
        if (i == 3) {
            Log.d(str2, str);
            return;
        }
        if (i != 4) {
            if (i == 5) {
                Log.w(str2, str);
                return;
            } else if (i == 6) {
                Log.e(str2, str);
                return;
            }
        }
        Log.i(str2, str);
    }
}
