package defpackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class pc0 {
    public static String a(long j) {
        return j <= 0 ? "" : new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(new Date(j));
    }

    public static String b(long j) {
        return j <= 0 ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date(j));
    }

    public static long c(int i, int i2, int i3, int i4, int i5) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).parse("" + i + "-" + i2 + "-" + i3 + " " + i4 + ":" + i5).getTime();
        } catch (Exception unused) {
            return 0L;
        }
    }
}
