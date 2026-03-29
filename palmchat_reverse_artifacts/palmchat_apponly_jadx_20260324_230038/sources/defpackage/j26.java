package defpackage;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface j26 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18313a;
        public final int b;
        public final byte[] c;

        public a(String str, int i, byte[] bArr) {
            this.f18313a = str;
            this.b = i;
            this.c = bArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18314a;

        @Nullable
        public final String b;
        public final List<a> c;
        public final byte[] d;

        public b(int i, @Nullable String str, @Nullable List<a> list, byte[] bArr) {
            this.f18314a = i;
            this.b = str;
            this.c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.d = bArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        @Nullable
        j26 a(int i, b bVar);

        SparseArray<j26> createInitialPayloadReaders();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18315a;
        public final int b;
        public final int c;
        public int d;
        public String e;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.b : i + this.c;
            this.e = this.f18315a + this.d;
        }

        public String b() {
            d();
            return this.e;
        }

        public int c() {
            d();
            return this.d;
        }

        public final void d() {
            if (this.d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public d(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + "/";
            } else {
                str = "";
            }
            this.f18315a = str;
            this.b = i2;
            this.c = i3;
            this.d = Integer.MIN_VALUE;
            this.e = "";
        }
    }

    void a(gc4 gc4Var, int i) throws ParserException;

    void b(jy5 jy5Var, qs1 qs1Var, d dVar);

    void seek();
}
