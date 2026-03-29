package com.bytedance.sdk.openadsdk.core.pn.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.pn.b.x;
import com.bytedance.sdk.openadsdk.core.y.bf;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements nr {
    private static final com.bytedance.sdk.component.b.nr.fx u = bf.u("open_ad_sdk_union_meta_cache_kv");

    private String fx(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return "sp_reward_video_cache_".concat(String.valueOf(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void nr(String str) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(u.get(fx(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            u uVarU = u.u((String) it.next());
            uVarU.fx = false;
            copyOnWriteArraySet2.add(uVarU.toString());
        }
        u.put(fx(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str, x.nr nrVar, iz izVar, x.u uVar, com.bytedance.sdk.openadsdk.core.pn.b.u uVar2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(u.get(fx(str), copyOnWriteArraySet));
        if (uVar.fx() <= 0) {
            return;
        }
        if (uVar.fx() > 0 && copyOnWriteArraySet.size() >= uVar.fx()) {
            u uVar3 = null;
            long j = 0;
            String str2 = null;
            for (String str3 : copyOnWriteArraySet) {
                u uVarU = u.u(str3);
                if (str2 == null || j < uVarU.u) {
                    j = uVarU.u;
                    str2 = str3;
                    uVar3 = uVarU;
                }
            }
            if (uVar3 != null) {
                uVar2.u(new x.nr(uVar3.b, uVar3.u, uVar3.nr, uVar3.iz));
            }
            copyOnWriteArraySet.remove(str2);
        }
        copyOnWriteArraySet.add(new u(nrVar.fx, nrVar.u, nrVar.nr, izVar.u, nrVar.pn, izVar.nr, izVar.fx).toString());
        u.put(fx(str), copyOnWriteArraySet);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        String b;
        boolean fx;
        String iz;
        int n;
        long nr;
        int pn;
        long u;
        long x;

        public u(String str, long j, long j2, boolean z, String str2, long j3, int i, int i2) {
            this.u = j;
            this.nr = j2;
            this.fx = z;
            this.b = str;
            this.iz = str2;
            this.x = j3;
            this.n = i;
            this.pn = i2;
        }

        public static u u(String str) {
            long jOptLong;
            long jOptLong2;
            boolean z;
            int iOptInt;
            String str2;
            long j;
            String str3;
            String str4;
            long j2;
            boolean z2;
            long j3;
            long j4;
            int i;
            int iOptInt2;
            String strOptString = "";
            long jOptLong3 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str);
                jOptLong = jSONObject.optLong("create_time", 0L);
                try {
                    jOptLong2 = jSONObject.optLong("expire_time", 0L);
                    try {
                        boolean zOptBoolean = jSONObject.optBoolean("is_using", false);
                        try {
                            String strOptString2 = jSONObject.optString("material_data", "");
                            try {
                                iOptInt = jSONObject.optInt("save_version", 0);
                                try {
                                    strOptString = jSONObject.optString(Constant.MAP_KEY_UUID, "");
                                    jOptLong3 = jSONObject.optLong("priority", 0L);
                                    str4 = strOptString;
                                    j2 = jOptLong3;
                                    z2 = zOptBoolean;
                                    iOptInt2 = jSONObject.optInt("index", 0);
                                    j3 = jOptLong;
                                    j4 = jOptLong2;
                                    str3 = strOptString2;
                                    i = iOptInt;
                                } catch (JSONException unused) {
                                    z = zOptBoolean;
                                    j = jOptLong3;
                                    str2 = strOptString;
                                    strOptString = strOptString2;
                                    str3 = strOptString;
                                    str4 = str2;
                                    j2 = j;
                                    z2 = z;
                                    j3 = jOptLong;
                                    j4 = jOptLong2;
                                    i = iOptInt;
                                    iOptInt2 = 0;
                                }
                            } catch (JSONException unused2) {
                                z = zOptBoolean;
                                iOptInt = 0;
                            }
                        } catch (JSONException unused3) {
                            z = zOptBoolean;
                            iOptInt = 0;
                            j = 0;
                            str2 = "";
                            str3 = strOptString;
                            str4 = str2;
                            j2 = j;
                            z2 = z;
                            j3 = jOptLong;
                            j4 = jOptLong2;
                            i = iOptInt;
                            iOptInt2 = 0;
                            return new u(str3, j3, j4, z2, str4, j2, iOptInt2, i);
                        }
                    } catch (JSONException unused4) {
                        j = 0;
                        z = true;
                        iOptInt = 0;
                    }
                } catch (JSONException unused5) {
                    jOptLong2 = 0;
                    z = true;
                    iOptInt = 0;
                    str2 = "";
                    j = jOptLong2;
                    str3 = strOptString;
                    str4 = str2;
                    j2 = j;
                    z2 = z;
                    j3 = jOptLong;
                    j4 = jOptLong2;
                    i = iOptInt;
                    iOptInt2 = 0;
                    return new u(str3, j3, j4, z2, str4, j2, iOptInt2, i);
                }
            } catch (JSONException unused6) {
                jOptLong = 0;
                jOptLong2 = 0;
            }
            return new u(str3, j3, j4, z2, str4, j2, iOptInt2, i);
        }

        public boolean nr(x.u uVar) {
            if (System.currentTimeMillis() <= this.nr && !TextUtils.isEmpty(this.b)) {
                return uVar.nr() && 7232 != this.pn;
            }
            return true;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("create_time", this.u);
                jSONObject.put("expire_time", this.nr);
                jSONObject.put("is_using", this.fx);
                jSONObject.put("material_data", this.b);
                jSONObject.put("save_version", this.pn);
                jSONObject.put(Constant.MAP_KEY_UUID, this.iz);
                jSONObject.put("priority", this.x);
                jSONObject.put("index", this.n);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }

        public u(String str, long j, long j2, boolean z, String str2, long j3, int i) {
            this(str, j, j2, z, str2, j3, i, 7232);
        }

        public boolean u(x.u uVar) {
            return (nr(uVar) || this.fx) ? false : true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public x.nr u(String str, x.u uVar, long j) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(u.get(fx(str), copyOnWriteArraySet));
        return u(copyOnWriteArraySet, uVar, j, (List<String>) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public x.nr u(String str, x.u uVar, long j, List<String> list) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(u.get(fx(str), copyOnWriteArraySet));
        return u(copyOnWriteArraySet, uVar, j, list);
    }

    private x.nr u(CopyOnWriteArraySet<String> copyOnWriteArraySet, x.u uVar, long j, List<String> list) {
        int i;
        int i2;
        Iterator<String> it = copyOnWriteArraySet.iterator();
        u uVar2 = null;
        while (it.hasNext()) {
            u uVarU = u.u(it.next());
            if (uVarU.u(uVar)) {
                String str = uVarU.iz;
                if (list == null || str == null || !list.contains(str)) {
                    if (j <= 0 || uVarU.u >= j) {
                        int iB = uVar.b();
                        if (iB != 1) {
                            if (iB != 2) {
                                if (iB != 3) {
                                    return new x.nr(uVarU.b, uVarU.u, uVarU.nr, uVarU.iz);
                                }
                                if (uVar2 == null || (i = uVar2.n) > (i2 = uVarU.n) || (i == i2 && uVar2.u < uVarU.u)) {
                                    uVar2 = uVarU;
                                }
                            } else if (uVar2 == null || uVar2.x < uVarU.x) {
                                uVar2 = uVarU;
                            }
                        } else if (uVar2 == null || uVar2.u < uVarU.u) {
                            uVar2 = uVarU;
                        }
                    }
                }
            }
        }
        if (uVar2 != null) {
            return new x.nr(uVar2.b, uVar2.u, uVar2.nr, uVar2.iz);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str) {
        u.remove(fx(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(x.u uVar) {
        u.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str, x.u uVar, com.bytedance.sdk.openadsdk.core.pn.b.u uVar2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(u.get(fx(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            u uVarU = u.u((String) it.next());
            if (!uVarU.nr(uVar)) {
                copyOnWriteArraySet2.add(uVarU.toString());
            } else if (uVar2 != null) {
                uVar2.u(new x.nr(uVarU.b, uVarU.u, uVarU.nr, uVarU.iz));
            }
        }
        u.put(fx(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str, String str2) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(u.get(fx(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            if (!TextUtils.equals(u.u(str3).iz, str2)) {
                copyOnWriteArraySet2.add(str3);
            }
        }
        u.put(fx(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.b.nr
    public void u(String str, String str2, boolean z) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(u.get(fx(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        for (String str3 : copyOnWriteArraySet) {
            u uVarU = u.u(str3);
            if (TextUtils.equals(uVarU.iz, str2)) {
                uVarU.fx = z;
                copyOnWriteArraySet2.add(uVarU.toString());
            } else {
                copyOnWriteArraySet2.add(str3);
            }
        }
        u.put(fx(str), copyOnWriteArraySet2);
    }
}
