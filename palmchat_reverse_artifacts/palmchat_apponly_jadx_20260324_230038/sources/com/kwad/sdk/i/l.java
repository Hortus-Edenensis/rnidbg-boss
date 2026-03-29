package com.kwad.sdk.i;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
class l {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int aYc;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onSuccess();
    }

    @WorkerThread
    public static void a(List<k> list, a aVar) {
        if (aYc > 10) {
            j.al("LogReportUtil", "request error");
            return;
        }
        g gVarOW = h.OS().OW();
        Map<String, String> requestHeader = gVarOW.getRequestHeader();
        JSONObject jSONObjectOR = gVarOW.OR();
        c.putValue(jSONObjectOR, "actionList", list);
        c.putValue(jSONObjectOR, "timestamp", System.currentTimeMillis());
        a(gVarOW.OQ(), requestHeader, a(requestHeader, jSONObjectOR), aVar);
    }

    private static String c(Map<String, String> map, String str) {
        g gVarOW = h.OS().OW();
        JSONObject jSONObject = new JSONObject();
        c.putValue(jSONObject, "version", gVarOW.getSdkVersion());
        c.putValue(jSONObject, "appId", gVarOW.getAppId());
        c.putValue(jSONObject, "message", com.kwad.sdk.i.a.av(str));
        com.kwad.sdk.i.a.a(gVarOW.OQ(), map, jSONObject.toString());
        return jSONObject.toString();
    }

    private static String inputStream2String(InputStream inputStream) {
        try {
            try {
                return c(inputStream);
            } catch (IOException unused) {
                j.Pc();
                j.closeQuietly(inputStream);
                return null;
            }
        } finally {
            j.closeQuietly(inputStream);
        }
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static String c(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
                try {
                    String strA = a(bufferedReader);
                    j.closeQuietly(bufferedReader);
                    j.closeQuietly(inputStreamReader);
                    return strA;
                } catch (Throwable th2) {
                    th = th2;
                    j.closeQuietly(bufferedReader);
                    j.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    private static String a(Map<String, String> map, JSONObject jSONObject) {
        if (h.OS().OW().OP()) {
            return jSONObject.toString();
        }
        return c(map, jSONObject.toString());
    }

    private static void a(String str, Map<String, String> map, String str2, a aVar) throws Throwable {
        Closeable closeable;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        OutputStream outputStream = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception unused) {
            closeable = null;
        } catch (Throwable th) {
            th = th;
            closeable = null;
        }
        try {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setUseCaches(false);
            setConnectionHeader(httpURLConnection, map);
            httpURLConnection.connect();
            if (!TextUtils.isEmpty(str2)) {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(str2.getBytes());
                outputStream.flush();
            }
            if (httpURLConnection.getResponseCode() == 200) {
                String strInputStream2String = inputStream2String(httpURLConnection.getInputStream());
                j.Pd();
                if (!TextUtils.isEmpty(strInputStream2String) && new JSONObject(strInputStream2String).optInt("result") == 1) {
                    aYc = 0;
                    aVar.onSuccess();
                } else {
                    aYc++;
                    j.Pd();
                }
            } else {
                aYc++;
                j.Pd();
            }
            j.closeQuietly(httpURLConnection);
            j.closeQuietly(outputStream);
        } catch (Exception unused2) {
            httpURLConnection2 = httpURLConnection;
            closeable = null;
            try {
                aYc++;
                j.Pc();
                j.closeQuietly(httpURLConnection2);
                j.closeQuietly(closeable);
            } catch (Throwable th2) {
                th = th2;
                j.closeQuietly(httpURLConnection2);
                j.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            closeable = null;
            j.closeQuietly(httpURLConnection2);
            j.closeQuietly(closeable);
            throw th;
        }
    }

    private static String a(Reader reader) throws Throwable {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int i = reader.read(cArr);
                    if (i != -1) {
                        stringWriter.write(cArr, 0, i);
                    } else {
                        String string = stringWriter.toString();
                        j.closeQuietly(reader);
                        j.closeQuietly(stringWriter);
                        return string;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                j.closeQuietly(reader);
                j.closeQuietly(stringWriter);
                throw th;
            }
        } catch (Throwable th3) {
            stringWriter = stringWriter2;
            th = th3;
        }
    }
}
