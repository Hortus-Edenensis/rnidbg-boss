package com.bytedance.sdk.openadsdk.core.y;

import android.os.SystemClock;
import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static volatile nr u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.b.nr.fx f5412a;
    private com.bytedance.sdk.component.b.nr.fx jk;
    private com.bytedance.sdk.component.b.nr.fx n;
    private com.bytedance.sdk.component.b.nr.fx x;
    private volatile int t = 0;
    private int l = 0;
    private int mv = 0;
    private final Map<String, Integer> nr = new HashMap();
    private final ConcurrentHashMap<String, Integer> fx = new ConcurrentHashMap<>();
    private final Map<String, Long> b = new HashMap();
    private final ConcurrentHashMap<String, Long> pn = new ConcurrentHashMap<>();
    private final long iz = SystemClock.elapsedRealtime();

    private nr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.b.nr.fx iz() {
        if (this.f5412a == null) {
            this.f5412a = bf.u("activity_foreground_time");
        }
        return this.f5412a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.b.nr.fx pn() {
        if (this.n == null) {
            this.n = bf.u("activity_adshow_count");
        }
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.b.nr.fx x() {
        if (this.jk == null) {
            this.jk = bf.u("activity_recorder");
        }
        return this.jk;
    }

    public void b(final String str) {
        com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.nr.3
            @Override // java.lang.Runnable
            public void run() {
                nr.this.pn().put(str, nr.this.pn().get(str, 0) + 1);
            }
        });
    }

    public void fx(String str) {
        Long lRemove;
        if (TextUtils.isEmpty(str) || (lRemove = this.pn.remove(str)) == null) {
            return;
        }
        long jElapsedRealtime = (SystemClock.elapsedRealtime() - lRemove.longValue()) / 1000;
        if (jElapsedRealtime >= 0) {
            Long l = this.b.get(str);
            if (l == null || l.longValue() < 0) {
                l = 0L;
            }
            this.b.put(str, Long.valueOf(l.longValue() + jElapsedRealtime));
            u(str, jElapsedRealtime);
        }
    }

    public void nr(final String str) {
        com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.nr.1
            @Override // java.lang.Runnable
            public void run() {
                nr.this.b().put(str, nr.this.b().get(str, 0) + 1);
                if (nr.this.t == 0) {
                    nr nrVar = nr.this;
                    nrVar.t = nrVar.x().get("histRunningCount", 0) + 1;
                    nr.this.x().put("histRunningCount", nr.this.t);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.b.nr.fx b() {
        if (this.x == null) {
            this.x = bf.u("activity_resume_count");
        }
        return this.x;
    }

    public void nr() {
        if (this.pn.size() == 1) {
            for (String str : this.pn.keySet()) {
                Integer num = this.fx.get(str);
                this.fx.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                b(str);
            }
        }
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

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.nr.get(str);
        this.nr.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.pn.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        if (this.pn.size() > 1) {
            this.l++;
        }
        nr(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        try {
            Map all = b().getAll();
            if (all == null) {
                return;
            }
            Iterator it = all.values().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next()).intValue();
            }
            if (iIntValue != 0 && iIntValue % 75 == 0) {
                final JSONArray jSONArray = new JSONArray();
                Iterator<String> it2 = this.nr.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String next = it2.next();
                    Integer num = this.nr.get(next);
                    Long l = this.b.get(next);
                    Integer num2 = this.fx.get(next);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", next);
                        jSONObject.put("rc", num != null ? num.intValue() : 0);
                        jSONObject.put("ft", l != null ? l.longValue() : 0L);
                        jSONObject.put("asc", num2 != null ? num2.intValue() : 0);
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                final JSONArray jSONArray2 = new JSONArray();
                Map all2 = iz().getAll();
                Map all3 = pn().getAll();
                if (all2 != null && all3 != null) {
                    for (String str : all.keySet()) {
                        Integer num3 = (Integer) all.get(str);
                        Long l2 = (Long) all2.get(str);
                        Integer num4 = (Integer) all3.get(str);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str);
                            jSONObject2.put("rc", num3 != null ? num3.intValue() : 0);
                            jSONObject2.put("ft", l2 != null ? l2.longValue() : 0L);
                            jSONObject2.put("asc", num4 != null ? num4.intValue() : 0);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException unused2) {
                        }
                    }
                }
                final long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.iz) / 1000;
                com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.nr.4
                    @Override // com.bytedance.sdk.openadsdk.t.u.u
                    public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("ara", jSONArray);
                        jSONObject3.put("hara", jSONArray2);
                        jSONObject3.put("rt", jElapsedRealtime);
                        jSONObject3.put("hrc", nr.this.t);
                        jSONObject3.put("drc", nr.this.l);
                        return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("ad_activity_record").nr(jSONObject3.toString());
                    }
                }, "ad_activity_record");
            }
        } catch (Throwable unused3) {
        }
    }

    public void u(final String str, final long j) {
        com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.nr.2
            @Override // java.lang.Runnable
            public void run() {
                long j2 = nr.this.iz().get(str, 0L);
                nr.this.iz().put(str, (j2 >= 0 ? j2 : 0L) + j);
                nr.this.fx();
                nr.this.u(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j) {
        int i = this.mv;
        if (i == 0) {
            try {
                Map all = iz().getAll();
                if (all != null) {
                    Iterator it = all.values().iterator();
                    while (it.hasNext()) {
                        this.mv = (int) (((long) this.mv) + ((Long) it.next()).longValue());
                    }
                }
            } catch (Throwable unused) {
                this.mv = -1;
            }
        } else {
            this.mv = (int) (((long) i) + j);
        }
        kj.u(this.mv, this.t);
    }
}
