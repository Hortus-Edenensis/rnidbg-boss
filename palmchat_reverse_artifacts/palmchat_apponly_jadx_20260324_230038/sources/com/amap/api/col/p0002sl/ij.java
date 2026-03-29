package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f2907a = 1000;
    static boolean b = false;
    static int c = 20;
    static int d = 0;
    private static WeakReference<ig> e = null;
    private static int f = 10;

    public static synchronized void a(int i, boolean z, int i2, int i3) {
        f2907a = i;
        b = z;
        if (i2 < 10 || i2 > 100) {
            i2 = 20;
        }
        c = i2;
        if (i2 / 5 > f) {
            f = i2 / 5;
        }
        d = i3;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends jd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2908a;
        private Context b;
        private ii c;

        public a(Context context, int i) {
            this.b = context;
            this.f2908a = i;
        }

        @Override // com.amap.api.col.p0002sl.jd
        public final void a() {
            int i = this.f2908a;
            if (i == 1) {
                try {
                    synchronized (ij.class) {
                        String string = Long.toString(System.currentTimeMillis());
                        ig igVarA = im.a(ij.e);
                        im.a(this.b, igVarA, hb.i, ij.f2907a, 2097152, "6");
                        if (igVarA.e == null) {
                            igVarA.e = new hp(new hr(new hs(new hr())));
                        }
                        ih.a(string, this.c.a(), igVarA);
                    }
                    return;
                } catch (Throwable th) {
                    hd.c(th, "ofm", "aple");
                    return;
                }
            }
            if (i == 2) {
                try {
                    ig igVarA2 = im.a(ij.e);
                    im.a(this.b, igVarA2, hb.i, ij.f2907a, 2097152, "6");
                    igVarA2.h = 14400000;
                    if (igVarA2.g == null) {
                        igVarA2.g = new iq(new ip(this.b, new iu(), new hp(new hr(new hs())), new String(go.a()), fr.f(this.b), fv.k(), fv.h(), fv.f(this.b), fv.a(), Build.MANUFACTURER, Build.DEVICE, fv.n(), fr.c(this.b), Build.MODEL, fr.d(this.b), fr.b(this.b), fv.e(this.b), fv.a(this.b), String.valueOf(Build.VERSION.SDK_INT), gk.a(this.b).a()));
                    }
                    if (TextUtils.isEmpty(igVarA2.i)) {
                        igVarA2.i = "fKey";
                    }
                    Context context = this.b;
                    igVarA2.f = new iy(context, igVarA2.h, igVarA2.i, new iw(context, ij.b, ij.f * 1024, ij.c * 1024, "offLocKey", ij.d * 1024));
                    ih.a(igVarA2);
                } catch (Throwable th2) {
                    hd.c(th2, "ofm", "uold");
                }
            }
        }

        public a(Context context, ii iiVar) {
            this(context, 1);
            this.c = iiVar;
        }
    }

    public static synchronized void a(ii iiVar, Context context) {
        jc.a().b(new a(context, iiVar));
    }

    public static void a(Context context) {
        jc.a().b(new a(context, 2));
    }
}
