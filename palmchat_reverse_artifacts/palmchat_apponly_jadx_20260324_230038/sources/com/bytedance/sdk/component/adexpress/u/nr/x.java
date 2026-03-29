package com.bytedance.sdk.component.adexpress.u.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.k;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private static volatile x u;
    private AtomicBoolean nr = new AtomicBoolean(false);

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr();

        void u();
    }

    private x() {
    }

    private JSONObject fx(String str) {
        com.bytedance.sdk.component.adexpress.u.u.fx fxVarFx = com.bytedance.sdk.component.adexpress.u.u.u.u().fx();
        if (fxVarFx == null) {
            return null;
        }
        com.bytedance.sdk.component.a.nr.fx fxVarPn = fxVarFx.pn();
        fxVarPn.u(str);
        com.bytedance.sdk.component.a.nr nrVarU = fxVarPn.u();
        if (nrVarU != null) {
            try {
                if (nrVarU.a() && nrVarU.pn() != null) {
                    return new JSONObject(nrVarU.pn());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set<com.bytedance.sdk.component.adexpress.u.fx.nr> nr(String str) {
        return iz.u().nr(str);
    }

    private void nr() {
        if (com.bytedance.sdk.component.adexpress.u.u.u.u().fx() == null) {
            return;
        }
        int iU = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().u();
        if (iU <= 0) {
            iU = 100;
        }
        List<com.bytedance.sdk.component.adexpress.u.fx.nr> listNr = iz.u().nr();
        if (listNr == null || listNr.isEmpty() || iU >= listNr.size()) {
            if (listNr != null) {
                listNr.size();
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.u.fx.nr nrVar : listNr) {
            treeMap.put(nrVar.x(), nrVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listNr.size() - (iU * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).longValue();
                com.bytedance.sdk.component.adexpress.u.fx.nr nrVar2 = (com.bytedance.sdk.component.adexpress.u.fx.nr) entry.getValue();
                if (nrVar2 != null) {
                    hashSet.add(nrVar2.nr());
                }
            }
        }
        u(hashSet);
        this.nr.set(false);
    }

    public static x u() {
        if (u == null) {
            synchronized (x.class) {
                if (u == null) {
                    u = new x();
                }
            }
        }
        return u;
    }

    public com.bytedance.sdk.component.adexpress.u.fx.nr u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return iz.u().u(str);
    }

    private JSONObject u(String str, u uVar) {
        if (com.bytedance.sdk.component.adexpress.u.u.u.u().fx() == null) {
            uVar.nr();
            return null;
        }
        com.bytedance.sdk.component.a.nr.fx fxVarPn = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().pn();
        fxVarPn.u(str);
        com.bytedance.sdk.component.a.nr nrVarU = fxVarPn.u();
        if (nrVarU != null) {
            try {
                if (nrVarU.a() && nrVarU.pn() != null) {
                    return new JSONObject(nrVarU.pn());
                }
            } catch (Exception unused) {
            }
        }
        uVar.nr();
        return null;
    }

    private void nr(String str, String str2, String str3, String str4, String str5, String str6) {
        iz.u().u(new com.bytedance.sdk.component.adexpress.u.fx.nr().u(str).nr(str2).fx(str3).b(str4).pn(str5).iz(str6).u(Long.valueOf(System.currentTimeMillis())), false);
        nr();
    }

    public void u(com.bytedance.sdk.component.adexpress.u.fx.b bVar, String str) {
        if (bVar == null) {
            k.nr("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = bVar.u;
        final String str3 = bVar.fx;
        final String str4 = bVar.nr;
        final String str5 = bVar.b;
        final String str6 = bVar.pn;
        final String strIz = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.u.u.u.u().fx() != null ? com.bytedance.sdk.component.adexpress.u.u.u.u().fx().iz() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            k.nr("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.component.adexpress.b.pn.u(new a("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.u.nr.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.u(str2, str3, str4, str5, str6, strIz);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(String str, String str2, String str3, String str4, String str5, String str6) {
        if (u(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                nr(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            u(str2, str6, str);
        } else {
            nr(str6, str, str3, str2, str4, str5);
        }
        boolean zU = n.u(str5);
        if (!nr.pn() || zU) {
            pn.nr().u(true);
        }
    }

    private void u(String str, String str2, String str3) {
        JSONObject jSONObjectFx;
        if (TextUtils.isEmpty(str) || (jSONObjectFx = fx(str)) == null) {
            return;
        }
        String strOptString = jSONObjectFx.optString("md5");
        String strOptString2 = jSONObjectFx.optString("version");
        String strOptString3 = jSONObjectFx.optString("data");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.u.fx.nr nrVarU = new com.bytedance.sdk.component.adexpress.u.fx.nr().u(str2).nr(str3).fx(strOptString).b(str).pn(strOptString3).iz(strOptString2).u(Long.valueOf(System.currentTimeMillis()));
        iz.u().u(nrVarU, false);
        nr();
        if (n.u(strOptString2)) {
            nrVarU.iz(strOptString2);
            pn.nr().u(true);
        }
    }

    public void u(com.bytedance.sdk.component.adexpress.u.fx.b bVar, u uVar) {
        u(bVar, bVar.nr(), uVar);
    }

    public void u(com.bytedance.sdk.component.adexpress.u.fx.b bVar, String str, final u uVar) {
        if (uVar == null) {
            return;
        }
        if (bVar == null) {
            k.nr("TmplDiffManager", "saveTemplate error: tplInfo == null");
            uVar.nr();
            return;
        }
        final String str2 = bVar.u;
        final String str3 = bVar.fx;
        final String str4 = bVar.nr;
        final String str5 = bVar.b;
        final String str6 = bVar.pn;
        final String strIz = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.u.u.u.u().fx() != null ? com.bytedance.sdk.component.adexpress.u.u.u.u().fx().iz() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            k.nr("TmplDiffManager", "saveTemplate error:tmpId is empty");
            uVar.nr();
        } else {
            com.bytedance.sdk.component.adexpress.b.pn.u(new a("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.u.nr.x.2
                @Override // java.lang.Runnable
                public void run() {
                    x.this.u(str2, str3, str4, str5, str6, strIz, uVar);
                }
            }, 10);
        }
    }

    public synchronized void u(String str, String str2, String str3, String str4, String str5, String str6, u uVar) {
        if (u(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                nr(str6, str, str3, str2, str4, str5);
                uVar.u();
            }
            uVar.u();
            return;
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            u(str2, str6, str, uVar);
        } else {
            nr(str6, str, str3, str2, str4, str5);
            uVar.u();
        }
        boolean zU = n.u(str5);
        if (!nr.pn() || zU) {
            pn.nr().u(true);
        }
    }

    private void u(String str, String str2, String str3, u uVar) {
        if (TextUtils.isEmpty(str)) {
            uVar.nr();
            return;
        }
        JSONObject jSONObjectU = u(str, uVar);
        if (jSONObjectU != null) {
            String strOptString = jSONObjectU.optString("md5");
            String strOptString2 = jSONObjectU.optString("version");
            String strOptString3 = jSONObjectU.optString("data");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                com.bytedance.sdk.component.adexpress.u.fx.nr nrVarU = new com.bytedance.sdk.component.adexpress.u.fx.nr().u(str2).nr(str3).fx(strOptString).b(str).pn(strOptString3).iz(strOptString2).u(Long.valueOf(System.currentTimeMillis()));
                if (nrVarU != null && com.bytedance.sdk.component.adexpress.u.u.u.u().nr() != null) {
                    if (TextUtils.isEmpty(nrVarU.nr())) {
                        uVar.nr();
                        return;
                    }
                    iz.u().u(nrVarU, false);
                    nr();
                    if (n.u(strOptString2)) {
                        nrVarU.iz(strOptString2);
                        pn.nr().u(true);
                    }
                    uVar.u();
                    return;
                }
                uVar.nr();
                return;
            }
            uVar.nr();
        }
    }

    public void u(Set<String> set) {
        try {
            iz.u().u(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
