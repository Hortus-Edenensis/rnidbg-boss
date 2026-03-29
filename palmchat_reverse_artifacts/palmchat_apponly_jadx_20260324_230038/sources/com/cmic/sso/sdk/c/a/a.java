package com.cmic.sso.sdk.c.a;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.c.b.h;
import com.qiniu.android.collect.ReportItem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.cmic.sso.sdk.c.c f5490a;

    /* JADX WARN: Removed duplicated region for block: B:100:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0228 A[Catch: all -> 0x0296, TryCatch #5 {all -> 0x0296, blocks: (B:87:0x01ef, B:91:0x0224, B:93:0x0228, B:95:0x0230, B:97:0x0238, B:44:0x0154, B:45:0x0156, B:47:0x015c, B:48:0x016a), top: B:131:0x002f }] */
    @Override // com.cmic.sso.sdk.c.a.b
    @TargetApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) throws Throwable {
        String str;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        int responseCode;
        Closeable closeable;
        InputStream inputStream;
        boolean z;
        String str2 = "";
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "请求地址: " + cVar.a());
        StringBuilder sb = new StringBuilder();
        try {
            try {
                String strA = cVar.a();
                URL url = new URL(strA);
                final String host = url.getHost();
                g gVarK = cVar.k();
                if ((gVarK instanceof h) || (gVarK instanceof e)) {
                    String strB = aVar.b(ReportItem.RequestKeyRemoteIp);
                    if (TextUtils.isEmpty(strB)) {
                        z = false;
                    } else {
                        url = new URL(strA.replaceFirst(host, strB));
                        z = true;
                    }
                    if (cVar.h() != null) {
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "开始wifi下取号");
                        httpURLConnection = (HttpURLConnection) cVar.h().openConnection(url);
                    } else {
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "使用当前网络环境发送请求");
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                    }
                    try {
                        Map<String, String> mapC = cVar.c();
                        if (mapC != null) {
                            for (String str3 : mapC.keySet()) {
                                str = str2;
                                try {
                                    httpURLConnection.addRequestProperty(str3, mapC.get(str3));
                                    str2 = str;
                                } catch (Exception e) {
                                    e = e;
                                    outputStream = null;
                                    inputStream = null;
                                    e.printStackTrace();
                                    com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + cVar.a());
                                    aVar.a().f5514a.add(e);
                                    if (e instanceof EOFException) {
                                    }
                                    if (e instanceof UnknownHostException) {
                                    }
                                    a(outputStream);
                                    a(inputStream);
                                    if (httpURLConnection != null) {
                                    }
                                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("responseResult: ");
                                    sb2.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb2.toString());
                                    if (responseCode != 200) {
                                    }
                                    cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    outputStream = null;
                                    closeable = null;
                                    responseCode = -1;
                                    a(outputStream);
                                    a(closeable);
                                    if (httpURLConnection != null) {
                                    }
                                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("responseResult: ");
                                    sb3.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb3.toString());
                                    if (responseCode == 200) {
                                        cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                                    }
                                    throw th;
                                }
                            }
                        }
                        str = str2;
                        if ((httpURLConnection instanceof HttpsURLConnection) && ((gVarK instanceof h) || (gVarK instanceof e))) {
                            if (z) {
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "host = " + host);
                                httpURLConnection.setRequestProperty("Host", host);
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "need sni handle");
                                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new com.cmic.sso.sdk.c.d((HttpsURLConnection) httpURLConnection, cVar.h(), aVar));
                                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.cmic.sso.sdk.c.a.a.1
                                    @Override // javax.net.ssl.HostnameVerifier
                                    public boolean verify(String str4, SSLSession sSLSession) {
                                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSession);
                                    }
                                });
                            } else {
                                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(a(gVarK, aVar));
                            }
                        }
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setReadTimeout(5000);
                        httpURLConnection.setDefaultUseCaches(false);
                        String strE = cVar.e();
                        httpURLConnection.setRequestMethod(strE);
                        httpURLConnection.setDoOutput(true);
                        if (cVar instanceof com.cmic.sso.sdk.c.c.b) {
                            httpURLConnection.connect();
                            ((com.cmic.sso.sdk.c.c.b) cVar).a(aVar);
                        }
                        if (strE.endsWith("POST")) {
                            outputStream = httpURLConnection.getOutputStream();
                            try {
                                outputStream.write(cVar.d().getBytes("utf-8"));
                                outputStream.flush();
                            } catch (Exception e2) {
                                e = e2;
                                inputStream = null;
                                e.printStackTrace();
                                com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + cVar.a());
                                aVar.a().f5514a.add(e);
                                if (e instanceof EOFException) {
                                }
                                if (e instanceof UnknownHostException) {
                                    aVar.a(ReportItem.RequestKeyRemoteIp, a());
                                }
                                a(outputStream);
                                a(inputStream);
                                if (httpURLConnection != null) {
                                }
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
                                StringBuilder sb22 = new StringBuilder();
                                sb22.append("responseResult: ");
                                sb22.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb22.toString());
                                if (responseCode != 200) {
                                }
                                cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = null;
                                responseCode = -1;
                                a(outputStream);
                                a(closeable);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
                                StringBuilder sb32 = new StringBuilder();
                                sb32.append("responseResult: ");
                                sb32.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb32.toString());
                                if (responseCode == 200 || responseCode == 301 || responseCode == 302) {
                                    cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                                } else {
                                    cVar2.a(com.cmic.sso.sdk.c.d.a.a(responseCode));
                                }
                                throw th;
                            }
                        } else {
                            outputStream = null;
                        }
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (Exception e3) {
                        e = e3;
                        str = str2;
                    } catch (Throwable th3) {
                        th = th3;
                        str = str2;
                    }
                    try {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i <= 0) {
                                    break;
                                } else {
                                    sb.append(new String(bArr, 0, i, "utf-8"));
                                }
                            }
                            com.cmic.sso.sdk.c.d.b bVar = new com.cmic.sso.sdk.c.d.b(responseCode, httpURLConnection.getHeaderFields(), sb.toString());
                            a(outputStream);
                            a(inputStream);
                            httpURLConnection.disconnect();
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("responseResult: ");
                            sb4.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb4.toString());
                            if (responseCode == 200 || responseCode == 301 || responseCode == 302) {
                                cVar2.a(bVar);
                                return;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + cVar.a());
                            aVar.a().f5514a.add(e);
                            responseCode = e instanceof EOFException ? 200050 : 102102;
                            if ((e instanceof UnknownHostException) && ((cVar.k() instanceof h) || (cVar.k() instanceof e))) {
                                aVar.a(ReportItem.RequestKeyRemoteIp, a());
                            }
                            a(outputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
                            StringBuilder sb222 = new StringBuilder();
                            sb222.append("responseResult: ");
                            sb222.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb222.toString());
                            if (responseCode != 200 || responseCode == 301 || responseCode == 302) {
                                cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                                return;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        inputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        closeable = null;
                        a(outputStream);
                        a(closeable);
                        if (httpURLConnection != null) {
                        }
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
                        StringBuilder sb322 = new StringBuilder();
                        sb322.append("responseResult: ");
                        sb322.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb322.toString());
                        if (responseCode == 200) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e6) {
            e = e6;
            str = "";
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th6) {
            th = th6;
            str = "";
            outputStream = null;
            httpURLConnection = null;
        }
        cVar2.a(com.cmic.sso.sdk.c.d.a.a(responseCode));
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String a() {
        return com.cmic.sso.sdk.b.f5486a[0] + "." + com.cmic.sso.sdk.b.f5486a[2] + "." + com.cmic.sso.sdk.b.f5486a[4] + "." + com.cmic.sso.sdk.b.f5486a[6];
    }

    public synchronized SSLSocketFactory a(g gVar, com.cmic.sso.sdk.a aVar) {
        if (gVar instanceof e) {
            com.cmic.sso.sdk.c.c cVar = new com.cmic.sso.sdk.c.c(HttpsURLConnection.getDefaultSSLSocketFactory(), aVar);
            if (f5490a == null) {
                f5490a = cVar;
            }
            return cVar;
        }
        if (f5490a == null) {
            f5490a = new com.cmic.sso.sdk.c.c(HttpsURLConnection.getDefaultSSLSocketFactory(), aVar);
        }
        return f5490a;
    }
}
