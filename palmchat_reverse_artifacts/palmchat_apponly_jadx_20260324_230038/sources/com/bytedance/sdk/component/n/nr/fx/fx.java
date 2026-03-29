package com.bytedance.sdk.component.n.nr.fx;

import android.text.TextUtils;
import com.bytedance.sdk.component.n.u.b;
import com.bytedance.sdk.component.n.u.pn;
import com.bytedance.sdk.component.utils.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static pn fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.bytedance.sdk.component.n.nr.u.pn(str);
    }

    private static String nr(String str) {
        b bVarB;
        pn pnVarFx = fx(str);
        if (pnVarFx == null || (bVarB = pnVarFx.b()) == null) {
            return null;
        }
        return bVarB.b();
    }

    private static boolean u(String str) {
        b bVarB;
        pn pnVarFx = fx(str);
        if (pnVarFx == null || (bVarB = pnVarFx.b()) == null) {
            return false;
        }
        return bVarB.fx();
    }

    public static void nr(String str, pn pnVar) {
        if (pnVar == null) {
            return;
        }
        u(null, str, pnVar.pn(), 100);
    }

    public static void u(String str, pn pnVar) {
        if (pnVar == null) {
            return;
        }
        u(null, str, pnVar.pn(), 6);
    }

    public static void u(String str, String str2, pn pnVar) {
        if (pnVar == null) {
            return;
        }
        u(str, str2, pnVar.pn(), 6);
    }

    private static void u(String str, String str2, String str3, int i) {
        try {
            if (u(str3) || i == 100) {
                String strNr = nr(str3);
                if (strNr == null) {
                    strNr = "";
                }
                String str4 = strNr + "log";
                if (!TextUtils.isEmpty(str)) {
                    str4 = str4 + str;
                }
                if (i == 6 || i == 100) {
                    k.nr(str4, str2);
                }
            }
        } catch (Exception unused) {
        }
    }
}
