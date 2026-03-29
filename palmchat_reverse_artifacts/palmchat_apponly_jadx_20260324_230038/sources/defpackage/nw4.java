package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class nw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19631a = "/v3/report";
    public static boolean b = true;
    public static String c = "";
    public static boolean d = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends xw2 {
        public final /* synthetic */ Object c;
        public final /* synthetic */ Context d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object obj, Context context) {
            super(str);
            this.c = obj;
            this.d = context;
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                JSONArray jSONArrayD = nw4.d(this.c);
                if (jSONArrayD != null) {
                    nw4.e(this.d, jSONArrayD, nw4.l(jSONArrayD));
                } else {
                    k63.a("ReportUtils", "data" + this.c + " is empty");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean A(Context context, String str, JSONObject jSONObject) {
        try {
            if (nl5.i(str)) {
                k63.a("ReportUtils", "file_name is null , give up save ");
                return false;
            }
            if (context != null) {
                return hv1.j(hv1.e(context, str), jSONObject != null ? jSONObject.toString() : "");
            }
            k63.a("ReportUtils", "context is null , give up save " + str);
            return false;
        } catch (Throwable th) {
            k63.a("ReportUtils", "writeLogFile e:" + th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0001, B:16:0x0037, B:18:0x003d, B:9:0x0020, B:11:0x0024, B:12:0x002e, B:14:0x0032), top: B:25:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray d(Object obj) {
        JSONArray jSONArrayPut;
        JSONArray jSONArrayS;
        try {
            if (obj instanceof String) {
                try {
                    try {
                        jSONArrayPut = new JSONArray((String) obj);
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    jSONArrayPut = new JSONArray().put(new JSONObject((String) obj));
                }
                jSONArrayS = s(jSONArrayPut);
                if (jSONArrayS != null) {
                    if (jSONArrayS.length() > 0) {
                        return jSONArrayS;
                    }
                }
            } else {
                jSONArrayPut = obj instanceof JSONObject ? new JSONArray().put(obj) : obj instanceof JSONArray ? (JSONArray) obj : null;
                jSONArrayS = s(jSONArrayPut);
                if (jSONArrayS != null) {
                }
            }
        } catch (Throwable th) {
            k63.l("ReportUtils", "adapt JSONArray e:" + th);
        }
        return null;
    }

    public static void e(Context context, JSONArray jSONArray, Set<String> set) {
        try {
            String strB = q7.c().e(context).b(set);
            JSONObject jSONObjectI = i(context);
            boolean z = jSONObjectI != null;
            StringBuilder sb = new StringBuilder();
            String str = File.separator;
            sb.append(str);
            sb.append(strB);
            sb.append(str);
            sb.append(z ? "tmp" : "nowrap");
            String string = sb.toString();
            Iterator<JSONArray> it = r(jSONArray, 40960, 204800).iterator();
            while (it.hasNext()) {
                try {
                    JSONObject jSONObjectZ = z(it.next(), jSONObjectI);
                    File fileN = hw4.n(context, string, jSONObjectZ, z);
                    k63.a("ReportUtils", "save report types=" + set + " at " + string + File.separator + fileN.getName());
                    if (z) {
                        x(context, set, jSONObjectZ, fileN, null);
                    }
                } catch (Throwable th) {
                    k63.o("ReportUtils", "buildReport [for item]", th);
                }
            }
        } catch (Throwable th2) {
            k63.c("ReportUtils", "report exception:" + th2);
        }
    }

    public static boolean f(Object obj) {
        return obj instanceof String ? ((String) obj).length() > 2 : obj instanceof JSONObject ? ((JSONObject) obj).length() > 0 : (obj instanceof JSONArray) && s((JSONArray) obj).length() > 0;
    }

    public static String g(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long jLongValue = ((Long) lg5.c(context, zz2.K())).longValue();
        if (jLongValue == 0) {
            k63.a("ReportUtils", " miss uid,generate report token failed");
            return null;
        }
        String strD = nl5.d(jLongValue + nl5.h((String) lg5.c(context, zz2.H())) + str);
        if (nl5.i(strD)) {
            return null;
        }
        try {
            return Base64.encodeToString((jLongValue + ":" + strD + ":" + str2).getBytes(), 10);
        } catch (Exception unused) {
            k63.c("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static String h(String str) {
        try {
            return n45.n(str, sw0.a());
        } catch (Throwable unused) {
            k63.c("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static JSONObject i(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "a");
            long jLongValue = ((Long) lg5.c(context, zz2.K())).longValue();
            if (jLongValue == 0) {
                k63.l("ReportUtils", "miss uid when wrap container info");
                return null;
            }
            jSONObject.put(DeviceInfoUtil.UID_TAG, jLongValue);
            String strE = fv2.e(context);
            if (nl5.i(strE)) {
                k63.c("ReportUtils", "miss app_key when wrap container info");
                return null;
            }
            jSONObject.put("app_key", strE);
            f5.c().e(jSONObject);
            jSONObject.put("core_sdk_ver", wv2.b);
            String strF = fv2.f(context);
            if (nl5.i(strF)) {
                k63.n("ReportUtils", "miss channel when wrap container info,but continue report...");
            } else {
                jSONObject.put("channel", strF);
            }
            Pair<String, Integer> pairH = xv2.h(context);
            if (pairH == null || nl5.i((String) pairH.first)) {
                k63.n("ReportUtils", "miss app version when wrap container info,but continue report...");
            } else {
                jSONObject.put("app_version", pairH.first);
            }
            return jSONObject;
        } catch (Throwable th) {
            k63.l("ReportUtils", "wrapContainerInfo exception:" + th);
            return null;
        }
    }

    public static String j() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(c)) ? "stats.jpush.cn" : c;
    }

    public static String k(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("type");
        }
        return null;
    }

    public static Set<String> l(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strK = k(jSONArray.optJSONObject(i));
                if (strK == null) {
                    strK = "";
                }
                hashSet.add(strK);
            }
        }
        return hashSet;
    }

    public static Set<String> m(JSONObject jSONObject) {
        return jSONObject == null ? new HashSet() : l(jSONObject.optJSONArray("content"));
    }

    public static LinkedHashSet<String> n(Context context, Set<String> set) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String strJ = j();
        if (!"stats.jpush.cn".equals(strJ)) {
            linkedHashSet.add(strJ);
            return linkedHashSet;
        }
        Set<String> setD = q7.c().f(context).d(set);
        if (setD != null) {
            for (String str : setD) {
                if (!TextUtils.isEmpty(str)) {
                    linkedHashSet.add(str);
                }
            }
        }
        String str2 = lv2.d;
        if (!TextUtils.isEmpty(strJ)) {
            linkedHashSet.add(str2 + strJ);
        }
        String str3 = (String) lg5.c(context, zz2.N(true));
        if (!TextUtils.isEmpty(str3)) {
            for (String str4 : str3.split(",")) {
                if (nl5.j(str4)) {
                    if (d) {
                        linkedHashSet.add(str2 + str4);
                    }
                } else if (!nl5.l(str4)) {
                    linkedHashSet.add(str2 + str4);
                } else if (!d) {
                    linkedHashSet.add(str2 + str4);
                }
            }
        }
        k63.a("ReportUtils", "types=" + set + " find urls=" + linkedHashSet);
        return linkedHashSet;
    }

    public static int o(Context context, byte[] bArr, int i, Set<String> set) {
        LinkedHashSet<String> linkedHashSetN = n(context, set);
        if (linkedHashSetN == null || linkedHashSetN.isEmpty()) {
            k63.l("ReportUtils", "can't get url, give up upload");
            return -2;
        }
        String str = " type=" + set;
        for (String str2 : linkedHashSetN) {
            if (TextUtils.isEmpty(str2)) {
                k63.l("ReportUtils", "can't get url, give up upload");
            } else if (Build.VERSION.SDK_INT < 28 || str2.startsWith(lv2.d)) {
                if (!str2.endsWith(f19631a)) {
                    str2 = str2 + f19631a;
                }
                String str3 = str2;
                k63.a("ReportUtils", "upload" + str + " to url:" + str3);
                px4 px4VarC = qw2.c(context, str3, bArr, i, 3, 1);
                int iB = px4VarC.b();
                if (iB == -3) {
                    hw4.b(context, fv2.e(context));
                    return -2;
                }
                if (iB == -1) {
                    k63.a("ReportUtils", "upload" + str + " error:" + px4VarC.a());
                } else {
                    if (iB == 0) {
                        return 0;
                    }
                    k63.a("ReportUtils", "upload" + str + " failed");
                }
            } else {
                k63.l("ReportUtils", "won't use http at device since 28");
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0086 A[PHI: r4
      0x0086: PHI (r4v1 int) = (r4v0 int), (r4v2 int) binds: [B:24:0x0084, B:21:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p(Context context, int i, JSONObject jSONObject, byte[] bArr, int i2, File file, Set<String> set, ReportCallBack reportCallBack) {
        try {
            k63.a("ReportUtils", "onTcpReportResult, types=" + set + " code=" + i);
            if (i == -3) {
                hw4.b(context, fv2.e(context));
            } else if (i != 0) {
                i = o(context, bArr, i2, set);
                if (i == 0) {
                    if (tv2.e && tv2.f) {
                        k63.a("ReportUtils", "http upload success, json=" + zw2.e(jSONObject));
                    }
                    hv1.c(file);
                }
            } else {
                if (tv2.e && tv2.f) {
                    k63.a("ReportUtils", "tcp upload success, json=" + zw2.e(jSONObject));
                }
                hv1.c(file);
            }
        } catch (Throwable unused) {
            if (reportCallBack != null) {
            }
        }
        if (reportCallBack != null) {
            reportCallBack.onFinish(i);
        }
        hw4.l(file);
    }

    public static Pair<byte[], Integer> q(String str, boolean z, int i) throws Throwable {
        String str2;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (z) {
                try {
                    bytes = z86.d(bytes);
                } catch (IOException unused) {
                    return null;
                }
            }
            int i2 = n45.i();
            String strH = n45.h(i2);
            if (i == 1) {
                str2 = "0102030405060708";
            } else {
                if (i != 2) {
                    return null;
                }
                str2 = "iop203040506aPk!";
            }
            return new Pair<>(n45.a(bytes, strH, str2, true), Integer.valueOf(i2));
        } catch (UnsupportedEncodingException | Exception unused2) {
            return null;
        }
    }

    public static ArrayList<JSONArray> r(JSONArray jSONArray, int i, int i2) {
        ArrayList<JSONArray> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            if (jSONArray.length() == 1) {
                arrayList.add(jSONArray);
                return arrayList;
            }
            JSONArray jSONArray2 = new JSONArray();
            int i3 = 0;
            int i4 = 0;
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(length);
                try {
                    int iA = zw2.a(jSONObjectOptJSONObject);
                    if (iA != 0) {
                        int i5 = i3 + iA;
                        if (i5 > i2) {
                            break;
                        }
                        int i6 = i4 + iA;
                        if (i6 > i) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            try {
                                jSONArray3.put(jSONObjectOptJSONObject);
                                jSONArray2 = jSONArray3;
                            } catch (Throwable th) {
                                th = th;
                                jSONArray2 = jSONArray3;
                                k63.l("ReportUtils", "partition exception:" + th);
                            }
                        } else {
                            jSONArray2.put(jSONObjectOptJSONObject);
                            iA = i6;
                        }
                        i4 = iA;
                        i3 = i5;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (jSONArray2.length() > 0) {
                arrayList.add(jSONArray2);
            }
        }
        return arrayList;
    }

    public static JSONArray s(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    public static void t(Context context, Object obj) {
        try {
            if (f(obj)) {
                wz4.a("UPLOAD_REPORT", new a("ReportUtils#report", obj, context));
            } else {
                k63.a("ReportUtils", "data is invalid or empty");
            }
            hw4.o(context);
        } catch (Throwable th) {
            k63.l("ReportUtils", "report e:" + th);
        }
    }

    public static void u(Context context, String str, Object obj) {
        try {
            k63.a("ReportUtils", "going to report data at push service");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("sdk_type", str);
            }
            if (f(obj)) {
                bundle.putString("report_data", obj.toString());
            }
            wv2.f(context, "a1", bundle);
        } catch (Throwable th) {
            try {
                k63.d("ReportUtils", "reportAtPushService", th);
            } catch (Throwable th2) {
                k63.d("ReportUtils", "reportAtPushService", th2);
            }
        }
    }

    public static void v(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        w(context, jSONObject, reportCallBack);
    }

    public static void w(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject jSONObjectI = i(context);
                    if (jSONObjectI == null) {
                        k63.c("ReportUtils", "wrap data failed");
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-1);
                        }
                    } else {
                        String strK = k(jSONObject);
                        JSONObject jSONObjectZ = z(new JSONArray().put(jSONObject), jSONObjectI);
                        HashSet hashSet = new HashSet();
                        hashSet.add(strK);
                        k63.a("ReportUtils", "reportWithoutStore type=" + strK);
                        x(context, hashSet, jSONObjectZ, null, reportCallBack);
                    }
                }
            } catch (Throwable th) {
                k63.c("ReportUtils", "reportWithoutStore exception:" + th);
            }
        }
        hw4.o(context);
    }

    public static int x(Context context, Set<String> set, JSONObject jSONObject, File file, ReportCallBack reportCallBack) {
        Object obj;
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    if (!ad.w(context)) {
                        k63.l("ReportUtils", "no network, give up upload");
                        hw4.l(file);
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-2);
                        }
                        return -2;
                    }
                    Pair<byte[], Integer> pairQ = q(jSONObject.toString(), true, 2);
                    if (pairQ != null && (obj = pairQ.first) != null && ((byte[]) obj).length != 0) {
                        byte[] bArr = (byte[]) obj;
                        int iIntValue = ((Integer) pairQ.second).intValue();
                        k63.a("ReportUtils", "will upload length=" + bArr.length);
                        if (y(set, bArr.length)) {
                            vt5.i().t(context, vt5.i().g(context, jSONObject, bArr, iIntValue, file, set, reportCallBack));
                            return 1;
                        }
                        int iO = o(context, bArr, iIntValue, set);
                        if (iO == 0) {
                            k63.a("ReportUtils", "http upload success json=" + zw2.e(jSONObject));
                            hv1.c(file);
                        }
                        if (iO != 1) {
                            hw4.l(file);
                            if (reportCallBack != null) {
                                reportCallBack.onFinish(iO);
                            }
                        }
                        return iO;
                    }
                    k63.l("ReportUtils", "package body failed, give up upload");
                    hw4.l(file);
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                }
            } catch (Throwable th) {
                try {
                    k63.l("ReportUtils", "upload failed, error:" + th);
                    hw4.l(file);
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                } catch (Throwable th2) {
                    if (0 != 1) {
                        hw4.l(file);
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(0);
                        }
                    }
                    throw th2;
                }
            }
        }
        k63.l("ReportUtils", "upload content is empty, do nothing");
        hw4.l(file);
        if (reportCallBack != null) {
            reportCallBack.onFinish(-1);
        }
        return -1;
    }

    public static boolean y(Set<String> set, int i) {
        return b && i < 30680 && set != null && !set.contains("crash_log");
    }

    public static JSONObject z(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("content", jSONArray);
        } catch (JSONException unused) {
        }
        zw2.b(jSONObject2, jSONObject);
        return jSONObject2;
    }
}
