package defpackage;

import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class pl5 extends Number {
    public static final ThreadLocal<int[]> d = new ThreadLocal<>();
    public static final Random e = new Random();
    public static final int f = Runtime.getRuntime().availableProcessors();
    public static final Unsafe g;
    public static final long h;
    public static final long i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile transient b[] f20048a;
    public volatile transient long b;
    public volatile transient int c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {
        public static final Unsafe b;
        public static final long c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f20049a;

        static {
            try {
                Unsafe unsafeU = pl5.u();
                b = unsafeU;
                c = unsafeU.objectFieldOffset(b.class.getDeclaredField("a"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public b(long j) {
            this.f20049a = j;
        }

        public final boolean a(long j, long j2) {
            return b.compareAndSwapLong(this, c, j, j2);
        }
    }

    static {
        try {
            Unsafe unsafeU = u();
            g = unsafeU;
            h = unsafeU.objectFieldOffset(pl5.class.getDeclaredField(t.l));
            i = unsafeU.objectFieldOffset(pl5.class.getDeclaredField("c"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public static Unsafe u() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    public final boolean q(long j, long j2) {
        return g.compareAndSwapLong(this, h, j, j2);
    }

    public final boolean s() {
        return g.compareAndSwapInt(this, i, 0, 1);
    }

    public abstract long t(long j, long j2);

    /* JADX WARN: Removed duplicated region for block: B:117:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v(long j, int[] iArr, boolean z) {
        int iNextInt;
        int[] iArr2;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            d.set(iArr2);
            iNextInt = e.nextInt();
            if (iNextInt == 0) {
                iNextInt = 1;
            }
            iArr2[0] = iNextInt;
        } else {
            iNextInt = iArr[0];
            iArr2 = iArr;
        }
        int i2 = iNextInt;
        boolean z4 = false;
        boolean z5 = z;
        while (true) {
            b[] bVarArr = this.f20048a;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i2];
                if (bVar == null) {
                    if (this.c == 0) {
                        b bVar2 = new b(j);
                        if (this.c == 0 && s()) {
                            try {
                                b[] bVarArr2 = this.f20048a;
                                if (bVarArr2 == null || (length2 = bVarArr2.length) <= 0) {
                                    z3 = false;
                                    if (!z3) {
                                        return;
                                    }
                                } else {
                                    int i3 = (length2 - 1) & i2;
                                    if (bVarArr2[i3] == null) {
                                        bVarArr2[i3] = bVar2;
                                        z3 = true;
                                    }
                                    if (!z3) {
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    z4 = false;
                } else if (z5) {
                    long j2 = bVar.f20049a;
                    if (bVar.a(j2, t(j2, j))) {
                        return;
                    }
                    if (length >= f || this.f20048a != bVarArr) {
                        z4 = false;
                    } else if (!z4) {
                        z4 = true;
                    } else if (this.c == 0 && s()) {
                        try {
                            if (this.f20048a == bVarArr) {
                                b[] bVarArr3 = new b[length << 1];
                                for (int i4 = 0; i4 < length; i4++) {
                                    bVarArr3[i4] = bVarArr[i4];
                                }
                                this.f20048a = bVarArr3;
                            }
                            this.c = 0;
                            z4 = false;
                        } finally {
                        }
                    }
                } else {
                    z5 = true;
                }
                int i5 = i2 ^ (i2 << 13);
                int i6 = i5 ^ (i5 >>> 17);
                i2 = i6 ^ (i6 << 5);
                iArr2[0] = i2;
            } else if (this.c == 0 && this.f20048a == bVarArr && s()) {
                try {
                    if (this.f20048a == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i2 & 1] = new b(j);
                        this.f20048a = bVarArr4;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                } finally {
                }
            } else {
                long j3 = this.b;
                if (q(j3, t(j3, j))) {
                    return;
                }
            }
        }
    }
}
