package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface v45 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x45 f21356a;
        public final x45 b;

        public a(x45 x45Var) {
            this(x45Var, x45Var);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f21356a.equals(aVar.f21356a) && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return (this.f21356a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f21356a);
            if (this.f21356a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public a(x45 x45Var, x45 x45Var2) {
            this.f21356a = (x45) vh.e(x45Var);
            this.b = (x45) vh.e(x45Var2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements v45 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f21357a;
        public final a b;

        public b(long j) {
            this(j, 0L);
        }

        @Override // defpackage.v45
        public long getDurationUs() {
            return this.f21357a;
        }

        @Override // defpackage.v45
        public a getSeekPoints(long j) {
            return this.b;
        }

        @Override // defpackage.v45
        public boolean isSeekable() {
            return false;
        }

        public b(long j, long j2) {
            this.f21357a = j;
            this.b = new a(j2 == 0 ? x45.c : new x45(0L, j2));
        }
    }

    long getDurationUs();

    a getSeekPoints(long j);

    boolean isSeekable();
}
