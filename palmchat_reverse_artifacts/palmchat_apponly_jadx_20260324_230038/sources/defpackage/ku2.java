package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ku2 extends lu2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f18831a;
        public final int b;
        public final int c;

        public a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(int i) {
            dm4.m(i, size());
            return Integer.valueOf(this.f18831a[this.b + i]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer set(int i, Integer num) {
            dm4.m(i, size());
            int[] iArr = this.f18831a;
            int i2 = this.b;
            int i3 = iArr[i2 + i];
            iArr[i2 + i] = ((Integer) dm4.o(num)).intValue();
            return Integer.valueOf(i3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && ku2.m(this.f18831a, ((Integer) obj).intValue(), this.b, this.c) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.f18831a[this.b + i] != aVar.f18831a[aVar.b + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iK = 1;
            for (int i = this.b; i < this.c; i++) {
                iK = (iK * 31) + ku2.k(this.f18831a[i]);
            }
            return iK;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iM;
            if (!(obj instanceof Integer) || (iM = ku2.m(this.f18831a, ((Integer) obj).intValue(), this.b, this.c)) < 0) {
                return -1;
            }
            return iM - this.b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iN;
            if (!(obj instanceof Integer) || (iN = ku2.n(this.f18831a, ((Integer) obj).intValue(), this.b, this.c)) < 0) {
                return -1;
            }
            return iN - this.b;
        }

        public int[] o() {
            return Arrays.copyOfRange(this.f18831a, this.b, this.c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.c - this.b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i, int i2) {
            dm4.s(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            int[] iArr = this.f18831a;
            int i3 = this.b;
            return new a(iArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.f18831a[this.b]);
            int i = this.b;
            while (true) {
                i++;
                if (i >= this.c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f18831a[i]);
            }
        }

        public a(int[] iArr, int i, int i2) {
            this.f18831a = iArr;
            this.b = i;
            this.c = i2;
        }
    }

    public static List<Integer> c(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new a(iArr);
    }

    public static int d(long j) {
        int i = (int) j;
        dm4.h(j == ((long) i), "the total number of elements (%s) in the arrays must fit in an int", j);
        return i;
    }

    public static int e(long j) {
        int i = (int) j;
        dm4.h(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static int f(int i, int i2) {
        return Integer.compare(i, i2);
    }

    public static int[] g(int[]... iArr) {
        long length = 0;
        for (int[] iArr2 : iArr) {
            length += (long) iArr2.length;
        }
        int[] iArr3 = new int[d(length)];
        int length2 = 0;
        for (int[] iArr4 : iArr) {
            System.arraycopy(iArr4, 0, iArr3, length2, iArr4.length);
            length2 += iArr4.length;
        }
        return iArr3;
    }

    public static int h(int i, int i2, int i3) {
        dm4.g(i2 <= i3, "min (%s) must be less than or equal to max (%s)", i2, i3);
        return Math.min(Math.max(i, i2), i3);
    }

    public static int i(byte[] bArr) {
        dm4.g(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return j(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int j(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & UByte.MAX_VALUE) << 16) | ((b3 & UByte.MAX_VALUE) << 8) | (b4 & UByte.MAX_VALUE);
    }

    public static int l(int[] iArr, int i) {
        return m(iArr, i, 0, iArr.length);
    }

    public static int m(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int n(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int o(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int[] p(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).o();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) dm4.o(array[i])).intValue();
        }
        return iArr;
    }

    public static byte[] q(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }

    public static Integer r(String str) {
        return s(str, 10);
    }

    public static Integer s(String str, int i) {
        Long lN = n73.n(str, i);
        if (lN == null || lN.longValue() != lN.intValue()) {
            return null;
        }
        return Integer.valueOf(lN.intValue());
    }

    public static int k(int i) {
        return i;
    }
}
