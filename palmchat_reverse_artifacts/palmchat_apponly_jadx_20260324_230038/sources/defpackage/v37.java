package defpackage;

import android.annotation.TargetApi;
import android.os.Debug;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class v37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21349a = new c();

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public b() {
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            throw null;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            throw null;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(19)
    public static class c extends b {
        public c() {
            super();
        }

        @Override // v37.b
        public int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // v37.b
        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // v37.b
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return f21349a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return f21349a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return f21349a.c(memoryInfo);
    }
}
