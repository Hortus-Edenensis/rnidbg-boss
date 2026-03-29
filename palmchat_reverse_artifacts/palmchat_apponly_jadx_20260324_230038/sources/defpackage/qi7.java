package defpackage;

import android.annotation.TargetApi;
import android.os.Debug;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class qi7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f20259a = new b();

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(19)
    public static class b extends c {
        public b() {
            super();
        }

        @Override // qi7.c
        public int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }

        @Override // qi7.c
        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // qi7.c
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {
        public c() {
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

    public static int a(Debug.MemoryInfo memoryInfo) {
        return f20259a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return f20259a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return f20259a.c(memoryInfo);
    }
}
