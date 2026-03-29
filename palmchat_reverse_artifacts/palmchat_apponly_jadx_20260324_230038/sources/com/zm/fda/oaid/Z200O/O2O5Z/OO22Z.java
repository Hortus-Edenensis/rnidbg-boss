package com.zm.fda.oaid.Z200O.O2O5Z;

import android.content.Context;
import android.provider.Settings;
import com.zm.fda.oaid.Z25O0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {
    public static void a(Context context, Z25O0 z25o0) {
        String string;
        if (z25o0 == null) {
            return;
        }
        try {
            string = Settings.Global.getString(context.getContentResolver(), com.zm.fda.oaid.Z2500.OO22Z.a("b2FpZA=="));
        } catch (Throwable th) {
            th.printStackTrace();
            string = "";
        }
        z25o0.a(string);
    }
}
