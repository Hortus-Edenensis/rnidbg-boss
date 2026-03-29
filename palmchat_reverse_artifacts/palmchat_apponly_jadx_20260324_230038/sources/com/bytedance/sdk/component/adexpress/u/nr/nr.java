package com.bytedance.sdk.component.adexpress.u.nr;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.b.jk;
import com.bytedance.sdk.component.adexpress.u.fx.u;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.k;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    static Object u = new Object();

    public static com.bytedance.sdk.component.adexpress.u.fx.u b() {
        return pn.nr().pn();
    }

    public static String fx() {
        return iz.fx();
    }

    @Deprecated
    private static String iz() {
        com.bytedance.sdk.component.adexpress.u.fx.u uVarB = b();
        if (uVarB == null) {
            return null;
        }
        return uVarB.b();
    }

    public static void nr() {
        try {
            n.b();
            File fileX = pn.x();
            if (fileX == null || !fileX.exists()) {
                return;
            }
            if (fileX.getParentFile() != null) {
                com.bytedance.sdk.component.utils.n.fx(fileX.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.n.fx(fileX);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean pn() {
        return pn.nr().b();
    }

    private static File b(String str) {
        if (!pn()) {
            return null;
        }
        for (u.C0206u c0206u : b().getResources()) {
            if (c0206u.u() != null && c0206u.u().equals(str)) {
                File file = new File(pn.x(), com.bytedance.sdk.component.utils.x.nr(c0206u.u()));
                String strU = com.bytedance.sdk.component.utils.x.u(file);
                if (c0206u.nr() == null || !c0206u.nr().equals(strU)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    private static boolean fx(String str) {
        com.bytedance.sdk.component.adexpress.u.fx.u uVarB;
        List<u.C0206u> resources;
        if (!pn() || (uVarB = b()) == null || (resources = uVarB.getResources()) == null) {
            return false;
        }
        for (u.C0206u c0206u : resources) {
            if (c0206u != null && TextUtils.equals(str, c0206u.u())) {
                return true;
            }
        }
        return false;
    }

    private static File pn(String str) {
        List<Pair<String, String>> listNr;
        u.nr nrVarPn = b().pn();
        if (nrVarPn == null || (listNr = nrVarPn.nr()) == null || listNr.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listNr) {
            Object obj = pair.second;
            if (obj != null && ((String) obj).equals(str)) {
                return new File(pn.x(), (String) pair.first);
            }
        }
        return null;
    }

    public static void u() {
        pn.nr();
    }

    public static void u(com.bytedance.sdk.component.adexpress.u.fx.b bVar) {
        x.u().u(bVar, bVar.iz);
    }

    public static Set<com.bytedance.sdk.component.adexpress.u.fx.nr> u(String str, boolean z) {
        final Set<com.bytedance.sdk.component.adexpress.u.fx.nr> setNr = x.u().nr(str);
        if (setNr != null && setNr.size() > 0) {
            if (z) {
                com.bytedance.sdk.component.adexpress.b.pn.u(new a("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.u.nr.nr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        nr.nr((Set<com.bytedance.sdk.component.adexpress.u.fx.nr>) setNr);
                    }
                }, 5);
            } else {
                nr(setNr);
            }
        }
        return setNr;
    }

    public static boolean fx(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(Set<com.bytedance.sdk.component.adexpress.u.fx.nr> set) {
        try {
            for (com.bytedance.sdk.component.adexpress.u.fx.nr nrVar : set) {
                nrVar.u(Long.valueOf(System.currentTimeMillis()));
                iz.u().u(nrVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.component.adexpress.u.fx.nr u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.u.fx.nr nrVarU = x.u().u(str);
        if (nrVarU != null) {
            nrVarU.u(Long.valueOf(System.currentTimeMillis()));
            u(nrVarU);
        }
        return nrVarU;
    }

    public static String nr(String str) {
        com.bytedance.sdk.component.adexpress.u.fx.u uVar;
        com.bytedance.sdk.component.adexpress.u.fx.u uVarB = b();
        if (uVarB == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> mapU = uVarB.u();
            if (mapU == null || mapU.size() <= 0 || (uVar = mapU.get(str)) == null) {
                return null;
            }
            return uVar.b();
        }
        return iz();
    }

    private static void u(final com.bytedance.sdk.component.adexpress.u.fx.nr nrVar) {
        com.bytedance.sdk.component.adexpress.b.pn.u(new a("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.u.nr.nr.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (nr.u) {
                    iz.u().u(nrVar, true);
                }
            }
        }, 10);
    }

    public static u u(String str, jk.u uVar, String str2, String str3) {
        File fileB;
        u uVar2 = new u();
        if (TextUtils.isEmpty(str3)) {
            fileB = null;
        } else {
            fileB = nr(str3, str);
            if (fileB != null) {
                uVar2.u(1);
            }
        }
        if (fileB == null && (fileB = pn(str)) != null) {
            uVar2.u(3);
        }
        if (fileB == null && (fileB = b(str)) != null) {
            uVar2.u(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!u(str, str3)) {
                uVar2.u(4);
            }
        } else if (!fx(str)) {
            uVar2.u(6);
        }
        uVar2.getType();
        if (fileB != null) {
            try {
                uVar2.u(new WebResourceResponse(uVar.getType(), "utf-8", new FileInputStream(fileB)));
            } catch (Throwable th) {
                k.u("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return uVar2;
    }

    private static File nr(String str, String str2) {
        com.bytedance.sdk.component.adexpress.u.fx.u uVar;
        com.bytedance.sdk.component.adexpress.u.fx.u uVarB = b();
        if (uVarB == null || !pn()) {
            return null;
        }
        Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> mapU = uVarB.u();
        if (mapU.size() == 0 || (uVar = mapU.get(str)) == null) {
            return null;
        }
        for (u.C0206u c0206u : uVar.getResources()) {
            if (c0206u.u() != null && c0206u.u().equals(str2)) {
                File file = new File(pn.x(), com.bytedance.sdk.component.utils.x.nr(c0206u.u()));
                String strU = com.bytedance.sdk.component.utils.x.u(file);
                if (c0206u.nr() == null || !c0206u.nr().equals(strU)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static boolean nr(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    private static boolean u(String str, String str2) {
        com.bytedance.sdk.component.adexpress.u.fx.u uVarB;
        com.bytedance.sdk.component.adexpress.u.fx.u uVar;
        if (!pn() || (uVarB = b()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.u.fx.u> mapU = uVarB.u();
        if (mapU.size() == 0 || (uVar = mapU.get(str2)) == null) {
            return false;
        }
        for (u.C0206u c0206u : uVar.getResources()) {
            if (c0206u != null && TextUtils.equals(str, c0206u.u())) {
                return true;
            }
        }
        return false;
    }

    public static boolean u(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }
}
