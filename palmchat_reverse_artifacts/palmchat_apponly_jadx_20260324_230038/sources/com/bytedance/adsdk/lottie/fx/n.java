package com.bytedance.adsdk.lottie.fx;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.lottie.l;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class n {
    private final iz nr;
    private final x u;

    public n(x xVar, iz izVar) {
        this.u = xVar;
        this.nr = izVar;
    }

    @WorkerThread
    private l<com.bytedance.adsdk.lottie.iz> fx(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.pn.pn.u("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                b bVarU = this.nr.u(str);
                if (!bVarU.u()) {
                    l<com.bytedance.adsdk.lottie.iz> lVar = new l<>(new IllegalArgumentException(bVarU.b()));
                    try {
                        bVarU.close();
                    } catch (IOException e) {
                        com.bytedance.adsdk.lottie.pn.pn.u("LottieFetchResult close failed ", e);
                    }
                    return lVar;
                }
                l<com.bytedance.adsdk.lottie.iz> lVarU = u(context, str, bVarU.nr(), bVarU.fx(), str2);
                StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                sb.append(lVarU.u() != null);
                com.bytedance.adsdk.lottie.pn.pn.u(sb.toString());
                try {
                    bVarU.close();
                } catch (IOException e2) {
                    com.bytedance.adsdk.lottie.pn.pn.u("LottieFetchResult close failed ", e2);
                }
                return lVarU;
            } catch (Exception e3) {
                l<com.bytedance.adsdk.lottie.iz> lVar2 = new l<>(e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e4) {
                        com.bytedance.adsdk.lottie.pn.pn.u("LottieFetchResult close failed ", e4);
                    }
                }
                return lVar2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    com.bytedance.adsdk.lottie.pn.pn.u("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    @WorkerThread
    private com.bytedance.adsdk.lottie.iz nr(Context context, String str, String str2) {
        x xVar;
        Pair<fx, InputStream> pairU;
        if (str2 == null || (xVar = this.u) == null || (pairU = xVar.u(str)) == null) {
            return null;
        }
        fx fxVar = (fx) pairU.first;
        InputStream inputStream = (InputStream) pairU.second;
        l<com.bytedance.adsdk.lottie.iz> lVarU = fxVar == fx.ZIP ? com.bytedance.adsdk.lottie.x.u(context, new ZipInputStream(inputStream), str2) : com.bytedance.adsdk.lottie.x.nr(inputStream, str2);
        if (lVarU.u() != null) {
            return lVarU.u();
        }
        return null;
    }

    @WorkerThread
    public l<com.bytedance.adsdk.lottie.iz> u(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.iz izVarNr = nr(context, str, str2);
        if (izVarNr != null) {
            return new l<>(izVarNr);
        }
        com.bytedance.adsdk.lottie.pn.pn.u("Animation for " + str + " not found in cache. Fetching from network.");
        return fx(context, str, str2);
    }

    private l<com.bytedance.adsdk.lottie.iz> u(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        l<com.bytedance.adsdk.lottie.iz> lVarU;
        fx fxVar;
        x xVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            com.bytedance.adsdk.lottie.pn.pn.u("Received json response.");
            fxVar = fx.JSON;
            lVarU = u(str, inputStream, str3);
        } else {
            com.bytedance.adsdk.lottie.pn.pn.u("Handling zip response.");
            fx fxVar2 = fx.ZIP;
            lVarU = u(context, str, inputStream, str3);
            fxVar = fxVar2;
        }
        if (str3 != null && lVarU.u() != null && (xVar = this.u) != null) {
            xVar.u(str, fxVar);
        }
        return lVarU;
    }

    private l<com.bytedance.adsdk.lottie.iz> u(Context context, String str, InputStream inputStream, String str2) throws IOException {
        x xVar;
        if (str2 != null && (xVar = this.u) != null) {
            return com.bytedance.adsdk.lottie.x.u(context, new ZipInputStream(new FileInputStream(xVar.u(str, inputStream, fx.ZIP))), str);
        }
        return com.bytedance.adsdk.lottie.x.u(context, new ZipInputStream(inputStream), (String) null);
    }

    private l<com.bytedance.adsdk.lottie.iz> u(String str, InputStream inputStream, String str2) throws IOException {
        x xVar;
        if (str2 != null && (xVar = this.u) != null) {
            return com.bytedance.adsdk.lottie.x.nr(new FileInputStream(xVar.u(str, inputStream, fx.JSON).getAbsolutePath()), str);
        }
        return com.bytedance.adsdk.lottie.x.nr(inputStream, (String) null);
    }
}
