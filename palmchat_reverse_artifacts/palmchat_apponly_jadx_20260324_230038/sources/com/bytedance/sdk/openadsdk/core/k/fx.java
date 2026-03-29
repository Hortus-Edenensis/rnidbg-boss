package com.bytedance.sdk.openadsdk.core.k;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.t;
import com.bytedance.sdk.openadsdk.core.y.u;
import com.qiniu.android.collect.ReportItem;
import com.tencent.matrix.trace.config.SharePluginInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements u.nr {
    private static volatile fx nr;
    private float mv;
    private final ConcurrentHashMap<Integer, b> fx = new ConcurrentHashMap<>();
    private final Map<String, Float> b = new ConcurrentHashMap();
    private b pn = null;
    private JSONArray x = new JSONArray();
    private final String n = "realtime_feature";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5290a = 0;
    private long jk = 0;
    private long t = 0;
    private long l = 0;
    public long u = 0;
    private Handler iz = jk.u();

    private fx() {
        com.bytedance.sdk.openadsdk.core.y.u uVarB = com.bytedance.sdk.openadsdk.core.n.o().b();
        if (uVarB != null) {
            uVarB.u(this);
        }
    }

    private Handler mv() {
        return this.iz;
    }

    public static fx pn() {
        if (nr == null) {
            synchronized (fx.class) {
                if (nr == null) {
                    nr = new fx();
                }
            }
        }
        return nr;
    }

    public long a() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (this.u == 0) {
            this.u = timeInMillis;
        }
        return timeInMillis;
    }

    public long b() {
        if (this.l == 0) {
            this.l = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - bg.pn);
        }
        return this.l;
    }

    public long fx() {
        if (this.t == 0) {
            this.t = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return this.t;
    }

    public void iz() {
        fx();
        b();
        u.u(u.u, 0L, 0L);
        u.u(u.b);
    }

    public long jk() {
        return this.f5290a;
    }

    public float l() {
        if (this.mv == 0.0f) {
            this.mv = t.l();
        }
        return this.mv;
    }

    public void n() {
        long jA = a();
        if (jA != this.u) {
            u.u(u.pn);
            this.u = jA;
        }
    }

    public long t() {
        return this.jk;
    }

    public JSONArray x() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.fx.keySet().isEmpty()) {
            this.x = new JSONArray();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                try {
                    Iterator<Integer> it = this.fx.keySet().iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        b bVar = this.fx.get(Integer.valueOf(iIntValue));
                        if (bVar != null && bVar.u().length() > 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("slot_type", iIntValue);
                            jSONObject.put("event_cnts", bVar.u());
                            jSONArray.put(jSONObject);
                        }
                    }
                    if (this.pn != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("slot_type", -1);
                        jSONObject2.put("event_cnts", this.pn.u());
                        jSONArray.put(jSONObject2);
                    }
                } catch (JSONException e) {
                    k.u(e.getMessage());
                }
            } catch (Throwable th) {
                k.u(th.getMessage());
            }
            this.x = jSONArray;
        }
        if (dw.nr().ju()) {
            double dCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis;
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(SharePluginInfo.ISSUE_COST, dCurrentTimeMillis);
                jSONObject3.put("feature_cnt", this.x.length());
            } catch (JSONException e2) {
                k.u(e2.getMessage());
            }
            s.u().a(jSONObject3);
        }
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void nr() {
        if (dw.nr().lk()) {
            mv().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.k.fx.5
                @Override // java.lang.Runnable
                public void run() {
                    fx.this.mv = t.l();
                    u.u(u.nr, 0L, u.x());
                    u.u(u.iz);
                    fx.this.f5290a = System.currentTimeMillis();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, @NonNull String str2, String str3, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !dw.nr().lk()) {
            return;
        }
        if (i > 0 && i <= 10) {
            b bVar = this.fx.get(Integer.valueOf(i));
            if (bVar == null) {
                bVar = new b(str2);
                this.fx.put(Integer.valueOf(i), bVar);
            }
            bVar.u(str, str3);
            return;
        }
        if (this.pn == null) {
            this.pn = new b(str2);
        }
        this.pn.u(str, str3);
    }

    public void u(@NonNull final String str, @NonNull final String str2, final String str3, final JSONObject jSONObject, final String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !dw.nr().lk()) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "feed_over":
            case "show":
            case "skip":
            case "click":
            case "feed_continue":
            case "feed_break":
            case "feed_pause":
            case "play_start":
                mv().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.k.fx.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String strOptString = str3;
                            int iOptInt = 0;
                            if (jSONObject != null) {
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = jSONObject.optString(ReportItem.RequestKeyRequestId);
                                }
                                iOptInt = jSONObject.optInt("ad_slot_type", 0);
                            } else if (str4 != null) {
                                JSONObject jSONObject2 = new JSONObject(str4);
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = jSONObject2.optString(ReportItem.RequestKeyRequestId);
                                }
                                iOptInt = jSONObject2.optInt("ad_slot_type", 0);
                            }
                            fx.this.u(str, str2, strOptString, iOptInt);
                        } catch (Exception unused) {
                        }
                    }
                });
                break;
        }
    }

    public void u(@NonNull final String str, final bc bcVar) {
        if (!TextUtils.isEmpty(str) && dw.nr().lk() && "videoPercent30".equals(str)) {
            mv().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.k.fx.2
                @Override // java.lang.Runnable
                public void run() {
                    bc bcVar2 = bcVar;
                    if (bcVar2 != null) {
                        String strLk = bcVar2.lk();
                        if (TextUtils.isEmpty(strLk)) {
                            return;
                        }
                        fx.this.u(str, strLk, bcVar.xx(), jp.jk(bcVar));
                    }
                }
            });
        }
    }

    public void u(@NonNull final String str, final bc bcVar, final String str2) {
        if (TextUtils.isEmpty(str) || !dw.nr().lk()) {
            return;
        }
        if ("landingStart".equals(str) || "landingFinish".equals(str) || "landingContinue".equals(str) || "landingPause".equals(str)) {
            mv().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.k.fx.3
                @Override // java.lang.Runnable
                public void run() {
                    bc bcVar2 = bcVar;
                    if (bcVar2 != null) {
                        String strLk = bcVar2.lk();
                        if (TextUtils.isEmpty(strLk)) {
                            return;
                        }
                        int iJk = jp.jk(bcVar);
                        fx.this.u(str, strLk, bcVar.xx() + str2, iJk);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.u.nr
    public void u() {
        if (dw.nr().lk()) {
            mv().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.k.fx.4
                @Override // java.lang.Runnable
                public void run() {
                    u.u(u.fx, u.iz(), 0L);
                    if (fx.this.pn != null) {
                        fx.this.pn.nr();
                    }
                    Iterator it = fx.this.fx.values().iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).nr();
                    }
                    fx.this.jk = System.currentTimeMillis();
                }
            });
        }
    }

    public void u(bc bcVar, float f) {
        if (bcVar != null) {
            this.b.put(jp.u(bcVar, ""), Float.valueOf(f));
        }
    }

    public float u(String str) {
        Float f;
        if (TextUtils.isEmpty(str) || (f = this.b.get(str)) == null) {
            return 0.0f;
        }
        return f.floatValue();
    }
}
