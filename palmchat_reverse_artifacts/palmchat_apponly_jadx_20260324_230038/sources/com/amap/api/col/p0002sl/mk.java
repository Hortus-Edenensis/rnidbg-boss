package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qiniu.android.http.dns.DnsSource;
import com.ss.android.ttvecamera.BuildConfig;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.umeng.analytics.pro.f;
import com.zenmen.palmchat.modulemanager.InitExceptionHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray<Long> f3003a = new SparseArray<>();
    public int b = -1;
    public long c = 0;
    String[] d = {"ol", "cl", "gl", "ha", CmcdConfiguration.KEY_BUFFER_STARVATION, "ds"};
    public int e = -1;
    public long f = -1;
    private static List<ik> i = new ArrayList();
    private static JSONArray j = null;
    static AMapLocation g = null;
    static boolean h = false;

    /* JADX INFO: renamed from: com.amap.api.col.2sl.mk$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3004a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f3004a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3004a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3004a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static String a(int i2) {
        if (i2 == 2011) {
            return "ContextIsNull";
        }
        if (i2 == 2031) {
            return "CreateApsReqException";
        }
        if (i2 == 2041) {
            return "ResponseResultIsNull";
        }
        if (i2 == 2081) {
            return "LocalLocException";
        }
        if (i2 == 2091) {
            return InitExceptionHelper.KEY_ACTION;
        }
        if (i2 == 2111) {
            return "ErrorCgiInfo";
        }
        if (i2 == 2121) {
            return "NotLocPermission";
        }
        if (i2 == 2141) {
            return "NoEnoughStatellites";
        }
        if (i2 == 2021) {
            return "OnlyMainWifi";
        }
        if (i2 == 2022) {
            return "OnlyOneWifiButNotMain";
        }
        if (i2 == 2061) {
            return "ServerRetypeError";
        }
        if (i2 == 2062) {
            return "ServerLocFail";
        }
        switch (i2) {
            case 2051:
                return "NeedLoginNetWork\t";
            case 2052:
                return "MaybeIntercepted";
            case 2053:
                return "DecryptResponseException";
            case 2054:
                return "ParserDataException";
            default:
                switch (i2) {
                    case AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND /* 2101 */:
                        return "BindAPSServiceException";
                    case 2102:
                        return "AuthClientScodeFail";
                    case 2103:
                        return "NotConfigAPSService";
                    default:
                        switch (i2) {
                            case 2131:
                                return "NoCgiOAndWifiInfo";
                            case 2132:
                                return "AirPlaneModeAndWifiOff";
                            case 2133:
                                return "NoCgiAndWifiOff";
                            default:
                                switch (i2) {
                                    case 2151:
                                        return "MaybeMockNetLoc";
                                    case 2152:
                                        return "MaybeMockGPSLoc";
                                    case 2153:
                                        return "UNSUPPORT_COARSE_LBSLOC";
                                    case 2154:
                                        return "UNSUPPORT_CONTINUE_LOC";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public static void b(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (md.a()) {
                    a(context, j2, z, "O024");
                }
            } catch (Throwable th) {
                me.a(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    private static void f(Context context) {
        try {
            JSONArray jSONArray = j;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            ij.a(new ii(context, me.c(), j.toString()), context);
            j = null;
        } catch (Throwable th) {
            me.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final int c(Context context) {
        try {
            long jA = ml.a(context, "pref1", this.d[2], 0L);
            long jA2 = ml.a(context, "pref1", this.d[0], 0L);
            long jA3 = ml.a(context, "pref1", this.d[1], 0L);
            if (jA == 0 && jA2 == 0 && jA3 == 0) {
                return -1;
            }
            long j2 = jA2 - jA;
            long j3 = jA3 - jA;
            return jA > j2 ? jA > j3 ? 2 : 1 : j2 > j3 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Context context) {
        try {
            long jA = ml.a(context, "pref1", this.d[3], 0L);
            long jA2 = ml.a(context, "pref1", this.d[4], 0L);
            long jA3 = ml.a(context, "pref1", this.d[5], 0L);
            if (jA == 0 && jA2 == 0 && jA3 == 0) {
                return -1;
            }
            return jA > jA2 ? jA > jA3 ? 3 : 5 : jA2 > jA3 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void e(Context context) {
        try {
            SharedPreferences.Editor editorA = ml.a(context, "pref1");
            int i2 = 0;
            while (true) {
                String[] strArr = this.d;
                if (i2 >= strArr.length) {
                    ml.a(editorA);
                    return;
                } else {
                    ml.a(editorA, strArr[i2], 0L);
                    i2++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(AMapLocation aMapLocation) {
        return mm.a(aMapLocation) ? !me.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(me.c);
    }

    public final void b(Context context) {
        try {
            long jB = mm.b() - this.c;
            int i2 = this.b;
            if (i2 != -1) {
                this.f3003a.append(this.b, Long.valueOf(jB + this.f3003a.get(i2, 0L).longValue()));
            }
            long jB2 = mm.b() - this.f;
            int i3 = this.e;
            if (i3 != -1) {
                this.f3003a.append(this.e, Long.valueOf(jB2 + this.f3003a.get(i3, 0L).longValue()));
            }
            SharedPreferences.Editor editorA = ml.a(context, "pref1");
            for (int i4 = 0; i4 < this.d.length; i4++) {
                long jLongValue = this.f3003a.get(i4, 0L).longValue();
                if (jLongValue > 0 && jLongValue > ml.a(context, "pref1", this.d[i4], 0L)) {
                    ml.a(editorA, this.d[i4], jLongValue);
                }
            }
            ml.a(editorA);
        } catch (Throwable th) {
            me.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public static void a(Context context, AMapLocation aMapLocation, lb lbVar) {
        int i2;
        if (aMapLocation == null) {
            return;
        }
        try {
            if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                String str = BuildConfig.REGION;
                if (a(aMapLocation)) {
                    str = "abroad";
                }
                String str2 = str;
                String str3 = "cache";
                if (aMapLocation.getErrorCode() != 0) {
                    int errorCode = aMapLocation.getErrorCode();
                    if (errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11) {
                        str3 = TKDownloadReason.KSAD_TK_NET;
                    }
                    i2 = 0;
                } else {
                    int locationType = aMapLocation.getLocationType();
                    if (locationType == 5 || locationType == 6) {
                        str3 = TKDownloadReason.KSAD_TK_NET;
                    }
                    i2 = 1;
                }
                a(context, "O016", str3, str2, i2, aMapLocation.getErrorCode(), lbVar);
            }
        } catch (Throwable th) {
            me.a(th, "ReportUtil", "reportBatting");
        }
    }

    public static void a(Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (md.a()) {
                    a(context, j2, z, "O015");
                }
            } catch (Throwable th) {
                me.a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void a(Context context, long j2, boolean z, String str) {
        a(context, str, !z ? "abroad" : BuildConfig.REGION, Long.valueOf(j2).intValue());
    }

    private static void a(Context context, String str, String str2, String str3, int i2, int i3, lb lbVar) {
        if (context != null) {
            try {
                if (md.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i3);
                    }
                    if (lbVar != null) {
                        if (!TextUtils.isEmpty(lbVar.d())) {
                            jSONObject.put(DnsSource.Udp, lbVar.d());
                        }
                        if (!TextUtils.isEmpty(lbVar.e())) {
                            jSONObject.put("domain", lbVar.e());
                        }
                        if (!TextUtils.isEmpty(lbVar.f())) {
                            jSONObject.put("type", lbVar.f());
                        }
                        if (!TextUtils.isEmpty(lbVar.g())) {
                            jSONObject.put("reason", lbVar.g());
                        }
                        if (!TextUtils.isEmpty(lbVar.c())) {
                            jSONObject.put("ip", lbVar.c());
                        }
                        if (!TextUtils.isEmpty(lbVar.b())) {
                            jSONObject.put(SharePluginInfo.ISSUE_TRACE_STACK, lbVar.b());
                        }
                        if (lbVar.h() > 0) {
                            jSONObject.put("ctime", String.valueOf(lbVar.h()));
                        }
                        if (lbVar.a() > 0) {
                            jSONObject.put("ntime", String.valueOf(lbVar.a()));
                        }
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                me.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, String str2, int i2) {
        if (context != null) {
            try {
                if (md.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                me.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void a(Context context, String str, JSONObject jSONObject) {
        if (context != null) {
            try {
                if (md.a()) {
                    ik ikVar = new ik(context, "loc", "6.4.5", str);
                    if (jSONObject != null) {
                        ikVar.a(jSONObject.toString());
                    }
                    i.add(ikVar);
                    if (i.size() >= 30) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(i);
                        il.b(arrayList, context);
                        i.clear();
                    }
                }
            } catch (Throwable th) {
                me.a(th, "ReportUtil", "applyStatistics");
            }
        }
    }

    public static synchronized void a(Context context) {
        if (context != null) {
            try {
                if (md.a()) {
                    List<ik> list = i;
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(i);
                        il.b(arrayList, context);
                        i.clear();
                    }
                    f(context);
                }
            } catch (Throwable th) {
                me.a(th, "ReportUtil", "destroy");
            }
        }
    }

    public static void a(String str, String str2) {
        try {
            hd.b(me.c(), str2, str);
        } catch (Throwable th) {
            me.a(th, "ReportUtil", "reportLog");
        }
    }

    public final void a(Context context, int i2) {
        try {
            int i3 = this.b;
            if (i3 == i2) {
                return;
            }
            if (i3 != -1 && i3 != i2) {
                this.f3003a.append(this.b, Long.valueOf((mm.b() - this.c) + this.f3003a.get(this.b, 0L).longValue()));
            }
            this.c = mm.b() - ml.a(context, "pref1", this.d[i2], 0L);
            this.b = i2;
        } catch (Throwable th) {
            me.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        int i2;
        try {
            int i3 = AnonymousClass1.f3004a[aMapLocationClientOption.getLocationMode().ordinal()];
            if (i3 == 1) {
                i2 = 4;
            } else if (i3 != 2) {
                i2 = 3;
                if (i3 != 3) {
                    i2 = -1;
                }
            } else {
                i2 = 5;
            }
            int i4 = this.e;
            if (i4 == i2) {
                return;
            }
            if (i4 != -1 && i4 != i2) {
                this.f3003a.append(this.e, Long.valueOf((mm.b() - this.f) + this.f3003a.get(this.e, 0L).longValue()));
            }
            this.f = mm.b() - ml.a(context, "pref1", this.d[i2], 0L);
            this.e = i2;
        } catch (Throwable th) {
            me.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public static void a(Context context, int i2, int i3, long j2, long j3) {
        if (i2 == -1 || i3 == -1) {
            return;
        }
        try {
            a(context, "O012", i2, i3, j2, j3);
        } catch (Throwable th) {
            me.a(th, "ReportUtil", "reportServiceAliveTime");
        }
    }

    private static void a(Context context, String str, int i2, int i3, long j2, long j3) {
        if (context != null) {
            try {
                if (md.a()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i2);
                    jSONObject.put("param_int_second", i3);
                    jSONObject.put("param_long_first", j2);
                    jSONObject.put("param_long_second", j3);
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                me.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0034 A[Catch: all -> 0x00f0, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:4:0x0003, B:8:0x000b, B:26:0x0034, B:37:0x0047, B:39:0x004b, B:40:0x0052, B:42:0x008b, B:45:0x0098, B:46:0x00d9, B:48:0x00eb, B:43:0x0091), top: B:58:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Context context, AMapLocation aMapLocation) {
        int i2;
        try {
            if (mm.a(aMapLocation)) {
                int locationType = aMapLocation.getLocationType();
                boolean z = false;
                if (locationType == 1) {
                    i2 = 0;
                } else if (locationType == 2 || locationType == 4) {
                    i2 = 1;
                } else if (locationType == 11) {
                    i2 = 4;
                } else if (locationType == 8) {
                    i2 = 3;
                } else {
                    if (locationType != 9) {
                        i2 = 0;
                        if (z) {
                            int iC = md.c();
                            if (iC != 0) {
                                if (i2 == 0 || i2 == 4) {
                                    if (iC == 2) {
                                        return;
                                    }
                                } else if (iC == 1) {
                                    return;
                                }
                            }
                            if (j == null) {
                                j = new JSONArray();
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("lon", mm.b(aMapLocation.getLongitude()));
                            jSONObject.put(f.C, mm.b(aMapLocation.getLatitude()));
                            jSONObject.put("type", i2);
                            jSONObject.put("timestamp", mm.a());
                            if (aMapLocation.getCoordType().equalsIgnoreCase(AMapLocation.COORD_TYPE_WGS84)) {
                                jSONObject.put("coordType", 1);
                            } else {
                                jSONObject.put("coordType", 2);
                            }
                            if (i2 == 0) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("accuracy", mm.c(aMapLocation.getAccuracy()));
                                jSONObject2.put("altitude", mm.c(aMapLocation.getAltitude()));
                                jSONObject2.put("bearing", mm.c(aMapLocation.getBearing()));
                                jSONObject2.put("speed", mm.c(aMapLocation.getSpeed()));
                                jSONObject.put("extension", jSONObject2);
                            }
                            JSONArray jSONArrayPut = j.put(jSONObject);
                            j = jSONArrayPut;
                            if (jSONArrayPut.length() >= md.b()) {
                                f(context);
                            }
                        }
                    }
                    i2 = 2;
                }
                z = true;
                if (z) {
                }
            }
        } catch (Throwable th) {
            me.a(th, "ReportUtil", "recordOfflineLocLog");
        }
    }

    public static void a(String str, int i2) {
        a(str, String.valueOf(i2), a(i2));
    }

    public static void a(String str, String str2, String str3) {
        try {
            hd.a(me.c(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            if (th instanceof fq) {
                hd.a(me.c(), str, (fq) th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (g == null) {
                if (!mm.a(aMapLocation)) {
                    g = aMapLocation2;
                    return;
                }
                g = aMapLocation.m10clone();
            }
            if (mm.a(g) && mm.a(aMapLocation2)) {
                AMapLocation aMapLocationM10clone = aMapLocation2.m10clone();
                if (g.getLocationType() != 1 && g.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(g.getProvider()) && g.getLocationType() != 7 && aMapLocationM10clone.getLocationType() != 1 && aMapLocationM10clone.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(aMapLocationM10clone.getProvider()) && aMapLocationM10clone.getLocationType() != 7) {
                    long jAbs = Math.abs(aMapLocationM10clone.getTime() - g.getTime()) / 1000;
                    if (jAbs <= 0) {
                        jAbs = 1;
                    }
                    if (jAbs <= 1800) {
                        float fA = mm.a(g, aMapLocationM10clone);
                        float f = fA / jAbs;
                        if (fA > 30000.0f && f > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(g.getLatitude());
                            sb.append(",");
                            sb.append(g.getLongitude());
                            sb.append(",");
                            sb.append(g.getAccuracy());
                            sb.append(",");
                            sb.append(g.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(mm.a(g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(g.getTime());
                            }
                            sb.append("#");
                            sb.append(aMapLocationM10clone.getLatitude());
                            sb.append(",");
                            sb.append(aMapLocationM10clone.getLongitude());
                            sb.append(",");
                            sb.append(aMapLocationM10clone.getAccuracy());
                            sb.append(",");
                            sb.append(aMapLocationM10clone.getLocationType());
                            sb.append(",");
                            if (aMapLocationM10clone.getTime() != 0) {
                                sb.append(mm.a(aMapLocationM10clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(aMapLocationM10clone.getTime());
                            }
                            a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                g = aMapLocationM10clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(long j2, long j3) {
        try {
            if (h) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(mm.a(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            stringBuffer.append("sysTime:");
            stringBuffer.append(mm.a(j3, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            long jU = md.u();
            String strA = 0 != jU ? mm.a(jU, "yyyy-MM-dd HH:mm:ss.SSS") : "0";
            stringBuffer.append("serverTime:");
            stringBuffer.append(strA);
            a("checkgpstime", stringBuffer.toString());
            if (0 != jU && Math.abs(j2 - jU) < 31536000000L) {
                stringBuffer.append(", correctError");
                a("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            h = true;
        } catch (Throwable unused) {
        }
    }
}
