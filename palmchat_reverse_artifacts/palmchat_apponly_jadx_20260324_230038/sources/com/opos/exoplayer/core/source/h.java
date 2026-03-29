package com.opos.exoplayer.core.source;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.w;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface h {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(h hVar, w wVar, @Nullable Object obj);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8292a;
        public final int b;
        public final int c;
        public final long d;

        public b(int i) {
            this(i, -1L);
        }

        public b a(int i) {
            return this.f8292a == i ? this : new b(i, this.b, this.c, this.d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f8292a == bVar.f8292a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d;
        }

        public int hashCode() {
            return ((((((this.f8292a + 527) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d);
        }

        public b(int i, int i2, int i3, long j) {
            this.f8292a = i;
            this.b = i2;
            this.c = i3;
            this.d = j;
        }

        public boolean a() {
            return this.b != -1;
        }

        public b(int i, long j) {
            this(i, -1, -1, j);
        }
    }

    g a(b bVar, com.opos.exoplayer.core.upstream.b bVar2);

    void a();

    void a(com.opos.exoplayer.core.g gVar, boolean z, a aVar);

    void a(g gVar);

    void b();
}
