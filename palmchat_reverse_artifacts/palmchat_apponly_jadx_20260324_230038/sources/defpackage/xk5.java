package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xk5 {
    public static String a(long j) {
        if (j >= 1073741824) {
            return String.format("%.2f GB", Float.valueOf(j / 1073741824));
        }
        if (j >= 1048576) {
            float f = j / 1048576;
            return String.format(f > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f));
        }
        if (j < 1024) {
            return String.format("%d B", Long.valueOf(j));
        }
        float f2 = j / 1024;
        return String.format(f2 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f2));
    }
}
