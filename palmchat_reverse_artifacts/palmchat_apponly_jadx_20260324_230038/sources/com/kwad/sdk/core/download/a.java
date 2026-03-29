package com.kwad.sdk.core.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.efs.sdk.base.Constants;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.be;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* JADX INFO: renamed from: com.kwad.sdk.core.download.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0607a {
    }

    @Nullable
    public static String I(AdInfo adInfo) {
        return dW(DownloadParams.transform(adInfo).mFileUrl);
    }

    public static void J(@NonNull AdInfo adInfo) {
        a(adInfo, false);
    }

    private static void a(@NonNull AdInfo adInfo, boolean z) {
        try {
            Context context = mContext;
            if (context == null) {
                return;
            }
            if (!ao.isNetworkConnected(context)) {
                Context context2 = mContext;
                ac.S(context2, ae.cY(context2));
                return;
            }
            DownloadParams downloadParamsTransform = DownloadParams.transform(adInfo);
            downloadParamsTransform.requestInstallPermission = false;
            String str = downloadParamsTransform.mFileUrl;
            if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(downloadParamsTransform.mFileUrl);
                downloadRequest.setDestinationFileName(dX(str));
                downloadRequest.setTag(downloadParamsTransform);
                downloadRequest.setDownloadEnablePause(downloadParamsTransform.downloadEnablePause);
                if (ServiceProvider.getSDKConfig().showNotification && bF(mContext)) {
                    downloadRequest.setNotificationVisibility(3);
                } else {
                    downloadRequest.setNotificationVisibility(0);
                }
                com.kwad.sdk.d.a.a(mContext, downloadParamsTransform.mDownloadid, downloadRequest);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized void bE(Context context) {
        if (context != null) {
            if (!mHasInit) {
                mContext = context;
                com.kwad.sdk.c.Ce().init(context);
                b.IL().init(context);
                mHasInit = true;
            }
        }
    }

    private static boolean bF(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean d(String str, File file) {
        try {
            return a(str, file, null, false);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String dW(String str) {
        if (mContext == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return be.dR(mContext) + File.separator + dX(str);
    }

    private static String dX(String str) {
        return al.md5(str) + com.huawei.hms.ads.dynamicloader.b.b;
    }

    public static void dY(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.d.a.G(mContext, str);
    }

    public static void dZ(String str) {
        if (mContext == null) {
            return;
        }
        String strDW = dW(str);
        com.kwad.sdk.d.a.e(mContext, al.md5(str), strDW);
    }

    private static URLConnection ea(String str) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        r.wrapHttpURLConnection(uRLConnectionOpenConnection);
        uRLConnectionOpenConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN");
        uRLConnectionOpenConnection.setConnectTimeout(10000);
        uRLConnectionOpenConnection.setReadTimeout(120000);
        uRLConnectionOpenConnection.setUseCaches(false);
        uRLConnectionOpenConnection.setDoInput(true);
        uRLConnectionOpenConnection.setRequestProperty("Connection", "keep-alive");
        uRLConnectionOpenConnection.setRequestProperty("Charset", "UTF-8");
        return uRLConnectionOpenConnection;
    }

    public static void a(String str, File file, boolean z) {
        a(str, file, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0115 A[Catch: all -> 0x013f, TryCatch #8 {all -> 0x013f, blocks: (B:58:0x0111, B:60:0x0115, B:62:0x013e, B:61:0x0118), top: B:86:0x0111 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0118 A[Catch: all -> 0x013f, TryCatch #8 {all -> 0x013f, blocks: (B:58:0x0111, B:60:0x0115, B:62:0x013e, B:61:0x0118), top: B:86:0x0111 }] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.File] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, File file, InterfaceC0607a interfaceC0607a, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        ?? file2;
        HashMap map;
        int i;
        InputStream bufferedInputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) ea(str);
            try {
                if (z) {
                    long length = file.length();
                    fileOutputStream = new FileOutputStream(file, true);
                    if (length > 0) {
                        try {
                            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, String.format("bytes=%s-%s", Long.valueOf(length), ""));
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = null;
                            file2 = fileOutputStream2;
                            try {
                                if (th instanceof IOException) {
                                }
                            } catch (Throwable th2) {
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                if (file2 != 0) {
                                    file2.delete();
                                }
                                throw th2;
                            }
                        }
                    }
                } else {
                    fileOutputStream = new FileOutputStream(file, false);
                }
                p.b(httpURLConnection);
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
                InputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    int contentLength = httpURLConnection.getContentLength();
                    if (httpURLConnection.getHeaderFields() == null) {
                        map = new HashMap();
                    } else {
                        map = new HashMap(httpURLConnection.getHeaderFields());
                    }
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(httpURLConnection.getInputStream());
                    try {
                        bufferedInputStream2 = a(map, bufferedInputStream3);
                        if (contentLength <= 0) {
                            Random random = new Random(System.currentTimeMillis());
                            file2 = new File(be.dS(mContext), random.nextInt() + ".tmp");
                            try {
                                fileOutputStream2 = new FileOutputStream((File) file2);
                                try {
                                    byte[] bArr = new byte[8192];
                                    i = 0;
                                    while (true) {
                                        int i2 = bufferedInputStream2.read(bArr);
                                        if (i2 == -1) {
                                            break;
                                        }
                                        i += i2;
                                        fileOutputStream2.write(bArr, 0, i2);
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                    bufferedInputStream = new BufferedInputStream(new FileInputStream((File) file2));
                                } catch (Throwable th3) {
                                    bufferedInputStream = bufferedInputStream2;
                                    th = th3;
                                    if (th instanceof IOException) {
                                        throw th;
                                    }
                                    throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream2 = null;
                                file2 = file2;
                                bufferedInputStream = bufferedInputStream2;
                                th = th;
                                if (th instanceof IOException) {
                                }
                            }
                            try {
                                map.put("Content-Length", Collections.singletonList(String.valueOf(i)));
                                file2 = file2;
                            } catch (Throwable th5) {
                                th = th5;
                                if (th instanceof IOException) {
                                }
                            }
                        } else {
                            fileOutputStream2 = null;
                            file2 = 0;
                            bufferedInputStream = bufferedInputStream2;
                        }
                        byte[] bArr2 = new byte[8192];
                        while (true) {
                            int i3 = bufferedInputStream.read(bArr2);
                            if (i3 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr2, 0, i3);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        httpURLConnection.disconnect();
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                        if (file2 != 0) {
                            file2.delete();
                        }
                        return true;
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream2 = null;
                        file2 = 0;
                        bufferedInputStream = bufferedInputStream3;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream2 = null;
                    file2 = 0;
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
                fileOutputStream2 = fileOutputStream;
                file2 = fileOutputStream2;
                if (th instanceof IOException) {
                }
            }
        } catch (Throwable th9) {
            th = th9;
            httpURLConnection = null;
            fileOutputStream = null;
        }
    }

    private static InputStream a(Map<String, List<String>> map, InputStream inputStream) {
        List<String> value;
        boolean z;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                Iterator<String> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (Constants.CP_GZIP.equalsIgnoreCase(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    try {
                        return new GZIPInputStream(inputStream);
                    } catch (IOException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return inputStream;
    }
}
