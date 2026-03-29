package a.a.b.a.a;

import a.a.a.a.a.a.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final f b;
    public static final String c;
    public static f d;
    public static volatile long e;
    public static final a f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0002a f1070a = new C0002a(false, 200);

    /* JADX INFO: renamed from: a.a.b.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0002a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1071a;
        public final long b;

        public C0002a() {
            this(false, 0L, 3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0002a)) {
                return false;
            }
            C0002a c0002a = (C0002a) obj;
            return this.f1071a == c0002a.f1071a && this.b == c0002a.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z = this.f1071a;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            long j = this.b;
            return (r0 * 31) + ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            return "INodeConfig(enable=" + this.f1071a + ", timeout=" + this.b + ")";
        }

        public C0002a(boolean z, long j) {
            this.f1071a = z;
            this.b = j;
        }

        public /* synthetic */ C0002a(boolean z, long j, int i) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 200L : j);
        }
    }

    static {
        f fVar = new f(false, null, null, null, 15);
        b = fVar;
        c = "https://lf-event-manager.oceanengine.com/obj/oceanus-project/android_sdk_conf.json";
        d = fVar;
        e = -1L;
    }
}
