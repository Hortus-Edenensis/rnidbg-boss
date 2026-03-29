package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.efs.sdk.base.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class rv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5062a;
    private static volatile boolean iz;
    private static volatile int n;
    public static JSONObject u;
    private static final String[] b = {"GET", "POST"};
    private static final String[] pn = {"aid", "app_version", "tt_data"};
    static final String[] nr = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] fx = {"tt_data", "device_platform"};
    private static Object x = new Object();

    public static JSONObject fx(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String strU = u(1, str, null, tr.u(jSONObject.toString()));
        if (strU != null) {
            try {
                jSONObject2 = new JSONObject(strU);
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && "success".equals(jSONObject2.optString("message", ""))) {
            return jSONObject2.optJSONObject("data");
        }
        return null;
    }

    private static void nr(Context context) {
        if (f5062a || context == null) {
            return;
        }
        synchronized (x) {
            try {
                SharedPreferences.Editor editorEdit = gb.nr(context).edit();
                if (n > 2) {
                    n -= 2;
                } else {
                    n = 0;
                }
                editorEdit.putInt("app_log_encrypt_faild_count", n);
                editorEdit.apply();
                f5062a = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean u(int i) {
        return i >= 500 && i < 600;
    }

    private static String u(String str) {
        if (TextUtils.isEmpty(str) || !u.n()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : pn) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (Pair pair : arrayList) {
            builderBuildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(tr.u(query), 8)));
        return builderBuildUpon.build().toString();
    }

    public static JSONObject nr(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap map = new HashMap(2);
        if (u.n()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        String strU = u(1, str, map, tr.u(jSONObject.toString()));
        if (strU != null) {
            try {
                jSONObject2 = new JSONObject(strU);
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
            return jSONObject2.optJSONObject(com.igexin.push.core.b.Y);
        }
        return null;
    }

    public static String u(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        HashMap map = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                map.put(str2, queryParameter);
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str3 : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str3, (String) map.get(str3));
        }
        return builderBuildUpon.build().toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:35|(1:37)(1:38)|(2:110|39)|(10:40|(1:42)(1:122)|71|108|74|(2:102|76)|(2:106|64)|81|(1:83)|84)|43|104|44|(1:46)) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0116, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x016d A[EXC_TOP_SPLITTER, PHI: r0 r10
      0x016d: PHI (r0v3 java.io.BufferedReader) = (r0v2 java.io.BufferedReader), (r0v10 java.io.BufferedReader) binds: [B:79:0x01a4, B:63:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x016d: PHI (r10v3 java.lang.String) = (r10v2 java.lang.String), (r10v12 java.lang.String) binds: [B:79:0x01a4, B:63:0x016b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(int i, String str, HashMap<String, String> map, byte[] bArr) {
        DataOutputStream dataOutputStream;
        String string;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream2;
        Throwable th;
        int responseCode;
        StringBuilder sb;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i == 0) {
                httpURLConnection.setDoOutput(false);
            } else if (i == 1) {
                httpURLConnection.setDoOutput(true);
            } else {
                ti.nr((Throwable) null);
            }
            httpURLConnection.setRequestMethod(b[i]);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    } else {
                        ti.nr((Throwable) null);
                    }
                }
            }
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream2 = null;
            } else {
                dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                    string = null;
                    bufferedReader = null;
                }
            }
            responseCode = httpURLConnection.getResponseCode();
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            string = null;
            bufferedReader = null;
        }
        if (responseCode == 200) {
            if (httpURLConnection.getContentLength() < 10240) {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)));
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                }
                try {
                    sb = new StringBuilder(inputStream.available());
                } catch (Throwable th4) {
                    th = th4;
                    string = null;
                }
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                    Throwable th5 = th;
                    dataOutputStream = dataOutputStream2;
                    th = th5;
                    try {
                        bg.fx("__kite", "error:" + th.getMessage());
                        ti.nr(th);
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (ti.nr) {
                            ti.u("http response: ".concat(String.valueOf(string)), null);
                        }
                        return string;
                    } finally {
                    }
                }
                string = sb.toString();
                JSONObject jSONObject = new JSONObject(string);
                jSONObject.put("http_code", 200);
                string = jSONObject.toString();
                if (bg.nr()) {
                    bg.u("__kite", "response:" + string + " X-Tt-Logid:" + httpURLConnection.getHeaderField("X-Tt-Logid"));
                }
            } else {
                ti.nr((Throwable) null);
                string = null;
                bufferedReader = null;
            }
        } else {
            if (bg.nr()) {
                bg.u("__kite", "error code:" + responseCode + " id:" + httpURLConnection.getHeaderField("X-Tt-Logid"));
            }
            String string2 = new JSONObject().put("http_code", responseCode).toString();
            try {
                new RuntimeException("HttpCode:".concat(String.valueOf(responseCode)));
                string = string2;
                bufferedReader = null;
            } catch (Throwable th6) {
                bufferedReader = null;
                dataOutputStream = dataOutputStream2;
                th = th6;
                string = string2;
                bg.fx("__kite", "error:" + th.getMessage());
                ti.nr(th);
                if (dataOutputStream != null) {
                }
                if (bufferedReader != null) {
                }
            }
        }
        if (dataOutputStream2 != null) {
            try {
                dataOutputStream2.close();
            } catch (IOException unused3) {
            }
        }
        if (bufferedReader != null) {
        }
        if (ti.nr) {
        }
        return string;
    }

    public static JSONObject u(String str, JSONObject jSONObject) {
        HashMap map = new HashMap(2);
        if (u.n()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        String strU = u(1, u(str), map, tr.u(jSONObject.toString()));
        if (strU != null) {
            try {
                return new JSONObject(strU);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static String u(Context context, String str, byte[] bArr, String str2, boolean z, boolean z2) {
        byte[] bArrU;
        try {
            try {
                HashMap map = new HashMap();
                if (z) {
                    try {
                        bArrU = u(bArr);
                        map.put("Content-Encoding", Constants.CP_GZIP);
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    bArrU = u(context, bArr);
                    map.put("log-encode-type", Constants.CP_GZIP);
                    str = str + "&tt_data=a";
                    if (z2) {
                        str = str + "&config_retry=b";
                    }
                    map.remove("Content-Encoding");
                    map.put("Content-Type", "application/octet-stream;tt-data=a");
                }
                if (!TextUtils.isEmpty(str2)) {
                    map.put("Content-Type", str2);
                }
                return u(1, str, map, bArrU);
            } catch (Exception e) {
                bg.fx("__kite", e.getMessage());
                return "";
            }
        } catch (RuntimeException e2) {
            bg.fx("__kite", e2.getMessage());
            return "";
        }
    }

    public static byte[] u(byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] u(Context context, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (context != null) {
                u(context);
                if (n >= 3) {
                    return null;
                }
                byte[] bArrA = TTEncryptUtils.a(byteArray, byteArray.length);
                nr(context);
                return bArrA;
            }
            return TTEncryptUtils.a(byteArray, byteArray.length);
        } catch (Throwable th) {
            try {
                bg.fx("__kite", "gzip ".concat(String.valueOf(th)));
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    private static void u(Context context) {
        if (iz || context == null) {
            return;
        }
        synchronized (x) {
            try {
                SharedPreferences sharedPreferencesNr = gb.nr(context);
                n = sharedPreferencesNr.getInt("app_log_encrypt_faild_count", 0);
                SharedPreferences.Editor editorEdit = sharedPreferencesNr.edit();
                editorEdit.putInt("app_log_encrypt_faild_count", n + 1);
                editorEdit.apply();
                iz = true;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int u(String[] strArr, byte[] bArr, mh mhVar) {
        JSONObject jSONObject;
        int iOptInt;
        HashMap map = new HashMap(2);
        if (u.n()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        String strU = null;
        for (String str : strArr) {
            strU = u(1, str, map, bArr);
            if (!TextUtils.isEmpty(strU)) {
                break;
            }
        }
        try {
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        if (TextUtils.isEmpty(strU)) {
            jSONObject = null;
            iOptInt = 0;
            if (iOptInt == 200) {
            }
            return iOptInt;
        }
        jSONObject = new JSONObject(strU);
        try {
            iOptInt = jSONObject.optInt("http_code");
            if (iOptInt == 200) {
                if ("ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                    iOptInt = "success".equals(jSONObject.optString("message")) ? 200 : Integer.valueOf("101").intValue();
                } else {
                    iOptInt = Integer.valueOf("102").intValue();
                }
            }
        } catch (JSONException e2) {
            e = e2;
            ti.nr(e);
            iOptInt = 0;
        }
        if (iOptInt == 200) {
            try {
                long jOptLong = jSONObject.optLong("server_time");
                if (jOptLong > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("server_time", jOptLong);
                    jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                    u = jSONObject2;
                }
            } catch (Exception e3) {
                ti.nr(e3);
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("blacklist");
            if (jSONObjectOptJSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("v1");
                int length = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0;
                HashSet hashSet = new HashSet(length);
                for (int i = 0; i < length; i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i, null);
                    if (!TextUtils.isEmpty(strOptString)) {
                        hashSet.add(strOptString);
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("v3");
                int length2 = jSONArrayOptJSONArray2 != null ? jSONArrayOptJSONArray2.length() : 0;
                HashSet hashSet2 = new HashSet(length2);
                for (int i2 = 0; i2 < length2; i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2, null);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        hashSet2.add(strOptString2);
                    }
                }
            }
        }
        return iOptInt;
        ti.nr(e);
        iOptInt = 0;
        if (iOptInt == 200) {
        }
        return iOptInt;
    }
}
