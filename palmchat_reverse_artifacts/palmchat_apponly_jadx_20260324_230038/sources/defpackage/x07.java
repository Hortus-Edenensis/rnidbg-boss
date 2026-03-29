package defpackage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f21852a = -30000;
    public static File b;

    public static String a(long j, String str) {
        try {
            return re7.y(new File(wi7.E(x97.m()), "apmlite/TrackInfo/" + ((j - (j % 86400000)) / 86400000) + "/" + str));
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static void b() {
        File file = new File(wi7.E(x97.m()), "apmlite/TrackInfo/");
        String[] list = file.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            for (int i = 0; i < list.length - 5; i++) {
                re7.r(new File(file, list[i]));
            }
        }
    }

    public static void c(long j) throws Throwable {
        if (j - f21852a < 30000) {
            return;
        }
        f21852a = j;
        try {
            re7.j(d(), String.valueOf(System.currentTimeMillis()), false);
        } catch (IOException unused) {
        }
    }

    public static File d() {
        if (b == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            b = new File(wi7.E(x97.m()), "apmlite/TrackInfo/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % 86400000)) / 86400000) + "/" + x97.l());
        }
        return b;
    }
}
