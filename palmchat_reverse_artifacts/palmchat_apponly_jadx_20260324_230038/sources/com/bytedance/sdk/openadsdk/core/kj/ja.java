package com.bytedance.sdk.openadsdk.core.kj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f5309a;
    private static int b;
    private static int fx;
    private static int jk;
    private static int k;
    private static int l;
    private static int mv;
    private static int my;
    private static int nr;
    private static int o;
    private static int s;
    private static int sx;
    private static int t;
    private static int u;
    private final int bg;
    private final int bq;
    private final int c;
    private final int dw;
    private final int q;
    private final String qq;
    private static final ArrayList<int[]> pn = new ArrayList<>();
    private static final ArrayList<int[]> iz = new ArrayList<>();
    private static final ArrayList<int[]> x = new ArrayList<>();
    private static final ArrayList<int[]> n = new ArrayList<>();
    private static String kj = "已为您延迟到奖励下发后再播放下一个";
    private static int z = 3;
    private static int gi = 0;
    private static int d = 0;

    public ja(JSONObject jSONObject) {
        this.q = jSONObject.optInt("carousel_pos", -1);
        this.bg = jSONObject.optInt("insert_ad_control", 0);
        this.bq = jSONObject.optInt("refresh_ad_control", 0);
        this.c = jSONObject.optInt("refresh_ad_imp_max_time", 0);
        this.dw = jSONObject.optInt("force_refresh_ad_control", 0);
        this.qq = jSONObject.optString("carousel_tip_content", "秒后将继续播放下一个");
    }

    public static int a() {
        return o;
    }

    public static boolean b() {
        return my == 1;
    }

    public static boolean fx() {
        return s == 1;
    }

    public static int iz() {
        return b;
    }

    public static int jk() {
        return sx / 1000;
    }

    public static int l() {
        return z;
    }

    public static int mv() {
        return gi;
    }

    public static int n() {
        return f5309a;
    }

    public static boolean nr() {
        return nr == 1;
    }

    public static int pn() {
        return fx;
    }

    public static int s() {
        return d;
    }

    public static String t() {
        return kj;
    }

    public static void u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                int iOptInt = jSONObjectOptJSONObject.optInt("insert_ad_control", 1);
                u = iOptInt;
                if (iOptInt < 0 || iOptInt > 1) {
                    u = 1;
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("insert_ad_control_fs", 1);
                nr = iOptInt2;
                if (iOptInt2 < 0 || iOptInt2 > 1) {
                    nr = 1;
                }
                fx = jSONObjectOptJSONObject.optInt("insert_ad_req_num", 3);
                b = jSONObjectOptJSONObject.optInt("insert_ad_req_num_fs", 2);
                f5309a = jSONObjectOptJSONObject.optInt("insert_ad_toast_max_time", 5);
                jk = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time", 0);
                t = jSONObjectOptJSONObject.optInt("insert_ad_tip_max_time_fs", 3);
                l = jSONObjectOptJSONObject.optInt("refresh_ad_tip_max_time", 3);
                mv = jSONObjectOptJSONObject.optInt("refresh_ad_tip_max_time_fs", 3);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("refresh_ad_control", 1);
                s = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > 1) {
                    s = 1;
                }
                k = jSONObjectOptJSONObject.optInt("refresh_ad_req_num", 3);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("force_refresh_ad_control", 1);
                my = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > 1) {
                    my = 1;
                }
                o = jSONObjectOptJSONObject.optInt("force_refresh_ad_pause_over_time", 5000);
                sx = jSONObjectOptJSONObject.optInt("refresh_ad_reduce_time", 0);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    pn.add(new int[]{0, 500});
                } else {
                    pn.clear();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 2) {
                            pn.add(new int[]{jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1)});
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time");
                if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) {
                    iz.add(new int[]{0, 500});
                } else {
                    iz.clear();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                        JSONArray jSONArrayOptJSONArray4 = jSONArrayOptJSONArray3.optJSONArray(i2);
                        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() == 2) {
                            iz.add(new int[]{jSONArrayOptJSONArray4.optInt(0), jSONArrayOptJSONArray4.optInt(1)});
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray("insert_ad_pt_show_time_fs");
                if (jSONArrayOptJSONArray5 == null || jSONArrayOptJSONArray5.length() <= 0) {
                    x.add(new int[]{0, 500});
                } else {
                    x.clear();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray5.length(); i3++) {
                        JSONArray jSONArrayOptJSONArray6 = jSONArrayOptJSONArray5.optJSONArray(i3);
                        if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() == 2) {
                            x.add(new int[]{jSONArrayOptJSONArray6.optInt(0), jSONArrayOptJSONArray6.optInt(1)});
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray("insert_ad_vd_show_time_fs");
                if (jSONArrayOptJSONArray7 == null || jSONArrayOptJSONArray7.length() <= 0) {
                    n.add(new int[]{0, 500});
                } else {
                    n.clear();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray7.length(); i4++) {
                        JSONArray jSONArrayOptJSONArray8 = jSONArrayOptJSONArray7.optJSONArray(i4);
                        if (jSONArrayOptJSONArray8 != null && jSONArrayOptJSONArray8.length() == 2) {
                            n.add(new int[]{jSONArrayOptJSONArray8.optInt(0), jSONArrayOptJSONArray8.optInt(1)});
                        }
                    }
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_aggregation_config");
                if (jSONObjectOptJSONObject2 != null) {
                    kj = jSONObjectOptJSONObject2.optString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
                    z = jSONObjectOptJSONObject2.optInt("refresh_ad_clickafter_tip_content_max_time", 3);
                    gi = jSONObjectOptJSONObject2.optInt("refresh_ad_ifclick_swtich");
                    d = jSONObjectOptJSONObject2.optInt("refresh_ad_ifclick_swtich_fs");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static int x() {
        return k;
    }

    public static int b(bc bcVar) {
        ja jaVarX = x(bcVar);
        if (jaVarX == null) {
            return -1;
        }
        return jaVarX.q;
    }

    public static int fx(bc bcVar) {
        ja jaVarX = x(bcVar);
        if (jaVarX == null) {
            return 0;
        }
        return jaVarX.dw;
    }

    public static String iz(bc bcVar) {
        ja jaVarX = x(bcVar);
        return jaVarX == null ? "秒后将继续播放下一个" : jaVarX.qq;
    }

    public static int nr(boolean z2) {
        return z2 ? l : mv;
    }

    public static int pn(bc bcVar) {
        ja jaVarX = x(bcVar);
        if (jaVarX == null) {
            return 0;
        }
        return jaVarX.c;
    }

    private static ja x(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.su();
    }

    private static boolean b(bc bcVar, boolean z2) {
        return (!z2 || nr == 1) && u(bcVar) == 1 && b(bcVar) > 0;
    }

    private static boolean fx(bc bcVar, boolean z2) {
        return (!z2 || u == 1) && u(bcVar) == 1 && b(bcVar) > 0;
    }

    private static boolean nr(boolean z2, int i) {
        if (z2) {
            for (int[] iArr : n) {
                if (i >= iArr[0] && i <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : x) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void nr(com.bytedance.sdk.component.b.nr.fx fxVar) {
        try {
            fxVar.put("insert_ad_control", u);
            fxVar.put("insert_ad_control_fs", nr);
            fxVar.put("insert_ad_req_num", fx);
            fxVar.put("insert_ad_req_num_fs", b);
            fxVar.put("insert_ad_toast_max_time", f5309a);
            fxVar.put("insert_ad_tip_max_time", jk);
            fxVar.put("insert_ad_tip_max_time_fs", t);
            fxVar.put("refresh_ad_tip_max_time", l);
            fxVar.put("refresh_ad_tip_max_time_fs", mv);
            fxVar.put("refresh_ad_control", s);
            fxVar.put("refresh_ad_req_num", k);
            fxVar.put("force_refresh_ad_control", my);
            fxVar.put("force_refresh_ad_pause_over_time", o);
            fxVar.put("refresh_ad_reduce_time", sx);
            ArrayList<int[]> arrayList = pn;
            if (!arrayList.isEmpty()) {
                HashSet hashSet = new HashSet();
                for (int[] iArr : arrayList) {
                    if (iArr != null && iArr.length == 2) {
                        hashSet.add(iArr[0] + "," + iArr[1]);
                    }
                }
                fxVar.put("insert_ad_pt_show_time", hashSet);
            }
            ArrayList<int[]> arrayList2 = iz;
            if (!arrayList2.isEmpty()) {
                HashSet hashSet2 = new HashSet();
                for (int[] iArr2 : arrayList2) {
                    if (iArr2 != null && iArr2.length == 2) {
                        hashSet2.add(iArr2[0] + "," + iArr2[1]);
                    }
                }
                fxVar.put("insert_ad_vd_show_time", hashSet2);
            }
            ArrayList<int[]> arrayList3 = x;
            if (!arrayList3.isEmpty()) {
                HashSet hashSet3 = new HashSet();
                for (int[] iArr3 : arrayList3) {
                    if (iArr3 != null && iArr3.length == 2) {
                        hashSet3.add(iArr3[0] + "," + iArr3[1]);
                    }
                }
                fxVar.put("insert_ad_pt_show_time_fs", hashSet3);
            }
            ArrayList<int[]> arrayList4 = n;
            if (!arrayList4.isEmpty()) {
                HashSet hashSet4 = new HashSet();
                for (int[] iArr4 : arrayList4) {
                    if (iArr4 != null && iArr4.length == 2) {
                        hashSet4.add(iArr4[0] + "," + iArr4[1]);
                    }
                }
                fxVar.put("insert_ad_vd_show_time_fs", hashSet4);
            }
            fxVar.put("refresh_ad_ifclick_swtich_fs", d);
            fxVar.put("refresh_ad_ifclick_swtich", gi);
            fxVar.put("refresh_ad_clickafter_tip_content", kj);
            fxVar.put("refresh_ad_clickafter_tip_content_max_time", z);
        } catch (Exception unused) {
        }
    }

    public void nr(JSONObject jSONObject) {
        try {
            jSONObject.put("carousel_pos", this.q);
            jSONObject.put("insert_ad_control", this.bg);
            jSONObject.put("refresh_ad_control", this.bq);
            jSONObject.put("refresh_ad_imp_max_time", this.c);
            jSONObject.put("force_refresh_ad_control", this.dw);
            jSONObject.put("carousel_tip_content", this.qq);
        } catch (JSONException unused) {
        }
    }

    public static int nr(bc bcVar) {
        ja jaVarX = x(bcVar);
        if (jaVarX == null) {
            return 0;
        }
        return jaVarX.bq;
    }

    public static boolean nr(bc bcVar, boolean z2) {
        return (!z2 || my == 1) && fx(bcVar) == 1 && b(bcVar) > 0;
    }

    public static boolean nr(boolean z2, bc bcVar, boolean z3) {
        return u(z2, bcVar, z3) || u(bcVar, z3) || nr(bcVar, z3);
    }

    public static boolean u() {
        return u == 1;
    }

    public static int u(boolean z2) {
        if (z2) {
            return jk;
        }
        return t;
    }

    public static boolean u(boolean z2, boolean z3, int i) {
        return z2 ? u(z3, i) : nr(z3, i);
    }

    private static boolean u(boolean z2, int i) {
        if (z2) {
            for (int[] iArr : iz) {
                if (i >= iArr[0] && i <= iArr[1]) {
                    return true;
                }
            }
        } else {
            for (int[] iArr2 : pn) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean u(int i, bc bcVar, boolean z2) {
        return pn(bcVar) > 0 && i * 1000 >= pn(bcVar) - (nr(z2) * 1000);
    }

    public static boolean u(int i, bc bcVar) {
        return pn(bcVar) > 0 && i * 1000 >= pn(bcVar);
    }

    public static void u(com.bytedance.sdk.component.b.nr.fx fxVar) {
        try {
            u = fxVar.getInt("insert_ad_control", 1);
            nr = fxVar.getInt("insert_ad_control_fs", 1);
            fx = fxVar.getInt("insert_ad_req_num", 3);
            b = fxVar.getInt("insert_ad_req_num_fs", 2);
            f5309a = fxVar.getInt("insert_ad_toast_max_time", 5);
            jk = fxVar.getInt("insert_ad_tip_max_time", 0);
            t = fxVar.getInt("insert_ad_tip_max_time_fs", 3);
            l = fxVar.getInt("refresh_ad_tip_max_time", 3);
            mv = fxVar.getInt("refresh_ad_tip_max_time_fs", 3);
            s = fxVar.getInt("refresh_ad_control", 1);
            k = fxVar.getInt("refresh_ad_req_num", 3);
            my = fxVar.getInt("force_refresh_ad_control", 1);
            o = fxVar.getInt("force_refresh_ad_pause_over_time", 5000);
            sx = fxVar.getInt("refresh_ad_reduce_time", 0);
            Set<String> stringSet = fxVar.getStringSet("insert_ad_pt_show_time", null);
            if (stringSet != null && !stringSet.isEmpty()) {
                pn.clear();
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split(",");
                    if (strArrSplit.length == 2) {
                        pn.add(new int[]{Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1])});
                    }
                }
            }
            Set<String> stringSet2 = fxVar.getStringSet("insert_ad_vd_show_time", null);
            if (stringSet2 != null && !stringSet2.isEmpty()) {
                iz.clear();
                Iterator<String> it2 = stringSet2.iterator();
                while (it2.hasNext()) {
                    String[] strArrSplit2 = it2.next().split(",");
                    if (strArrSplit2.length == 2) {
                        iz.add(new int[]{Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1])});
                    }
                }
            }
            Set<String> stringSet3 = fxVar.getStringSet("insert_ad_pt_show_time_fs", null);
            if (stringSet3 != null && !stringSet3.isEmpty()) {
                x.clear();
                Iterator<String> it3 = stringSet3.iterator();
                while (it3.hasNext()) {
                    String[] strArrSplit3 = it3.next().split(",");
                    if (strArrSplit3.length == 2) {
                        x.add(new int[]{Integer.parseInt(strArrSplit3[0]), Integer.parseInt(strArrSplit3[1])});
                    }
                }
            }
            Set<String> stringSet4 = fxVar.getStringSet("insert_ad_vd_show_time_fs", null);
            if (stringSet4 != null && !stringSet4.isEmpty()) {
                n.clear();
                Iterator<String> it4 = stringSet4.iterator();
                while (it4.hasNext()) {
                    String[] strArrSplit4 = it4.next().split(",");
                    if (strArrSplit4.length == 2) {
                        n.add(new int[]{Integer.parseInt(strArrSplit4[0]), Integer.parseInt(strArrSplit4[1])});
                    }
                }
            }
            kj = fxVar.getString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
            z = fxVar.getInt("refresh_ad_clickafter_tip_content_max_time", 3);
            gi = fxVar.getInt("refresh_ad_ifclick_swtich", 0);
            d = fxVar.getInt("refresh_ad_ifclick_swtich_fs", 0);
        } catch (Exception unused) {
        }
    }

    public static int u(bc bcVar) {
        ja jaVarX = x(bcVar);
        if (jaVarX == null) {
            return 0;
        }
        return jaVarX.bg;
    }

    public static boolean u(boolean z2, bc bcVar, boolean z3) {
        return z2 ? fx(bcVar, z3) : b(bcVar, z3);
    }

    public static boolean u(bc bcVar, boolean z2) {
        return (!z2 || s == 1) && nr(bcVar) == 1 && b(bcVar) > 0;
    }
}
