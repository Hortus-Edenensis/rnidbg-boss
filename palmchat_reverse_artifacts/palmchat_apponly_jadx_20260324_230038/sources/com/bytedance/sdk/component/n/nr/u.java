package com.bytedance.sdk.component.n.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.n.u.iz;
import com.bytedance.sdk.component.n.u.pn;
import com.bytedance.sdk.component.n.u.x;
import com.bytedance.sdk.component.utils.k;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static final ConcurrentHashMap<String, nr> u = new ConcurrentHashMap<>();
    private static volatile List<com.bytedance.sdk.component.n.u.fx> nr = new ArrayList();
    private static ConcurrentHashMap<String, pn> fx = new ConcurrentHashMap<>();

    public static void b(String str) {
        fx(str).nr();
    }

    public static x fx(String str) {
        ConcurrentHashMap<String, nr> concurrentHashMap = u;
        nr nrVar = concurrentHashMap.get(str);
        if (nrVar != null) {
            return nrVar;
        }
        nr nrVar2 = new nr();
        concurrentHashMap.put(str, nrVar2);
        return nrVar2;
    }

    public static void nr(String str) {
        u(false, str);
        fx(str).u();
    }

    public static pn pn(String str) {
        pn pnVarFx = fx.get(str);
        if (pnVarFx == null && (pnVarFx = fx(str).fx()) != null) {
            fx.put(str, pnVarFx);
        }
        return pnVarFx;
    }

    public static x u(com.bytedance.sdk.component.n.u.u uVar) {
        if (uVar == null || TextUtils.isEmpty(uVar.pn()) || uVar.getContext() == null) {
            k.nr("csj_log_error", "config or adLogFrom or context is null");
            return null;
        }
        ConcurrentHashMap<String, nr> concurrentHashMap = u;
        nr nrVar = concurrentHashMap.get(uVar.pn());
        if (nrVar == null) {
            nrVar = new nr(uVar);
        } else {
            nrVar.nr(uVar);
        }
        concurrentHashMap.put(uVar.pn(), nrVar);
        return nrVar;
    }

    public static void u(iz izVar, String str) {
        fx(str).u(izVar);
    }

    public static void u(boolean z, String str) {
        fx(str).u(z);
    }

    public static List<com.bytedance.sdk.component.n.u.fx> u() {
        return nr;
    }

    public static void u(com.bytedance.sdk.component.n.u.fx fxVar) {
        if (fxVar != null) {
            nr.add(fxVar);
        }
    }

    public static boolean u(String str) {
        nr nrVar = u.get(str);
        return nrVar == null || nrVar.fx() == null || nrVar.b() == null || nrVar.pn() == null;
    }

    public static void u(String str, String str2) {
        fx(str).u(str2);
    }

    public static void u(String str, String str2, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        fx(str).u(str2, list, z, map, jSONObject);
    }

    public static void u(com.bytedance.sdk.component.n.u.nr nrVar, String str) {
        fx(str).u(nrVar);
    }
}
