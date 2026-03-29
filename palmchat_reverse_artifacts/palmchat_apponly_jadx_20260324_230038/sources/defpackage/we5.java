package defpackage;

import defpackage.we5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class we5 {
    public static final Comparator<b> h = new Comparator() { // from class: ue5
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return we5.g((we5.b) obj, (we5.b) obj2);
        }
    };
    public static final Comparator<b> i = new Comparator() { // from class: ve5
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return we5.h((we5.b) obj, (we5.b) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21687a;
    public int e;
    public int f;
    public int g;
    public final b[] c = new b[5];
    public final ArrayList<b> b = new ArrayList<>();
    public int d = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21688a;
        public int b;
        public float c;

        public b() {
        }
    }

    public we5(int i2) {
        this.f21687a = i2;
    }

    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f21688a - bVar2.f21688a;
    }

    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.c, bVar2.c);
    }

    public void c(int i2, float f) {
        b bVar;
        d();
        int i3 = this.g;
        if (i3 > 0) {
            b[] bVarArr = this.c;
            int i4 = i3 - 1;
            this.g = i4;
            bVar = bVarArr[i4];
        } else {
            bVar = new b();
        }
        int i5 = this.e;
        this.e = i5 + 1;
        bVar.f21688a = i5;
        bVar.b = i2;
        bVar.c = f;
        this.b.add(bVar);
        this.f += i2;
        while (true) {
            int i6 = this.f;
            int i7 = this.f21687a;
            if (i6 <= i7) {
                return;
            }
            int i8 = i6 - i7;
            b bVar2 = this.b.get(0);
            int i9 = bVar2.b;
            if (i9 <= i8) {
                this.f -= i9;
                this.b.remove(0);
                int i10 = this.g;
                if (i10 < 5) {
                    b[] bVarArr2 = this.c;
                    this.g = i10 + 1;
                    bVarArr2[i10] = bVar2;
                }
            } else {
                bVar2.b = i9 - i8;
                this.f -= i8;
            }
        }
    }

    public final void d() {
        if (this.d != 1) {
            Collections.sort(this.b, h);
            this.d = 1;
        }
    }

    public final void e() {
        if (this.d != 0) {
            Collections.sort(this.b, i);
            this.d = 0;
        }
    }

    public float f(float f) {
        e();
        float f2 = f * this.f;
        int i2 = 0;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            b bVar = this.b.get(i3);
            i2 += bVar.b;
            if (i2 >= f2) {
                return bVar.c;
            }
        }
        if (this.b.isEmpty()) {
            return Float.NaN;
        }
        return this.b.get(r5.size() - 1).c;
    }

    public void i() {
        this.b.clear();
        this.d = -1;
        this.e = 0;
        this.f = 0;
    }
}
