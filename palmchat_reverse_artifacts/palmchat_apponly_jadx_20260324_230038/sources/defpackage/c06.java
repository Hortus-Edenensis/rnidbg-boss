package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface c06 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1866a;
        public final byte[] b;
        public final int c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.f1866a = i;
            this.b = bArr;
            this.c = i2;
            this.d = i3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1866a == aVar.f1866a && this.c == aVar.c && this.d == aVar.d && Arrays.equals(this.b, aVar.b);
        }

        public int hashCode() {
            return (((((this.f1866a * 31) + Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
        }
    }

    void a(gc4 gc4Var, int i, int i2);

    void b(m mVar);

    int c(ru0 ru0Var, int i, boolean z) throws IOException;

    void d(gc4 gc4Var, int i);

    void e(long j, int i, int i2, int i3, @Nullable a aVar);

    int f(ru0 ru0Var, int i, boolean z, int i2) throws IOException;
}
