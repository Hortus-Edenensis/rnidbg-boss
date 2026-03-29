package com.bytedance.adsdk.nr;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class my {
    public static Object u(com.bytedance.adsdk.nr.nr.u.u uVar) {
        a aVarU;
        if (uVar == null || (aVarU = u(uVar.u())) == null) {
            return null;
        }
        return aVarU.u(null, uVar.nr());
    }

    public static a u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "toNumber":
                return new mv();
            case "toString":
                return new s();
            case "formatDecimal":
                return new x();
            case "modArray":
                return new jk();
            case "find":
                return new iz();
            case "size":
                return new t();
            case "chunk":
                return new u();
            case "exist":
                return new pn();
            case "split":
                return new l();
            case "decodeUrl":
                return new nr();
            case "translate":
                return new k();
            case "encodeUrl":
                return new b();
            case "isDigit":
                return new n();
            default:
                return null;
        }
    }
}
