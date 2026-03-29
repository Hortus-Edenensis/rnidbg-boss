package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class g57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17667a = false;

    public static void a(Exception exc) {
        if (f17667a) {
            Log.e("ZM_Exception", "", exc);
        }
    }

    public static void b(String str, String str2) {
        if (f17667a) {
            c(str, str2, null);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        String str3 = null;
        if (str2 != null) {
            try {
                byte[] bytes = str2.getBytes();
                int length = bytes.length;
                if (length <= 4000) {
                    Log.i(str, str2, th);
                    return;
                }
                int i = 0;
                while (i < length - 4000) {
                    int iMin = Math.min(i + 4000, bytes.length - 1);
                    int i2 = iMin;
                    while (true) {
                        if (i2 <= iMin - 4000) {
                            break;
                        }
                        if (bytes[i2] == 10) {
                            iMin = i2;
                            break;
                        }
                        i2--;
                    }
                    int i3 = iMin - i;
                    Log.i(str, new String(bytes, i, i3), null);
                    if (i3 < 4000) {
                        iMin++;
                    }
                    i = iMin;
                }
                if (length <= i) {
                    return;
                } else {
                    str3 = new String(bytes, i, length - i);
                }
            } catch (Exception e) {
                a(e);
                return;
            }
        }
        Log.d(str, str3, th);
    }

    public static void d(String str, Throwable th) {
        if (f17667a) {
            c(str, "", th);
        }
    }
}
