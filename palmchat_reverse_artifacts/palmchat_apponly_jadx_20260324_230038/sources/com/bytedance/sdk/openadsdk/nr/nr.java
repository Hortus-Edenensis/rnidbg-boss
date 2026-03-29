package com.bytedance.sdk.openadsdk.nr;

import android.text.TextUtils;
import com.bytedance.sdk.component.a.nr.b;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.gi.pn;
import com.bytedance.sdk.openadsdk.gi.jk;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private Set<String> fx;
    private ReentrantLock nr;
    private Map<String, com.bytedance.sdk.openadsdk.nr.u> u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        private static final nr u = new nr();
    }

    private void b() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.u.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.openadsdk.nr.u uVar = this.u.get(it.next());
            if (uVar != null) {
                jSONArray.put(uVar.pn());
            }
        }
        com.bytedance.sdk.openadsdk.core.nr.u().put("sdk_brand_video_cahce", jSONArray.toString());
    }

    private void delete(Map<String, com.bytedance.sdk.openadsdk.nr.u> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            map.get(it.next()).nr(jk.u());
        }
    }

    private JSONArray fx(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creatives");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray2 == null) {
            return jSONArray;
        }
        for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("precache_brand_video")) != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    jSONArray.put(jSONArrayOptJSONArray.opt(i2));
                }
            }
        }
        return jSONArray;
    }

    private com.bytedance.sdk.component.a.u nr() {
        return pn.u().nr();
    }

    private Map<String, com.bytedance.sdk.openadsdk.nr.u> pn() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.sdk.openadsdk.nr.u>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, com.bytedance.sdk.openadsdk.nr.u> next = it.next();
            if (next.getValue().b()) {
                map.put(next.getKey(), next.getValue());
                it.remove();
            } else {
                arrayList.add(next.getValue());
            }
        }
        int size = this.u.size() - dw.nr().ls();
        if (size > 0) {
            Collections.sort(arrayList, new Comparator<com.bytedance.sdk.openadsdk.nr.u>() { // from class: com.bytedance.sdk.openadsdk.nr.nr.3
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public int compare(com.bytedance.sdk.openadsdk.nr.u uVar, com.bytedance.sdk.openadsdk.nr.u uVar2) {
                    long jFx = uVar2.fx() - uVar.fx();
                    if (jFx == 0) {
                        String strU = jk.u();
                        jFx = uVar.u(strU) - uVar2.u(strU);
                    }
                    return (int) jFx;
                }
            });
            for (int i = 0; i < size; i++) {
                com.bytedance.sdk.openadsdk.nr.u uVar = (com.bytedance.sdk.openadsdk.nr.u) arrayList.get(i);
                this.u.remove(uVar.nr());
                map.put(uVar.nr(), uVar);
            }
        }
        return map;
    }

    private nr() {
        this.u = new HashMap();
        this.nr = new ReentrantLock();
        this.fx = new HashSet();
        String str = com.bytedance.sdk.openadsdk.core.nr.u().get("sdk_brand_video_cahce", "");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                nr(jSONArray.optJSONObject(i));
            }
        } catch (Throwable unused) {
        }
    }

    private void nr(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.nr.u uVar = new com.bytedance.sdk.openadsdk.nr.u(jSONObject);
            this.u.put(uVar.nr(), uVar);
        }
    }

    public static nr u() {
        return u.u;
    }

    public void u(JSONObject jSONObject) {
        final JSONArray jSONArrayFx = fx(jSONObject);
        if (jSONArrayFx == null || jSONArrayFx.length() == 0) {
            return;
        }
        com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.nr.nr.1
            @Override // java.lang.Runnable
            public void run() {
                jSONArrayFx.length();
                nr.this.u(jSONArrayFx);
            }
        }, 20000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(JSONArray jSONArray) {
        try {
            this.nr.lock();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                nr(jSONArray.optJSONObject(i));
            }
            Map<String, com.bytedance.sdk.openadsdk.nr.u> mapPn = pn();
            int iFx = fx();
            b();
            delete(mapPn);
            this.nr.unlock();
            u(iFx);
        } catch (Throwable th) {
            this.nr.unlock();
            throw th;
        }
    }

    private int fx() {
        Iterator<String> it = this.u.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            com.bytedance.sdk.openadsdk.nr.u uVar = this.u.get(it.next());
            if (uVar != null) {
                String strU = jk.u();
                String strNr = uVar.nr();
                if (TextUtils.isEmpty(strNr)) {
                    strNr = x.nr(uVar.u());
                }
                String strU2 = uVar.u();
                File file = new File(strU, strNr);
                if (!file.exists() || file.length() <= 0) {
                    i++;
                    if (!this.fx.contains(strNr)) {
                        this.fx.add(strNr);
                        u(strU2, strU, strNr);
                    }
                }
            }
        }
        return i;
    }

    private void u(int i) {
        File[] fileArrListFiles = new File(jk.u()).listFiles();
        int iLs = dw.nr().ls();
        if (fileArrListFiles == null || fileArrListFiles.length <= iLs - i) {
            return;
        }
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            if (!this.u.containsKey(u(fileArrListFiles[i2])) && fileArrListFiles[i2].exists()) {
                fileArrListFiles[i2].delete();
            }
        }
    }

    private String u(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(".");
        return iLastIndexOf != -1 ? name.substring(0, iLastIndexOf) : name;
    }

    private void u(final String str, String str2, final String str3) {
        com.bytedance.sdk.component.a.nr.nr nrVarB = nr().b();
        nrVarB.u(str);
        nrVarB.u(str2, str3);
        nrVarB.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.nr.nr.2
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                nr.this.u(str3);
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(b bVar, IOException iOException) {
                nr.this.u(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        try {
            this.nr.lock();
            this.fx.remove(str);
        } finally {
            this.nr.unlock();
        }
    }
}
