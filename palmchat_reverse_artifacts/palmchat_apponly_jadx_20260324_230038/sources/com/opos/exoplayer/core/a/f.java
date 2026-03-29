package com.opos.exoplayer.core.a;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface f {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends com.opos.exoplayer.core.util.b {
        public a(String str) {
            super(str);
        }

        @Override // com.opos.exoplayer.core.util.b
        public String a() {
            return "ConfigurationException";
        }

        public a(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.opos.exoplayer.core.util.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8098a;

        public b(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.f8098a = i;
        }

        @Override // com.opos.exoplayer.core.util.b
        public String a() {
            return "InitializationException";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();

        void a(int i);

        void a(int i, long j, long j2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends com.opos.exoplayer.core.util.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8099a;

        public d(int i) {
            super("AudioTrack write failed: " + i);
            this.f8099a = i;
        }

        @Override // com.opos.exoplayer.core.util.b
        public String a() {
            return "WriteException";
        }
    }

    long a(boolean z);

    com.opos.exoplayer.core.n a(com.opos.exoplayer.core.n nVar);

    void a();

    void a(float f);

    void a(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6);

    void a(com.opos.exoplayer.core.a.b bVar);

    void a(c cVar);

    boolean a(int i);

    boolean a(ByteBuffer byteBuffer, long j);

    void b();

    void b(int i);

    void c();

    boolean d();

    boolean e();

    com.opos.exoplayer.core.n f();

    void g();

    void h();

    void i();

    void j();
}
