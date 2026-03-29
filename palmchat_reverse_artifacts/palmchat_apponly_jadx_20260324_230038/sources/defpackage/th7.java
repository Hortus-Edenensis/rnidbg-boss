package defpackage;

import android.annotation.TargetApi;
import android.app.ActivityManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class th7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20992a = new c();

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public b() {
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(16)
    public static class c extends b {
        public c() {
            super();
        }

        @Override // th7.b
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return f20992a.a(memoryInfo);
    }
}
