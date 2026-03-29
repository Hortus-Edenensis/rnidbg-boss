package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.os.Trace;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.bytedance.adsdk.lottie.fx.iz f5004a = null;
    private static boolean b = true;
    private static boolean fx = true;
    private static long[] iz = null;
    private static com.bytedance.adsdk.lottie.fx.pn jk = null;
    private static volatile com.bytedance.adsdk.lottie.fx.x l = null;
    private static int n = 0;
    private static boolean nr = false;
    private static String[] pn = null;
    private static volatile com.bytedance.adsdk.lottie.fx.n t = null;
    public static boolean u = false;
    private static int x;

    public static float nr(String str) {
        int i = n;
        if (i > 0) {
            n = i - 1;
            return 0.0f;
        }
        if (!nr) {
            return 0.0f;
        }
        int i2 = x - 1;
        x = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(pn[i2])) {
            Trace.endSection();
            return (System.nanoTime() - iz[x]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + pn[x] + ".");
    }

    public static void u(String str) {
        if (nr) {
            int i = x;
            if (i == 20) {
                n++;
                return;
            }
            pn[i] = str;
            iz[i] = System.nanoTime();
            Trace.beginSection(str);
            x++;
        }
    }

    public static com.bytedance.adsdk.lottie.fx.n u(Context context) {
        com.bytedance.adsdk.lottie.fx.n nVar = t;
        if (nVar == null) {
            synchronized (com.bytedance.adsdk.lottie.fx.n.class) {
                nVar = t;
                if (nVar == null) {
                    com.bytedance.adsdk.lottie.fx.x xVarNr = nr(context);
                    com.bytedance.adsdk.lottie.fx.iz nrVar = f5004a;
                    if (nrVar == null) {
                        nrVar = new com.bytedance.adsdk.lottie.fx.nr();
                    }
                    nVar = new com.bytedance.adsdk.lottie.fx.n(xVarNr, nrVar);
                    t = nVar;
                }
            }
        }
        return nVar;
    }

    public static com.bytedance.adsdk.lottie.fx.x nr(Context context) {
        if (!fx) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.lottie.fx.x xVar = l;
        if (xVar == null) {
            synchronized (com.bytedance.adsdk.lottie.fx.x.class) {
                xVar = l;
                if (xVar == null) {
                    com.bytedance.adsdk.lottie.fx.pn pnVar = jk;
                    if (pnVar == null) {
                        pnVar = new com.bytedance.adsdk.lottie.fx.pn() { // from class: com.bytedance.adsdk.lottie.pn.1
                            @Override // com.bytedance.adsdk.lottie.fx.pn
                            public File u() {
                                return new File(com.bytedance.sdk.openadsdk.api.plugin.nr.nr(applicationContext), "lottie_network_cache");
                            }
                        };
                    }
                    xVar = new com.bytedance.adsdk.lottie.fx.x(pnVar);
                    l = xVar;
                }
            }
        }
        return xVar;
    }

    public static boolean u() {
        return b;
    }
}
