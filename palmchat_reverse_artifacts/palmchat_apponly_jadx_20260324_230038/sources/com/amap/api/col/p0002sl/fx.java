package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile b f2809a = new b(0);
    private hm b = new hm("HttpsDecisionUtil");

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static fx f2810a = new fx();
    }

    public static fx a() {
        return a.f2810a;
    }

    private static boolean c() {
        return false;
    }

    public final boolean b() {
        if (this.f2809a == null) {
            this.f2809a = new b((byte) 0);
        }
        return this.f2809a.a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f2811a;
        private int b;
        private final boolean c;
        private boolean d;

        private b() {
            this.b = 0;
            this.f2811a = true;
            this.c = true;
            this.d = false;
        }

        public final void a(Context context) {
            if (context != null && this.b <= 0) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z) {
            this.d = z;
        }

        public final void a(boolean z) {
            this.f2811a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a() {
            boolean z;
            if (!this.d) {
                boolean z2 = Build.VERSION.SDK_INT >= 28;
                if (this.f2811a) {
                    int i = this.b;
                    if (i <= 0) {
                        i = 28;
                    }
                    if (!(i >= 28)) {
                        z = false;
                    }
                    if (z2) {
                        if (!z2 && z) {
                        }
                    }
                } else {
                    z = true;
                    if (!z2 && z) {
                        return false;
                    }
                }
            }
            return true;
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public final void a(Context context) {
        if (this.f2809a == null) {
            this.f2809a = new b((byte) 0);
        }
        this.f2809a.a(hm.a(context, "open_common", "a3", true));
        this.f2809a.a(context);
        gp.a(context).a();
    }

    private static void b(Context context, boolean z) {
        SharedPreferences.Editor editorA = hm.a(context, "open_common");
        hm.a(editorA, "a3", z);
        hm.a(editorA);
    }

    public final boolean b(boolean z) {
        if (c()) {
            return false;
        }
        return z || b();
    }

    public static void b(Context context) {
        b(context, true);
    }

    public final void a(boolean z) {
        if (this.f2809a == null) {
            this.f2809a = new b((byte) 0);
        }
        this.f2809a.b(z);
    }

    public final void a(Context context, boolean z) {
        if (this.f2809a == null) {
            this.f2809a = new b((byte) 0);
        }
        b(context, z);
        this.f2809a.a(z);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith(BaseConstants.SCHEME_HTTPS)) {
            return str;
        }
        try {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.scheme(BaseConstants.SCHEME_HTTPS);
            return builderBuildUpon.build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
