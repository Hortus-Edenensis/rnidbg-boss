package com.opos.exoplayer.core.c;

import android.graphics.Point;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.r;
import com.opos.exoplayer.core.source.o;
import com.opos.exoplayer.core.source.p;
import com.opos.exoplayer.core.util.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8120a = new int[0];
    private final f.a b;
    private final AtomicReference<a> c;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8121a = new a();
        public final String b;
        public final String c;
        public final boolean d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final int j;
        public final int k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;

        private a() {
            this(null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.d == aVar.d && this.e == aVar.e && this.m == aVar.m && this.n == aVar.n && this.o == aVar.o && this.f == aVar.f && this.g == aVar.g && this.i == aVar.i && this.p == aVar.p && this.l == aVar.l && this.j == aVar.j && this.k == aVar.k && this.h == aVar.h && TextUtils.equals(this.b, aVar.b) && TextUtils.equals(this.c, aVar.c);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((this.d ? 1 : 0) * 31) + this.e) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + (this.o ? 1 : 0)) * 31) + this.f) * 31) + this.g) * 31) + (this.i ? 1 : 0)) * 31) + (this.p ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + this.j) * 31) + this.k) * 31) + this.h) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        private a(String str, String str2, boolean z, int i, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4, boolean z5, boolean z6, int i5, int i6, boolean z7) {
            this.b = y.b(str);
            this.c = y.b(str2);
            this.d = z;
            this.e = i;
            this.m = z2;
            this.n = z3;
            this.o = z4;
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.i = z5;
            this.p = z6;
            this.j = i5;
            this.k = i6;
            this.l = z7;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8122a;
        public final int b;
        public final String c;

        public b(int i, int i2, String str) {
            this.f8122a = i;
            this.b = i2;
            this.c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f8122a == bVar.f8122a && this.b == bVar.b && TextUtils.equals(this.c, bVar.c);
        }

        public int hashCode() {
            int i = ((this.f8122a * 31) + this.b) * 31;
            String str = this.c;
            return i + (str != null ? str.hashCode() : 0);
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0684c implements Comparable<C0684c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f8123a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;

        public C0684c(Format format, a aVar, int i) {
            this.f8123a = aVar;
            this.b = c.a(i, false) ? 1 : 0;
            this.c = c.a(format, aVar.b) ? 1 : 0;
            this.d = (format.x & 1) != 0 ? 1 : 0;
            this.e = format.r;
            this.f = format.s;
            this.g = format.b;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull C0684c c0684c) {
            int i = this.b;
            int i2 = c0684c.b;
            if (i != i2) {
                return c.c(i, i2);
            }
            int i3 = this.c;
            int i4 = c0684c.c;
            if (i3 != i4) {
                return c.c(i3, i4);
            }
            int i5 = this.d;
            int i6 = c0684c.d;
            if (i5 != i6) {
                return c.c(i5, i6);
            }
            if (this.f8123a.m) {
                return c.c(c0684c.g, this.g);
            }
            int i7 = i != 1 ? -1 : 1;
            int i8 = this.e;
            int i9 = c0684c.e;
            return i7 * ((i8 == i9 && (i8 = this.f) == (i9 = c0684c.f)) ? c.c(this.g, c0684c.g) : c.c(i8, i9));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0684c.class != obj.getClass()) {
                return false;
            }
            C0684c c0684c = (C0684c) obj;
            return this.b == c0684c.b && this.c == c0684c.c && this.d == c0684c.d && this.e == c0684c.e && this.f == c0684c.f && this.g == c0684c.g;
        }

        public int hashCode() {
            return (((((((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        }
    }

    public c() {
        this(null);
    }

    private static int b(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public c(f.a aVar) {
        this.b = aVar;
        this.c = new AtomicReference<>(a.f8121a);
    }

    private static int a(o oVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int iIntValue = list.get(i6).intValue();
            if (a(oVar.a(iIntValue), str, iArr[iIntValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    private static f b(r rVar, p pVar, int[][] iArr, a aVar, f.a aVar2) {
        int i = aVar.o ? 24 : 16;
        boolean z = aVar.n && (rVar.m() & i) != 0;
        for (int i2 = 0; i2 < pVar.b; i2++) {
            o oVarA = pVar.a(i2);
            int[] iArrA = a(oVarA, iArr[i2], z, i, aVar.f, aVar.g, aVar.h, aVar.j, aVar.k, aVar.l);
            if (iArrA.length > 0) {
                return aVar2.b(oVarA, iArrA);
            }
        }
        return null;
    }

    private static int a(o oVar, int[] iArr, b bVar) {
        int i = 0;
        for (int i2 = 0; i2 < oVar.f8303a; i2++) {
            if (a(oVar.a(i2), iArr[i2], bVar)) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static f b(p pVar, int[][] iArr, a aVar) {
        int i;
        int i2;
        int i3;
        p pVar2 = pVar;
        int i4 = -1;
        int i5 = 0;
        o oVar = null;
        int i6 = 0;
        int i7 = 0;
        int iA = -1;
        int i8 = -1;
        while (i5 < pVar2.b) {
            o oVarA = pVar2.a(i5);
            List<Integer> listA = a(oVarA, aVar.j, aVar.k, aVar.l);
            int[] iArr2 = iArr[i5];
            int i9 = 0;
            while (i9 < oVarA.f8303a) {
                if (a(iArr2[i9], aVar.p)) {
                    Format formatA = oVarA.a(i9);
                    boolean z = true;
                    boolean z2 = listA.contains(Integer.valueOf(i9)) && ((i = formatA.j) == i4 || i <= aVar.f) && (((i2 = formatA.k) == i4 || i2 <= aVar.g) && ((i3 = formatA.b) == i4 || i3 <= aVar.h));
                    if (z2 || aVar.i) {
                        int i10 = z2 ? 2 : 1;
                        boolean zA = a(iArr2[i9], false);
                        if (zA) {
                            i10 += 1000;
                        }
                        boolean z3 = i10 > i7;
                        if (i10 != i7) {
                            z = z3;
                        } else if (!aVar.m) {
                            int iA2 = formatA.a();
                            int iB = iA2 != iA ? b(iA2, iA) : b(formatA.b, i8);
                            if (!zA || !z2 ? iB >= 0 : iB <= 0) {
                            }
                        } else if (b(formatA.b, i8) >= 0) {
                            z = false;
                        }
                        if (z) {
                            i8 = formatA.b;
                            iA = formatA.a();
                            oVar = oVarA;
                            i6 = i9;
                            i7 = i10;
                        }
                    }
                }
                i9++;
                i4 = -1;
            }
            i5++;
            pVar2 = pVar;
            i4 = -1;
        }
        if (oVar == null) {
            return null;
        }
        return new d(oVar, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Point a(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if ((i3 > i4) == (i > i2)) {
                i2 = i;
                i = i2;
            }
        }
        int i5 = i3 * i;
        int i6 = i4 * i2;
        return i5 >= i6 ? new Point(i2, y.a(i6, i3)) : new Point(y.a(i5, i4), i);
    }

    private static void b(o oVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!a(oVar.a(iIntValue), str, iArr[iIntValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    public f a(int i, p pVar, int[][] iArr, a aVar) {
        o oVar = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < pVar.b; i4++) {
            o oVarA = pVar.a(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < oVarA.f8303a; i5++) {
                if (a(iArr2[i5], aVar.p)) {
                    int i6 = (oVarA.a(i5).x & 1) != 0 ? 2 : 1;
                    if (a(iArr2[i5], false)) {
                        i6 += 1000;
                    }
                    if (i6 > i3) {
                        oVar = oVarA;
                        i2 = i5;
                        i3 = i6;
                    }
                }
            }
        }
        if (oVar == null) {
            return null;
        }
        return new d(oVar, i2);
    }

    public f a(r rVar, p pVar, int[][] iArr, a aVar, f.a aVar2) {
        f fVarB = (aVar.m || aVar2 == null) ? null : b(rVar, pVar, iArr, aVar, aVar2);
        return fVarB == null ? b(pVar, iArr, aVar) : fVarB;
    }

    public f a(p pVar, int[][] iArr, a aVar) {
        o oVar = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < pVar.b; i3++) {
            o oVarA = pVar.a(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < oVarA.f8303a; i4++) {
                if (a(iArr2[i4], aVar.p)) {
                    Format formatA = oVarA.a(i4);
                    int i5 = formatA.x & (~aVar.e);
                    int i6 = 1;
                    boolean z = (i5 & 1) != 0;
                    boolean z2 = (i5 & 2) != 0;
                    boolean zA = a(formatA, aVar.c);
                    if (zA || (aVar.d && a(formatA))) {
                        i6 = (z ? 8 : !z2 ? 6 : 4) + (zA ? 1 : 0);
                    } else if (z) {
                        i6 = 3;
                    } else if (z2) {
                        if (a(formatA, aVar.b)) {
                            i6 = 2;
                        }
                    }
                    if (a(iArr2[i4], false)) {
                        i6 += 1000;
                    }
                    if (i6 > i2) {
                        oVar = oVarA;
                        i = i4;
                        i2 = i6;
                    }
                }
            }
        }
        if (oVar == null) {
            return null;
        }
        return new d(oVar, i);
    }

    public f a(p pVar, int[][] iArr, a aVar, f.a aVar2) {
        C0684c c0684c = null;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < pVar.b; i3++) {
            o oVarA = pVar.a(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < oVarA.f8303a; i4++) {
                if (a(iArr2[i4], aVar.p)) {
                    C0684c c0684c2 = new C0684c(oVarA.a(i4), aVar, iArr2[i4]);
                    if (c0684c == null || c0684c2.compareTo(c0684c) > 0) {
                        i = i3;
                        i2 = i4;
                        c0684c = c0684c2;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        o oVarA2 = pVar.a(i);
        if (!aVar.m && aVar2 != null) {
            int[] iArrA = a(oVarA2, iArr[i], aVar.n);
            if (iArrA.length > 0) {
                return aVar2.b(oVarA2, iArrA);
            }
        }
        return new d(oVarA2, i2);
    }

    private static List<Integer> a(o oVar, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(oVar.f8303a);
        for (int i4 = 0; i4 < oVar.f8303a; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i5 = Integer.MAX_VALUE;
            for (int i6 = 0; i6 < oVar.f8303a; i6++) {
                Format formatA = oVar.a(i6);
                int i7 = formatA.j;
                if (i7 > 0 && (i3 = formatA.k) > 0) {
                    Point pointA = a(z, i, i2, i7, i3);
                    int i8 = formatA.j;
                    int i9 = formatA.k;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (pointA.x * 0.98f)) && i9 >= ((int) (pointA.y * 0.98f)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
            if (i5 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int iA = oVar.a(((Integer) arrayList.get(size)).intValue()).a();
                    if (iA == -1 || iA > i5) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean a(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    public static boolean a(Format format) {
        return TextUtils.isEmpty(format.y) || a(format, "und");
    }

    private static boolean a(Format format, int i, b bVar) {
        if (!a(i, false) || format.r != bVar.f8122a || format.s != bVar.b) {
            return false;
        }
        String str = bVar.c;
        return str == null || TextUtils.equals(str, format.f);
    }

    public static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, y.b(format.y));
    }

    private static boolean a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!a(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !y.a(format.f, str)) {
            return false;
        }
        int i6 = format.j;
        if (i6 != -1 && i6 > i3) {
            return false;
        }
        int i7 = format.k;
        if (i7 != -1 && i7 > i4) {
            return false;
        }
        int i8 = format.b;
        return i8 == -1 || i8 <= i5;
    }

    private static int[] a(o oVar, int[] iArr, boolean z) {
        int iA;
        HashSet hashSet = new HashSet();
        b bVar = null;
        int i = 0;
        for (int i2 = 0; i2 < oVar.f8303a; i2++) {
            Format formatA = oVar.a(i2);
            b bVar2 = new b(formatA.r, formatA.s, z ? null : formatA.f);
            if (hashSet.add(bVar2) && (iA = a(oVar, iArr, bVar2)) > i) {
                i = iA;
                bVar = bVar2;
            }
        }
        if (i <= 1) {
            return f8120a;
        }
        int[] iArr2 = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < oVar.f8303a; i4++) {
            if (a(oVar.a(i4), iArr[i4], bVar)) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return iArr2;
    }

    private static int[] a(o oVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        String str;
        int iA;
        if (oVar.f8303a < 2) {
            return f8120a;
        }
        List<Integer> listA = a(oVar, i5, i6, z2);
        if (listA.size() < 2) {
            return f8120a;
        }
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i7 = 0;
            for (int i8 = 0; i8 < listA.size(); i8++) {
                String str3 = oVar.a(listA.get(i8).intValue()).f;
                if (hashSet.add(str3) && (iA = a(oVar, iArr, i, str3, i2, i3, i4, listA)) > i7) {
                    i7 = iA;
                    str2 = str3;
                }
            }
            str = str2;
        }
        b(oVar, iArr, i, str, i2, i3, i4, listA);
        return listA.size() < 2 ? f8120a : y.a(listA);
    }

    @Override // com.opos.exoplayer.core.c.e
    public f[] a(r[] rVarArr, p[] pVarArr, int[][][] iArr) {
        int length = rVarArr.length;
        f[] fVarArr = new f[length];
        a aVar = this.c.get();
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (true) {
            if (i >= length) {
                break;
            }
            if (2 == rVarArr[i].a()) {
                if (!z) {
                    f fVarA = a(rVarArr[i], pVarArr[i], iArr[i], aVar, this.b);
                    fVarArr[i] = fVarA;
                    z = fVarA != null;
                }
                z2 |= pVarArr[i].b > 0;
            }
            i++;
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i2 = 0; i2 < length; i2++) {
            int iA = rVarArr[i2].a();
            if (iA != 1) {
                if (iA != 2) {
                    if (iA != 3) {
                        fVarArr[i2] = a(rVarArr[i2].a(), pVarArr[i2], iArr[i2], aVar);
                    } else if (!z4) {
                        f fVarA2 = a(pVarArr[i2], iArr[i2], aVar);
                        fVarArr[i2] = fVarA2;
                        z4 = fVarA2 != null;
                    }
                }
            } else if (!z3) {
                f fVarA3 = a(pVarArr[i2], iArr[i2], aVar, z2 ? null : this.b);
                fVarArr[i2] = fVarA3;
                z3 = fVarA3 != null;
            }
        }
        return fVarArr;
    }
}
