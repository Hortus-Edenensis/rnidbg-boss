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
public final class by1 extends cy1 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f1850a;
        public final int b;
        public final int c;

        public a(float[] fArr, int i, int i2) {
            this.f1850a = fArr;
            this.b = i;
            this.c = i2;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(int i) {
            dm4.m(i, size());
            return Float.valueOf(this.f1850a[this.b + i]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float set(int i, Float f) {
            dm4.m(i, size());
            float[] fArr = this.f1850a;
            int i2 = this.b;
            float f2 = fArr[i2 + i];
            fArr[i2 + i] = ((Float) dm4.o(f)).floatValue();
            return Float.valueOf(f2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Float) && by1.d(this.f1850a, ((Float) obj).floatValue(), this.b, this.c) != -1;
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
                if (this.f1850a[this.b + i] != aVar.f1850a[aVar.b + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iC = 1;
            for (int i = this.b; i < this.c; i++) {
                iC = (iC * 31) + by1.c(this.f1850a[i]);
            }
            return iC;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iD;
            if (!(obj instanceof Float) || (iD = by1.d(this.f1850a, ((Float) obj).floatValue(), this.b, this.c)) < 0) {
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
            if (!(obj instanceof Float) || (iE = by1.e(this.f1850a, ((Float) obj).floatValue(), this.b, this.c)) < 0) {
                return -1;
            }
            return iE - this.b;
        }

        public float[] o() {
            return Arrays.copyOfRange(this.f1850a, this.b, this.c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.c - this.b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int i, int i2) {
            dm4.s(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            float[] fArr = this.f1850a;
            int i3 = this.b;
            return new a(fArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append('[');
            sb.append(this.f1850a[this.b]);
            int i = this.b;
            while (true) {
                i++;
                if (i >= this.c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f1850a[i]);
            }
        }
    }

    public static int c(float f) {
        return Float.valueOf(f).hashCode();
    }

    public static int d(float[] fArr, float f, int i, int i2) {
        while (i < i2) {
            if (fArr[i] == f) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int e(float[] fArr, float f, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (fArr[i3] == f) {
                return i3;
            }
        }
        return -1;
    }

    public static float[] f(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).o();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = ((Number) dm4.o(array[i])).floatValue();
        }
        return fArr;
    }
}
