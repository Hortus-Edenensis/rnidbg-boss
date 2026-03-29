package com.bytedance.sdk.openadsdk.core.pn.nr;

import android.text.TextUtils;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.qiniu.android.collect.ReportItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private final int l;
    private pn n;
    private String x;
    private final AtomicBoolean pn = new AtomicBoolean(false);
    private final AtomicBoolean iz = new AtomicBoolean(false);
    List<bc> u = new ArrayList();
    List<bc> nr = new ArrayList();
    List<bc> fx = new ArrayList();
    List<String> b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5360a = -1;
    private long jk = -1;
    private long t = -1;
    private final Runnable mv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pn.nr.u.1
        @Override // java.lang.Runnable
        public void run() {
            if (u.this.iz.get()) {
                return;
            }
            u.this.pn.set(true);
            Iterator<bc> it = u.this.fx.iterator();
            while (it.hasNext()) {
                it.next().a(100003L);
            }
            u uVar = u.this;
            uVar.nr(uVar.u);
        }
    };

    public u(int i) {
        this.l = i;
    }

    private void b(List<bc> list) {
        list.size();
        Iterator<bc> it = list.iterator();
        while (it.hasNext()) {
            nr(it.next());
        }
        pn pnVar = this.n;
        if (pnVar != null) {
            pnVar.nr(list);
        }
        u();
    }

    private void fx(long j) {
        this.t = j;
    }

    private void fx(List<bc> list) {
        list.size();
        Iterator<bc> it = list.iterator();
        while (it.hasNext()) {
            nr(it.next());
        }
        pn pnVar = this.n;
        if (pnVar != null) {
            pnVar.u(list);
        }
        u();
    }

    public void nr(long j) {
        this.jk = j;
    }

    private JSONObject nr(int i, List<bc> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<bc> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(u(it.next()));
            }
            jSONObject.put("ads", jSONArray);
            jSONObject.put("check_type", i);
        } catch (JSONException e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public void u() {
        this.n = null;
        jk.fx().removeCallbacks(this.mv);
    }

    public void u(long j) {
        this.f5360a = j;
    }

    public void u(List<bc> list, pn pnVar) {
        this.n = pnVar;
        u(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(List<bc> list) {
        boolean z;
        boolean z2;
        this.u = list;
        this.nr.clear();
        this.fx.clear();
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        for (bc bcVar : list) {
            this.b.add(bcVar.nu());
            JSONObject jSONObjectIs = bcVar.is();
            if (jSONObjectIs == null) {
                bcVar.n(-1L);
                this.nr.add(bcVar);
            } else {
                int iOptInt = jSONObjectIs.optInt("cache_correct_type", i);
                int iOptInt2 = jSONObjectIs.optInt("is_need_cache_correct", i);
                int iOptInt3 = jSONObjectIs.optInt("is_need_cache_check", i);
                boolean z5 = iOptInt == 1;
                boolean z6 = iOptInt2 == 1;
                boolean z7 = iOptInt3 == 1;
                if (!z5) {
                    this.nr.add(bcVar);
                    bcVar.n(0L);
                } else if (z6 || z7) {
                    if (!z6) {
                        this.fx.add(bcVar);
                        bcVar.n(3L);
                    } else {
                        long jOptLong = jSONObjectIs.optLong("creative_check_duration", 0L);
                        if (jOptLong > 0) {
                            z = z3;
                            z2 = Math.abs(((double) (System.currentTimeMillis() / 1000)) - jp.s(bcVar)) <= ((double) jOptLong);
                            if (z2) {
                                if (!z7) {
                                    this.fx.add(bcVar);
                                    bcVar.n(5L);
                                    z3 = z;
                                    i = 0;
                                } else {
                                    this.fx.add(bcVar);
                                    bcVar.n(7L);
                                    i = 0;
                                    z3 = true;
                                }
                                z4 = true;
                            } else if (!z7) {
                                this.nr.add(bcVar);
                                bcVar.n(4L);
                                bcVar.a(100002L);
                                z3 = z;
                                i = 0;
                            } else {
                                this.fx.add(bcVar);
                                bcVar.n(6L);
                                i = 0;
                            }
                        } else {
                            z = z3;
                        }
                        if (z2) {
                        }
                    }
                    z3 = true;
                } else {
                    this.nr.add(bcVar);
                    bcVar.n(2L);
                    bcVar.a(100002L);
                }
            }
            z = z3;
            z3 = z;
            i = 0;
        }
        boolean z8 = z3;
        if (!this.fx.isEmpty() && (z8 || z4)) {
            u((z8 && z4) ? 3 : z8 ? 1 : z4 ? 2 : 0, this.fx);
        } else {
            fx(this.nr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(List<bc> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : this.b) {
            for (bc bcVar : list) {
                if (str.equals(bcVar.nu())) {
                    arrayList.add(bcVar);
                }
            }
        }
        b(arrayList);
    }

    private void nr(bc bcVar) {
        fx(System.currentTimeMillis());
        if (bcVar.ps() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String strNr = jp.nr(this.l);
            long j = this.jk;
            long j2 = this.f5360a;
            jSONObject.put("cache_get_duration", j - j2 < 0 ? -1L : j - j2);
            long j3 = this.t;
            long j4 = this.jk;
            jSONObject.put("network_check_duration", j3 - j4 < 0 ? -1L : j3 - j4);
            long j5 = this.t;
            long j6 = this.f5360a;
            jSONObject.put("cache_total_duration", j5 - j6 < 0 ? -1L : j5 - j6);
            jSONObject.put("cache_loss_reason", this.x);
            jSONObject.put("correct_action_code", bcVar.ps());
            jSONObject.put("correct_result_code", bcVar.bo());
            jSONObject.put("creative_check_duration", bcVar.is() != null ? bcVar.is().optLong("creative_check_duration", 0L) : -1L);
            com.bytedance.sdk.openadsdk.core.s.b.fx(bcVar, strNr, jSONObject);
        } catch (Exception unused) {
        }
    }

    private void u(final int i, final List<bc> list) {
        Iterator<bc> it = list.iterator();
        long jMin = 2147483647L;
        while (it.hasNext()) {
            JSONObject jSONObjectIs = it.next().is();
            long jOptLong = jSONObjectIs == null ? 0L : jSONObjectIs.optLong("correct_interface_timeout", 0L);
            if (jOptLong > 0) {
                jMin = Math.min(jMin, jOptLong);
            }
        }
        if (jMin == 2147483647L) {
            jMin = 0;
        }
        if (jMin > 0) {
            jk.fx().postDelayed(this.mv, jMin);
        }
        dw.u().u(nr(i, list), new nr<b>() { // from class: com.bytedance.sdk.openadsdk.core.pn.nr.u.2
            @Override // com.bytedance.sdk.openadsdk.core.pn.nr.nr
            public void u(b bVar, long j, long j2) {
                try {
                    u.this.u(i, list, bVar, j);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, List<bc> list, b bVar, long j) throws JSONException {
        if (this.pn.get()) {
            return;
        }
        this.iz.set(true);
        if (bVar == null || bVar.u()) {
            b(Collections.emptyList());
            return;
        }
        if (j != 20000) {
            Iterator<bc> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(100001L);
            }
            nr(this.u);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, JSONObject> map = bVar.nr;
        for (bc bcVar : list) {
            String strU = b.u(bcVar.lk(), bcVar.xx());
            JSONObject jSONObject = TextUtils.isEmpty(strU) ? null : map.get(strU);
            if (jSONObject == null) {
                bcVar.a(100004L);
                arrayList.add(bcVar);
            } else {
                if (jSONObject.has("is_valid")) {
                    if (jSONObject.optBoolean("is_valid")) {
                        if (i == 2 || i == 3) {
                            String strOptString = jSONObject.optString("ext");
                            String strOptString2 = jSONObject.optString("media_ext");
                            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                                bcVar.q(strOptString);
                                bcVar.u(u(new JSONObject(strOptString2), bcVar.sj()));
                            } else {
                                bcVar.a(100006L);
                                arrayList.add(bcVar);
                            }
                        }
                        bcVar.a(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US);
                        arrayList.add(bcVar);
                    } else {
                        arrayList2.add(bcVar);
                        this.x = jSONObject.optString("reason");
                        bcVar.a(100007L);
                    }
                } else {
                    bcVar.a(100005L);
                    arrayList.add(bcVar);
                }
                arrayList.addAll(this.nr);
                nr(arrayList);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    nr((bc) it2.next());
                }
                pn pnVar = this.n;
                if (pnVar != null) {
                    pnVar.fx(arrayList2);
                }
            }
        }
    }

    public static Map<String, Object> u(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null) {
            return map;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private JSONObject u(bc bcVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strLk = bcVar.lk();
            String strAp = bcVar.ap();
            Map<String, Object> mapSj = bcVar.sj();
            String string = "";
            if (mapSj != null) {
                JSONObject jSONObject2 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = mapSj.entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                if (jSONObject2.length() > 0) {
                    string = jSONObject2.toString();
                }
            }
            u(strLk, strAp, string, bcVar.xx(), jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void u(String str, String str2, String str3, String str4, JSONObject jSONObject) throws JSONException {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String upperCase = x.nr("id=" + str + "&timestamp=" + iCurrentTimeMillis + "&ext=" + str2 + "&media_ext=" + str3 + "&req_id=" + str4).toUpperCase();
        jSONObject.put("id", str);
        jSONObject.put("timestamp", iCurrentTimeMillis);
        jSONObject.put("ext", str2);
        jSONObject.put("media_ext", str3);
        jSONObject.put(ReportItem.RequestKeyRequestId, str4);
        jSONObject.put("sign", upperCase);
    }
}
