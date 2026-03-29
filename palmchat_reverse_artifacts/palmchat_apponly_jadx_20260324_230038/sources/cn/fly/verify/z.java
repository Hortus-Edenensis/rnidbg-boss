package cn.fly.verify;

import android.text.TextUtils;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2446a;
    private v b;

    private HashMap<String, Object> a(x xVar) {
        OutputStream outputStream;
        String string;
        List<String> list;
        HashMap<String, String> mapO;
        z zVar = this;
        x xVar2 = xVar;
        String str = "resultcode";
        try {
            String strD = xVar.d();
            URL url = new URL(strD);
            f.a().a("CMCCSDK " + strD);
            HttpURLConnection httpURLConnection = (HttpURLConnection) (xVar.c() != null ? xVar.c().openConnection(url) : url.openConnection());
            int i = zVar.f2446a;
            HashMap<String, String> mapN = (i == 0 || i == 2) ? xVar.n() : (i == 1 || i == 3) ? xVar.o() : (i == 4 || i == 5) ? xVar.p() : null;
            if (mapN != null) {
                for (String str2 : mapN.keySet()) {
                    httpURLConnection.addRequestProperty(str2, mapN.get(str2));
                }
            }
            if ((httpURLConnection instanceof HttpsURLConnection) && strD.contains("rcs.cmpassport.com")) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(zVar.a(zVar.f2446a));
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setDefaultUseCaches(false);
            String strB = xVar.b();
            httpURLConnection.setRequestMethod(strB);
            httpURLConnection.setDoOutput(true);
            if (zVar.f2446a == 0) {
                httpURLConnection.connect();
                xVar2.e(zVar.b.a());
            }
            if (strB.endsWith("POST")) {
                outputStream = httpURLConnection.getOutputStream();
                int i2 = zVar.f2446a;
                if (i2 == 0) {
                    outputStream.write(xVar.f().getBytes("utf-8"));
                } else if (i2 == 1) {
                    outputStream.write(xVar.e().getBytes("utf-8"));
                } else if (i2 == 2) {
                    outputStream.write(xVar.g().getBytes("utf-8"));
                } else if (i2 == 3) {
                    outputStream.write(xVar.h().getBytes("utf-8"));
                } else if (i2 == 4) {
                    outputStream.write(xVar.j().getBytes("utf-8"));
                } else if (i2 == 5) {
                    outputStream.write(xVar.k().getBytes("utf-8"));
                }
                outputStream.flush();
            } else {
                outputStream = null;
            }
            int responseCode = httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[2048];
            String str3 = "utf-8";
            while (true) {
                int i3 = inputStream.read(bArr);
                byte[] bArr2 = bArr;
                if (i3 == -1) {
                    break;
                }
                try {
                    String str4 = str;
                    String str5 = str3;
                    sb.append(new String(bArr2, 0, i3, str5));
                    zVar = this;
                    bArr = bArr2;
                    str3 = str5;
                    str = str4;
                    xVar2 = xVar;
                } catch (Throwable th) {
                    th = th;
                    f.a().a(th);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("error", as.a(th));
                    map.put("code", Integer.valueOf(th instanceof EOFException ? 200050 : 102102));
                    return map;
                }
            }
            u uVar = new u(responseCode, httpURLConnection.getHeaderFields(), sb.toString());
            f.a().a("CMCCSDK " + responseCode + " " + uVar);
            if (outputStream != null) {
                outputStream.close();
            }
            inputStream.close();
            httpURLConnection.disconnect();
            if (responseCode != 200) {
                if (responseCode == 301 || responseCode == 302) {
                }
                HashMap<String, Object> map2 = new HashMap<>();
                map2.put("error", "responseCode is " + responseCode);
                map2.put("code", 102102);
                return map2;
            }
            JSONObject jSONObject = new JSONObject(uVar.b());
            try {
                if (!jSONObject.has(str)) {
                    str = "resultCode";
                }
                string = jSONObject.getString(str);
            } catch (Throwable unused) {
                string = null;
            }
            if (string != null) {
                return zVar.a(xVar2, string, jSONObject);
            }
            if (responseCode == 200) {
                xVar2.b("POST");
                int i4 = zVar.f2446a;
                if (i4 != 2) {
                    if (i4 == 3) {
                        mapO = xVar.o();
                    }
                    xVar2.g(uVar.b());
                    xVar2.c(xVar.q());
                    xVar2.h(null);
                    return a(xVar);
                }
                mapO = xVar.n();
                mapO.put("Content-Type", "application/json");
                xVar2.g(uVar.b());
                xVar2.c(xVar.q());
                xVar2.h(null);
                return a(xVar);
            }
            Map<String, List<String>> mapA = uVar.a();
            if (mapA.containsKey("pplocation") && (list = mapA.get("pplocation")) != null && list.size() > 0) {
                xVar2.h(list.get(0));
            }
            if (mapA.containsKey(HttpHeaders.LOCATION)) {
                List<String> list2 = mapA.get(HttpHeaders.LOCATION);
                if (list2 == null || list2.isEmpty()) {
                    list2 = mapA.get(HttpHeaders.LOCATION.toLowerCase());
                }
                if (list2 != null && list2.size() > 0) {
                    xVar2.c(list2.get(0));
                }
            }
            xVar2.b("GET");
            int i5 = zVar.f2446a;
            if (i5 == 0 || i5 == 2) {
                xVar.n().put("Content-Type", "application/x-www-form-urlencoded");
                return zVar.a(xVar2, 2);
            }
            if (i5 == 1) {
                xVar.o().put("Content-Type", "application/x-www-form-urlencoded");
                return zVar.a(xVar2, 3);
            }
            HashMap<String, Object> map22 = new HashMap<>();
            map22.put("error", "responseCode is " + responseCode);
            map22.put("code", 102102);
            return map22;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private HashMap<String, Object> b(String str) {
        Long lValueOf;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("phonescrip");
            String strOptString2 = jSONObject.optString("securityphone");
            String strOptString3 = jSONObject.optString("scripExpiresIn");
            HashMap<String, Object> map = new HashMap<>();
            map.put("optoken", strOptString);
            map.put("phone", strOptString2);
            if (as.b().equals("CMCC")) {
                lValueOf = Long.valueOf(System.currentTimeMillis() + 3600000);
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis() + 600000;
                if (strOptString3 != null) {
                    try {
                        jCurrentTimeMillis = (((long) Integer.parseInt(strOptString3)) * 1000) + System.currentTimeMillis();
                    } catch (Throwable unused) {
                    }
                }
                lValueOf = Long.valueOf(jCurrentTimeMillis);
            }
            map.put("expired", lValueOf);
            return map;
        } catch (JSONException e) {
            f.a().a(e);
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("error", as.a(e));
            return map2;
        }
    }

    private HashMap<String, Object> c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("securityphone");
            String strOptString2 = jSONObject.optString("token");
            int iOptInt = jSONObject.optInt("tokenExpiresIn");
            HashMap<String, Object> map = new HashMap<>();
            map.put("optoken", strOptString2);
            map.put("phone", strOptString);
            map.put("expired", Long.valueOf(System.currentTimeMillis() + (((long) iOptInt) * 1000)));
            return map;
        } catch (JSONException e) {
            f.a().a(e);
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("error", as.a(e));
            return map2;
        }
    }

    private HashMap<String, Object> d(String str) {
        return null;
    }

    public HashMap<String, Object> a(x xVar, int i) {
        this.f2446a = i;
        return a(xVar);
    }

    public HashMap<String, Object> a(x xVar, String str, JSONObject jSONObject) {
        String strB;
        if ("103000".equals(str)) {
            String strOptString = jSONObject.optString("resultdata");
            if (TextUtils.isEmpty(strOptString)) {
                strB = jSONObject.toString();
            } else if (xVar != null) {
                strB = w.b(xVar.l(), strOptString, xVar.m());
            } else {
                strB = null;
                str = "200025";
            }
            int i = this.f2446a;
            if (i == 0 || i == 2) {
                return b(strB);
            }
            if (i == 1 || i == 3) {
                return c(strB);
            }
            if (i == 4) {
                return d(strB);
            }
            if (i == 5) {
                return a(strB);
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("error", jSONObject != null ? jSONObject.toString() : "");
        try {
            map.put("code", Integer.valueOf(Integer.parseInt(str)));
        } catch (Throwable unused) {
        }
        return map;
    }

    private HashMap<String, Object> a(String str) {
        return null;
    }

    public synchronized SSLSocketFactory a(int i) {
        v vVar;
        if (i == 0) {
            vVar = new v(HttpsURLConnection.getDefaultSSLSocketFactory());
            if (this.b == null) {
                this.b = vVar;
            }
        } else {
            if (this.b == null) {
                this.b = new v(HttpsURLConnection.getDefaultSSLSocketFactory());
            }
            vVar = this.b;
        }
        return vVar;
    }
}
