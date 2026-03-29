package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class c32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1886a;
    public final int b;
    public final float c;
    public final long d;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1887a;
        public int b;
        public float c = 1.0f;
        public long d;

        public b(int i, int i2) {
            this.f1887a = i;
            this.b = i2;
        }

        public c32 a() {
            return new c32(this.f1887a, this.b, this.c, this.d);
        }

        public b b(float f) {
            this.c = f;
            return this;
        }
    }

    public c32(int i, int i2, float f, long j) {
        vh.b(i > 0, "width must be positive, but is: " + i);
        vh.b(i2 > 0, "height must be positive, but is: " + i2);
        this.f1886a = i;
        this.b = i2;
        this.c = f;
        this.d = j;
    }
}
