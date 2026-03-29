package com.zm.fda;

import com.zm.fda.busi.IPubParams;
import com.zm.fda.oaid.Z0225;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z25O0 {
    public static String a(IPubParams iPubParams) {
        String str = Z0225.oaid;
        if (com.zm.fda.oaid.ZZ00Z.a(str) || iPubParams == null) {
            return str;
        }
        String oaid = iPubParams.getOaid();
        return com.zm.fda.oaid.ZZ00Z.a(oaid) ? oaid : str;
    }
}
