package com.opos.exoplayer.core.extractor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface l {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f8183a;
        public final m b;

        public a(m mVar) {
            this(mVar, mVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8183a.equals(aVar.f8183a) && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return (this.f8183a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f8183a);
            if (this.f8183a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public a(m mVar, m mVar2) {
            this.f8183a = (m) com.opos.exoplayer.core.util.a.a(mVar);
            this.b = (m) com.opos.exoplayer.core.util.a.a(mVar2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f8184a;
        private final a b;

        public b(long j) {
            this(j, 0L);
        }

        @Override // com.opos.exoplayer.core.extractor.l
        public boolean a() {
            return false;
        }

        @Override // com.opos.exoplayer.core.extractor.l
        public long b() {
            return this.f8184a;
        }

        public b(long j, long j2) {
            this.f8184a = j;
            this.b = new a(j2 == 0 ? m.f8185a : new m(0L, j2));
        }

        @Override // com.opos.exoplayer.core.extractor.l
        public a b(long j) {
            return this.b;
        }
    }

    boolean a();

    long b();

    a b(long j);
}
