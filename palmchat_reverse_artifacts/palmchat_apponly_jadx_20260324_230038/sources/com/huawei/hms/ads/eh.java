package com.huawei.hms.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.server.AppConfigRsp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class eh {
    private static final int B = 0;
    private static final int C = 30;
    private static final String Code = "SpHandler";
    private static eh D = null;
    private static final long I = 5;
    private static final int V = 60;
    private static final int Z = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f6560a = new byte[0];
    private static final int e = 85;
    private static final int f = 119;
    private static final int g = 5;
    private static final int h = 60;
    private static final int i = 10080;
    private SharedPreferences F;
    private Map<String, String> L;
    private final SharedPreferences S;
    private final byte[] b = new byte[0];
    private String c;
    private Context d;

    private eh(Context context) {
        this.L = new HashMap();
        Context contextL = com.huawei.openalliance.ad.utils.q.L(context.getApplicationContext());
        this.d = contextL;
        this.S = contextL.getSharedPreferences(com.huawei.openalliance.ad.constant.w.Code, 0);
        try {
            this.F = context.getSharedPreferences(com.huawei.openalliance.ad.constant.w.Code, 0);
        } catch (Throwable unused) {
            this.F = null;
            fh.I(Code, "create sp error.");
        }
        at();
        this.c = new com.huawei.openalliance.ad.utils.n(this.d).Code();
        this.L = (Map) com.huawei.openalliance.ad.utils.ad.V(av(), Map.class, new Class[0]);
    }

    private int Code(String str, int i2) {
        if (com.huawei.openalliance.ad.utils.bc.Code(str)) {
            return i2;
        }
        synchronized (this.b) {
            Map<String, String> map = this.L;
            if (map == null) {
                return i2;
            }
            return com.huawei.openalliance.ad.utils.bc.Code(map.get(str), i2);
        }
    }

    private void at() {
        if (au()) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = this.F;
            if (sharedPreferences == null) {
                if (fh.Code()) {
                    fh.Code(Code, "there is no old config file");
                    return;
                }
                return;
            }
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null && !all.isEmpty()) {
                Set<Map.Entry<String, ?>> setEntrySet = all.entrySet();
                if (setEntrySet != null && !setEntrySet.isEmpty()) {
                    SharedPreferences.Editor editorEdit = this.S.edit();
                    Iterator<Map.Entry<String, ?>> it = setEntrySet.iterator();
                    while (it.hasNext()) {
                        Code(it.next(), editorEdit);
                    }
                    editorEdit.commit();
                }
                B(true);
                return;
            }
            if (fh.Code()) {
                fh.Code(Code, "there is no old config file");
            }
        } catch (Throwable th) {
            fh.I(Code, "restore config error:" + th.getClass().getSimpleName());
        }
    }

    private boolean au() {
        boolean z;
        synchronized (this.b) {
            z = this.S.getBoolean(com.huawei.openalliance.ad.constant.w.al, false);
        }
        return z;
    }

    private String av() {
        String string;
        synchronized (this.b) {
            string = this.S.getString(com.huawei.openalliance.ad.constant.w.an, "");
        }
        return string;
    }

    private String aw() {
        String string;
        synchronized (this.b) {
            string = this.S.getString(com.huawei.openalliance.ad.constant.w.o, "");
        }
        return string;
    }

    private int ax() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.ag, 2);
        }
        return i2;
    }

    public int A() {
        int iIntValue;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.E)) : null;
            iIntValue = (numF == null || numF.intValue() < 0 || numF.intValue() > 24) ? 3 : numF.intValue();
        }
        return iIntValue;
    }

    public int B() {
        int i2;
        synchronized (this.b) {
            int i3 = 0;
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.S, 0);
            if (i2 == 0) {
                int iAx = ax();
                if (iAx != 1) {
                    i3 = iAx;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public void C(int i2) {
        synchronized (this.b) {
            this.S.edit().putInt("splash_skip_area", i2).commit();
        }
    }

    public int D() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt("splash_skip_area", 0);
        }
        return i2;
    }

    public String E() {
        String strV;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            strV = map != null ? com.huawei.openalliance.ad.utils.bc.V(map.get(com.huawei.openalliance.ad.constant.w.G)) : null;
        }
        return strV;
    }

    public long F() {
        long jMax;
        synchronized (this.b) {
            jMax = Math.max(this.S.getLong(com.huawei.openalliance.ad.constant.w.I, 1800000L), 300000L);
        }
        return jMax;
    }

    public int G() {
        int iIntValue;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.H)) : null;
            iIntValue = (numF == null || numF.intValue() <= 0) ? 0 : numF.intValue();
        }
        return iIntValue;
    }

    public String H() {
        String strV;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            strV = map != null ? com.huawei.openalliance.ad.utils.bc.V(map.get(com.huawei.openalliance.ad.constant.w.J)) : null;
        }
        return strV;
    }

    public int I() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.C, 5000);
        }
        return i2;
    }

    public int J() {
        int iIntValue;
        synchronized (this.b) {
            Integer numF = !com.huawei.openalliance.ad.utils.al.Code(this.L) ? com.huawei.openalliance.ad.utils.bc.F(this.L.get(com.huawei.openalliance.ad.constant.w.K)) : null;
            iIntValue = 35;
            if (numF != null && numF.intValue() >= 35) {
                iIntValue = numF.intValue();
            }
        }
        return iIntValue;
    }

    public int K() {
        int iIntValue;
        synchronized (this.b) {
            Integer numF = !com.huawei.openalliance.ad.utils.al.Code(this.L) ? com.huawei.openalliance.ad.utils.bc.F(this.L.get(com.huawei.openalliance.ad.constant.w.M)) : null;
            iIntValue = (numF == null || numF.intValue() < 10) ? 15 : numF.intValue();
        }
        return iIntValue;
    }

    public int L() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.L, 0);
        }
        return i2;
    }

    public int M() {
        int iIntValue;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.N)) : null;
            iIntValue = (numF == null || numF.intValue() <= 0) ? 56 : numF.intValue();
        }
        return iIntValue;
    }

    public int N() {
        int iIntValue;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.P)) : null;
            iIntValue = (numF == null || numF.intValue() <= 0) ? 16 : numF.intValue();
        }
        return iIntValue;
    }

    public int O() {
        int iIntValue;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.Q)) : null;
            iIntValue = (numF == null || numF.intValue() <= 0) ? 36 : numF.intValue();
        }
        return iIntValue;
    }

    public int P() {
        int iIntValue;
        synchronized (this.b) {
            synchronized (this.b) {
                Map<String, String> map = this.L;
                Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.T)) : null;
                iIntValue = (numF == null || numF.intValue() < 0) ? 60 : numF.intValue();
            }
        }
        return iIntValue;
    }

    public int Q() {
        int iIntValue;
        synchronized (this.b) {
            synchronized (this.b) {
                Map<String, String> map = this.L;
                Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.W)) : null;
                iIntValue = (numF == null || numF.intValue() <= 0) ? 200 : numF.intValue();
            }
        }
        return iIntValue;
    }

    public Map<String, String> R() {
        Map<String, String> map;
        synchronized (this.b) {
            synchronized (this.b) {
                Map<String, String> map2 = this.L;
                map = map2 != null ? (Map) com.huawei.openalliance.ad.utils.ad.V(map2.get(com.huawei.openalliance.ad.constant.w.U), Map.class, new Class[0]) : null;
            }
        }
        return map;
    }

    public long S() {
        long j;
        synchronized (this.b) {
            j = this.S.getLong(com.huawei.openalliance.ad.constant.w.V, 1800000L);
        }
        return j;
    }

    public Long T() {
        Long lValueOf;
        synchronized (this.b) {
            lValueOf = Long.valueOf(this.S.getLong(com.huawei.openalliance.ad.constant.w.ab, 0L));
        }
        return lValueOf;
    }

    public int U() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.ac, 0);
        }
        return i2;
    }

    public int V() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.B, 3000);
        }
        return i2;
    }

    public String W() {
        String string;
        synchronized (this.b) {
            string = this.S.getString(com.huawei.openalliance.ad.constant.w.ad, null);
        }
        return string;
    }

    public int X() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.ae, 100);
        }
        return i2;
    }

    public String Y() {
        String string;
        synchronized (this.b) {
            string = this.S.getString(com.huawei.openalliance.ad.constant.w.af, this.c);
        }
        return string;
    }

    public int Z() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.S, ax());
        }
        return i2;
    }

    public int a() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.f6928a, 2000);
        }
        return i2;
    }

    public boolean aa() {
        boolean z;
        synchronized (this.b) {
            z = this.S.getBoolean("full_screen_notify", true);
        }
        return z;
    }

    public int ab() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.ai, 0);
        }
        return i2;
    }

    public int ac() {
        synchronized (this.b) {
            if (!cn.Code(this.d).V()) {
                return 0;
            }
            return this.S.getInt(com.huawei.openalliance.ad.constant.w.aq, 0);
        }
    }

    public int ad() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.aj, 0) * 1000;
        }
        return i2;
    }

    public boolean ae() {
        boolean z;
        synchronized (this.b) {
            z = this.S.getBoolean(com.huawei.openalliance.ad.constant.w.ak, false);
        }
        return z;
    }

    public int af() {
        synchronized (this.b) {
            Integer numF = !com.huawei.openalliance.ad.utils.al.Code(this.L) ? com.huawei.openalliance.ad.utils.bc.F(this.L.get("preRequest")) : null;
            if (numF == null) {
                return 0;
            }
            return numF.intValue();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean ag() {
        boolean z;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.X)) : null;
            if (numF != null) {
                z = true;
                if (numF.intValue() != 1) {
                    z = false;
                }
            }
        }
        return z;
    }

    public long ah() {
        long j;
        synchronized (this.b) {
            j = this.S.getLong(com.huawei.openalliance.ad.constant.w.b, 0L);
        }
        return j;
    }

    public int ai() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.as, 30);
        }
        return i2;
    }

    public String aj() {
        String string;
        synchronized (this.b) {
            string = this.S.getString(com.huawei.openalliance.ad.constant.w.ar, "");
        }
        return string;
    }

    public Set<String> ak() {
        Set<String> stringSet;
        synchronized (this.b) {
            stringSet = this.S.getStringSet(com.huawei.openalliance.ad.constant.w.at, new HashSet());
        }
        return stringSet;
    }

    public boolean al() {
        synchronized (this.b) {
            if (!com.huawei.openalliance.ad.utils.q.V(this.d)) {
                return false;
            }
            fh.Code(Code, "isSingleMediaPlayerInstance, is tv");
            Set<String> stringSet = this.S.getStringSet(com.huawei.openalliance.ad.constant.w.au, new HashSet());
            String strCode = com.huawei.openalliance.ad.utils.q.Code();
            if (!com.huawei.openalliance.ad.utils.ag.Code(stringSet) && !TextUtils.isEmpty(strCode)) {
                return com.huawei.openalliance.ad.utils.bc.Code(stringSet, strCode.toUpperCase(Locale.ENGLISH));
            }
            return true;
        }
    }

    public int am() {
        int i2;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            i2 = 0;
            int iCode = (map == null || TextUtils.isEmpty(map.get(com.huawei.openalliance.ad.constant.w.am))) ? 0 : com.huawei.openalliance.ad.utils.bc.Code(this.L.get(com.huawei.openalliance.ad.constant.w.am), 0);
            if (iCode == 0 || iCode == 1) {
                i2 = iCode;
            }
        }
        return i2;
    }

    public String an() {
        String string;
        synchronized (this.b) {
            string = this.S.getString("sha256", "");
        }
        return string;
    }

    public long ao() {
        synchronized (this.b) {
            Map<String, String> map = this.L;
            if (map == null) {
                return 5000L;
            }
            String str = map.get(com.huawei.openalliance.ad.constant.w.aw);
            if (TextUtils.isEmpty(str)) {
                return 5000L;
            }
            long jCode = com.huawei.openalliance.ad.utils.bc.Code(str, 5L);
            return jCode >= 0 ? jCode * 1000 : 5000L;
        }
    }

    public Map<String, String> ap() {
        Map<String, String> map;
        synchronized (this.b) {
            String packageName = this.d.getPackageName();
            Map<String, String> map2 = this.L;
            Map map3 = map2 != null ? (Map) com.huawei.openalliance.ad.utils.ad.V(map2.get(com.huawei.openalliance.ad.constant.w.ax), Map.class, new Class[0]) : null;
            return (map3 == null || !map3.containsKey(packageName) || (map = (Map) com.huawei.openalliance.ad.utils.ad.V((String) map3.get(packageName), Map.class, new Class[0])) == null) ? new HashMap() : map;
        }
    }

    public long aq() {
        long j;
        synchronized (this.b) {
            j = this.S.getLong(com.huawei.openalliance.ad.constant.w.aC, 0L);
        }
        return j;
    }

    public Map<String, String> ar() {
        Map<String, String> map;
        try {
            synchronized (this.b) {
                Map<String, String> map2 = this.L;
                map = map2 != null ? (Map) com.huawei.openalliance.ad.utils.ad.V(map2.get(com.huawei.openalliance.ad.constant.w.aE), Map.class, new Class[0]) : null;
            }
            return map;
        } catch (Throwable th) {
            fh.Z(Code, "getIconListTitleMap err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public Map<String, String> as() {
        Map<String, String> map;
        try {
            synchronized (this.b) {
                Map<String, String> map2 = this.L;
                map = map2 != null ? (Map) com.huawei.openalliance.ad.utils.ad.V(map2.get(com.huawei.openalliance.ad.constant.w.aF), Map.class, new Class[0]) : null;
            }
            return map;
        } catch (Throwable th) {
            fh.Z(Code, "getSingleSlotAdsCountMap err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public int b() {
        int i2;
        synchronized (this.b) {
            int iL = 1 == Z() ? L() : 2000;
            if (com.huawei.openalliance.ad.utils.q.V(this.d)) {
                iL = a();
            }
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.D, iL);
        }
        return i2;
    }

    public long c() {
        long j;
        synchronized (this.b) {
            j = this.S.getLong(com.huawei.openalliance.ad.constant.w.c, 300L);
        }
        return j;
    }

    public int d() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.d, 0);
        }
        return i2;
    }

    public int e() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.e, 0);
        }
        return i2;
    }

    public String f() {
        String string;
        synchronized (this.b) {
            string = this.S.getString(com.huawei.openalliance.ad.constant.w.f, "");
        }
        return string;
    }

    public boolean g() {
        boolean z;
        synchronized (this.b) {
            z = this.S.getBoolean(com.huawei.openalliance.ad.constant.w.j, false);
        }
        return z;
    }

    public long h() {
        Long lValueOf = Long.valueOf(Code(com.huawei.openalliance.ad.constant.w.l, 5L) * 60000);
        if (lValueOf.longValue() < 0) {
            return 300000L;
        }
        return lValueOf.longValue();
    }

    public boolean i() {
        boolean z;
        synchronized (this.b) {
            z = this.S.getBoolean(com.huawei.openalliance.ad.constant.w.k, true);
        }
        return z;
    }

    public long j() {
        long j;
        synchronized (this.b) {
            j = this.S.getLong(com.huawei.openalliance.ad.constant.w.m, 0L);
        }
        return j;
    }

    public int k() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.h, 360);
        }
        return i2;
    }

    public long l() {
        long j;
        synchronized (this.b) {
            j = this.S.getLong(com.huawei.openalliance.ad.constant.w.i, 0L);
        }
        return j;
    }

    public boolean m() {
        Integer numCode = com.huawei.openalliance.ad.utils.bd.Code(aw(), 1);
        return numCode != null && numCode.intValue() == 1;
    }

    public Set<String> n() {
        Set<String> stringSet;
        synchronized (this.b) {
            stringSet = this.S.getStringSet(com.huawei.openalliance.ad.constant.w.p, com.huawei.openalliance.ad.constant.aa.Code);
        }
        return stringSet;
    }

    public int o() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.q, 0);
        }
        return i2;
    }

    public long p() {
        long j;
        synchronized (this.b) {
            j = this.S.getLong(com.huawei.openalliance.ad.constant.w.s, 30L);
        }
        return j;
    }

    public long q() {
        long j;
        synchronized (this.b) {
            j = this.S.getInt(com.huawei.openalliance.ad.constant.w.u, 60);
        }
        return j;
    }

    public long r() {
        long j;
        synchronized (this.b) {
            j = this.S.getLong(com.huawei.openalliance.ad.constant.w.t, 120L);
        }
        return j;
    }

    public int s() {
        int i2;
        synchronized (this.b) {
            i2 = this.S.getInt(com.huawei.openalliance.ad.constant.w.n, com.huawei.openalliance.ad.constant.x.e);
        }
        return i2;
    }

    public String t() {
        String string;
        synchronized (this.b) {
            string = this.S.getString(com.huawei.openalliance.ad.constant.w.v, null);
        }
        return string;
    }

    public float u() {
        float f2;
        synchronized (this.b) {
            f2 = this.S.getFloat(com.huawei.openalliance.ad.constant.w.x, 0.05f);
        }
        return f2;
    }

    public int v() {
        try {
            return ((Integer) Class.forName("com.huawei.openalliance.ad.ppskit.utils.SdkSpFunctionWrapper").getMethod("getAdsCoreSelection", new Class[0]).invoke(null, new Object[0])).intValue();
        } catch (Throwable unused) {
            fh.V(Code, "function wrapper not found");
            if (!cn.V(this.d) && cn.Code(this.d).V()) {
                return 1;
            }
            synchronized (this.b) {
                String strCode = com.huawei.openalliance.ad.utils.bg.Code(this.d, com.huawei.openalliance.ad.constant.x.bQ);
                if (!TextUtils.isEmpty(strCode)) {
                    int i2 = com.huawei.openalliance.ad.constant.f.Z.equalsIgnoreCase(strCode) ? 1 : com.huawei.openalliance.ad.constant.f.B.equalsIgnoreCase(strCode) ? 0 : com.huawei.openalliance.ad.constant.f.C.equalsIgnoreCase(strCode) ? 2 : -1;
                    if (i2 != -1) {
                        return i2;
                    }
                }
                return this.S.getInt(com.huawei.openalliance.ad.constant.w.Y, (!cn.V(this.d) || cn.Code(this.d).V()) ? 1 : 0);
            }
        }
    }

    public String w() {
        String string;
        synchronized (this.b) {
            string = this.S.getString(com.huawei.openalliance.ad.constant.w.aa, "");
        }
        return string;
    }

    public int x() {
        int iIntValue;
        synchronized (this.b) {
            synchronized (this.b) {
                Map<String, String> map = this.L;
                Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.y)) : null;
                iIntValue = (numF == null || numF.intValue() <= 0) ? 10 : numF.intValue();
            }
        }
        return iIntValue;
    }

    public int y() {
        synchronized (this.b) {
            Map<String, String> map = this.L;
            Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.z)) : null;
            if (numF != null && numF.intValue() >= 0) {
                if (numF.intValue() <= 4) {
                    return numF.intValue();
                }
                return 0;
            }
            return 0;
        }
    }

    public String z() {
        String strV;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            strV = map != null ? com.huawei.openalliance.ad.utils.bc.V(map.get(com.huawei.openalliance.ad.constant.w.A)) : null;
        }
        return strV;
    }

    private long Code(String str, long j) {
        if (com.huawei.openalliance.ad.utils.bc.Code(str)) {
            return j;
        }
        synchronized (this.b) {
            Map<String, String> map = this.L;
            if (map == null) {
                return j;
            }
            return com.huawei.openalliance.ad.utils.bc.Code(map.get(str), j);
        }
    }

    private static eh I(Context context) {
        eh ehVar;
        synchronized (f6560a) {
            if (D == null) {
                D = new eh(context);
            }
            ehVar = D;
        }
        return ehVar;
    }

    public void B(int i2) {
        synchronized (this.b) {
            if (i2 > 0) {
                this.S.edit().putInt(com.huawei.openalliance.ad.constant.w.ae, i2).commit();
            }
        }
    }

    public void C(String str) {
        synchronized (this.b) {
            this.S.edit().putString("sha256", str).commit();
        }
    }

    public boolean D(String str) {
        boolean zEquals;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            zEquals = "1".equals(map != null ? map.get(com.huawei.openalliance.ad.constant.w.az) : null);
        }
        return zEquals;
    }

    public String F(String str) {
        if (com.huawei.openalliance.ad.utils.bc.Code(str)) {
            return null;
        }
        synchronized (this.b) {
            if (com.huawei.openalliance.ad.utils.al.Code(this.L)) {
                return null;
            }
            return this.L.get(str);
        }
    }

    public int L(String str) {
        int iCode;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            iCode = (map != null ? com.huawei.openalliance.ad.utils.bc.Code(map.get(com.huawei.openalliance.ad.constant.w.aA), 60) : 60) * 60000;
        }
        return iCode;
    }

    public void S(int i2) {
        synchronized (this.b) {
            this.S.edit().putInt(com.huawei.openalliance.ad.constant.w.ag, i2).commit();
        }
    }

    public int V(Context context) {
        int iIntValue;
        synchronized (this.b) {
            boolean zH = com.huawei.openalliance.ad.utils.z.h(context);
            iIntValue = zH ? 98 : 64;
            int i2 = zH ? 119 : 85;
            Map<String, String> map = this.L;
            Integer numF = map != null ? com.huawei.openalliance.ad.utils.bc.F(map.get(com.huawei.openalliance.ad.constant.w.O)) : null;
            if (numF != null && numF.intValue() > 0 && numF.intValue() <= i2) {
                iIntValue = numF.intValue();
            }
        }
        return iIntValue;
    }

    public void Z(int i2) {
        synchronized (this.b) {
            if (i2 > 0) {
                this.S.edit().putInt(com.huawei.openalliance.ad.constant.w.ac, i2).commit();
            }
        }
    }

    public int a(String str) {
        int i2;
        synchronized (this.b) {
            Map<String, String> map = this.L;
            int iCode = i;
            if (map != null) {
                iCode = com.huawei.openalliance.ad.utils.bc.Code(map.get(com.huawei.openalliance.ad.constant.w.aB), i);
            }
            i2 = iCode * 60000;
        }
        return i2;
    }

    public static eh Code(Context context) {
        return I(context);
    }

    public void B(String str) {
        synchronized (this.b) {
            this.S.edit().putString(com.huawei.openalliance.ad.constant.w.ar, str).commit();
        }
    }

    public boolean C() {
        synchronized (this.b) {
            return Integer.valueOf(this.S.getInt(com.huawei.openalliance.ad.constant.w.Z, 0)).intValue() == 1;
        }
    }

    public void F(int i2) {
        synchronized (this.b) {
            this.S.edit().putInt(com.huawei.openalliance.ad.constant.w.ai, i2).commit();
        }
    }

    public void I(int i2) {
        synchronized (this.b) {
            SharedPreferences.Editor editorEdit = this.S.edit();
            editorEdit.putInt(com.huawei.openalliance.ad.constant.w.q, i2);
            editorEdit.commit();
        }
    }

    public boolean S(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, String> map = this.L;
        List list = (List) com.huawei.openalliance.ad.utils.ad.V(map != null ? map.get(com.huawei.openalliance.ad.constant.w.g) : null, List.class, String.class);
        return list == null ? com.huawei.openalliance.ad.constant.dg.V(str) : list.contains(str);
    }

    public void V(int i2) {
        synchronized (this.b) {
            this.S.edit().putInt(com.huawei.openalliance.ad.constant.w.f6928a, i2).commit();
        }
    }

    public void Z(long j) {
        if (j <= 0) {
            return;
        }
        synchronized (this.b) {
            this.S.edit().putLong(com.huawei.openalliance.ad.constant.w.aC, j).commit();
        }
    }

    private void B(boolean z) {
        synchronized (this.b) {
            this.S.edit().putBoolean(com.huawei.openalliance.ad.constant.w.al, z).commit();
        }
    }

    public String Code() {
        String string;
        synchronized (this.b) {
            string = this.S.getString(com.huawei.openalliance.ad.constant.w.ap, "");
        }
        return string;
    }

    public void I(long j) {
        synchronized (this.b) {
            this.S.edit().putLong(com.huawei.openalliance.ad.constant.w.b, j).commit();
        }
    }

    public void V(long j) {
        synchronized (this.b) {
            if (j > 0) {
                this.S.edit().putLong(com.huawei.openalliance.ad.constant.w.ab, j).commit();
            }
        }
    }

    public void Z(String str) {
        synchronized (this.b) {
            if (!com.huawei.openalliance.ad.utils.bc.Code(str)) {
                this.S.edit().putString(com.huawei.openalliance.ad.constant.w.af, str).commit();
            }
        }
    }

    private void V(SharedPreferences.Editor editor, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            editor.putString(com.huawei.openalliance.ad.constant.w.an, jSONObject.toString());
            this.L = (Map) com.huawei.openalliance.ad.utils.ad.V(jSONObject.toString(), Map.class, new Class[0]);
        } catch (JSONException unused) {
            fh.Z(Code, "putConfigMap JSONException");
        }
    }

    public void Code(int i2) {
        synchronized (this.b) {
            this.S.edit().putInt(com.huawei.openalliance.ad.constant.w.L, i2).commit();
        }
    }

    public void I(String str) {
        synchronized (this.b) {
            if (!TextUtils.isEmpty(str)) {
                this.S.edit().putString(com.huawei.openalliance.ad.constant.w.o, str).commit();
            }
        }
    }

    public void Z(boolean z) {
        synchronized (this.b) {
            this.S.edit().putBoolean(com.huawei.openalliance.ad.constant.w.ak, z).commit();
        }
    }

    public void Code(long j) {
        synchronized (this.b) {
            this.S.edit().putLong(com.huawei.openalliance.ad.constant.w.i, j).commit();
        }
    }

    public void I(boolean z) {
        synchronized (this.b) {
            this.S.edit().putBoolean("full_screen_notify", z).commit();
        }
    }

    public void V(String str) {
        synchronized (this.b) {
            if (!TextUtils.isEmpty(str)) {
                this.S.edit().putString(com.huawei.openalliance.ad.constant.w.ad, str).commit();
            }
        }
    }

    private void Code(SharedPreferences.Editor editor, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("trustAppList", jSONObject);
            Code(editor, com.huawei.openalliance.ad.constant.w.ap, jSONObject2.toString());
        } catch (JSONException unused) {
            fh.Z(Code, "putTrustAppList JSONException");
        }
    }

    public void V(boolean z) {
        synchronized (this.b) {
            this.S.edit().putBoolean(com.huawei.openalliance.ad.constant.w.k, z).commit();
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Integer num) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Integer num, int i2) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        } else {
            editor.putInt(str, i2);
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Long l) {
        if (l != null) {
            editor.putLong(str, l.longValue());
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, String str2) {
        if (str2 != null) {
            editor.putString(str, str2);
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public void Code(AppConfigRsp appConfigRsp) {
        synchronized (this.b) {
            SharedPreferences.Editor editorEdit = this.S.edit();
            editorEdit.putLong(com.huawei.openalliance.ad.constant.w.V, appConfigRsp.f().longValue());
            editorEdit.putLong(com.huawei.openalliance.ad.constant.w.I, appConfigRsp.h().longValue());
            editorEdit.putInt(com.huawei.openalliance.ad.constant.w.Z, appConfigRsp.g());
            editorEdit.putInt(com.huawei.openalliance.ad.constant.w.B, appConfigRsp.C());
            editorEdit.putInt(com.huawei.openalliance.ad.constant.w.C, appConfigRsp.S());
            Code(editorEdit, com.huawei.openalliance.ad.constant.w.S, appConfigRsp.F());
            editorEdit.putInt("splash_skip_area", appConfigRsp.D());
            if (com.huawei.openalliance.ad.utils.q.V(this.d)) {
                Code(editorEdit, com.huawei.openalliance.ad.constant.w.D, appConfigRsp.B());
            } else {
                Code(editorEdit, com.huawei.openalliance.ad.constant.w.D, appConfigRsp.B(), 2000);
            }
            editorEdit.putLong(com.huawei.openalliance.ad.constant.w.c, appConfigRsp.Z());
            editorEdit.putInt(com.huawei.openalliance.ad.constant.w.d, appConfigRsp.I());
            Code(editorEdit, com.huawei.openalliance.ad.constant.w.h, appConfigRsp.L());
            editorEdit.putLong(com.huawei.openalliance.ad.constant.w.i, System.currentTimeMillis());
            editorEdit.putString(com.huawei.openalliance.ad.constant.w.o, appConfigRsp.a());
            editorEdit.putLong(com.huawei.openalliance.ad.constant.w.r, appConfigRsp.c());
            editorEdit.putFloat(com.huawei.openalliance.ad.constant.w.x, (float) appConfigRsp.i());
            Code(editorEdit, com.huawei.openalliance.ad.constant.w.s, appConfigRsp.d());
            Code(editorEdit, com.huawei.openalliance.ad.constant.w.t, appConfigRsp.e());
            Code(editorEdit, com.huawei.openalliance.ad.constant.w.Y, appConfigRsp.j());
            editorEdit.putString(com.huawei.openalliance.ad.constant.w.aa, appConfigRsp.k());
            V(editorEdit, appConfigRsp.l());
            Code(editorEdit, com.huawei.openalliance.ad.constant.w.u, appConfigRsp.m());
            Code(editorEdit, appConfigRsp.V());
            Code(editorEdit, com.huawei.openalliance.ad.constant.w.aq, appConfigRsp.n());
            Code(editorEdit, com.huawei.openalliance.ad.constant.w.aj, appConfigRsp.o());
            Code(editorEdit, com.huawei.openalliance.ad.constant.w.as, appConfigRsp.p());
            Code(appConfigRsp.q());
            Code(editorEdit, "sha256", appConfigRsp.r());
            List<String> listB = appConfigRsp.b();
            if (!com.huawei.openalliance.ad.utils.ag.Code(listB)) {
                editorEdit.putStringSet(com.huawei.openalliance.ad.constant.w.p, new HashSet(listB));
            }
            editorEdit.commit();
        }
    }

    public void Code(String str) {
        synchronized (this.b) {
            if (!TextUtils.isEmpty(str)) {
                this.S.edit().putString(com.huawei.openalliance.ad.constant.w.v, str).commit();
            }
        }
    }

    public void Code(List<String> list) {
        synchronized (this.b) {
            if (!com.huawei.openalliance.ad.utils.ag.Code(list)) {
                this.S.edit().putStringSet(com.huawei.openalliance.ad.constant.w.au, com.huawei.openalliance.ad.utils.ag.Code(list, true)).commit();
            }
        }
    }

    private void Code(Map.Entry<String, ?> entry, SharedPreferences.Editor editor) {
        if (entry == null || editor == null) {
            return;
        }
        Object value = entry.getValue();
        String key = entry.getKey();
        if (value instanceof Integer) {
            editor.putInt(key, ((Integer) value).intValue());
            return;
        }
        if (value instanceof Boolean) {
            editor.putBoolean(key, ((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Long) {
            editor.putLong(key, ((Long) value).longValue());
            return;
        }
        if (value instanceof Float) {
            editor.putFloat(key, ((Float) value).floatValue());
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, new HashSet((Set) value));
        }
    }

    public void Code(Set<String> set) {
        synchronized (this.b) {
            SharedPreferences.Editor editorEdit = this.S.edit();
            if (com.huawei.openalliance.ad.utils.ag.Code(set)) {
                editorEdit.putStringSet(com.huawei.openalliance.ad.constant.w.at, null);
            } else {
                editorEdit.putStringSet(com.huawei.openalliance.ad.constant.w.at, set);
            }
            editorEdit.commit();
        }
    }

    public void Code(boolean z) {
        synchronized (this.b) {
            this.S.edit().putBoolean(com.huawei.openalliance.ad.constant.w.j, z).commit();
        }
    }
}
