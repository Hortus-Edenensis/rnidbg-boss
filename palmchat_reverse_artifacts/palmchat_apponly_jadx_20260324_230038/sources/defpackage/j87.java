package defpackage;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class j87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f18345a = {null, null, null, null, null, null, null, null, null, null, "9.0", "9.5", "10.0", "10.5", null};

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f18346a = j87.d("ro.rom.version");
    }

    public static int a() {
        Log.v("BrandPBuild", " getOSVERSION " + a.f18346a);
        for (int length = f18345a.length + (-2); length >= 0; length--) {
            StringBuilder sb = new StringBuilder(" VERSIONS[ ");
            sb.append(length);
            sb.append("]");
            String[] strArr = f18345a;
            sb.append(strArr[length]);
            Log.v("BrandPBuild", sb.toString());
            String str = a.f18346a;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strArr[length])) {
                if (!str.startsWith(strArr[length])) {
                    if (!str.startsWith(hd7.p + strArr[length])) {
                        if (str.startsWith(hd7.q + strArr[length])) {
                        }
                    }
                }
                return length + 1;
            }
        }
        return 0;
    }

    public static String c() {
        return d("ro.rom.version");
    }

    public static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            if (!k17.k()) {
                return "unknown";
            }
            e.printStackTrace();
            return "unknown";
        }
    }
}
