package com.bytedance.sdk.openadsdk.core.k;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements Comparable<b> {
    private int fx;
    private final String nr;
    private int pn;
    private long s;
    private int x;
    private final ArrayList<Long> u = new ArrayList<>();
    private final ArrayList<Long> b = new ArrayList<>();
    private final ArrayList<Long> iz = new ArrayList<>();
    private final ArrayList<Long> n = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, pn> f5289a = new HashMap<>();
    private int jk = 0;
    private int t = 0;
    private final HashMap<String, pn> l = new HashMap<>();
    private int mv = 0;

    public b(String str) {
        this.nr = str;
    }

    private void nr(@NonNull JSONArray jSONArray) throws JSONException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        List<Integer> listG = dw.nr().g();
        long j = 60000;
        if (listG != null) {
            int i = 0;
            while (i < listG.size()) {
                int iIntValue = listG.get(i).intValue();
                long j2 = jElapsedRealtime - (((long) iIntValue) * j);
                Iterator<String> it = this.l.keySet().iterator();
                long jU = 0;
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    HashSet hashSet3 = hashSet2;
                    pn pnVar = this.l.get(it.next());
                    if (pnVar != null) {
                        jU += pnVar.u(j2, jElapsedRealtime);
                    }
                    hashSet2 = hashSet3;
                    it = it2;
                }
                HashSet hashSet4 = hashSet2;
                if (jU != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", "lpstay_".concat(String.valueOf(iIntValue)));
                    jSONObject.put("v", jU);
                    jSONArray.put(jSONObject);
                }
                i++;
                hashSet2 = hashSet4;
                j = 60000;
            }
        }
        HashSet hashSet5 = hashSet2;
        if (listG != null) {
            int i2 = 0;
            while (i2 < listG.size()) {
                int iIntValue2 = listG.get(i2).intValue();
                long j3 = jElapsedRealtime - (((long) iIntValue2) * 60000);
                Iterator<String> it3 = this.f5289a.keySet().iterator();
                long jU2 = 0;
                while (it3.hasNext()) {
                    List<Integer> list = listG;
                    pn pnVar2 = this.f5289a.get(it3.next());
                    if (pnVar2 != null) {
                        jU2 += pnVar2.u(j3, jElapsedRealtime);
                    }
                    listG = list;
                }
                List<Integer> list2 = listG;
                if (jU2 != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("t", "vstay_".concat(String.valueOf(iIntValue2)));
                    jSONObject2.put("v", jU2);
                    jSONArray.put(jSONObject2);
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    this.l.remove((String) it4.next());
                }
                Iterator it5 = hashSet5.iterator();
                while (it5.hasNext()) {
                    this.f5289a.remove((String) it5.next());
                }
                i2++;
                listG = list2;
            }
        }
        if (dw.nr().pu() && this.jk != 0) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("t", "vstay_0");
            jSONObject3.put("v", this.jk);
            jSONArray.put(jSONObject3);
        }
        if (dw.nr().pu() && this.mv != 0) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("t", "lpstay_0");
            jSONObject4.put("v", this.mv);
            jSONArray.put(jSONObject4);
        }
        if (this.t != 0) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("t", "v30p");
            jSONObject5.put("v", this.t);
            jSONArray.put(jSONObject5);
        }
    }

    public void u(@NonNull String str, @Nullable String str2) {
        pn pnVar;
        pn pnVar2;
        pn pnVar3;
        pn pnVar4;
        pn pnVar5;
        pn pnVar6;
        str.hashCode();
        switch (str) {
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (pnVar = this.l.get(str2)) != null) {
                    pnVar.b(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (pnVar2 = this.l.get(str2)) != null) {
                    pnVar2.fx(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2)) {
                    pn pnVar7 = this.l.get(str2);
                    if (pnVar7 == null) {
                        pnVar7 = new pn();
                        this.l.put(str2, pnVar7);
                    }
                    pnVar7.u(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
                if (!TextUtils.isEmpty(str2) && (pnVar3 = this.f5289a.get(str2)) != null && pnVar3.u() != pn.pn) {
                    pnVar3.nr(SystemClock.elapsedRealtime());
                    if (dw.nr().pu()) {
                        this.jk = (int) (((long) this.jk) + pnVar3.u(this.s, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "show":
                this.u.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (dw.nr().pu()) {
                    this.fx++;
                    break;
                }
                break;
            case "click":
                this.b.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (dw.nr().pu()) {
                    this.pn++;
                    break;
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (pnVar4 = this.f5289a.get(str2)) != null) {
                    pnVar4.b(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (pnVar5 = this.f5289a.get(str2)) != null) {
                    pnVar5.fx(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (pnVar6 = this.l.get(str2)) != null && pnVar6.u() != pn.pn) {
                    pnVar6.nr(SystemClock.elapsedRealtime());
                    if (dw.nr().pu()) {
                        this.mv = (int) (((long) this.mv) + pnVar6.u(this.s, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "videoPercent30":
                if (dw.nr().pu()) {
                    this.t++;
                    break;
                }
                break;
            case "dislike":
                this.n.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
            case "play_start":
                this.iz.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (dw.nr().pu()) {
                    this.x++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    pn pnVar8 = this.f5289a.get(str2);
                    if (pnVar8 == null) {
                        pnVar8 = new pn();
                        this.f5289a.put(str2, pnVar8);
                    }
                    pnVar8.u(SystemClock.elapsedRealtime());
                    break;
                }
                break;
        }
    }

    public void nr() {
        this.s = SystemClock.elapsedRealtime();
        this.t = 0;
        this.pn = 0;
        this.fx = 0;
        this.mv = 0;
        this.jk = 0;
        this.x = 0;
    }

    public JSONArray u() {
        JSONArray jSONArray = new JSONArray();
        try {
            u(jSONArray);
            nr(jSONArray);
        } catch (Throwable th) {
            k.u(th.getMessage());
        }
        return jSONArray;
    }

    private void u(String str, JSONArray jSONArray, ArrayList<Long> arrayList, List<Integer> list, long j) throws JSONException {
        int size = arrayList.size() - 1;
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            long j2 = j - (((long) iIntValue) * 60000);
            while (size >= 0 && arrayList.get(size).longValue() >= j2) {
                i++;
                size--;
            }
            if (i != 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", str + iIntValue);
                jSONObject.put("v", i);
                jSONArray.put(jSONObject);
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void u(@NonNull JSONArray jSONArray) throws JSONException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        u("show_", jSONArray, this.u, dw.nr().g(), jElapsedRealtime);
        u("click_", jSONArray, this.b, dw.nr().g(), jElapsedRealtime);
        u("play_", jSONArray, this.iz, dw.nr().g(), jElapsedRealtime);
        u("dis_", jSONArray, this.n, dw.nr().g(), jElapsedRealtime);
        if (dw.nr().pu() && this.fx != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", "show_0");
            jSONObject.put("v", this.fx);
            jSONArray.put(jSONObject);
        }
        if (dw.nr().pu() && this.pn != 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("t", "click_0");
            jSONObject2.put("v", this.pn);
            jSONArray.put(jSONObject2);
        }
        if (!dw.nr().pu() || this.x == 0) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("t", "play_0");
        jSONObject3.put("v", this.x);
        jSONArray.put(jSONObject3);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        return bVar.fx - this.fx;
    }
}
