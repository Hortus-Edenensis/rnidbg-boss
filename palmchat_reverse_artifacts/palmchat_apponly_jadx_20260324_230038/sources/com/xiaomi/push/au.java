package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.efs.sdk.base.Constants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<a<av>> f11423a = new AtomicReference<>(a());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f135a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> extends FutureTask<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f11424a;

        public a(Callable<T> callable) {
            super(callable);
        }

        public boolean a() {
            return j.m651a(C1401r.m660a()) || (isDone() && Math.abs(SystemClock.elapsedRealtime() - this.f11424a) > 1800000);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.f11424a = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f11425a;

        public b(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int i3;
            if (!this.f11425a && (i3 = super.read(bArr, i, i2)) != -1) {
                return i3;
            }
            this.f11425a = true;
            return -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11426a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<String, String> f136a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.f11426a), this.f136a.toString());
        }
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static void b() {
        f11423a.set(a());
    }

    public static boolean c(Context context) {
        av avVarM168a = m168a();
        return avVarM168a != null && avVarM168a.m179a();
    }

    public static boolean d(Context context) {
        av avVarM168a = m168a();
        return avVarM168a != null && 1 == avVarM168a.a();
    }

    public static boolean e(Context context) {
        av avVarM169a = m169a(context);
        return avVarM169a != null && avVarM169a.a() == 0 && 20 == avVarM169a.b();
    }

    public static boolean f(Context context) {
        av avVarM169a = m169a(context);
        return avVarM169a != null && avVarM169a.a() == 0 && 13 == avVarM169a.b();
    }

    public static boolean g(Context context) {
        av avVarM169a = m169a(context);
        if (avVarM169a == null || avVarM169a.a() != 0) {
            return false;
        }
        String strM180b = avVarM169a.m180b();
        if (!"TD-SCDMA".equalsIgnoreCase(strM180b) && !"CDMA2000".equalsIgnoreCase(strM180b) && !"WCDMA".equalsIgnoreCase(strM180b)) {
            switch (avVarM169a.b()) {
            }
            return false;
        }
        return true;
    }

    public static boolean h(Context context) {
        av avVarM169a = m169a(context);
        if (avVarM169a == null || avVarM169a.a() != 0) {
            return false;
        }
        int iB = avVarM169a.b();
        return iB == 1 || iB == 2 || iB == 4 || iB == 7 || iB == 11;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m174a() {
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context) {
        boolean zHasCapability;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            zHasCapability = false;
        } else if (Build.VERSION.SDK_INT >= 23) {
            try {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null) {
                    zHasCapability = networkCapabilities.hasCapability(16);
                }
            } catch (Exception unused) {
            }
        } else {
            zHasCapability = m175a(context);
        }
        return zHasCapability && c(context);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Object m170a(Context context) {
        if (context == null) {
            context = C1401r.m660a();
        }
        ConnectivityManager.NetworkCallback networkCallback = null;
        if (context == null || j.m651a(context)) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
            ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.xiaomi.push.au.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    au.b();
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    au.b();
                }
            };
            try {
                connectivityManager.registerNetworkCallback(networkRequestBuild, networkCallback2);
                return networkCallback2;
            } catch (Throwable th) {
                th = th;
                networkCallback = networkCallback2;
                com.xiaomi.channel.commonutils.logger.b.m74a("exception occurred in adding network callback :" + th);
                return networkCallback;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context, Object obj) {
        if (context == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof ConnectivityManager.NetworkCallback) {
                ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m74a("exception occurred in removing network callback :" + th);
        }
    }

    private static a<av> a() {
        return new a<>(new Callable<av>() { // from class: com.xiaomi.push.au.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public av call() {
                NetworkInfo activeNetworkInfo;
                Context contextM660a = C1401r.m660a();
                if (contextM660a == null) {
                    return null;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) contextM660a.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return null;
                    }
                    return new av(activeNetworkInfo);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static av m168a() {
        AtomicReference<a<av>> atomicReference = f11423a;
        a<av> aVarA = atomicReference.get();
        if (aVarA != null) {
            try {
                if (aVarA.a()) {
                    aVarA = a();
                    atomicReference.set(aVarA);
                }
                if (!aVarA.isDone()) {
                    aVarA.run();
                }
                return aVarA.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, c cVar) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("context");
        }
        if (url != null) {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection httpURLConnectionM172a = m172a(context, url2);
                httpURLConnectionM172a.setConnectTimeout(10000);
                httpURLConnectionM172a.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    httpURLConnectionM172a.setRequestProperty("User-Agent", str);
                }
                if (str2 != null) {
                    httpURLConnectionM172a.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        httpURLConnectionM172a.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (cVar != null && (url.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME) || url.getProtocol().equals(BaseConstants.SCHEME_HTTPS))) {
                    cVar.f11426a = httpURLConnectionM172a.getResponseCode();
                    if (cVar.f136a == null) {
                        cVar.f136a = new HashMap();
                    }
                    int i = 0;
                    while (true) {
                        String headerFieldKey = httpURLConnectionM172a.getHeaderFieldKey(i);
                        String headerField = httpURLConnectionM172a.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                            cVar.f136a.put(headerFieldKey, headerField);
                        }
                        i++;
                    }
                }
                return new b(httpURLConnectionM172a.getInputStream());
            } catch (IOException e) {
                throw new IOException("IOException:" + e.getClass().getSimpleName());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        }
        throw new IllegalArgumentException("url");
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) throws Throwable {
        InputStream inputStreamA;
        try {
            inputStreamA = a(context, url, z, str, str3);
            try {
                StringBuilder sb = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamA, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int i = bufferedReader.read(cArr);
                    if (-1 != i) {
                        sb.append(cArr, 0, i);
                    } else {
                        w.a((Closeable) inputStreamA);
                        return sb.toString();
                    }
                }
            } catch (Throwable th) {
                th = th;
                w.a((Closeable) inputStreamA);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamA = null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, ba.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        FileInputStream fileInputStream;
        byte[] bArr;
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", HTTP.CONN_KEEP_ALIVE);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"" + HttpClient.NEWLINE);
                dataOutputStream.writeBytes(HttpClient.NEWLINE);
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = new byte[1024];
                } catch (IOException e) {
                    e = e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                w.a((Closeable) null);
                w.a((Closeable) file);
                throw th2;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
        }
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                break;
            }
            dataOutputStream.write(bArr, 0, i);
            dataOutputStream.flush();
            throw new IOException("IOException:" + e.getClass().getSimpleName());
        }
        dataOutputStream.writeBytes(HttpClient.NEWLINE);
        dataOutputStream.writeBytes(HttpClient.ENDFLAG);
        dataOutputStream.writeBytes("*****");
        dataOutputStream.writeBytes(HttpClient.ENDFLAG);
        dataOutputStream.writeBytes(HttpClient.NEWLINE);
        dataOutputStream.flush();
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnection.getInputStream())));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    stringBuffer.append(line);
                } else {
                    String string = stringBuffer.toString();
                    w.a((Closeable) fileInputStream);
                    w.a(bufferedReader);
                    return string;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th4) {
                th = th4;
                throw new IOException(th.getMessage());
            }
        }
    }

    public static int a(Context context) {
        av avVarM168a = m168a();
        if (avVarM168a == null) {
            return -1;
        }
        return avVarM168a.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static HttpURLConnection m172a(Context context, URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m175a(Context context) {
        return a(context) >= 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static av m169a(Context context) {
        return m168a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m171a(Context context) {
        if (d(context)) {
            return "wifi";
        }
        av avVarM168a = m168a();
        if (avVarM168a == null) {
            return "";
        }
        return (avVarM168a.m178a() + "-" + avVarM168a.m180b()).toLowerCase();
    }

    public static as a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static as a(Context context, String str, String str2, Map<String, String> map, String str3) {
        HttpURLConnection httpURLConnectionM172a;
        int i;
        boolean zEqualsIgnoreCase;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        as asVar = new as();
        try {
            try {
                try {
                    httpURLConnectionM172a = m172a(context, m173a(str));
                    httpURLConnectionM172a.setConnectTimeout(10000);
                    httpURLConnectionM172a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    httpURLConnectionM172a.setRequestMethod(str4);
                    i = 0;
                    if (map != null) {
                        zEqualsIgnoreCase = Constants.CP_GZIP.equalsIgnoreCase(map.get("Content-Encoding"));
                        for (String str5 : map.keySet()) {
                            httpURLConnectionM172a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        zEqualsIgnoreCase = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnectionM172a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (zEqualsIgnoreCase) {
                            outputStream = new GZIPOutputStream(httpURLConnectionM172a.getOutputStream());
                        } else {
                            outputStream = httpURLConnectionM172a.getOutputStream();
                        }
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e) {
                            e = e;
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    asVar.f11422a = httpURLConnectionM172a.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.b.m74a("Http POST Response Code: " + asVar.f11422a);
                } catch (IOException e2) {
                    e = e2;
                }
                while (true) {
                    String headerFieldKey = httpURLConnectionM172a.getHeaderFieldKey(i);
                    String headerField = httpURLConnectionM172a.getHeaderField(i);
                    if (headerFieldKey == null && headerField == null) {
                        try {
                            break;
                        } catch (IOException unused) {
                            bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM172a.getErrorStream())));
                        }
                    } else {
                        asVar.f134a.put(headerFieldKey, headerField);
                        i = i + 1 + 1;
                    }
                    throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
                }
                bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM172a.getInputStream())));
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String property = System.getProperty("line.separator");
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    stringBuffer.append(line);
                    stringBuffer.append(property);
                }
                asVar.f133a = stringBuffer.toString();
                bufferedReader.close();
                w.a((Closeable) null);
                w.a((Closeable) null);
                return asVar;
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                throw new IOException(th.getMessage());
            }
        } catch (Throwable th4) {
            w.a((Closeable) null);
            w.a((Closeable) str2);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                } catch (UnsupportedEncodingException e) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("Failed to convert from params map to string: " + e);
                    com.xiaomi.channel.commonutils.logger.b.m74a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static URL m173a(String str) {
        return new URL(str);
    }
}
