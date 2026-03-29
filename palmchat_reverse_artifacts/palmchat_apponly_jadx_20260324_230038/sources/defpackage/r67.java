package defpackage;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class r67 {
    public static volatile r67 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f20404a;

    public static r67 a() {
        if (b == null) {
            synchronized (r67.class) {
                if (b == null) {
                    b = new r67();
                }
            }
        }
        return b;
    }

    public synchronized Long b(String str, Long l) {
        synchronized (this) {
        }
        if (!this.f20404a.contains(str)) {
            return l;
        }
        return Long.valueOf(this.f20404a.getLong(str, 0L));
    }

    public synchronized String c(String str, String str2) {
        synchronized (this) {
        }
        if (!this.f20404a.contains(str)) {
            return str2;
        }
        return this.f20404a.getString(str, null);
    }

    public synchronized void d(String str, long j) {
        this.f20404a.edit().putLong(str, j).apply();
    }

    public synchronized void e(String str, String str2) {
        this.f20404a.edit().putString(str, str2).apply();
    }
}
