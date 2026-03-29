package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kuaishou.weapon.p0.g;
import com.umeng.analytics.pro.dn;
import com.zenmen.palmchat.refund.RefundData;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import okio.Utf8;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class sj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20761a = bf2.b(new byte[]{32, 0, dn.l, 41, 38, 38, Utf8.REPLACEMENT_BYTE, 1, 23, 43});

    public static HttpURLConnection a(Context context, String str) throws IOException {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        URL url = new URL(str);
        if (context != null) {
            try {
                if (context.getPackageManager().checkPermission(g.b, context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                    return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(f20761a, 80)));
                }
            } catch (Throwable unused) {
            }
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static mj2 b(Context context, lj2 lj2Var) {
        return c(context, lj2Var, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0246 A[PHI: r1 r3 r9 r11
      0x0246: PHI (r1v7 java.io.InputStream) = (r1v2 java.io.InputStream), (r1v8 java.io.InputStream) binds: [B:77:0x01a9, B:101:0x0244] A[DONT_GENERATE, DONT_INLINE]
      0x0246: PHI (r3v9 java.io.OutputStream) = (r3v42 java.io.OutputStream), (r3v43 java.io.OutputStream) binds: [B:77:0x01a9, B:101:0x0244] A[DONT_GENERATE, DONT_INLINE]
      0x0246: PHI (r9v9 java.io.InputStream) = (r9v20 java.io.InputStream), (r9v21 java.io.InputStream) binds: [B:77:0x01a9, B:101:0x0244] A[DONT_GENERATE, DONT_INLINE]
      0x0246: PHI (r11v20 java.net.HttpURLConnection) = (r11v32 java.net.HttpURLConnection), (r11v33 java.net.HttpURLConnection) binds: [B:77:0x01a9, B:101:0x0244] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122 A[Catch: all -> 0x013d, IOException -> 0x0142, MalformedURLException -> 0x0148, TryCatch #11 {MalformedURLException -> 0x0148, IOException -> 0x0142, all -> 0x013d, blocks: (B:32:0x00ef, B:47:0x0112, B:49:0x0118, B:51:0x0122, B:52:0x012c), top: B:126:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c0 A[Catch: all -> 0x0211, TryCatch #9 {all -> 0x0211, blocks: (B:82:0x01b3, B:84:0x01c0, B:91:0x01ea, B:85:0x01cc, B:87:0x01d0, B:88:0x01dc, B:90:0x01e0), top: B:116:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cc A[Catch: all -> 0x0211, TryCatch #9 {all -> 0x0211, blocks: (B:82:0x01b3, B:84:0x01c0, B:91:0x01ea, B:85:0x01cc, B:87:0x01d0, B:88:0x01dc, B:90:0x01e0), top: B:116:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020d  */
    /* JADX WARN: Type inference failed for: r11v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static mj2 c(Context context, lj2 lj2Var, boolean z) throws Throwable {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream4;
        OutputStream outputStream3;
        OutputStream outputStream4;
        OutputStream outputStream5;
        byte[] bArrE;
        InputStream inputStream5 = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        errorStream = null;
        InputStream errorStream = null;
        inputStream5 = null;
        inputStream5 = null;
        inputStream5 = null;
        inputStream5 = null;
        inputStream5 = null;
        HttpURLConnection httpURLConnection4 = null;
        inputStream5 = null;
        if (lj2Var == null) {
            return null;
        }
        ?? G = lj2Var.g();
        mj2 mj2Var = new mj2(G);
        try {
            try {
                HttpURLConnection httpURLConnectionA = a(context, lj2Var.g());
                try {
                    URL url = httpURLConnectionA.getURL();
                    k63.j("HttpUtils", "host:" + url.getHost() + ",port:" + url.getPort());
                    g(lj2Var, httpURLConnectionA);
                    if (httpURLConnectionA instanceof HttpsURLConnection) {
                        try {
                            if (lj2Var.f() != null) {
                                SSLContext sSLContext = SSLContext.getInstance("TLS");
                                sSLContext.init(null, new TrustManager[]{lj2Var.f()}, new SecureRandom());
                                ((HttpsURLConnection) httpURLConnectionA).setSSLSocketFactory(sSLContext.getSocketFactory());
                            }
                            if (lj2Var.b() != null) {
                                ((HttpsURLConnection) httpURLConnectionA).setHostnameVerifier(lj2Var.b());
                            } else {
                                ((HttpsURLConnection) httpURLConnectionA).setHostnameVerifier(new x51(httpURLConnectionA.getURL().getHost()));
                            }
                        } catch (Throwable th) {
                            k63.n("HttpUtils", "set ssl config error:" + th.getMessage());
                        }
                    }
                    if (z != 0) {
                        httpURLConnectionA.setRequestMethod("POST");
                        httpURLConnectionA.setDoOutput(true);
                        httpURLConnectionA.setDoInput(true);
                        byte[] bArrC = lj2Var.c();
                        if (bArrC != null) {
                            outputStream5 = httpURLConnectionA.getOutputStream();
                            try {
                                outputStream5.write(bArrC);
                                outputStream5 = outputStream5;
                            } catch (MalformedURLException e) {
                                e = e;
                                httpURLConnection2 = httpURLConnectionA;
                                inputStream3 = null;
                                outputStream2 = outputStream5;
                                k63.l("HttpUtils", "http post  error:" + e.getMessage());
                                mj2Var.d(3004);
                                mj2Var.c("MalformedURLException");
                                z86.b(inputStream5);
                                z86.b(inputStream3);
                                z86.b(outputStream2);
                                outputStream3 = outputStream2;
                                inputStream4 = inputStream3;
                                httpURLConnection3 = httpURLConnection2;
                                G = outputStream2;
                                context = inputStream3;
                                z = httpURLConnection2;
                                if (httpURLConnection2 != null) {
                                    httpURLConnection3.disconnect();
                                    G = outputStream3;
                                    context = inputStream4;
                                    z = httpURLConnection3;
                                }
                                return mj2Var;
                            } catch (IOException e2) {
                                e = e2;
                                inputStream2 = null;
                                outputStream4 = outputStream5;
                                httpURLConnection4 = httpURLConnectionA;
                                context = inputStream2;
                                G = outputStream4;
                                try {
                                    mj2Var.d(2998);
                                    mj2Var.c("网络错误");
                                    if (!(e instanceof SocketTimeoutException)) {
                                        mj2Var.d(3001);
                                        mj2Var.c("请求超时");
                                    } else if (e instanceof UnknownHostException) {
                                        mj2Var.d(3003);
                                        mj2Var.c("域名无效");
                                    } else if (e instanceof SSLHandshakeException) {
                                        mj2Var.d(3005);
                                        mj2Var.c("SSL失败");
                                    }
                                    k63.l("HttpUtils", "http post IOException error:" + e.getMessage());
                                    z86.b(inputStream2);
                                    z86.b(context);
                                    z86.b(G);
                                    if (httpURLConnection4 != null) {
                                        httpURLConnection4.disconnect();
                                    }
                                    return mj2Var;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = httpURLConnection4;
                                    inputStream5 = inputStream2;
                                    z86.b(inputStream5);
                                    z86.b(context);
                                    z86.b(G);
                                    if (z != 0) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                httpURLConnection = httpURLConnectionA;
                                inputStream = null;
                                outputStream = outputStream5;
                                k63.l("HttpUtils", "http post Exception error:" + th);
                                mj2Var.d(3006);
                                mj2Var.c("UNKnow execption" + th.getMessage());
                                z86.b(inputStream5);
                                z86.b(inputStream);
                                z86.b(outputStream);
                                outputStream3 = outputStream;
                                inputStream4 = inputStream;
                                httpURLConnection3 = httpURLConnection;
                                G = outputStream;
                                context = inputStream;
                                z = httpURLConnection;
                                if (httpURLConnection != null) {
                                }
                                return mj2Var;
                            }
                        } else {
                            outputStream5 = null;
                        }
                        int responseCode = httpURLConnectionA.getResponseCode();
                        mj2Var.d(responseCode);
                        try {
                            inputStream2 = httpURLConnectionA.getInputStream();
                        } catch (Throwable th4) {
                            k63.a("HttpUtils", "get input stream error:" + th4.getMessage());
                            inputStream2 = null;
                        }
                        try {
                            if (!lj2Var.h() || inputStream2 == null) {
                                bArrE = null;
                                if (bArrE == null && responseCode != 200 && lj2Var.i()) {
                                    errorStream = httpURLConnectionA.getErrorStream();
                                    bArrE = e(errorStream);
                                }
                                if (bArrE != null) {
                                    mj2Var.c(new String(bArrE, "UTF-8"));
                                }
                                f(httpURLConnectionA, mj2Var);
                                z86.b(inputStream2);
                                z86.b(errorStream);
                                z86.b(outputStream5);
                                httpURLConnectionA.disconnect();
                            } else {
                                try {
                                    bArrE = e(inputStream2);
                                    if (bArrE != null) {
                                        try {
                                            if (lj2Var.j()) {
                                                bArrE = z86.c(bArrE);
                                            }
                                        } catch (Throwable unused) {
                                        }
                                    }
                                } catch (Throwable unused2) {
                                    bArrE = null;
                                }
                                if (bArrE == null) {
                                    errorStream = httpURLConnectionA.getErrorStream();
                                    bArrE = e(errorStream);
                                }
                                if (bArrE != null) {
                                }
                                f(httpURLConnectionA, mj2Var);
                                z86.b(inputStream2);
                                z86.b(errorStream);
                                z86.b(outputStream5);
                                httpURLConnectionA.disconnect();
                            }
                        } catch (MalformedURLException e3) {
                            e = e3;
                            httpURLConnection2 = httpURLConnectionA;
                            inputStream3 = errorStream;
                            inputStream5 = inputStream2;
                            outputStream2 = outputStream5;
                            k63.l("HttpUtils", "http post  error:" + e.getMessage());
                            mj2Var.d(3004);
                            mj2Var.c("MalformedURLException");
                            z86.b(inputStream5);
                            z86.b(inputStream3);
                            z86.b(outputStream2);
                            outputStream3 = outputStream2;
                            inputStream4 = inputStream3;
                            httpURLConnection3 = httpURLConnection2;
                            G = outputStream2;
                            context = inputStream3;
                            z = httpURLConnection2;
                            if (httpURLConnection2 != null) {
                            }
                        } catch (IOException e4) {
                            e = e4;
                            InputStream inputStream6 = errorStream;
                            httpURLConnection4 = httpURLConnectionA;
                            context = inputStream6;
                            G = outputStream5;
                            mj2Var.d(2998);
                            mj2Var.c("网络错误");
                            if (!(e instanceof SocketTimeoutException)) {
                            }
                            k63.l("HttpUtils", "http post IOException error:" + e.getMessage());
                            z86.b(inputStream2);
                            z86.b(context);
                            z86.b(G);
                            if (httpURLConnection4 != null) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            httpURLConnection = httpURLConnectionA;
                            inputStream = errorStream;
                            inputStream5 = inputStream2;
                            outputStream = outputStream5;
                            k63.l("HttpUtils", "http post Exception error:" + th);
                            mj2Var.d(3006);
                            mj2Var.c("UNKnow execption" + th.getMessage());
                            z86.b(inputStream5);
                            z86.b(inputStream);
                            z86.b(outputStream);
                            outputStream3 = outputStream;
                            inputStream4 = inputStream;
                            httpURLConnection3 = httpURLConnection;
                            G = outputStream;
                            context = inputStream;
                            z = httpURLConnection;
                            if (httpURLConnection != null) {
                            }
                        }
                    }
                } catch (MalformedURLException e5) {
                    e = e5;
                    httpURLConnection2 = httpURLConnectionA;
                    inputStream3 = null;
                    outputStream2 = null;
                } catch (IOException e6) {
                    e = e6;
                    outputStream4 = null;
                    inputStream2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection = httpURLConnectionA;
                    inputStream = null;
                    outputStream = null;
                }
            } catch (Throwable th7) {
                th = th7;
                z86.b(inputStream5);
                z86.b(context);
                z86.b(G);
                if (z != 0) {
                    z.disconnect();
                }
                throw th;
            }
        } catch (MalformedURLException e7) {
            e = e7;
            inputStream3 = null;
            httpURLConnection2 = null;
            outputStream2 = null;
        } catch (IOException e8) {
            e = e8;
            context = 0;
            G = 0;
            inputStream2 = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            httpURLConnection = null;
            outputStream = null;
        }
        return mj2Var;
    }

    public static String d(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<String, String> next = it.next();
                    sb.append(next.getKey());
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static byte[] e(InputStream inputStream) throws Exception {
        return z86.f(inputStream);
    }

    public static void f(HttpURLConnection httpURLConnection, mj2 mj2Var) throws IOException {
        if (mj2Var == null || httpURLConnection == null) {
            return;
        }
        mj2Var.d(httpURLConnection.getResponseCode());
        mj2Var.e(RefundData.TAG_CLOCK, httpURLConnection.getHeaderField(HttpHeaders.EXPIRES));
        mj2Var.e("cache-control", httpURLConnection.getHeaderField(HttpHeaders.CACHE_CONTROL));
    }

    public static void g(lj2 lj2Var, HttpURLConnection httpURLConnection) {
        if (lj2Var == null || httpURLConnection == null) {
            return;
        }
        h(lj2Var.e(), httpURLConnection);
        if (lj2Var.a() >= 0) {
            httpURLConnection.setConnectTimeout(lj2Var.a());
        }
        if (lj2Var.d() >= 0) {
            httpURLConnection.setReadTimeout(lj2Var.d());
        }
    }

    public static void h(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
