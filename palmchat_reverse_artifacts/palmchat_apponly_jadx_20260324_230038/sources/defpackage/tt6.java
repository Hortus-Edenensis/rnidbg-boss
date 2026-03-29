package defpackage;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.Npth;
import com.apm.lite.j.e;
import com.apm.lite.nativecrash.NativeImpl;
import com.huawei.hms.ads.ex;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.umeng.analytics.pro.bd;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import defpackage.s07;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class tt6 {
    public static volatile boolean D = false;
    public static volatile boolean E = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n07 f21067a;
    public final Context b;
    public volatile boolean c;
    public JSONObject g;
    public JSONObject h;
    public JSONArray m;
    public JSONObject n;
    public JSONArray q;
    public JSONArray r;
    public JSONObject s;
    public boolean t;
    public volatile boolean v;
    public long d = -1;
    public File e = null;
    public boolean f = true;
    public String i = "unknown";
    public String j = "unknown";
    public String k = "unknown";
    public String l = "npth_inner_default";
    public int o = 0;
    public long p = -1;
    public final Object u = new Object();
    public long w = -1;
    public long x = 0;
    public final Runnable y = new b();
    public int z = 0;
    public List<Pattern> A = null;
    public Pattern B = null;
    public File C = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements s07.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21068a;

        public a(long j) {
            this.f21068a = j;
        }

        @Override // s07.a
        public void a(JSONObject jSONObject) {
            y77.a().b(jSONObject, this.f21068a, tt6.this.f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                tt6.this.h(200, 25);
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
        }
    }

    public tt6(Context context) {
        this.b = context;
    }

    public static String a(float f) {
        return f <= 0.0f ? "0%" : f <= 0.1f ? "0% - 10%" : f <= 0.3f ? "10% - 30%" : f <= 0.6f ? "30% - 60%" : f <= 0.9f ? "60% - 90%" : "90% - 100%";
    }

    public static String b(float f, float f2) {
        return f2 > 0.0f ? a(f / f2) : f > 0.0f ? "100%" : "0%";
    }

    public static void f(HashMap<String, Float> map, JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String strB;
        String str3 = "npth_anr_" + str;
        if (map.isEmpty()) {
            str2 = str3 + "_total";
            strB = "not found";
        } else {
            float fFloatValue = 0.0f;
            float fFloatValue2 = 0.0f;
            float fFloatValue3 = 0.0f;
            float fFloatValue4 = 0.0f;
            float fFloatValue5 = 0.0f;
            for (Map.Entry<String, Float> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key.endsWith(bd.m)) {
                    fFloatValue += entry.getValue().floatValue();
                } else if (key.endsWith("kernel")) {
                    fFloatValue2 += entry.getValue().floatValue();
                } else if (key.endsWith("iowait")) {
                    fFloatValue3 += entry.getValue().floatValue();
                } else if (key.endsWith("irq")) {
                    fFloatValue4 += entry.getValue().floatValue();
                } else if (key.endsWith("softirq")) {
                    fFloatValue5 += entry.getValue().floatValue();
                }
            }
            float f = fFloatValue + fFloatValue2 + fFloatValue3 + fFloatValue4 + fFloatValue5;
            jSONObject.put(str3 + "_total", l(f));
            jSONObject.put(str3 + "_kernel_user_ratio", b(fFloatValue2, f));
            str2 = str3 + "_iowait_user_ratio";
            strB = b(fFloatValue3, f);
        }
        jSONObject.put(str2, strB);
    }

    public static String l(float f) {
        return a(f / 100.0f);
    }

    public static void o(String str) {
        Iterator<ICrashCallback> it = cg7.a().i().iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(CrashType.ANR, str, null);
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
        }
    }

    public final JSONObject c(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayB = gg7.b(256, 128, jSONArray);
        if (jSONArrayB.length() != jSONArray.length()) {
            this.o++;
        }
        try {
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, str);
            jSONObject.put("thread_stack", jSONArrayB);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void d() {
        if (this.c) {
            return;
        }
        this.f21067a = new n07(this);
        this.d = x97.p();
        this.c = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0207, code lost:
    
        if (r8 != 5) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0241 A[PHI: r28
      0x0241: PHI (r28v3 char) = (r28v2 char), (r28v18 char) binds: [B:127:0x023b, B:117:0x020d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x024f A[PHI: r28
      0x024f: PHI (r28v4 char) = (r28v3 char), (r28v19 char) binds: [B:130:0x0249, B:116:0x020a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0259 A[PHI: r28
      0x0259: PHI (r28v15 char) = (r28v4 char), (r28v20 char) binds: [B:133:0x0255, B:114:0x0207] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02c6 A[LOOP:2: B:101:0x01f1->B:158:0x02c6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0360 A[PHI: r3 r15 r16 r22 r25 r26
      0x0360: PHI (r3v7 java.lang.String) = (r3v6 java.lang.String), (r3v4 java.lang.String) binds: [B:184:0x0359, B:160:0x02d4] A[DONT_GENERATE, DONT_INLINE]
      0x0360: PHI (r15v9 java.lang.String) = (r15v8 java.lang.String), (r15v1 java.lang.String) binds: [B:184:0x0359, B:160:0x02d4] A[DONT_GENERATE, DONT_INLINE]
      0x0360: PHI (r16v10 java.lang.String) = (r16v8 java.lang.String), (r16v1 java.lang.String) binds: [B:184:0x0359, B:160:0x02d4] A[DONT_GENERATE, DONT_INLINE]
      0x0360: PHI (r22v3 char) = (r22v2 char), (r22v5 char) binds: [B:184:0x0359, B:160:0x02d4] A[DONT_GENERATE, DONT_INLINE]
      0x0360: PHI (r25v6 java.util.HashMap) = (r25v5 java.util.HashMap), (r25v8 java.util.HashMap) binds: [B:184:0x0359, B:160:0x02d4] A[DONT_GENERATE, DONT_INLINE]
      0x0360: PHI (r26v6 java.util.HashMap) = (r26v5 java.util.HashMap), (r26v8 java.util.HashMap) binds: [B:184:0x0359, B:160:0x02d4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03cc A[PHI: r15 r16 r20 r22 r25 r26
      0x03cc: PHI (r15v5 java.lang.String) = (r15v1 java.lang.String), (r15v1 java.lang.String), (r15v10 java.lang.String), (r15v1 java.lang.String) binds: [B:200:0x03be, B:197:0x039d, B:195:0x0394, B:16:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x03cc: PHI (r16v4 java.lang.String) = (r16v1 java.lang.String), (r16v1 java.lang.String), (r16v11 java.lang.String), (r16v1 java.lang.String) binds: [B:200:0x03be, B:197:0x039d, B:195:0x0394, B:16:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x03cc: PHI (r20v2 java.lang.String) = (r20v0 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String) binds: [B:200:0x03be, B:197:0x039d, B:195:0x0394, B:16:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x03cc: PHI (r22v1 char) = (r22v0 char), (r22v2 char), (r22v4 char), (r22v7 char) binds: [B:200:0x03be, B:197:0x039d, B:195:0x0394, B:16:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x03cc: PHI (r25v4 java.util.HashMap) = (r25v2 java.util.HashMap), (r25v5 java.util.HashMap), (r25v7 java.util.HashMap), (r25v18 java.util.HashMap) binds: [B:200:0x03be, B:197:0x039d, B:195:0x0394, B:16:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x03cc: PHI (r26v4 java.util.HashMap) = (r26v2 java.util.HashMap), (r26v5 java.util.HashMap), (r26v7 java.util.HashMap), (r26v20 java.util.HashMap) binds: [B:200:0x03be, B:197:0x039d, B:195:0x0394, B:16:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03e9 A[EDGE_INSN: B:237:0x03e9->B:207:0x03e9 BREAK  A[LOOP:0: B:3:0x0038->B:205:0x03d2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0394 A[EDGE_INSN: B:241:0x0394->B:195:0x0394 BREAK  A[LOOP:2: B:101:0x01f1->B:158:0x02c6], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(String str, JSONObject jSONObject) throws JSONException {
        HashMap map;
        HashMap map2;
        String[] strArr;
        int i;
        String str2;
        char c;
        char c2;
        boolean z;
        String str3;
        String strTrim;
        String string;
        HashMap map3;
        String str4;
        int i2;
        char c3;
        String[] strArr2;
        String str5;
        float fFloatValue;
        tt6 tt6Var = this;
        SystemClock.uptimeMillis();
        String[] strArrSplit = str.split("\n");
        float[] fArr = {-1.0f, -1.0f, -1.0f};
        HashMap map4 = new HashMap();
        HashMap map5 = new HashMap();
        HashMap map6 = new HashMap();
        HashMap map7 = new HashMap();
        HashMap map8 = new HashMap();
        int length = strArrSplit.length;
        String str6 = "unknown";
        String strTrim2 = "unknown";
        String str7 = strTrim2;
        int i3 = 0;
        char c4 = 0;
        boolean z2 = false;
        while (true) {
            if (i3 >= length) {
                map = map7;
                map2 = map8;
                break;
            }
            String strTrim3 = strArrSplit[i3];
            if (TextUtils.isEmpty(strTrim3)) {
                strArr = strArrSplit;
                map = map7;
                map2 = map8;
                i = length;
                str2 = str6;
            } else {
                strArr = strArrSplit;
                i = length;
                if (c4 != 0) {
                    str2 = str6;
                    if (c4 == 1) {
                        map = map7;
                        map2 = map8;
                        c = c4;
                        strTrim3 = strTrim3.trim();
                        String lowerCase = strTrim3.toLowerCase();
                        if (lowerCase.startsWith("shortmsg")) {
                            strTrim3.substring(strTrim3.indexOf(58));
                            z = false;
                        } else if (lowerCase.startsWith("reason:")) {
                            strTrim3.substring(strTrim3.indexOf(58));
                            z = true;
                        } else if (lowerCase.contains("appfreeze")) {
                            str7 = "AppFreeze";
                            c2 = 4;
                            c4 = '\n';
                        } else {
                            c4 = c;
                            c2 = 4;
                        }
                        if (lowerCase.contains("input dispatch")) {
                            str3 = "Input dispatching timed out";
                        } else if (lowerCase.contains("broadcast of intent")) {
                            str3 = "Broadcast of Intent";
                        } else {
                            if (lowerCase.contains("executing service")) {
                                if (com.igexin.push.core.b.m.equalsIgnoreCase(strTrim2)) {
                                    strTrim2 = strTrim3.substring(strTrim3.indexOf("service ") + 8).trim();
                                }
                                str7 = "executing service";
                            } else if (lowerCase.contains("service.startforeground")) {
                                str3 = "not call Service.startForeground";
                            } else {
                                str7 = str2;
                            }
                            if (z) {
                                strTrim = strTrim3.trim();
                                if (strTrim.startsWith("Load:")) {
                                }
                                c4 = c;
                                c2 = 4;
                            } else {
                                c2 = 4;
                                c4 = 2;
                            }
                        }
                        str7 = str3;
                        if (z) {
                        }
                    } else if (c4 != 2) {
                        if (c4 != 3) {
                            map = map7;
                            map2 = map8;
                            c = c4;
                        } else {
                            String[] strArrSplit2 = strTrim3.split("\\s");
                            c = c4;
                            if (strArrSplit2.length < 2) {
                                map = map7;
                                map2 = map8;
                            } else {
                                if ("CPU".equalsIgnoreCase(strArrSplit2[0]) && SharePluginInfo.ISSUE_CPU_USAGE.equalsIgnoreCase(strArrSplit2[1])) {
                                    if (strTrim3.contains("ago")) {
                                        z2 = true;
                                    }
                                    if (map4.isEmpty() && map5.isEmpty() && map6.isEmpty() && map8.isEmpty() && map7.isEmpty()) {
                                        map = map7;
                                        map2 = map8;
                                        c4 = c;
                                        c2 = 4;
                                    }
                                } else if (map4.isEmpty() || map5.isEmpty() || map6.isEmpty() || map8.isEmpty() || map7.isEmpty()) {
                                    if (map4.isEmpty() && strArrSplit2[1].equalsIgnoreCase("TOTAL:")) {
                                        string = "";
                                        map3 = map4;
                                    } else if (strTrim3.contains(tt6Var.b.getPackageName())) {
                                        string = "";
                                        int i4 = 0;
                                        while (i4 < strArrSplit2.length) {
                                            if (strArrSplit2[i4].contains(tt6Var.b.getPackageName())) {
                                                StringBuilder sb = new StringBuilder();
                                                String str8 = strArrSplit2[i4];
                                                sb.append(str8.substring(str8.indexOf(47) + 1, strArrSplit2[i4].length() - 1));
                                                sb.append('_');
                                                string = sb.toString();
                                            }
                                            i4++;
                                            tt6Var = this;
                                        }
                                        map3 = map6;
                                    } else if (map5.isEmpty() && strTrim3.contains("system_server:")) {
                                        string = "";
                                        map3 = map5;
                                    } else if (map8.isEmpty() && strTrim3.contains("kswapd")) {
                                        string = "";
                                        map3 = map8;
                                    } else if (map7.isEmpty() && strTrim3.contains("dex2oat")) {
                                        string = "";
                                        map3 = map7;
                                    } else {
                                        string = "";
                                        map3 = null;
                                    }
                                    if (map3 != null) {
                                        int i5 = 0;
                                        try {
                                            do {
                                                str4 = "%";
                                                if (!strArrSplit2[i5].contains("%")) {
                                                    i5++;
                                                }
                                                break;
                                            } while (i5 < strArrSplit2.length);
                                            break;
                                            fFloatValue = Float.valueOf(strArrSplit2[i5].replace("%", "")).floatValue();
                                            map = map7;
                                        } catch (Throwable unused) {
                                            map = map7;
                                        }
                                        try {
                                            String str9 = string + "total";
                                            if (map3 == map4) {
                                                map2 = map8;
                                            } else {
                                                map2 = map8;
                                                try {
                                                    fFloatValue /= i77.i();
                                                } catch (Throwable unused2) {
                                                    map3.put(string + "total", Float.valueOf(-1.0f));
                                                }
                                            }
                                            map3.put(str9, Float.valueOf(fFloatValue));
                                        } catch (Throwable unused3) {
                                            map2 = map8;
                                            map3.put(string + "total", Float.valueOf(-1.0f));
                                            i2 = i5 + 3;
                                            char c5 = 0;
                                            while (i2 < strArrSplit2.length) {
                                            }
                                            c4 = c;
                                            c2 = 4;
                                            if (c4 >= c2) {
                                            }
                                        }
                                        i2 = i5 + 3;
                                        char c52 = 0;
                                        while (i2 < strArrSplit2.length) {
                                            String str10 = "softirq";
                                            if (c52 == 0) {
                                                c3 = c52;
                                                if (bd.m.equalsIgnoreCase(strArrSplit2[i2])) {
                                                    str10 = bd.m;
                                                    c52 = 1;
                                                }
                                                if (str10 != null) {
                                                }
                                                if (c52 < 6) {
                                                }
                                            } else if (c52 == 1) {
                                                c3 = c52;
                                            } else if (c52 == 2) {
                                                c3 = c52;
                                                if (!"iowait".equalsIgnoreCase(strArrSplit2[i2])) {
                                                    str10 = "iowait";
                                                    c52 = 3;
                                                } else if (!"irq".equalsIgnoreCase(strArrSplit2[i2])) {
                                                }
                                                if (str10 != null) {
                                                }
                                                if (c52 < 6) {
                                                }
                                            } else if (c52 == 3) {
                                                c3 = c52;
                                                if (!"irq".equalsIgnoreCase(strArrSplit2[i2])) {
                                                    str10 = "irq";
                                                    c52 = 4;
                                                } else if (!"softirq".equalsIgnoreCase(strArrSplit2[i2])) {
                                                }
                                                if (str10 != null) {
                                                }
                                                if (c52 < 6) {
                                                }
                                            } else if (c52 != 4) {
                                                c3 = c52;
                                            } else {
                                                c3 = c52;
                                                if (!"softirq".equalsIgnoreCase(strArrSplit2[i2])) {
                                                    c52 = 5;
                                                } else if ("softirq".equalsIgnoreCase(strArrSplit2[i2])) {
                                                    c52 = 6;
                                                } else {
                                                    c52 = c3;
                                                    str10 = null;
                                                }
                                                if (str10 != null) {
                                                    try {
                                                        float fFloatValue2 = Float.valueOf(strArrSplit2[i2 - 1].replace(str4, "")).floatValue();
                                                        strArr2 = strArrSplit2;
                                                        try {
                                                            String str11 = string + str10;
                                                            if (map3 == map4) {
                                                                str5 = str4;
                                                            } else {
                                                                str5 = str4;
                                                                try {
                                                                    fFloatValue2 /= i77.i();
                                                                } catch (Throwable unused4) {
                                                                    map3.put(string + str10, Float.valueOf(-1.0f));
                                                                }
                                                            }
                                                            map3.put(str11, Float.valueOf(fFloatValue2));
                                                        } catch (Throwable unused5) {
                                                            str5 = str4;
                                                            map3.put(string + str10, Float.valueOf(-1.0f));
                                                            if (c52 < 6) {
                                                            }
                                                        }
                                                    } catch (Throwable unused6) {
                                                        strArr2 = strArrSplit2;
                                                    }
                                                } else {
                                                    strArr2 = strArrSplit2;
                                                    str5 = str4;
                                                }
                                                if (c52 < 6) {
                                                    break;
                                                }
                                                i2 += 3;
                                                strArrSplit2 = strArr2;
                                                str4 = str5;
                                            }
                                            if ("kernel".equalsIgnoreCase(strArrSplit2[i2])) {
                                                str10 = "kernel";
                                                c52 = 2;
                                            } else if (!"iowait".equalsIgnoreCase(strArrSplit2[i2])) {
                                            }
                                            if (str10 != null) {
                                            }
                                            if (c52 < 6) {
                                            }
                                        }
                                    } else {
                                        map = map7;
                                        map2 = map8;
                                    }
                                    c4 = c;
                                    c2 = 4;
                                }
                                map = map7;
                                map2 = map8;
                                c2 = 4;
                                c4 = 4;
                            }
                        }
                        c4 = c;
                        c2 = 4;
                    } else {
                        map = map7;
                        map2 = map8;
                        c = c4;
                        strTrim = strTrim3.trim();
                        if (strTrim.startsWith("Load:")) {
                            String[] strArrSplit3 = strTrim.replace("Load:", "").trim().split("/");
                            if (3 == strArrSplit3.length) {
                                for (int i6 = 0; i6 < strArrSplit3.length; i6++) {
                                    fArr[i6] = Float.valueOf(strArrSplit3[i6]).floatValue();
                                }
                            }
                            c2 = 4;
                            c4 = 3;
                        }
                        c4 = c;
                        c2 = 4;
                    }
                    if (c4 >= c2) {
                        break;
                    }
                } else {
                    map = map7;
                    map2 = map8;
                    str2 = str6;
                    c = c4;
                    String strTrim4 = strTrim3.trim();
                    if (strTrim4.startsWith("tag:")) {
                        strTrim2 = strTrim4.replace("tag:", "").trim();
                        c2 = 4;
                        c4 = 1;
                    }
                    if (c4 >= c2) {
                    }
                }
            }
            i3++;
            tt6Var = this;
            strArrSplit = strArr;
            length = i;
            str6 = str2;
            map7 = map;
            map8 = map2;
        }
        jSONObject.put("anr_tag", strTrim2);
        jSONObject.put("anr_has_ago", String.valueOf(z2));
        jSONObject.put("anr_reason", str7);
        f(map6, jSONObject, "app");
        f(map4, jSONObject, "total");
        if (map5.isEmpty()) {
            jSONObject.put("npth_anr_systemserver_total", "not found");
        } else {
            jSONObject.put("npth_anr_systemserver_total", l(nj7.a(map5).floatValue()));
        }
        if (map2.isEmpty()) {
            jSONObject.put("npth_anr_kswapd_total", "not found");
        } else {
            jSONObject.put("npth_anr_kswapd_total", l(nj7.a(map2).floatValue()));
        }
        if (map.isEmpty()) {
            jSONObject.put("npth_anr_dex2oat_total", "not found");
        } else {
            jSONObject.put("npth_anr_dex2oat_total", l(nj7.a(map).floatValue()));
        }
    }

    public final void g(JSONArray jSONArray) {
        int[] iArrP;
        int[] iArrP2;
        if (jSONArray == null) {
            return;
        }
        this.g = null;
        this.n = null;
        this.o = 0;
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        this.i = "unknown";
        this.j = "unknown";
        this.k = "unknown";
        int[] iArr = {0, 0, 0};
        JSONArray jSONArray5 = jSONArray4;
        String strSubstring = null;
        boolean z = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            if (TextUtils.isEmpty(strOptString)) {
                if (jSONArray5.length() > 0 && !TextUtils.isEmpty(strSubstring)) {
                    if (this.g == null && "main".equals(strSubstring)) {
                        this.g = r(jSONArray5);
                    } else {
                        jSONArray2.put(c(strSubstring, jSONArray5));
                    }
                    try {
                        if (!"main".equals(strSubstring)) {
                            strSubstring = strSubstring.substring(0, strSubstring.indexOf(40)).trim();
                        }
                    } catch (Throwable unused) {
                    }
                    String str = strSubstring;
                    if (!k(str)) {
                        try {
                            iArrP2 = p(jSONArray5);
                        } catch (IllegalArgumentException e) {
                            n37.a();
                            n37.b("NPTH_CATCH", e);
                            iArrP2 = null;
                        } catch (Throwable unused2) {
                            iArrP2 = null;
                        }
                        if (iArrP2 != null) {
                            int i2 = iArrP2[0];
                            if (i2 > iArr[0]) {
                                iArr[0] = i2;
                                this.i = str;
                            }
                            int i3 = iArrP2[1];
                            if (i3 > iArr[1]) {
                                iArr[1] = i3;
                                this.j = str;
                            }
                            int i4 = iArrP2[2];
                            if (i4 > iArr[2]) {
                                iArr[2] = i4;
                                this.k = str;
                            }
                        }
                    }
                }
                if (jSONArray5.length() > 0) {
                    jSONArray5 = new JSONArray();
                }
                strSubstring = null;
            } else {
                if (z) {
                    if (z) {
                        if (strOptString.contains(" prio=")) {
                            if (jSONArray5.length() > 0 && !TextUtils.isEmpty(strSubstring)) {
                                if (this.g == null && "main".equals(strSubstring)) {
                                    this.g = r(jSONArray5);
                                } else {
                                    jSONArray2.put(c(strSubstring, jSONArray5));
                                }
                                try {
                                    if (!"main".equals(strSubstring)) {
                                        strSubstring = strSubstring.substring(0, strSubstring.indexOf(40)).trim();
                                    }
                                } catch (Throwable unused3) {
                                }
                                String str2 = strSubstring;
                                if (!k(str2)) {
                                    try {
                                        iArrP = p(jSONArray5);
                                    } catch (IllegalArgumentException e2) {
                                        n37.a();
                                        n37.b("NPTH_CATCH", e2);
                                        iArrP = null;
                                    } catch (Throwable unused4) {
                                        iArrP = null;
                                    }
                                    if (iArrP != null) {
                                        int i5 = iArrP[0];
                                        if (i5 > iArr[0]) {
                                            iArr[0] = i5;
                                            this.i = str2;
                                        }
                                        int i6 = iArrP[1];
                                        if (i6 > iArr[1]) {
                                            iArr[1] = i6;
                                            this.j = str2;
                                        }
                                        int i7 = iArrP[2];
                                        if (i7 > iArr[2]) {
                                            iArr[2] = i7;
                                            this.k = str2;
                                        }
                                    }
                                }
                                strSubstring = str2;
                            }
                            try {
                                strSubstring = strOptString.substring(1, strOptString.indexOf(34, 1));
                                if (!"main".equals(strSubstring)) {
                                    strSubstring = strSubstring + "  (" + strOptString.substring(strOptString.indexOf(34, 2) + 1) + " )";
                                }
                            } catch (Throwable unused5) {
                            }
                            if (jSONArray5.length() > 0) {
                                jSONArray5 = new JSONArray();
                            }
                        } else if (TextUtils.isEmpty(strSubstring)) {
                        }
                        jSONArray5.put(strOptString);
                    }
                } else if (strOptString.startsWith("DALVIK THREADS") || strOptString.startsWith("suspend") || strOptString.startsWith("\"")) {
                    z = true;
                }
                jSONArray3.put(strOptString);
            }
        }
        if (jSONArray2.length() > 0) {
            this.m = jSONArray3;
            try {
                JSONObject jSONObject = new JSONObject();
                this.n = jSONObject;
                jSONObject.put("thread_all_count", jSONArray2.length());
                this.n.put("thread_stacks", jSONArray2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x03bd A[Catch: all -> 0x0461, TRY_ENTER, TryCatch #0 {all -> 0x0461, blocks: (B:79:0x0177, B:83:0x01f1, B:85:0x01f6, B:88:0x01ff, B:90:0x0203, B:92:0x0209, B:94:0x0211, B:135:0x03bd, B:136:0x03e6, B:138:0x03ea, B:139:0x03f0, B:146:0x0445, B:93:0x020f), top: B:157:0x0177 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03e6 A[Catch: all -> 0x0461, TryCatch #0 {all -> 0x0461, blocks: (B:79:0x0177, B:83:0x01f1, B:85:0x01f6, B:88:0x01ff, B:90:0x0203, B:92:0x0209, B:94:0x0211, B:135:0x03bd, B:136:0x03e6, B:138:0x03ea, B:139:0x03f0, B:146:0x0445, B:93:0x020f), top: B:157:0x0177 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h(int i, int i2) {
        boolean z;
        boolean z2;
        JSONArray jSONArrayA;
        JSONObject jSONObject;
        JSONObject jSONObjectC;
        JSONObject jSONObjectC2;
        boolean z3;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        boolean z4;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z5;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray jSONArray3;
        JSONObject jSONObject4;
        String strK;
        JSONObject jSONObject5;
        JSONArray jSONArrayB;
        boolean zA = y97.a();
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean zI = i(jUptimeMillis);
        String strB = o37.b(this.b, 1);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str5 = PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
        boolean z6 = TextUtils.isEmpty(strB) && zI;
        if (zI || !TextUtils.isEmpty(strB)) {
            synchronized (this.u) {
                z = !z6;
            }
            if (this.g != null) {
                z2 = z;
                if (System.currentTimeMillis() - this.d <= 20000) {
                    str5 = z6 ? "trace_only" : "trace_last";
                }
                JSONObject jSONObject6 = this.g;
                String str6 = this.i;
                String str7 = this.j;
                String str8 = this.k;
                JSONArray jSONArray4 = this.m;
                JSONArray jSONArray5 = this.r;
                jSONArrayA = this.q;
                jSONObject = this.s;
                jSONObjectC = jSONObject6;
                jSONObjectC2 = this.h;
                boolean z7 = this.t;
                long j = this.p;
                z3 = z7;
                if (!z6) {
                    this.g = null;
                    this.m = null;
                    this.q = null;
                    this.h = null;
                    this.r = null;
                    this.i = "unknown";
                    this.j = "unknown";
                    this.k = "unknown";
                    this.o = 0;
                }
                jSONArray = jSONArray4;
                jSONArray2 = jSONArray5;
                String str9 = str5;
                z4 = z2;
                jCurrentTimeMillis = j;
                str = str8;
                str2 = str7;
                str3 = str6;
                str4 = str9;
            } else {
                z2 = z;
            }
            if (this.v) {
                this.v = false;
                str5 = "trace_after";
            }
            n(jUptimeMillis);
            JSONObject jSONObject62 = this.g;
            String str62 = this.i;
            String str72 = this.j;
            String str82 = this.k;
            JSONArray jSONArray42 = this.m;
            JSONArray jSONArray52 = this.r;
            jSONArrayA = this.q;
            jSONObject = this.s;
            jSONObjectC = jSONObject62;
            jSONObjectC2 = this.h;
            boolean z72 = this.t;
            long j2 = this.p;
            z3 = z72;
            if (!z6) {
            }
            jSONArray = jSONArray42;
            jSONArray2 = jSONArray52;
            String str92 = str5;
            z4 = z2;
            jCurrentTimeMillis = j2;
            str = str82;
            str2 = str72;
            str3 = str62;
            str4 = str92;
        } else {
            str = "unknown";
            jSONArray = null;
            jSONObject = null;
            jSONArrayA = null;
            jSONObjectC = null;
            jSONObjectC2 = null;
            jSONArray2 = null;
            z3 = false;
            str2 = "unknown";
            str3 = "unknown";
            str4 = PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
            z4 = false;
        }
        if (!z6 && TextUtils.isEmpty(strB)) {
            if (this.g == null || System.currentTimeMillis() - this.d <= 20000) {
                if (this.g == null || System.currentTimeMillis() - this.d <= 2000 || !NativeImpl.isResendSigQuit()) {
                    return false;
                }
                re7.r(w());
                return false;
            }
            this.g = null;
            this.m = null;
            this.q = null;
            this.h = null;
            this.r = null;
            this.i = "unknown";
            this.j = "unknown";
            this.k = "unknown";
            this.o = 0;
            File file = this.e;
            if (file != null) {
                re7.r(file);
            }
            this.e = null;
            return false;
        }
        if (jSONObjectC == null) {
            if (jSONArrayA == null) {
                try {
                    jSONArrayB = u77.b();
                    JSONObject jSONObject7 = jSONObject;
                    try {
                        jSONArrayA = oc7.a(100, jUptimeMillis);
                        jSONObjectC2 = u77.c(jUptimeMillis);
                        JSONObject jSONObject8 = new JSONObject();
                        try {
                            kv6.d(this.b, jSONObject8);
                            jSONObject = jSONObject8;
                        } catch (Throwable unused) {
                            jSONObject = jSONObject8;
                        }
                    } catch (Throwable unused2) {
                        jSONObject = jSONObject7;
                    }
                } catch (Throwable unused3) {
                    jSONArrayB = jSONArray2;
                }
            } else {
                jSONArrayB = jSONArray2;
            }
            try {
                jSONObjectC = o37.c(E);
            } catch (Throwable unused4) {
            }
            jSONArray3 = jSONArrayB;
            jSONObject2 = jSONObjectC;
            z5 = z4;
            jSONObject3 = jSONObjectC2;
        } else {
            z5 = z4;
            jSONObject2 = jSONObjectC;
            jSONObject3 = jSONObjectC2;
            jSONArray3 = jSONArray2;
        }
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            try {
                jSONObject2.put("pid", Process.myPid());
                jSONObject2.put("package", this.b.getPackageName());
                jSONObject2.put("is_remote_process", 0);
                jSONObject2.put("is_new_stack", 10);
                ev6 ev6Var = new ev6(new JSONObject());
                String str10 = str;
                ev6Var.j("data", jSONObject2.toString());
                JSONObject jSONObject9 = jSONObject2;
                boolean z8 = true;
                ev6Var.j("is_anr", 1);
                ev6Var.j("anrType", str4);
                ev6Var.j("history_message", jSONArray3);
                ev6Var.j("current_message", jSONObject3);
                ev6Var.j("pending_messages", jSONArrayA);
                ev6Var.j("anr_time", Long.valueOf(System.currentTimeMillis()));
                ev6Var.j("crash_time", Long.valueOf(jCurrentTimeMillis));
                ev6Var.y(jSONObject);
                ev6Var.j("anr_info", z6 ? "no anr info" : strB);
                if (jSONArray != null) {
                    ev6Var.j("dump_trace", jSONArray);
                }
                ev6Var.j("all_thread_stacks", (z6 || !((jSONObject5 = this.n) == null || jSONObject5.length() == 0)) ? this.n : yl7.r(null));
                da7 da7VarD = da7.d();
                CrashType crashType = CrashType.ANR;
                ev6 ev6VarA = da7VarD.a(crashType, ev6Var);
                ev6VarA.j("is_background", Boolean.valueOf(z3));
                ev6VarA.j("logcat", hf7.b(x97.l()));
                ev6VarA.j("has_dump", ex.Code);
                ev6VarA.j("crash_uuid", x97.b(jCurrentTimeMillis, crashType, false, false));
                ev6VarA.j("jiffy", Long.valueOf(ph7.a()));
                JSONObject jSONObjectOptJSONObject = ev6VarA.G().optJSONObject("filters");
                if (jSONObjectOptJSONObject == null) {
                    try {
                        jSONObject4 = new JSONObject();
                        try {
                            ev6VarA.j("filters", jSONObject4);
                        } catch (Throwable unused5) {
                            jSONObjectOptJSONObject = jSONObject4;
                            strK = strB;
                            jSONObject4 = jSONObjectOptJSONObject;
                            if (z6) {
                            }
                            return z5;
                        }
                    } catch (Throwable unused6) {
                        strK = strB;
                        jSONObject4 = jSONObjectOptJSONObject;
                        if (z6) {
                        }
                        return z5;
                    }
                } else {
                    jSONObject4 = jSONObjectOptJSONObject;
                }
                try {
                    jSONObject4.put("anrType", str4);
                    jSONObject4.put("max_utm_thread", str3);
                    jSONObject4.put("max_stm_thread", str2);
                    jSONObject4.put("max_utm_stm_thread", str10);
                    jSONObject4.put("max_utm_thread_version", this.l);
                    jSONObject4.put("crash_length", q(jCurrentTimeMillis));
                    jSONObject4.put("disable_looper_monitor", String.valueOf(nv6.l()));
                    jSONObject4.put("sdk_version", "0.0.1-rc.3");
                    jSONObject4.put("has_logcat", String.valueOf(ev6VarA.o()));
                    jSONObject4.put("memory_leak", String.valueOf(ev6VarA.E()));
                    jSONObject4.put("fd_leak", String.valueOf(ev6VarA.A()));
                    jSONObject4.put("threads_leak", String.valueOf(ev6VarA.D()));
                    jSONObject4.put("is_64_devices", String.valueOf(q37.f()));
                    jSONObject4.put("is_64_runtime", String.valueOf(NativeImpl.is64BitRuntime()));
                    jSONObject4.put("is_x86_devices", String.valueOf(q37.j()));
                    jSONObject4.put("has_meminfo_file", String.valueOf(ev6VarA.F()));
                    jSONObject4.put("is_root", w37.y() ? ex.Code : ex.V);
                    if (this.v) {
                        z8 = false;
                    }
                    jSONObject4.put("anr_normal_trace", String.valueOf(z8));
                    jSONObject4.put("anr_no_run", String.valueOf(zA));
                    jSONObject4.put("crash_after_crash", Npth.hasCrash() ? ex.Code : ex.V);
                    jSONObject4.put("from_file", String.valueOf(o37.d()));
                    jSONObject4.put("has_dump", ex.Code);
                    jSONObject4.put("from_kill", String.valueOf(z6));
                    strK = nz6.y().K();
                    jSONObject4.put("last_resume_activity", strK);
                    int i3 = this.o;
                    if (i3 > 0) {
                        strK = "may_have_stack_overflow";
                        jSONObject4.put("may_have_stack_overflow", String.valueOf(i3));
                    }
                } catch (Throwable unused7) {
                    strK = strB;
                }
                try {
                    if (z6) {
                        strK = strB;
                        if (!x()) {
                            jSONObject4.put("aid", String.valueOf(ev6VarA.H().s().opt("aid")));
                        }
                    } else {
                        strK = strB;
                        try {
                            e(strK, jSONObject4);
                        } catch (Throwable th) {
                            n37.a();
                            n37.b("NPTH_CATCH", th);
                        }
                    }
                } catch (Throwable unused8) {
                    jSONObjectOptJSONObject = jSONObject4;
                    jSONObject4 = jSONObjectOptJSONObject;
                }
                if (z6) {
                    String strS = e.s();
                    File file2 = new File(wi7.b(this.b), x97.b(jCurrentTimeMillis, CrashType.ANR, false, false));
                    this.e = file2;
                    re7.f(file2, file2.getName(), strS, ev6VarA.G(), e.q());
                } else {
                    File file3 = this.e;
                    if (file3 != null) {
                        re7.r(file3);
                        this.e = null;
                    }
                    zu6.a().b(CrashType.ANR, jCurrentTimeMillis, x97.k());
                    try {
                        if (vb7.g().length() > 1024) {
                            ev6VarA.e("has_system_traces", ex.Code);
                        }
                    } catch (Throwable unused9) {
                    }
                    try {
                        JSONArray jSONArrayB2 = z77.b(wi7.q(x97.l()), wi7.t(x97.l()));
                        jSONObject4.put("leak_threads_count", String.valueOf(jSONArrayB2.length()));
                        if (jSONArrayB2.length() > 0) {
                            re7.l(wi7.w(x97.l()), jSONArrayB2, false);
                        }
                    } catch (Throwable unused10) {
                    }
                    s07.i(ev6VarA.G(), s07.d(jSONObject9.optString("mainStackFromTrace")), new a(jCurrentTimeMillis));
                    o(strK);
                }
            } catch (Throwable th2) {
                n37.a();
                n37.b("NPTH_CATCH", th2);
            }
        }
        return z5;
    }

    public final boolean i(long j) {
        if (this.v) {
            this.v = false;
            n(j);
        }
        return false;
    }

    public final boolean k(String str) {
        if (this.A == null) {
            JSONArray jSONArrayJ = nv6.j();
            if (jSONArrayJ != null) {
                this.A = new LinkedList();
                this.l = jSONArrayJ.optString(0);
                for (int i = 1; i < jSONArrayJ.length(); i++) {
                    try {
                        this.A.add(Pattern.compile(jSONArrayJ.optString(i)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.A == null) {
                LinkedList linkedList = new LinkedList();
                this.A = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.A.add(Pattern.compile("^default_npth_thread$"));
                this.A.add(Pattern.compile("^RenderThread$"));
                this.A.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        Iterator<Pattern> it = this.A.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        n07 n07Var = this.f21067a;
        if (n07Var != null) {
            n07Var.b();
        }
    }

    public final void n(long j) {
        if (this.x != this.w) {
            try {
                this.p = System.currentTimeMillis();
                this.r = u77.b();
                this.q = oc7.a(100, j);
                this.h = u77.c(j);
                JSONObject jSONObject = new JSONObject();
                this.s = jSONObject;
                kv6.d(this.b, jSONObject);
                this.t = v();
                this.f = !Npth.hasCrash();
            } catch (Throwable unused) {
            }
            try {
                this.d = this.p;
                String strK = wi7.k();
                File file = new File(new File(wi7.u(this.b), strK), "trace_" + kv6.m(this.b).replace(':', '_') + ".txt");
                file.getParentFile().mkdirs();
                re7.j(file, w07.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                vi7.d("anr_trace", strK);
                NativeImpl.doDumpAllThread(file.getAbsolutePath());
                try {
                    JSONArray jSONArrayU = re7.u(file.getAbsolutePath());
                    this.m = jSONArrayU;
                    g(jSONArrayU);
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    n37.a();
                    n37.b("NPTH_CATCH", th);
                }
                if (this.g == null) {
                    this.g = o37.c(true);
                }
            } catch (Throwable th2) {
                n37.a();
                n37.b("NPTH_CATCH", th2);
            }
            vb7.b();
        } else {
            try {
                this.d = this.p;
                String strK2 = wi7.k();
                File file2 = new File(new File(wi7.u(this.b), strK2), "trace" + kv6.m(this.b).replace(':', '_') + ".txt");
                file2.getParentFile().mkdirs();
                re7.j(file2, w07.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                vi7.d("anr_trace", strK2);
                NativeImpl.doDumpAllThread(file2.getAbsolutePath());
                try {
                    JSONArray jSONArrayU2 = re7.u(file2.getAbsolutePath());
                    this.m = jSONArrayU2;
                    g(jSONArrayU2);
                } catch (IOException unused3) {
                } catch (Throwable th3) {
                    n37.a();
                    n37.b("NPTH_CATCH", th3);
                }
                if (this.g == null) {
                    this.g = o37.c(true);
                }
            } catch (Throwable th4) {
                n37.a();
                n37.b("NPTH_CATCH", th4);
            }
        }
        long j2 = this.w;
        this.x = j2;
        this.w = -1L;
        if (j2 == -1) {
            this.x = (-1) - 1;
        }
    }

    public final int[] p(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            int iIndexOf = (strOptString == null || strOptString.isEmpty()) ? -1 : strOptString.indexOf("utm=");
            if (iIndexOf > 0) {
                if (this.B == null) {
                    this.B = Pattern.compile("[^0-9]+");
                }
                String[] strArrSplit = this.B.split(strOptString.substring(iIndexOf));
                if (strArrSplit == null || strArrSplit.length < 2) {
                    return null;
                }
                int iIntValue = Integer.decode(strArrSplit[1]).intValue();
                int iIntValue2 = Integer.decode(strArrSplit[2]).intValue();
                return new int[]{iIntValue, iIntValue2, iIntValue + iIntValue2};
            }
        }
        return null;
    }

    public final String q(long j) {
        long jP = j - x97.p();
        return jP < 30000 ? "0 - 30s" : jP < 60000 ? "30s - 1min" : jP < 120000 ? "1min - 2min" : jP < 300000 ? "2min - 5min" : jP < 600000 ? "5min - 10min" : jP < 1800000 ? "10min - 30min" : jP < 3600000 ? "30min - 1h" : "1h - ";
    }

    public final JSONObject r(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayB = gg7.b(256, 128, jSONArray);
        if (jSONArrayB.length() != jSONArray.length()) {
            this.o++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArrayB.length(); i++) {
                sb.append(jSONArrayB.getString(i));
                sb.append('\n');
            }
            jSONObject.put("mainStackFromTrace", sb.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void s() {
        if (D) {
            return;
        }
        synchronized (this.u) {
            if (D) {
                return;
            }
            this.y.run();
        }
    }

    public void t() {
        if (NativeImpl.isResendSigQuit()) {
            try {
                re7.j(w(), String.valueOf(this.z + 1), false);
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
        }
        this.w = SystemClock.uptimeMillis();
        this.v = true;
    }

    public void u() {
        File fileW = w();
        try {
            int iIntValue = Integer.decode(re7.z(fileW.getAbsolutePath())).intValue();
            this.z = iIntValue;
            if (iIntValue >= 2) {
                NativeImpl.setResendSigQuit(false);
            } else {
                NativeImpl.setResendSigQuit(true);
            }
        } catch (IOException unused) {
            NativeImpl.setResendSigQuit(true);
        } catch (Throwable unused2) {
            re7.r(fileW);
        }
    }

    public final boolean v() {
        boolean z = !kv6.h(this.b);
        if (!z || nz6.y().B() > 2000) {
            return z;
        }
        return false;
    }

    public final File w() {
        if (this.C == null) {
            this.C = new File(this.b.getFilesDir(), "has_anr_signal_" + kv6.m(this.b).replaceAll(":", "_"));
        }
        return this.C;
    }

    public final boolean x() {
        return nv6.p();
    }
}
