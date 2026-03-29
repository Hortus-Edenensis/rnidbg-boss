package defpackage;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class vi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21448a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends vi {
        public final long b;
        public final List<b> c;
        public final List<a> d;

        public a(int i, long j) {
            super(i);
            this.b = j;
            this.c = new ArrayList();
            this.d = new ArrayList();
        }

        public void d(a aVar) {
            this.d.add(aVar);
        }

        public void e(b bVar) {
            this.c.add(bVar);
        }

        @Nullable
        public a f(int i) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.d.get(i2);
                if (aVar.f21448a == i) {
                    return aVar;
                }
            }
            return null;
        }

        @Nullable
        public b g(int i) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.c.get(i2);
                if (bVar.f21448a == i) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // defpackage.vi
        public String toString() {
            return vi.a(this.f21448a) + " leaves: " + Arrays.toString(this.c.toArray()) + " containers: " + Arrays.toString(this.d.toArray());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends vi {
        public final gc4 b;

        public b(int i, gc4 gc4Var) {
            super(i);
            this.b = gc4Var;
        }
    }

    public vi(int i) {
        this.f21448a = i;
    }

    public static String a(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public static int b(int i) {
        return i & 16777215;
    }

    public static int c(int i) {
        return (i >> 24) & 255;
    }

    public String toString() {
        return a(this.f21448a);
    }
}
