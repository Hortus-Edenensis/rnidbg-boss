package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f extends a implements Callable<d> {
    private static final String i = "f";

    public f(String str, int i2, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        super(str, i2, cVar, context, str2, grsBaseInfo, cVar2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0149: MOVE (r6 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:62:0x0149 */
    @Override // java.util.concurrent.Callable
    public d call() throws Throwable {
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnectionA;
        long j;
        long jCurrentTimeMillis;
        long jElapsedRealtime;
        String str = i;
        Logger.i(str, "Post call execute");
        long jCurrentTimeMillis2 = 0;
        HttpURLConnection httpURLConnection2 = null;
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            try {
                try {
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        jCurrentTimeMillis2 = System.currentTimeMillis();
                        httpsURLConnectionA = com.huawei.hms.framework.network.grs.h.f.a.a(c(), a(), e());
                    } catch (IOException e) {
                        e = e;
                        httpsURLConnectionA = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (RuntimeException unused) {
                            Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                        } catch (Throwable unused2) {
                            Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                httpsURLConnectionA = null;
                j = 0;
            }
            try {
            } catch (IOException e3) {
                e = e3;
                long j2 = jCurrentTimeMillis2;
                jCurrentTimeMillis2 = jElapsedRealtime;
                j = j2;
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                jCurrentTimeMillis = System.currentTimeMillis();
                Logger.w(i, "RequestCallableV2 run task catch IOException", e);
                this.f6728a = new d(e, jElapsedRealtime2 - jCurrentTimeMillis2);
                if (httpsURLConnectionA != null) {
                    try {
                        httpsURLConnectionA.disconnect();
                    } catch (RuntimeException unused3) {
                        jCurrentTimeMillis2 = j;
                        Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                    } catch (Throwable unused4) {
                        jCurrentTimeMillis2 = j;
                        Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                    }
                }
                jCurrentTimeMillis2 = j;
            }
            if (httpsURLConnectionA == null) {
                Logger.w(str, "create HttpsURLConnection instance by url return null.");
                if (httpsURLConnectionA != null) {
                    try {
                        httpsURLConnectionA.disconnect();
                    } catch (RuntimeException unused5) {
                        Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                    } catch (Throwable unused6) {
                        Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                    }
                }
                return null;
            }
            httpsURLConnectionA.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpsURLConnectionA.setRequestProperty("Connection", "close");
            httpsURLConnectionA.setRequestMethod("POST");
            httpsURLConnectionA.setDoOutput(true);
            httpsURLConnectionA.setDoInput(true);
            String strA = b() != null ? b().a() : "";
            if (TextUtils.isEmpty(strA)) {
                strA = ContainerUtils.FIELD_DELIMITER;
            }
            httpsURLConnectionA.setRequestProperty(HttpHeaders.IF_NONE_MATCH, strA);
            httpsURLConnectionA.connect();
            com.huawei.hms.framework.network.grs.h.f.a.a(httpsURLConnectionA, f().a("services", ""));
            int responseCode = httpsURLConnectionA.getResponseCode();
            Logger.i(str, "httpsURLConnection result code:" + responseCode);
            if (responseCode == 200) {
                try {
                    inputStream = httpsURLConnectionA.getInputStream();
                    byte[] byteArray = IoUtils.toByteArray(inputStream);
                    IoUtils.closeSecure(inputStream);
                    bArr = byteArray;
                } catch (Throwable th2) {
                    IoUtils.closeSecure(inputStream);
                    throw th2;
                }
            }
            Map<String, List<String>> headerFields = httpsURLConnectionA.getHeaderFields();
            httpsURLConnectionA.disconnect();
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            jCurrentTimeMillis = System.currentTimeMillis();
            this.f6728a = new d(responseCode, headerFields, bArr == null ? new byte[0] : bArr, jElapsedRealtime3 - jElapsedRealtime);
            try {
                httpsURLConnectionA.disconnect();
            } catch (RuntimeException unused7) {
                Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
            } catch (Throwable unused8) {
                Logger.w(i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
            }
            this.f6728a.b(c());
            this.f6728a.a(d());
            this.f6728a.b(jCurrentTimeMillis2);
            this.f6728a.a(jCurrentTimeMillis);
            if (b() != null) {
                b().a(this.f6728a);
            }
            return this.f6728a;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
        }
    }
}
