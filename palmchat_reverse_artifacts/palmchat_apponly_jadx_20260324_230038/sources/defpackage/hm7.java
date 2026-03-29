package defpackage;

import android.annotation.TargetApi;
import android.app.ActivityManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class hm7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17996a = new b();

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(16)
    public static class b extends c {
        public b() {
            super();
        }

        @Override // hm7.c
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {
        public c() {
        }

        public long a(ActivityManager.MemoryInfo memoryInfo) {
            throw null;
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return f17996a.a(memoryInfo);
    }
}
