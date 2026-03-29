package defpackage;

import android.util.Log;
import java.util.logging.Level;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class vc implements o63 {
    public static final boolean b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21402a;

    static {
        boolean z;
        try {
            Class.forName("android.util.Log");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        b = z;
    }

    public vc(String str) {
        this.f21402a = str;
    }

    public static boolean c() {
        return b;
    }

    @Override // defpackage.o63
    public void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(d(level), this.f21402a, str);
        }
    }

    @Override // defpackage.o63
    public void b(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            Log.println(d(level), this.f21402a, str + "\n" + Log.getStackTraceString(th));
        }
    }

    public final int d(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            return iIntValue < 500 ? 2 : 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        return iIntValue < 1000 ? 5 : 6;
    }
}
