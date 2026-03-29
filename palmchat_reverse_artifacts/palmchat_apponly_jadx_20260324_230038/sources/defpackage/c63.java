package defpackage;

import android.util.Log;
import com.zm.fissionsdk.WVVzW;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class c63 {
    public static boolean a(int i) {
        return i >= 2;
    }

    public static void b(String str, String str2, boolean z, int i, String str3, Throwable th) {
        try {
            if (tv2.e || i >= 5) {
                if ((tv2.f || !z || i >= 6) && a(i)) {
                    if (i == 2) {
                        Log.v("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        f63.d(WVVzW.b, str2, str3, null);
                    } else if (i == 3) {
                        Log.d("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        f63.d("DEBUG", str2, str3, null);
                    } else if (i == 4) {
                        Log.i("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        f63.d("INFO", str2, str3, null);
                    } else if (i == 5) {
                        Log.w("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        f63.d("WARN", str2, str3, null);
                    } else if (i == 6) {
                        Log.e("JIGUANG-" + str, "[" + str2 + "] " + str3);
                        f63.d("ERROR", str2, str3, null);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
