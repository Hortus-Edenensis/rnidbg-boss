package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.Constants;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bw;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private static final Pattern aJZ = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String aKa = "UTF-8";
    private static OkHttpClient aKb = null;
    public static OkHttpClient aKc = Jy();

    public static OkHttpClient Jx() {
        if (!com.kwad.framework.a.a.oy.booleanValue()) {
            return aKc;
        }
        if (aKb == null) {
            aKb = aKc.newBuilder().build();
        }
        return aKb;
    }

    private static OkHttpClient Jy() {
        if (aKc == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder builderConnectionSpecs = builder.connectTimeout(3000L, timeUnit).readTimeout(6000L, timeUnit).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                builderConnectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            aKc = builderConnectionSpecs.build();
        }
        return aKc;
    }

    public static com.kwad.sdk.core.network.c a(String str, @Nullable Map<String, String> map, boolean z, boolean z2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            if (z2) {
                a(builderUrl);
            }
            a(builderUrl, map);
            Response responseExecute = Jx().newCall(builderUrl.build()).execute();
            int iCode = responseExecute.code();
            cVar.code = iCode;
            cVar.aIU = iCode;
            cVar.aIW = z ? a(responseExecute) : "";
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    private static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBodyBuild;
        if (map == null || map.isEmpty()) {
            formBodyBuild = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            formBodyBuild = builder2.build();
        }
        if (builder == null || formBodyBuild == null) {
            return;
        }
        builder.post(formBodyBuild);
    }

    public static com.kwad.sdk.core.network.c doGet(String str, @Nullable Map<String, String> map) {
        return a(str, map, true, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            a(builderUrl);
            a(builderUrl, map);
            a(builderUrl, jSONObject);
            Response responseExecute = Jx().newCall(builderUrl.build()).execute();
            int iCode = responseExecute.code();
            cVar.code = iCode;
            cVar.aIU = iCode;
            cVar.aIW = a(responseExecute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j, boolean z, @Nullable AdHttpResponseListener adHttpResponseListener) throws Throwable {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder builderUrl = new Request.Builder().url(str);
        HashMap map = new HashMap();
        map.put(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN");
        if (z) {
            map.put("Connection", "keep-alive");
        } else {
            map.put("Connection", "close");
        }
        map.put("Charset", "UTF-8");
        a(builderUrl);
        a(builderUrl, map);
        Response responseExecute = Jx().newCall(builderUrl.build()).execute();
        int iCode = responseExecute.code();
        cVar.code = iCode;
        cVar.aIU = iCode;
        if (responseExecute.code() != 200) {
            throw new FileNotFoundException(str);
        }
        a(responseExecute, outputStream, j, adHttpResponseListener);
        return true;
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return "";
        }
    }

    private static long b(Response response) {
        try {
            return Long.parseLong(response.header("content-length"));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", p.getUserAgent());
        builder.addHeader("BrowserUa", p.Ju());
        builder.addHeader("SystemUa", p.Jt());
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder builderUrl = new Request.Builder().url(str);
            a(builderUrl);
            a(builderUrl, map);
            b(builderUrl, map2);
            Response responseExecute = Jx().newCall(builderUrl.build()).execute();
            int iCode = responseExecute.code();
            cVar.code = iCode;
            cVar.aIU = iCode;
            cVar.aIW = a(responseExecute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.aIV = exc;
        if (cVar.aIU == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = aJZ.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.aIU = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            e eVar = e.aIX;
            cVar.code = eVar.errorCode;
            cVar.aIW = eVar.msg;
        } else {
            cVar.code = e.aIY.errorCode;
            cVar.aIW = e.aIY.msg + "/" + bw.r(exc);
        }
        if (com.kwad.framework.a.a.oy.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(exc);
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            final MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.a.c.1
                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3) {
                        type.addFormDataPart(str2, str3);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3, String str4, byte[] bArr) {
                        type.addFormDataPart(str2, str3, RequestBody.create(MediaType.parse(str4), bArr));
                    }
                });
            }
            Request.Builder builderPost = new Request.Builder().url(str).post(type.build());
            a(builderPost, map);
            Response responseExecute = Jx().newCall(builderPost.build()).execute();
            int iCode = responseExecute.code();
            cVar.code = iCode;
            cVar.aIU = iCode;
            cVar.aIW = a(responseExecute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    private static void a(Request.Builder builder, @Nullable Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033 A[Catch: all -> 0x006e, TRY_LEAVE, TryCatch #4 {all -> 0x006e, blocks: (B:4:0x000e, B:6:0x0016, B:7:0x001a, B:9:0x0020, B:14:0x0033), top: B:46:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[Catch: all -> 0x0065, LOOP:1: B:40:0x004a->B:21:0x0050, LOOP_END, TRY_LEAVE, TryCatch #1 {all -> 0x0065, blocks: (B:19:0x004a, B:21:0x0050), top: B:40:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Response response) throws Throwable {
        InputStream inputStreamByteStream;
        InputStream inputStream;
        ?? inputStreamReader;
        boolean z;
        InputStream gZIPInputStream;
        BufferedReader bufferedReader;
        String line;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            inputStreamByteStream = response.body().byteStream();
        } catch (Throwable th) {
            th = th;
            inputStreamByteStream = null;
            inputStream = null;
        }
        try {
            List<String> listHeaders = response.headers("Content-Encoding");
            if (listHeaders != null) {
                Iterator<String> it = listHeaders.iterator();
                while (it.hasNext()) {
                    if (Constants.CP_GZIP.equalsIgnoreCase(it.next())) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (z) {
                    inputStream = null;
                    gZIPInputStream = inputStreamByteStream;
                } else {
                    gZIPInputStream = new GZIPInputStream(inputStreamByteStream);
                    inputStream = gZIPInputStream;
                }
                try {
                    inputStreamReader = new InputStreamReader(gZIPInputStream, aKa);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader, 8);
                        while (true) {
                            try {
                                line = bufferedReader.readLine();
                                if (line == null) {
                                    sb.append(line);
                                } else {
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                                    return sb.toString();
                                }
                            } catch (Throwable th2) {
                                bufferedReader2 = bufferedReader;
                                th = th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = 0;
                }
            } else {
                z = false;
                if (z) {
                }
                inputStreamReader = new InputStreamReader(gZIPInputStream, aKa);
                bufferedReader = new BufferedReader(inputStreamReader, 8);
                while (true) {
                    line = bufferedReader.readLine();
                    if (line == null) {
                    }
                    sb.append(line);
                }
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            inputStreamReader = inputStream;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
        com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) inputStreamReader);
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
        throw th;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #3 {all -> 0x009f, blocks: (B:4:0x0010, B:6:0x0020, B:7:0x0024, B:9:0x002a, B:14:0x003d), top: B:55:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[Catch: all -> 0x0096, LOOP:1: B:21:0x0056->B:62:?, LOOP_START, PHI: r12
      0x0056: PHI (r12v3 long) = (r12v0 long), (r12v4 long) binds: [B:20:0x0054, B:62:?] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x0096, blocks: (B:19:0x004d, B:21:0x0056, B:23:0x005c, B:28:0x006a, B:29:0x0070, B:32:0x0078, B:33:0x007b, B:37:0x0086), top: B:52:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(Response response, OutputStream outputStream, long j, AdHttpResponseListener adHttpResponseListener) throws Throwable {
        Throwable th;
        Closeable closeable;
        InputStream inputStreamByteStream;
        InputStream inputStream;
        boolean z;
        InputStream gZIPInputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        try {
            AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
            inputStreamByteStream = response.body().byteStream();
            try {
                List<String> listHeaders = response.headers("Content-Encoding");
                long jB = b(response);
                if (listHeaders != null) {
                    Iterator<String> it = listHeaders.iterator();
                    while (it.hasNext()) {
                        if (Constants.CP_GZIP.equalsIgnoreCase(it.next())) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (z) {
                        inputStream = null;
                        gZIPInputStream = inputStreamByteStream;
                    } else {
                        gZIPInputStream = new GZIPInputStream(inputStreamByteStream);
                        inputStream = gZIPInputStream;
                    }
                    try {
                        bufferedInputStream = new BufferedInputStream(gZIPInputStream);
                        try {
                            byte[] bArr = new byte[1024];
                            long j2 = 0;
                            if (j <= 0) {
                                do {
                                    int i = bufferedInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    j2 += (long) i;
                                    AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, jB);
                                } while (j2 <= j);
                            } else if (j < 0) {
                                bufferedOutputStream = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                                do {
                                    int i2 = bufferedInputStream.read(bArr);
                                    if (i2 == -1) {
                                        break;
                                    }
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.write(bArr, 0, i2);
                                    }
                                    j2 += (long) i2;
                                } while (!AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, jB));
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.flush();
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                            return true;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = null;
                            bufferedInputStream2 = bufferedInputStream;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = null;
                    }
                } else {
                    z = false;
                    if (z) {
                    }
                    bufferedInputStream = new BufferedInputStream(gZIPInputStream);
                    byte[] bArr2 = new byte[1024];
                    long j22 = 0;
                    if (j <= 0) {
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
                    return true;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                inputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            inputStreamByteStream = null;
            inputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamByteStream);
        throw th;
    }
}
