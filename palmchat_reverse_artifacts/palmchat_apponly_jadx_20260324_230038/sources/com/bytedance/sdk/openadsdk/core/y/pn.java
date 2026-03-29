package com.bytedance.sdk.openadsdk.core.y;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements Comparable<u> {
        private String nr;
        private long u;

        public u(String str, long j) {
            this.nr = str;
            this.u = j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compareTo(u uVar) {
            if (uVar == null) {
                return 1;
            }
            long j = this.u;
            long j2 = uVar.u;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }
    }

    private static void delete(int i, int i2, com.bytedance.sdk.component.b.nr.fx fxVar, int i3) {
        if (fxVar == null) {
            return;
        }
        try {
            Map all = fxVar.getAll();
            if (all != null && all.size() != 0) {
                int size = all.size();
                if (u(i)) {
                    if (size > 1) {
                        fxVar.clear();
                        return;
                    }
                    return;
                }
                if (i3 >= i2) {
                    fxVar.clear();
                    return;
                }
                int i4 = size + i3;
                if (i4 > i2) {
                    PriorityQueue priorityQueue = new PriorityQueue();
                    for (Map.Entry entry : all.entrySet()) {
                        String str = (String) entry.getValue();
                        JSONObject jSONObject = (str == null || !str.contains("pre_fetch_time")) ? str != null ? new JSONObject(com.bytedance.sdk.component.utils.u.fx(str)) : null : new JSONObject(str);
                        if (jSONObject != null) {
                            priorityQueue.add(new u((String) entry.getKey(), jSONObject.optLong("pre_fetch_time")));
                        }
                    }
                    int size2 = priorityQueue.size();
                    int i5 = i4 - i2;
                    if (size2 == 0 || size2 < i5) {
                        fxVar.clear();
                        return;
                    }
                    for (int i6 = 0; i6 < i5; i6++) {
                        u uVar = (u) priorityQueue.poll();
                        if (uVar != null) {
                            fxVar.remove(uVar.nr);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean u(int i) {
        return i == 3 || i == 7 || i == 8;
    }

    public static void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, int i, int i2) {
        if (uVar == null || uVar.nr() == null || i2 <= 0) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.kj.bc> listNr = uVar.nr();
        int size = listNr.size();
        try {
            com.bytedance.sdk.component.b.nr.fx fxVarU = bf.u(i + "_prefetch");
            delete(i, i2, fxVarU, size);
            for (com.bytedance.sdk.openadsdk.core.kj.bc bcVar : listNr) {
                String strM = bcVar.m();
                String strNr = com.bytedance.sdk.component.utils.u.nr(bcVar.et().toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pre_fetch_time", System.currentTimeMillis());
                jSONObject.put("message", strNr);
                fxVarU.put(strM, jSONObject.toString());
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.openadsdk.core.kj.bc u(String str, int i) {
        if (com.bytedance.sdk.openadsdk.core.dw.nr().y() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.b.nr.fx fxVarU = bf.u(i + "_prefetch");
        String strOptString = fxVarU.get(str, (String) null);
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                if (strOptString.contains("pre_fetch_time")) {
                    strOptString = new JSONObject(strOptString).optString("message");
                }
                com.bytedance.sdk.openadsdk.core.kj.bc bcVarU = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(com.bytedance.sdk.component.utils.u.fx(strOptString)));
                fxVarU.remove(str);
                return bcVarU;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
