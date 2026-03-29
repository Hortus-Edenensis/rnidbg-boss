package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.ex;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.b.a.b> aSp = new ConcurrentHashMap();
    private static final Map<String, String> aSq = new ConcurrentHashMap();

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.h.a.b bVar, b.a aVar, boolean z) throws Throwable {
        com.kwad.sdk.core.webview.b.a.b bVarA;
        try {
            bVarA = a(context, bVar, str, aVar);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e);
            bVarA = null;
        }
        if (bVarA == null) {
            b(z, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVarA.aSx)) {
            b(z, "getResource [" + str + "] getFilePath from url fail");
            aVar.msg = "getFilePath from url fail";
            return null;
        }
        if (!com.kwad.sdk.core.webview.b.c.c.fw(bVarA.aSt)) {
            b(z, "mimetype为: " + bVarA.aSt + "不在拦截范围的文件");
            aVar.msg = "mimetype为: " + bVarA.aSt + "不在拦截范围的文件";
            return null;
        }
        BufferedInputStream bufferedInputStreamHf = w.hf(bVarA.aSx);
        if (bufferedInputStreamHf != null) {
            return a(bufferedInputStreamHf, bVarA);
        }
        b(z, "getResource [" + str + "] inputStream is null");
        StringBuilder sb = new StringBuilder("inputStream is null,本地加载路径：");
        sb.append(bVarA.aSx);
        aVar.msg = sb.toString();
        return null;
    }

    private static String ad(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void ae(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        aSq.put(str, str2);
    }

    private static void b(boolean z, String str) {
        if (z) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    private static com.kwad.sdk.core.webview.b.a.b fo(String str) {
        return aSp.get(String.valueOf(str.hashCode()));
    }

    private static String fp(String str) {
        return aSq.get(str);
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.aSt;
        HashMap map = new HashMap();
        map.put("Access-Control-Allow-Origin", bVar.aSw.aSr);
        map.put("Access-Control-Allow-Credentials", ex.Code);
        map.put("Timing-Allow-Origin", bVar.aSw.aSs);
        map.put("content-type", str);
        map.put("Date", bVar.aSw.aSu);
        map.put("union-cache ", "1");
        return new WebResourceResponse(bVar.aSt, "", bVar.status, "OK", map, inputStream);
    }

    private static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.h.a.b bVar, String str, b.a aVar) throws Throwable {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String strFp = fp(bVar.aWm);
            com.kwad.sdk.core.webview.b.a.b bVarFo = !TextUtils.isEmpty(strFp) ? fo(ad(strFp, str)) : null;
            if (bVarFo != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return bVarFo;
            }
            String strM = com.kwad.sdk.core.webview.b.c.a.M(context, bVar.aWn);
            if (strM == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(strM);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + strM;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
                try {
                    String strB = h.b(inputStreamReader);
                    if (TextUtils.isEmpty(strB)) {
                        aVar.msg = "获取配置文件失败 mainfest文件不存在";
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(strB);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        com.kwad.sdk.core.webview.b.a.b bVar2 = new com.kwad.sdk.core.webview.b.a.b();
                        bVar2.parseJson(jSONObject2);
                        String host = Uri.parse("https://" + next).getHost();
                        bVar2.aSy = host;
                        bVar2.aSx = com.kwad.sdk.core.webview.b.c.a.L(context, bVar.aWn) + "/" + next;
                        if (TextUtils.isEmpty(bVar2.aSt)) {
                            bVar2.aSt = URLConnection.getFileNameMap().getContentTypeFor(bVar2.aSx);
                        }
                        a(next, bVar2);
                        strFp = host;
                    }
                    ae(bVar.aWm, strFp);
                    com.kwad.sdk.core.webview.b.a.b bVarFo2 = fo(ad(strFp, str));
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return bVarFo2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        aSp.put(String.valueOf(str.hashCode()), bVar);
    }
}
