package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class vv {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f21535a;
        public final int b;
        public final int c;

        public a(byte[] bArr, int i, int i2) {
            this.f21535a = bArr;
            this.b = i;
            this.c = i2;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte get(int i) {
            dm4.m(i, size());
            return Byte.valueOf(this.f21535a[this.b + i]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte set(int i, Byte b) {
            dm4.m(i, size());
            byte[] bArr = this.f21535a;
            int i2 = this.b;
            byte b2 = bArr[i2 + i];
            bArr[i2 + i] = ((Byte) dm4.o(b)).byteValue();
            return Byte.valueOf(b2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Byte) && vv.d(this.f21535a, ((Byte) obj).byteValue(), this.b, this.c) != -1;
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
                if (this.f21535a[this.b + i] != aVar.f21535a[aVar.b + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iC = 1;
            for (int i = this.b; i < this.c; i++) {
                iC = (iC * 31) + vv.c(this.f21535a[i]);
            }
            return iC;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iD;
            if (!(obj instanceof Byte) || (iD = vv.d(this.f21535a, ((Byte) obj).byteValue(), this.b, this.c)) < 0) {
                return -1;
            }
            return iD - this.b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iE;
            if (!(obj instanceof Byte) || (iE = vv.e(this.f21535a, ((Byte) obj).byteValue(), this.b, this.c)) < 0) {
                return -1;
            }
            return iE - this.b;
        }

        public byte[] o() {
            return Arrays.copyOfRange(this.f21535a, this.b, this.c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.c - this.b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int i, int i2) {
            dm4.s(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            byte[] bArr = this.f21535a;
            int i3 = this.b;
            return new a(bArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append((int) this.f21535a[this.b]);
            int i = this.b;
            while (true) {
                i++;
                if (i >= this.c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.f21535a[i]);
            }
        }
    }

    public static int d(byte[] bArr, byte b, int i, int i2) {
        while (i < i2) {
            if (bArr[i] == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int e(byte[] bArr, byte b, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (bArr[i3] == b) {
                return i3;
            }
        }
        return -1;
    }

    public static byte[] f(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).o();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = ((Number) dm4.o(array[i])).byteValue();
        }
        return bArr;
    }

    public static int c(byte b) {
        return b;
    }
}
