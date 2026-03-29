package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.lantern.auth.server.WkParams;
import com.ss.android.ttvecamera.TELogUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class jx2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f18529a = "";
    public static final String b = bf2.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 106, 124, 100, 67, 69, 107, 38, 124, 97, 69, 83, 113, 38, 117, ByteCompanionObject.MAX_VALUE, TELogUtils.DEBUG_LEVEL_V, 86, 43, 39, 119, 97, 64, 65, 110, 105, 125, 116, TELogUtils.DEBUG_LEVEL_V, 83, 109, 105, 98, 100, 67});

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<Integer> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return num.intValue() - num2.intValue();
        }
    }

    public static long a(long j) {
        Date date = new Date();
        Date date2 = new Date(j);
        date.setHours(date2.getHours());
        date.setMinutes(date2.getMinutes());
        date.setSeconds(date2.getSeconds());
        return (date.getTime() / 1000) * 1000;
    }

    public static String b(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                int i = b2 & UByte.MAX_VALUE;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Throwable th) {
            p63.f("JWakeConfigHelper", "get md5 throwable:" + th.getMessage());
            return "";
        }
    }

    public static List<String> c(JSONObject jSONObject, String str) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(jSONArrayOptJSONArray.get(i).toString());
        }
        return arrayList;
    }

    public static kx2 d(Context context) {
        kx2 kx2VarE = null;
        try {
            String strB = mv2.b(context, "bwc.catch");
            if (strB != null) {
                kx2VarE = e(context, new JSONObject(m86.b(strB)));
            }
        } catch (Throwable th) {
            p63.f("JWakeConfigHelper", "read config json from cache failed !! error:" + th);
        }
        return kx2VarE == null ? new kx2() : kx2VarE;
    }

    public static kx2 e(Context context, JSONObject jSONObject) {
        String str;
        long j;
        int i;
        String str2 = "enable";
        String str3 = "disable";
        kx2 kx2Var = new kx2();
        if (jSONObject == null) {
            return kx2Var;
        }
        try {
            int iOptInt = jSONObject.optInt("app_wakeup_stat", -1);
            if (iOptInt < 0) {
                return kx2Var;
            }
            int iOptInt2 = jSONObject.optInt("app_wakeup_threshold", -1) * 1000;
            if (iOptInt2 > 0) {
                kx2Var.g = iOptInt2;
            }
            int iOptInt3 = jSONObject.optInt("app_get_threshold", -1) * 1000;
            if (iOptInt3 > 0) {
                kx2Var.l = iOptInt3;
            }
            int iOptInt4 = jSONObject.optInt("app_report_threshold", -1) * 1000;
            if (iOptInt4 > 0) {
                long j2 = iOptInt4;
                kx2Var.m = j2;
                kv2.I(context, "JWakeReport", j2);
            }
            int iOptInt5 = jSONObject.optInt("app_account_wakeup_threshold", -1) * 1000;
            if (iOptInt5 > 0) {
                kx2Var.q = iOptInt5;
            }
            int iOptInt6 = jSONObject.optInt("app_activity_wakeup_threshold", -1) * 1000;
            if (iOptInt6 > 0) {
                kx2Var.s = iOptInt6;
            }
            int iOptInt7 = jSONObject.optInt("app_dactivity_wakeup_threshold", -1) * 1000;
            if (iOptInt7 > 0) {
                kx2Var.r = iOptInt7;
            }
            if (iOptInt == 0 || iOptInt == 1) {
                kx2Var.c = true;
            } else if (iOptInt == 2) {
                kx2Var.c = false;
            } else {
                p63.f("JWakeConfigHelper", "parseWakeConfigJson error: " + jSONObject.optString("errmsg"));
            }
            int iOptInt8 = jSONObject.optInt("app_wakeup_disable", -1);
            if (iOptInt8 == 0) {
                kx2Var.d = true;
            } else if (iOptInt8 == 1) {
                kx2Var.d = false;
            } else if (iOptInt8 == 2) {
                kx2Var.d = true;
            }
            kx2Var.e = jSONObject.optInt("app_ignore_local", 0) == 1;
            kx2Var.j = jSONObject.optInt("app_wakeup_api_type", 0);
            kx2Var.f = jSONObject.optInt("app_wakeup_count", 5);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("app_wakeup_time");
            if (jSONArrayOptJSONArray != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String str4 = "";
                long j3 = 0;
                int i2 = 0;
                while (i2 < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    long jA = a(jSONObjectOptJSONObject.optLong("start"));
                    JSONArray jSONArray = jSONArrayOptJSONArray;
                    String str5 = str2;
                    long jA2 = a(jSONObjectOptJSONObject.optLong("end"));
                    if (jA == 0 || jA2 == 0 || jA < j3 || jCurrentTimeMillis < jA || jCurrentTimeMillis >= jA2) {
                        j = jCurrentTimeMillis;
                    } else {
                        j = jCurrentTimeMillis;
                        kx2Var.i = false;
                        int iOptInt9 = jSONObjectOptJSONObject.optInt("max_count");
                        String str6 = jA + "" + jA2;
                        int iT = kv2.t(context, str6);
                        if (iOptInt9 == 0 || iT < iOptInt9) {
                            kx2Var.h = true;
                        } else {
                            kx2Var.h = false;
                        }
                        str4 = str6;
                        int iOptInt10 = jSONObjectOptJSONObject.optInt("interval", -1) * 1000;
                        if (iOptInt10 > 0) {
                            i = iT;
                            kx2Var.g = iOptInt10;
                        } else {
                            i = iT;
                        }
                        p63.a("JWakeConfigHelper", "wakeTimeEnable:" + kx2Var.h + ",at starttime:" + jSONObjectOptJSONObject.optLong("start") + "and endtime:" + jSONObjectOptJSONObject.optLong("end") + ",wakeInterval=" + iOptInt10);
                        StringBuilder sb = new StringBuilder();
                        sb.append("wakeTimeEnable:");
                        sb.append(kx2Var.h);
                        sb.append(",current wakeCount:");
                        sb.append(i);
                        sb.append("and Max wake count:");
                        sb.append(iOptInt9);
                        p63.a("JWakeConfigHelper", sb.toString());
                        j3 = jA;
                    }
                    i2++;
                    jSONArrayOptJSONArray = jSONArray;
                    str2 = str5;
                    jCurrentTimeMillis = j;
                }
                str = str2;
                if (!nl5.i(str4)) {
                    kv2.B(context, str4);
                }
            } else {
                str = "enable";
            }
            kx2Var.v = jSONObject.optInt("app_unsupported_wakeup_type", 0);
            p63.a("JWakeConfigHelper", "wakeTimeEnable:" + kx2Var.h + ", app unsupported_wakeup_type: " + kx2Var.v);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("app_wakeup_list");
            if (jSONArrayOptJSONArray2 != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                TreeMap treeMap = new TreeMap(new a());
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i3);
                    ux2 ux2Var = new ux2();
                    ux2Var.b = jSONObjectOptJSONObject2.optString("pkg_name");
                    ux2Var.f21313a = jSONObjectOptJSONObject2.optInt("be_waked_type");
                    ux2Var.c = jSONObjectOptJSONObject2.optInt("priority", 10);
                    ux2Var.g = jSONObjectOptJSONObject2.optInt("delay_time");
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("extra_cfg");
                    if (jSONObjectOptJSONObject3 != null) {
                        ux2Var.e = jSONObjectOptJSONObject3.optString("authen_type");
                        String strOptString = jSONObjectOptJSONObject3.optString("activity_uri");
                        ux2Var.d = jSONObjectOptJSONObject3.optBoolean("force_wake", false);
                        if (!nl5.i(strOptString)) {
                            ux2Var.f = strOptString;
                        }
                    }
                    ArrayList arrayList = (ArrayList) treeMap.get(Integer.valueOf(ux2Var.c));
                    if (arrayList == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(ux2Var);
                        treeMap.put(Integer.valueOf(ux2Var.c), arrayList2);
                    } else {
                        arrayList.add(ux2Var);
                    }
                }
                Iterator it = treeMap.keySet().iterator();
                while (it.hasNext()) {
                    ArrayList<ux2> arrayList3 = (ArrayList) treeMap.get((Integer) it.next());
                    Collections.shuffle(arrayList3);
                    for (ux2 ux2Var2 : arrayList3) {
                        linkedHashMap.put(ux2Var2.b, ux2Var2);
                    }
                }
                kx2Var.k = linkedHashMap;
            }
            String str7 = str;
            kx2Var.f18847a = !"disable".equals(jSONObject.optString("app_wakeup_config", str7));
            kx2Var.b = !"disable".equals(jSONObject.optString("app_wakeuped_config", str7));
            String strOptString2 = jSONObject.optString("app_package_config", "disable");
            if (!strOptString2.isEmpty()) {
                str3 = strOptString2;
            }
            kx2Var.n = str3;
            kx2Var.o = c(jSONObject, "app_package_list");
            kx2Var.p = c(jSONObject, "app_blacklist");
            kx2Var.t = jSONObject.optInt("app_wakeup_report_enable", 0) == 1;
            kx2Var.u = jSONObject.optInt("app_bewakeup_report_enable", 0) == 1;
        } catch (JSONException e) {
            p63.f("JWakeConfigHelper", "parseWakeConfig exception:" + e.toString());
        }
        return kx2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03b8 A[PHI: r1 r5
      0x03b8: PHI (r1v15 ??) = (r1v10 ??), (r1v11 ??), (r1v12 ??), (r1v16 ??) binds: [B:116:0x0304, B:127:0x0340, B:138:0x037b, B:149:0x03b6] A[DONT_GENERATE, DONT_INLINE]
      0x03b8: PHI (r5v17 ??) = (r5v9 ??), (r5v12 ??), (r5v15 ??), (r5v20 ??) binds: [B:116:0x0304, B:127:0x0340, B:138:0x037b, B:149:0x03b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0324 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x035f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v55 */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v58 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v61 */
    /* JADX WARN: Type inference failed for: r5v62 */
    /* JADX WARN: Type inference failed for: r5v63 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject f(Context context) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        JSONException jSONException;
        HttpURLConnection httpURLConnection2;
        IOException iOException;
        HttpURLConnection httpURLConnection3;
        UnsupportedEncodingException unsupportedEncodingException;
        HttpURLConnection httpURLConnection4;
        InputStream inputStream;
        String str;
        ?? r1 = context;
        ?? r5 = 0;
        InputStream inputStream2 = null;
        InputStream inputStream3 = null;
        InputStream inputStream4 = null;
        InputStream inputStream5 = null;
        try {
            try {
                try {
                    if (!rv2.z(context)) {
                        p63.f("JWakeConfigHelper", "request wakeConfig failed because is not validRegistered");
                        return null;
                    }
                    String strE = rv2.e(context);
                    if (TextUtils.isEmpty(strE)) {
                        p63.f("JWakeConfigHelper", "request wakeConfig failed because can't get appKey");
                        return null;
                    }
                    long jU = rv2.u(context);
                    if (jU == 0) {
                        p63.f("JWakeConfigHelper", "request wakeConfig failed because can't get uid");
                        return null;
                    }
                    String strM = rv2.m(context);
                    if (TextUtils.isEmpty(strM)) {
                        p63.f("JWakeConfigHelper", "request wakeConfig failed because need register first");
                        return null;
                    }
                    kv2.E(r1, "JWakeConfigHelper");
                    String str2 = b;
                    if (lv2.f19083a && !TextUtils.isEmpty(f18529a)) {
                        str2 = f18529a;
                    }
                    kx2 kx2VarD = d(context);
                    HashMap map = new HashMap();
                    String str3 = lv2.b;
                    String str4 = Build.MODEL;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appkey", strE);
                    jSONObject.put(DeviceInfoUtil.UID_TAG, jU);
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("manufacturer", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject.put(WkParams.MODEL, str4);
                    }
                    jSONObject.put("version", 1);
                    jSONObject.put("apitype", kx2VarD.j);
                    if (kx2VarD.j == 0) {
                        HashMap<String, rx2> mapM = mx2.m(r1, null);
                        JSONArray jSONArray = new JSONArray();
                        if (mapM != null) {
                            Set<String> setKeySet = mapM.keySet();
                            if (mapM.size() > 10) {
                                ArrayList arrayList = new ArrayList(setKeySet);
                                Collections.shuffle(arrayList);
                                setKeySet = new HashSet<>(arrayList);
                            }
                            Iterator<String> it = setKeySet.iterator();
                            int i = 0;
                            for (int i2 = 10; it.hasNext() && i < i2; i2 = 10) {
                                jSONArray.put(it.next());
                                i++;
                            }
                        }
                        jSONObject.put("pkglist", jSONArray);
                    }
                    p63.a("JWakeConfigHelper", "url:" + str2 + ", param json:" + jSONObject.toString());
                    map.put("Content-Type", HTTP.PLAIN_TEXT_TYPE);
                    map.put(HttpHeaders.ACCEPT, "application/json");
                    map.put("X-Http-Platform", "android");
                    map.put("X-Http-Appkey", strE);
                    String strB = b(jSONObject.toString().getBytes("UTF-8"));
                    String strL = rv2.l(jU + rv2.l(strM) + strB);
                    if (TextUtils.isEmpty(strL)) {
                        return null;
                    }
                    String strEncodeToString = Base64.encodeToString((jU + ":" + strL).getBytes(), 10);
                    if (TextUtils.isEmpty(strEncodeToString)) {
                        return null;
                    }
                    map.put(HttpHeaders.AUTHORIZATION, "Basic " + strEncodeToString);
                    map.put("Charset", "UTF-8");
                    HttpURLConnection httpURLConnectionA = sj2.a(r1, str2);
                    try {
                        httpURLConnectionA.setConnectTimeout(30000);
                        httpURLConnectionA.setReadTimeout(30000);
                        httpURLConnectionA.setRequestMethod("POST");
                        for (Map.Entry entry : map.entrySet()) {
                            httpURLConnectionA.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        OutputStream outputStream = httpURLConnectionA.getOutputStream();
                        outputStream.write(jSONObject.toString().getBytes("UTF-8"));
                        outputStream.flush();
                        if (httpURLConnectionA.getResponseCode() == 200) {
                            inputStream = httpURLConnectionA.getInputStream();
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i3 = inputStream.read(bArr);
                                    if (i3 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i3);
                                }
                                str = new String(byteArrayOutputStream.toByteArray());
                            } catch (UnsupportedEncodingException e) {
                                unsupportedEncodingException = e;
                                inputStream2 = inputStream;
                                r1 = httpURLConnectionA;
                            } catch (IOException e2) {
                                iOException = e2;
                                inputStream3 = inputStream;
                                r1 = httpURLConnectionA;
                                p63.f("JWakeConfigHelper", "request wakeConfig exception:" + iOException.getMessage());
                                r5 = inputStream3;
                                if (inputStream3 != null) {
                                }
                                if (r1 != 0) {
                                }
                                return null;
                            } catch (JSONException e3) {
                                jSONException = e3;
                                inputStream4 = inputStream;
                                r1 = httpURLConnectionA;
                                p63.f("JWakeConfigHelper", "request wakeConfig exception:" + jSONException.getMessage());
                                r5 = inputStream4;
                                if (inputStream4 != null) {
                                }
                                if (r1 != 0) {
                                }
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream5 = inputStream;
                                r1 = httpURLConnectionA;
                                p63.f("JWakeConfigHelper", "request wakeConfig exception:" + th.getMessage());
                                r5 = inputStream5;
                                if (inputStream5 != null) {
                                }
                                if (r1 != 0) {
                                }
                                return null;
                            }
                        } else {
                            inputStream = null;
                            str = null;
                        }
                        p63.a("JWakeConfigHelper", "responseBody:" + str);
                        if (TextUtils.isEmpty(str)) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e4) {
                                    p63.f("JWakeConfigHelper", "request wakeConfig exception:" + e4.getMessage());
                                }
                            }
                            httpURLConnectionA.disconnect();
                            return null;
                        }
                        p63.a("JWakeConfigHelper", "request wakeConfig success,response body:" + str);
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e5) {
                                p63.f("JWakeConfigHelper", "request wakeConfig exception:" + e5.getMessage());
                            }
                        }
                        httpURLConnectionA.disconnect();
                        return jSONObject2;
                    } catch (UnsupportedEncodingException e6) {
                        unsupportedEncodingException = e6;
                        httpURLConnection4 = httpURLConnectionA;
                        inputStream2 = null;
                        r1 = httpURLConnection4;
                    } catch (IOException e7) {
                        iOException = e7;
                        httpURLConnection3 = httpURLConnectionA;
                        inputStream3 = null;
                        r1 = httpURLConnection3;
                        p63.f("JWakeConfigHelper", "request wakeConfig exception:" + iOException.getMessage());
                        r5 = inputStream3;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                                r5 = inputStream3;
                            } catch (Exception e8) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("request wakeConfig exception:");
                                sb.append(e8.getMessage());
                                p63.f("JWakeConfigHelper", sb.toString());
                                r5 = sb;
                            }
                        }
                        if (r1 != 0) {
                        }
                        return null;
                    } catch (JSONException e9) {
                        jSONException = e9;
                        httpURLConnection2 = httpURLConnectionA;
                        inputStream4 = null;
                        r1 = httpURLConnection2;
                        p63.f("JWakeConfigHelper", "request wakeConfig exception:" + jSONException.getMessage());
                        r5 = inputStream4;
                        if (inputStream4 != null) {
                            try {
                                inputStream4.close();
                                r5 = inputStream4;
                            } catch (Exception e10) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("request wakeConfig exception:");
                                sb2.append(e10.getMessage());
                                p63.f("JWakeConfigHelper", sb2.toString());
                                r5 = sb2;
                            }
                        }
                        if (r1 != 0) {
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnectionA;
                        inputStream5 = null;
                        r1 = httpURLConnection;
                        p63.f("JWakeConfigHelper", "request wakeConfig exception:" + th.getMessage());
                        r5 = inputStream5;
                        if (inputStream5 != null) {
                            try {
                                inputStream5.close();
                                r5 = inputStream5;
                            } catch (Exception e11) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("request wakeConfig exception:");
                                sb3.append(e11.getMessage());
                                p63.f("JWakeConfigHelper", sb3.toString());
                                r5 = sb3;
                            }
                        }
                        if (r1 != 0) {
                        }
                        return null;
                    }
                } catch (UnsupportedEncodingException e12) {
                    unsupportedEncodingException = e12;
                    r1 = 0;
                } catch (IOException e13) {
                    iOException = e13;
                    r1 = 0;
                } catch (JSONException e14) {
                    jSONException = e14;
                    r1 = 0;
                } catch (Throwable th4) {
                    th = th4;
                    r1 = 0;
                }
            } finally {
            }
        } catch (UnsupportedEncodingException e15) {
            unsupportedEncodingException = e15;
            httpURLConnection4 = null;
        } catch (IOException e16) {
            iOException = e16;
            httpURLConnection3 = null;
        } catch (JSONException e17) {
            jSONException = e17;
            httpURLConnection2 = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
        }
        inputStream2 = null;
        r1 = httpURLConnection4;
        p63.f("JWakeConfigHelper", "request wakeConfig exception:" + unsupportedEncodingException.getMessage());
        r5 = inputStream2;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
                r5 = inputStream2;
            } catch (Exception e18) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("request wakeConfig exception:");
                sb4.append(e18.getMessage());
                p63.f("JWakeConfigHelper", sb4.toString());
                r5 = sb4;
            }
        }
        if (r1 != 0) {
            r1.disconnect();
        }
        return null;
    }

    public static void g(Context context, String str) {
        if (str != null) {
            p63.a("JWakeConfigHelper", "write wakeConfigJson:" + str);
            mv2.d(context, "bwc.catch", str);
        }
    }
}
