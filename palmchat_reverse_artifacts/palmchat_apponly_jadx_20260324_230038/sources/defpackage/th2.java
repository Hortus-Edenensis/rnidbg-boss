package defpackage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class th2 {
    public static final String[] b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    public static final int[][] c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    public static final int[][] d;
    public static final int[][] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f20985a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<lk5> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(lk5 lk5Var, lk5 lk5Var2) {
            return lk5Var.d() - lk5Var2.d();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        d = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            d[0][i] = (i - 65) + 2;
        }
        d[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            d[1][i2] = (i2 - 97) + 2;
        }
        d[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            d[2][i3] = (i3 - 48) + 2;
        }
        int[] iArr2 = d[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i4 = 0; i4 < 28; i4++) {
            d[3][iArr3[i4]] = i4;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i5 = 0; i5 < 31; i5++) {
            int i6 = iArr4[i5];
            if (i6 > 0) {
                d[4][i6] = i5;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = e;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public th2(byte[] bArr) {
        this.f20985a = bArr;
    }

    public static Collection<lk5> b(Iterable<lk5> iterable) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        for (lk5 lk5Var : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                lk5 lk5Var2 = (lk5) it.next();
                if (lk5Var2.f(lk5Var)) {
                    z = false;
                    break;
                }
                if (lk5Var.f(lk5Var2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(lk5Var);
            }
        }
        return linkedList;
    }

    public static void d(lk5 lk5Var, int i, int i2, Collection<lk5> collection) {
        lk5 lk5VarB = lk5Var.b(i);
        collection.add(lk5VarB.g(4, i2));
        if (lk5Var.e() != 4) {
            collection.add(lk5VarB.h(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(lk5VarB.g(2, 16 - i2).g(2, 1));
        }
        if (lk5Var.c() > 0) {
            collection.add(lk5Var.a(i).a(i + 1));
        }
    }

    public static Collection<lk5> f(Iterable<lk5> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<lk5> it = iterable.iterator();
        while (it.hasNext()) {
            d(it.next(), i, i2, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public et a() {
        int i;
        Collection<lk5> collectionSingletonList = Collections.singletonList(lk5.e);
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f20985a;
            if (i2 >= bArr.length) {
                return ((lk5) Collections.min(collectionSingletonList, new a())).i(this.f20985a);
            }
            int i3 = i2 + 1;
            byte b2 = i3 < bArr.length ? bArr[i3] : (byte) 0;
            byte b3 = bArr[i2];
            if (b3 != 13) {
                if (b3 != 44) {
                    if (b3 != 46) {
                        i = (b3 == 58 && b2 == 32) ? 5 : 0;
                    } else if (b2 == 32) {
                        i = 3;
                    }
                } else if (b2 == 32) {
                    i = 4;
                }
            } else if (b2 == 10) {
                i = 2;
            }
            if (i > 0) {
                collectionSingletonList = f(collectionSingletonList, i2, i);
                i2 = i3;
            } else {
                collectionSingletonList = e(collectionSingletonList, i2);
            }
            i2++;
        }
    }

    public final void c(lk5 lk5Var, int i, Collection<lk5> collection) {
        char c2 = (char) (this.f20985a[i] & UByte.MAX_VALUE);
        boolean z = d[lk5Var.e()][c2] > 0;
        lk5 lk5VarB = null;
        for (int i2 = 0; i2 <= 4; i2++) {
            int i3 = d[i2][c2];
            if (i3 > 0) {
                if (lk5VarB == null) {
                    lk5VarB = lk5Var.b(i);
                }
                if (!z || i2 == lk5Var.e() || i2 == 2) {
                    collection.add(lk5VarB.g(i2, i3));
                }
                if (!z && e[lk5Var.e()][i2] >= 0) {
                    collection.add(lk5VarB.h(i2, i3));
                }
            }
        }
        if (lk5Var.c() > 0 || d[lk5Var.e()][c2] == 0) {
            collection.add(lk5Var.a(i));
        }
    }

    public final Collection<lk5> e(Iterable<lk5> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator<lk5> it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next(), i, linkedList);
        }
        return b(linkedList);
    }
}
