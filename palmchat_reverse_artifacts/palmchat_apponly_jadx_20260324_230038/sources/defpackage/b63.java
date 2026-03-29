package defpackage;

import com.zenmen.palmchat.Vo.LogConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b63 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LogConfig f1655a = new LogConfig();
    public static b63 b;

    public static b63 a() {
        if (b == null) {
            synchronized (b63.class) {
                if (b == null) {
                    b = new b63();
                }
            }
        }
        return b;
    }

    public static void c(LogConfig logConfig) {
        f1655a = logConfig;
    }

    public LogConfig b() {
        return f1655a;
    }
}
