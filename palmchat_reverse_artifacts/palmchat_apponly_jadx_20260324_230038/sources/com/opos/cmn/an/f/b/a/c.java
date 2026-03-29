package com.opos.cmn.an.f.b.a;

import com.huawei.openalliance.ad.constant.bq;
import com.lantern.auth.server.WkParams;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import defpackage.mw6;
import defpackage.r17;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c implements mw6 {
    private UserTraceConfigDto c(String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            UserTraceConfigDto userTraceConfigDto = new UserTraceConfigDto();
            userTraceConfigDto.setTraceId(jSONObject.optLong("traceId", 0L));
            if (!jSONObject.isNull(WkParams.IMEI)) {
                userTraceConfigDto.setImei(jSONObject.optString(WkParams.IMEI, ""));
            }
            userTraceConfigDto.setBeginTime(jSONObject.optLong("beginTime", 0L));
            userTraceConfigDto.setBeginTime(jSONObject.optLong(bq.f.h, 0L));
            userTraceConfigDto.setForce(jSONObject.optInt("force", 0));
            if (!jSONObject.isNull("tracePkg")) {
                userTraceConfigDto.setTracePkg(jSONObject.optString("tracePkg", ""));
            }
            if (!jSONObject.isNull("openId")) {
                String strOptString = jSONObject.optString("openId", "");
                com.opos.cmn.an.f.c.c cVar = new com.opos.cmn.an.f.c.c(UserTraceConfigDto.class);
                Method methodA = cVar.a("setOpenId", String.class);
                if (methodA != null) {
                    methodA.invoke(userTraceConfigDto, strOptString);
                } else {
                    cVar.a("setOpenid", String.class).invoke(userTraceConfigDto, strOptString);
                }
            }
            return userTraceConfigDto;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // defpackage.mw6
    public r17 a(String str) {
        HttpURLConnection httpURLConnection;
        try {
            if (com.opos.cmn.an.d.b.a(str)) {
                return null;
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
                httpURLConnection.connect();
                r17 r17Var = new r17(httpURLConnection.getResponseCode());
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused) {
                }
                return r17Var;
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            httpURLConnection = null;
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:6|35|7|43|8|37|9|(7:10|(1:12)(1:48)|33|44|30|31|32)|13|(1:15)|44|30|31|32) */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    @Override // defpackage.mw6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserTraceConfigDto b(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        StringBuilder sb;
        BufferedReader bufferedReader;
        String string = "";
        HttpURLConnection httpURLConnection2 = null;
        if (com.opos.cmn.an.d.b.a(str)) {
            return null;
        }
        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            a(httpURLConnection);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            httpURLConnection.connect();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                } finally {
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
            }
            return c(string);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            httpURLConnection.disconnect();
            return c(string);
        }
        string = sb.toString();
        if (inputStream != null) {
            inputStream.close();
        }
        httpURLConnection.disconnect();
        return c(string);
        if (httpURLConnection2 != null) {
            httpURLConnection = httpURLConnection2;
            httpURLConnection.disconnect();
        }
        return c(string);
    }

    @Override // defpackage.mw6
    public r17 a(String str, File file) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        r17 r17Var;
        FileInputStream fileInputStream;
        r17 r17Var2 = null;
        try {
        } catch (Throwable unused) {
            httpURLConnection = null;
        }
        if (!com.opos.cmn.an.d.b.a(str) && file != null && file.exists()) {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
                try {
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                if (httpURLConnection != null) {
                }
                return r17Var2;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, i);
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        } catch (Throwable unused4) {
                            r17Var = r17Var2;
                        }
                    }
                }
                dataOutputStream.flush();
                r17Var = new r17(httpURLConnection.getResponseCode());
                try {
                    fileInputStream.close();
                    try {
                        dataOutputStream.close();
                    } catch (Throwable unused5) {
                    }
                    r17Var2 = r17Var;
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused6) {
                    }
                    return r17Var2;
                } catch (Throwable th4) {
                    th = th4;
                    r17Var2 = r17Var;
                    throw th;
                }
            } finally {
            }
        }
        return null;
    }

    private static SSLSocketFactory a() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                SSLSocketFactory sSLSocketFactoryA = a();
                if (sSLSocketFactoryA != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactoryA);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
