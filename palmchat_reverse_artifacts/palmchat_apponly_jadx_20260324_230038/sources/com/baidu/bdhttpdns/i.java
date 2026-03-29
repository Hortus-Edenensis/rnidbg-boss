package com.baidu.bdhttpdns;

import com.efs.sdk.base.Constants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile i f3359a = null;
    private static boolean b = true;
    private static c g;
    private String d;
    private String f;
    private int q;
    private int r;
    private String c = "180.76.76.200";
    private String e = "[240c:4006::6666]";
    private boolean h = true;
    private long i = 0;
    private final Object l = new Object();
    private ArrayList<String> m = new ArrayList<>();
    private String n = "";
    private String o = "";
    private boolean p = false;
    private int s = 10;
    private final Object k = new Object();
    private final HashSet<String> j = new HashSet<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, d dVar, Map<String, e> map, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        private String c;
        private d d;
        private a e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3360a = false;
        private boolean f = false;

        public b(String str, d dVar, a aVar) {
            this.c = str;
            this.d = dVar;
            this.e = aVar;
        }

        private String a(String str, int i) {
            if (str == null || i >= 3) {
                return null;
            }
            this.f = true;
            l.a("Using IDCServerIP(%s)", str);
            return str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            if (this.f3360a) {
                l.a("Retry for %s(%s).", this.d.toString(), this.c);
                a();
            }
            synchronized (i.this.k) {
                if (!this.d.equals(d.TAG_OF_HOSTS)) {
                    for (String str : this.c.split(",")) {
                        i.this.j.remove(str);
                    }
                }
            }
            synchronized (i.this.l) {
                if (this.d.equals(d.DNLIST_HOSTS)) {
                    for (String str2 : this.c.split(",")) {
                        i.this.m.remove(str2);
                    }
                }
            }
        }

        private String a(String str, d dVar) {
            String strA;
            String str2;
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + 300 + i.this.i;
            String strA2 = i.this.a(str, jCurrentTimeMillis);
            if (strA2 == null) {
                return null;
            }
            if (BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                strA = a(i.this.d, i.this.q);
                if (strA == null) {
                    strA = i.this.c;
                    this.f = false;
                    l.a("Using BGPServerIp(%s)", i.this.c);
                }
                str2 = BDNetworkStateChangeReceiver.isIPv6Reachable() ? "dual_stack" : "ipv4";
            } else {
                if (!BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                    return null;
                }
                strA = a(i.this.f, i.this.r);
                if (strA == null) {
                    strA = i.this.e;
                    this.f = false;
                    l.a("Using BGPServerIp(%s)", i.this.e);
                }
                str2 = "ipv6";
            }
            String str3 = dVar.equals(d.TAG_OF_HOSTS) ? String.format("%s/v4/resolve?account_id=%s&tag=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true&type=%s", strA, i.this.n, str, strA2, Long.valueOf(jCurrentTimeMillis), "1.3", "android", str2) : String.format("%s/v4/resolve?account_id=%s&dn=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true&type=%s", strA, i.this.n, str, strA2, Long.valueOf(jCurrentTimeMillis), "1.3", "android", str2);
            return i.this.h ? String.format("https://%s", str3) : String.format("http://%s", str3);
        }

        private void a() {
            String strA = a(this.c, this.d);
            l.a("Request url is :%s", strA);
            if (strA != null) {
                a(strA);
            } else {
                this.e.a(-1, this.d, null, this.c);
                l.a("Httpdns request failed for  %s(%s), get url error", this.d.toString(), this.c);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x018e A[PHI: r1 r7
          0x018e: PHI (r1v8 java.net.HttpURLConnection) = (r1v23 java.net.HttpURLConnection), (r1v24 java.net.HttpURLConnection), (r1v25 java.net.HttpURLConnection) binds: [B:57:0x018c, B:63:0x01c3, B:67:0x01f3] A[DONT_GENERATE, DONT_INLINE]
          0x018e: PHI (r7v7 java.lang.Boolean) = (r7v4 java.lang.Boolean), (r7v5 java.lang.Boolean), (r7v8 java.lang.Boolean) binds: [B:57:0x018c, B:63:0x01c3, B:67:0x01f3] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r7v26, types: [com.baidu.bdhttpdns.i] */
        /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(String str) {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            HttpURLConnection httpURLConnection3;
            Boolean bool;
            HttpURLConnection httpURLConnection4;
            HttpURLConnection httpURLConnection5;
            int responseCode;
            InputStream errorStream;
            a aVar;
            d dVar;
            String str2;
            ?? r1;
            ?? r12;
            Map<String, e> map = new HashMap<>();
            ?? r13 = Boolean.TRUE;
            try {
                try {
                    URL url = new URL(str);
                    if (i.this.h) {
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                        httpsURLConnection.setRequestProperty("Host", "httpdns.baidubce.com");
                        httpsURLConnection.setHostnameVerifier(i.g);
                        httpURLConnection5 = httpsURLConnection;
                    } else {
                        httpURLConnection5 = (HttpURLConnection) url.openConnection();
                    }
                    try {
                        httpURLConnection5.setRequestMethod("GET");
                        httpURLConnection5.setReadTimeout(30000);
                        httpURLConnection5.setConnectTimeout(30000);
                        httpURLConnection5.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                        httpURLConnection5.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
                        httpURLConnection5.connect();
                        responseCode = httpURLConnection5.getResponseCode();
                        errorStream = responseCode >= 400 ? httpURLConnection5.getErrorStream() : httpURLConnection5.getInputStream();
                    } catch (IOException e) {
                        httpURLConnection3 = httpURLConnection5;
                        e = e;
                        e.printStackTrace();
                        bool = Boolean.FALSE;
                        i.this.a(Boolean.valueOf(this.f));
                        l.a("Httpdns request failed for %s(%s), caught network IOException", this.d.toString(), this.c);
                        this.e.a(-1, this.d, null, this.c);
                        httpURLConnection4 = httpURLConnection3;
                        r13 = httpURLConnection3;
                        if (httpURLConnection3 != null) {
                            httpURLConnection4.disconnect();
                            r13 = httpURLConnection4;
                        }
                    } catch (ArrayIndexOutOfBoundsException e2) {
                        httpURLConnection2 = httpURLConnection5;
                        e = e2;
                        e.printStackTrace();
                        bool = Boolean.FALSE;
                        i.this.a(Boolean.valueOf(this.f));
                        l.a("Httpdns request failed for %s(%s), caught ArrayIndexOutOfBoundsException", this.d.toString(), this.c);
                        this.e.a(-1, this.d, null, this.c);
                        r13 = httpURLConnection2;
                        if (httpURLConnection2 != null) {
                            httpURLConnection4 = httpURLConnection2;
                            httpURLConnection4.disconnect();
                            r13 = httpURLConnection4;
                        }
                    } catch (Throwable th) {
                        httpURLConnection = httpURLConnection5;
                        th = th;
                        th.printStackTrace();
                        bool = Boolean.FALSE;
                        i.this.a(Boolean.valueOf(this.f));
                        l.a("Httpdns request failed for %s(%s), caught Exception", this.d.toString(), this.c);
                        this.e.a(-1, this.d, null, this.c);
                        httpURLConnection4 = httpURLConnection;
                        r13 = httpURLConnection;
                        if (httpURLConnection != null) {
                        }
                    }
                } catch (Throwable th2) {
                    if (r13 != 0) {
                        r13.disconnect();
                    }
                    if (bool.booleanValue() && this.f) {
                        if (BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                            i.this.q = 0;
                        } else if (BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                            i.this.r = 0;
                        }
                    }
                    throw th2;
                }
            } catch (IOException e3) {
                e = e3;
                httpURLConnection3 = null;
            } catch (ArrayIndexOutOfBoundsException e4) {
                e = e4;
                httpURLConnection2 = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
            if (errorStream != null) {
                String strA = i.this.a(errorStream, httpURLConnection5);
                l.a("Response data is : %s", strA);
                if (strA == null) {
                    Boolean bool2 = Boolean.FALSE;
                    i.this.a(Boolean.valueOf(this.f));
                    l.a("Httpdns request failed for %s(%s), get empty response data", this.d.toString(), this.c);
                    this.e.a(-1, this.d, null, this.c);
                    httpURLConnection5.disconnect();
                    return;
                }
                Map mapA = i.this.a(strA, this.c, this.d);
                if (mapA.get("isSignExpired").equals(r13)) {
                    this.f3360a = true;
                    httpURLConnection5.disconnect();
                    if (this.f) {
                        if (BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                            i.this.q = 0;
                            return;
                        } else {
                            if (BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                                i.this.r = 0;
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (mapA.get("isMsgOK").equals(r13) && responseCode == 200) {
                    map = i.this.a(strA, this.c);
                    r12 = r13;
                    httpURLConnection5.disconnect();
                    if (r12.booleanValue() && this.f) {
                        if (!BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                            i.this.q = 0;
                        } else if (BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                            i.this.r = 0;
                        }
                    }
                    if (map != null || map.isEmpty()) {
                        this.e.a(-1, this.d, null, this.c);
                    } else {
                        this.e.a(0, this.d, map, this.c);
                        return;
                    }
                }
                aVar = this.e;
                dVar = this.d;
                str2 = this.c;
                r1 = r13;
            } else {
                Boolean bool3 = Boolean.FALSE;
                i.this.a(Boolean.valueOf(this.f));
                l.a("Httpdns request failed for %s(%s), get null response stream", this.d.toString(), this.c);
                aVar = this.e;
                dVar = this.d;
                str2 = this.c;
                r1 = bool3;
            }
            aVar.a(-1, dVar, null, str2);
            r12 = r1;
            httpURLConnection5.disconnect();
            if (r12.booleanValue()) {
                if (!BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                }
            }
            if (map != null) {
            }
            this.e.a(-1, this.d, null, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements HostnameVerifier {
        private c() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpdns.baidubce.com", sSLSession);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum d {
        DNLIST_HOSTS,
        TAG_OF_HOSTS
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e {
        private final ArrayList<String> b;
        private final ArrayList<String> c;
        private final long d;

        public e(ArrayList<String> arrayList, ArrayList<String> arrayList2, long j) {
            this.b = arrayList;
            this.c = arrayList2;
            this.d = j;
        }

        public ArrayList<String> a() {
            return this.b;
        }

        public ArrayList<String> b() {
            return this.c;
        }

        public long c() {
            return this.d;
        }
    }

    private i() {
        g = new c();
    }

    public int d() {
        return this.s;
    }

    private long a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        long j;
        if (jSONObject != null) {
            try {
                j = jSONObject.getLong(RemoteMessageConst.TTL);
            } catch (JSONException e2) {
                e2.printStackTrace();
                l.a("Httpdns request failed, host(%s), response has no ttl, will use defaults ttl(60s)", str);
                return -1L;
            }
        } else {
            j = -1;
        }
        long j2 = jSONObject2 != null ? jSONObject2.getLong(RemoteMessageConst.TTL) : -1L;
        if (j > 0 && j2 > 0) {
            return j < j2 ? j : j2;
        }
        if (j > 0) {
            return j;
        }
        if (j2 > 0) {
            return j2;
        }
        return -1L;
    }

    private String b(String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString("msg");
        } catch (JSONException e2) {
            e2.printStackTrace();
            l.a("Httpdns request failed, host(%s), response has no msg in %s ", str2, str);
            return null;
        }
    }

    public ArrayList c() {
        return this.m;
    }

    public String e() {
        return !b ? this.o : com.baidu.bdhttpdns.e.g(this.o);
    }

    public boolean f() {
        return this.p;
    }

    public static i a() {
        if (f3359a == null) {
            synchronized (i.class) {
                if (f3359a == null) {
                    f3359a = new i();
                }
            }
        }
        return f3359a;
    }

    public void c(String str) {
        this.n = str;
    }

    public void d(String str) {
        String strF = com.baidu.bdhttpdns.e.f(str);
        this.o = strF;
        if (strF == null) {
            this.o = str;
            b = false;
        }
    }

    public void b() {
        this.q = 0;
        this.r = 0;
        this.d = null;
        this.f = null;
    }

    public void b(boolean z) {
        this.p = z;
    }

    public static boolean b(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(InputStream inputStream, HttpURLConnection httpURLConnection) {
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (contentEncoding != null) {
            try {
                if (contentEncoding.contains(Constants.CP_GZIP)) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int contentLength = httpURLConnection.getContentLength();
                    if (contentLength <= 0) {
                        contentLength = 1024;
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (-1 == i) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } else {
                        byte[] bArr2 = new byte[contentLength];
                        inputStream.read(bArr2);
                        byteArrayOutputStream.write(bArr2, 0, contentLength);
                    }
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return a(byteArrayOutputStream.toByteArray(), contentLength);
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(line);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, long j) {
        return com.baidu.bdhttpdns.e.e(String.format("%s-%s-%d", str, e(), Long.valueOf(j)));
    }

    private String a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
            do {
                int i2 = gZIPInputStream.read(bArr2, 0, i);
                byteArrayOutputStream.write(bArr2, 0, i2);
                if (i2 == -1) {
                    break;
                }
            } while (!b(byteArrayOutputStream.toString()));
            gZIPInputStream.close();
            return byteArrayOutputStream.toString();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private ArrayList<String> a(String str, String str2, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ip");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            l.a("Httpdns request warning, host(%s), response has no ip field in %s", str2, str);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            String strOptString = jSONArrayOptJSONArray.optString(i);
            if (strOptString == null || strOptString.isEmpty()) {
                l.a("Httpdns request warning, host(%s), response of data get ip error in %s", str2, str);
            } else if (com.baidu.bdhttpdns.e.a(strOptString) || com.baidu.bdhttpdns.e.b(strOptString)) {
                arrayList.add(strOptString);
            } else {
                l.a("Httpdns request warning, host(%s), response of data get invalid ip(%s) in %s", str2, strOptString, str);
            }
        }
        return arrayList;
    }

    public Map a(String str, String str2) {
        ArrayList<String> arrayListA;
        ArrayList<String> arrayListA2;
        HashMap map = new HashMap();
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("serverip")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("serverip");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ipv4");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    this.d = jSONArrayOptJSONArray.optString(0);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("ipv6");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    this.f = "[" + jSONArrayOptJSONArray2.optString(0) + "]";
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject2 == null) {
                l.a("Httpdns request failed, hostsOrTag(%s), response has empty data", str2);
                return null;
            }
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next);
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("ipv4");
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject3.optJSONObject("ipv6");
                long jA = a(next, jSONObjectOptJSONObject4, jSONObjectOptJSONObject5);
                if (jA < 0) {
                    map.put(next, z);
                } else {
                    String strB = b("ipv4Obj", next, jSONObjectOptJSONObject4);
                    String strB2 = b("ipv6Obj", next, jSONObjectOptJSONObject5);
                    if (strB == null || strB.isEmpty()) {
                        l.a("Host(%s) ipv4Msg(%s), will deprecated the ipv4List result", next, strB);
                        arrayListA = null;
                    } else {
                        arrayListA = a("ipv4Obj", next, jSONObjectOptJSONObject4);
                    }
                    if (strB2 == null || strB2.isEmpty()) {
                        l.a("Host(%s) ipv6Msg(%s), will deprecated the ipv6List result", next, strB2);
                        arrayListA2 = null;
                    } else {
                        arrayListA2 = a("ipv6Obj", next, jSONObjectOptJSONObject5);
                    }
                    if ((arrayListA == null || arrayListA.isEmpty()) && (arrayListA2 == null || arrayListA2.isEmpty())) {
                        l.a("Httpdns request failed, host(%s), response has no valid ip", next);
                        map.put(next, null);
                    } else {
                        map.put(next, new e(arrayListA, arrayListA2, jA));
                    }
                    z = false;
                }
            }
            return map;
        } catch (JSONException e2) {
            e2.printStackTrace();
            l.a("Httpdns request failed, hostsOrTag(%s), response parse data json error", str2);
            return null;
        }
    }

    public Map a(String str, String str2, d dVar) {
        HashMap map = new HashMap();
        Boolean bool = Boolean.FALSE;
        map.put("isMsgOK", bool);
        map.put("isSignExpired", bool);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("msg");
            if (strOptString == null || strOptString.isEmpty()) {
                l.a("Httpdns request failed for %s(%s), response lack of msg", dVar.toString(), str2);
                return map;
            }
            if (!"SignatureExpired".equals(strOptString)) {
                if (com.igexin.push.core.b.B.equals(strOptString)) {
                    map.put("isMsgOK", Boolean.TRUE);
                    return map;
                }
                l.a("Httpdns request failed for %s(%s), response msg(%s) is not ok", dVar.toString(), str2, strOptString);
                return map;
            }
            int iOptInt = jSONObject.optInt("timestamp");
            if (iOptInt == 0) {
                l.a("Httpdns request failed for %s(%s), response get invalid timestamp", dVar.toString(), str2);
            } else {
                this.i = ((long) iOptInt) - (System.currentTimeMillis() / 1000);
                map.put("isSignExpired", Boolean.TRUE);
            }
            return map;
        } catch (JSONException e2) {
            e2.printStackTrace();
            l.a("Httpdns request failed for %s(%s), response parse json error", dVar.toString(), str2);
            return map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Boolean bool) {
        if (bool.booleanValue()) {
            if (BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                int i = this.q + 1;
                this.q = i;
                l.a("requestV4IDCFailNum: %s", Integer.valueOf(i));
            } else if (BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                int i2 = this.r + 1;
                this.r = i2;
                l.a("requestV6IDCFailNum: %s", Integer.valueOf(i2));
            }
        }
    }

    public void a(String str) {
        synchronized (this.l) {
            if (!this.m.contains(str)) {
                this.m.add(str);
            }
        }
    }

    public void a(String str, d dVar, a aVar) {
        if (str == null || str.isEmpty()) {
            return;
        }
        synchronized (this.k) {
            if (dVar.equals(d.DNLIST_HOSTS)) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(str.split(",")));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (this.j.contains(str2)) {
                        l.a("Httpdns request request for host(%s) is in processing，will exclude it.", str2);
                        it.remove();
                    } else {
                        this.j.add(str2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append((String) arrayList.get(i));
                    sb.append(",");
                }
                str = sb.toString().replaceAll("^,*|,*$", "");
            }
            if (str != null && !str.isEmpty()) {
                try {
                    m.a().b().execute(new b(str, dVar, aVar));
                } catch (RejectedExecutionException e2) {
                    e2.printStackTrace();
                    l.a("Httpdns request failed, host(%s), async tasks has exceed the maximum thread limit.", str);
                }
            }
        }
    }

    public void a(ArrayList<String> arrayList, a aVar) {
        ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
        int i = 0;
        int i2 = 0;
        while (i < arrayList2.size()) {
            String str = "";
            int i3 = 0;
            while (true) {
                int i4 = this.s;
                if (i3 >= i4 || (i = i3 + (i4 * i2)) >= arrayList2.size()) {
                    break;
                }
                str = str + ((String) arrayList2.get(i)) + ",";
                i3++;
            }
            i2++;
            if (str != null && !str.isEmpty()) {
                String strSubstring = str.substring(0, str.length() - 1);
                l.a("Hosts for httpdns request is (%s) ", strSubstring);
                a(strSubstring, d.DNLIST_HOSTS, aVar);
            }
        }
    }

    public void a(boolean z) {
        this.h = z;
    }
}
