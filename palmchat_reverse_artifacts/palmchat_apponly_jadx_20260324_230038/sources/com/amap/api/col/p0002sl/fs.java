package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.ia;
import com.amap.api.col.p0002sl.id;
import com.amap.api.maps2d.AMapException;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.cdo.oaps.ad.OapsWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.t;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import defpackage.w;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fs {
    private static volatile boolean D = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2791a = -1;
    public static String b = "";
    public static Context c = null;
    private static String k = "6";
    private static String l = "4";
    private static String m = "9";
    private static String n = "8";
    private static volatile boolean o = true;
    private static Vector<e> p = new Vector<>();
    private static Map<String, Integer> q = new HashMap();
    private static String r = null;
    private static long s = 0;
    public static volatile boolean d = false;
    private static volatile ConcurrentHashMap<String, g> t = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, Long> u = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, d> v = new ConcurrentHashMap<>(8);
    private static boolean w = false;
    private static boolean x = false;
    public static int e = 5000;
    public static boolean f = true;
    public static boolean g = false;
    private static int y = 3;
    public static boolean h = true;
    public static boolean i = false;
    private static int z = 3;
    public static boolean j = false;
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> B = new ConcurrentHashMap<>();
    private static ArrayList<ia.a> C = new ArrayList<>();
    private static Queue<ia.c> E = new LinkedList();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(b bVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Deprecated
        public JSONObject f2793a;

        @Deprecated
        public JSONObject b;
        public String c;
        public int d = -1;
        public long e = 0;
        public JSONObject f;
        public a g;
        public C0055b h;
        private boolean i;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f2794a;
            public boolean b;
            public JSONObject c;
        }

        /* JADX INFO: renamed from: com.amap.api.col.2sl.fs$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0055b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f2795a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends hy {
        private String d;
        private Map<String, String> e;
        private String f;
        private String g;
        private String h;

        public c(Context context, gd gdVar, String str, String str2, String str3, String str4) {
            super(context, gdVar);
            this.d = str;
            this.e = null;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            a(id.c.HTTPS);
            a(id.a.FIX);
        }

        private static String a(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.col.p0002sl.hy
        public final byte[] b() {
            return null;
        }

        @Override // com.amap.api.col.p0002sl.fy, com.amap.api.col.p0002sl.id
        public final String b_() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.g);
        }

        @Override // com.amap.api.col.p0002sl.id
        public final Map<String, String> d() {
            if (TextUtils.isEmpty(this.h)) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("host", this.h);
            return map;
        }

        @Override // com.amap.api.col.p0002sl.id
        public final String f() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.f);
        }

        @Override // com.amap.api.col.p0002sl.hy
        public final byte[] g() {
            String strP = fv.p(((hy) this).f2881a);
            if (!TextUtils.isEmpty(strP)) {
                strP = fz.a(new StringBuilder(strP).reverse().toString());
            }
            HashMap map = new HashMap();
            map.put("authkey", TextUtils.isEmpty(this.d) ? "" : this.d);
            map.put("plattype", "android");
            map.put("ccver", "1");
            map.put("product", ((hy) this).b.a());
            map.put("version", ((hy) this).b.b());
            map.put("output", BodyData.TYPE_JSON);
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            map.put("androidversion", sb.toString());
            map.put("deviceId", strP);
            map.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map2 = this.e;
            if (map2 != null && !map2.isEmpty()) {
                map.putAll(this.e);
            }
            map.put("abitype", ge.a(((hy) this).f2881a));
            map.put("ext", ((hy) this).b.e());
            return ge.a(ge.a(map));
        }

        @Override // com.amap.api.col.p0002sl.hy
        public final String i() {
            return "3.0";
        }

        @Override // com.amap.api.col.p0002sl.id
        public final String j() {
            return !TextUtils.isEmpty(this.h) ? this.h : super.j();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        gd f2796a;
        String b;
        a c;

        private d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2797a;
        private String b;
        private AtomicInteger c;

        public e(String str, String str2, int i) {
            this.f2797a = str;
            this.b = str2;
            this.c = new AtomicInteger(i);
        }

        public final void a(String str) {
            this.b = str;
        }

        public final String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f2797a);
                jSONObject.put("f", this.b);
                jSONObject.put("h", this.c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public static e b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new e(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f2798a = true;
        public static boolean b = false;
        public static boolean c = true;
        public static int d = 0;
        public static boolean e = false;
        public static int f;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2799a;
        public String b;

        public g(Long l, String str) {
            this.f2799a = 0L;
            this.b = "";
            this.f2799a = l.longValue();
            this.b = str;
        }
    }

    public static void a(Context context, String str) {
        fr.a(context, str);
    }

    private static b b(Context context, gd gdVar, String str) {
        return b(context, gdVar, str, null, null, null);
    }

    private static void c(Context context, gd gdVar, String str) {
        HashMap map = new HashMap();
        map.put("amap_sdk_auth_fail", "1");
        map.put("amap_sdk_auth_fail_type", str);
        map.put("amap_sdk_name", gdVar.a());
        map.put("amap_sdk_version", gdVar.c());
        String string = new JSONObject(map).toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            ik ikVar = new ik(context, "core", "2.0", "O001");
            ikVar.a(string);
            il.a(ikVar, context);
        } catch (fq unused) {
        }
    }

    public static synchronized boolean d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (v == null) {
                return false;
            }
            if (u == null) {
                u = new ConcurrentHashMap<>(8);
            }
            if (v.containsKey(str) && !u.containsKey(str)) {
                u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
        } catch (Throwable th) {
            ha.a(th, t.u, "cslct");
        }
        return false;
    }

    public static void e() {
        if (d) {
            return;
        }
        try {
            Context context = c;
            if (context == null) {
                return;
            }
            d = true;
            fx.a().a(context);
            b(context);
            c(context);
            f.f2798a = hm.a(context, "open_common", "ucf", f.f2798a);
            f.b = hm.a(context, "open_common", "fsv2", f.b);
            f.c = hm.a(context, "open_common", "usc", f.c);
            f.d = hm.a(context, "open_common", "umv", f.d);
            f.e = hm.a(context, "open_common", "ust", f.e);
            f.f = hm.a(context, "open_common", "ustv", f.f);
        } catch (Throwable unused) {
        }
    }

    public static synchronized g f(String str) {
        try {
            if (t == null) {
                t = new ConcurrentHashMap<>(8);
            }
        } catch (Throwable th) {
            ha.a(th, t.u, "glcut");
        }
        if (t.containsKey(str)) {
            return t.get(str);
        }
        return new g(0L, "");
    }

    public static boolean g(String str) {
        e eVarA;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (!f) {
                return false;
            }
            if (!(A.get(str) == null)) {
                return false;
            }
            Context context = c;
            if (context == null || (eVarA = a(context, b(str, "a14"), "open_common")) == null) {
                return true;
            }
            return eVarA.a() < y;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void i() {
        try {
            Context context = c;
            if (context != null) {
                String strO = fv.o(context);
                if (!TextUtils.isEmpty(r) && !TextUtils.isEmpty(strO) && r.equals(strO) && System.currentTimeMillis() - s < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(strO)) {
                    r = strO;
                }
            } else if (System.currentTimeMillis() - s < 10000) {
                return;
            }
            s = System.currentTimeMillis();
            q.clear();
            if (!w.a()) {
                q.put("WIFI", 3);
                q.put("MOBILE", 3);
                return;
            }
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    Iterator<InterfaceAddress> it = networkInterface.getInterfaceAddresses().iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        InetAddress address = it.next().getAddress();
                        if (address instanceof Inet6Address) {
                            if (!a((Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(ge.c("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            q.put("WIFI", Integer.valueOf(i2));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            q.put("MOBILE", Integer.valueOf(i2));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ha.a(th, t.u, "ipstack");
        }
    }

    public static boolean a(String str, boolean z2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z2;
            }
            String[] strArrSplit = URLDecoder.decode(str).split("/");
            return strArrSplit[strArrSplit.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0188  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.amap.api.col.2sl.fs$b] */
    /* JADX WARN: Type inference failed for: r12v14, types: [com.amap.api.col.2sl.fs$b] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.amap.api.col.2sl.fs$b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static b b(Context context, gd gdVar, String str, String str2, String str3, String str4) throws fq {
        String str5;
        String str6;
        String str7;
        String strC;
        ie ieVarC;
        byte[] bArr;
        ?? r12;
        String str8;
        String str9;
        boolean zIsEmpty;
        String str10 = "infocode";
        ?? r122 = "result";
        String str11 = "ver";
        b bVar = new b();
        bVar.f = new JSONObject();
        if (context != null) {
            c = context.getApplicationContext();
        }
        e();
        String strA = null;
        try {
            a(gdVar);
            new hx();
            zIsEmpty = TextUtils.isEmpty(str);
            try {
                if (zIsEmpty) {
                    strC = str;
                } else {
                    try {
                        strC = c(str);
                    } catch (fq e2) {
                        e = e2;
                        throw e;
                    } catch (Throwable unused) {
                        throw new fq(AMapException.ERROR_UNKNOWN);
                    }
                }
                try {
                    d(context);
                    e(context);
                    str6 = "result";
                    String str12 = strC;
                    r122 = bVar;
                    str7 = "ver";
                    str11 = t.u;
                    str5 = "infocode";
                    str10 = "lc";
                    try {
                        ieVarC = hx.c(new c(context, gdVar, str12, str2, str3, str4));
                    } catch (fq e3) {
                        throw e3;
                    } catch (Throwable unused2) {
                        throw new fq(AMapException.ERROR_UNKNOWN);
                    }
                } catch (fq e4) {
                    e = e4;
                    throw e;
                } catch (Throwable unused3) {
                    throw new fq(AMapException.ERROR_UNKNOWN);
                }
            } catch (fq e5) {
                e = e5;
                ieVarC = null;
                bArr = null;
                r122.c = e.a();
                c(context, gdVar, e.a());
                hd.a(gdVar, "/v3/iasdkauth", e);
                r12 = r122;
                String str13 = strC;
                if (bArr != null) {
                }
            } catch (IllegalBlockSizeException e6) {
                e = e6;
                ieVarC = null;
                bArr = null;
                a(context, gdVar, e);
                r12 = r122;
                String str132 = strC;
                if (bArr != null) {
                }
            } catch (Throwable th) {
                th = th;
                ieVarC = null;
                bArr = null;
                hd.c(th, str11, str10);
                a(context, gdVar, th);
                r12 = r122;
                String str1322 = strC;
                if (bArr != null) {
                }
            }
        } catch (fq e7) {
            e = e7;
            str5 = "infocode";
            str6 = "result";
            str7 = "ver";
            r122 = bVar;
            str11 = t.u;
            str10 = "lc";
            strC = str;
        } catch (IllegalBlockSizeException e8) {
            e = e8;
            str5 = "infocode";
            str6 = "result";
            str7 = "ver";
            r122 = bVar;
            str11 = t.u;
            str10 = "lc";
            strC = str;
        } catch (Throwable th2) {
            th = th2;
            str5 = "infocode";
            str6 = "result";
            str7 = "ver";
            r122 = bVar;
            str11 = t.u;
            str10 = "lc";
            strC = str;
        }
        if (zIsEmpty) {
            return r122;
        }
        if (ieVarC != null) {
            try {
                bArr = ieVarC.f2902a;
                try {
                    Map<String, List<String>> map = ieVarC.b;
                    if (map != null && map.containsKey("lct")) {
                        List<String> list = map.get("lct");
                        List<String> list2 = map.get("lct-info");
                        r122.e = a(list);
                        String strB = b(list2);
                        if (r122.e != 0 && gdVar != null) {
                            String strA2 = gdVar.a();
                            if (!TextUtils.isEmpty(strA2)) {
                                a(strA2, r122.e, strB);
                            }
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        th3.printStackTrace();
                        hd.c(th3, str11, "lct");
                    } catch (fq e9) {
                        e = e9;
                        r122.c = e.a();
                        c(context, gdVar, e.a());
                        hd.a(gdVar, "/v3/iasdkauth", e);
                        r12 = r122;
                    } catch (IllegalBlockSizeException e10) {
                        e = e10;
                        a(context, gdVar, e);
                        r12 = r122;
                    } catch (Throwable th4) {
                        th = th4;
                        hd.c(th, str11, str10);
                        a(context, gdVar, th);
                        r12 = r122;
                    }
                }
            } catch (fq e11) {
                e = e11;
                bArr = null;
                r122.c = e.a();
                c(context, gdVar, e.a());
                hd.a(gdVar, "/v3/iasdkauth", e);
                r12 = r122;
            } catch (IllegalBlockSizeException e12) {
                e = e12;
                bArr = null;
                a(context, gdVar, e);
                r12 = r122;
            } catch (Throwable th5) {
                th = th5;
                bArr = null;
                hd.c(th, str11, str10);
                a(context, gdVar, th);
                r12 = r122;
            }
        } else {
            bArr = null;
        }
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, ge.c("EQUVT"));
        Cipher cipher = Cipher.getInstance(ge.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, new IvParameterSpec(ge.c()));
        strA = ge.a(cipher.doFinal(bArr3));
        r12 = r122;
        String str13222 = strC;
        if (bArr != null) {
            return r12;
        }
        if (TextUtils.isEmpty(strA)) {
            strA = ge.a(bArr);
        }
        String str14 = strA;
        if (TextUtils.isEmpty(str14)) {
            c(context, gdVar, "result is null");
        }
        try {
            JSONObject jSONObject = new JSONObject(str14);
            if (jSONObject.has("status")) {
                int i2 = jSONObject.getInt("status");
                if (i2 == 1) {
                    f2791a = 1;
                } else if (i2 == 0) {
                    if (ieVarC != null) {
                        str8 = ieVarC.c;
                        str9 = ieVarC.d;
                    } else {
                        str8 = "authcsid";
                        str9 = "authgsid";
                    }
                    ge.a(context, str8, str9, jSONObject);
                    f2791a = 0;
                    if (jSONObject.has("info")) {
                        b = jSONObject.getString("info");
                    }
                    String str15 = str5;
                    hd.a(gdVar, "/v3/iasdkauth", b, str9, str8, jSONObject.has(str15) ? jSONObject.getString(str15) : "");
                    if (f2791a == 0) {
                        r12.c = b;
                        return r12;
                    }
                }
                String str16 = str7;
                try {
                    if (jSONObject.has(str16)) {
                        r12.d = jSONObject.getInt(str16);
                    }
                } catch (Throwable th6) {
                    ha.a(th6, str11, str10);
                }
                String str17 = str6;
                if (ge.a(jSONObject, str17)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str17);
                    a(context, gdVar, str13222, (b) r12, jSONObject2);
                    try {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("15K");
                        boolean zA = a(jSONObject3.optString("isTargetAble"), false);
                        if (a(jSONObject3.optString("able"), false)) {
                            fx.a().a(context, zA);
                        } else {
                            fx.a();
                            fx.b(context);
                        }
                    } catch (Throwable unused4) {
                    }
                }
            }
        } catch (Throwable th7) {
            ha.a(th7, str11, str10);
        }
        return r12;
    }

    public static boolean h(String str) {
        e eVarA;
        try {
            if (TextUtils.isEmpty(str) || !i) {
                return false;
            }
            if (!(B.get(str) == null)) {
                return false;
            }
            Context context = c;
            if (context == null || (eVarA = a(context, b(str, "a15"), "open_common")) == null) {
                return true;
            }
            if (eVarA.a() < z) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static ia.a f() {
        if (D) {
            return null;
        }
        synchronized (C) {
            if (D) {
                return null;
            }
            Collections.sort(C);
            if (C.size() <= 0) {
                return null;
            }
            ia.a aVarClone = C.get(0).clone();
            D = true;
            return aVarClone;
        }
    }

    public static ia.c g() {
        synchronized (E) {
            ia.c cVarPoll = E.poll();
            if (cVarPoll != null) {
                return cVarPoll;
            }
            return null;
        }
    }

    public static b a(Context context, gd gdVar, String str) {
        return b(context, gdVar, str);
    }

    public static b a(Context context, gd gdVar, String str, String str2, String str3, String str4) {
        return b(context, gdVar, str, str2, str3, str4);
    }

    public static void a(Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    public static long a(List<String> list) {
        if (list == null) {
            return 0L;
        }
        try {
            if (list.size() <= 0) {
                return 0L;
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.valueOf(str).longValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static boolean c() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String strO = fv.o(context);
        return (TextUtils.isEmpty(strO) || (num = q.get(strO.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    private static void d(Context context) {
        try {
            if (w) {
                return;
            }
            go.d = hm.a(context, "open_common", "a4", true);
            go.e = hm.a(context, "open_common", "a5", true);
            w = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized void e(String str) {
        if (u == null) {
            return;
        }
        if (u.containsKey(str)) {
            u.remove(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0299 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, gd gdVar, String str, b bVar, JSONObject jSONObject) throws JSONException {
        String str2;
        String str3;
        boolean zA;
        Context context2;
        b.a aVar = new b.a();
        aVar.f2794a = false;
        aVar.b = false;
        bVar.g = aVar;
        try {
            String[] strArrSplit = str.split(x.aQ);
            if (strArrSplit != null && strArrSplit.length > 0) {
                for (String str4 : strArrSplit) {
                    if (jSONObject.has(str4)) {
                        bVar.f.putOpt(str4, jSONObject.get(str4));
                    }
                }
            }
        } catch (Throwable th) {
            ha.a(th, t.u, "co");
        }
        if (ge.a(jSONObject, "16H")) {
            try {
                bVar.i = a(jSONObject.getJSONObject("16H").optString("able"), false);
            } catch (Throwable th2) {
                ha.a(th2, "AuthConfigManager", "load 16H");
            }
        }
        if (ge.a(jSONObject, "11K")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("11K");
                aVar.f2794a = a(jSONObject2.getString("able"), false);
                if (jSONObject2.has(WkInteractiveManager.TimingTypeOff)) {
                    aVar.c = jSONObject2.getJSONObject(WkInteractiveManager.TimingTypeOff);
                }
            } catch (Throwable th3) {
                ha.a(th3, "AuthConfigManager", "load 11K");
            }
        }
        if (ge.a(jSONObject, "145")) {
            try {
                bVar.f2793a = jSONObject.getJSONObject("145");
            } catch (Throwable th4) {
                ha.a(th4, "AuthConfigManager", "load 145");
            }
        }
        if (ge.a(jSONObject, "14D")) {
            try {
                bVar.b = jSONObject.getJSONObject("14D");
            } catch (Throwable th5) {
                ha.a(th5, "AuthConfigManager", "load 14D");
            }
        }
        if (ge.a(jSONObject, "151")) {
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject("151");
                b.C0055b c0055b = new b.C0055b();
                if (jSONObject3 != null) {
                    c0055b.f2795a = a(jSONObject3.optString("able"), false);
                }
                bVar.h = c0055b;
            } catch (Throwable th6) {
                ha.a(th6, "AuthConfigManager", "load 151");
            }
        }
        if (ge.a(jSONObject, "17S")) {
            try {
                JSONObject jSONObject4 = jSONObject.getJSONObject("17S");
                if (jSONObject4 != null && (zA = a(jSONObject4.optString("able"), false)) != o) {
                    o = zA;
                    if (context != null) {
                        SharedPreferences.Editor editorA = hm.a(context, "open_common");
                        hm.a(editorA, "a2", zA);
                        hm.a(editorA);
                    }
                }
                if (jSONObject4 != null) {
                    boolean zA2 = a(jSONObject4.optString("static_enable"), true);
                    boolean zA3 = a(jSONObject4.optString("static_ip_direct_enable"), false);
                    int iOptInt = jSONObject4.optInt("static_timeout", 5) * 1000;
                    int iOptInt2 = jSONObject4.optInt("static_retry", 3);
                    boolean zA4 = a(jSONObject4.optString("bgp_enable"), true);
                    str2 = "ust";
                    try {
                        boolean zA5 = a(jSONObject4.optString("bgp_ip_direct_enable"), false);
                        str3 = "umv";
                        try {
                            int iOptInt3 = jSONObject4.optInt("bgp_retry", 3);
                            boolean zA6 = a(jSONObject4.optString("perf_data_upload_enable"), false);
                            if (zA2 != f || zA3 != g || iOptInt != e || iOptInt2 != y || zA4 != h || zA5 != i || iOptInt3 != z || zA6 != j) {
                                f = zA2;
                                g = zA3;
                                e = iOptInt;
                                y = iOptInt2;
                                h = zA4;
                                i = zA5;
                                z = iOptInt3;
                                j = zA6;
                                if (context != null) {
                                    SharedPreferences.Editor editorA2 = hm.a(context, "open_common");
                                    hm.a(editorA2, "a13", zA2);
                                    hm.a(editorA2, "a6", zA4);
                                    hm.a(editorA2, "a7", zA3);
                                    hm.a(editorA2, "a8", iOptInt);
                                    hm.a(editorA2, "a9", iOptInt2);
                                    hm.a(editorA2, "a10", zA5);
                                    hm.a(editorA2, "a11", iOptInt3);
                                    hm.a(editorA2, "a12", zA6);
                                    hm.a(editorA2);
                                }
                            }
                            ia.a();
                            ia.a();
                            ia.a();
                            ia.a();
                            ia.a();
                        } catch (Throwable th7) {
                            th = th7;
                            ha.a(th, "AuthConfigManager", "load 17S");
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        str3 = "umv";
                        ha.a(th, "AuthConfigManager", "load 17S");
                        if (!ge.a(jSONObject, "15K")) {
                        }
                        if (ge.a(jSONObject, "183")) {
                        }
                        if (ge.a(jSONObject, "17I")) {
                        }
                        if (ge.a(jSONObject, "1A4")) {
                        }
                    }
                } else {
                    str2 = "ust";
                    str3 = "umv";
                }
            } catch (Throwable th9) {
                th = th9;
                str2 = "ust";
            }
        }
        if (!ge.a(jSONObject, "15K")) {
            try {
                JSONObject jSONObject5 = jSONObject.getJSONObject("15K");
                if (jSONObject5 != null) {
                    boolean zA7 = a(jSONObject5.optString("ucf"), f.f2798a);
                    boolean zA8 = a(jSONObject5.optString("fsv2"), f.b);
                    boolean zA9 = a(jSONObject5.optString("usc"), f.c);
                    String str5 = str3;
                    int iOptInt4 = jSONObject5.optInt(str5, f.d);
                    String str6 = str2;
                    boolean zA10 = a(jSONObject5.optString(str6), f.e);
                    int iOptInt5 = jSONObject5.optInt("ustv", f.f);
                    if (zA7 == f.f2798a && zA8 == f.b && zA9 == f.c && iOptInt4 == f.d && zA10 == f.e && iOptInt5 == f.d) {
                        context2 = context;
                    } else {
                        f.f2798a = zA7;
                        f.b = zA8;
                        f.c = zA9;
                        f.d = iOptInt4;
                        f.e = zA10;
                        f.f = iOptInt5;
                        context2 = context;
                        try {
                            SharedPreferences.Editor editorA3 = hm.a(context2, "open_common");
                            hm.a(editorA3, "ucf", f.f2798a);
                            hm.a(editorA3, "fsv2", f.b);
                            hm.a(editorA3, "usc", f.c);
                            hm.a(editorA3, str5, f.d);
                            hm.a(editorA3, str6, f.e);
                            hm.a(editorA3, "ustv", f.f);
                            hm.a(editorA3);
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable th10) {
                context2 = context;
                ha.a(th10, "AuthConfigManager", "load 15K");
            }
        }
        if (ge.a(jSONObject, "183")) {
            try {
                hz.a(gdVar, jSONObject.getJSONObject("183"));
            } catch (Throwable th11) {
                ha.a(th11, "AuthConfigManager", "load 183");
            }
        }
        if (ge.a(jSONObject, "17I")) {
            try {
                JSONObject jSONObject6 = jSONObject.getJSONObject("17I");
                boolean zA11 = a(jSONObject6.optString("na"), false);
                boolean zA12 = a(jSONObject6.optString("aa"), false);
                go.d = zA11;
                go.e = zA12;
                SharedPreferences.Editor editorA4 = hm.a(context2, "open_common");
                hm.a(editorA4, "a4", zA11);
                hm.a(editorA4, "a5", zA12);
                hm.a(editorA4);
            } catch (Throwable th12) {
                ha.a(th12, "AuthConfigManager", "load 17I");
            }
        }
        if (ge.a(jSONObject, "1A4")) {
            return;
        }
        try {
            JSONObject jSONObject7 = jSONObject.getJSONObject("1A4");
            String strOptString = jSONObject7.optString("ada");
            boolean zA13 = a(strOptString, gh.c);
            long jOptLong = jSONObject7.optLong("iv", gh.f2828a);
            gh.d = zA13;
            gh.b = jOptLong;
            SharedPreferences.Editor editorA5 = hm.a(context2, "open_common");
            hm.a(editorA5, "a16", strOptString);
            hm.a(editorA5, "a17", jOptLong);
            hm.a(editorA5);
        } catch (Throwable th13) {
            ha.a(th13, "AuthConfigManager", "load 1A4");
        }
    }

    private static void c(Context context) {
        if (context == null) {
            return;
        }
        f = hm.a(context, "open_common", "a13", true);
        h = hm.a(context, "open_common", "a6", true);
        g = hm.a(context, "open_common", "a7", false);
        e = hm.a(context, "open_common", "a8", 5000);
        y = hm.a(context, "open_common", "a9", 3);
        i = hm.a(context, "open_common", "a10", false);
        z = hm.a(context, "open_common", "a11", 3);
        j = hm.a(context, "open_common", "a12", false);
    }

    public static void d() {
        try {
            e eVarA = a(c, "IPV6_CONFIG_NAME", "open_common");
            String strA = ge.a(System.currentTimeMillis(), "yyyyMMdd");
            if (!strA.equals(eVarA.b)) {
                eVarA.a(strA);
                eVarA.c.set(0);
            }
            eVarA.c.incrementAndGet();
            a(c, "IPV6_CONFIG_NAME", "open_common", eVarA);
        } catch (Throwable unused) {
        }
    }

    private static void e(Context context) {
        try {
            if (x) {
                return;
            }
            gh.d = a(hm.b(context, "open_common", "a16", ""), true);
            gh.b = hm.a(context, "open_common", "a17", gh.f2828a);
            x = true;
        } catch (Throwable unused) {
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + ";15K;16H;17I;1A4;17S;183";
    }

    public static void c(ia.c cVar) {
        if (cVar != null && j) {
            synchronized (E) {
                E.offer(cVar);
                ia.a();
            }
        }
    }

    private static String b(List<String> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean b() {
        Integer num;
        Context context = c;
        if (context == null) {
            return false;
        }
        String strO = fv.o(context);
        return (TextUtils.isEmpty(strO) || (num = q.get(strO.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        o = hm.a(context, "open_common", "a2", true);
    }

    public static gd b(String str) {
        d dVar = v.get(str);
        if (dVar != null) {
            return dVar.f2796a;
        }
        return null;
    }

    public static synchronized void b(String str, boolean z2) {
        a(str, z2, (String) null, (String) null, (String) null);
    }

    private static String b(String str, String str2) {
        return str2 + "_" + fz.a(str.getBytes());
    }

    public static void b(ia.c cVar) {
        synchronized (C) {
            boolean z2 = false;
            for (int i2 = 0; i2 < C.size(); i2++) {
                ia.a aVar = C.get(i2);
                if (cVar.c.equals(aVar.b) && cVar.d.equals(aVar.e)) {
                    int i3 = cVar.m;
                    int i4 = aVar.f;
                    if (i3 == i4) {
                        z2 = true;
                        if (i4 == 1) {
                            aVar.i = ((((long) aVar.j.get()) * aVar.i) + cVar.f) / ((long) (aVar.j.get() + 1));
                        }
                        aVar.j.getAndIncrement();
                    }
                }
            }
            if (!z2) {
                C.add(new ia.a(cVar));
            }
            ia.a();
        }
    }

    private static void a(Context context, gd gdVar, Throwable th) {
        c(context, gdVar, th.getMessage());
    }

    public static void a(String str, boolean z2, boolean z3, boolean z4) {
        if (TextUtils.isEmpty(str) || c == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("url", str);
        map.put("downLevel", String.valueOf(z2));
        map.put("ant", fv.j(c) == 0 ? "0" : "1");
        if (z4) {
            map.put("type", z2 ? m : n);
        } else {
            map.put("type", z2 ? k : l);
        }
        map.put("status", z3 ? "0" : "1");
        String string = new JSONObject(map).toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            ik ikVar = new ik(c, "core", "2.0", "O002");
            ikVar.a(string);
            il.a(ikVar, c);
        } catch (fq unused) {
        }
    }

    public static void a(ia.c cVar) {
        if (cVar == null || c == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("serverip", cVar.c);
        map.put("hostname", cVar.e);
        map.put(OapsWrapper.KEY_PATH, cVar.d);
        map.put("csid", cVar.f2893a);
        map.put("degrade", String.valueOf(cVar.b.a()));
        map.put("errorcode", String.valueOf(cVar.m));
        map.put("errorsubcode", String.valueOf(cVar.n));
        map.put("connecttime", String.valueOf(cVar.h));
        map.put("writetime", String.valueOf(cVar.i));
        map.put("readtime", String.valueOf(cVar.j));
        map.put("datasize", String.valueOf(cVar.l));
        map.put("totaltime", String.valueOf(cVar.f));
        String string = new JSONObject(map).toString();
        "--埋点--".concat(String.valueOf(string));
        ia.a();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            ik ikVar = new ik(c, "core", "2.0", "O008");
            ikVar.a(string);
            il.a(ikVar, c);
        } catch (fq unused) {
        }
    }

    public static boolean a() {
        e eVarA;
        if (c != null) {
            i();
            if (!c()) {
                return false;
            }
            if (b()) {
                return true;
            }
        }
        return o && (eVarA = a(c, "IPV6_CONFIG_NAME", "open_common")) != null && eVarA.a() < 5;
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static void a(Context context, String str, String str2, e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f2797a)) {
            return;
        }
        String strB = eVar.b();
        if (TextUtils.isEmpty(strB) || context == null) {
            return;
        }
        SharedPreferences.Editor editorA = hm.a(context, str2);
        editorA.putString(str, strB);
        hm.a(editorA);
    }

    public static String a(String str) {
        d dVar;
        if (!v.containsKey(str) || (dVar = v.get(str)) == null) {
            return null;
        }
        return dVar.b;
    }

    public static synchronized void a(Context context, gd gdVar, String str, a aVar) {
        if (context == null || gdVar == null) {
            return;
        }
        try {
            if (c == null) {
                c = context.getApplicationContext();
            }
            String strA = gdVar.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            a(gdVar);
            if (v == null) {
                v = new ConcurrentHashMap<>(8);
            }
            if (u == null) {
                u = new ConcurrentHashMap<>(8);
            }
            if (t == null) {
                t = new ConcurrentHashMap<>(8);
            }
            if (!v.containsKey(strA)) {
                d dVar = new d((byte) 0);
                dVar.f2796a = gdVar;
                dVar.b = str;
                dVar.c = aVar;
                v.put(strA, dVar);
                t.put(strA, new g(Long.valueOf(hm.a(c, "open_common", strA, 0L)), hm.b(c, "open_common", strA + "lct-info", "")));
                d(c);
                e(c);
            }
        } catch (Throwable th) {
            ha.a(th, t.u, "rglc");
        }
    }

    public static synchronized boolean a(String str, long j2) {
        boolean z2 = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            g gVarF = f(str);
            long jLongValue = 0;
            if (j2 != (gVarF != null ? gVarF.f2799a : 0L)) {
                if (u != null && u.containsKey(str)) {
                    jLongValue = u.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - jLongValue > 30000) {
                    z2 = true;
                }
            }
        } catch (Throwable unused) {
        }
        return z2;
    }

    public static synchronized void a(final String str, boolean z2, final String str2, final String str3, final String str4) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (u == null) {
                u = new ConcurrentHashMap<>(8);
            }
            u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            if (v == null) {
                return;
            }
            if (v.containsKey(str)) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z2) {
                    hz.a(true, str);
                }
                jc.a().b(new jd() { // from class: com.amap.api.col.2sl.fs.1
                    @Override // com.amap.api.col.p0002sl.jd
                    public final void a() {
                        d dVar = (d) fs.v.get(str);
                        if (dVar == null) {
                            return;
                        }
                        a aVar = dVar.c;
                        b bVarA = fs.a(fs.c, dVar.f2796a, dVar.b, str2, str3, str4);
                        if (bVarA == null || aVar == null) {
                            return;
                        }
                        aVar.a(bVarA);
                    }
                });
            }
        } catch (Throwable th) {
            ha.a(th, t.u, "lca");
        }
    }

    private static synchronized void a(String str, long j2, String str2) {
        try {
            if (v != null && v.containsKey(str)) {
                if (t == null) {
                    t = new ConcurrentHashMap<>(8);
                }
                t.put(str, new g(Long.valueOf(j2), str2));
                Context context = c;
                if (context != null) {
                    SharedPreferences.Editor editorA = hm.a(context, "open_common");
                    hm.a(editorA, str, j2);
                    hm.a(editorA, str + "lct-info", str2);
                    hm.a(editorA);
                }
            }
        } catch (Throwable th) {
            ha.a(th, t.u, "ucut");
        }
    }

    private static void a(gd gdVar) {
        if (gdVar != null) {
            try {
                if (TextUtils.isEmpty(gdVar.a())) {
                    return;
                }
                String strC = gdVar.c();
                if (TextUtils.isEmpty(strC)) {
                    strC = gdVar.b();
                }
                if (TextUtils.isEmpty(strC)) {
                    return;
                }
                go.a(gdVar.a(), strC);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z2, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            ia.a();
            if (f || z2) {
                if ((i || !z2) && !TextUtils.isEmpty(str)) {
                    if (!z2) {
                        if (A.get(str) != null) {
                            return;
                        }
                        A.put(str, Boolean.TRUE);
                        a(b(str, "a14"), "open_common");
                        return;
                    }
                    if (B.get(str) != null) {
                        return;
                    }
                    B.put(str, Boolean.TRUE);
                    a(b(str, "a15"), "open_common");
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2) {
        e eVarA = a(c, str, str2);
        String strA = ge.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!strA.equals(eVarA.b)) {
            eVarA.a(strA);
            eVarA.c.set(0);
        }
        eVarA.c.incrementAndGet();
        a(c, str, str2, eVarA);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006e A[Catch: all -> 0x0084, LOOP:0: B:23:0x0068->B:25:0x006e, LOOP_END, TryCatch #0 {, blocks: (B:9:0x000d, B:10:0x0013, B:12:0x0019, B:14:0x0029, B:16:0x0033, B:18:0x0039, B:20:0x003f, B:21:0x0046, B:22:0x005c, B:23:0x0068, B:25:0x006e, B:26:0x007f, B:27:0x0082), top: B:33:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(boolean z2, ia.a aVar) {
        if (!D || aVar == null) {
            return;
        }
        synchronized (C) {
            if (z2) {
                Iterator<ia.a> it = C.iterator();
                while (it.hasNext()) {
                    ia.a next = it.next();
                    if (next.b.equals(aVar.b) && next.e.equals(aVar.e) && next.f == aVar.f) {
                        if (next.j == aVar.j) {
                            it.remove();
                            ia.a();
                        } else {
                            next.j.set(next.j.get() - aVar.j.get());
                            ia.a();
                        }
                    }
                }
                D = false;
                ia.a();
                for (ia.a aVar2 : C) {
                    String str = aVar2.e;
                    Objects.toString(aVar2.j);
                    ia.a();
                }
                ia.a();
            } else {
                D = false;
                ia.a();
                while (r4.hasNext()) {
                }
                ia.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized e a(Context context, String str, String str2) {
        e eVar;
        if (!TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < p.size(); i2++) {
                eVar = p.get(i2);
                if (eVar != null && str.equals(eVar.f2797a)) {
                    break;
                }
            }
            eVar = null;
            if (eVar == null) {
                return eVar;
            }
            if (context == null) {
                return null;
            }
            e eVarB = e.b(hm.b(context, str2, str, ""));
            String strA = ge.a(System.currentTimeMillis(), "yyyyMMdd");
            if (eVarB == null) {
                eVarB = new e(str, strA, 0);
            }
            if (!strA.equals(eVarB.b)) {
                eVarB.a(strA);
                eVarB.c.set(0);
            }
            p.add(eVarB);
            return eVarB;
        }
        eVar = null;
        if (eVar == null) {
        }
    }
}
