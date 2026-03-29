package com.opos.acs.st.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.efs.sdk.base.Constants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.t;
import com.lantern.auth.server.WkParams;
import com.opos.acs.st.STManager;
import com.opos.cmn.biz.ststrategy.entity.DataEntity;
import com.opos.cmn.biz.ststrategy.entity.MetaEntity;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.entity.StrategyEntity;
import com.opos.cmn.func.a.a.d;
import com.umeng.analytics.pro.bt;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f7727a = new byte[0];
    private static final ReadWriteLock b = new ReentrantReadWriteLock();
    private static Map<String, Long> c = new ConcurrentHashMap();
    private static Timer d = null;
    private static final byte[] e = new byte[0];
    private static boolean f = false;
    private static boolean g = false;
    private static AtomicBoolean h = new AtomicBoolean(false);
    private static boolean i = false;
    private static final ReentrantReadWriteLock j = new ReentrantReadWriteLock();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(String str, String str2);
    }

    public static com.opos.acs.st.entity.b a(Map<String, String> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.opos.acs.st.entity.b bVar = new com.opos.acs.st.entity.b();
        bVar.b = b.b(map);
        bVar.c = jCurrentTimeMillis;
        bVar.d = jCurrentTimeMillis;
        return bVar;
    }

    public static MetaEntity b(Context context, String str) {
        STConfigEntity sTConfigEntityC;
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        if (TextUtils.isEmpty(str) || (sTConfigEntityC = i.c(context)) == null || (dataEntity = sTConfigEntityC.dataEntity) == null || (map = dataEntity.metaEntityMap) == null) {
            return null;
        }
        return map.get(str);
    }

    public static StrategyEntity c(Context context) {
        DataEntity dataEntity;
        STConfigEntity sTConfigEntityC = i.c(context);
        if (sTConfigEntityC == null || (dataEntity = sTConfigEntityC.dataEntity) == null) {
            return null;
        }
        return dataEntity.strategyEntity;
    }

    public static String d() {
        return a("3.13.0") ? "" : "3.13.0";
    }

    public static synchronized void e(Context context) {
        long jMax;
        long jMax2;
        synchronized (e) {
            try {
                boolean zG = g();
                f.b("Utils", "begin start Timer,reportTimer=" + d + ",startReportTimer=" + zG + ",isStartTimering=" + f);
                if (context != null && d == null && zG && !f) {
                    f = true;
                    StrategyEntity strategyEntityC = c(context);
                    if (strategyEntityC != null) {
                        jMax = Math.max(60, strategyEntityC.frequencyTime) * 1000;
                        jMax2 = Math.max(60, strategyEntityC.wfTime) * 1000;
                    } else {
                        jMax = 0;
                        jMax2 = 0;
                    }
                    long j2 = (!h(context) || jMax2 <= 0) ? jMax : jMax2;
                    if (j2 <= 0) {
                        j2 = 60000;
                    }
                    long j3 = j2;
                    h hVar = new h(context, jMax, jMax2, j3);
                    d = new Timer();
                    boolean zE = e();
                    if (zE) {
                        d.schedule(hVar, 0L, j3);
                    }
                    f.b("Utils", "do really start timer!period=" + j3 + ",shouldRunTimer=" + zE);
                }
            } finally {
                f = false;
            }
        }
    }

    public static String f(Context context) {
        return (context == null || com.opos.cmn.an.h.f.a.d(context)) ? "0" : "1";
    }

    public static HashMap<String, String> g(Context context) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-type", "application/json");
        map.put(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        map.put("Connection", HTTP.CONN_KEEP_ALIVE);
        map.put("Content-Encoding", Constants.CP_GZIP);
        map.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
        return map;
    }

    public static String h() {
        String property;
        try {
            property = System.getProperty("http.agent");
        } catch (Exception e2) {
            f.b("Utils", "", e2);
            property = "";
        }
        f.a("Utils", "getUserAgent=" + property);
        return property;
    }

    private static String i() {
        String language = Locale.getDefault().getLanguage();
        return language == null ? "" : language;
    }

    private static String j() {
        String country = Locale.getDefault().getCountry();
        return country == null ? "" : country;
    }

    private static String k() {
        return UUID.randomUUID().toString() + "-" + System.currentTimeMillis();
    }

    public static void l(Context context) {
        STConfigEntity sTConfigEntityC = i.c(context);
        if (sTConfigEntityC != null) {
            a(context, sTConfigEntityC);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        r20 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m(Context context) {
        STConfigEntity sTConfigEntityC;
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        StrategyEntity strategyEntity;
        long j2;
        List<com.opos.acs.st.entity.b> listA;
        long j3;
        String str;
        long j4;
        String str2;
        try {
            int iA = com.opos.acs.st.db.c.a(context);
            f.b("Utils", "move temp db data to local biz db db, num:" + iA);
            if (iA != 0 && (sTConfigEntityC = i.c(context)) != null && (dataEntity = sTConfigEntityC.dataEntity) != null && (map = dataEntity.metaEntityMap) != null && (strategyEntity = dataEntity.strategyEntity) != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i2 = strategyEntity.reportLimit;
                if (i2 <= 0) {
                    i2 = 30;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis() - ((((((long) i2) * 24) * 60) * 60) * 1000);
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int iMin = Math.min(20, iA - (i3 * 20));
                    if (iMin != 0 && (listA = com.opos.acs.st.db.c.a(context, jCurrentTimeMillis2, iMin)) != null) {
                        Iterator<com.opos.acs.st.entity.b> it = listA.iterator();
                        while (it.hasNext()) {
                            com.opos.acs.st.entity.b next = it.next();
                            Map<String, String> mapA = b.a(next.b);
                            if (mapA == null) {
                                com.opos.acs.st.db.c.c(context, next);
                                i5++;
                            } else {
                                int i6 = iA;
                                String str3 = mapA.get(STManager.KEY_DATA_TYPE);
                                Map<String, MetaEntity> map2 = map;
                                MetaEntity metaEntity = map.get(str3);
                                if (metaEntity == null) {
                                    com.opos.acs.st.db.c.b(context, next);
                                    iA = i6;
                                    map = map2;
                                } else {
                                    Iterator<com.opos.acs.st.entity.b> it2 = it;
                                    long j5 = jCurrentTimeMillis;
                                    boolean zEquals = "wbs".equals(metaEntity.version);
                                    mapA.put(x.cw, String.valueOf(metaEntity.category));
                                    mapA.put("eventValue", String.valueOf(metaEntity.eventValue));
                                    mapA.put("count", "1");
                                    mapA.put("clickId", k());
                                    mapA.put("oriDatatype", zEquals ? "" : str3);
                                    String str4 = mapA.get("statUploadStrategy");
                                    if (zEquals || "3".equals(str4)) {
                                        str = str3;
                                        j4 = jCurrentTimeMillis2;
                                    } else {
                                        j4 = jCurrentTimeMillis2;
                                        if (metaEntity.uploadFlag != 0) {
                                            str = str3;
                                            a(context, a(context, str3, mapA, false), metaEntity.aggrFlag, -1);
                                        } else {
                                            str = str3;
                                        }
                                    }
                                    if (zEquals || "3".equals(str4) || "2".equals(str4)) {
                                        if (zEquals) {
                                            str2 = str;
                                        } else {
                                            str2 = metaEntity.newDatatype;
                                            if (!TextUtils.isEmpty(str2) && (metaEntity = sTConfigEntityC.dataEntity.metaEntityMap.get(str2)) != null) {
                                            }
                                        }
                                        if (metaEntity.uploadFlag != 0) {
                                            a(context, a(context, str2, mapA, true), metaEntity.aggrFlag, -1);
                                        }
                                    }
                                    com.opos.acs.st.db.c.c(context, next);
                                    i5++;
                                    iA = i6;
                                    it = it2;
                                    map = map2;
                                    jCurrentTimeMillis = j5;
                                    jCurrentTimeMillis2 = j4;
                                }
                            }
                        }
                        int i7 = iA;
                        Map<String, MetaEntity> map3 = map;
                        j2 = jCurrentTimeMillis;
                        j3 = jCurrentTimeMillis2;
                        i3++;
                        int size = listA.size();
                        i4 += size;
                        f.a("Utils", "move count:" + size + ", delete total count:" + i5 + ",move total:" + i4);
                        if (size < 20 || i4 >= 200) {
                            break;
                        }
                        iA = i7;
                        map = map3;
                        jCurrentTimeMillis = j2;
                        jCurrentTimeMillis2 = j3;
                    }
                    com.opos.acs.st.db.c.a(context, jCurrentTimeMillis2);
                    STManager.getInstance().reportDataOnExit(context);
                    f.a("Utils", "Move biz data finish! cost time:" + (System.currentTimeMillis() - j2));
                }
                jCurrentTimeMillis2 = j3;
                com.opos.acs.st.db.c.a(context, jCurrentTimeMillis2);
                STManager.getInstance().reportDataOnExit(context);
                f.a("Utils", "Move biz data finish! cost time:" + (System.currentTimeMillis() - j2));
            }
        } catch (Exception e2) {
            f.c("Utils", "moveBizData2StatDb error", e2);
        }
    }

    private static String n(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static com.opos.acs.st.entity.d a(Context context, String str, Map<String, String> map, boolean z) {
        com.opos.acs.st.entity.d dVar = new com.opos.acs.st.entity.d();
        dVar.b = str;
        dVar.c = map.get("adId");
        dVar.d = a(context, str, map);
        if (map.get("parEvtId") != null) {
            dVar.h = map.get("parEvtId");
        }
        dVar.i = System.currentTimeMillis();
        long jCurrentTimeMillis = System.currentTimeMillis();
        StrategyEntity strategyEntityC = c(context);
        MetaEntity metaEntityB = b(context, str);
        List<String> list = metaEntityB != null ? metaEntityB.eventKeys : null;
        if (z) {
            dVar.k = a(context, strategyEntityC != null ? strategyEntityC.commonKeys : null, map, true);
            dVar.l = a(context, list, map, true);
            dVar.j = 1;
        } else {
            String strC = c(context, str);
            List<String> list2 = strategyEntityC != null ? strategyEntityC.headKeys : null;
            List<String> list3 = strategyEntityC != null ? strategyEntityC.bodyKeys : null;
            dVar.e = a(context, list2, map, strC, false);
            dVar.f = a(context, list3, map, strC, false);
            dVar.g = a(context, list, map, ",", false);
            dVar.j = 0;
        }
        f.a("Utils", "map2AcsStDbCache,dataType=" + str + ",cost time=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return dVar;
    }

    public static String b() {
        String strB = com.opos.cmn.an.c.d.b();
        return strB != null ? strB.toUpperCase() : "";
    }

    public static String c() {
        String str = Build.VERSION.RELEASE;
        return a(str) ? "" : str;
    }

    public static void d(Context context) {
        STConfigEntity sTConfigEntityC;
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        if (context == null || (sTConfigEntityC = i.c(context)) == null || (dataEntity = sTConfigEntityC.dataEntity) == null || dataEntity.strategyEntity == null || (map = dataEntity.metaEntityMap) == null) {
            return;
        }
        List<String> listA = com.opos.acs.st.db.b.a(context);
        synchronized (f7727a) {
            for (String str : map.keySet()) {
                if (listA != null && listA.size() > 0) {
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        b(context, str, listA.get(i2));
                    }
                }
            }
            int i3 = sTConfigEntityC.dataEntity.strategyEntity.reportLimit;
            if (i3 <= 0) {
                i3 = 30;
            }
            f.b("Utils", "recordEvents end,reportLimit =" + i3 + "days, delete overdue count =" + com.opos.acs.st.db.b.a(context, "'cpd-app-expose', 'cpd-srh-expose', 'bd-expose', 'feeds-expose', 'sms-expose'", System.currentTimeMillis() - ((((((long) i3) * 24) * 60) * 60) * 1000)));
        }
    }

    public static boolean e() {
        return !h.get();
    }

    public static synchronized void f() {
        synchronized (e) {
            try {
                f.b("Utils", "cancel timer,is canceled=" + g);
                Timer timer = d;
                if (timer != null && !g) {
                    g = true;
                    timer.cancel();
                    d = null;
                }
            } finally {
                g = false;
            }
        }
    }

    public static boolean g() {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = j;
            reentrantReadWriteLock.readLock().lock();
            boolean z = i;
            reentrantReadWriteLock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            j.readLock().unlock();
            throw th;
        }
    }

    public static boolean h(Context context) {
        return "WIFI".equalsIgnoreCase(b(context));
    }

    public static boolean i(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            f.c("Utils", "", e2);
            return false;
        }
    }

    public static boolean j(Context context) {
        if (context == null || !i(context) || d.b()) {
            return false;
        }
        f.c("Utils", "isDebuggable, not inited");
        return true;
    }

    public static String k(Context context) {
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        f.a("Utils", "getWebUserAgent=" + defaultUserAgent);
        return defaultUserAgent;
    }

    public static MetaEntity a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            f.c("Utils", "No associate new dataType!old dataType:" + str + ",new dataType:" + str2);
            g.a(context).a(ErrorContants.errorContantseMap(context, "5", ErrorContants.NO_NEW_OLD_ASSOCIATE, "", "", 0L, 0L, "old dataType:" + str + ",new dataType:" + str2));
            return null;
        }
        MetaEntity metaEntityB = b(context, str2);
        if (metaEntityB == null) {
            f.c("Utils", "No associate dataType strategy!old dataType:" + str + ",new dataType:" + str2);
            g.a(context).a(ErrorContants.errorContantseMap(context, "5", ErrorContants.NO_NEW_STRATEGY_ERROR, "", "", 0L, 0L, "old dataType:" + str + ",new dataType:" + str2));
            i.b(context, str2);
        }
        return metaEntityB;
    }

    public static String b(Context context) {
        return com.opos.cmn.an.h.c.a.f(context);
    }

    private static String c(Context context, String str) {
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        MetaEntity metaEntity;
        String str2;
        STConfigEntity sTConfigEntityC = i.c(context);
        return (sTConfigEntityC == null || (dataEntity = sTConfigEntityC.dataEntity) == null || (map = dataEntity.metaEntityMap) == null || str == null || (metaEntity = map.get(str)) == null || (str2 = metaEntity.split) == null) ? "\t" : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Long l = c.get(str);
        if (l == null) {
            l = 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - l.longValue() < 300000) {
            return false;
        }
        c.put(str, Long.valueOf(jCurrentTimeMillis));
        return true;
    }

    public static String a() {
        String strA = com.opos.cmn.an.c.d.a();
        if (a(strA) || "0".equalsIgnoreCase(strA)) {
            strA = "";
        }
        return strA.toUpperCase();
    }

    private static String b(Context context, List<String> list, Map<String, String> map, boolean z) {
        String string = "";
        if (list != null && context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str = list.get(i2);
                    if (str != null && !"eventKeys".equals(str)) {
                        if ("ext".equals(str)) {
                            jSONObject.put(str, "");
                        } else {
                            jSONObject.put(str, a(context, str, map, "", z));
                        }
                    }
                }
                string = jSONObject.toString();
            } catch (JSONException e2) {
                f.b("Utils", "", e2);
            }
        }
        f.a("Utils", "getExtJsonValues = " + string);
        return string;
    }

    public static String c(String str) {
        if (a(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("(?<=\\#)(\\S+)(?=\\#)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static String a(Context context) {
        return "";
    }

    public static JSONObject b(Context context, com.opos.acs.st.entity.d dVar) throws JSONException {
        boolean z = dVar.j == 0;
        JSONObject jSONObject = new JSONObject();
        if (z) {
            String strReplace = dVar.g;
            if (strReplace != null) {
                strReplace = strReplace.replace("#", "");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("evtTime", dVar.i);
            jSONObject2.put(STManager.KEY_DATA_TYPE, dVar.b);
            jSONObject.put("headers", jSONObject2);
            String strC = c(context, dVar.b);
            jSONObject.put("body", dVar.e + strC + dVar.f + strC + strReplace);
        } else {
            JSONObject jSONObject3 = dVar.k;
            JSONObject jSONObject4 = dVar.l;
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            if (jSONObject4 == null) {
                jSONObject4 = new JSONObject();
            }
            jSONObject3.put("evtTime", dVar.i);
            jSONObject3.put(STManager.KEY_DATA_TYPE, dVar.b);
            jSONObject.put("header", jSONObject3);
            jSONObject.put("body", jSONObject4);
        }
        return jSONObject;
    }

    private static boolean c(Context context, String str, String str2) {
        MetaEntity metaEntityB;
        List<String> list;
        f.a("Utils", "start ifDataEffective");
        if (str2 == null || "".equals(str2)) {
            return true;
        }
        try {
            ReadWriteLock readWriteLock = b;
            readWriteLock.readLock().lock();
            com.opos.acs.st.entity.c cVarB = com.opos.acs.st.db.b.b(context, str2);
            readWriteLock.readLock().unlock();
            f.a("Utils", "statBatchEntity=" + cVarB);
            if (cVarB != null) {
                if (cVarB.d == 1 || cVarB.c == null || a(context, str) || (metaEntityB = b(context, str)) == null || (list = metaEntityB.judgePosids) == null || list.size() == 0) {
                    return true;
                }
                f.a("Utils", "statBatchEntity.acsPosIds=" + cVarB.c);
                String[] strArrSplit = cVarB.c.split("\\|");
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str3 = list.get(i2);
                    for (String str4 : strArrSplit) {
                        if (!Pattern.compile(str3).matcher(str4).find()) {
                            f.a("Utils", "judgePosid=" + str3 + ",acsPosId=" + str4 + " not match!");
                            return true;
                        }
                    }
                }
            }
            f.a("Utils", "end ifDataEffective");
            return false;
        } catch (Throwable th) {
            b.readLock().unlock();
            throw th;
        }
    }

    public static String a(Context context, com.opos.acs.st.entity.d dVar) {
        String str;
        if (dVar == null) {
            return "";
        }
        boolean z = dVar.j == 0;
        try {
            f.a("Utils", "dataType=" + dVar.b + ",acsId=" + dVar.c);
            if (z && (str = dVar.f) != null) {
                dVar.f = str.replace("sessionIdRpl", "1");
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(b(context, dVar));
            return jSONArray.toString();
        } catch (Exception e2) {
            f.c("Utils", "acsStDbCache2JsonString:" + e2.toString());
            return "";
        }
    }

    public static void b(final Context context, final String str, final String str2) {
        String str3;
        STConfigEntity sTConfigEntityC;
        DataEntity dataEntity;
        StrategyEntity strategyEntity;
        Map<String, MetaEntity> map;
        MetaEntity metaEntity;
        String str4;
        String str5 = "Utils";
        if (context != null) {
            try {
                sTConfigEntityC = i.c(context);
            } catch (Throwable th) {
                th = th;
                str3 = str5;
            }
            if (str2 != null && !"".equals(str2.trim()) && sTConfigEntityC != null && (dataEntity = sTConfigEntityC.dataEntity) != null && (strategyEntity = dataEntity.strategyEntity) != null && (map = dataEntity.metaEntityMap) != null && (metaEntity = map.get(str)) != null) {
                final j jVarA = j.a();
                boolean zD = jVarA.d(str, str2);
                f.a("Utils", "limitRetry=" + zD + ",dataType=" + str + ",url=" + str2);
                if (zD) {
                    return;
                }
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                int i2 = metaEntity.batchNums;
                if (i2 <= 0) {
                    i2 = strategyEntity.batchNums;
                }
                int i3 = i2;
                List<com.opos.acs.st.entity.d> listA = com.opos.acs.st.db.b.a(context, str, str2);
                if (i3 != 0 && listA != null && listA.size() > 0) {
                    int size = listA.size() % i3 == 0 ? listA.size() / i3 : (listA.size() / i3) + 1;
                    int i4 = 0;
                    while (i4 < size) {
                        int i5 = i4 * i3;
                        int i6 = i4 + 1;
                        int size2 = i6 * i3;
                        try {
                            if (size2 > listA.size()) {
                                size2 = listA.size();
                            }
                            if (size2 < i5) {
                                return;
                            }
                            final List<com.opos.acs.st.entity.d> listSubList = listA.subList(i5, size2);
                            final Integer[] numArr = new Integer[listSubList.size()];
                            final ArrayList arrayList = new ArrayList();
                            int i7 = 0;
                            for (com.opos.acs.st.entity.d dVar : listSubList) {
                                int i8 = i7 + 1;
                                numArr[i7] = Integer.valueOf(dVar.f7714a);
                                String str6 = dVar.h;
                                if (str6 != null && !arrayList.contains(str6)) {
                                    arrayList.add(dVar.h);
                                }
                                i7 = i8;
                            }
                            String strA = a(context, listSubList);
                            System.currentTimeMillis();
                            str4 = str5;
                            int i9 = size;
                            List<com.opos.acs.st.entity.d> list = listA;
                            try {
                                a(context, str2, strA, str, new a() { // from class: com.opos.acs.st.utils.k.3
                                    @Override // com.opos.acs.st.utils.k.a
                                    public void a() {
                                        k.b(context, numArr, (List<String>) arrayList);
                                        j.a().b(str, str2);
                                    }

                                    @Override // com.opos.acs.st.utils.k.a
                                    public void a(String str7, String str8) {
                                        boolean z = listSubList.size() > 0 && ((com.opos.acs.st.entity.d) listSubList.get(0)).j == 1;
                                        if (String.valueOf(400).equals(str7)) {
                                            k.b(context, numArr, (List<String>) arrayList);
                                        } else if (!z) {
                                            for (int i10 = 0; i10 < listSubList.size(); i10++) {
                                                k.a(context, (com.opos.acs.st.entity.d) listSubList.get(i10), str7);
                                            }
                                        }
                                        if (atomicBoolean.compareAndSet(false, true) && jVarA.a(str7)) {
                                            jVarA.a(str, str2);
                                        }
                                    }
                                });
                                i4 = i6;
                                str5 = str4;
                                size = i9;
                                listA = list;
                            } catch (Throwable th2) {
                                th = th2;
                                str3 = str4;
                                f.c(str3, "recordEventsByDataType", th);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str4 = str5;
                            str3 = str4;
                            f.c(str3, "recordEventsByDataType", th);
                        }
                    }
                    str4 = str5;
                    str3 = str4;
                    try {
                        f.a(str3, "recordEventsByDataType end:" + str);
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                return;
                f.c(str3, "recordEventsByDataType", th);
            }
        }
    }

    public static String a(Context context, String str, Map<String, String> map) {
        String str2;
        if (context != null && map != null && !a(context, str)) {
            StrategyEntity strategyEntityC = c(context);
            MetaEntity metaEntityB = b(context, str);
            if (metaEntityB != null) {
                String str3 = metaEntityB.url;
                if (!a(str3) && strategyEntityC != null) {
                    int i2 = strategyEntityC.prtflg;
                    StringBuilder sb = new StringBuilder();
                    if (str3.startsWith("http://")) {
                        String strReplace = str3.replace("http://", "");
                        sb.append("http://");
                        str2 = str3;
                        str3 = strReplace;
                    } else if (str3.startsWith("https://")) {
                        String strReplace2 = str3.replace("https://", "");
                        sb.append("https://");
                        str2 = str3;
                        str3 = strReplace2;
                    } else if (i2 == 1) {
                        str2 = "https://" + str3;
                        sb.append("https://");
                    } else {
                        sb.append("http://");
                        str2 = "http://" + str3;
                    }
                    f.a("Utils", "prtflg = " + i2);
                    f.a("Utils", "nonDmDefaultUrlUrl:" + str3);
                    f.a("Utils", "dmDefaultUrlUrl:" + str2);
                    f.a("Utils", "urlBuffer:" + ((Object) sb));
                    List<String> list = strategyEntityC.dmKeys;
                    String str4 = map.get(t.v);
                    int i3 = -1;
                    if (str4 != null) {
                        try {
                            i3 = Integer.parseInt(str4);
                        } catch (Exception e2) {
                            f.b("Utils", "createUrl error", e2);
                        }
                    }
                    String strSubstring = str3.substring(0, str3.indexOf("/"));
                    String str5 = map.get("area");
                    String strSubstring2 = str3.substring(str3.indexOf("/"));
                    if (i3 < 0 || list == null || i3 >= list.size()) {
                        sb.append(strSubstring);
                    } else {
                        sb.append(list.get(i3));
                    }
                    if (str5 != null && !"".equals(str5.trim())) {
                        sb.append("/");
                        sb.append(str5);
                    }
                    if (!"".equals(strSubstring2.trim())) {
                        sb.append(strSubstring2);
                    }
                    return sb.toString();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final boolean z, final boolean z2, Map<String, String> map, final MetaEntity metaEntity, final STManager.EventListener eventListener) throws Throwable {
        String str;
        String str2;
        if (metaEntity.uploadFlag == 0) {
            f.b("Utils", "report data no need upload!");
            b(z2, 3, eventListener);
            return;
        }
        StrategyEntity strategyEntityC = c(context);
        final com.opos.acs.st.entity.d dVarA = a(context, metaEntity.dataType, map, z);
        if (!com.opos.cmn.an.h.c.a.d(context)) {
            f.b("Utils", "report data fail:no net!");
            a(context, dVarA, metaEntity.aggrFlag, strategyEntityC.triggerNums);
            b(z2, 5, eventListener);
            return;
        }
        if (metaEntity.immFlag != 0) {
            f.a("Utils", "report data immediately.dataType= " + metaEntity.dataType + ",new dataType= " + z);
            final String str3 = dVarA.d;
            if (TextUtils.isEmpty(str3)) {
                b(z2, 4, eventListener);
                return;
            } else {
                String strA = a(context, dVarA);
                System.currentTimeMillis();
                a(context, str3, strA, metaEntity.dataType, new a() { // from class: com.opos.acs.st.utils.k.2
                    @Override // com.opos.acs.st.utils.k.a
                    public void a() {
                        k.b(z2, 1, eventListener);
                        j.a().b(metaEntity.dataType, str3);
                    }

                    @Override // com.opos.acs.st.utils.k.a
                    public void a(String str4, String str5) {
                        if (!String.valueOf(400).equals(str4)) {
                            k.a(context, dVarA, metaEntity.aggrFlag, 0);
                            if (!z) {
                                k.a(context, dVarA, str4);
                            }
                        }
                        j jVarA = j.a();
                        if (jVarA.a(str4) && !jVarA.c(metaEntity.dataType, str3)) {
                            jVarA.a(metaEntity.dataType, str3);
                        }
                        k.b(z2, 2, eventListener);
                    }
                });
            }
        } else {
            f.b("Utils", "report data delay!insert db.dataType=" + metaEntity.dataType + ",is new dataType=" + z);
            a(context, dVarA, metaEntity.aggrFlag, strategyEntityC.triggerNums);
            b(z2, 5, eventListener);
        }
        if (!z && (str = map.get("parEvtId")) != null && !"".equals(str.trim())) {
            try {
                ReadWriteLock readWriteLock = b;
                readWriteLock.writeLock().lock();
                f.a("Utils", "evtParentId=" + str);
                com.opos.acs.st.entity.c cVarB = com.opos.acs.st.db.b.b(context, str);
                if (cVarB == null) {
                    com.opos.acs.st.entity.c cVar = new com.opos.acs.st.entity.c();
                    cVar.b = str;
                    cVar.c = map.get(STManager.KEY_AD_POS_ID);
                    if (metaEntity.immFlag != 0) {
                        cVar.d = 1;
                    } else if (metaEntity.judgePosids != null) {
                        cVar.d = 0;
                    }
                    f.a("Utils", "insertStatBatchEntity:" + cVar);
                    com.opos.acs.st.db.b.a(context, cVar);
                } else if (cVarB.d == 0) {
                    if (metaEntity.immFlag != 0) {
                        cVarB.d = 1;
                    } else if (cVarB.c != null && (str2 = map.get(STManager.KEY_AD_POS_ID)) != null && !cVarB.c.contains(str2)) {
                        cVarB.c += HiAnalyticsConstant.REPORT_VAL_SEPARATOR + map.get(STManager.KEY_AD_POS_ID);
                    }
                    com.opos.acs.st.db.b.b(context, cVarB);
                    f.a("Utils", "updateStatBatchEntity:" + cVarB);
                }
                readWriteLock.writeLock().unlock();
            } catch (Throwable th) {
                b.writeLock().unlock();
                throw th;
            }
        }
        f.b("Utils", "report recordEvent end!!!!!!!dataType=" + metaEntity.dataType);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str, Map<String, String> map, String str2, boolean z) {
        String strD;
        boolean zB = com.opos.cmn.an.f.a.b(context);
        if (map != null && map.containsKey(str)) {
            strD = map.get(str);
        } else if (WkParams.IMEI.equals(str)) {
            strD = zB ? "" : a(context);
        } else if (WkParams.MODEL.equals(str)) {
            strD = com.opos.cmn.an.c.c.a();
        } else if ("osVersion".equals(str)) {
            strD = a();
        } else if ("romVersion".equals(str)) {
            strD = b();
        } else if ("androidVersion".equals(str)) {
            strD = c();
        } else if ("sdkVersion".equals(str) || "statSdkVer".equals(str)) {
            strD = d();
        } else if ("appVersion".equals(str)) {
            strD = com.opos.cmn.an.h.d.a.c(context, n(context));
        } else if ("networkId".equals(str)) {
            strD = b(context);
        } else if ("clientTime".equals(str)) {
            strD = String.valueOf((int) (System.currentTimeMillis() / 1000));
        } else if ("evtId".equals(str)) {
            strD = "" + System.currentTimeMillis();
        } else if (bt.P.equals(str)) {
            strD = com.opos.cmn.an.h.e.a.b(context);
        } else if ("scOri".equals(str)) {
            strD = f(context);
        } else if ("appCode".equals(str)) {
            strD = String.valueOf(com.opos.cmn.an.h.d.a.b(context, n(context)));
        } else if ("firstBootTime".equals(str)) {
            strD = String.valueOf(Build.TIME);
        } else if (!"allInstalledPkgNames".equals(str)) {
            if (WkParams.SESSIONID.equals(str)) {
                strD = z ? null : "sessionIdRpl";
            } else if ("a".equals(str)) {
                if (!z) {
                    strD = "#0#";
                }
            } else if ("local".equals(str)) {
                strD = context.getResources().getConfiguration().locale.getCountry();
            } else if ("ouId".equals(str)) {
                strD = com.opos.cmn.g.a.b.a(context);
            } else if ("duId".equals(str)) {
                strD = com.opos.cmn.g.a.b.b(context);
            } else if ("ouidStatus".equals(str)) {
                strD = com.opos.cmn.g.a.b.g(context) + "";
            } else if ("country".equals(str)) {
                strD = j();
            } else if ("region".equals(str)) {
                strD = d.a(context);
            } else if (WkParams.LANG.equals(str)) {
                strD = i();
            } else if ("gaid".equals(str)) {
                strD = com.opos.cmn.g.a.b.f(context);
            } else if ("anId".equals(str)) {
                if (!zB) {
                    strD = com.opos.cmn.an.c.e.a(context);
                }
            } else if ("brand".equals(str)) {
                strD = d.b(context);
            } else if ("mac".equals(str)) {
                if (!zB) {
                    strD = com.opos.cmn.g.a.d.a(context);
                }
            } else if ("ua".equals(str)) {
                strD = h();
            } else if ("webUA".equals(str)) {
                strD = k(context);
            } else if (!"guId".equals(str)) {
                if ("appPkg".equals(str)) {
                    strD = n(context);
                } else if ("ext".equals(str)) {
                    strD = a(context, map, z);
                } else if ("localId".equals(str)) {
                    strD = com.opos.cmn.g.a.c.b(context);
                } else if ("clientMode".equals(str)) {
                    strD = zB ? "1" : "0";
                } else if (z) {
                }
            }
        }
        return strD != null ? strD.replaceAll(str2, "").replace("\t", "").replace(",", "") : strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, Integer[] numArr, List<String> list) {
        com.opos.acs.st.db.b.a(context, numArr);
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            ReadWriteLock readWriteLock = b;
            readWriteLock.writeLock().lock();
            f.a("Utils", "delete db data, batchIds:" + list);
            com.opos.acs.st.db.b.a(context, list);
            readWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            b.writeLock().unlock();
            throw th;
        }
    }

    public static String a(Context context, List<com.opos.acs.st.entity.d> list) {
        String strReplace;
        if (list != null && list.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (com.opos.acs.st.entity.d dVar : list) {
                    if (dVar.j == 0) {
                        if (c(context, dVar.b, dVar.h)) {
                            f.a("Utils", "dataType=" + dVar.b + ",acsId=" + dVar.c + ",effective");
                            strReplace = dVar.f.replace("sessionIdRpl", "1");
                        } else {
                            f.b("Utils", "dataType=" + dVar.b + ",acsId=" + dVar.c + "， not effective");
                            strReplace = dVar.f.replace("sessionIdRpl", "0");
                        }
                        dVar.f = strReplace;
                    }
                    jSONArray.put(b(context, dVar));
                }
                return jSONArray.toString();
            } catch (Exception e2) {
                f.c("Utils", "acsStDbCache2JsonString:" + e2.toString());
            }
        }
        return "";
    }

    public static void b(boolean z) {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = j;
            reentrantReadWriteLock.writeLock().lock();
            i = z;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            j.writeLock().unlock();
            throw th;
        }
    }

    public static String a(Context context, List<String> list, Map<String, String> map, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (list != null && context != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str2 = list.get(i2);
                if (str2 != null && !"eventKeys".equals(str2)) {
                    sb.append(a(context, str2, map, str, z));
                    if (i2 < list.size() - 1) {
                        sb.append(str);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, int i2, STManager.EventListener eventListener) {
        if (eventListener != null && z) {
            eventListener.onEventReturn(i2);
        }
    }

    public static synchronized String a(Context context, Map<String, String> map, boolean z) {
        String strA;
        StrategyEntity strategyEntityC = c(context);
        strA = com.opos.cmn.an.b.d.a(b(context, strategyEntityC != null ? strategyEntityC.extKeys : null, map, z));
        if (strA == null) {
            strA = "";
        }
        return strA;
    }

    public static byte[] b(String str) {
        byte[] bArrA;
        byte[] bytes = "".getBytes();
        return (str == null || (bArrA = com.opos.cmn.b.c.a.a(str.getBytes())) == null) ? bytes : bArrA;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length <= 0) {
            return null;
        }
        try {
            return (Integer.parseInt(strArrSplit[0]) + 1) + "_" + str2;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("Utils", "getRetStr error", e2);
            return null;
        }
    }

    public static JSONObject a(Context context, List<String> list, Map<String, String> map, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (list != null && context != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = list.get(i2);
                if (str != null && !"eventKeys".equals(str)) {
                    try {
                        String strA = a(context, str, map, "", z);
                        if (strA != null) {
                            jSONObject.put(str, strA);
                        }
                    } catch (JSONException e2) {
                        f.b("Utils", "getValueJsonObject", e2);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void a(Context context, com.opos.acs.st.entity.d dVar, int i2, int i3) {
        String str;
        String str2;
        synchronized (f7727a) {
            if (i2 != 0) {
                String strC = c(context, dVar.b);
                com.opos.acs.st.entity.d dVarA = com.opos.acs.st.db.b.a(context, dVar.b, dVar.c, dVar.d);
                if (dVarA == null) {
                    com.opos.acs.st.db.b.a(context, dVar);
                } else {
                    if (dVar.j == 0) {
                        int iLastIndexOf = dVarA.f.lastIndexOf(strC);
                        if (iLastIndexOf <= 0) {
                            return;
                        }
                        try {
                            String strSubstring = dVarA.f.substring(iLastIndexOf + 1);
                            f.a("Utils", "count=" + strSubstring);
                            int i4 = Integer.parseInt(strSubstring) + 1;
                            dVarA.f = dVarA.f.substring(0, iLastIndexOf);
                            dVarA.f += strC + i4;
                        } catch (Exception e2) {
                            e = e2;
                            str = "Utils";
                            str2 = "insertOrMergeAcsStDbCache";
                            f.c(str, str2, e);
                        }
                        com.opos.acs.st.db.b.b(context, dVarA);
                    } else {
                        try {
                            JSONObject jSONObject = dVarA.k;
                            if (jSONObject != null && jSONObject.has("count")) {
                                jSONObject.put("count", jSONObject.optInt("count") + 1);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = "Utils";
                            str2 = "insertOrMergeAcsStDbCache";
                            f.c(str, str2, e);
                        }
                        com.opos.acs.st.db.b.b(context, dVarA);
                    }
                }
            } else {
                com.opos.acs.st.db.b.a(context, dVar);
                if (i3 > 0) {
                    int iIntValue = com.opos.acs.st.db.b.a(context, dVar.b).intValue();
                    f.a("Utils", dVar.b + "已经有事件 count=" + iIntValue);
                    if (iIntValue != 0 && iIntValue >= i3) {
                        b(context, dVar.b, dVar.d);
                    }
                }
            }
        }
    }

    public static void a(Context context, com.opos.acs.st.entity.d dVar, String str) {
        String strA;
        if (dVar == null || str == null || dVar.j != 0 || (strA = a(c(dVar.g), str)) == null) {
            return;
        }
        dVar.g = dVar.g.replaceAll("#.*?#", "#" + strA + "#");
        com.opos.acs.st.db.b.b(context, dVar);
    }

    public static void a(Context context, STConfigEntity sTConfigEntity) {
        if (context == null || sTConfigEntity == null) {
            return;
        }
        boolean zA = a(sTConfigEntity);
        boolean zE = e();
        b(zA);
        f.b("Utils", "start report timer!!!result=" + zA + ",shouldRunTimer=" + zE);
        if (zA && zE) {
            e(context);
        } else {
            f();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, String str, String str2, String str3, a aVar) throws Throwable {
        com.opos.cmn.func.a.a.e eVarA;
        long jCurrentTimeMillis;
        boolean z;
        String str4;
        InputStream inputStream;
        InputStream inputStream2;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        com.opos.cmn.func.a.a.e eVar = 0;
        try {
            try {
                f.b("Utils", "report data http start======, dataType= " + str3 + ",url= " + str + ", string= " + str2);
                eVarA = com.opos.cmn.func.a.a.b.a().a(context, new d.a().b(str).a(g(context)).a("POST").a(b(str2)).a());
                try {
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    z = true;
                    if (!(eVarA != null && 200 == eVarA.f7934a) || ((inputStream2 = eVarA.c) != null && inputStream2.read() != -1)) {
                        z = false;
                    }
                } catch (Exception e2) {
                    e = e2;
                    f.b("Utils", "report data fail!dataType= " + str3 + ",cost =" + (System.currentTimeMillis() - jCurrentTimeMillis2) + ",exception= ", e);
                    aVar.a("-1", null);
                    if (eVarA == null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                eVar = context;
                if (eVar != 0) {
                    eVar.a();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            eVarA = null;
        } catch (Throwable th2) {
            th = th2;
            if (eVar != 0) {
            }
            throw th;
        }
        if (z) {
            f.b("Utils", "report data success======!dataType=" + str3 + ",cost=" + jCurrentTimeMillis);
            aVar.a();
            if (eVarA != null) {
                eVarA.a();
                return;
            }
            return;
        }
        if (eVarA == null) {
            str4 = "-2";
        } else {
            str4 = "" + eVarA.f7934a;
        }
        String str5 = (eVarA == null || (inputStream = eVarA.c) == null) ? null : new String(a(inputStream));
        aVar.a(str4, str5);
        f.b("Utils", "report data fail======! dataType = " + str3 + ",cost =" + jCurrentTimeMillis + ",code =" + str4 + ",stream = " + str5);
        if (eVarA == null) {
            return;
        }
        eVarA.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(final Context context, final Map<String, String> map, final STManager.EventListener eventListener) {
        boolean z;
        int i2;
        String str;
        if (context == null || map == null) {
            return;
        }
        String str2 = map.get(STManager.KEY_DATA_TYPE);
        if (str2 != null) {
            if ("".equals(str2.trim())) {
                z = true;
                f.c("Utils", "report data dataType is empty!");
                i2 = 4;
            } else {
                final MetaEntity metaEntityB = b(context, str2);
                if (!a(context, str2) && metaEntityB != null) {
                    boolean zEquals = "wbs".equals(metaEntityB.version);
                    map.put("count", "1");
                    map.put("clickId", k());
                    map.put(x.cw, String.valueOf(metaEntityB.category));
                    map.put("eventValue", String.valueOf(metaEntityB.eventValue));
                    map.put("oriDatatype", zEquals ? "" : str2);
                    String str3 = map.get("statUploadStrategy");
                    boolean z2 = (zEquals || "3".equals(str3) || "2".equals(str3)) ? false : true;
                    if (zEquals || "3".equals(str3)) {
                        str = "3";
                    } else {
                        final boolean z3 = z2;
                        str = "3";
                        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.acs.st.utils.k.1
                            @Override // java.lang.Runnable
                            public void run() throws Throwable {
                                MetaEntity metaEntity = metaEntityB;
                                if (metaEntity != null && k.e(metaEntity.dataType)) {
                                    f.b("Utils", "report data old dataType strategy======:" + metaEntityB);
                                }
                                k.b(context, false, z3, map, metaEntityB, eventListener);
                            }
                        });
                    }
                    if (zEquals || str.equals(str3) || "2".equals(str3)) {
                        MetaEntity metaEntityA = zEquals ? metaEntityB : a(context, str2, metaEntityB.newDatatype);
                        if (metaEntityA != null) {
                            if (e(metaEntityA.dataType)) {
                                f.b("Utils", "report data new dataType strategy======:" + metaEntityA);
                            }
                            b(context, true, false, map, metaEntityA, eventListener);
                        }
                    }
                    b(!z2, 7, eventListener);
                    return;
                }
                f.b("Utils", "report data no strategy,save data!dataType=" + str2);
                com.opos.acs.st.db.c.a(context, a(map));
                i.b(context, str2);
                i2 = 6;
                z = true;
            }
        }
        b(z, i2, eventListener);
    }

    public static void a(boolean z) {
        h.set(z);
    }

    public static boolean a(Context context, String str) {
        STConfigEntity sTConfigEntityC;
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        return TextUtils.isEmpty(str) || (sTConfigEntityC = i.c(context)) == null || (dataEntity = sTConfigEntityC.dataEntity) == null || dataEntity.strategyEntity == null || (map = dataEntity.metaEntityMap) == null || map.get(str) == null;
    }

    public static boolean a(STConfigEntity sTConfigEntity) {
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        if (sTConfigEntity == null || (dataEntity = sTConfigEntity.dataEntity) == null || (map = dataEntity.metaEntityMap) == null || map.size() <= 0) {
            return false;
        }
        try {
            Iterator<Map.Entry<String, MetaEntity>> it = sTConfigEntity.dataEntity.metaEntityMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().immFlag == 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            f.a("Utils", "", e2);
            return false;
        }
    }

    public static boolean a(String str) {
        return str == null || "".equals(str.trim());
    }

    private static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1000];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (-1 == i2) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e2) {
            f.b("Utils", "", e2);
            return null;
        }
    }
}
