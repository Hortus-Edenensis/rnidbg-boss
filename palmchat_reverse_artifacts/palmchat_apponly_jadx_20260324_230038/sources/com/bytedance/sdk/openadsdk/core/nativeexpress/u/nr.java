package com.bytedance.sdk.openadsdk.core.nativeexpress.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.a.nr.b;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.gi.pn;
import com.bytedance.sdk.openadsdk.core.kj.tm;
import com.bytedance.sdk.openadsdk.core.n;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static volatile nr u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
    }

    private void nr(String str, String str2, String str3, String str4, String str5) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.u.u uVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.u.u();
        uVar.fx(str).pn(str3).b(str4).nr(str2).u(str5).u(Long.valueOf(System.currentTimeMillis()));
        fx.u().u(uVar, false);
        nr();
    }

    public static nr u() {
        if (u == null) {
            synchronized (nr.class) {
                if (u == null) {
                    u = new nr();
                }
            }
        }
        return u;
    }

    public void u(tm tmVar, String str, String str2) {
        if (tmVar == null) {
            return;
        }
        if (TextUtils.isEmpty(tmVar.u())) {
            k.nr("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        final String str3 = str2 + "_" + tmVar.u();
        final String strFx = tmVar.fx();
        final String strNr = tmVar.nr();
        final String strB = tmVar.b();
        if (TextUtils.isEmpty(str) && str2.equals("ad")) {
            str = n.o().c();
        }
        final String str4 = str;
        x.u(new a("saveUGenTemplate") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.u.nr.1
            @Override // java.lang.Runnable
            public void run() {
                nr.this.u(str3, strFx, strNr, strB, str4);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr() {
        int iE = dw.nr().e();
        if (iE <= 0) {
            iE = 100;
        }
        List<com.bytedance.sdk.openadsdk.core.nativeexpress.u.u> listNr = fx.u().nr();
        if (listNr == null || listNr.isEmpty() || iE >= listNr.size()) {
            if (listNr != null) {
                listNr.size();
                return;
            }
            return;
        }
        int size = (int) (listNr.size() - (iE * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.openadsdk.core.nativeexpress.u.u uVar : listNr) {
            treeMap.put(uVar.b(), uVar);
        }
        HashSet hashSet = new HashSet();
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                com.bytedance.sdk.openadsdk.core.nativeexpress.u.u uVar2 = (com.bytedance.sdk.openadsdk.core.nativeexpress.u.u) entry.getValue();
                if (uVar2 != null) {
                    hashSet.add(uVar2.u());
                }
            }
        }
        u(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2, String str3, String str4, String str5) {
        if (u(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            nr(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            u(str2, str, str3, str5, (u) null);
        } else {
            nr(str2, str3, str5, str4, str);
        }
    }

    private void u(final String str, final String str2, final String str3, final String str4, final u uVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.component.a.nr.fx fxVarFx = pn.u().nr().fx();
        fxVarFx.u(str);
        fxVarFx.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.u.nr.2
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                if (nrVar != null && nrVar.a()) {
                    String strPn = nrVar.pn();
                    if (TextUtils.isEmpty(strPn)) {
                        return;
                    }
                    fx.u().u(new com.bytedance.sdk.openadsdk.core.nativeexpress.u.u().u(str2).nr(str3).fx(str).pn(str4).b(strPn).u(Long.valueOf(System.currentTimeMillis())), false);
                    nr.this.nr();
                    if (uVar != null) {
                        try {
                            new JSONObject(strPn);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(b bVar, IOException iOException) {
                if (uVar != null) {
                    iOException.getMessage();
                }
            }
        });
    }

    public Set<com.bytedance.sdk.openadsdk.core.nativeexpress.u.u> u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return fx.u().u(str);
    }

    public String u(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.u.u uVarU = u(str + "_" + str2, str3);
        if (uVarU == null) {
            return null;
        }
        u(uVarU);
        return uVarU.pn();
    }

    private com.bytedance.sdk.openadsdk.core.nativeexpress.u.u u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return fx.u().u(str, str2);
    }

    private void u(final com.bytedance.sdk.openadsdk.core.nativeexpress.u.u uVar) {
        uVar.u(Long.valueOf(System.currentTimeMillis()));
        x.u(new a("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.u.nr.3
            @Override // java.lang.Runnable
            public void run() {
                fx.u().u(uVar, true);
            }
        }, 10);
    }

    public void u(Set<String> set) {
        try {
            fx.u().u(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
