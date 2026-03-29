package com.bytedance.sdk.openadsdk.core.l.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.sdk.component.a.nr.fx] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.a.nr.b] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.sdk.component.a.nr.pn] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void u(int i, String str, Map<String, Object> map, pn pnVar) {
        ?? Fx;
        if (i == 0) {
            Fx = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().fx();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    Fx.u(entry.getKey(), entry.getValue().toString());
                }
            }
        } else if (i != 1) {
            Fx = 0;
        } else {
            Fx = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr();
            HashMap map2 = new HashMap();
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                map2.put(entry2.getKey(), entry2.getValue().toString());
            }
            Fx.u(map2);
        }
        if (Fx != 0) {
            Fx.u(str);
            u(Fx.u(), pnVar);
        }
    }

    public static void u(String str, byte[] bArr, String str2, int i, pn pnVar) {
        if (bArr == null) {
            if (pnVar != null) {
                pnVar.u(new Exception("request data is null"));
            }
        } else {
            com.bytedance.sdk.component.a.nr.pn pnVarNr = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr();
            pnVarNr.u(str);
            pnVarNr.u(str2, bArr);
            u(pnVarNr.u(), pnVar);
        }
    }

    private static void u(com.bytedance.sdk.component.a.nr nrVar, pn pnVar) {
        String strValueOf;
        if (nrVar != null && nrVar.a()) {
            if (pnVar != null) {
                pnVar.u(nrVar.pn());
                return;
            }
            return;
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(nrVar != null && nrVar.fx() != null ? nrVar.fx() : null);
        if (pnVar != null) {
            if (zIsEmpty) {
                strValueOf = nrVar.fx();
            } else {
                strValueOf = nrVar != null ? String.valueOf(nrVar.nr()) : "";
            }
            pnVar.u(new Exception(strValueOf));
        }
    }
}
